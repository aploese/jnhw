/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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
import de.ibapl.jnhw.common.memory.UintPtr_t;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import de.ibapl.jnhw.winapi.Winnt.PAPCFUNC;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;
import jdk.incubator.foreign.ResourceScope;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.condition.EnabledOnOs;
import jdk.incubator.foreign.MemoryAddress;

/**
 *
 * @author aploese
 */
@EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class ProcessthreadsapiTest {

    private ResourceScope scope;

    @BeforeEach
    public void setUp() throws Exception {
        scope = ResourceScope.newConfinedScope();
    }

    @AfterEach
    public void tearDown() throws Exception {
        scope.close();
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
        final MemoryAddress[] ref = new MemoryAddress[1];

        Winnt.PAPCFUNC pfnAPC = new Winnt.PAPCFUNC() {

            @Override
            public void callback(MemoryAddress address) {
                ref[0] = address;
            }
        };

        HANDLE hThread = Processthreadsapi.GetCurrentThread();
        UintPtr_t dwData = UintPtr_t.allocateNative(scope);

        assertThrows(NullPointerException.class, () -> {
            Processthreadsapi.QueueUserAPC(null, hThread, dwData);
        });

        assertThrows(NullPointerException.class, () -> {
            Processthreadsapi.QueueUserAPC(pfnAPC, null, dwData);
        });

        dwData.set(MemoryAddress.ofLong(42));
        Processthreadsapi.QueueUserAPC(pfnAPC, hThread, dwData);

        long result = Synchapi.SleepEx(100, true);
        assertEquals(Winbase.WAIT_IO_COMPLETION, result);

        assertEquals(42, ref[0].toRawLongValue());
    }
}
