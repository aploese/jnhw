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
package de.ibapl.jnhw.it.posixsignal.posix_signal;

import de.ibapl.jnhw.common.callback.Callback_I_V_Impl;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NotDefinedException;
import de.ibapl.jnhw.common.nativecall.CallNative_I_V;
import de.ibapl.jnhw.posix.Signal;

/**
 *
 * @author aploese
 */
public class SimpleSignalHandler extends Callback_I_V_Impl {

    final int signal;
    final boolean handlerInSameThread;
    CallNative_I_V originalHandler;
    boolean done;

    SimpleSignalHandler(final int signal, boolean handlerInSameThread) {
        this.signal = signal;
        this.handlerInSameThread = handlerInSameThread;
    }

    private void setup() throws NativeErrorException, InterruptedException, NotDefinedException {
        if (handlerInSameThread) {
            originalHandler = Signal.signal(signal, this);
            System.err.println("Signalhandler for signal: " + signal + " set! in thread: " + Thread.currentThread());
            if (Signal.SIG_DFL().equals(originalHandler)) {
                System.out.println("Old signal handler of SIG is SIG_DFL!");
            } else if (Signal.SIG_ERR().equals(originalHandler)) {
                System.out.println("Old signal handler of SIG is SIG_ERR!");
            } else if (Signal.SIG_IGN().equals(originalHandler)) {
                System.out.println("Old signal handler of SIG is SIG_IGN!");
            } else if (Signal.SIG_HOLD().equals(originalHandler)) {
                System.out.println("Old signal handler of SIG is SIG_HOLD!");
            } else {
                System.out.println("Old signal handler of SIG is " + originalHandler);
            }
        } else {
            final Object lock = new Object();
            new Thread(() -> {
                try {
                    originalHandler = Signal.signal(signal, SimpleSignalHandler.this);
                    synchronized (lock) {
                        lock.notifyAll();
                    }
                    System.err.println("Signalhandler for signal: " + signal + " set! in thread: " + Thread.currentThread());
                    while (!done) {
                        Thread.sleep(100);
                    }
                } catch (NativeErrorException nee) {
                    System.err.println(nee);
                    synchronized (lock) {
                        lock.notifyAll();
                    }
                    throw new RuntimeException(nee);
                } catch (Throwable t) {
                    System.err.println(t);
                    throw new RuntimeException(t);
                }

            }).start();
            synchronized (lock) {
                lock.wait();
            }
        }
        System.err.println("Return from Init of signal : " + signal + " in thread: " + Thread.currentThread());
    }

    @Override
    protected void callback(int value) {
        System.err.println("Signal: " + value + " caught! in thread: " + Thread.currentThread());
    }

    void raise() throws NativeErrorException, InterruptedException, NotDefinedException {
        try {
            setup();

            System.out.println("Will raise signal: " + signal + " in thread: " + Thread.currentThread());
            Signal.raise(signal);
            System.out.println("Signal: " + signal + " raised! in thread: " + Thread.currentThread());
            Signal.signal(signal, originalHandler);
            System.err.println("Signalhandler for signal: " + signal + " removed!");
        } finally {
            done = true;
        }
    }

}
