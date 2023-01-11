/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.downcall.foreign.JnhwMi__V___I;
import de.ibapl.jnhw.posix.Signal;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;

/**
 *
 * @author aploese
 */
public abstract class SignalHandler {

    public static enum ThreadingModel {
        SETUP_IN_THREAD_MAIN__SIGNAL_IN_THREAD_MAIN,
        SETUP_IN_THREAD_MAIN__SIGNAL_IN_THREAD_1,
        SETUP_IN_THREAD_1__SIGNAL_IN_THREAD_MAIN,
        SETUP_IN_THREAD_1__SIGNAL_IN_THREAD_1,
        SETUP_IN_THREAD_1__SIGNAL_IN_THREAD_2;
    }

    public static enum SignalAction {
        PRINT_MSG,
        PRINT_MSG_AND_SYSTEM_EXIT,
        PRINT_MSG_AND_CALL_OLD_HANDLER;
    }

    protected Throwable thrownInSetupHandler;
    protected Throwable thrownInRestoreHandler;
    protected Throwable thrownInRaise;
    protected Throwable thrownInHandler;
    protected boolean signalHandled = false;
    protected final int signalToRaise;
    protected ThreadingModel threadingModel;
    protected final SignalAction signalAction;

    public SignalHandler(int signalToRaise, SignalAction signalAction) {
        this.signalToRaise = signalToRaise;
        this.signalAction = signalAction;
    }

    void raiseSignal() {
        signalHandled = false;
        switch (threadingModel) {
            case SETUP_IN_THREAD_MAIN__SIGNAL_IN_THREAD_MAIN:
                doSetupHandler();
                doRaiseSignal();
                break;
            case SETUP_IN_THREAD_MAIN__SIGNAL_IN_THREAD_1:
                doSetupHandler();
                new Thread(() -> doRaiseSignal()).start();
                break;
            case SETUP_IN_THREAD_1__SIGNAL_IN_THREAD_MAIN:
                new Thread(() -> {
                    doSetupHandler();
                    while (!signalHandled) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ie) {
                            System.err.println("InterruptedException" + ie);
                        }
                    }
                }).start();
                doRaiseSignal();
                break;
            case SETUP_IN_THREAD_1__SIGNAL_IN_THREAD_1:
                new Thread(() -> {
                    doSetupHandler();
                    doRaiseSignal();
                }).start();
                break;
            case SETUP_IN_THREAD_1__SIGNAL_IN_THREAD_2:
                new Thread(() -> {
                    doSetupHandler();
                    while (!signalHandled) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ie) {
                            System.err.println("InterruptedException" + ie);
                        }
                    }
                }).start();
                new Thread(() -> {
                    doRaiseSignal();
                }).start();
                break;
            default:
                throw new RuntimeException("Cant handle threading model!");
        }
        while (!signalHandled) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                System.err.println("InterruptedException" + ie);
            }
        }
        doRestoreHandler();
    }

    void forceSignal() {
        if (signalToRaise != Signal.SIGSEGV) {
            throw new IllegalStateException("Can only force SIGSEGEV!");
        }

    }

    protected abstract void doSetupHandler();

    protected abstract void doRestoreHandler();

    private void doRaiseSignal() {
        System.out.println("raise Signal " + signalToRaise + " in thread: " + Thread.currentThread());
        try {
            Signal.raise(signalToRaise);
        } catch (Throwable t) {
            thrownInRaise = t;
        }
    }

    private void doForceSignal() {
        try ( MemorySession ms = MemorySession.openConfined()) {
            System.out.println("force Signal " + signalToRaise + " in thread: " + Thread.currentThread());
            //We will call a NULL pointer on the native side. So we will force a segmentation violation.
            JnhwMi__V___I callNative__V___I = new JnhwMi__V___I(MemoryAddress.NULL, ms);
            callNative__V___I.invoke__V__sI(42);
        } catch (Throwable t) {
            thrownInHandler = t;
        }
    }

    public void setThreadingModel(ThreadingModel threadingModel) {
        this.threadingModel = threadingModel;
    }

}
