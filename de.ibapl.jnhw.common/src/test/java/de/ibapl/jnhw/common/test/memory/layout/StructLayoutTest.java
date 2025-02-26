/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2021-2025, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.test.JnhwTestLogger;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.UnionLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.VarHandle;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 *
 * @author aploese
 */
public class StructLayoutTest {

    @BeforeAll
    public static void setUpBeforeClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeAll(testTnfo);
    }

    @AfterAll
    public static void tearDownAfterClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterAll(testTnfo);
    }

    @BeforeEach
    public void setUpBeforeEach(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeEach(testTnfo);
    }

    @AfterEach
    public void tearDownAfterEach(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterEach(testTnfo);
    }

    private int alignOf_struct_EMPTY() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_struct_EMPTY");
    }

    private int sizeOf_struct_EMPTY() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("sizeOf_struct_EMPTY");
    }

    private int alignOf_struct_int8_t() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_struct_int8_t");
    }

    private int sizeOf_struct_int8_t() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("sizeOf_struct_int8_t");
    }

    private int alignOf_struct_int16_t() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_struct_int16_t");
    }

    private int sizeOf_struct_int16_t() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("sizeOf_struct_int16_t");
    }

    private int alignOf_struct_int32_t() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_struct_int32_t");
    }

    private int sizeOf_struct_int32_t() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("sizeOf_struct_int32_t");
    }

    private int alignOf_struct_int64_t() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_struct_int64_t");
    }

    private int sizeOf_struct_int64_t() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("sizeOf_struct_int64_t");
    }

    private int alignOf_struct_intptr_t() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_struct_intptr_t");
    }

    private int sizeOf_struct_intptr_t() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("sizeOf_struct_intptr_t");
    }

    private int alignOf_struct_pointer() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_struct_pointer");
    }

    private int sizeOf_struct_pointer() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("sizeOf_struct_pointer");
    }

    private int alignOf_struct_int() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_struct_int");
    }

    private int sizeOf_struct_int() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("sizeOf_struct_int");
    }

    private int alignOf_struct_long() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_struct_long");
    }

    private int sizeOf_struct_long() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("sizeOf_struct_long");
    }

    private int alignOf_struct_long_long() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_struct_long_long");
    }

    private int sizeOf_struct_long_long() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("sizeOf_struct_long_long");
    }

    private int alignOf_struct_float() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_struct_float");
    }

    private int sizeOf_struct_float() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("sizeOf_struct_float");
    }

    private int alignOf_struct_double() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_struct_double");
    }

    private int sizeOf_struct_double() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("sizeOf_struct_double");
    }

    private int alignOf_struct_long_double() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_struct_long_double");
    }

    private int sizeOf_struct_long_double() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("sizeOf_struct_long_double");
    }

    @Test
    public void testStruct_EMPTY() {
        Assertions.assertEquals(alignOf_struct_EMPTY(), 1, "alignment in struct ");
        Assertions.assertEquals(sizeOf_struct_EMPTY(), 0, "size ");
    }

    @Test
    public void testStruct_Int8_t() {
        Assertions.assertEquals(alignOf_struct_int8_t(), BaseDataType.int8_t.ALIGNMENT_IN_STRUCT.alignof, "alignment in struct ");
        Assertions.assertEquals(sizeOf_struct_int8_t(), BaseDataType.int8_t.byteSize, "size ");
    }

    @Test
    public void testStruct_Int16_t() {
        Assertions.assertEquals(alignOf_struct_int16_t(), BaseDataType.int16_t.ALIGNMENT_IN_STRUCT.alignof, "alignment in struct ");
        Assertions.assertEquals(sizeOf_struct_int16_t(), BaseDataType.int16_t.byteSize, "size ");
    }

    @Test
    public void testStruct_Int32_t() {
        Assertions.assertEquals(alignOf_struct_int32_t(), BaseDataType.int32_t.ALIGNMENT_IN_STRUCT.alignof, "alignment in struct ");
        Assertions.assertEquals(sizeOf_struct_int32_t(), BaseDataType.int32_t.byteSize, "size ");
    }

    @Test
    public void testStruct_Int64_t() {
        Assertions.assertEquals(alignOf_struct_int64_t(), BaseDataType.int64_t.ALIGNMENT_IN_STRUCT.alignof, "alignment in struct ");
        Assertions.assertEquals(sizeOf_struct_int64_t(), BaseDataType.int64_t.byteSize, "size ");
    }

    @Test
    public void testStruct_int() {
        Assertions.assertEquals(alignOf_struct_int(), BaseDataType.C_int.ALIGNMENT_IN_STRUCT.alignof, "alignment in struct ");
        Assertions.assertEquals(sizeOf_struct_int(), BaseDataType.C_int.byteSize, "size ");
    }

    @Test
    public void testStruct_long() {
        Assertions.assertEquals(alignOf_struct_long(), BaseDataType.C_long.ALIGNMENT_IN_STRUCT.alignof, "alignment in struct ");
        Assertions.assertEquals(sizeOf_struct_long(), BaseDataType.C_long.byteSize, "size ");
    }

    @Test
    public void testStruct_long_long() {
        Assertions.assertEquals(alignOf_struct_long_long(), BaseDataType.C_long_long.ALIGNMENT_IN_STRUCT.alignof, "alignment in struct ");
        Assertions.assertEquals(sizeOf_struct_long_long(), BaseDataType.C_long_long.byteSize, "size ");
    }

    @Test
    public void testStruct_intptr_t() {
        Assertions.assertEquals(alignOf_struct_intptr_t(), BaseDataType.intptr_t.ALIGNMENT_IN_STRUCT.alignof, "alignment in struct ");
        Assertions.assertEquals(sizeOf_struct_intptr_t(), BaseDataType.intptr_t.byteSize, "size ");

        //The same for (void*)
        Assertions.assertEquals(alignOf_struct_pointer(), BaseDataType.intptr_t.ALIGNMENT_IN_STRUCT.alignof, "alignment in struct ");
        Assertions.assertEquals(sizeOf_struct_pointer(), BaseDataType.intptr_t.byteSize, "size ");
    }

    @Test
    public void testStruct_float() {
        Assertions.assertEquals(alignOf_struct_float(), BaseDataType._float.ALIGNMENT_IN_STRUCT.alignof, "alignment in struct ");
        Assertions.assertEquals(sizeOf_struct_float(), BaseDataType._float.byteSize, "size ");
    }

    @Test
    public void testStruct_double() {
        Assertions.assertEquals(alignOf_struct_double(), BaseDataType._double.ALIGNMENT_IN_STRUCT.alignof, "alignment in struct in struct ");
        Assertions.assertEquals(sizeOf_struct_double(), BaseDataType._double.byteSize, "size ");
    }

    @Test
    public void testStruct_long_double() {
        Assertions.assertEquals(alignOf_struct_long_double(), BaseDataType._long_double.ALIGNMENT_IN_STRUCT.alignof, "alignment in struct ");
        Assertions.assertEquals(sizeOf_struct_long_double(), BaseDataType._long_double.byteSize, "size ");
    }

    @Test
    public void testDefinedLayout() {
        S_i8_i64Impl.Layout definedLayout = new S_i8_i64Impl.Layout();

        Assertions.assertEquals(0, definedLayout.offsetof_0_i8);
        Assertions.assertEquals(2, definedLayout.offsetof_1_i16);
        Assertions.assertEquals(4, definedLayout.offsetof_2_i8);
        Assertions.assertEquals(8, definedLayout.offsetof_3_i32);
        Assertions.assertEquals(12, definedLayout.offsetof_4_i8);
        Assertions.assertEquals(16, definedLayout.offsetof_5_i64);
        Assertions.assertEquals(24, definedLayout.offsetof_6_i8);
        switch (MultiarchTupelBuilder.getArch()) {
            case I386 -> {
                Assertions.assertEquals(28, definedLayout.offsetof_7_i64);
                Assertions.assertEquals(36, definedLayout.offsetof_8_i8);
                Assertions.assertEquals(40, definedLayout.offsetof_9_i32);
                Assertions.assertEquals(44, definedLayout.offsetof_10_i8);
                Assertions.assertEquals(46, definedLayout.offsetof_11_i16);
                Assertions.assertEquals(48, definedLayout.offsetof_12_i8);
                Assertions.assertEquals(52, definedLayout.sizeof);
                Assertions.assertEquals(Alignment.AT_4, definedLayout.alignment);
            }
            default -> {
                Assertions.assertEquals(32, definedLayout.offsetof_7_i64);
                Assertions.assertEquals(40, definedLayout.offsetof_8_i8);
                Assertions.assertEquals(44, definedLayout.offsetof_9_i32);
                Assertions.assertEquals(48, definedLayout.offsetof_10_i8);
                Assertions.assertEquals(50, definedLayout.offsetof_11_i16);
                Assertions.assertEquals(52, definedLayout.offsetof_12_i8);
                Assertions.assertEquals(56, definedLayout.sizeof);
                Assertions.assertEquals(Alignment.AT_8, definedLayout.alignment);
            }
        }
    }

    @Test
    public void testNativeLayout() {
        S_i8_i64Impl.Layout nativeLayout = new S_i8_i64Impl.Layout();

        Assertions.assertEquals(0, nativeLayout.offsetof_0_i8);
        Assertions.assertEquals(2, nativeLayout.offsetof_1_i16);
        Assertions.assertEquals(4, nativeLayout.offsetof_2_i8);
        Assertions.assertEquals(8, nativeLayout.offsetof_3_i32);
        Assertions.assertEquals(12, nativeLayout.offsetof_4_i8);
        Assertions.assertEquals(16, nativeLayout.offsetof_5_i64);
        Assertions.assertEquals(24, nativeLayout.offsetof_6_i8);
        switch (MultiarchTupelBuilder.getArch()) {
            case I386 -> {
                Assertions.assertEquals(28, nativeLayout.offsetof_7_i64);
                Assertions.assertEquals(36, nativeLayout.offsetof_8_i8);
                Assertions.assertEquals(40, nativeLayout.offsetof_9_i32);
                Assertions.assertEquals(44, nativeLayout.offsetof_10_i8);
                Assertions.assertEquals(46, nativeLayout.offsetof_11_i16);
                Assertions.assertEquals(48, nativeLayout.offsetof_12_i8);
                Assertions.assertEquals(52, nativeLayout.sizeof);
                Assertions.assertEquals(Alignment.AT_4, nativeLayout.alignment);
            }
            default -> {
                Assertions.assertEquals(32, nativeLayout.offsetof_7_i64);
                Assertions.assertEquals(40, nativeLayout.offsetof_8_i8);
                Assertions.assertEquals(44, nativeLayout.offsetof_9_i32);
                Assertions.assertEquals(48, nativeLayout.offsetof_10_i8);
                Assertions.assertEquals(50, nativeLayout.offsetof_11_i16);
                Assertions.assertEquals(52, nativeLayout.offsetof_12_i8);
                Assertions.assertEquals(56, nativeLayout.sizeof);
                Assertions.assertEquals(Alignment.AT_8, nativeLayout.alignment);
            }
        }

        Assertions.assertEquals(S_i8_i64Impl.offsetOf_0_i8(), nativeLayout.offsetof_0_i8);
        Assertions.assertEquals(S_i8_i64Impl.offsetOf_1_i16(), nativeLayout.offsetof_1_i16);
        Assertions.assertEquals(S_i8_i64Impl.offsetOf_2_i8(), nativeLayout.offsetof_2_i8);
        Assertions.assertEquals(S_i8_i64Impl.offsetOf_3_i32(), nativeLayout.offsetof_3_i32);
        Assertions.assertEquals(S_i8_i64Impl.offsetOf_4_i8(), nativeLayout.offsetof_4_i8);
        Assertions.assertEquals(S_i8_i64Impl.offsetOf_5_i64(), nativeLayout.offsetof_5_i64);
        Assertions.assertEquals(S_i8_i64Impl.offsetOf_6_i8(), nativeLayout.offsetof_6_i8);
        Assertions.assertEquals(S_i8_i64Impl.offsetOf_7_i64(), nativeLayout.offsetof_7_i64);
        Assertions.assertEquals(S_i8_i64Impl.offsetOf_8_i8(), nativeLayout.offsetof_8_i8);
        Assertions.assertEquals(S_i8_i64Impl.offsetOf_9_i32(), nativeLayout.offsetof_9_i32);
        Assertions.assertEquals(S_i8_i64Impl.offsetOf_10_i8(), nativeLayout.offsetof_10_i8);
        Assertions.assertEquals(S_i8_i64Impl.offsetOf_11_i16(), nativeLayout.offsetof_11_i16);
        Assertions.assertEquals(S_i8_i64Impl.offsetOf_12_i8(), nativeLayout.offsetof_12_i8);
        Assertions.assertEquals(S_i8_i64Impl.sizeOf(), nativeLayout.sizeof);
        Assertions.assertEquals(S_i8_i64Impl.alignOf(), nativeLayout.alignment.alignof);

    }

    @Test
    public void testForeignUnion_I_MA() {
        final UnionLayout LAYOUT__UNION_I_MA = MemoryLayout.unionLayout(
                ValueLayout.ADDRESS.withName("value_ptr"),
                ValueLayout.JAVA_INT.withName("value_int")
        );

        final VarHandle HANDLE_VALUE_PTR
                = LAYOUT__UNION_I_MA.varHandle(MemoryLayout.PathElement.groupElement("value_ptr"));
        final VarHandle HANDLE_VALUE_INT
                = LAYOUT__UNION_I_MA.varHandle(MemoryLayout.PathElement.groupElement("value_int"));

        try (Arena a = Arena.ofConfined()) {
            MemorySegment seg = a.allocate(LAYOUT__UNION_I_MA);
            HANDLE_VALUE_INT.set(seg, 0L, 42);
            Assertions.assertEquals(42, HANDLE_VALUE_INT.get(seg, 0L));

            HANDLE_VALUE_PTR.set(seg, 0L, MemorySegment.ofAddress(11));
            Assertions.assertEquals(11, ((MemorySegment) HANDLE_VALUE_PTR.get(seg, 0L)).address());
        }
    }

}
