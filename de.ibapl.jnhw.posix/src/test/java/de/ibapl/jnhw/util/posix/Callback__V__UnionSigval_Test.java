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

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.downcall.JnhwMh_MA___V;
import de.ibapl.jnhw.common.downcall.JnhwMh__V___A;
import de.ibapl.jnhw.common.downcall.JnhwMh__V__sI;
import de.ibapl.jnhw.common.downcall.JnhwMh__V__sL;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr__V__MA;
import de.ibapl.jnhw.common.util.ConversionsJava2Native;
import static de.ibapl.jnhw.libloader.MemoryModel.ILP32;
import static de.ibapl.jnhw.libloader.MemoryModel.LP64;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.posix.LibJnhwPosixTestLoader;
import de.ibapl.jnhw.util.posix.nativepointer.FunctionPtr__V__UnionSigval;
import de.ibapl.jnhw.util.posix.upcall.CallbackFactory__V__UnionSigval;
import de.ibapl.jnhw.util.posix.upcall.Callback__V__UnionSigval;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author aploese
 */
public class Callback__V__UnionSigval_Test {

    private final static JnhwMh__V___A setCallback__V__UnionSigval;
    private final static JnhwMh_MA___V getCallback__V__UnionSigval;
    private final static JnhwMh__V___A doCallback__V__UnionSigval_A;
    private final static JnhwMh__V__sI doCallback__V__UnionSigval_I;

    static {
        LibJnhwPosixTestLoader.touch();
        setCallback__V__UnionSigval = JnhwMh__V___A.of(LibJnhwPosixTestLoader.LIB_JNHW_POSIX_TEST_SYMBOL_LOOKUP, "setCallback__V__UnionSigval", BaseDataType.uintptr_t);
        getCallback__V__UnionSigval = JnhwMh_MA___V.of(LibJnhwPosixTestLoader.LIB_JNHW_POSIX_TEST_SYMBOL_LOOKUP, "getCallback__V__UnionSigval", BaseDataType.uintptr_t);
        doCallback__V__UnionSigval_A = JnhwMh__V___A.of(LibJnhwPosixTestLoader.LIB_JNHW_POSIX_TEST_SYMBOL_LOOKUP, "doCallback__V__UnionSigval_A", BaseDataType.uintptr_t);
        doCallback__V__UnionSigval_I = JnhwMh__V__sI.of(LibJnhwPosixTestLoader.LIB_JNHW_POSIX_TEST_SYMBOL_LOOKUP, "doCallback__V__UnionSigval_I", BaseDataType.int32_t);
    }

    private class DummyCB extends Callback__V__UnionSigval<OpaqueMemory> {

        @Override
        protected void callback(MemoryAddress sival_ptr, int sival_int) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }

    private MemorySession ms;

    @BeforeEach
    public void setUpBefore() throws Exception {
        System.gc();
        ms = MemorySession.openConfined();
    }

    @BeforeEach
    public void beforeEach() throws Exception {
        assertEquals(CallbackFactory__V__UnionSigval.MAX_CALL_BACKS, CallbackFactory__V__UnionSigval.callbacksAvailable());
    }

    @AfterEach
    public void cleanupAfterEach() throws Exception {
        ms.close();
        System.gc();
        assertEquals(CallbackFactory__V__UnionSigval.MAX_CALL_BACKS, CallbackFactory__V__UnionSigval.callbacksAvailable());
    }

