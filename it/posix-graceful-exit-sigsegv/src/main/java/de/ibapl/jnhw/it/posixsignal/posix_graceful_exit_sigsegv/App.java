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
package de.ibapl.jnhw.it.posixsignal.posix_graceful_exit_sigsegv;

import de.ibapl.jnhw.common.callback.Callback_I_V;
import de.ibapl.jnhw.common.callback.Callback_I_V_Impl;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.nativecall.CallNative_I_V;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr_I_V;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.posix.Signal;

/**
 * The simplest way to handle a SIGSEGV. The shutdownhook will be called or the
 * default handler will be called.
 *
 * @author aploese
 */
public class App {

    public static void main(String[] args) throws Exception {

        MultiarchTupelBuilder mtb = new MultiarchTupelBuilder();
        if (mtb.getOS() == OS.WINDOWS) {
            throw new RuntimeException("No POSIX system!");
        }
        //set a shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("***********************************************************");
            System.out.println("*                                                         *");
            System.out.println("*                 End from ShutdownHook!                  *");
            System.out.println("*                                                         *");
            System.out.println("***********************************************************");
            System.out.flush();
            try {
                //give the stream time to write.
                Thread.sleep(20);
            } catch (InterruptedException ie) {

            }
        }));

        Callback_I_V callback_I_V = new Callback_I_V_Impl() {
            @Override
            protected void callback(int value) {
                System.out.println("Signal: " + value + " caught! in thread: " + Thread.currentThread());
                System.out.flush();
                System.exit(value);
            }
        };

        //comment this out, and you will get the default JVM style of saying goodby after a SIGSEGV
        FunctionPtr_I_V originalHandler = Signal.signal(Signal.SIGSEGV, callback_I_V);

        //We will call a NULL pointer on the native side. So we will force a segmentation violation.
        NativeAddressHolder nah = NativeAddressHolder.NULL;
        CallNative_I_V callNative_I_V = new CallNative_I_V(nah);
        callNative_I_V.call(42);

        System.err.println("We should never reach this.");
        System.err.flush();
        try {
            //give the stream time to write.
            Thread.sleep(20);
        } catch (InterruptedException ie) {

        }
    }
}
