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
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeException;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.util.OutputStreamAppender;
import de.ibapl.jnhw.posix.Signal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 */
public class SigactionSignalHandler extends SignalHandler {

    final Signal.Sigaction act = new Signal.Sigaction<>();
    final Signal.Sigaction oact = new Signal.Sigaction();
    Callback_I_Mem_Mem_V_Impl<Signal.Siginfo_t, Signal.Ucontext_t> sa_handler = new Callback_I_Mem_Mem_V_Impl<>() {

        @Override
        protected void callback(int value, Signal.Siginfo_t siginfo, Signal.Ucontext_t ucontext) {
            try {
                OutputStreamAppender sb = new OutputStreamAppender(System.out);
                sb.append("\n\n********Caught Signal " + value + " in thread: " + Thread.currentThread() + "\n");

                sb.append("siginfo: ");
                siginfo.nativeToString(sb, "", " ");
                sb.append("\n");

                sb.append("ucontext: ");
                ucontext.nativeToString(sb, "", " ");
                sb.append("\n");

                switch (signalAction) {
                    case PRINT_MSG:
                        break;
                    case PRINT_MSG_AND_SYSTEM_EXIT:
                        System.exit(value);
                        break;
                    case PRINT_MSG_AND_CALL_OLD_HANDLER:
                        oact.sa_sigaction().call(value, siginfo, ucontext);
                        break;
                    default:
                        thrownInHandler = new RuntimeException("Can't handle signalAction: " + signalAction);
                }
                signalHandled = true;
            } catch (IOException ioe) {
                thrownInHandler = ioe;
            }
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

    public SigactionSignalHandler(int signalToRaise, SignalAction signalAction) {
        super(signalToRaise, signalAction);
    }

    @Override
    protected void doSetupHandler() {
        System.out.println("Sigaction handler for signal " + signalToRaise + " in thread: " + Thread.currentThread());
        try {
            OutputStreamAppender sb = new OutputStreamAppender(System.err);
            act.sa_flags(Signal.SA_SIGINFO());
            Signal.sigemptyset(act.sa_mask);

            act.sa_sigaction(sa_handler);

            Signal.sigaction(signalToRaise, act, oact);

            sb.append("act: ");
            act.nativeToString(sb, "", " ");
            sb.append("\n");
            sb.append("oact: ");
            oact.nativeToString(sb, "", " ");
            sb.append("\n");
            sb.flush();
        } catch (Throwable t) {
            thrownInSetupHandler = t;
        }
    }

    @Override
    protected void doRestoreHandler() {
        System.out.println("restore sigaction handler for signal " + signalToRaise + " in thread: " + Thread.currentThread());
        try {
            Signal.sigaction(signalToRaise, oact, null);
        } catch (Throwable t) {
            thrownInRestoreHandler = t;
        }
    }

}
