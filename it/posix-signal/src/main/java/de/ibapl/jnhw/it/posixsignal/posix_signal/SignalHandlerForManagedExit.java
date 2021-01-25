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
import de.ibapl.jnhw.common.nativecall.CallNative_I_V;
import de.ibapl.jnhw.posix.Signal;

/**
 *
 * @author aploese
 */
public class SignalHandlerForManagedExit extends Callback_I_V_Impl {

    final int signal;
    CallNative_I_V originalHandler;
    boolean done;

    SignalHandlerForManagedExit(final int signal) {
        this.signal = signal;
    }

    private void setup() throws NativeErrorException, InterruptedException {
        originalHandler = Signal.signal(signal, this);
        System.err.println("Signalhandler for signal: " + signal + " set! in thread: " + Thread.currentThread());
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            //This will be called.
            System.err.println("End from ShutdownHook");
        }));
    }

    @Override
    protected void callback(int value) {
        System.err.println("Signal: " + value + " caught! in thread: " + Thread.currentThread() + " will gracefully exit with result: " + signal);
        System.exit(signal);
    }

    void raise() throws NativeErrorException, InterruptedException {
        setup();

        System.out.println("Will raise signal: " + signal + " in thread: " + Thread.currentThread());
        Signal.raise(signal);
        System.out.println("Signal: " + signal + " raised! in thread: " + Thread.currentThread());
        Signal.signal(signal, originalHandler);
        System.err.println("Signalhandler for signal: " + signal + " removed!");
    }

}
