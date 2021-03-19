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
package de.ibapl.jnhw.common.test.memory.layout;

import de.ibapl.jnhw.common.memory.layout.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aploese
 */
public class StructLayoutFactoryImplTest {

    public StructLayoutFactoryImplTest() {
    }

    public static class S1 extends StructLayout {

        public final static long f0;
        public final static long f1;
        public final static int sizeof;
        public final static Alignment alignment;

        static {
            StructLayoutFactory slf = new StructLayoutFactoryImpl(StructLayoutFactoryImpl.Type.STRUCT);
            f0 = slf.uint8_t();
            f1 = slf.uint16_t();
            sizeof = (int) slf.getSizeof();
            alignment = slf.getAlignment();
        }

        private long offset;

    }

    public static class S1_fields_reversed extends StructLayout {

        public final static long f0;
        public final static long f1;
        public final static int sizeof;
        public final static Alignment alignment;

        static {
            StructLayoutFactory slf = new StructLayoutFactoryImpl(StructLayoutFactoryImpl.Type.STRUCT);
            f0 = slf.uint16_t();
            f1 = slf.uint8_t();
            sizeof = (int) slf.getSizeof();
            alignment = slf.getAlignment();
        }

        private long offset;

    }

    public static class S2 extends StructLayout {

        public final static long f0;
        public final static long f1;
        public final static int sizeof;
        public final static Alignment alignment;

        static {
            StructLayoutFactory slf = new StructLayoutFactoryImpl(StructLayoutFactoryImpl.Type.STRUCT);
            f0 = slf.uint8_t();
            f1 = slf.struct(S1.sizeof, S1.alignment);
            sizeof = (int) slf.getSizeof();
            alignment = slf.getAlignment();
        }

    }

    public static class S3 extends StructLayout {

        public final static long f0;
        public final static long f1;
        public final static int sizeof;
        public final static Alignment alignment;

        static {
            StructLayoutFactory slf = new StructLayoutFactoryImpl(StructLayoutFactoryImpl.Type.STRUCT, Alignment.AT_1);
            f0 = slf.uint8_t();
            f1 = slf.struct(S1.sizeof, S1.alignment);
            sizeof = (int) slf.getSizeof();
            alignment = slf.getAlignment();
        }

    }

    @Test
    public void testCalcNextOffset() {
    }

    @Test
    public void testS1() {
        assertEquals(4, S1.sizeof);
        assertEquals(2, S1.f1);
        assertEquals(Alignment.AT_2, S1.alignment);
    }

    @Test
    public void testS1_fields_reversed() {
        assertEquals(4, S1_fields_reversed.sizeof);
        assertEquals(2, S1_fields_reversed.f1);
        assertEquals(Alignment.AT_2, S1_fields_reversed.alignment);
    }

    @Test
    public void testS2() {
        assertEquals(6, S2.sizeof);
        assertEquals(2, S2.f1);
        assertEquals(Alignment.AT_2, S2.alignment);
    }

    @Test
    public void testS3() {
        assertEquals(5, S3.sizeof);
        assertEquals(1, S3.f1);
        assertEquals(Alignment.AT_1, S3.alignment);
    }
}
