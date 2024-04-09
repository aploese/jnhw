/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2023-2024, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.posix;

import org.junit.jupiter.api.TestInfo;

/**
 *
 * @author aploese
 */
public class JnhwTestLogger {

    //set this to true to see lot of output
    //it may be useful to see which test crashed the VM ...
    final static boolean PRINT_LOG = false;
    final static int WAIT_TIME = 0;

    private static void flushAndWait() {
        System.out.flush();
        if (WAIT_TIME != 0) {
            try {
                Thread.sleep(WAIT_TIME);
            } catch (InterruptedException ex) {
            }
        }
    }

    public static void logTest(String text) {
        if (PRINT_LOG) {
            System.out.println("   " + text);
            flushAndWait();
        }
    }

    public static void logTest(String text, Object... args) {
        if (PRINT_LOG) {
            System.out.printf("   " + text, args);
            flushAndWait();
        }
    }

    public static void logBeforeEach(TestInfo testInfo) {
        if (PRINT_LOG) {
            System.out.println(" +Will run test: " + testInfo.getTestClass().get().getSimpleName() + "#" + testInfo.getDisplayName());
            flushAndWait();
        }
    }

    public static void logAfterEach(TestInfo testInfo) {
        if (PRINT_LOG) {
            System.out.println(" -Test done:     " + testInfo.getTestClass().get().getSimpleName() + "#" + testInfo.getDisplayName());
            flushAndWait();
        }
    }

    public static void logBeforeAllBegin(String text) {
        if (PRINT_LOG) {
            System.out.println(text);
            flushAndWait();
        }
    }

    public static void logBeforeAllEnd(String text) {
        if (PRINT_LOG) {
            System.out.println(text);
            flushAndWait();
        }
    }

    public static void logBeforeAll(TestInfo testInfo) {
        if (PRINT_LOG) {
            System.out.println(">Tests of class: " + testInfo.getTestClass().get().getSimpleName() + " begin.");
            flushAndWait();
        }
    }

    public static void logAfterAll(TestInfo testInfo) {
        if (PRINT_LOG) {
            System.out.println("<Tests of class: " + testInfo.getTestClass().get().getSimpleName() + " done.");
            flushAndWait();
        }
    }

}
