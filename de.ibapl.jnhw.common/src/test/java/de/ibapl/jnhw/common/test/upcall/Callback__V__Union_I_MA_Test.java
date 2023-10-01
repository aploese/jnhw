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
package de.ibapl.jnhw.common.test.upcall;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.downcall.JnhwMh_MA___V;
import de.ibapl.jnhw.common.downcall.JnhwMh__V___A;
import de.ibapl.jnhw.common.downcall.JnhwMh__V__sI;
import de.ibapl.jnhw.common.downcall.JnhwMh__V__sL;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr__V__Union_I_MA;
import de.ibapl.jnhw.common.test.JnhwTestLogger;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import de.ibapl.jnhw.common.upcall.CallbackFactory__V__Union_I_MA;
import de.ibapl.jnhw.common.upcall.Callback__V__Union_I_MA;
import de.ibapl.jnhw.common.util.ConversionsJava2Native;
import static de.ibapl.jnhw.libloader.MemoryModel.ILP32;
import static de.ibapl.jnhw.libloader.MemoryModel.LP64;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import java.lang.foreign.MemorySegment;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author aploese
 */
public class Callback__V__Union_I_MA_Test {

    private final static JnhwMh__V___A.ExceptionErased setCallback__V__Union_I_MA;
    private final static JnhwMh_MA___V.ExceptionErased getCallback__V__Union_I_MA;
    private final static JnhwMh__V___A.ExceptionErased doCallback__V__Union_I_MAA;
    private final static JnhwMh__V__sI.ExceptionErased doCallback__V__Union_I_MAI;

    static {
        LibJnhwCommonTestLoader.touch();
        setCallback__V__Union_I_MA = JnhwMh__V___A.mandatoryOf(LibJnhwCommonTestLoader.SYMBOL_LOOKUP, "setCallback__V__Union_I_MA", BaseDataType.uintptr_t);
        getCallback__V__Union_I_MA = JnhwMh_MA___V.mandatoryOf(LibJnhwCommonTestLoader.SYMBOL_LOOKUP, "getCallback__V__Union_I_MA", BaseDataType.uintptr_t, 0);
        doCallback__V__Union_I_MAA = JnhwMh__V___A.mandatoryOf(LibJnhwCommonTestLoader.SYMBOL_LOOKUP, "doCallback__V__Union_I_MAA", BaseDataType.uintptr_t);
        doCallback__V__Union_I_MAI = JnhwMh__V__sI.mandatoryOf(LibJnhwCommonTestLoader.SYMBOL_LOOKUP, "doCallback__V__Union_I_MAI", BaseDataType.int32_t);
    }

