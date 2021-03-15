/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2021, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.common.test.callbacks;

import de.ibapl.jnhw.common.callback.Callback_I_Mem_Mem_V;
import de.ibapl.jnhw.common.callback.Callback_I_Mem_Mem_V_Impl;
import de.ibapl.jnhw.common.references.ObjectRef;
import de.ibapl.jnhw.common.references.IntRef;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.Memory32Heap;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.memory.OpaqueMemory64;
import de.ibapl.jnhw.common.nativecall.CallNative_I_Mem_Mem_V;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr_I_Mem_Mem_V;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import java.lang.ref.Cleaner;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class Callback_I_Mem_Mem_V_Test {

    static class A extends Memory32Heap {

        public final static int SIZE_OF = 2;

        public A(NativeAddressHolder nativeAddress) {
            super(nativeAddress, SIZE_OF);
        }

        public A() {
            super((OpaqueMemory32) null, 0, SIZE_OF, SET_MEM_TO_0);
        }

    }

    static class B extends Memory32Heap {

        public final static int SIZE_OF = 4;

        public B(NativeAddressHolder nativeAddress) {
            super(nativeAddress, SIZE_OF);
        }

        public B() {
            super((OpaqueMemory32) null, 0, SIZE_OF, SET_MEM_TO_0);
        }

    }

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        LibJnhwCommonTestLoader.touch();
    }

    @BeforeEach
    public void setUpBefore() throws Exception {
        System.runFinalization();
        System.gc();
    }

    public Callback_I_Mem_Mem_V_Test() {
    }

    private static native FunctionPtr_I_Mem_Mem_V getCallbackPtr();

    private static native void setCallback(Callback_I_Mem_Mem_V<A, B> callback);

    private static native void doCallTheCallback(int value, A a, B b);

    private class DummyCB32 extends Callback_I_Mem_Mem_V_Impl<OpaqueMemory32, OpaqueMemory32> {

        @Override
        protected void callback(int value, OpaqueMemory32 a, OpaqueMemory32 b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        protected OpaqueMemory32 wrapA(NativeAddressHolder address) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        protected OpaqueMemory32 wrapB(NativeAddressHolder address) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    private class DummyCB64 extends Callback_I_Mem_Mem_V_Impl<OpaqueMemory64, OpaqueMemory64> {

        @Override
        protected void callback(int value, OpaqueMemory64 a, OpaqueMemory64 b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        protected OpaqueMemory64 wrapA(NativeAddressHolder address) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        protected OpaqueMemory64 wrapB(NativeAddressHolder address) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    /**
     * Test of MAX_INT_CONSUMER_CALLBACKS method, of class
     * IntConsumerCallbackFactory.
     */
    @Test
    @SuppressWarnings("UnusedAssignment")
    public void testMAX_CALL_BACKS() {
        System.out.println("MAX_CALL_BACKS");
        int maxCB = Callback_I_Mem_Mem_V_Impl.MAX_CALL_BACKS();
        assertEquals(8, maxCB);
        Callback_I_Mem_Mem_V_Impl[] cbs = new Callback_I_Mem_Mem_V_Impl[maxCB];
        for (int i = 0; i < cbs.length; i++) {
            cbs[i] = new DummyCB32();
            assertEquals(maxCB - (i + 1), Callback_I_Mem_Mem_V_Impl.callbacksAvailable());
        }

        @SuppressWarnings("ResultOfObjectAllocationIgnored")
        RuntimeException re = assertThrows(RuntimeException.class, () -> {
            new DummyCB64();
        });
        assertEquals("No more Callbacks available! max: 8 reached", re.getMessage());

        cbs = null;

        System.runFinalization();
        System.gc();

        assertEquals(maxCB, Callback_I_Mem_Mem_V_Impl.callbacksAvailable());
    }

    @Test
    public void testNativeFunctionPointer() {
        @SuppressWarnings("unchecked")
        final Callback_I_Mem_Mem_V<A, B> testPtr = new Callback_I_Mem_Mem_V(NativeAddressHolder.of(121)) {
            @Override
            protected void callback(int value, AbstractNativeMemory a, AbstractNativeMemory b) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        setCallback(testPtr);
        assertEquals(getCallbackPtr(), testPtr);
    }

    /**
     * Test of release method, of class IntConsumerCallbackFactory.
     */
    @Test
    public void testReleaseByGarbageCollector() {
        System.out.println("release");
        final IntRef intref = new IntRef();
        final ObjectRef<A> refA = new ObjectRef<>();
        final ObjectRef<B> refB = new ObjectRef<>();
        A a = new A();
        B b = new B();
        Callback_I_Mem_Mem_V_Impl<A, B> callback = new Callback_I_Mem_Mem_V_Impl<>() {

            @Override
            protected void callback(int value, A a, B b) {
                intref.value = value;
                refA.value = a;
                refB.value = b;
            }

            @Override
            protected A wrapA(NativeAddressHolder address) {
                return new A(address);
            }

            @Override
            protected B wrapB(NativeAddressHolder address) {
                return new B(address);
            }

        };
        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback);

        setCallback(callback);

        assertEquals(getCallbackPtr(), callback);
        assertSame(Callback_I_Mem_Mem_V_Impl.find(getCallbackPtr()), callback);
        doCallTheCallback(42, a, b);
        assertEquals(42, intref.value);
        assertEquals(a, refA.value);
        assertEquals(b, refB.value);
        assertNotSame(a, refA.value);
        assertNotSame(b, refB.value);

        intref.value = -1;
        refA.value = null;
        refB.value = null;

        CallNative_I_Mem_Mem_V.wrap(getCallbackPtr()).call(42, a, b);
        assertEquals(42, intref.value);
        assertEquals(a, refA.value);
        assertEquals(b, refB.value);
        assertNotSame(a, refA.value);
        assertNotSame(b, refB.value);

        callback = null;

        System.runFinalization();
        System.gc();

        assertEquals(Callback_I_Mem_Mem_V_Impl.MAX_CALL_BACKS(), Callback_I_Mem_Mem_V_Impl.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertEquals(getCallbackPtr(), nativeCallbackPointer);

        //Just check that the reference is gone...
        intref.value = -1;
        doCallTheCallback(84, a, b);
        assertEquals(-1, intref.value);
    }

    /**
     * Test of release method, of class IntConsumerCallbackFactory.
     */
    @Test
    public void testReleaseByGarbageCollectorAndCleanup() throws Exception {
        System.out.println("release");
        Cleaner CLEANER = Cleaner.create();
        final ObjectRef<A> refA = new ObjectRef<>();
        final ObjectRef<B> refB = new ObjectRef<>();
        A a = new A();
        B b = new B();

        final IntRef intref = new IntRef();
        @SuppressWarnings("unchecked")
        final Callback_I_Mem_Mem_V<A, B> NULL_PTR = new Callback_I_Mem_Mem_V(NativeAddressHolder.NULL) {
            @Override
            protected void callback(int value, AbstractNativeMemory a, AbstractNativeMemory b) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        Callback_I_Mem_Mem_V_Impl<A, B> callback = new Callback_I_Mem_Mem_V_Impl<>() {

            @Override
            protected void callback(int value, A a, B b) {
                intref.value = value;
                refA.value = a;
                refB.value = b;
            }

            @Override
            protected A wrapA(NativeAddressHolder address) {
                return new A(address);
            }

            @Override
            protected B wrapB(NativeAddressHolder address) {
                return new B(address);
            }

        };
        CLEANER.register(callback, () -> {
            setCallback(NULL_PTR);
        });

        setCallback(callback);

        assertEquals(getCallbackPtr(), callback);
        doCallTheCallback(42, a, b);
        assertEquals(42, intref.value);
        assertEquals(a, refA.value);
        assertEquals(b, refB.value);
        assertNotSame(a, refA.value);
        assertNotSame(b, refB.value);

        callback = null;

        System.runFinalization();
        System.gc();

        //sleep here, to let the CLEANER do it cleanup....
        Thread.sleep(10);

        assertEquals(getCallbackPtr(), NULL_PTR);

    }
}
