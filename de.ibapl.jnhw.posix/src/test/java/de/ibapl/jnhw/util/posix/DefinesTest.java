/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.util.posix;

import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.util.IntDefine;
import de.ibapl.jnhw.common.util.ObjectDefine;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.posix.LibJnhwPosixTestLoader;
import java.lang.reflect.Field;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * Test all symbolic constants XXX that are defined with #define XXX
 *
 * @author aploese
 */
public class DefinesTest {

    public static void testDefines(Class<?> javaDefines, String haveHeaderName) throws Exception {
        testDefines(javaDefines, haveHeaderName, null);
    }

    public static void testDefines(Class<?> javaDefines, String haveHeaderName, ObjectResolver objectResolver) throws Exception {
        Stream.Builder<Executable> streamBuilder = Stream.builder();

        for (Field f : javaDefines.getFields()) {
            if (f.getAnnotation(Define.class) != null) {
                final Class<?> type = f.getType();
                if (Long.class.equals(type) || Integer.class.equals(type) || Short.class.equals(type) || Byte.class.equals(type)) {
                    throw new AssertionError("Unexpected type " + type + " for " + f.getName());
                } else if (long.class.equals(type)) {
                    streamBuilder.accept(() -> {
                        assertEquals(LibJnhwPosixTestLoader.getLongDefine(f.getName()), f.getLong(javaDefines), f.getName());
                    });
                } else if (int.class.equals(type)) {
                    streamBuilder.accept(() -> {
                        assertEquals(LibJnhwPosixTestLoader.getIntDefine(f.getName()), f.getInt(javaDefines), f.getName());
                    });
                } else if (short.class.equals(type)) {
                    streamBuilder.accept(() -> {
                        assertEquals(LibJnhwPosixTestLoader.getShortDefine(f.getName()), f.getShort(javaDefines), f.getName());
                    });
                } else if (byte.class.equals(type)) {
                    streamBuilder.accept(() -> {
                        assertEquals(LibJnhwPosixTestLoader.getByteDefine(f.getName()), f.getByte(javaDefines), f.getName());
                    });
                } else if (IntDefine.class.equals(type)) {
                    Integer nativeResult = LibJnhwPosixTestLoader.getClassIntegerDefine(f.getName());
                    if (nativeResult == null) {
                        streamBuilder.accept(() -> {
                            assertFalse(((IntDefine) f.get(javaDefines)).isDefined(), () -> {
                                return f.getName() + " is defined";
                            });
                        });
                    } else {
                        streamBuilder.accept(() -> {
                            assertTrue(((IntDefine) f.get(javaDefines)).isDefined(), () -> {
                                return f.getName() + " is not defined";
                            });
                            assertEquals(nativeResult, ((IntDefine) f.get(javaDefines)).get(), f.getName());
                        });
                    }
                } else if (ObjectDefine.class.equals(type)) {
                    if (objectResolver == null) {
                        throw new IllegalArgumentException("No objectResolver for: " + f.getName());
                    }
                    ObjectDefine<?> nativeResult = (ObjectDefine) objectResolver.invoke(f.getName());
                    if (nativeResult.isDefined()) {
                        streamBuilder.accept(() -> {
                            assertTrue(((ObjectDefine) f.get(javaDefines)).isDefined(), () -> {
                                return f.getName() + " is not defined";
                            });
                            assertEquals(nativeResult.get(), ((ObjectDefine) f.get(javaDefines)).get(), f.getName());
                        });
                    } else {
                        streamBuilder.accept(() -> {
                            assertFalse(((ObjectDefine) f.get(javaDefines)).isDefined(), () -> {
                                return f.getName() + " is defined";
                            });
                            assertEquals(nativeResult, ((ObjectDefine) f.get(javaDefines)).get(), f.getName());
                        });

                    }
                } else if (Object.class.isAssignableFrom(type)) {
                    if (objectResolver == null) {
                        throw new IllegalArgumentException("No objectResolver for: " + f.getName());
                    }
                    Object nativeResult = objectResolver.invoke(f.getName());
                    if (nativeResult == null) {
                        streamBuilder.accept(() -> {
                            assertNull(f.get(javaDefines), () -> {
                                return f.getName() + " is not null";
                            });
                        });
                    } else {
                        streamBuilder.accept(() -> {
                            assertEquals(nativeResult, f.get(javaDefines), f.getName());
                        });
                    }
                } else {
                    streamBuilder.accept(() -> {
                        fail("Implement Any Define! " + f.getName() + " " + type);
                    });
                }
            } else if (haveHeaderName.equals(f.getName())) {
                streamBuilder.accept(() -> {
                    assertEquals(LibJnhwPosixTestLoader.getIntDefine(f.getName()) != 0, f.getBoolean(javaDefines), haveHeaderName);
                });
            }
        }
        assertAll(streamBuilder.build());
    }

