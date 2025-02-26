/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2025, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.tests;

import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.UnionLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class JavaForeignTests {

    /**
     * see: http://bugs.java.com/bugdatabase/view_bug?bug_id=JDK-8349880
     */
    @Test
    public void test_JDK_8349880() {
        Assumptions.assumeTrue(ValueLayout.ADDRESS.byteSize() == 4, "pointer must be 32bit");
        final Arena arena = Arena.ofConfined();
        final MemorySegment mem = arena.allocate(1024);
        //next call fails on i386!
        final MemorySegment memToSet = MemorySegment.ofAddress(0xfedcba9876543210L);
        mem.set(ValueLayout.ADDRESS, 0L, memToSet);
        MemorySegment ms = mem.get(ValueLayout.ADDRESS, 0L);
        Assertions.assertEquals("0x76543210", "0x" + Long.toHexString(ms.address()));
    }

    /**
     * see: http://bugs.java.com/bugdatabase/view_bug?bug_id=JDK-8349881
     */
    @Test
    public void test_JDK_8349881() {
        //TODO check for JNI property? and assume we use the jni imlementation of jnhw.common ?? - no libs compiled by default.
//        Assumptions.assumeTrue(ValueLayout.ADDRESS.byteSize() == 4, "pointer must be 32bit");
        final Linker linker = Linker.nativeLinker();
        Assertions.assertNotNull(linker, "Native Linker is null!");
        System.out.println("Linker.getClass(): " + linker.getClass());
    }

    @Test
    public void testUnionLayoutInMemorySegment_S_B() {
        UnionLayout LAYOUT__UNION_MA_L_I_S_B = MemoryLayout.unionLayout(
                ValueLayout.JAVA_SHORT.withName("S"),
                ValueLayout.JAVA_BYTE.withName("B"));
        VarHandle HANDLE_VALUE_S
                = LAYOUT__UNION_MA_L_I_S_B.varHandle(MemoryLayout.PathElement.groupElement("S"));
        VarHandle HANDLE_VALUE_B
                = LAYOUT__UNION_MA_L_I_S_B.varHandle(MemoryLayout.PathElement.groupElement("B"));

        final Arena arena = Arena.ofConfined();
        final MemorySegment mem = arena.allocate(1024);
        HANDLE_VALUE_S.set(mem, 0L, (short) 0x3210);
        Assertions.assertEquals("0x3210", "0x" + Long.toHexString((short) HANDLE_VALUE_S.get(mem, 0L)));
        switch (MultiarchTupelBuilder.getEndianess()) {
            case LITTLE ->
                Assertions.assertEquals("0x10", "0x" + Long.toHexString((byte) HANDLE_VALUE_B.get(mem, 0L)));
            case BIG ->
                Assertions.assertEquals("0x32", "0x" + Long.toHexString((byte) HANDLE_VALUE_B.get(mem, 0L)));
            default ->
                throw new RuntimeException("Unknown endianess! " + MultiarchTupelBuilder.getEndianess());
        }
    }

    @Test
    public void testUnionLayoutInMemorySegment_I_S_B() {
        UnionLayout LAYOUT__UNION_MA_L_I_S_B = MemoryLayout.unionLayout(
                ValueLayout.JAVA_INT.withName("I"),
                ValueLayout.JAVA_SHORT.withName("S"),
                ValueLayout.JAVA_BYTE.withName("B"));
        VarHandle HANDLE_VALUE_I
                = LAYOUT__UNION_MA_L_I_S_B.varHandle(MemoryLayout.PathElement.groupElement("I"));
        VarHandle HANDLE_VALUE_S
                = LAYOUT__UNION_MA_L_I_S_B.varHandle(MemoryLayout.PathElement.groupElement("S"));
        VarHandle HANDLE_VALUE_B
                = LAYOUT__UNION_MA_L_I_S_B.varHandle(MemoryLayout.PathElement.groupElement("B"));

        final Arena arena = Arena.ofConfined();
        final MemorySegment mem = arena.allocate(1024);
        HANDLE_VALUE_I.set(mem, 0L, (int) 0x76543210);
        Assertions.assertEquals("0x76543210", "0x" + Integer.toHexString((int) HANDLE_VALUE_I.get(mem, 0L)));
        switch (MultiarchTupelBuilder.getEndianess()) {
            case LITTLE -> {
                Assertions.assertEquals("0x3210", "0x" + Long.toHexString((short) HANDLE_VALUE_S.get(mem, 0L)));
                Assertions.assertEquals("0x10", "0x" + Long.toHexString((byte) HANDLE_VALUE_B.get(mem, 0L)));

            }
            case BIG -> {
                Assertions.assertEquals("0x7654", "0x" + Long.toHexString((short) HANDLE_VALUE_S.get(mem, 0L)));
                Assertions.assertEquals("0x76", "0x" + Long.toHexString((byte) HANDLE_VALUE_B.get(mem, 0L)));

            }
            default ->
                throw new RuntimeException("Unknown endianess! " + MultiarchTupelBuilder.getEndianess());
        }
    }

    @Test
    public void testUnionLayoutInMemorySegment_L_I_S_B() {
        UnionLayout LAYOUT__UNION_MA_L_I_S_B = MemoryLayout.unionLayout(
                ValueLayout.JAVA_LONG.withName("L"),
                ValueLayout.JAVA_INT.withName("I"),
                ValueLayout.JAVA_SHORT.withName("S"),
                ValueLayout.JAVA_BYTE.withName("B"));
        VarHandle HANDLE_VALUE_L
                = LAYOUT__UNION_MA_L_I_S_B.varHandle(MemoryLayout.PathElement.groupElement("L"));
        VarHandle HANDLE_VALUE_I
                = LAYOUT__UNION_MA_L_I_S_B.varHandle(MemoryLayout.PathElement.groupElement("I"));
        VarHandle HANDLE_VALUE_S
                = LAYOUT__UNION_MA_L_I_S_B.varHandle(MemoryLayout.PathElement.groupElement("S"));
        VarHandle HANDLE_VALUE_B
                = LAYOUT__UNION_MA_L_I_S_B.varHandle(MemoryLayout.PathElement.groupElement("B"));

        final Arena arena = Arena.ofConfined();
        final MemorySegment mem = arena.allocate(1024);
        HANDLE_VALUE_L.set(mem, 0L, 0xfedcba9876543210L);
        Assertions.assertEquals("0xfedcba9876543210", "0x" + Long.toHexString((long) HANDLE_VALUE_L.get(mem, 0L)));
        switch (MultiarchTupelBuilder.getEndianess()) {
            case LITTLE -> {
                Assertions.assertEquals("0x76543210", "0x" + Integer.toHexString((int) HANDLE_VALUE_I.get(mem, 0L)));
                Assertions.assertEquals("0x3210", "0x" + Integer.toHexString((short) HANDLE_VALUE_S.get(mem, 0L)));
                Assertions.assertEquals("0x10", "0x" + Integer.toHexString((byte) HANDLE_VALUE_B.get(mem, 0L)));

            }
            case BIG -> {
                Assertions.assertEquals("0xfedcba98", "0x" + Integer.toHexString((int) HANDLE_VALUE_I.get(mem, 0L)));
                Assertions.assertEquals("0xfedc", "0x" + Integer.toHexString(0xFFFF & (short) HANDLE_VALUE_S.get(mem, 0L)));
                Assertions.assertEquals("0xfe", "0x" + Integer.toHexString(0xFF & (byte) HANDLE_VALUE_B.get(mem, 0L)));
            }
            default ->
                throw new RuntimeException("Unknown endianess! " + MultiarchTupelBuilder.getEndianess());
        }
    }

    @Test
    public void testUnionLayoutInMemorySegment_MA_L_I_S_B() {
        UnionLayout LAYOUT__UNION_MA_L_I_S_B = MemoryLayout.unionLayout(
                ValueLayout.ADDRESS.withName("MA"),
                ValueLayout.JAVA_LONG.withName("L"),
                ValueLayout.JAVA_INT.withName("I"),
                ValueLayout.JAVA_SHORT.withName("S"),
                ValueLayout.JAVA_BYTE.withName("B"));
        VarHandle HANDLE_VALUE_MA
                = LAYOUT__UNION_MA_L_I_S_B.varHandle(MemoryLayout.PathElement.groupElement("MA"));
        VarHandle HANDLE_VALUE_L
                = LAYOUT__UNION_MA_L_I_S_B.varHandle(MemoryLayout.PathElement.groupElement("L"));
        VarHandle HANDLE_VALUE_I
                = LAYOUT__UNION_MA_L_I_S_B.varHandle(MemoryLayout.PathElement.groupElement("I"));
        VarHandle HANDLE_VALUE_S
                = LAYOUT__UNION_MA_L_I_S_B.varHandle(MemoryLayout.PathElement.groupElement("S"));
        VarHandle HANDLE_VALUE_B
                = LAYOUT__UNION_MA_L_I_S_B.varHandle(MemoryLayout.PathElement.groupElement("B"));

        final Arena arena = Arena.ofConfined();
        final MemorySegment mem = arena.allocate(1024);
        HANDLE_VALUE_L.set(mem, 0L, 0xfedcba9876543210L);
        MemorySegment result = (MemorySegment) HANDLE_VALUE_MA.get(mem, 0L);
        switch (MultiarchTupelBuilder.getEndianess()) {
            case LITTLE -> {
                switch (MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer) {
                    case _64_Bit ->
                        Assertions.assertEquals("0xfedcba9876543210", "0x" + Long.toHexString(result.address()));
                    case _32_Bit ->
                        Assertions.assertEquals("0x76543210", "0x" + Long.toHexString(result.address()));
                    default ->
                        throw new RuntimeException("Unknown sizeOf pointer! " + MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer);
                }
                Assertions.assertEquals("0x76543210", "0x" + Integer.toHexString((int) HANDLE_VALUE_I.get(mem, 0L)));
                Assertions.assertEquals("0x3210", "0x" + Integer.toHexString((short) HANDLE_VALUE_S.get(mem, 0L)));
                Assertions.assertEquals("0x10", "0x" + Integer.toHexString((byte) HANDLE_VALUE_B.get(mem, 0L)));

            }
            case BIG -> {
                switch (MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer) {
                    case _64_Bit ->
                        Assertions.assertEquals("0xfedcba9876543210", "0x" + Long.toHexString(result.address()));
                    case _32_Bit ->
                        Assertions.assertEquals("0xfedcba98", "0x" + Long.toHexString(result.address()));
                    default ->
                        throw new RuntimeException("Unknown sizeOf pointer! " + MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer);
                }
                Assertions.assertEquals("0xfedcba98", "0x" + Integer.toHexString((int) HANDLE_VALUE_I.get(mem, 0L)));
                Assertions.assertEquals("0xfedc", "0x" + Integer.toHexString(0xFFFF & (short) HANDLE_VALUE_S.get(mem, 0L)));
                Assertions.assertEquals("0xfe", "0x" + Integer.toHexString(0xFF & (byte) HANDLE_VALUE_B.get(mem, 0L)));
            }
            default ->
                throw new RuntimeException("Unknown endianess! " + MultiarchTupelBuilder.getEndianess());
        }

    }
    //    @Test

    public void testUnionLayoutInMethodHandle() {
        UnionLayout LAYOUT__UNION_I_MA = MemoryLayout.unionLayout(
                ValueLayout.ADDRESS.withName("value_ptr"),
                ValueLayout.JAVA_INT.withName("value_int"));
        final Linker linker = Linker.nativeLinker();
        try {
            MethodHandle mhDown = linker.downcallHandle(FunctionDescriptor.ofVoid(LAYOUT__UNION_I_MA));
            switch (MultiarchTupelBuilder.getMultiarch()) {
                case ARM__LINUX__GNU_EABI_HF, I386__LINUX__GNU ->
                    Assertions.fail("java.base/jdk.internal.foreign.abi.fallback.FFIType.toFFIType(FFIType.java:114) can handle unions correct callback code Union_MA_I__ in jnhw.common !");
                default -> {
                    Assertions.assertNotNull(mhDown);
                }
            }
        } catch (IllegalArgumentException iae) {
            switch (MultiarchTupelBuilder.getMultiarch()) {
                case ARM__LINUX__GNU_EABI_HF, I386__LINUX__GNU ->
                    Assumptions.abort("java.base/jdk.internal.foreign.abi.fallback.FFIType.toFFIType(FFIType.java:114) still can't handle unions!");
                default ->
                    throw iae;
            }
        }
    }

}
