/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2019, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw;

import java.lang.ref.Cleaner;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class Callback_I_PtrOpaquememory_PtrOpaquememory_V_Test {

    static class A extends OpaqueMemory {

        public final static int SIZE_OF = 2;

        public A(long nativeAddress) {
            super(nativeAddress, SIZE_OF);
        }

        public A() {
            super(SIZE_OF, true);
        }

    }

    static class B extends OpaqueMemory {

        public final static int SIZE_OF = 4;

        public B(long nativeAddress) {
            super(nativeAddress, SIZE_OF);
        }

        public B() {
            super(SIZE_OF, true);
        }

    }

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        LibJnhwCommonTestLoader.touch();
    }

    public Callback_I_PtrOpaquememory_PtrOpaquememory_V_Test() {
    }

    private native NativeFunctionPointer<Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V<A, B>> getCallbackPtr();

    private native void setCallback(NativeFunctionPointer<Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V<A, B>> callback);

    private native void doCallTheCallback(int value, A a, B b);

    /**
     * Test of MAX_INT_CONSUMER_CALLBACKS method, of class
     * IntConsumerCallbackFactory.
     */
    @Test
    public void testMAX_CALL_BACKS() {
        System.out.println("MAX_CALL_BACKS");
        int result = Callback_I_V.MAX_CALL_BACKS();
        assertEquals(2, result);
        assertEquals(Callback_I_V.MAX_CALL_BACKS(), Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V.callbacksAvailable());
    }

    @Test
    public void testNativeFunctionPointer() {
        final var testPtr = new NativeFunctionPointer<Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V<A, B>>(121);
        setCallback(testPtr);
        assertTrue(getCallbackPtr().addressEquals(testPtr));
    }

    /**
     * Test of release method, of class IntConsumerCallbackFactory.
     */
    @Test
    public void testReleaseByGarbageCollector() {
        System.out.println("release");
        final IntRef intref = new IntRef();
        final ObjectRef<A> refA = new ObjectRef();
        final ObjectRef<B> refB = new ObjectRef();
        A a = new A();
        B b = new B();
        Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V<A, B> callback = new Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V<A, B>() {

            @Override
            protected void callback(int value, A a, B b) {
                intref.value = value;
                refA.value = a;
                refB.value = b;
            }

            @Override
            protected A wrapA(long address) {
                return new A(address);
            }

            @Override
            protected B wrapB(long address) {
                return new B(address);
            }

        };
        final var nativeCallbackPointer = new NativeFunctionPointer(callback);

        setCallback(callback);

        assertTrue(getCallbackPtr().addressEquals(callback));
        doCallTheCallback(42, a, b);
        assertEquals(42, intref.value);
        assertEquals(a, refA.value);
        assertEquals(b, refB.value);
        assertNotSame(a, refA.value);
        assertNotSame(b, refB.value);

        callback = null;

        System.runFinalization();
        System.gc();

        assertEquals(Callback_I_V.MAX_CALL_BACKS(), Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertTrue(getCallbackPtr().addressEquals(nativeCallbackPointer));

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
        final ObjectRef<A> refA = new ObjectRef();
        final ObjectRef<B> refB = new ObjectRef();
        A a = new A();
        B b = new B();

        final IntRef intref = new IntRef();
        final var NULL_PTR = new NativeFunctionPointer<Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V<A, B>>(0);
        Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V<A, B> callback = new Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V<>() {

            @Override
            protected void callback(int value, A a, B b) {
                intref.value = value;
                refA.value = a;
                refB.value = b;
            }

            @Override
            protected A wrapA(long address) {
                return new A(address);
            }

            @Override
            protected B wrapB(long address) {
                return new B(address);
            }

        };
        CLEANER.register(callback, () -> {
            setCallback(NULL_PTR);
        });

        setCallback(callback);

        assertTrue(getCallbackPtr().addressEquals(callback));
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

        assertTrue(getCallbackPtr().addressEquals(NULL_PTR));

    }
}