    public static void printDefines(Class clazz) throws Exception {
        System.out.println(clazz.getName() + " Defines: >>>");
        for (Field f : clazz.getFields()) {
            if (f.getAnnotation(Define.class) != null) {
                Class type = f.getType();
                if (Long.class.equals(type) || long.class.equals(type)) {
                    System.out.println(String.format("\t%-30s = 0x%2$016x | %2$d", f.getName(), f.getLong(clazz)));
                } else if (Integer.class.equals(type) || int.class.equals(type)) {
                    System.out.println(String.format("\t%-30s = 0x%2$08x | %2$d", f.getName(), f.getInt(clazz)));
                } else if (Short.class.equals(type) || short.class.equals(type)) {
                    System.out.println(String.format("\t%-30s = 0x%2$04x | %2$d", f.getName(), f.getShort(clazz)));
                } else if (Byte.class.equals(type) || byte.class.equals(type)) {
                    System.out.println(String.format("\t%-30s = 0x%2$02x | %2$d", f.getName(), f.getByte(clazz)));
                } else if (IntDefine.class.equals(type)) {
                    IntDefine def = (IntDefine) f.get(clazz);
                    assertNotNull(def, clazz.getName() + "#" + f.getName());
                    if (def.isDefined()) {
                        System.out.println(String.format("\t%-30s = 0x%2$08x | %2$d", f.getName(), def.get()));
                    } else {
                        System.out.println(String.format("\t%-30s ... is not defined", f.getName()));
                    }
                } else {
                    System.out.println(String.format("\t%-30s = \"%s\"", f.getName(), f.get(clazz)));
                }
            }
        }
        System.out.println("<<< " + clazz.getName() + " Defines");
    }

    @Test
    public void test_NativeDefines() throws Exception {
        DefinesTest.testDefines(Defines.class, null);
    }

    /**
     * Test of _LARGEFILE64_SOURCE method, of class Defines.
     */
    @Test
    public void test_LARGEFILE64_SOURCE() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX -> {
                switch (Defines.__SIZEOF_LONG__) {
                    case 4 ->
                        assertTrue(Defines._LARGEFILE64_SOURCE.get() != 0);
                    case 8 ->
                        assertTrue(Defines._LARGEFILE64_SOURCE.get() != 0);
                    default ->
                        fail("no case for this size of long:" + Defines.__SIZEOF_LONG__);
                }
            }

