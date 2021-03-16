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

import de.ibapl.jnhw.common.callback.Callback_Mem_V;
import de.ibapl.jnhw.common.callback.Callback_Mem_V_Impl;
import de.ibapl.jnhw.common.references.ObjectRef;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.Memory32Heap;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.nativecall.CallNative_Mem_V;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr_Mem_V;
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
public class Callback_Mem_V_Test {

    static class A extends Memory32Heap {

        public final static int SIZE_OF = 2;

        public A(NativeAddressHolder nativeAddress) {
            super(nativeAddress, SIZE_OF);
        }

        public A() {
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

    public Callback_Mem_V_Test() {
    }

    private static native FunctionPtr_Mem_V getCallbackPtr();

    private static native void setCallback(Callback_Mem_V<A> callback);

    private static native void doCallTheCallback(A a);

    private class DummyCB extends Callback_Mem_V_Impl<AbstractNativeMemory> {

        @Override
        protected void callback(AbstractNativeMemory a) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        protected AbstractNativeMemory wrapA(NativeAddressHolder address) {
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
        int maxCB = Callback_Mem_V_Impl.MAX_CALL_BACKS();
        assertEquals(8, maxCB);
        Callback_Mem_V_Impl[] cbs = new Callback_Mem_V_Impl[maxCB];
        for (int i = 0; i < cbs.length; i++) {
            cbs[i] = new DummyCB();
            assertEquals(maxCB - (i + 1), Callback_Mem_V_Impl.callbacksAvailable());
        }

        RuntimeException re = assertThrows(RuntimeException.class, () -> {
            new DummyCB();
        });
        assertEquals("No more Callbacks available! max: 8 reached", re.getMessage());

        cbs = null;

        System.runFinalization();
        System.gc();

        assertEquals(maxCB, Callback_Mem_V_Impl.callbacksAvailable());
    }

    @Test
    public void testNativeFunctionPointer() {
        @SuppressWarnings("unchecked")
        final Callback_Mem_V<A> testPtr = new Callback_Mem_V(NativeAddressHolder.ofUintptr_t(121)) {
            @Override
            protected void callback(AbstractNativeMemory a) {
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
        final ObjectRef<A> refA = new ObjectRef<>();
        A a = new A();
        Callback_Mem_V_Impl<A> callback = new Callback_Mem_V_Impl<>() {

            @Override
            protected void callback(A a) {
                refA.value = a;
            }

            @Override
            protected A wrapA(NativeAddressHolder address) {
                return new A(address);
            }

        };
        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback);

        setCallback(callback);

        assertEquals(getCallbackPtr(), callback);
        assertSame(Callback_Mem_V_Impl.find(getCallbackPtr()), callback);

        doCallTheCallback(a);
        assertEquals(a, refA.value);
        assertNotSame(a, refA.value);

        refA.value = null;
        CallNative_Mem_V.wrap(getCallbackPtr()).call(a);
        assertEquals(a, refA.value);
        assertNotSame(a, refA.value);

        callback = null;

        System.runFinalization();
        System.gc();

        assertEquals(Callback_Mem_V_Impl.MAX_CALL_BACKS(), Callback_Mem_V_Impl.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertEquals(getCallbackPtr(), nativeCallbackPointer);

        //Just check that the reference is gone...
        refA.value = null;
        doCallTheCallback(a);
        assertNull(refA.value);
    }

    /**
     * Test of release method, of class IntConsumerCallbackFactory.
     */
    @Test
    public void testReleaseByGarbageCollectorAndCleanup() throws Exception {
        System.out.println("release");
        Cleaner CLEANER = Cleaner.create();
        final ObjectRef<A> refA = new ObjectRef<>();
        A a = new A();

        @SuppressWarnings("unchecked")
        final Callback_Mem_V<A> NULL_PTR = new Callback_Mem_V(NativeAddressHolder.NULL) {
            @Override
            protected void callback(AbstractNativeMemory a) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        Callback_Mem_V_Impl<A> callback = new Callback_Mem_V_Impl<>() {

            @Override
            protected void callback(A a) {
                refA.value = a;
            }

            @Override
            protected A wrapA(NativeAddressHolder address) {
                return new A(address);
            }

        };
        CLEANER.register(callback, () -> {
            setCallback(NULL_PTR);
        });

        setCallback(callback);

        assertEquals(getCallbackPtr(), callback);
        doCallTheCallback(a);
        assertEquals(a, refA.value);
        assertNotSame(a, refA.value);

        callback = null;

        System.runFinalization();
        System.gc();

        //sleep here, to let the CLEANER do it cleanup....
        Thread.sleep(10);

        assertEquals(getCallbackPtr(), NULL_PTR);

    }
}
