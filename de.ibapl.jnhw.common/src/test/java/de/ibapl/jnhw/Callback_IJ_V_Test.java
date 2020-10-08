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
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import de.ibapl.jnhw.libloader.MultiarchInfo;
import de.ibapl.jnhw.libloader.MultiarchInfo.WordSize;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;

/**
 *
 * @author aploese
 */
public class Callback_IJ_V_Test {

    private static WordSize WORD_SIZE;

    @BeforeAll
    public static void setUpClass() {
        MultiarchInfo multiarchInfo = new MultiarchTupelBuilder().guessMultiarch().iterator().next();
        WORD_SIZE = multiarchInfo.getWordSize();
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

    private static native NativeFunctionPointer getCallbackPtr();

    private static native void setCallback(Callback_IJ_V callback);

    private static native void doCallTheCallback(long value);

    /**
     * Test of MAX_INT_CONSUMER_CALLBACKS method, of class
     * IntConsumerCallbackFactory.
     */
    @Test
    public void testMAX_CALL_BACKS() {
        System.out.println("MAX_CALL_BACKS");
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
        final LongRef longRef = new LongRef();
        final IntRef intRef = new IntRef();

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
                    longRef.value = value;
                }
            }

            @Override
            protected void callback(int value) {
                if (!t.equals(Thread.currentThread())) {
                    intRef.value = value;
                }
            }

        };
        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback);

        setCallback(callback);

        assertEquals(getCallbackPtr(), callback);
        assertSame(Callback_IJ_V_Impl.find(getCallbackPtr()), callback);
        doCallTheCallback(42);
        switch (WORD_SIZE) {
            case _32_BIT:
                assertEquals(42, intRef.value);
                break;
            case _64_BIT:
                assertEquals(42, longRef.value);
                break;
            default:
                throw new RuntimeException("Unknown Wordsize " + WORD_SIZE);
        }

        callback = null;

        System.runFinalization();
        System.gc();

        assertEquals(Callback_IJ_V_Impl.MAX_CALL_BACKS(), Callback_IJ_V_Impl.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertEquals(getCallbackPtr(), nativeCallbackPointer);

        //Just check that the reference is gone...
        longRef.value = -1;
        doCallTheCallback(84);
        assertEquals(-1, longRef.value);
    }

    /**
     * Test of release method, of class IntConsumerCallbackFactory.
     */
    @Test
    public void testReleaseByGarbageCollectorAndCleanup() throws Exception {
        System.out.println("release");
        Cleaner CLEANER = Cleaner.create();

        final LongRef longRef = new LongRef();
        final IntRef intRef = new IntRef();
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
                longRef.value = value;
            }

            @Override
            protected void callback(int value) {
                intRef.value = value;
            }

        };
        CLEANER.register(callback, () -> {
            setCallback(NULL_PTR);
        });

        setCallback(callback);

        assertEquals(getCallbackPtr(), callback);
        doCallTheCallback(42);
        switch (WORD_SIZE) {
            case _32_BIT:
                assertEquals(42, intRef.value);
                break;
            case _64_BIT:
                assertEquals(42, longRef.value);
                break;
            default:
                throw new RuntimeException("Unknown Wordsize " + WORD_SIZE);
        }

        callback = null;

        System.runFinalization();
        System.gc();

        //sleep here, to let the CLEANER do it cleanup....
        Thread.sleep(10);

        assertEquals(getCallbackPtr(), NULL_PTR);

    }
}
