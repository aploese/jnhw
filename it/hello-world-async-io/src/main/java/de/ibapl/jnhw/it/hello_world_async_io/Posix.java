/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2021-2024, Arne Plöse and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package de.ibapl.jnhw.it.hello_world_async_io;

import de.ibapl.jnhw.common.exception.InvalidCacheException;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeException;
import de.ibapl.jnhw.common.memory.MemoryHeap;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.util.OutputStreamAppender;
import de.ibapl.jnhw.posix.Aio;
import de.ibapl.jnhw.posix.Errno;
import de.ibapl.jnhw.posix.Fcntl;
import de.ibapl.jnhw.posix.Pthread;
import de.ibapl.jnhw.posix.Signal;
import de.ibapl.jnhw.posix.StringHeader;
import de.ibapl.jnhw.posix.Unistd;
import de.ibapl.jnhw.util.posix.upcall.Callback__V__UnionSigval;
import java.io.File;
import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

public class Posix {

    final boolean isDebug;
    long transmitted;
    final Arena arena = Arena.ofShared();
    final Aio.Aiocb<Aio.Aiocb> aiocb;

    final Object[] objRef = new Object[1];

    //This is the callback to be called from the native side.
    final Callback__V__UnionSigval<Aio.Aiocb> callback = new Callback__V__UnionSigval<>() {

        @Override
        @SuppressWarnings("unchecked")
        protected void callback(MemorySegment sival_ptr, int sival_int) {
            debugThread("Enter callback");
            try {
                int errno = Aio.aio_error(aiocb);
                if (errno == 0) {
                    transmitted = Aio.aio_return(aiocb);
                    debugThread("Read/Wrote " + transmitted + " bytes!");
                } else {
                    debugThread("Got errno from aio_read or aio_write: " + Errno.getErrnoSymbol(errno) + ", " + StringHeader.strerror(errno));
                }
            } catch (NativeErrorException nee) {
                try {
                    debug("Got errno within callback: " + Errno.getErrnoSymbol(nee.errno) + ", " + StringHeader.strerror(nee.errno));
                } catch (NativeErrorException nee1) {
                    debug("Got errno within callback: " + Errno.getErrnoSymbol(nee.errno));
                }
            } catch (NoSuchNativeMethodException nsnme) {
                debug("NoSuchNativeMethodException within callback: " + nsnme);
            }
            synchronized (objRef) {
                objRef[0] = aiocb;
                objRef.notify();
            }
            debugThread("Leave callback");
        }

    };

    public Posix(boolean isDebug) {
        this.isDebug = isDebug;
        try {
            aiocb = Aio.Aiocb.tryAllocateNative(arena);
        } catch (NoSuchNativeTypeException nsnte) {
            throw new RuntimeException(nsnte);
        }
    }

    public void aio(File file, MemorySegment aioBuffer) throws NativeErrorException, NoSuchNativeMethodException, NoSuchNativeTypeException, IOException, InterruptedException {
        debugThread("Write/Read in thread: ");

        aiocb.aio_fildes(Fcntl.open(file.getAbsolutePath(), Fcntl.O_RDWR));
        aiocb.aio_buf(aioBuffer);
        if (!Signal.SIGEV_THREAD.isDefined()) {
            throw new RuntimeException("Not defined Signal.SIGEV_THREAD!");
        }
        aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_THREAD.get());
        aiocb.aio_sigevent.sigev_notify_function(callback);

        debugAiocb(MemoryHeap.wrap(aioBuffer));

        debug("Will now write");

        Aio.aio_write(aiocb);

        debug("...written");

        //force data write
        //Aio.aio_fsync(Fcntl.O_DSYNC(), aiocb); // enabling this 9 bytes will be reported in callback. and the call back is called twice,
        //Wait debug is slow, so we are here before the callback finishes...
        synchronized (objRef) {
            if (objRef[0] == null) {
                debug("Wait for write callback to finish!");
                objRef.wait(1000);
            }
        }

        if (objRef[0] != aiocb) {
            throw new RuntimeException("Excpected handler was called!");
        } else {
            debug("Data written");
        }

        objRef[0] = null;
        aioBuffer.fill((byte) 0);

        debug("Will now read");

        Aio.aio_read(aiocb);

        debug("...read");

        //force data read
        //Aio.aio_fsync(Fcntl.O_DSYNC(), aiocb);
        //Wait debug is slow, so we are here before the callback finishes...
        synchronized (objRef) {
            if (objRef[0] == null) {
                debug("Wait for read callback to finish!");
                objRef.wait(100);
            }
        }

        if (objRef[0] != aiocb) {
            throw new RuntimeException("Excpected handler was called! " + objRef[0]);
        } else {
            debug("Data read");
        }

        //Close the handle
        Unistd.close(aiocb.aio_fildes());

        printBuffer(MemoryHeap.wrap(aioBuffer));
    }

    private void debug(String msg) {
        if (isDebug) {
            System.out.println(msg);
            System.out.flush();
        }
    }

    private void debugThread(String msg) {
        if (isDebug) {
            System.out.append(msg).append(" thread: ").append(Thread.currentThread().toString()).append(" pthread_t: ").println(Pthread.pthread_self(arena).nativeToString());
            System.out.flush();
        }
    }

    private void debugAiocb(OpaqueMemory aioBuffer) {
        if (isDebug) {
            try {
                OutputStreamAppender osa = new OutputStreamAppender(System.out);
                osa.append("data to write:>>>\n");
                aioBuffer.nativeToString(osa, "", " ");
                osa.append("<<<\n");
                osa.append("aiocb : ");
                aiocb.nativeToString(osa, "", " ");
                osa.append("\n");
                Pthread.Pthread_attr_t sigev_notify_attributes;
                try {
                    sigev_notify_attributes = aiocb.aio_sigevent.sigev_notify_attributesAs();
                } catch (InvalidCacheException ice) {
                    final long address = aiocb.aio_sigevent.sigev_notify_attributes().address();
                    if (address != 0L) {
                        sigev_notify_attributes = Pthread.Pthread_attr_t.ofAddress(address, arena);
                    } else {
                        sigev_notify_attributes = null;
                    }
                }

                osa.append("aiocb.aio_sigevent.sigev_notify_attributes : ");
                if (sigev_notify_attributes == null) {
                    osa.append("null");
                } else {
                    sigev_notify_attributes.nativeToString(osa, "", " ");
                }
                osa.append("\n");

                osa.append("native callback same address as aiocb.aio_sigevent.sigev_notify_function: ");
                callback.nativeToString(osa, "", " ");
                osa.append("\n");
                System.out.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void printBuffer(OpaqueMemory aioBuffer) {
        StringBuilder sb = new StringBuilder((int) aioBuffer.sizeof());
        for (int i = 0; i < aioBuffer.sizeof(); i++) {
            sb.append((char) OpaqueMemory.getByte(aioBuffer, i));
        }

        System.out.println(sb.toString());
    }

}
