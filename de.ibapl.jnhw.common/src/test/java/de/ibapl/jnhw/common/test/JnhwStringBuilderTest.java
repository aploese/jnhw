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
package de.ibapl.jnhw.common.test;

import de.ibapl.jnhw.common.memory.AbstractNativeMemory.SetMem;
import de.ibapl.jnhw.common.memory.Int8_t;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.common.memory.StructArray32;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class JnhwStringBuilderTest {

    private final static MultiarchTupelBuilder MULTIARCH_TUPEL_BUILDER = new MultiarchTupelBuilder();

    public class Struct32Test extends Struct32 {

        public Struct32Test(OpaqueMemory32 owner, int offset, int sizeInBytes, SetMem setMem) {
            super(owner, offset, sizeInBytes, setMem);
        }

        @Override
        public void nativeToString(Appendable sb, String indentOffset, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentOffset, indent);
            jsb.appendMember("memory", "\"", (sbu) -> OpaqueMemory32.printMemory(sbu, this, false), "\"");
            jsb.close();
        }
    }

    public static class StructArray32TestElement extends Struct32 {

        final Int8_t i0;
        final Int8_t i1;

        public StructArray32TestElement(OpaqueMemory32 parent, long offset, byte i0, byte i1) {
            super(parent, offset, 2, SetMem.DO_NOT_SET);
            this.i0 = new Int8_t(this, 0, SetMem.DO_NOT_SET);
            this.i0.int8_t(i0);
            this.i1 = new Int8_t(this, 1, SetMem.DO_NOT_SET);
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

    public static class StructArray32Test extends StructArray32<StructArray32TestElement> {

        public StructArray32Test() {
            super(new StructArray32TestElement[3], StructArray32Test::createAtOffset, 3, SetMem.TO_0x00);
        }

        private static StructArray32TestElement createAtOffset(OpaqueMemory32 parent, long offset) {
            return new StructArray32TestElement(parent, offset, (byte) 0, (byte) offset);
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
        jsb.appendStruct32Member("_struct32", new Struct32Test(null, 0, 16, SetMem.TO_0x00));
        jsb.appendStructArray32Member("array", new StructArray32Test());
        assertEquals("{_byte : 127, _char : \"a\", _int : 2147483647, _long : 9223372036854775807, _flags : [ONE, TWO], _short : 32767, _string : \"Hello!\", _struct32 : {memory : \"00000000 00000000  00000000 00000000 | ................\"}, array : [{i0 : 0x00, i1 : 0x00}, {i0 : 0x00, i1 : 0x03}, {i0 : 0x00, i1 : 0x06}]}", jsb.toString()
        );
    }

    @Test
    public void testFormatPretty() throws Exception {
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
        jsb.appendStruct32Member("_struct32", new Struct32Test(null, 0, 16, SetMem.TO_0x00));
        jsb.appendStructArray32Member("array", new StructArray32Test());
        assertEquals("{\n"
                + " _byte : 127,\n"
                + " _char : \"a\",\n"
                + " _int : 2147483647,\n"
                + " _long : 9223372036854775807,\n"
                + " _flags : [ONE, TWO],\n"
                + " _short : 32767,\n"
                + " _string : \"Hello!\",\n"
                + " _struct32 : {\n"
                + "  memory : \"00000000 00000000  00000000 00000000 | ................\"\n"
                + "  },\n"
                + " array : [\n"
                + "  {\n"
                + "   i0 : 0x00,\n"
                + "   i1 : 0x00\n"
                + "   },\n"
                + "  {\n"
                + "   i0 : 0x00,\n"
                + "   i1 : 0x03\n"
                + "   },\n"
                + "  {\n"
                + "   i0 : 0x00,\n"
                + "   i1 : 0x06\n"
                + "   }\n"
                + "  ]\n"
                + " }",
                jsb.toString());
    }

    @Test
    public void testFormatAddress() throws Exception {
        JsonStringBuilder jsb = new JsonStringBuilder("", "");
        jsb.appendNativeAddressHolderMember("_address", NativeAddressHolder.ofUintptr_t(42));
        switch (MULTIARCH_TUPEL_BUILDER.getSizeOfPointer()) {
            case _64_BIT:
                assertEquals("{_address : {address : 0x000000000000002a}}", jsb.toString());
                break;
            case _32_BIT:
                assertEquals("{_address : {address : 0x0000002a}}", jsb.toString());
                break;
            default:
                throw new RuntimeException();
        }
    }

}