            case FREE_BSD, OPEN_BSD, DARWIN, WINDOWS ->
                assertFalse(Defines._LARGEFILE64_SOURCE.isDefined());
            default ->
                fail("No testcase for OS: " + MultiarchTupelBuilder.getOS());
        }
    }

    /**
     * Test of _LARGEFILE_SOURCE method, of class Defines.
     */
    @Test
    public void test_LARGEFILE_SOURCE() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX -> {
                switch (Defines.__SIZEOF_LONG__) {
                    case 4 ->
                        assertTrue(Defines._LARGEFILE_SOURCE.get() != 0);
                    case 8 ->
                        assertTrue(Defines._LARGEFILE_SOURCE.get() != 0);
                    default ->
                        fail("no case for this size of long:" + Defines.__SIZEOF_LONG__);
                }
            }

            case FREE_BSD, OPEN_BSD, DARWIN, WINDOWS ->
                assertFalse(Defines._LARGEFILE_SOURCE.isDefined());
            default ->
                fail("No testcase for OS: " + MultiarchTupelBuilder.getOS());
        }
    }

    /**
     * Test of _FILE_OFFSET_BITS method, of class Defines.
     */
    @Test
    public void test_FILE_OFFSET_BITS() throws Exception {
        assertFalse(Defines._FILE_OFFSET_BITS.isDefined());
    }

    /**
     * Test of _POSIX_C_SOURCE method, of class Defines.
     */
    @Test
    public void test_POSIX_C_SOURCE() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX, FREE_BSD, OPEN_BSD, DARWIN ->
                assertEquals(200809, Defines._POSIX_C_SOURCE.get());
            case WINDOWS ->
                assertFalse(Defines._POSIX_C_SOURCE.isDefined());
            default ->
                fail("No testcase for OS: " + MultiarchTupelBuilder.getOS());
        }
    }

    /**
     * Test of _XOPEN_SOURCE method, of class Defines.
     */
    @Test
    public void test_XOPEN_SOURCE() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX, FREE_BSD, OPEN_BSD, DARWIN ->
                assertEquals(700, Defines._XOPEN_SOURCE.get());
            case WINDOWS ->
                assertFalse(Defines._XOPEN_SOURCE.isDefined());
            default ->
                fail("No testcase for OS: " + MultiarchTupelBuilder.getOS());
        }
    }

    /**
     * Test of _XOPEN_SOURCE_EXTENDED method, of class Defines.
     */
    @Test
    public void test_XOPEN_SOURCE_EXTENDED() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX, FREE_BSD, OPEN_BSD, DARWIN ->
                assertEquals(1, Defines._XOPEN_SOURCE_EXTENDED.get());
            case WINDOWS ->
                assertFalse(Defines._XOPEN_SOURCE_EXTENDED.isDefined());
            default ->
                fail("No testcase for OS: " + MultiarchTupelBuilder.getOS());
        }
    }

    /**
     * Test of __APPLE__ method, of class Defines.
     */
    @Test
    public void test__APPLE__() {
        assertEquals(MultiarchTupelBuilder.getOS() == OS.DARWIN, Defines.__APPLE__.isDefined());
    }

    /**
     * Test of __FreeBSD__ method, of class Defines.
     */
    @Test
    public void test__FreeBSD__() {
        assertEquals(MultiarchTupelBuilder.getOS() == OS.FREE_BSD, Defines.__FreeBSD__.isDefined());
    }

    /**
     * Test of __WORDSIZE method, of class Defines.
     */
    @Test
    public void test__WORDSIZE() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case OPEN_BSD, WINDOWS ->
                assertFalse(Defines.__WORDSIZE.isDefined());
            default -> {
                assertEquals(MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer.sizeInBit, Defines.__WORDSIZE.get(), "size of pointer != wordsize");
                assertEquals(MultiarchTupelBuilder.getMemoryModel().sizeOf_long.sizeInBit, Defines.__WORDSIZE.get(), "size of long != wordsize");
            }
        }
    }

    /**
     * Test of __linux__ method, of class Defines.
     */
    @Test
    public void test__linux__() {
        assertEquals(MultiarchTupelBuilder.getOS() == OS.LINUX, Defines.__linux__.isDefined());
    }

    @Test
    public void test__ORDER_LITTLE_ENDIAN__() throws Exception {
        assertEquals(1234, Defines.__ORDER_LITTLE_ENDIAN__);
    }

    @Test
    public void test__ORDER_BIG_ENDIAN__() throws Exception {
        assertEquals(4321, Defines.__ORDER_BIG_ENDIAN__);
    }

    @Test
    public void test__ORDER_PDP_ENDIAN__() throws Exception {
        assertEquals(3412, Defines.__ORDER_PDP_ENDIAN__);
    }

    @Test
    public void test__BYTE_ORDER__() throws Exception {
        switch (MultiarchTupelBuilder.getEndianess()) {
            case BIG:
                assertEquals(Defines.__ORDER_BIG_ENDIAN__, Defines.__BYTE_ORDER__);
                break;
            case LITTLE:
                assertEquals(Defines.__ORDER_LITTLE_ENDIAN__, Defines.__BYTE_ORDER__);
                break;
        }
    }

    @Test
    public void test__GNU_LIBRARY__() throws Exception {
        if (Defines.__GNU_LIBRARY__.isDefined()) {
            assertTrue(Defines.__GLIBC__.isDefined(), "__GLIBC__");
            assertTrue(Defines.__GLIBC_MINOR__.isDefined(), "__GLIBC_MINOR__");
        }
    }

    @FunctionalInterface
    public interface ObjectResolver {

        Object invoke(String name);
    }

}
