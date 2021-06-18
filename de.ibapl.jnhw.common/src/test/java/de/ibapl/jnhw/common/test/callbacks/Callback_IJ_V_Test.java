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

import de.ibapl.jnhw.common.callback.Callback_IJ_V;
import de.ibapl.jnhw.common.callback.Callback_IJ_V_Impl;
import de.ibapl.jnhw.common.references.ObjectRef;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.nativecall.CallNative_IJ_V;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr_IJ_V;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import java.lang.ref.Cleaner;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.SizeInBit;

/**
 *
 * @author aploese
 */
public class Callback_IJ_V_Test {

    private final static MultiarchTupelBuilder MULTIARCH_TUPEL_BUILDER = new MultiarchTupelBuilder();
    private final static long CB_VALUE;

    static {
        switch (MULTIARCH_TUPEL_BUILDER.getSizeOfPointer()) {
            case _32_BIT:
                CB_VALUE = 0xFEDCBA98;
                break;
            case _64_BIT:
                CB_VALUE = 0xFEDCBA9876543210L;
                break;
            default:
                throw new RuntimeException("Unknown SizeOfPointer " + MULTIARCH_TUPEL_BUILDER.getSizeOfPointer());
        }

    }

    private class DummyCB extends Callback_IJ_V_Impl {

        @Override
        protected void callback(long value) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        protected void callback(int value) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        LibJnhwCommonTestLoader.touch();
    }

    public Callback_IJ_V_Test() {
    }

    private static native FunctionPtr_IJ_V getCallbackPtr();

    private static native void setCallback(Callback_IJ_V callback);

    private static native void doCallTheCallback(long value);

    /**
     * Test of MAX_INT_CONSUMER_CALLBACKS method, of class
     * IntConsumerCallbackFactory.
     */
    @Test
    public void testMAX_CALL_BACKS() {
        System.out.println("MAX_CALL_BACKS");

        //Cleanup
        System.runFinalization();
        System.gc();

        int maxCB = Callback_IJ_V_Impl.MAX_CALL_BACKS();
        assertEquals(8, maxCB);
        Callback_IJ_V[] cbs = new Callback_IJ_V[maxCB];
        for (int i = 0; i < cbs.length; i++) {
            cbs[i] = new DummyCB();
            assertEquals(maxCB - (i + 1), Callback_IJ_V_Impl.callbacksAvailable());
        }

        RuntimeException re = assertThrows(RuntimeException.class, () -> {
            new DummyCB();
        });
        assertEquals("No more Callbacks available! max: 8 reached", re.getMessage());

        cbs = null;

        System.runFinalization();
        System.gc();

        assertEquals(maxCB, Callback_IJ_V_Impl.callbacksAvailable());
    }

