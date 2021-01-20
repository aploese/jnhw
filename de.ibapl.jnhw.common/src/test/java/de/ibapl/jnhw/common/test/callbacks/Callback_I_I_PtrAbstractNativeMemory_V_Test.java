/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.callbacks.Callback_I_I_PtrAbstractNativeMemory_V;
import de.ibapl.jnhw.common.callbacks.Callback_I_I_PtrAbstractNativeMemory_V_Impl;
import de.ibapl.jnhw.common.references.ObjectRef;
import de.ibapl.jnhw.common.references.IntRef;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.Memory32Heap;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import java.lang.ref.Cleaner;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class Callback_I_I_PtrAbstractNativeMemory_V_Test {

    static class C extends Memory32Heap {

        public final static int SIZE_OF = 2;

        public C(NativeAddressHolder nativeAddress) {
            super(nativeAddress, SIZE_OF);
        }

        public C() {
            super(SIZE_OF, true);
        }

    }

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        LibJnhwCommonTestLoader.touch();
    }

    public Callback_I_I_PtrAbstractNativeMemory_V_Test() {
    }

    private static native NativeFunctionPointer getCallbackPtr();

    private static native void setCallback(Callback_I_I_PtrAbstractNativeMemory_V<C> callback);

    private static native void doCallTheCallback(int a, int b, C c);

    private class DummyCB extends Callback_I_I_PtrAbstractNativeMemory_V_Impl<OpaqueMemory32> {

        @Override
        protected void callback(int a, int b, OpaqueMemory32 c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        protected OpaqueMemory32 wrapC(NativeAddressHolder address) {
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
        int maxCB = Callback_I_I_PtrAbstractNativeMemory_V_Impl.MAX_CALL_BACKS();
        assertEquals(8, maxCB);
        Callback_I_I_PtrAbstractNativeMemory_V_Impl[] cbs = new Callback_I_I_PtrAbstractNativeMemory_V_Impl[maxCB];
        for (int i = 0; i < cbs.length; i++) {
            cbs[i] = new DummyCB();
            assertEquals(maxCB - (i + 1), Callback_I_I_PtrAbstractNativeMemory_V_Impl.callbacksAvailable());
        }

        RuntimeException re = assertThrows(RuntimeException.class, () -> {
            new DummyCB();
        });
        assertEquals("No more Callbacks available! max: 8 reached", re.getMessage());

        cbs = null;

        System.runFinalization();
        System.gc();

        assertEquals(maxCB, Callback_I_I_PtrAbstractNativeMemory_V_Impl.callbacksAvailable());
    }

    @Test
    public void testNativeFunctionPointer() {
        @SuppressWarnings("unchecked")
        final Callback_I_I_PtrAbstractNativeMemory_V<C> testPtr = new Callback_I_I_PtrAbstractNativeMemory_V(new NativeAddressHolder(121)) {
            @Override
            protected void callback(int a, int b, AbstractNativeMemory c) {
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
        final IntRef refA = new IntRef();
        final IntRef refB = new IntRef();
        final ObjectRef<C> refC = new ObjectRef<>();
        C c = new C();
        Callback_I_I_PtrAbstractNativeMemory_V_Impl<C> callback = new Callback_I_I_PtrAbstractNativeMemory_V_Impl<>() {

            @Override
            protected void callback(int a, int b, C c) {
                refA.value = a;
                refB.value = b;
                refC.value = c;
            }

            @Override
            protected C wrapC(NativeAddressHolder address) {
                return new C(address);
            }

        };
        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback);

        setCallback(callback);

        assertEquals(getCallbackPtr(), callback);
        assertSame(Callback_I_I_PtrAbstractNativeMemory_V_Impl.find(getCallbackPtr()), callback);
        doCallTheCallback(42, 84, c);
        assertEquals(42, refA.value);
        assertEquals(84, refB.value);
        assertEquals(c, refC.value);
        assertNotSame(c, refC.value);

        callback = null;

        System.runFinalization();
        System.gc();

        assertEquals(Callback_I_I_PtrAbstractNativeMemory_V_Impl.MAX_CALL_BACKS(), Callback_I_I_PtrAbstractNativeMemory_V_Impl.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertEquals(getCallbackPtr(), nativeCallbackPointer);

        //Just check that the reference is gone...
        refA.value = -1;
        refB.value = -2;
        refC.value = null;
        doCallTheCallback(11, 23, c);
        assertEquals(-1, refA.value);
        assertEquals(-2, refB.value);
        assertNull(refC.value);
    }

    /**
     * Test of release method, of class IntConsumerCallbackFactory.
     */
    @Test
    public void testReleaseByGarbageCollectorAndCleanup() throws Exception {
        System.out.println("release");
        Cleaner CLEANER = Cleaner.create();
        final IntRef refA = new IntRef();
        final IntRef refB = new IntRef();
        final ObjectRef<C> refC = new ObjectRef<>();
        C c = new C();

        @SuppressWarnings("unchecked")
        final Callback_I_I_PtrAbstractNativeMemory_V<C> NULL_PTR = new Callback_I_I_PtrAbstractNativeMemory_V(new NativeAddressHolder(0)) {
            @Override
            protected void callback(int a, int b, AbstractNativeMemory c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        Callback_I_I_PtrAbstractNativeMemory_V_Impl<C> callback = new Callback_I_I_PtrAbstractNativeMemory_V_Impl<>() {

            @Override
            protected void callback(int a, int b, C c) {
                refA.value = a;
                refB.value = b;
                refC.value = c;
            }

            @Override
            protected C wrapC(NativeAddressHolder address) {
                return new C(address);
            }

        };
        CLEANER.register(callback, () -> {
            setCallback(NULL_PTR);
        });

        setCallback(callback);

        assertEquals(getCallbackPtr(), callback);
        doCallTheCallback(42, 41, c);
        assertEquals(42, refA.value);
        assertEquals(41, refB.value);
        assertEquals(c, refC.value);
        assertNotSame(c, refC.value);

        callback = null;

        System.runFinalization();
        System.gc();

        //sleep here, to let the CLEANER do it cleanup....
        Thread.sleep(10);

        assertEquals(getCallbackPtr(), NULL_PTR);

    }
}