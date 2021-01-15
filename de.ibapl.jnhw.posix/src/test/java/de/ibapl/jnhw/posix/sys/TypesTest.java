/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.posix.sys;

import de.ibapl.jnhw.common.datatypes.BaseDataTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aploese
 */
public class TypesTest {
    
    public TypesTest() {
    }
    
    @Test
    public void testPid_t() {
        Assertions.assertEquals(4, Types.Pid_t.sizeof());
        Assertions.assertEquals(4, Types.Pid_t.alignof());
        Assertions.assertFalse(Types.Pid_t.unsigned());
        Types.Pid_t instance = new Types.Pid_t(true);
        instance.setValue(0x80706050);
        assertEquals(0x80706050, instance.getValue());
        assertEquals(Integer.toString(0x80706050), instance.nativeToString());
    }
    
    @Test
    public void testOff_t() {
        Assertions.assertFalse(Types.Off_t.unsigned());
        Types.Off_t instance = new Types.Off_t(true);
        if (Types.Off_t.sizeof() == 4) {
            Assertions.assertEquals(4, Types.Off_t.alignof());
            assertEquals(BaseDataTypes.int32_t, instance.getBaseDataType());
            instance.setValue(0x80706050);
            assertEquals(0x80706050, instance.getValue());
            assertEquals(Integer.toString(0x80706050), instance.nativeToString());
            assertEquals("80706050", instance.nativeToHexString());
            fail("missing test too small too big");
        } else if (Types.Off_t.sizeof() == 8){
            Assertions.assertEquals(8, Types.Off_t.alignof());
            assertEquals(BaseDataTypes.int64_t, instance.getBaseDataType());
            instance.setValue(0x8070605040302010L);
            assertEquals(0x8070605040302010L, instance.getValue());
            assertEquals(Long.toString(0x8070605040302010L), instance.nativeToString());
            assertEquals("8070605040302010", instance.nativeToHexString());
        } else {
            fail();
        }
    }
    
    @Test
    public void testSize_t() {
        Assertions.assertTrue(Types.Size_t.unsigned());
        Types.Size_t instance = new Types.Size_t(true);
        if (Types.Off_t.sizeof() == 4) {
            Assertions.assertEquals(4, Types.Size_t.alignof());
            assertEquals(BaseDataTypes.uint32_t, instance.getBaseDataType());
            instance.setValue(0x80706050);
            assertEquals(0x80706050, instance.getValue());
            assertEquals(Integer.toUnsignedString(0x80706050), instance.nativeToString());
            assertEquals("80706050", instance.nativeToHexString());
            fail("missing test too small too big");
        } else if (Types.Off_t.sizeof() == 8){
            Assertions.assertEquals(8, Types.Size_t.alignof());
            assertEquals(BaseDataTypes.uint64_t, instance.getBaseDataType());
            instance.setValue(0x8070605040302010L);
            assertEquals(0x8070605040302010L, instance.getValue());
            assertEquals(Long.toUnsignedString(0x8070605040302010L), instance.nativeToString());
            assertEquals("8070605040302010", instance.nativeToHexString());
        } else {
            fail();
        }
    }
    
    @Test
    public void testSsize_t() {
        Assertions.assertFalse(Types.Ssize_t.unsigned());
        Types.Ssize_t instance = new Types.Ssize_t(true);
        if (Types.Ssize_t.sizeof() == 4) {
            Assertions.assertEquals(4, Types.Ssize_t.alignof());
            assertEquals(BaseDataTypes.int32_t, instance.getBaseDataType());
            instance.setValue(0x80706050);
            assertEquals(0x80706050, instance.getValue());
            assertEquals(Integer.toString(0x80706050), instance.nativeToString());
            assertEquals("80706050", instance.nativeToHexString());
            fail("missing test too small too big");
        } else if (Types.Ssize_t.sizeof() == 8){
            Assertions.assertEquals(8, Types.Ssize_t.alignof());
            assertEquals(BaseDataTypes.int64_t, instance.getBaseDataType());
            instance.setValue(0x8070605040302010L);
            assertEquals(0x8070605040302010L, instance.getValue());
            assertEquals(Long.toString(0x8070605040302010L), instance.nativeToString());
            assertEquals("8070605040302010", instance.nativeToHexString());
        } else {
            fail();
        }
    }
    

}