    @Test
    public void testNativeFunctionPointer() {
        final Callback_IJ_V testPtr = new Callback_IJ_V(NativeAddressHolder.ofUintptr_t(121)) {
            @Override
            protected void callback(long value) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            protected void callback(int value) {
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
        final Object[] ref = new Object[1];

        final Callback_IJ_V NULL_PTR = new Callback_IJ_V(NativeAddressHolder.NULL) {
            @Override
            protected void callback(long value) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            protected void callback(int value) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        final Thread t = Thread.currentThread();
        Callback_IJ_V_Impl callback = new Callback_IJ_V_Impl() {

            @Override
            protected void callback(long value) {
                if (!t.equals(Thread.currentThread())) {
                    ref[0] = value;
                } else {
                    ref[0] = Thread.currentThread();
                }
            }

            @Override
            protected void callback(int value) {
                if (!t.equals(Thread.currentThread())) {
                    ref[0] = value;
                } else {
                    ref[0] = Thread.currentThread();
                }
            }

        };
        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback);

        setCallback(callback);

        assertEquals(getCallbackPtr(), callback);
        assertSame(Callback_IJ_V_Impl.find(getCallbackPtr()), callback);
        doCallTheCallback(CB_VALUE);
        switch (MULTIARCH_TUPEL_BUILDER.getSizeOfPointer()) {
            case _32_BIT:
                assertTrue(ref[0] instanceof Integer, "ref.value not Integer.class");
                assertEquals((int) CB_VALUE, ref[0], String.format("ref mismatch for 32 bit pointers - CB_VALUE = 0x%08x, value = 0x%04x ", CB_VALUE, ref[0]));
                break;
            case _64_BIT:
                assertEquals(CB_VALUE, ref[0]);
                break;
            default:
                throw new RuntimeException("Unknown SizeOfPointer " + MULTIARCH_TUPEL_BUILDER.getSizeOfPointer());
        }

        callback = null;

        System.runFinalization();
        System.gc();

        assertEquals(Callback_IJ_V_Impl.MAX_CALL_BACKS(), Callback_IJ_V_Impl.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertEquals(getCallbackPtr(), nativeCallbackPointer);

        //Just check that the reference is gone...
        ref[0] = -1L;
        doCallTheCallback(~CB_VALUE);
        assertEquals(-1L, ref[0]);
    }

    /**
     * Test of release method, of class IntConsumerCallbackFactory.
     */
    @Test
    public void testReleaseByGarbageCollectorAndCleanup() throws Exception {
        System.out.println("release");
        Cleaner CLEANER = Cleaner.create();

        final ObjectRef<Number> ref = new ObjectRef<>();
        final Callback_IJ_V NULL_PTR = new Callback_IJ_V(NativeAddressHolder.NULL) {
            @Override
            protected void callback(int value) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            protected void callback(long value) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        Callback_IJ_V_Impl callback = new Callback_IJ_V_Impl() {

            @Override
            protected void callback(long value) {
                ref.value = value;
            }

            @Override
            protected void callback(int value) {
                ref.value = value;
            }

        };
        CLEANER.register(callback, () -> {
            setCallback(NULL_PTR);
        });

        setCallback(callback);

        assertEquals(getCallbackPtr(), callback);
        doCallTheCallback(CB_VALUE);
        switch (MULTIARCH_TUPEL_BUILDER.getSizeOfPointer()) {
            case _32_BIT:
                assertEquals(Integer.valueOf((int) CB_VALUE), ref.value);
                break;
            case _64_BIT:
                assertEquals(Long.valueOf(CB_VALUE), ref.value);
                break;
            default:
                throw new RuntimeException("Unknown Wordsize " + MULTIARCH_TUPEL_BUILDER.getSizeOfPointer());
        }

        ref.value = -1;

        CallNative_IJ_V.wrap(getCallbackPtr()).call(CB_VALUE);
        switch (MULTIARCH_TUPEL_BUILDER.getSizeOfPointer()) {
            case _32_BIT:
                assertEquals(Integer.valueOf((int) CB_VALUE), ref.value);
                break;
            case _64_BIT:
                assertEquals(Long.valueOf(CB_VALUE), ref.value);
                break;
            default:
                throw new RuntimeException("Unknown SizeOfPointer " + MULTIARCH_TUPEL_BUILDER.getSizeOfPointer());
        }
        if (MULTIARCH_TUPEL_BUILDER.getSizeOfPointer() == SizeInBit._32_BIT) {
            ref.value = -1;
            assertThrows(IllegalArgumentException.class, () -> CallNative_IJ_V.wrap(getCallbackPtr()).call((long) Integer.MIN_VALUE - 1L));
            assertThrows(IllegalArgumentException.class, () -> CallNative_IJ_V.wrap(getCallbackPtr()).call(1L + Integer.MAX_VALUE));
        }

        callback = null;

        System.runFinalization();
        System.gc();

        //sleep here, to let the CLEANER do the cleanup....
        Thread.sleep(10);

        assertEquals(getCallbackPtr(), NULL_PTR);

    }
}
