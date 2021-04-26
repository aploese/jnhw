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
package de.ibapl.jnhw.syscall.linux.util.memory;

import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aploese
 */
public class LinuxSyscallStruct32Test {

    class TestStruct extends LinuxSyscallStruct32 {

        public TestStruct() {
            super(null, 0, 4, SetMem.TO_0x00);
        }

        short getShort() {
            return ACCESSOR___LE16.__le16(t, 0);
        }

        void setShort(short value) {
            ACCESSOR___LE16.__le16(t, 0, value);
        }

        int getInt() {
            return ACCESSOR___LE16.__le16_AsInt(t, 0);
        }

        void setInt(int value) {
            ACCESSOR___LE16.__le16_FromInt(t, 0, value);
        }

        byte get(int index) {
            return OpaqueMemory32.getByte(t, index);
        }
    }

    TestStruct t = new TestStruct();

    public LinuxSyscallStruct32Test() {
    }

    @Test
    public void testLe16AsShort() {
        final short value = 0x0100;
        t.setShort(value);
        assertEquals(0, t.get(0));
        assertEquals(1, t.get(1));
        assertEquals(0, t.get(2));
        assertEquals(0, t.get(3));
        assertEquals(value, t.getShort());
    }

    @Test
    public void testLe16AsInt() {
        final int value = 0x0100;
        t.setInt(value);
        assertEquals(0, t.get(0));
        assertEquals(1, t.get(1));
        assertEquals(0, t.get(2));
        assertEquals(0, t.get(3));
        assertEquals(value, t.getInt());
    }

}
