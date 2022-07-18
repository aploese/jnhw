/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.memory.MemoryHeap;
import de.ibapl.jnhw.common.downcall.JnhwMi__V___I__I__A;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr__V___I__I_MA;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import de.ibapl.jnhw.common.upcall.CallbackFactory__V___I__I_MA;
import de.ibapl.jnhw.common.upcall.Callback__V___I__I_MA;
import java.lang.invoke.MethodHandle;
import java.lang.ref.Cleaner;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.ValueLayout;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class Callback__V___I__I_MA_Test {

    final static MethodHandle setCallback__V___I__I_MA;
    final static MethodHandle getCallback__V___I__I_MA;
    final static MethodHandle doCallback__V___I__I_MA;

    static {
        LibJnhwCommonTestLoader.touch();
        setCallback__V___I__I_MA = LibJnhwCommonTestLoader.downcallHandle("setCallback__V___I__I_MA", FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
        getCallback__V___I__I_MA = LibJnhwCommonTestLoader.downcallHandle("getCallback__V___I__I_MA", FunctionDescriptor.of(ValueLayout.ADDRESS));
        doCallback__V___I__I_MA = LibJnhwCommonTestLoader.downcallHandle("doCallback__V___I__I_MA", FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    }

    private ResourceScope rs;

    static class C extends MemoryHeap {

        public final static int SIZE_OF = 2;

        public C(MemoryAddress nativeAddress, ResourceScope rs) {
            super(MemorySegment.ofAddress(nativeAddress, SIZE_OF, rs), 0, SIZE_OF);
        }

        public C(ResourceScope rs) {
            super(MemorySegment.allocateNative(SIZE_OF, rs), 0, SIZE_OF);
        }

    }

    @BeforeEach
    public void setUpBefore() throws Exception {
        System.runFinalization();
        System.gc();
        rs = ResourceScope.newConfinedScope();
    }

    @AfterEach
    public void cleanupAfterEach() throws Exception {
        rs.close();
    }

    private static FunctionPtr__V___I__I_MA getCallback__V___I__I_MA() {
        try {
            return FunctionPtr__V___I__I_MA.wrap((MemoryAddress) getCallback__V___I__I_MA.invokeExact());
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void setCallback__V___I__I_MA(FunctionPtr__V___I__I_MA callback) {
        try {
            setCallback__V___I__I_MA.invokeExact(callback.toAddressable());
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void doCallback__V___I__I_MA(int a, int b, OpaqueMemory c) {
        try {
            doCallback__V___I__I_MA.invokeExact(a, b, c.toAddressable());
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private class DummyCB extends Callback__V___I__I_MA {

        @Override
        protected void callback(int a, int b, MemoryAddress c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

        cbs = null;

        System.runFinalization();
        System.gc();

        assertEquals(maxCB, CallbackFactory__V___I__I_MA.callbacksAvailable());
    }

    @Test
    public void testNativeFunctionPointer() {
        @SuppressWarnings("unchecked")
        final Callback__V___I__I_MA testPtr = new Callback__V___I__I_MA(MemoryAddress.ofLong(121)) {
            @Override
            protected void callback(int a, int b, MemoryAddress c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        setCallback__V___I__I_MA(testPtr);
        assertEquals(getCallback__V___I__I_MA(), testPtr);
    }

    /**
     * Test of release method, of class IntConsumerCallbackFactory.
     */
    @Test
    public void testReleaseByGarbageCollector() {
        System.out.println("release");
        final int[] refA = new int[1];
        final int[] refB = new int[1];
        final MemoryAddress[] refC = new MemoryAddress[1];
        C c = new C(rs);
        Callback__V___I__I_MA callback = new Callback__V___I__I_MA() {

            @Override
            protected void callback(int a, int b, MemoryAddress c) {
                refA[0] = a;
                refB[0] = b;
                refC[0] = c;
            }

        };
        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback.toAddressable().address());

        setCallback__V___I__I_MA(callback);

        assertEquals(getCallback__V___I__I_MA(), callback);
        assertSame(Callback__V___I__I_MA.find(getCallback__V___I__I_MA()), callback);
        doCallback__V___I__I_MA(42, 84, c);
        assertEquals(42, refA[0]);
        assertEquals(84, refB[0]);
        assertEquals(c.toAddressable().address(), refC[0]);
        assertNotSame(c.toAddressable().address(), refC[0]);

        refA[0] = -1;
        refB[0] = -1;
        refC[0] = null;

        new JnhwMi__V___I__I__A(getCallback__V___I__I_MA().toAddressable().address(), rs).invoke__V__sI_sI__P(42, 84, c);
        assertEquals(42, refA[0]);
        assertEquals(84, refB[0]);
        assertEquals(c.toAddressable().address(), refC[0]);
        assertNotSame(c.toAddressable().address(), refC[0]);

        callback = null;

        System.runFinalization();
        System.gc();

        assertEquals(CallbackFactory__V___I__I_MA.MAX_CALL_BACKS, CallbackFactory__V___I__I_MA.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertEquals(getCallback__V___I__I_MA(), nativeCallbackPointer);

        //Just check that the reference is gone...
        refA[0] = -1;
        refB[0] = -2;
        refC[0] = null;
        doCallback__V___I__I_MA(11, 23, c);
        assertEquals(-1, refA[0]);
        assertEquals(-2, refB[0]);
        assertNull(refC[0]);
    }

    /**
     * Test of release method, of class IntConsumerCallbackFactory.
     */
    @Test
    public void testReleaseByGarbageCollectorAndCleanup() throws Exception {
        System.out.println("release");
        Cleaner CLEANER = Cleaner.create();
        final int[] refA = new int[1];
        final int[] refB = new int[1];
        final MemoryAddress[] refC = new MemoryAddress[1];
        C c = new C(rs);

        @SuppressWarnings("unchecked")
        final Callback__V___I__I_MA NULL_PTR = new Callback__V___I__I_MA(MemoryAddress.NULL) {
            @Override
            protected void callback(int a, int b, MemoryAddress c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        Callback__V___I__I_MA callback = new Callback__V___I__I_MA() {

            @Override
            protected void callback(int a, int b, MemoryAddress c) {
                refA[0] = a;
                refB[0] = b;
                refC[0] = c;
            }

        };
        CLEANER.register(callback, () -> {
            setCallback__V___I__I_MA(NULL_PTR);
        });

        setCallback__V___I__I_MA(callback);

        assertEquals(getCallback__V___I__I_MA(), callback);
        doCallback__V___I__I_MA(42, 41, c);
        assertEquals(42, refA[0]);
        assertEquals(41, refB[0]);
        assertEquals(c.toAddressable().address(), refC[0]);
        assertNotSame(c.toAddressable().address(), refC[0]);

        callback = null;

        System.runFinalization();
        System.gc();

        //sleep here, to let the CLEANER do it cleanup....
        Thread.sleep(10);

        assertEquals(getCallback__V___I__I_MA(), NULL_PTR);
    }
}
