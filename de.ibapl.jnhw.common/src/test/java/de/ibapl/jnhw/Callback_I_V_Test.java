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
package de.ibapl.jnhw;

import java.lang.ref.Cleaner;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class Callback_I_V_Test {

    private class DummyCB extends Callback_I_V_Impl {

        @Override
        protected void callback(int value) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
    
    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        LibJnhwCommonTestLoader.touch();
    }
    
    public Callback_I_V_Test() {
    }
    
    private static native NativeFunctionPointer getCallbackPtr();
    
    private static native void setCallback(Callback_I_V callback);
    
    private static native void doCallTheCallback(int value);

    /**
     * Test of MAX_INT_CONSUMER_CALLBACKS method, of class
     * IntConsumerCallbackFactory.
     */
    @Test
    public void testMAX_CALL_BACKS() {
        System.out.println("MAX_CALL_BACKS");
        int maxCB = Callback_I_V_Impl.MAX_CALL_BACKS();
        assertEquals(8, maxCB);
        Callback_I_V[] cbs = new Callback_I_V[maxCB];
        for (int i = 0; i < cbs.length; i++) {
            cbs[i] = new DummyCB();
            assertEquals(maxCB - (i + 1), Callback_I_V_Impl.callbacksAvailable());
        }

        RuntimeException re = assertThrows(RuntimeException.class, () -> {
            new DummyCB();
        });
        assertEquals("No more Callbacks available! max: 8 reached", re.getMessage());

        cbs = null;

        System.runFinalization();
        System.gc();

        assertEquals(maxCB, Callback_I_V_Impl.callbacksAvailable());
    }
    
    @Test
    public void testNativeFunctionPointer() {
        final Callback_I_V testPtr = new Callback_I_V(new NativeAddressHolder(121)) {
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
        final IntRef intref = new IntRef();
        final Callback_I_V NULL_PTR = new Callback_I_V(new NativeAddressHolder(0)) {
            @Override
            protected void callback(int value) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };
        final Thread t = Thread.currentThread();
        Callback_I_V_Impl callback = new Callback_I_V_Impl() {
            
            @Override
            protected void callback(int value) {
                if (!t.equals(Thread.currentThread())) {
                    intref.value = value;
                }
            }
            
        };
        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback);
        
        setCallback(callback);
        
        assertEquals(getCallbackPtr(), callback);
        assertSame(Callback_I_V_Impl.find(getCallbackPtr()), callback);
        doCallTheCallback(42);
        assertEquals(42, intref.value);
        
        callback = null;
        
        System.runFinalization();
        System.gc();

        assertEquals(Callback_I_V_Impl.MAX_CALL_BACKS(), Callback_I_V_Impl.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertEquals(getCallbackPtr(), nativeCallbackPointer);

        //Just check that the reference is gone...
        intref.value = -1;
        doCallTheCallback(84);
        assertEquals(-1, intref.value);
    }

    /**
     * Test of release method, of class IntConsumerCallbackFactory.
     */
    @Test
    public void testReleaseByGarbageCollectorAndCleanup() throws Exception {
        System.out.println("release");
        Cleaner CLEANER = Cleaner.create();
        
        final IntRef intref = new IntRef();
        final Callback_I_V NULL_PTR = new Callback_I_V(new NativeAddressHolder(0)) {
            @Override
            protected void callback(int value) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        Callback_I_V_Impl callback = new Callback_I_V_Impl() {
            
            @Override
            protected void callback(int value) {
                intref.value = value;
            }
            
        };
        CLEANER.register(callback, () -> {
            setCallback(NULL_PTR);
        });
        
        setCallback(callback);
        
        assertEquals(getCallbackPtr(), callback);
        doCallTheCallback(42);
        assertEquals(42, intref.value);
        
        callback = null;
        
        System.runFinalization();
        System.gc();

        //sleep here, to let the CLEANER do it cleanup....
        Thread.sleep(10);
        
        assertEquals(getCallbackPtr(), NULL_PTR);
        
    }
}
