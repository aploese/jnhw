/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.downcall.JnhwMi__V___I__A__A;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeException;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.upcall.Callback__V___I_MA_MA;
import de.ibapl.jnhw.common.util.OutputStreamAppender;
import de.ibapl.jnhw.posix.Signal;
import de.ibapl.jnhw.x_open.Ucontext;
import java.io.IOException;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.ResourceScope;

/**
 *
 * @author aploese
 */
public class SigactionSignalHandler extends SignalHandler {

    final ResourceScope scope = ResourceScope.newSharedScope();

    final Signal.Sigaction act = Signal.Sigaction.allocateNative(scope);
    final Signal.Sigaction oact = Signal.Sigaction.allocateNative(scope);
    Callback__V___I_MA_MA<Signal.Siginfo_t, Signal.Ucontext_t> sa_handler = new Callback__V___I_MA_MA<>() {

        @Override
        protected void callback(int value, MemoryAddress siginfoPtr, MemoryAddress ucontextPtr) {
            try {
                OutputStreamAppender sb = new OutputStreamAppender(System.out);
                sb.append("\n\n********Caught Signal " + value + " in thread: " + Thread.currentThread() + "\n");

                sb.append("siginfo: ");
                final Signal.Siginfo_t siginfo = Signal.Siginfo_t.ofAddress(siginfoPtr, scope);
                siginfo.nativeToString(sb, "", " ");
                sb.append("\n");

                sb.append("ucontext: ");
                final Signal.Ucontext_t ucontext = Signal.Ucontext_t.tryOfAddress(ucontextPtr, scope);
                ucontext.nativeToString(sb, "", " ");
                sb.append("\n");

                switch (signalAction) {
                    case PRINT_MSG:
                        break;
                    case PRINT_MSG_AND_SYSTEM_EXIT:
                        System.exit(value);
                        break;
                    case PRINT_MSG_AND_CALL_OLD_HANDLER:
                        try (ResourceScope rs = ResourceScope.newConfinedScope()){
                        new JnhwMi__V___I__A__A(oact.sa_sigaction().toAddressable(), rs).invoke__V__sI__P__P(value, siginfo, ucontext);
                        }                        break;
                    default:
                        thrownInHandler = new RuntimeException("Can't handle signalAction: " + signalAction);
                }
                signalHandled = true;
            } catch (NoSuchNativeTypeException | IOException ex) {
                thrownInHandler = ex;
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
            act.sa_flags(Signal.SA_SIGINFO);
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
