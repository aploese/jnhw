/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2022-2024, Arne Plöse and individual contributors as indicated
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
import de.ibapl.jnhw.common.downcall.JnhwMh__V__sI__A__A;
import de.ibapl.jnhw.common.memory.MemoryHeap;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr__V___I_MA_MA;
import de.ibapl.jnhw.common.test.JnhwTestLogger;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import de.ibapl.jnhw.common.upcall.CallbackFactory__V___I_MA_MA;
import de.ibapl.jnhw.common.upcall.Callback__V___I_MA_MA;
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
public class Callback__V___I_MA_MA_Test {

    final static JnhwMh__V___A.ExceptionErased setCallback__V___I_MA_MA;
    final static JnhwMh_MA___V.ExceptionErased getCallback__V___I_MA_MA;
    final static JnhwMh__V__sI__A__A.ExceptionErased doCallback__V___I_MA_MA;

    static {
        LibJnhwCommonTestLoader.touch();
        setCallback__V___I_MA_MA = JnhwMh__V___A.mandatoryOf(LibJnhwCommonTestLoader.SYMBOL_LOOKUP, "setCallback__V___I_MA_MA", BaseDataType.uintptr_t);
        getCallback__V___I_MA_MA = JnhwMh_MA___V.mandatoryOf(LibJnhwCommonTestLoader.SYMBOL_LOOKUP, "getCallback__V___I_MA_MA", BaseDataType.uintptr_t, 0);
        doCallback__V___I_MA_MA = JnhwMh__V__sI__A__A.mandatoryOf(LibJnhwCommonTestLoader.SYMBOL_LOOKUP, "doCallback__V___I_MA_MA", BaseDataType.int32_t, BaseDataType.uintptr_t, BaseDataType.uintptr_t);
    }

