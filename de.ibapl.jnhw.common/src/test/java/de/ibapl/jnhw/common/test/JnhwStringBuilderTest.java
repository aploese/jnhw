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
package de.ibapl.jnhw.common.test;

import de.ibapl.jnhw.common.datatypes.MultiarchTupelBuilder;
import de.ibapl.jnhw.common.memory.Int8_t;
import de.ibapl.jnhw.common.memory.MemoryArray;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.memory.Struct;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import java.io.IOException;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class JnhwStringBuilderTest {

    public class StructTest extends Struct {

        public StructTest(MemorySegment memorySegment) {
            super(memorySegment, 0, memorySegment.byteSize());
        }

        @Override
        public void nativeToString(Appendable sb, String indentOffset, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentOffset, indent);
            jsb.appendMember("memory", "\"", (sbu) -> OpaqueMemory.printMemory(sbu, this, false), "\"");
            jsb.close();
        }
    }

    public static class MemoryArrayTestElement extends Struct {

        final Int8_t i0;
        final Int8_t i1;

        public MemoryArrayTestElement(MemorySegment memorySegment, long offset, byte i0, byte i1) {
            super(memorySegment, offset, 2);
            this.i0 = Int8_t.map(this, 0);
            this.i0.int8_t(i0);
            this.i1 = Int8_t.map(this, 1);
            this.i1.int8_t(i1);
        }

        @Override
        public void nativeToString(Appendable sb, String indentOffset, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentOffset, indent);
            jsb.appendHexByteMember("i0", i0.int8_t());
            jsb.appendHexByteMember("i1", i1.int8_t());
            jsb.close();
        }
    }

    public static class MemoryArrayTest extends MemoryArray<MemoryArrayTestElement> {

        public MemoryArrayTest(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, new MemoryArrayTestElement[3], MemoryArrayTest::createAtOffset, 3);
        }

        private static MemoryArrayTestElement createAtOffset(MemorySegment memorySegment, long elementOffset, int index) {
            return new MemoryArrayTestElement(memorySegment, elementOffset, (byte) 0, (byte) index);
        }

    }

    public JnhwStringBuilderTest() {
    }

    @Test
    public void testFormatState() throws Exception {
        JsonStringBuilder jsbc = new JsonStringBuilder("", "");
        assertEquals("{}", jsbc.toString());
        assertThrows(IllegalStateException.class, () -> jsbc.appendByteMember("_byte", Byte.MAX_VALUE));

        JsonStringBuilder jsbp = new JsonStringBuilder("  ", " ");
        assertEquals(
                "{\n"
                + "   \n"
                + "   }", jsbp.toString());
        assertThrows(IllegalStateException.class, () -> jsbp.appendByteMember("_byte", Byte.MAX_VALUE));
    }

    @Test
    public void testFormatHex() throws Exception {
        JsonStringBuilder jsb = new JsonStringBuilder("", "");
        jsb.appendHexByteMember("_byte", Byte.MAX_VALUE);
        jsb.appendHexIntMember("_int", Integer.MAX_VALUE);
        jsb.appendHexLongMember("_long", Long.MAX_VALUE);
        jsb.appendHexShortMember("_short", Short.MAX_VALUE);
        assertEquals("{_byte : 0x7f, _int : 0x7fffffff, _long : 0x7fffffffffffffff, _short : 0x7fff}", jsb.toString());
    }

    @Test
    public void testFormatCompact() throws Exception {
        try ( MemorySession ms = MemorySession.openConfined()) {
            JsonStringBuilder jsb = new JsonStringBuilder("", "");
            jsb.appendByteMember("_byte", Byte.MAX_VALUE);
            jsb.appendCharMember("_char", 'a');
            jsb.appendIntMember("_int", Integer.MAX_VALUE);
            jsb.appendLongMember("_long", Long.MAX_VALUE);
            jsb.appendMember("_flags", "[", (sb) -> {
                sb.append("ONE").append(", ").append("TWO");
            }, "]");
            jsb.appendShortMember("_short", Short.MAX_VALUE);
            jsb.appendStringMember("_string", "Hello!");
            jsb.appendStruct32Member("_struct32", new StructTest(MemorySegment.allocateNative(16, ms)));
            jsb.appendStructArray32Member("array", new MemoryArrayTest(MemorySegment.allocateNative(12, ms), 0));
            assertEquals("{_byte : 127, _char : \"a\", _int : 2147483647, _long : 9223372036854775807, _flags : [ONE, TWO], _short : 32767, _string : \"Hello!\", _struct32 : {memory : \"00000000 00000000  00000000 00000000 | \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\"}, array : [{i0 : 0x00, i1 : 0x00}, {i0 : 0x00, i1 : 0x01}, {i0 : 0x00, i1 : 0x02}]}", jsb.toString()
            );
        }
    }

    @Test
    public void testFormatPretty() throws Exception {
        try ( MemorySession ms = MemorySession.openConfined()) {
            JsonStringBuilder jsb = new JsonStringBuilder("", " ");
            jsb.appendByteMember("_byte", Byte.MAX_VALUE);
            jsb.appendCharMember("_char", 'a');
            jsb.appendIntMember("_int", Integer.MAX_VALUE);
            jsb.appendLongMember("_long", Long.MAX_VALUE);
            jsb.appendMember("_flags", "[", (sb) -> {
                sb.append("ONE").append(", ").append("TWO");
            }, "]");
            jsb.appendShortMember("_short", Short.MAX_VALUE);
            jsb.appendStringMember("_string", "Hello!");
            jsb.appendStruct32Member("_struct32", new StructTest(MemorySegment.allocateNative(16, ms)));
            jsb.appendStructArray32Member("array", new MemoryArrayTest(MemorySegment.allocateNative(12, ms), 0));
            assertEquals("""
                         {
                          _byte : 127,
                          _char : "a",
                          _int : 2147483647,
                          _long : 9223372036854775807,
                          _flags : [ONE, TWO],
                          _short : 32767,
                          _string : "Hello!",
                          _struct32 : {
                           memory : "00000000 00000000  00000000 00000000 | \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000"
                           },
                          array : [
                           {
                            i0 : 0x00,
                            i1 : 0x00
                            },
                           {
                            i0 : 0x00,
                            i1 : 0x01
                            },
                           {
                            i0 : 0x00,
                            i1 : 0x02
                            }
                           ]
                          }""",
                    jsb.toString());
        }
    }

    @Test
    public void testFormatAddress() throws Exception {
        JsonStringBuilder jsb = new JsonStringBuilder("", "");
        jsb.appendAddressMember("_address", MemoryAddress.ofLong(42));
        switch (MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer) {
            case _64_BIT ->
                assertEquals("{_address : 0x000000000000002a}", jsb.toString());
            case _32_BIT ->
                assertEquals("{_address : 0x0000002a}", jsb.toString());
            default ->
                throw new RuntimeException();
        }
    }
}
