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
import de.ibapl.jnhw.common.downcall.JnhwMh__V__sI_sI__A;
import de.ibapl.jnhw.common.memory.MemoryHeap;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr__V___I__I_MA;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import de.ibapl.jnhw.common.upcall.CallbackFactory__V___I__I_MA;
import de.ibapl.jnhw.common.upcall.Callback__V___I__I_MA;
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
public class Callback__V___I__I_MA_Test {

    final static JnhwMh__V___A.ExceptionErased setCallback__V___I__I_MA;
    final static JnhwMh_MA___V.ExceptionErased getCallback__V___I__I_MA;
    final static JnhwMh__V__sI_sI__A.ExceptionErased doCallback__V___I__I_MA;

    static {
        LibJnhwCommonTestLoader.touch();
        setCallback__V___I__I_MA = JnhwMh__V___A.mandatoryOf(LibJnhwCommonTestLoader.SYMBOL_LOOKUP, "setCallback__V___I__I_MA", BaseDataType.uintptr_t);
        getCallback__V___I__I_MA = JnhwMh_MA___V.mandatoryOf(LibJnhwCommonTestLoader.SYMBOL_LOOKUP, "getCallback__V___I__I_MA", BaseDataType.uintptr_t);
        doCallback__V___I__I_MA = JnhwMh__V__sI_sI__A.mandatoryOf(LibJnhwCommonTestLoader.SYMBOL_LOOKUP, "doCallback__V___I__I_MA", BaseDataType.int32_t, BaseDataType.int32_t, BaseDataType.uintptr_t);
    }

    private MemorySession ms;

    static class C extends MemoryHeap {

        public final static int SIZE_OF = 2;

        public C(MemoryAddress nativeAddress, MemorySession ms) {
            super(MemorySegment.ofAddress(nativeAddress, SIZE_OF, ms), 0, SIZE_OF);
        }

        public C(MemorySession ms) {
            super(MemorySegment.allocateNative(SIZE_OF, ms), 0, SIZE_OF);
        }

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

    private static FunctionPtr__V___I__I_MA getCallback__V___I__I_MA() {
        try {
            return FunctionPtr__V___I__I_MA.wrap((MemoryAddress) getCallback__V___I__I_MA.invoke_MA___V());
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void setCallback__V___I__I_MA(FunctionPtr__V___I__I_MA callback) {
        try {
            setCallback__V___I__I_MA.invoke__V___P(callback);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void doCallback__V___I__I_MA(int a, int b, OpaqueMemory c) {
        try {
            doCallback__V___I__I_MA.invoke__V__sI_sI__P(a, b, c);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private class DummyCB extends Callback__V___I__I_MA {

        @Override
        protected void callback(int a, int b, MemoryAddress c) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    /**
     * Test of MAX_INT_CONSUMER_CALLBACKS method, of class
     * IntConsumerCallbackFactory.
     */
    @Test
    public void testMAX_CALL_BACKS() {
        System.out.println("MAX_CALL_BACKS");
        int maxCB = CallbackFactory__V___I__I_MA.MAX_CALL_BACKS;
        assertEquals(16, maxCB);
        Callback__V___I__I_MA[] cbs = new Callback__V___I__I_MA[maxCB];
        for (int i = 0; i < cbs.length; i++) {
            cbs[i] = new DummyCB();
            assertEquals(maxCB - (i + 1), CallbackFactory__V___I__I_MA.callbacksAvailable());
        }

        RuntimeException re = assertThrows(RuntimeException.class, () -> {
            new DummyCB();
        });
        assertEquals("No more Callbacks available! max: 16 reached", re.getMessage());

        for (Callback__V___I__I_MA cb : cbs) {
            cb.release();
        }

        assertEquals(maxCB, CallbackFactory__V___I__I_MA.callbacksAvailable());
    }

    @Test
    public void testNativeFunctionPointer() {
        @SuppressWarnings("unchecked")
        final Callback__V___I__I_MA testPtr = new Callback__V___I__I_MA((t) -> MemoryAddress.ofLong(121)) {
            @Override
            protected void callback(int a, int b, MemoryAddress c) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void release() {
                throw new UnsupportedOperationException("This was not aquired - so there is nothing to be released");
            }
        };
        setCallback__V___I__I_MA(testPtr);
        assertEquals(getCallback__V___I__I_MA(), testPtr);
    }

    /**
     * Test of release method, of class IntConsumerCallbackFactory.
     */
    @ParameterizedTest
    @ValueSource(ints = {
        0x04030201,
        0xf4030201})
    public void testCallAndRelease(final int testValueInt) {
        System.out.printf("Callback__V__I__I_MA_Test.testCallAndRelease 0x%08x %1$d \n", testValueInt);
        final int[] refA = new int[1];
        final int[] refB = new int[1];
        final MemoryAddress[] refC = new MemoryAddress[1];
        C c = new C(ms);
        Callback__V___I__I_MA callback = new Callback__V___I__I_MA() {

            @Override
            protected void callback(int a, int b, MemoryAddress c) {
                refA[0] = a;
                refB[0] = b;
                refC[0] = c;
            }

        };
        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback.toAddressable().address());
        try {

            setCallback__V___I__I_MA(callback);

            assertEquals(getCallback__V___I__I_MA(), callback);
            assertSame(Callback__V___I__I_MA.find(getCallback__V___I__I_MA()), callback);
            doCallback__V___I__I_MA(testValueInt, ~testValueInt, c);
            assertEquals(testValueInt, refA[0]);
            assertEquals(~testValueInt, refB[0]);
            assertEquals(c.toAddressable().address(), refC[0]);
            assertNotSame(c.toAddressable().address(), refC[0]);

            refA[0] = -1;
            refB[0] = -1;
            refC[0] = null;

            JnhwMh__V__sI_sI__A.of(
                    MemorySegment.ofAddress(
                            getCallback__V___I__I_MA().toAddressable().address(), 0, ms),
                    "testCallback",
                    BaseDataType.int32_t,
                    BaseDataType.int32_t,
                    BaseDataType.intptr_t
            ).invoke__V__sI_sI__P(~testValueInt, testValueInt, c);

            assertEquals(~testValueInt, refA[0]);
            assertEquals(testValueInt, refB[0]);
            assertEquals(c.toAddressable().address(), refC[0]);
            assertNotSame(c.toAddressable().address(), refC[0]);

        } finally {
            callback.release();
        }

        assertEquals(CallbackFactory__V___I__I_MA.MAX_CALL_BACKS, CallbackFactory__V___I__I_MA.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertEquals(getCallback__V___I__I_MA(), nativeCallbackPointer);

        //Just check that the reference is gone...
        refA[0] = -1;
        refB[0] = -2;
        refC[0] = null;
        doCallback__V___I__I_MA(testValueInt / 2, testValueInt * 2, c);
        assertEquals(-1, refA[0]);
        assertEquals(-2, refB[0]);
        assertNull(refC[0]);
    }

}
