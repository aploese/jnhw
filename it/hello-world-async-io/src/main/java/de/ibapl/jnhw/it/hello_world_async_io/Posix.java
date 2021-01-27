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
import de.ibapl.jnhw.common.exception.NotDefinedException;
import de.ibapl.jnhw.common.memory.Memory32Heap;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.references.ObjectRef;
import de.ibapl.jnhw.common.util.OutputStreamAppender;
import de.ibapl.jnhw.posix.Aio;
import de.ibapl.jnhw.posix.Errno;
import de.ibapl.jnhw.posix.Fcntl;
import de.ibapl.jnhw.posix.Pthread;
import de.ibapl.jnhw.posix.Signal;
import de.ibapl.jnhw.posix.StringHeader;
//Import only the needed define from the wrapper of posix's unistd.h.h
import static de.ibapl.jnhw.posix.Unistd.STDOUT_FILENO;
//Import only the needed method from the wrapper of iso c's unistd.h.h
import java.io.IOException;

public class Posix {

    public static void sayHello(final boolean debug) throws NativeErrorException, NoSuchNativeMethodException, NoSuchNativeTypeException, NotDefinedException, IOException, InterruptedException {
        String STRING_TO_WRITE = "\n\t\tHello World! - AIO from POSIX\n\n";

        final ObjectRef objRef = new ObjectRef<>(null);

        final Aio.Aiocb<NativeRunnable> aiocb = new Aio.Aiocb();
        aiocb.aio_fildes(STDOUT_FILENO());
        final OpaqueMemory32 aioBuffer = Memory32Heap.of(STRING_TO_WRITE.getBytes());

        aiocb.aio_buf(aioBuffer);

        aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_THREAD());

        aiocb.aio_sigevent.sigev_notify_function(Callback_NativeRunnable.INSTANCE);
        NativeRunnable callback = new NativeRunnable() {

            @Override
            @SuppressWarnings("unchecked")
            protected void callback() {
                try {
                    int errno = Aio.aio_error(aiocb);
                    if (errno == 0) {
                        if (debug) {
                            System.out.println("Wrote " + Aio.aio_return(aiocb) + " bytes!");
                            System.out.flush();
                        }
                    } else {
                        System.err.print("Got errno from aio_write: " + Errno.getErrnoSymbol(errno) + ", " + StringHeader.strerror(errno));
                        System.err.flush();
                    }
                } catch (NativeErrorException nee) {
                    System.err.print("Got errno within callback: " + Errno.getErrnoSymbol(nee.errno) + ", " + StringHeader.strerror(nee.errno));
                    System.err.flush();
                } catch (NoSuchNativeMethodException nsnme) {
                    System.err.print("NoSuchNativeMethodException within callback: " + nsnme);
                    System.err.flush();
                }
                synchronized (objRef) {
                    objRef.value = aiocb;
                    objRef.notify();
                }
            }

        };
        aiocb.aio_sigevent.sigev_value.sival_ptr(callback);

        if (debug) {
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
        }
        if (debug) {
            System.out.println("Will now write");
            System.out.flush();
        }

        Aio.aio_write(aiocb);
        
        if (debug) {
            System.out.println("...written");
            System.out.flush();
        }

        //force data write
        Aio.aio_fsync(Fcntl.O_DSYNC(), aiocb);
        //Wait debug is slow, so we are here before the callback finishes...
        if (objRef.value == null) {
            synchronized (objRef) {
                if (debug) {
                    System.out.println("Wait for callback to finish!");
                }
                objRef.wait(100);
            }
        }

        if (objRef.value != aiocb) {
            throw new RuntimeException("Excpected handler was called!");
        } else {
            if (debug) {
                System.out.println("Data written");
            }
        }
    }
}
