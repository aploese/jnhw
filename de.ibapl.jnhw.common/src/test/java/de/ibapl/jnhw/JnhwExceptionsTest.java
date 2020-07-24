/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2019, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class JnhwExceptionsTest {

    private static native void throwNativeErrorException(int errno) throws NativeErrorException;

    private static native void throwNotDefinedException() throws NotDefinedException;

    private static native void throwNoSuchNativeMethodException() throws NoSuchNativeMethodException;

    private static native void throwNoSuchTypeException() throws NoSuchNativeTypeMemberException;

    private static native void throwNoSuchTypeMemberException() throws NoSuchNativeTypeMemberException;

    private static native void throwNullPointerException() throws NullPointerException;

    private static native void throwArrayIndexOutOfBoundsException() throws ArrayIndexOutOfBoundsException;

    private static native void throwIndexOutOfBoundsException() throws IndexOutOfBoundsException;

    private static native void throwIllegalArgumentException() throws IllegalArgumentException;

    private static native void throwException(String className) throws Exception;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        LibJnhwCommonTestLoader.touch();
    }

    public JnhwExceptionsTest() {
    }

    @Test
    public void testThrowNativeErrorException() {
        var ex = Assertions.assertThrows(NativeErrorException.class, () -> {
            throwNativeErrorException(1);
        });
        Assertions.assertEquals(1, ex.errno);
        Assertions.assertEquals("Native error: 1", ex.getMessage());
    }

    @Test
    public void testThrowNotDefinedException() {
        var ex = Assertions.assertThrows(NotDefinedException.class, () -> {
            throwNotDefinedException();
        });
        Assertions.assertEquals("TEST_DEFINE", ex.getMessage());
    }

    @Test
    public void testThrowNoSuchNativeMethodException() {
        var ex = Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
            throwNoSuchNativeMethodException();
        });
        Assertions.assertEquals("No such method a_native_method", ex.getMessage());
    }

    @Test
    public void testThrowNoSuchTypeException() {
        var ex = Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
            throwNoSuchTypeException();
        });
        Assertions.assertEquals("No such member a_type", ex.getMessage());
    }

    @Test
    public void testThrowNoSuchTypeMemberException() {
        var ex = Assertions.assertThrows(NoSuchNativeTypeMemberException.class, () -> {
            throwNoSuchTypeMemberException();
        });
        Assertions.assertEquals("No such member a_type.a_member", ex.getMessage());
    }

    @Test
    public void testThrowNullPointerException() {
        var ex = Assertions.assertThrows(NullPointerException.class, () -> {
            throwNullPointerException();
        });
        Assertions.assertEquals("arg0", ex.getMessage());
    }

    @Test
    public void testThrowArrayIndexOutOfBoundsException() {
        var ex = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            throwArrayIndexOutOfBoundsException();
        });
        Assertions.assertEquals("arg_array_index", ex.getMessage());
    }

    @Test
    public void testThrowIndexOutOfBoundsException() {
        var ex = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            throwIndexOutOfBoundsException();
        });
        Assertions.assertEquals("arg_index", ex.getMessage());
    }

    @Test
    public void testThrowIllegalArgumentException() {
        var ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            throwIllegalArgumentException();
        });
        Assertions.assertEquals("arg_illegal", ex.getMessage());
    }

    @Test
    public void testThrowException() {
        var ex = Assertions.assertThrows(RuntimeException.class, () -> {
            throwException("java/lang/RuntimeException");
        });
        Assertions.assertEquals("rte 42", ex.getMessage());
    }

}
