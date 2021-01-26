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

import de.ibapl.jnhw.common.callback.Callback_I_V;
import de.ibapl.jnhw.common.callback.Callback_I_V_Impl;
import de.ibapl.jnhw.common.nativecall.CallNative_I_V;
import de.ibapl.jnhw.posix.Signal;

/**
 *
 * @author aploese
 */
public class SimpleSignalHandler extends SignalHandler {

    public SimpleSignalHandler(int signalToRaise, SignalAction signalAction) {
        super(signalToRaise, signalAction);
    }

    private CallNative_I_V originalHandler;
    private Callback_I_V callback_I_V = new Callback_I_V_Impl() {
        @Override
        protected void callback(int value) {
            System.out.print("\n\n********Caught Signal " + value + " in thread: " + Thread.currentThread() + "\n");
            switch (signalAction) {
                case PRINT_MSG:
                    break;
                case PRINT_MSG_AND_SYSTEM_EXIT:
                    System.exit(value);
                    break;
                case PRINT_MSG_AND_CALL_OLD_HANDLER:
                    originalHandler.call(value);
                    break;
                default:
                    thrownInHandler = new RuntimeException("Can't handle signalAction: " + signalAction);
            }
            signalHandled = true;
        }
    };

    @Override
    protected void doSetupHandler() {
        System.out.println("Simple handler for signal " + signalToRaise + " in thread: " + Thread.currentThread());
        try {
            originalHandler = Signal.signal(signalToRaise, callback_I_V);
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
        } catch (Throwable t) {
            thrownInSetupHandler = t;
        }
    }

    @Override
    protected void doRestoreHandler() {
        System.out.println("restore simple handler for signal " + signalToRaise + " in thread: " + Thread.currentThread());
        try {
            Signal.signal(signalToRaise, originalHandler);
        } catch (Throwable t) {
            thrownInRestoreHandler = t;
        }
    }

}
