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
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeException;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.nativecall.CallNative_I_V;
import de.ibapl.jnhw.common.nativepointer.FunctionPointer_I_V;
import de.ibapl.jnhw.posix.Errno;
import de.ibapl.jnhw.posix.Signal;
import de.ibapl.jnhw.posix.Time;

/**
 *
 * @author aploese
 */
public class NativeSementationFaultHandler extends Callback_I_V_Impl {

    CallNative_I_V originalHandler;

    NativeSementationFaultHandler() throws NativeErrorException {
        originalHandler = Signal.signal(Signal.SIGSEGV(), this);
        System.err.println("Signalhandler for signal: SIGSEGV set!");
    }

    @Override
    protected void callback(int value) {
        System.err.println("Signal: " + value + " caught!");
//        System.exit(-1);
    }

    void raise() throws NoSuchNativeTypeException, NoSuchNativeMethodException, NativeErrorException {
        System.out.println("Will force SIGSEGV by calling CallNative_I_V with a NULL reference");
        NativeAddressHolder nah = new NativeAddressHolder(0L);
        CallNative_I_V callNative_I_V = new CallNative_I_V(nah);
        try {
            callNative_I_V.call(42);
        } catch (RuntimeException re) {
            System.err.println("executed and ex of: " + re);
        }
        Signal.signal(Signal.SIGSEGV(), originalHandler);
        System.err.println("Signalhandler for signal: SIGSEGV removed!");
    }

}
