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

import de.ibapl.jnhw.common.callback.Callback_I_Mem_Mem_V_Impl;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeException;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.nativecall.CallNative_I_V;
import de.ibapl.jnhw.posix.Signal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 */
public class AdvancedSignalHandler {

    public void raise() throws NativeErrorException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            //This will be called.
            System.err.println("End from ShutdownHook");
        }));

        final Signal.Sigaction act = new Signal.Sigaction<>();
        final Signal.Sigaction oact = new Signal.Sigaction();
        act.sa_flags(Signal.SA_SIGINFO());
        Signal.sigemptyset(act.sa_mask);

        Callback_I_Mem_Mem_V_Impl<Signal.Siginfo_t, Signal.Ucontext_t> sa_handler = new Callback_I_Mem_Mem_V_Impl<>() {

            @Override
            protected void callback(int value, Signal.Siginfo_t siginfo, Signal.Ucontext_t ucontext) {
                System.err.println("Caught signal: " + value);
                System.err.println("siginfo: " + siginfo.nativeToString());
                //TODO Iterate
                System.err.println("ucontext: " + ucontext.nativeToString());
                if (oact.sa_flags() == Signal.SA_SIGINFO()) {
                    System.err.println("Call old sigaction: ");
                    oact.sa_sigaction().call(value, siginfo, ucontext);
                } else {
                    System.err.println("Not calling old sigaction: ");
                    System.err.flush();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AdvancedSignalHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    oact.sa_sigaction().call(value, siginfo, ucontext);
                }
                System.exit(value);
            }

            @Override
            protected Signal.Siginfo_t wrapA(NativeAddressHolder address) {
                return new Signal.Siginfo_t(address);
            }

            @Override
            protected Signal.Ucontext_t wrapB(NativeAddressHolder address) {
                try {
                    return new Signal.Ucontext_t(address);
                } catch (NoSuchNativeTypeException nste) {
                    throw new RuntimeException(nste);
                }
            }
        };

        act.sa_sigaction(sa_handler);

        Signal.sigaction(Signal.SIGSEGV(), act, oact);
        try {
            System.err.println(" act: " + act.nativeToString());
            System.err.println("oact: " + oact.nativeToString());
            //Signal.raise(Signal.SIGSEGV());

            NativeAddressHolder nah = new NativeAddressHolder(0L);
            CallNative_I_V callNative_I_V = new CallNative_I_V(nah);
            try {
                callNative_I_V.call(42);
            } catch (RuntimeException re) {
                System.err.println("executed and ex of: " + re);
            }

        } finally {
            Signal.sigaction(Signal.SIGSEGV(), oact, null);
        }
    }

}
