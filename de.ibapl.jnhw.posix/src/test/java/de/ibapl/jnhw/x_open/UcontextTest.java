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
package de.ibapl.jnhw.x_open;

import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeException;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.posix.JnhwTestLogger;
import de.ibapl.jnhw.posix.Signal;
import de.ibapl.jnhw.util.posix.DefinesTest;
import java.lang.foreign.MemorySession;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.condition.DisabledOnOs;

/**
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class UcontextTest {

    @BeforeAll
    public static void checkBeforeAll_UcontextDefines() throws Exception {
        JnhwTestLogger.logBeforeAllBeginn("checkBeforeAll_UcontextDefines");
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            JnhwTestLogger.logBeforeAllEnd("checkBeforeAll_UcontextDefines");
            return;
        }
        DefinesTest.testDefines(Ucontext.class, "HAVE_UCONTEXT_H");
        JnhwTestLogger.logBeforeAllEnd("checkBeforeAll_UcontextDefines");
    }

    private MemorySession ms;

    @BeforeEach
    public void setUp(TestInfo testInfo) throws Exception {
        JnhwTestLogger.logBeforeEach(testInfo);
        ms = MemorySession.openConfined();
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        ms.close();
        JnhwTestLogger.logAfterEach(testInfo);
    }

    /**
     * Test of getcontext method, of class Ucontext.
     */
    @Test
    public void testGetcontext() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case APPLE, OPEN_BSD ->
                assertThrows(NoSuchNativeTypeException.class, () -> Ucontext.getcontext(Signal.Ucontext_t.tryAllocateNative(ms)));
            default -> {
                assertThrows(NullPointerException.class, () -> Ucontext.getcontext(null));
                Signal.Ucontext_t ucp = Signal.Ucontext_t.tryAllocateNative(ms);
                Ucontext.getcontext(ucp);
                StringBuilder sb = new StringBuilder();
                ucp.nativeToString(sb, "", " ");
                JnhwTestLogger.logTest("ucontext:" + sb.toString());
            }
        }
    }

    private volatile int count;

    /**
     * Test of setcontext method, of class Ucontext.
     */
    @Test
    @Disabled
    public void testSetcontext() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case APPLE, OPEN_BSD ->
                assertThrows(NoSuchNativeMethodException.class, () -> Ucontext.setcontext(null));
            default -> {
                assertThrows(NullPointerException.class, () -> Ucontext.setcontext(null));
                Signal.Ucontext_t ucp = Signal.Ucontext_t.tryAllocateNative(ms);
                count = 0;
                Ucontext.getcontext(ucp);
                count++;
                if (count < 10) {
                    Ucontext.setcontext(ucp);
                } else {
                }
                assertEquals(10, count);
            }
        }
    }

    /**
     * Test of swapcontext method, of class Ucontext.
     */
    @Test
    @Disabled
    public void testSwapcontext() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case APPLE, OPEN_BSD ->
                assertThrows(NoSuchNativeMethodException.class, () -> Ucontext.swapcontext(null, null));
            default -> {
                fail("The test will crash the jvm - so stop here!");
                Signal.Ucontext_t oucp = null;
                Signal.Ucontext_t ucp = null;
                int expResult = 0;
                Ucontext.swapcontext(oucp, ucp);
            }
        }
    }

}