    @BeforeAll
    public static void setUpBeforeClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeAll(testTnfo);
    }

    @AfterAll
    public static void tearDownAfterClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterAll(testTnfo);
    }

    private static FunctionPtr__V__Union_I_MA getCallback__V__Union_I_MA() {
        try {
            return FunctionPtr__V__Union_I_MA.wrap(getCallback__V__Union_I_MA.invoke_MA___V());
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void setCallback__V__Union_I_MA(FunctionPtr__V__Union_I_MA callback) {
        try {
            setCallback__V__Union_I_MA.invoke__V___P(callback);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void doCallback__V__Union_I_MAA(MemorySegment value) {
        try {
            doCallback__V__Union_I_MAA.invoke__V___A(value);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    @BeforeEach
    public void setUpBeforeEach(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeEach(testTnfo);
    }

    @AfterEach
    public void tearDownAfterEach(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterEach(testTnfo);
    }

    @BeforeEach
    public void setUp(TestInfo testInfo) throws Exception {
        System.gc(); //TODO removint this will fail the tests ...?
        assertEquals(CallbackFactory__V__Union_I_MA.MAX_CALL_BACKS, CallbackFactory__V__Union_I_MA.callbacksAvailable());
    }

    @AfterEach
    public void cleanupAfterEach(TestInfo testInfo) throws Exception {
        System.gc();
        assertEquals(CallbackFactory__V__Union_I_MA.MAX_CALL_BACKS, CallbackFactory__V__Union_I_MA.callbacksAvailable());
    }

    private void doCallback__V__Union_I_MAI(int value) {
        try {
            doCallback__V__Union_I_MAI.invoke__V__sI(value);
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
        int maxCB = CallbackFactory__V__Union_I_MA.MAX_CALL_BACKS;
        assertEquals(16, maxCB);
        Callback__V__Union_I_MA[] cbs = new Callback__V__Union_I_MA[maxCB];
        for (int i = 0; i < cbs.length; i++) {
            cbs[i] = new DummyCB();
            assertEquals(maxCB - (i + 1), CallbackFactory__V__Union_I_MA.callbacksAvailable());
        }

        RuntimeException re = assertThrows(RuntimeException.class, () -> {
            new DummyCB();
        });
        assertEquals("No more Callbacks available! max: 16 reached", re.getMessage());

        for (Callback__V__Union_I_MA cb : cbs) {
            cb.release();
        }

        assertEquals(maxCB, CallbackFactory__V__Union_I_MA.callbacksAvailable());
    }

    @Test
    public void testNativeFunctionPointer() {
        final Callback__V__Union_I_MA testPtr = new Callback__V__Union_I_MA((t) -> MemorySegment.ofAddress(121)) {
            @Override
            protected void callback(MemorySegment value_ptr, int value_int) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void release() {
                throw new UnsupportedOperationException("This was not aquired - so there is nothing to be released");
            }
        };
        setCallback__V__Union_I_MA(testPtr);
        assertEquals(getCallback__V__Union_I_MA(), testPtr);

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
        final long[] addressValueRef = new long[1];
        final int[] intValueRef = new int[1];

        final Callback__V__Union_I_MA NULL_PTR = new Callback__V__Union_I_MA((t) -> MemorySegment.NULL) {
            @Override
            protected void callback(MemorySegment sival_ptr, int sival_int) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void release() {
                throw new UnsupportedOperationException("This was not aquired - so there is nothing to be released");
            }
        };
        final Thread t = Thread.currentThread();
        Callback__V__Union_I_MA callback = new Callback__V__Union_I_MA() {

            @Override
            protected void callback(MemorySegment sival_ptr, int sival_int) {
                addressValueRef[0] = sival_ptr.address();
                intValueRef[0] = sival_int;
            }

        };
        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback.toMemorySegment());
        try {

            setCallback__V__Union_I_MA(callback);
            assertEquals(getCallback__V__Union_I_MA(), callback);
            assertSame(Callback__V__Union_I_MA.find(getCallback__V__Union_I_MA()), callback);
            doCallback__V__Union_I_MAA(MemorySegment.ofAddress(testValue));

            switch (MultiarchTupelBuilder.getMemoryModel()) {
                case ILP32 ->
                    assertAll(
                            () -> assertEquals(testValue & 0xffffffffL, addressValueRef[0], "sival_ptr"),
                            () -> assertEquals((int) testValue, intValueRef[0], "sival_int"));
                case LLP64, LP64 ->
                    assertAll(
                            () -> assertEquals(testValue, addressValueRef[0], "sival_ptr"),
                            () -> {
                                switch (MultiarchTupelBuilder.getEndianess()) {
                                    case BIG ->
                                        assertEquals((int) (testValue >>> 32), intValueRef[0], "sival_int");
                                    case LITTLE ->
                                        assertEquals((int) testValue, intValueRef[0], "sival_int");
                                    default ->
                                        throw new AssertionError("Can`t handle endianess: " + MultiarchTupelBuilder.getEndianess());
                                }
                            });
                default ->
                    throw new AssertionError("Can`t handle memory model: " + MultiarchTupelBuilder.getMemoryModel());
            }

            //Call native from java
            addressValueRef[0] = 0;
            intValueRef[0] = 0;
            JnhwMh__V___A.of(
                    getCallback__V__Union_I_MA().toMemorySegment(),
                    "testCalllback",
                    BaseDataType.uintptr_t
            ).invoke__V___A(MemorySegment.ofAddress(testValue));

            switch (MultiarchTupelBuilder.getMemoryModel()) {
                case ILP32 ->
                    assertAll(
                            () -> assertEquals(testValue & 0xffffffffL, addressValueRef[0], "sival_ptr"),
                            () -> assertEquals((int) testValue, intValueRef[0], "sival_int"));
                case LLP64, LP64 ->
                    assertAll(
                            () -> assertEquals(testValue, addressValueRef[0], "sival_ptr"),
                            () -> {
                                switch (MultiarchTupelBuilder.getEndianess()) {
                                    case BIG ->
                                        assertEquals((int) (testValue >>> 32), intValueRef[0], "sival_int");
                                    case LITTLE ->
                                        assertEquals((int) testValue, intValueRef[0], "sival_int");
                                    default ->
                                        throw new AssertionError("Can`t handle endianess: " + MultiarchTupelBuilder.getEndianess());
                                }
                            });
                default ->
                    throw new AssertionError("Can`t handle memory model: " + MultiarchTupelBuilder.getMemoryModel());
            }

        } finally {
            callback.release();
        }

        assertEquals(CallbackFactory__V__Union_I_MA.MAX_CALL_BACKS, CallbackFactory__V__Union_I_MA.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertEquals(getCallback__V__Union_I_MA(), nativeCallbackPointer);

        //Just check that the reference is gone...
        addressValueRef[0] = -1;
        intValueRef[0] = -1;
        doCallback__V__Union_I_MAA(MemorySegment.ofAddress(testValue / 2));
        assertEquals(-1, addressValueRef[0]);
        assertEquals(-1, intValueRef[0]);

        addressValueRef[0] = -1;
        intValueRef[0] = -1;

//The logs should show: Unassigned callback for trampoline_0(testValue/2)
        JnhwMh__V__sL.of(
                getCallback__V__Union_I_MA().toMemorySegment(),
                "testCallback",
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
        final long[] addressValueRef = new long[1];
        final int[] intValueRef = new int[1];
        final Callback__V__Union_I_MA NULL_PTR = new Callback__V__Union_I_MA((t) -> MemorySegment.NULL) {
            @Override
            protected void callback(MemorySegment value_ptr, int value_int) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void release() {
                throw new UnsupportedOperationException("This was not aquired - so there is nothing to be released");
            }
        };
        final Thread t = Thread.currentThread();
        Callback__V__Union_I_MA callback = new Callback__V__Union_I_MA() {

            @Override
            protected void callback(MemorySegment value_ptr, int value_int) {
                addressValueRef[0] = value_ptr.address();
                intValueRef[0] = value_int;
            }

        };
        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback.toMemorySegment());
        try {

            setCallback__V__Union_I_MA(callback);

            assertEquals(getCallback__V__Union_I_MA(), callback);
            assertSame(Callback__V__Union_I_MA.find(getCallback__V__Union_I_MA()), callback);
            doCallback__V__Union_I_MAI(testValue);
            assertAll(
                    () -> assertEquals(testValue, intValueRef[0], "sival_int"),
                    () -> {
                        switch (MultiarchTupelBuilder.getEndianess()) {
                            case BIG ->
                                assertEquals(testValue, (int) (addressValueRef[0] >>> 32), "sival_ptr");
                            case LITTLE ->
                                assertEquals(0xffffffffL & testValue, addressValueRef[0], "sival_ptr");
                            default ->
                                throw new AssertionError("Can`t handle endianess: " + MultiarchTupelBuilder.getEndianess());
                        }
                    });
            //Call native from java
            intValueRef[0] = 0;
            addressValueRef[0] = 0;
            switch (MultiarchTupelBuilder.getMemoryModel()) {
                case ILP32 ->
                    JnhwMh__V__sI.of(
                            getCallback__V__Union_I_MA().toMemorySegment(),
                            "testCallback",
                            BaseDataType.int32_t
                    ).invoke__V__sI(testValue);
                case LLP64, LP64 ->
                    JnhwMh__V__sL.of(
                            getCallback__V__Union_I_MA().toMemorySegment(),
                            "testCallback",
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
            assertAll(
                    () -> assertEquals(testValue, intValueRef[0], "sival_int"),
                    () -> {
                        switch (MultiarchTupelBuilder.getMemoryModel()) {
                            case ILP32 ->
                                assertEquals(0xffffffffL & testValue, addressValueRef[0], "sival_ptr");
                            case LLP64, LP64 -> {
                                switch (MultiarchTupelBuilder.getEndianess()) {
                                    case BIG ->
                                        assertEquals(0xffffffffL & testValue, addressValueRef[0] >>> 32, "sival_ptr");
                                    case LITTLE ->
                                        assertEquals(0xffffffffL & testValue, addressValueRef[0], "sival_ptr");
                                    default ->
                                        throw new AssertionError("Can`t handle endianess: " + MultiarchTupelBuilder.getEndianess());
                                }
                            }
                            default ->
                                throw new AssertionError("Can`t handle memory model: " + MultiarchTupelBuilder.getMemoryModel());
                        }
                    });
        } finally {
            callback.release();
        }

        assertEquals(CallbackFactory__V__Union_I_MA.MAX_CALL_BACKS, CallbackFactory__V__Union_I_MA.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertEquals(getCallback__V__Union_I_MA(), nativeCallbackPointer);

        //Just check that the reference is gone...
        intValueRef[0] = -1;
        addressValueRef[0] = -1;
        doCallback__V__Union_I_MAI(testValue / 2);
        assertEquals(-1, addressValueRef[0]);
        assertEquals(-1, intValueRef[0]);

        intValueRef[0] = -1;
        addressValueRef[0] = -1;
        //The logs shoud show: Unassigned callback for trampoline_o(testValue/2)
        JnhwMh__V__sI.of(
                getCallback__V__Union_I_MA().toMemorySegment(),
                "testCallback",
                BaseDataType.int32_t
        ).invoke__V__sI(testValue / 2);
        assertEquals(-1, addressValueRef[0]);
        assertEquals(-1, intValueRef[0]);

    }

    private class DummyCB extends Callback__V__Union_I_MA {

        @Override
        protected void callback(MemorySegment value_ptr, int value_int) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }

}
