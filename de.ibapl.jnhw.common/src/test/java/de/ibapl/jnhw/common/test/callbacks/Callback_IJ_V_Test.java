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
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import java.lang.ref.Cleaner;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.WordSize;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author aploese
 */
public class Callback_IJ_V_Test {

    private final static MultiarchTupelBuilder MULTIARCH_TUPEL_BUILDER = new MultiarchTupelBuilder();
    private final static long CB_VALUE;

    static {
        switch (MULTIARCH_TUPEL_BUILDER.getWordSize()) {
            case _32_BIT:
                CB_VALUE = 0x00000000FEDCBA98L;
                break;
            case _64_BIT:
                CB_VALUE = 0xFEDCBA9876543210L;
                break;
            default:
                throw new RuntimeException("Unknown Wordsize " + MULTIARCH_TUPEL_BUILDER.getWordSize());
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

    private static native CallNative_IJ_V getCallbackPtr();

    private static native void setCallback(Callback_IJ_V callback);

    private static native void doCallTheCallback(long value);

    @Test
    public void testAlignofIntptr_t() {
        switch (MULTIARCH_TUPEL_BUILDER.getWordSize()) {
            case _32_BIT:
                assertEquals(4, Callback_IJ_V.alignofIntptr_t());
                break;
            case _64_BIT:
                assertEquals(8, Callback_IJ_V.alignofIntptr_t());
                break;
            default:
                throw new RuntimeException("Unknown Wordsize " + MULTIARCH_TUPEL_BUILDER.getWordSize());
        }
    }

    @Test
    public void testSizeofIntptr_t() {
        switch (MULTIARCH_TUPEL_BUILDER.getWordSize()) {
            case _32_BIT:
                assertEquals(4, Callback_IJ_V.sizeofIntptr_t());
                break;
            case _64_BIT:
                assertEquals(8, Callback_IJ_V.sizeofIntptr_t());
                break;
            default:
                throw new RuntimeException("Unknown Wordsize " + MULTIARCH_TUPEL_BUILDER.getWordSize());
        }
    }

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
        final Callback_IJ_V testPtr = new Callback_IJ_V(new NativeAddressHolder(121)) {
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
        final ObjectRef<Object> ref = new ObjectRef();

        final Callback_IJ_V NULL_PTR = new Callback_IJ_V(new NativeAddressHolder(0)) {
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
                    ref.value = value;
                } else {
                    ref.value = Thread.currentThread();
                }
            }

            @Override
            protected void callback(int value) {
                if (!t.equals(Thread.currentThread())) {
                    ref.value = value;
                } else {
                    ref.value = Thread.currentThread();
                }
            }

        };
        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback);

        setCallback(callback);

        assertEquals(getCallbackPtr(), callback);
        assertSame(Callback_IJ_V_Impl.find(getCallbackPtr()), callback);
        doCallTheCallback(CB_VALUE);
        switch (MULTIARCH_TUPEL_BUILDER.getWordSize()) {
            case _32_BIT:
                assertTrue(ref.value instanceof Integer, "ref.value not Integer.class");
                assertEquals((int) CB_VALUE, ref.value, String.format("ref mismatch for 32 bit - CB_VALUE = 0x%08x, value = 0x%04x ", CB_VALUE, ref.value));
                break;
            case _64_BIT:
                assertEquals(CB_VALUE, ref.value);
                break;
            default:
                throw new RuntimeException("Unknown Wordsize " + MULTIARCH_TUPEL_BUILDER.getWordSize());
        }

        callback = null;

        System.runFinalization();
        System.gc();

        assertEquals(Callback_IJ_V_Impl.MAX_CALL_BACKS(), Callback_IJ_V_Impl.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertEquals(getCallbackPtr(), nativeCallbackPointer);

        //Just check that the reference is gone...
        ref.value = -1L;
        doCallTheCallback(~CB_VALUE);
        assertEquals(-1L, ref.value);
    }

    /**
     * Test of release method, of class IntConsumerCallbackFactory.
     */
    @Test
    public void testReleaseByGarbageCollectorAndCleanup() throws Exception {
        System.out.println("release");
        Cleaner CLEANER = Cleaner.create();

        final ObjectRef<Number> ref = new ObjectRef<>();
        final Callback_IJ_V NULL_PTR = new Callback_IJ_V(new NativeAddressHolder(0)) {
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
        switch (MULTIARCH_TUPEL_BUILDER.getWordSize()) {
            case _32_BIT:
                assertEquals(Integer.valueOf((int) CB_VALUE), ref.value);
                break;
            case _64_BIT:
                assertEquals(Long.valueOf(CB_VALUE), ref.value);
                break;
            default:
                throw new RuntimeException("Unknown Wordsize " + MULTIARCH_TUPEL_BUILDER.getWordSize());
        }

        ref.value = -1;
        
        if (MULTIARCH_TUPEL_BUILDER.getWordSize() == WordSize._32_BIT) {
            assertThrows(IllegalArgumentException.class, ()->getCallbackPtr().call(CB_VALUE));
        }
        
        getCallbackPtr().call(CB_VALUE);
        switch (MULTIARCH_TUPEL_BUILDER.getWordSize()) {
            case _32_BIT:
                assertEquals(Integer.valueOf((int) CB_VALUE), ref.value);
                break;
            case _64_BIT:
                assertEquals(Long.valueOf(CB_VALUE), ref.value);
                break;
            default:
                throw new RuntimeException("Unknown Wordsize " + MULTIARCH_TUPEL_BUILDER.getWordSize());
        }
        if (MULTIARCH_TUPEL_BUILDER.getWordSize() == WordSize._32_BIT) {
            ref.value = -1;
            assertThrows(IllegalArgumentException.class, () -> getCallbackPtr().call(-1L - Integer.MIN_VALUE));
            assertThrows(IllegalArgumentException.class, () -> getCallbackPtr().call(1L + Integer.MAX_VALUE));
        }

        callback = null;

        System.runFinalization();
        System.gc();

        //sleep here, to let the CLEANER do the cleanup....
        Thread.sleep(10);

        assertEquals(getCallbackPtr(), NULL_PTR);

    }
}
