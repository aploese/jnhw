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
package de.ibapl.jnhw.x_open;

import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory.SetMem;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.posix.LibJnhwPosixTestLoader;
import de.ibapl.jnhw.posix.Signal;
import de.ibapl.jnhw.util.posix.DefinesTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.condition.DisabledOnOs;

/**
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class UcontextTest {

    public static class NativeDefines {

        public final static native boolean HAVE_UCONTEXT_H();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    private final static MultiarchTupelBuilder MULTIARCHTUPEL_BUILDER = new MultiarchTupelBuilder();

    @BeforeAll
    public static void checkBeforeAll_HAVE_UCONTEXT_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Ucontext.HAVE_UCONTEXT_H, "not expected to have ucontect.h");
        } else {
            Assertions.assertTrue(Ucontext.HAVE_UCONTEXT_H, "expected to have ucontect.h");
        }
    }

    @BeforeAll
    public static void checkBeforeAll_StdioDefines() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Ucontext.class, NativeDefines.class, "HAVE_UCONTEXT_H");
    }

    /**
     * Test of getcontext method, of class Ucontext.
     */
    @Test
    public void testGetcontext() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.OPEN_BSD) {
            assertThrows(NoSuchNativeMethodException.class, () -> Ucontext.getcontext(null));
        } else {
            assertThrows(NullPointerException.class, () -> Ucontext.getcontext(null));
            Signal.Ucontext_t ucp = new Signal.Ucontext_t(SetMem.DO_NOT_SET);
            Ucontext.getcontext(ucp);
            StringBuilder sb = new StringBuilder();
            ucp.nativeToString(sb, "", " ");
            System.out.println("ucontext:" + sb.toString());
        }
    }

    private volatile int count;

    /**
     * Test of setcontext method, of class Ucontext.
     */
    @Test
    @Disabled
    public void testSetcontext() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.OPEN_BSD) {
            assertThrows(NoSuchNativeMethodException.class, () -> Ucontext.setcontext(null));
        } else {
            assertThrows(NullPointerException.class, () -> Ucontext.setcontext(null));
            Signal.Ucontext_t ucp = new Signal.Ucontext_t(SetMem.DO_NOT_SET);
            count = 0;
            Ucontext.getcontext(ucp);
            count++;
            System.out.println("IN testGetcontext");
            if (count < 10) {
                System.out.println("will loop");
                Ucontext.setcontext(ucp);
            } else {
                System.out.println("stop loop");
            }
            assertEquals(10, count);
        }
    }

    /**
     * Test of swapcontext method, of class Ucontext.
     */
    @Test
    @Disabled
    public void testSwapcontext() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.OPEN_BSD) {
            assertThrows(NoSuchNativeMethodException.class, () -> Ucontext.swapcontext(null, null));
        } else {
            fail("The test will crash the jvm - so stop here!");
            System.out.println("swapcontext");
            Signal.Ucontext_t oucp = null;
            Signal.Ucontext_t ucp = null;
            int expResult = 0;
            Ucontext.swapcontext(oucp, ucp);
        }
    }

}