    @BeforeAll
    public static void setUpBeforeClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeAll(testTnfo);
    }

    @AfterAll
    public static void tearDownAfterClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterAll(testTnfo);
    }

    private static FunctionPtr__V___I_MA_MA getCallback__V___I_MA_MA() {
        try {
            return FunctionPtr__V___I_MA_MA.wrap(getCallback__V___I_MA_MA.invoke_MA___V());
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void setCallback__V___I_MA_MA(FunctionPtr__V___I_MA_MA callback) {
        try {
            setCallback__V___I_MA_MA.invoke__V___P(callback);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void doCallback__V___I_MA_MA(int a, OpaqueMemory b, OpaqueMemory c) {
        try {
            doCallback__V___I_MA_MA.invoke__V__sI__P__P(a, b, c);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private Arena arena;

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
        arena = Arena.ofConfined();
    }

    @AfterEach
    public void cleanupAfterEach() throws Exception {
        arena.close();
    }

    /**
     * Test of MAX_INT_CONSUMER_CALLBACKS method, of class
     * IntConsumerCallbackFactory.
     */
    @Test
    @SuppressWarnings("UnusedAssignment")
    public void testMAX_CALL_BACKS() {
        int maxCB = CallbackFactory__V___I_MA_MA.MAX_CALL_BACKS;
        assertEquals(16, maxCB);
        Callback__V___I_MA_MA<?, ?>[] cbs = new Callback__V___I_MA_MA[maxCB];
        for (int i = 0; i < cbs.length; i++) {
            cbs[i] = new DummyCB32();
            assertEquals(maxCB - (i + 1), CallbackFactory__V___I_MA_MA.callbacksAvailable());
        }

        @SuppressWarnings("ResultOfObjectAllocationIgnored")
        RuntimeException re = assertThrows(RuntimeException.class, () -> {
            new DummyCB64();
        });
        assertEquals("No more Callbacks available! max: 16 reached", re.getMessage());

        for (Callback__V___I_MA_MA cb : cbs) {
            cb.release();
        }

        assertEquals(maxCB, CallbackFactory__V___I_MA_MA.callbacksAvailable());
    }

    @Test
    public void testNativeFunctionPointer() {
        @SuppressWarnings("unchecked")
        final Callback__V___I_MA_MA testPtr = new Callback__V___I_MA_MA((t) -> MemorySegment.ofAddress(121)) {
            @Override
            protected void callback(int value, MemorySegment a, MemorySegment b) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void release() {
                throw new UnsupportedOperationException("This was not aquired - so there is nothing to be released");
            }
        };
        setCallback__V___I_MA_MA(testPtr);
        assertEquals(getCallback__V___I_MA_MA(), testPtr);
    }

    /**
     * Test of release method, of class IntConsumerCallbackFactory.
     */
    @ParameterizedTest
    @ValueSource(ints = {
        0x04030201,
        0xf4030201})
    public void testCallAndRelease(final int testValueA) {
        JnhwTestLogger.logTest("Callback__V__I_MA_MA_Test.testCallAndRelease 0x%08x %1$d \n", testValueA);
        final int[] refA = new int[1];
        final MemorySegment[] refB = new MemorySegment[1];
        final MemorySegment[] refC = new MemorySegment[1];
        B b = new B(arena);
        C c = new C(arena);
        Callback__V___I_MA_MA callback = new Callback__V___I_MA_MA() {

            @Override
            protected void callback(int value, MemorySegment a, MemorySegment b) {
                refA[0] = value;
                refB[0] = a;
                refC[0] = b;
            }

        };
        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback.toMemorySegment());
        try {

            setCallback__V___I_MA_MA(callback);

            assertEquals(getCallback__V___I_MA_MA(), callback);
            assertSame(Callback__V___I_MA_MA.find(getCallback__V___I_MA_MA()), callback);
            doCallback__V___I_MA_MA(testValueA, b, c);
            assertEquals(testValueA, refA[0]);
            assertEquals(b.toMemorySegment(), refB[0]);
            assertEquals(c.toMemorySegment(), refC[0]);
            assertNotSame(b.toMemorySegment(), refB[0]);
            assertNotSame(c.toMemorySegment(), refC[0]);

            refA[0] = -1;
            refB[0] = null;
            refC[0] = null;

            JnhwMh__V__sI__A__A.of(
                    getCallback__V___I_MA_MA().toMemorySegment(),
                    "testCallback",
                    BaseDataType.int32_t,
                    BaseDataType.intptr_t,
                    BaseDataType.intptr_t
            ).invoke__V__sI__P__P(testValueA, b, c);

            assertEquals(testValueA, refA[0]);
            assertEquals(b.toMemorySegment(), refB[0]);
            assertEquals(c.toMemorySegment(), refC[0]);
            assertNotSame(b.toMemorySegment(), refB[0]);
            assertNotSame(c.toMemorySegment(), refC[0]);

        } finally {
            callback.release();
        }

        assertEquals(CallbackFactory__V___I_MA_MA.MAX_CALL_BACKS, CallbackFactory__V___I_MA_MA.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertEquals(getCallback__V___I_MA_MA(), nativeCallbackPointer);

        //Just check that the reference is gone...
        refA[0] = -1;
        doCallback__V___I_MA_MA(testValueA / 2, b, c);
        assertEquals(-1, refA[0]);
    }

    static class B extends MemoryHeap {

        public final static int SIZE_OF = 2;

        public B(MemorySegment nativeAddress, Arena arena) {
            super(nativeAddress.reinterpret(SIZE_OF, arena, null), 0, SIZE_OF);
        }

        public B(Arena arena) {
            super(arena.allocate(SIZE_OF), 0, SIZE_OF);
        }

    }

    static class C extends MemoryHeap {

        public final static int SIZE_OF = 4;

        public C(MemorySegment nativeAddress, Arena arena) {
            super(nativeAddress.reinterpret(SIZE_OF, arena, null), 0, SIZE_OF);
        }

        public C(Arena arena) {
            super(arena.allocate(SIZE_OF), 0, SIZE_OF);
        }

    }

    private class DummyCB32 extends Callback__V___I_MA_MA {

        @Override
        protected void callback(int value, MemorySegment a, MemorySegment b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    private class DummyCB64 extends Callback__V___I_MA_MA {

        @Override
        protected void callback(int value, MemorySegment a, MemorySegment b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

}
