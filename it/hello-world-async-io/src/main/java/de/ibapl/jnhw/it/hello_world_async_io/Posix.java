/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2021, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.callback.Callback_NativeRunnable;
import de.ibapl.jnhw.common.callback.NativeRunnable;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeException;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.references.ObjectRef;
import de.ibapl.jnhw.common.util.OutputStreamAppender;
import de.ibapl.jnhw.posix.Aio;
import de.ibapl.jnhw.posix.Errno;
import de.ibapl.jnhw.posix.Fcntl;
import de.ibapl.jnhw.posix.Pthread;
import de.ibapl.jnhw.posix.Signal;
import de.ibapl.jnhw.posix.StringHeader;
import de.ibapl.jnhw.posix.Unistd;
import java.io.File;
//Import only the needed method from the wrapper of iso c's unistd.h.h
import java.io.IOException;

public class Posix {

    final boolean isDebug;
    long transmitted;
    final Aio.Aiocb<NativeRunnable> aiocb;

    final ObjectRef objRef = new ObjectRef<>(null);

    //This is the callback to be called from the native side.
    final NativeRunnable callback = new NativeRunnable() {

        @Override
        @SuppressWarnings("unchecked")
        protected void callback() {
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
                debug("Got errno within callback: " + Errno.getErrnoSymbol(nee.errno) + ", " + StringHeader.strerror(nee.errno));
            } catch (NoSuchNativeMethodException nsnme) {
                debug("NoSuchNativeMethodException within callback: " + nsnme);
            }
            synchronized (objRef) {
                objRef.value = aiocb;
                objRef.notify();
            }
            debugThread("Leave callback");
        }

    };

    public Posix(boolean isDebug) {
        this.isDebug = isDebug;
        try {
            aiocb = new Aio.Aiocb<>();
        } catch (NoSuchNativeTypeException nsnte) {
            throw new RuntimeException(nsnte);
        }
    }

    public void aio(File file, OpaqueMemory32 aioBuffer) throws NativeErrorException, NoSuchNativeMethodException, NoSuchNativeTypeException, IOException, InterruptedException {
        debugThread("Write/Read in thread: ");

        aiocb.aio_fildes(Fcntl.open(file.getAbsolutePath(), Fcntl.O_RDWR));
        aiocb.aio_buf(aioBuffer);
        if (!Signal.SIGEV_THREAD.isDefined()) {
            throw new RuntimeException("Not defined Signal.SIGEV_THREAD!");
        }
        aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_THREAD.get());
        aiocb.aio_sigevent.sigev_notify_function(Callback_NativeRunnable.INSTANCE);
        aiocb.aio_sigevent.sigev_value.sival_ptr(callback);

        debugAiocb(aioBuffer);

        debug("Will now write");

        Aio.aio_write(aiocb);

        debug("...written");

        //force data write
        //Aio.aio_fsync(Fcntl.O_DSYNC(), aiocb); // enabling this 9 bytes will be reported in callback. and the call back is called twice,
        //Wait debug is slow, so we are here before the callback finishes...
        if (objRef.value == null) {
            synchronized (objRef) {
                debug("Wait for write callback to finish!");
                objRef.wait(1000);
            }
        }

        if (objRef.value != aiocb) {
            throw new RuntimeException("Excpected handler was called!");
        } else {
            debug("Data written");
        }

        objRef.value = null;
        OpaqueMemory32.clear(aioBuffer);

        debug("Will now read");

        Aio.aio_read(aiocb);

        debug("...read");

        //force data read
        //Aio.aio_fsync(Fcntl.O_DSYNC(), aiocb);
        //Wait debug is slow, so we are here before the callback finishes...
        if (objRef.value == null) {
            synchronized (objRef) {
                debug("Wait for read callback to finish!");
                objRef.wait(100);
            }
        }

        if (objRef.value != aiocb) {
            throw new RuntimeException("Excpected handler was called! " + objRef.value);
        } else {
            debug("Data read");
        }

        //Close the handle
        Unistd.close(aiocb.aio_fildes());

        printBuffer(aioBuffer);
    }

    private void debug(String msg) {
        if (isDebug) {
            System.out.println(msg);
            System.out.flush();
        }
    }

    private void debugThread(String msg) {
        if (isDebug) {
            System.out.append(msg).append(" thread: ").append(Thread.currentThread().toString()).append(" pthread_t: ").println(Pthread.pthread_self().nativeToString());
            System.out.flush();
        }
    }

    private void debugAiocb(OpaqueMemory32 aioBuffer) {
        if (isDebug) {
            try {
                OutputStreamAppender osa = new OutputStreamAppender(System.out);
                osa.append("data to write:>>>\n");
                aioBuffer.nativeToString(osa, "", " ");
                osa.append("<<<\n");
                osa.append("aiocb : ");
                aiocb.nativeToString(osa, "", " ");
                osa.append("\n");
                final Pthread.Pthread_attr_t sigev_notify_attributes = aiocb.aio_sigevent.sigev_notify_attributes((address, parent) -> new Pthread.Pthread_attr_t(address));
                if (sigev_notify_attributes != null) {
                    osa.append("aiocb.aio_sigevent.sigev_notify_attributes : ");
                    sigev_notify_attributes.nativeToString(osa, "", " ");
                    osa.append("\n");
                }
                osa.append("native callback same address as aiocb.aio_sigevent.sigev_notify_function: ");
                Callback_NativeRunnable.INSTANCE.nativeToString(osa, "", " ");
                osa.append("\n");
                System.out.flush();
            } catch (IOException | NoSuchNativeTypeException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void printBuffer(OpaqueMemory32 aioBuffer) {
        StringBuilder sb = new StringBuilder(aioBuffer.sizeInBytes);
        for (int i = 0; i < aioBuffer.sizeInBytes; i++) {
            sb.append((char) OpaqueMemory32.getByte(aioBuffer, i));
        }

        System.out.println(sb.toString());
    }

}
