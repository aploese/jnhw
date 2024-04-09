/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2020-2024, Arne Plöse and individual contributors as indicated
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
import de.ibapl.jnhw.winapi.Winnt.HANDLE;
import java.lang.foreign.Arena;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

/**
 *
 * @author aploese
 */
@EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class ProcessthreadsapiTest {

    private Arena arena;

    @BeforeEach
    public void setUp() throws Exception {
        arena = Arena.ofConfined();
    }

    @AfterEach
    public void tearDown() throws Exception {
        arena.close();
    }

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
        final long[] ref = new long[1];

        Winnt.PAPCFUNC pfnAPC = new Winnt.PAPCFUNC() {

            @Override
            public void callback(long value) {
                ref[0] = value;
            }
        };

        HANDLE hThread = Processthreadsapi.GetCurrentThread();
        long dwData = 84;

        assertThrows(NullPointerException.class, () -> {
            Processthreadsapi.QueueUserAPC(null, hThread, dwData);
        });

        assertThrows(NullPointerException.class, () -> {
            Processthreadsapi.QueueUserAPC(pfnAPC, null, dwData);
        });

        Processthreadsapi.QueueUserAPC(pfnAPC, hThread, dwData);

        long result = Synchapi.SleepEx(100, true);
        assertEquals(Winbase.WAIT_IO_COMPLETION, result);

        assertEquals(84, ref[0]);
    }
}
