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
import de.ibapl.jnhw.common.downcall.JnhwMh__V__BL_sI;
import de.ibapl.jnhw.common.downcall.JnhwMh__V___A;
import de.ibapl.jnhw.common.downcall.JnhwMh__V__sI;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr__V___I;
import de.ibapl.jnhw.common.test.JnhwTestLogger;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import de.ibapl.jnhw.common.upcall.CallbackFactory__V___I;
import de.ibapl.jnhw.common.upcall.Callback__V___I;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
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
public class Callback__V___I_Test {

    private final static JnhwMh__V___A setCallback__V___I;
    private final static JnhwMh_MA___V.ExceptionErased getCallback__V___I;
    private final static JnhwMh__V__BL_sI doCallback__V___I;

    static {
        LibJnhwCommonTestLoader.touch();
        setCallback__V___I = JnhwMh__V___A.mandatoryOf(LibJnhwCommonTestLoader.SYMBOL_LOOKUP, "setCallback__V___I", BaseDataType.uintptr_t);
        getCallback__V___I = JnhwMh_MA___V.mandatoryOf(LibJnhwCommonTestLoader.SYMBOL_LOOKUP, "getCallback__V___I", BaseDataType.uintptr_t);
        doCallback__V___I = JnhwMh__V__BL_sI.mandatoryOf(LibJnhwCommonTestLoader.SYMBOL_LOOKUP, "doCallback__V___I", BaseDataType.C_char, BaseDataType.int32_t);
    }

    @BeforeAll
    public static void setUpBeforeClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeAll(testTnfo);
    }

    @AfterAll
    public static void tearDownAfterClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterAll(testTnfo);
    }

    private static FunctionPtr__V___I getCallback__V___I() {
        try {
            return FunctionPtr__V___I.wrap(getCallback__V___I.invoke_MA___V());
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void setCallback__V___I(FunctionPtr__V___I callback) {
        try {
            setCallback__V___I.invoke__V___P(callback);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void doCallback__V___I(boolean newThread, int value) {
        try {
            doCallback__V___I.invoke__V__BL_sI(newThread, value);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }
    private MemorySession ms;

    @BeforeEach
    public void setUpBeforeEach(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeEach(testTnfo);
    }

    @AfterEach
    public void tearDownAfterEach(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterEach(testTnfo);
    }

    @BeforeEach
    public void setUpBefore() throws Exception {
        System.gc();
        ms = MemorySession.openConfined();
    }

    @AfterEach
    public void cleanupAfterEach() throws Exception {
        ms.close();
    }

    /**
     * Test of MAX_INT_CONSUMER_CALLBACKS method, of class
     * IntConsumerCallbackFactory.
     */
    @Test
    public void testMAX_CALL_BACKS() {
        int maxCB = CallbackFactory__V___I.MAX_CALL_BACKS;
        assertEquals(16, maxCB);
        Callback__V___I[] cbs = new Callback__V___I[maxCB];
        for (int i = 0; i < cbs.length; i++) {
            cbs[i] = new DummyCB();
            assertEquals(maxCB - (i + 1), CallbackFactory__V___I.callbacksAvailable());
        }

        RuntimeException re = assertThrows(RuntimeException.class, () -> {
            new DummyCB();
        });
        assertEquals("No more Callbacks available! max: 16 reached", re.getMessage());

        for (Callback__V___I cb : cbs) {
            cb.release();
        }

        assertEquals(maxCB, CallbackFactory__V___I.callbacksAvailable());
    }

    @Test
    public void testNativeFunctionPointer() {
        final Callback__V___I testPtr = new Callback__V___I((t) -> MemoryAddress.ofLong(121)) {
            @Override
            protected void callback(int value) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void release() {
                throw new UnsupportedOperationException("This was not aquired - so there is nothing to be released");
            }
        };
        setCallback__V___I(testPtr);
        assertEquals(getCallback__V___I(), testPtr);

        //Its not aquired ... so do not release
        //testPtr.release();
    }

    /**
     * Test of release method
     */
    @ParameterizedTest
    @ValueSource(ints = {
        0x04030201,
        0xf4030201})
    public void testCallAndRelease(final int testValue) {
        JnhwTestLogger.logTest("Callback__V__L_Test.testCallAndRelease 0x%08x %1$d \n", testValue);
        final int[] ref = new int[1];
        final Callback__V___I NULL_PTR = new Callback__V___I((t) -> MemoryAddress.NULL) {
            @Override
            protected void callback(int value) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void release() {
                throw new UnsupportedOperationException("This was not aquired - so there is nothing to be released");
            }
        };
        final Thread t = Thread.currentThread();
        Callback__V___I callback = new Callback__V___I() {

            @Override
            protected void callback(int value) {
                if (t.equals(Thread.currentThread())) {
                    ref[0] = -value;
                } else {
                    ref[0] = value;
                }
            }

        };
        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback.toAddressable().address());
        try {

            setCallback__V___I(callback);

            assertEquals(getCallback__V___I(), callback);
            assertSame(Callback__V___I.find(getCallback__V___I()), callback);
            doCallback__V___I(true, 42);
            assertEquals(42, ref[0]);

            //Call native from java
            ref[0] = 0;
            JnhwMh__V__sI.of(
                    MemorySegment.ofAddress(
                            getCallback__V___I().toAddressable().address(), 0, ms),
                    "testCallback",
                    BaseDataType.int32_t
            ).invoke__V__sI(testValue);

            assertEquals(-testValue, ref[0]);

        } finally {
            callback.release();
        }

        assertEquals(CallbackFactory__V___I.MAX_CALL_BACKS, CallbackFactory__V___I.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertEquals(getCallback__V___I(), nativeCallbackPointer);

        //Just check that the reference is gone...
        ref[0] = -1;
        doCallback__V___I(false, testValue / 2);
        assertEquals(-1, ref[0]);

        ref[0] = -1;
        //The logs shoud show: Unassigned callback for trampoline_o(testValue/2)
        JnhwMh__V__sI.of(
                MemorySegment.ofAddress(
                        getCallback__V___I().toAddressable().address(), 0, ms),
                "testCallback",
                BaseDataType.int32_t
        ).invoke__V__sI(testValue / 2);

        assertEquals(-1, ref[0]);

    }

    private class DummyCB extends Callback__V___I {

        @Override
        protected void callback(int value) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }

}
