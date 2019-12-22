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
public class Callback_I_V_Test {
    
    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        LibJnhwCommonTestLoader.touch();
    }
    
    public Callback_I_V_Test() {
    }
    
    private native NativeFunctionPointer<Callback_I_V> getCallbackPtr();
    
    private native void setCallback(NativeFunctionPointer<Callback_I_V> callback);
    
    private native void doCallTheCallback(int value);

    /**
     * Test of MAX_INT_CONSUMER_CALLBACKS method, of class
     * IntConsumerCallbackFactory.
     */
    @Test
    public void testMAX_CALL_BACKS() {
        System.out.println("MAX_CALL_BACKS");
        int result = Callback_I_V.MAX_CALL_BACKS();
        assertEquals(2, result);
        assertEquals(Callback_I_V.MAX_CALL_BACKS(), Callback_I_V.callbacksAvailable());
    }
    
    @Test
    public void testNativeFunctionPointer() {
        final var testPtr = new NativeFunctionPointer<Callback_I_V>(121);
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
        final var NULL_PTR = new NativeFunctionPointer<Callback_I_V>(0);
        Callback_I_V callback = new Callback_I_V() {
            
            @Override
            protected void callback(int value) {
                intref.value = value;
            }
            
        };
        final var nativeCallbackPointer = new NativeFunctionPointer(callback);
        
        setCallback(callback);
        
        assertTrue(getCallbackPtr().addressEquals(callback));
        doCallTheCallback(42);
        assertEquals(42, intref.value);
        
        callback = null;
        
        System.runFinalization();
        System.gc();

        assertEquals(Callback_I_V.MAX_CALL_BACKS(), Callback_I_V.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertTrue(getCallbackPtr().addressEquals(nativeCallbackPointer));

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
        final var NULL_PTR = new NativeFunctionPointer<Callback_I_V>(0);
        Callback_I_V callback = new Callback_I_V() {
            
            @Override
            protected void callback(int value) {
                intref.value = value;
            }
            
        };
        CLEANER.register(callback, () -> {
            setCallback(NULL_PTR);
        });
        
        setCallback(callback);
        
        assertTrue(getCallbackPtr().addressEquals(callback));
        doCallTheCallback(42);
        assertEquals(42, intref.value);
        
        callback = null;
        
        System.runFinalization();
        System.gc();

        //sleep here, to let the CLEANER do it cleanup....
        Thread.sleep(10);
        
        assertTrue(getCallbackPtr().addressEquals(NULL_PTR));
        
    }
}
