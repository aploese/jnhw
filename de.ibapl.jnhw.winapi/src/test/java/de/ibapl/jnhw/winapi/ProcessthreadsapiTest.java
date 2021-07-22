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
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import de.ibapl.jnhw.winapi.Winnt.PAPCFUNC;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;
import org.junit.jupiter.api.condition.EnabledOnOs;

/**
 *
 * @author aploese
 */
@EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class ProcessthreadsapiTest {

    private final static MultiarchTupelBuilder MULTIARCH_TUPEL_BUILDER = new MultiarchTupelBuilder();

    public ProcessthreadsapiTest() {
    }

    /**
     * Test of GetCurrentThread, of class Processthreadsapi.
     */
    @Test
    public void testGetCurrentThread() {
        assertNotNull(Processthreadsapi.GetCurrentThread());
    }

    /**
     * Test of QueueUserAPC method, of class Processthreadsapi.
     */
    @Test
    public void testQueueUserAPC() throws NativeErrorException {
        System.out.println("QueueUserAPC");
        final Long[] longRef = new Long[1];
        final Integer[] intRef = new Integer[1];

        PAPCFUNC pfnAPC = new PAPCFUNC() {
            @Override
            protected void callback(int value) {
                intRef[0] = value;
                longRef[0] = -1L;
            }

            @Override
            protected void callback(long value) {
                longRef[0] = value;
                intRef[0] = -1;
            }
        };

        HANDLE hThread = Processthreadsapi.GetCurrentThread();

        assertThrows(NullPointerException.class, () -> {
            Processthreadsapi.QueueUserAPC(null, hThread, 0);
        });

        assertThrows(NullPointerException.class, () -> {
            Processthreadsapi.QueueUserAPC(pfnAPC, null, 0);
        });

        Processthreadsapi.QueueUserAPC(pfnAPC, hThread, 42);

        long result = Synchapi.SleepEx(100, true);
        assertEquals(Winbase.WAIT_IO_COMPLETION, result);

        switch (MULTIARCH_TUPEL_BUILDER.getSizeOfPointer()) {
            case _32_BIT:
                assertEquals(-1L, longRef[0]);
                assertEquals(42, intRef[0]);
                assertThrows(IllegalArgumentException.class, () -> {
                    Processthreadsapi.QueueUserAPC(pfnAPC, null, 1L + Integer.MAX_VALUE);
                });
                assertThrows(IllegalArgumentException.class, () -> {
                    Processthreadsapi.QueueUserAPC(pfnAPC, null, Integer.MIN_VALUE - 1L);
                });
                break;
            case _64_BIT:
                assertEquals(-1, intRef[0]);
                assertEquals(42L, longRef[0]);
                break;
            default:
                throw new RuntimeException("Can't handle SizeOfPointer " + MULTIARCH_TUPEL_BUILDER.getSizeOfPointer());
        }
    }
}
