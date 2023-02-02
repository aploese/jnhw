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
import de.ibapl.jnhw.common.downcall.JnhwMh__V__BL_sL;
import de.ibapl.jnhw.common.downcall.JnhwMh__V___A;
import de.ibapl.jnhw.common.downcall.JnhwMh__V__sL;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr__V___L;
import de.ibapl.jnhw.common.test.JnhwTestLogger;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import de.ibapl.jnhw.common.upcall.CallbackFactory__V___L;
import de.ibapl.jnhw.common.upcall.Callback__V___L;
import java.lang.foreign.Arena;
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
public class Callback__V___L_Test {

    private final static JnhwMh__V___A.ExceptionErased setCallback__V___L;
    private final static JnhwMh_MA___V.ExceptionErased getCallback__V___L;
    private final static JnhwMh__V__BL_sL.ExceptionErased doCallback__V___L;

    static {
        LibJnhwCommonTestLoader.touch();
        setCallback__V___L = JnhwMh__V___A.mandatoryOf(LibJnhwCommonTestLoader.SYMBOL_LOOKUP, "setCallback__V___L", BaseDataType.uintptr_t);
        getCallback__V___L = JnhwMh_MA___V.mandatoryOf(LibJnhwCommonTestLoader.SYMBOL_LOOKUP, "getCallback__V___L", BaseDataType.uintptr_t);
        doCallback__V___L = JnhwMh__V__BL_sL.mandatoryOf(LibJnhwCommonTestLoader.SYMBOL_LOOKUP, "doCallback__V___L", BaseDataType.C_char, BaseDataType.int64_t);
    }

    @BeforeAll
    public static void setUpBeforeClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeAll(testTnfo);
    }

    @AfterAll
    public static void tearDownAfterClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterAll(testTnfo);
    }

    private static FunctionPtr__V___L getCallback__V___L() {
        try {
            return FunctionPtr__V___L.wrap(getCallback__V___L.invoke_MA___V());
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void setCallback__V___L(FunctionPtr__V___L callback) {
        try {
            setCallback__V___L.invoke__V___P(callback);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void doCallback__V___L(boolean newThread, long value) {
        try {
            doCallback__V___L.invoke__V__BL_sL(newThread, value);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }
    private Arena ms;

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
        ms = Arena.openConfined();
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
        int maxCB = CallbackFactory__V___L.MAX_CALL_BACKS;
        assertEquals(16, maxCB);
        Callback__V___L[] cbs = new Callback__V___L[maxCB];
        for (int i = 0; i < cbs.length; i++) {
            cbs[i] = new DummyCB();
            assertEquals(maxCB - (i + 1), CallbackFactory__V___L.callbacksAvailable());
        }

        RuntimeException re = assertThrows(RuntimeException.class, () -> {
            new DummyCB();
        });
        assertEquals("No more Callbacks available! max: 16 reached", re.getMessage());

        for (Callback__V___L cb : cbs) {
            cb.release();
        }

        assertEquals(maxCB, CallbackFactory__V___L.callbacksAvailable());
    }

    @Test
    public void testNativeFunctionPointer() {
        final Callback__V___L testPtr = new Callback__V___L((t) -> MemorySegment.ofAddress(121)) {
            @Override
            protected void callback(long value) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void release() {
                throw new UnsupportedOperationException("This was not aquired - so there is nothing to be released");
            }
        };
        setCallback__V___L(testPtr);
        assertEquals(getCallback__V___L(), testPtr);

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
        JnhwTestLogger.logTest("Callback__V__L_Test.testCallAndRelease 0x%016x %1$d \n", testValue);
        final long[] ref = new long[1];
        final Callback__V___L NULL_PTR = new Callback__V___L((t) -> MemorySegment.NULL) {
            @Override
            protected void callback(long value) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };
        final Thread t = Thread.currentThread();
        Callback__V___L callback = new Callback__V___L() {

            @Override
            protected void callback(long value) {
                if (t.equals(Thread.currentThread())) {
                    ref[0] = -value;
                } else {
                    ref[0] = value;
                }
            }

        };
        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback.toMemorySegment());
        try {

            setCallback__V___L(callback);

            assertEquals(getCallback__V___L(), callback);
            assertSame(Callback__V___L.find(getCallback__V___L()), callback);
            doCallback__V___L(true, testValue);
            assertEquals(testValue, ref[0]);

            //Call native from java
            ref[0] = 0;
            JnhwMh__V__sL.of(
                    MemorySegment.ofAddress(
                            getCallback__V___L().toAddress(), 0, ms.scope()),
                    "testCallback",
                    BaseDataType.int64_t
            ).invoke__V__sL(testValue);

            assertEquals(-testValue, ref[0]);

        } finally {
            callback.release();
        }

        assertEquals(CallbackFactory__V___L.MAX_CALL_BACKS, CallbackFactory__V___L.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertEquals(getCallback__V___L(), nativeCallbackPointer);

        //Just check that the reference is gone...
        ref[0] = -1;
        doCallback__V___L(false, testValue / 2);
        assertEquals(-1, ref[0]);

        ref[0] = -1;
        //The logs shoud show: Unassigned callback for trampoline_0(testValue / 2)
        JnhwMh__V__sL.of(
                MemorySegment.ofAddress(
                        getCallback__V___L().toAddress(), 0, ms.scope()),
                "testCallback",
                BaseDataType.int64_t
        ).invoke__V__sL(testValue / 2);

        assertEquals(-1, ref[0]);

    }

    private class DummyCB extends Callback__V___L {

        @Override
        protected void callback(long value) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }

}
