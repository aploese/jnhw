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

import de.ibapl.jnhw.common.downcall.JnhwMi__V___A;
import de.ibapl.jnhw.common.memory.MemoryHeap;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr__V__MA;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import de.ibapl.jnhw.common.upcall.CallbackFactory__V__MA;
import de.ibapl.jnhw.common.upcall.Callback__V__MA;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.lang.ref.Cleaner;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class Callback__V__MA_Test {

    final static MethodHandle setCallback__V__MA;
    final static MethodHandle getCallback__V__MA;
    final static MethodHandle doCallback__V__MA;

    static {
        LibJnhwCommonTestLoader.touch();
        setCallback__V__MA = LibJnhwCommonTestLoader.downcallHandle("setCallback__V__MA", FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
        getCallback__V__MA = LibJnhwCommonTestLoader.downcallHandle("getCallback__V__MA", FunctionDescriptor.of(ValueLayout.ADDRESS));
        doCallback__V__MA = LibJnhwCommonTestLoader.downcallHandle("doCallback__V__MA", FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
    }

    private MemorySession ms;

    private class DummyCB extends Callback__V__MA {

        @Override
        protected void callback(MemoryAddress address) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    @BeforeEach
    public void setUpBefore() throws Exception {
        System.gc();
        ms = MemorySession.openConfined();
    }

    @AfterEach
    public void cleanupAfterEach() throws Exception {
        ms.close();
    }

    private static FunctionPtr__V__MA getCallback__V__MA() {
        try {
            return FunctionPtr__V__MA.wrap((MemoryAddress) getCallback__V__MA.invokeExact());
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void setCallback__V__MA(FunctionPtr__V__MA callback) {
        try {
            setCallback__V__MA.invokeExact(callback.toAddressable());
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void doCallback__V__MA(OpaqueMemory a) {
        try {
            doCallback__V__MA.invokeExact(a.toAddressable());
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    /**
     * Test of MAX_INT_CONSUMER_CALLBACKS method, of class
     * IntConsumerCallbackFactory.
     */
    @Test
    public void testMAX_CALL_BACKS() {
        System.out.println("MAX_CALL_BACKS");
        assertEquals(16, CallbackFactory__V__MA.MAX_CALL_BACKS);
        Callback__V__MA[] cbs = new Callback__V__MA[CallbackFactory__V__MA.MAX_CALL_BACKS];
        for (int i = 0; i < cbs.length; i++) {
            cbs[i] = new DummyCB();
            assertEquals(CallbackFactory__V__MA.MAX_CALL_BACKS - (i + 1), CallbackFactory__V__MA.callbacksAvailable());
        }

        RuntimeException re = assertThrows(RuntimeException.class, () -> {
            new DummyCB();
        });
        assertEquals("No more Callbacks available! max: 16 reached", re.getMessage());

        cbs = null;

        System.gc();

        assertEquals(CallbackFactory__V__MA.MAX_CALL_BACKS, CallbackFactory__V__MA.callbacksAvailable());
    }

    @Test
    public void testNativeFunctionPointer() {
        final Callback__V__MA testPtr = new Callback__V__MA(MemoryAddress.ofLong(121)) {
            @Override
            protected void callback(MemoryAddress address) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };
        setCallback__V__MA(testPtr);
        assertEquals(getCallback__V__MA(), testPtr);
    }

    /**
     * Test of release method, of class IntConsumerCallbackFactory.
     */
    @Test
    public void testReleaseByGarbageCollector() {
        System.out.println("release");
        final int[] intref = new int[1];
        final Callback__V__MA NULL_PTR = new Callback__V__MA(MemoryAddress.NULL) {
            @Override
            protected void callback(MemoryAddress address) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };
        final Thread t = Thread.currentThread();
        Callback__V__MA callback = new Callback__V__MA() {

            @Override
            protected void callback(MemoryAddress address) {
                if (t.equals(Thread.currentThread())) {
                    intref[0] = 42;
                } else {
                    intref[0] = -42;
                }
            }

        };
        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback.toAddressable().address());

        setCallback__V__MA(callback);

        assertEquals(getCallback__V__MA(), callback);
        assertSame(Callback__V__MA.find(getCallback__V__MA()), callback);

        intref[0] = 0;
        doCallback__V__MA(new MemoryHeap(MemoryAddress.ofLong(42), ms, 1));
        assertEquals(42, intref[0]);

        intref[0] = 0;
        new JnhwMi__V___A(getCallback__V__MA().toAddressable().address(), ms).invoke__V___P(new MemoryHeap(MemoryAddress.ofLong(42), ms, 1));
        assertEquals(42, intref[0]);

        callback = null;

        System.gc();

        assertEquals(CallbackFactory__V__MA.MAX_CALL_BACKS, CallbackFactory__V__MA.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertEquals(getCallback__V__MA(), nativeCallbackPointer);

        //Just check that the reference is gone...
        intref[0] = -1;
        doCallback__V__MA(new MemoryHeap(MemoryAddress.ofLong(84), ms, 1));
        assertEquals(-1, intref[0]);

        intref[0] = -1;
        //The logs shoud show: Unassigned callback for trampoline(0, 84)
        new JnhwMi__V___A(getCallback__V__MA().toAddressable().address(), ms).invoke__V___P(new MemoryHeap(MemoryAddress.ofLong(84), ms, 1));
        assertEquals(-1, intref[0]);

    }

    /**
     * Test of release method, of class IntConsumerCallbackFactory.
     */
    @Test
    public void testReleaseByGarbageCollectorAndCleanup() throws Exception {
        System.out.println("release");
        Cleaner CLEANER = Cleaner.create();

        final int[] intref = new int[1];
        final Callback__V__MA NULL_PTR = new Callback__V__MA(MemoryAddress.NULL) {
            @Override
            protected void callback(MemoryAddress address) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        Callback__V__MA callback = new Callback__V__MA() {

            @Override
            protected void callback(MemoryAddress address) {
                intref[0] = 42;
            }

        };
        CLEANER.register(callback, () -> {
            setCallback__V__MA(NULL_PTR);
        });

        setCallback__V__MA(callback);

        assertEquals(getCallback__V__MA(), callback);
        doCallback__V__MA(new MemoryHeap(MemoryAddress.ofLong(42), ms, 1));
        assertEquals(42, intref[0]);

        intref[0] = 0;
        new JnhwMi__V___A(getCallback__V__MA().toAddressable().address(), ms).invoke__V___P(new MemoryHeap(MemoryAddress.ofLong(42), ms, 1));
        assertEquals(42, intref[0]);

        callback = null;

        System.gc();

        //sleep here, to let the CLEANER do it cleanup....
        Thread.sleep(10);

        assertEquals(getCallback__V__MA(), NULL_PTR);

    }
}
