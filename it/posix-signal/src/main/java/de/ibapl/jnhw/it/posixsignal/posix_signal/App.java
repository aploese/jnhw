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

import de.ibapl.jnhw.it.posixsignal.posix_signal.SignalHandler.SignalAction;
import de.ibapl.jnhw.it.posixsignal.posix_signal.SignalHandler.ThreadingModel;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.posix.Signal;

/**
 *
 * @author aploese
 */
public class App {

    public final static int SIGNAL_TO_RAISE = Signal.SIGSEGV;

    public static void main(String[] args) throws Exception {

        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            throw new RuntimeException("No POSIX system!");
        }
        //set a shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("***********************************************************");
            System.err.println("*                                                         *");
            System.err.println("*                 End from ShutdownHook!                  *");
            System.err.println("*                                                         *");
            System.err.println("***********************************************************");
        }));

        do {
            char input;
            if (args.length == 3) {
                input = args[0].charAt(0);
            } else {
                System.out.println("Choose signal handler");
                System.out.println("\t 0: signal unhandled");
                System.out.println("\t 1: sigaction.sa_sigaction signal handler print msg");
                System.out.println("\t 2: sigaction.sa_sigaction signal handler print msg and System.exit(signal)");
                System.out.println("\t 3: sigaction.sa_sigaction signal handler print msg call old handler");
                System.out.println("\t 4: signal(int, (void*)(int)) signal handler print msg");
                System.out.println("\t 5: signal(int, (void*)(int)) signal handler print msg and System.exit(signal)");
                System.out.println("\t 6: signal(int, (void*)(int)) signal handler print msg call old handler");
                System.out.println("\t 7: exit");
                input = (char) System.in.read();
            }
            SignalHandler signalHandler = null;
            switch (input) {
                case '0' ->
                    signalHandler = new NoSignalHandler(SIGNAL_TO_RAISE, SignalAction.PRINT_MSG);
                case '1' ->
                    signalHandler = new SigactionSignalHandler(SIGNAL_TO_RAISE, SignalAction.PRINT_MSG);
                case '2' ->
                    signalHandler = new SigactionSignalHandler(SIGNAL_TO_RAISE, SignalAction.PRINT_MSG_AND_SYSTEM_EXIT);
                case '3' ->
                    signalHandler = new SigactionSignalHandler(SIGNAL_TO_RAISE, SignalAction.PRINT_MSG_AND_CALL_OLD_HANDLER);
                case '4' ->
                    signalHandler = new SimpleSignalHandler(SIGNAL_TO_RAISE, SignalAction.PRINT_MSG);
                case '5' ->
                    signalHandler = new SimpleSignalHandler(SIGNAL_TO_RAISE, SignalAction.PRINT_MSG_AND_SYSTEM_EXIT);
                case '6' ->
                    signalHandler = new SimpleSignalHandler(SIGNAL_TO_RAISE, SignalAction.PRINT_MSG_AND_CALL_OLD_HANDLER);
                case '7' ->
                    System.exit(0);
                default -> {
                    System.out.println("Wrong input for signal handler");
                    continue;
                }
            }
            if (args.length != 3) {
                System.in.read(); //read '\n'
            }

            if (args.length == 3) {
                input = args[1].charAt(0);
            } else {
                System.out.println("Choose threading model");
                System.out.println("\t 0: setup in thread main, signal in thread main");
                System.out.println("\t 1: setup in thread main, signal in thread 1");
                System.out.println("\t 2: setup in thread 1, signal in thread main");
                System.out.println("\t 3: setup in thread 1, signal in thread 1");
                System.out.println("\t 4: setup in thread 1, signal in thread 2");
                System.out.println("\t 5: exit");
                input = (char) System.in.read();
            }
            switch (input) {
                case '0' ->
                    signalHandler.setThreadingModel(ThreadingModel.SETUP_IN_THREAD_MAIN__SIGNAL_IN_THREAD_MAIN);
                case '1' ->
                    signalHandler.setThreadingModel(ThreadingModel.SETUP_IN_THREAD_MAIN__SIGNAL_IN_THREAD_1);
                case '2' ->
                    signalHandler.setThreadingModel(ThreadingModel.SETUP_IN_THREAD_1__SIGNAL_IN_THREAD_MAIN);
                case '3' ->
                    signalHandler.setThreadingModel(ThreadingModel.SETUP_IN_THREAD_1__SIGNAL_IN_THREAD_1);
                case '4' ->
                    signalHandler.setThreadingModel(ThreadingModel.SETUP_IN_THREAD_1__SIGNAL_IN_THREAD_2);
                case '5' ->
                    System.exit(0);
                default -> {
                    System.out.println("Wrong input for threading model");
                    continue;
                }
            }
            if (args.length != 3) {
                System.in.read(); //read '\n'
            }

            if (args.length == 3) {
                input = args[2].charAt(0);
            } else {
                System.out.println("Choose signal source");
                System.out.println("\t 0: raise signal");
                System.out.println("\t 1: force signal in native code the signal will reoccur forever");
                System.out.println("\t 2: exit");
                input = (char) System.in.read();
            }
            switch (input) {
                case '0' ->
                    signalHandler.raiseSignal();
                case '1' ->
                    signalHandler.forceSignal();
                case '2' ->
                    System.exit(0);
                default -> {
                    System.out.println("Wrong input for threading model");
                    continue;
                }
            }
            if (args.length != 3) {
                System.in.read(); //read '\n'
            } else {
                args = new String[0];
            }
            System.gc();
        } while (true);
    }
}
