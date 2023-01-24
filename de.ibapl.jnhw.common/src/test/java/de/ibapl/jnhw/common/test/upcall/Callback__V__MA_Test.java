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
import de.ibapl.jnhw.common.downcall.JnhwMh__V__sL;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr__V__MA;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import de.ibapl.jnhw.common.upcall.CallbackFactory__V__MA;
import de.ibapl.jnhw.common.upcall.Callback__V__MA;
import static de.ibapl.jnhw.libloader.MemoryModel.ILP32;
import static de.ibapl.jnhw.libloader.MemoryModel.LLP64;
import static de.ibapl.jnhw.libloader.MemoryModel.LP64;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
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
public class Callback__V__MA_Test {

    private final static JnhwMh__V___A.ExceptionErased setCallback__V__MA;
    private final static JnhwMh_MA___V.ExceptionErased getCallback__V__MA;
    private final static JnhwMh__V___A.ExceptionErased doCallback__V__MA;

    static {
        LibJnhwCommonTestLoader.touch();
        setCallback__V__MA = JnhwMh__V___A.mandatoryOf(LibJnhwCommonTestLoader.SYMBOL_LOOKUP, "setCallback__V__MA", BaseDataType.uintptr_t);
        getCallback__V__MA = JnhwMh_MA___V.mandatoryOf(LibJnhwCommonTestLoader.SYMBOL_LOOKUP, "getCallback__V__MA", BaseDataType.uintptr_t);
        doCallback__V__MA = JnhwMh__V___A.mandatoryOf(LibJnhwCommonTestLoader.SYMBOL_LOOKUP, "doCallback__V__MA", BaseDataType.uintptr_t);
    }

    private class DummyCB extends Callback__V__MA {

        @Override
        protected void callback(MemoryAddress value) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }

    private MemorySession ms;

    @BeforeEach
    public void setUpBefore() throws Exception {
        System.gc();
        ms = MemorySession.openConfined();
    }

    @AfterEach
    public void cleanupAfterEach() throws Exception {
        ms.close();
    }

    private static FunctionPtr__V__MA getCallback__V__MA() {
        try {
            return FunctionPtr__V__MA.wrap(getCallback__V__MA.invoke_MA___V());
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void setCallback__V__MA(FunctionPtr__V__MA callback) {
        try {
            setCallback__V__MA.invoke__V___P(callback);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void doCallback__V__MA(MemoryAddress value) {
        try {
            doCallback__V__MA.invoke__V___A(value);
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
        int maxCB = CallbackFactory__V__MA.MAX_CALL_BACKS;
        assertEquals(16, maxCB);
        Callback__V__MA[] cbs = new Callback__V__MA[maxCB];
        for (int i = 0; i < cbs.length; i++) {
            cbs[i] = new DummyCB();
            assertEquals(maxCB - (i + 1), CallbackFactory__V__MA.callbacksAvailable());
        }

        RuntimeException re = assertThrows(RuntimeException.class, () -> {
            new DummyCB();
        });
        assertEquals("No more Callbacks available! max: 16 reached", re.getMessage());

        for (Callback__V__MA cb : cbs) {
            cb.release();
        }

        assertEquals(maxCB, CallbackFactory__V__MA.callbacksAvailable());
    }

    @Test
    public void testNativeFunctionPointer() {
        final Callback__V__MA testPtr = new Callback__V__MA((t) -> MemoryAddress.ofLong(121)) {
            @Override
            protected void callback(MemoryAddress value) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void release() {
                throw new UnsupportedOperationException("This was not aquired - so there is nothing to be released");
            }
        };
        setCallback__V__MA(testPtr);
        assertEquals(getCallback__V__MA(), testPtr);

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
    public void testCallAndRelease(final long testValue) {
        System.out.printf("Callback__V__L_Test.testCallAndRelease 0x%016x %1$d \n", testValue);
        final long[] ref = new long[1];
        final Callback__V__MA NULL_PTR = new Callback__V__MA((t) -> MemoryAddress.NULL) {
            @Override
            protected void callback(MemoryAddress value) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void release() {
                throw new UnsupportedOperationException("This was not aquired - so there is nothing to be released");
            }
        };
        final Thread t = Thread.currentThread();
        Callback__V__MA callback = new Callback__V__MA() {

            @Override
            protected void callback(MemoryAddress value) {
                if (t.equals(Thread.currentThread())) {
                    ref[0] = value.toRawLongValue();
                } else {
                    ref[0] = ~value.toRawLongValue();
                }
            }

        };
        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback.toAddressable().address());
        try {

            setCallback__V__MA(callback);

            assertEquals(getCallback__V__MA(), callback);
            assertSame(Callback__V__MA.find(getCallback__V__MA()), callback);
            doCallback__V__MA(MemoryAddress.ofLong(testValue));
            switch (MultiarchTupelBuilder.getMemoryModel()) {
                case ILP32 ->
                    assertEquals(testValue & 0xffffffffL, ref[0]);
                case LLP64, LP64 ->
                    assertEquals(testValue, ref[0]);
                default ->
                    throw new AssertionError("Can`t handle memory model: " + MultiarchTupelBuilder.getMemoryModel());
            }

            //Call native from java
            ref[0] = 0;
            JnhwMh__V___A.of(
                    MemorySegment.ofAddress(
                            getCallback__V__MA().toAddressable().address(), 0, ms),
                    "testCallback",
                    BaseDataType.uintptr_t
            ).invoke__V___A(MemoryAddress.ofLong(testValue));

            switch (MultiarchTupelBuilder.getMemoryModel()) {
                case ILP32 ->
                    assertEquals(testValue & 0xffffffffL, ref[0]);
                case LLP64, LP64 ->
                    assertEquals(testValue, ref[0]);
                default ->
                    throw new AssertionError("Can`t handle memory model: " + MultiarchTupelBuilder.getMemoryModel());
            }

        } finally {
            callback.release();
        }

        assertEquals(CallbackFactory__V__MA.MAX_CALL_BACKS, CallbackFactory__V__MA.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertEquals(getCallback__V__MA(), nativeCallbackPointer);

        //Just check that the reference is gone...
        ref[0] = -1;
        doCallback__V__MA(MemoryAddress.ofLong(testValue / 2));
        assertEquals(-1, ref[0]);

        ref[0] = -1;
        //The logs shoud show: Unassigned callback for trampoline_0(testValue/2)
        JnhwMh__V__sL.of(
                MemorySegment.ofAddress(
                        getCallback__V__MA().toAddressable().address(), 0, ms),
                "testCallback",
                BaseDataType.int64_t
        ).invoke__V__sL(testValue / 2);

        assertEquals(-1, ref[0]);

    }

}