    private static FunctionPtr__V__MA getCallback__V__UnionSigval() {
        try {
            return FunctionPtr__V__MA.wrap(getCallback__V__UnionSigval.invoke_MA___V());
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void setCallback__V__UnionSigval(FunctionPtr__V__UnionSigval callback) {
        try {
            setCallback__V__UnionSigval.invoke__V___P(callback);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void doCallback__V__MA(MemoryAddress value) {
        try {
            doCallback__V__UnionSigval_A.invoke__V___A(value);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private void doCallback__V___I(int value) {
        try {
            doCallback__V__UnionSigval_I.invoke__V__sI(value);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    /**
     * Test of MAX_INT_CONSUMER_CALLBACKS method, of class
     * IntConsumerCallbackFactory.
     */
    @Test
    public void testMAX_CALL_BACKS() {
        System.out.println("MAX_CALL_BACKS");
        int maxCB = CallbackFactory__V__UnionSigval.MAX_CALL_BACKS;
        assertEquals(16, maxCB);
        Callback__V__UnionSigval[] cbs = new Callback__V__UnionSigval[maxCB];
        for (int i = 0; i < cbs.length; i++) {
            cbs[i] = new DummyCB();
            assertEquals(maxCB - (i + 1), CallbackFactory__V__UnionSigval.callbacksAvailable());
        }

        RuntimeException re = assertThrows(RuntimeException.class, () -> {
            new DummyCB();
        });
        assertEquals("No more Callbacks available! max: 16 reached", re.getMessage());

        for (Callback__V__UnionSigval cb : cbs) {
            cb.release();
        }

        assertEquals(maxCB, CallbackFactory__V__UnionSigval.callbacksAvailable());
    }

    @Test
    public void testNativeFunctionPointer() {
        final Callback__V__UnionSigval testPtr = new Callback__V__UnionSigval((t) -> MemoryAddress.ofLong(121)) {
            @Override
            protected void callback(MemoryAddress sival_ptr, int sival_int) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void release() {
                throw new UnsupportedOperationException("This was not aquired - so there is nothing to be released");
            }
        };
        setCallback__V__UnionSigval(testPtr);
        assertEquals(getCallback__V__UnionSigval(), testPtr);

        //Its not aquired ... so do not release
        //testPtr.release();
    }

    /**
     * Test of release method
     */
    @ParameterizedTest
    @ValueSource(longs = {
        0x0807060504030201L,
        0xF807060504030201L,
        0x0000000004030201L,
        0x00000000F4030201L})
    public void testCallAndRelease_A(final long testValue) {
        System.out.printf("Callback__V__UnionSigval_Test.testCallAndRelease_A 0x%016x %1$d \n", testValue).flush();
        final long[] addressValueRef = new long[1];
        final int[] intValueRef = new int[1];

        final Callback__V__UnionSigval NULL_PTR = new Callback__V__UnionSigval((t) -> MemoryAddress.NULL) {
            @Override
            protected void callback(MemoryAddress sival_ptr, int sival_int) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void release() {
                throw new UnsupportedOperationException("This was not aquired - so there is nothing to be released");
            }
        };
        final Thread t = Thread.currentThread();
        Callback__V__UnionSigval callback = new Callback__V__UnionSigval() {

            @Override
            protected void callback(MemoryAddress sival_ptr, int sival_int) {
                addressValueRef[0] = sival_ptr.toRawLongValue();
                intValueRef[0] = sival_int;
            }

        };
        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback.toAddressable().address());
        try {

            setCallback__V__UnionSigval(callback);
            assertEquals(getCallback__V__UnionSigval(), callback);
            assertSame(Callback__V__UnionSigval.find(getCallback__V__UnionSigval()), callback);
            doCallback__V__MA(MemoryAddress.ofLong(testValue));

            switch (MultiarchTupelBuilder.getMemoryModel()) {
                case ILP32 -> {
                    assertEquals(testValue & 0xffffffffL, addressValueRef[0]);
                    assertEquals((int) testValue, intValueRef[0]);
                }
                case LP64 -> {
                    assertEquals(testValue, addressValueRef[0]);
                    switch (MultiarchTupelBuilder.getEndianess()) {
                        case BIG ->
                            assertEquals((int) (testValue >>> 32), intValueRef[0]);
                        case LITTLE ->
                            assertEquals((int) testValue, intValueRef[0]);
                        default ->
                            throw new AssertionError("Can`t handle endianess: " + MultiarchTupelBuilder.getEndianess());
                    }
                }
                default ->
                    throw new AssertionError("Can`t handle memory model: " + MultiarchTupelBuilder.getMemoryModel());
            }

            //Call native from java
            addressValueRef[0] = 0;
            intValueRef[0] = 0;
            JnhwMh__V___A.of(
                    getCallback__V__UnionSigval().toAddressable(),
                    ms,
                    BaseDataType.uintptr_t
            ).invoke__V___A(MemoryAddress.ofLong(testValue));

            switch (MultiarchTupelBuilder.getMemoryModel()) {
                case ILP32 -> {
                    assertEquals(testValue & 0xffffffffL, addressValueRef[0]);
                    assertEquals((int) testValue, intValueRef[0]);
                }
                case LP64 -> {
                    assertEquals(testValue, addressValueRef[0]);
                    switch (MultiarchTupelBuilder.getEndianess()) {
                        case BIG ->
                            assertEquals((int) (testValue >>> 32), intValueRef[0]);
                        case LITTLE ->
                            assertEquals((int) testValue, intValueRef[0]);
                        default ->
                            throw new AssertionError("Can`t handle endianess: " + MultiarchTupelBuilder.getEndianess());
                    }
                }
                default ->
                    throw new AssertionError("Can`t handle memory model: " + MultiarchTupelBuilder.getMemoryModel());
            }

        } finally {
            callback.release();
        }

        assertEquals(CallbackFactory__V__UnionSigval.MAX_CALL_BACKS, CallbackFactory__V__UnionSigval.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertEquals(getCallback__V__UnionSigval(), nativeCallbackPointer);

        //Just check that the reference is gone...
        addressValueRef[0] = -1;
        intValueRef[0] = -1;
        doCallback__V__MA(MemoryAddress.ofLong(testValue / 2));
        assertEquals(-1, addressValueRef[0]);
        assertEquals(-1, intValueRef[0]);

        addressValueRef[0] = -1;
        intValueRef[0] = -1;

//The logs should show: Unassigned callback for trampoline_0(testValue/2)
        JnhwMh__V__sL.of(
                getCallback__V__UnionSigval().toAddressable().address(),
                ms,
                BaseDataType.int64_t
        ).invoke__V__sL(testValue / 2);

        assertEquals(-1, addressValueRef[0]);
        assertEquals(-1, intValueRef[0]);

    }

    /**
     * Test of release method
     */
    @ParameterizedTest
    @ValueSource(ints = {
        0x04030201,
        0xf4030201})
    public void testCallAndRelease_I(final int testValue) {
        System.out.printf("Callback__V__UnionSigval_Test.testCallAndRelease_I 0x%08x %1$d \n", testValue).flush();
        final long[] addressValueRef = new long[1];
        final int[] intValueRef = new int[1];
        final Callback__V__UnionSigval NULL_PTR = new Callback__V__UnionSigval((t) -> MemoryAddress.NULL) {
            @Override
            protected void callback(MemoryAddress sival_ptr, int sival_int) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void release() {
                throw new UnsupportedOperationException("This was not aquired - so there is nothing to be released");
            }
        };
        final Thread t = Thread.currentThread();
        Callback__V__UnionSigval callback = new Callback__V__UnionSigval() {

            @Override
            protected void callback(MemoryAddress sival_ptr, int sival_int) {
                addressValueRef[0] = sival_ptr.toRawLongValue();
                intValueRef[0] = sival_int;
            }

        };
        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback.toAddressable().address());
        try {

            setCallback__V__UnionSigval(callback);

            assertEquals(getCallback__V__UnionSigval(), callback);
            assertSame(Callback__V__UnionSigval.find(getCallback__V__UnionSigval()), callback);
            doCallback__V___I(testValue);
            assertEquals(testValue, intValueRef[0]);
            switch (MultiarchTupelBuilder.getEndianess()) {
                case BIG ->
                    assertEquals(testValue, (int) (addressValueRef[0] >>> 32));
                case LITTLE ->
                    assertEquals(0xffffffffL & testValue, addressValueRef[0]);
                default ->
                    throw new AssertionError("Can`t handle endianess: " + MultiarchTupelBuilder.getEndianess());
            }

            //Call native from java
            intValueRef[0] = 0;
            addressValueRef[0] = 0;
            switch (MultiarchTupelBuilder.getMemoryModel()) {
                case ILP32 ->
                    JnhwMh__V__sI.of(
                            getCallback__V__UnionSigval().toAddressable(),
                            ms,
                            BaseDataType.int32_t
                    ).invoke__V__sI(testValue);
                case LP64 ->
                    JnhwMh__V__sL.of(
                            getCallback__V__UnionSigval().toAddressable(),
                            ms,
                            BaseDataType.int64_t
                    ).invoke__V__sL(switch (MultiarchTupelBuilder.getEndianess()) {
                        case BIG ->
                            //move by 4 bytes up in the region of sival_int
                            ConversionsJava2Native.int_TO_uint64_t(testValue) << 32;
                        case LITTLE ->
                            ConversionsJava2Native.int_TO_uint64_t(testValue);
                        default ->
                            throw new AssertionError("Can`t handle endianess: " + MultiarchTupelBuilder.getEndianess());
                    });
                default ->
                    throw new AssertionError("Can`t handle memory model: " + MultiarchTupelBuilder.getMemoryModel());
            }
            assertEquals(testValue, intValueRef[0]);
            switch (MultiarchTupelBuilder.getMemoryModel()) {
                case ILP32 ->
                    assertEquals(0xffffffffL & testValue, addressValueRef[0]);
                case LP64 -> {
                    switch (MultiarchTupelBuilder.getEndianess()) {
                        case BIG ->
                            assertEquals(0xffffffffL & testValue, addressValueRef[0] >>> 32);
                        case LITTLE ->
                            assertEquals(0xffffffffL & testValue, addressValueRef[0]);
                        default ->
                            throw new AssertionError("Can`t handle endianess: " + MultiarchTupelBuilder.getEndianess());
                    }
                }
                default ->
                    throw new AssertionError("Can`t handle memory model: " + MultiarchTupelBuilder.getMemoryModel());
            }
        } finally {
            callback.release();
        }

        assertEquals(CallbackFactory__V__UnionSigval.MAX_CALL_BACKS, CallbackFactory__V__UnionSigval.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertEquals(getCallback__V__UnionSigval(), nativeCallbackPointer);

        //Just check that the reference is gone...
        intValueRef[0] = -1;
        addressValueRef[0] = -1;
        doCallback__V___I(testValue / 2);
        assertEquals(-1, addressValueRef[0]);
        assertEquals(-1, intValueRef[0]);

        intValueRef[0] = -1;
        addressValueRef[0] = -1;
        //The logs shoud show: Unassigned callback for trampoline_o(testValue/2)
        JnhwMh__V__sI.of(getCallback__V__UnionSigval().toAddressable().address(), ms, BaseDataType.int32_t).invoke__V__sI(testValue / 2);
        assertEquals(-1, addressValueRef[0]);
        assertEquals(-1, intValueRef[0]);

    }

}
