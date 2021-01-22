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

import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.posix.Signal;

/**
 *
 * @author aploese
 */
public class App {

    public static void main(String[] args) throws Exception {
        MultiarchTupelBuilder mtb = new MultiarchTupelBuilder();
        if (mtb.getOS() == OS.WINDOWS) {
            throw new RuntimeException("No POSIX system!");
        } else {
            boolean printMsg = true;
            do {
                if (printMsg) {
                    System.out.println("Choose ");
                    System.out.println("\t 0 exit ");
                    System.out.println("\t 1 for unhandled exception SIGSEGV");
                    System.out.println("\t 2 for simple SIGSEGV handler (in same thread)");
                    System.out.println("\t 3 for simple SIGSEGV handler (in new thread)");
                    System.out.println("\t 4 force a SIGSEGV in native code");
                    System.out.println("\t 5 call current SIGSEGV handler");
                }
                printMsg = true;
                char input = (char) System.in.read();
                switch (input) {
                    case '0':
                        System.exit(0);
                        break;
                    case '1':
                        new SignalUnhandled().raise();
                        break;
                    case '2':
                        new SimpleSignalHandler(Signal.SIGSEGV(), true).raise();
                        break;
                    case '3':
                        new SimpleSignalHandler(Signal.SIGSEGV(), false).raise();
                        break;
                    case '4':
                        new NativeSementationFaultHandler().raise();
                        break;
                    case '5':
                        new CallOriginalSigSegVHandler().raise();
                        break;
                    case '\n':
                        printMsg = false;
                        break;
                    default:
                        System.out.println("Wrong input");

                }
                //Free Callbacks
                while (SimpleSignalHandler.callbacksAvailable() == 0) {
                    System.out.println("No Callabacks of " + SimpleSignalHandler.MAX_CALL_BACKS() + " left. Will try to free resources!");
                    System.runFinalization();
                    System.gc();
                    System.out.println("Now we have " + SimpleSignalHandler.callbacksAvailable() + " callbacks.");
                }
            } while (true);
        }
    }

}
