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

import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr__V___I;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import de.ibapl.jnhw.common.upcall.CallbackFactory__V___I;
import de.ibapl.jnhw.common.upcall.Callback__V___I;
import java.lang.invoke.MethodHandle;
import java.lang.ref.Cleaner;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.ValueLayout;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import de.ibapl.jnhw.common.downcall.JnhwMi__V___I;

/**
 *
 * @author aploese
 */
public class Callback__V___I_Test {

    final static MethodHandle setCallback__V___I;
    final static MethodHandle getCallback__V___I;
    final static MethodHandle doCallback__V___I;

    static {
        LibJnhwCommonTestLoader.touch();
        setCallback__V___I = LibJnhwCommonTestLoader.downcallHandle("setCallback__V___I", FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
        getCallback__V___I = LibJnhwCommonTestLoader.downcallHandle("getCallback__V___I", FunctionDescriptor.of(ValueLayout.ADDRESS));
        doCallback__V___I = LibJnhwCommonTestLoader.downcallHandle("doCallback__V___I", FunctionDescriptor.ofVoid(ValueLayout.JAVA_BOOLEAN, ValueLayout.JAVA_INT));
    }

    private ResourceScope rs;

    private class DummyCB extends Callback__V___I {

        @Override
        protected void callback(int value) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    @BeforeEach
    public void setUpBefore() throws Exception {
        System.runFinalization();
        System.gc();
        rs = ResourceScope.newConfinedScope();
    }

    @AfterEach
    public void cleanupAfterEach() throws Exception {
        rs.close();
    }

    private FunctionPtr__V___I getCallback__V___I() {
        try {
            return FunctionPtr__V___I.wrap((MemoryAddress) getCallback__V___I.invokeExact());
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void setCallback__V___I(FunctionPtr__V___I callback) {
        try {
            setCallback__V___I.invokeExact(callback.toAddressable());
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void doCallback__V___I(boolean newThread, int value) {
        try {
            doCallback__V___I.invokeExact(newThread, value);
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
        assertEquals(16, CallbackFactory__V___I.MAX_CALL_BACKS);
        Callback__V___I[] cbs = new Callback__V___I[CallbackFactory__V___I.MAX_CALL_BACKS];
        for (int i = 0; i < cbs.length; i++) {
            cbs[i] = new DummyCB();
            assertEquals(CallbackFactory__V___I.MAX_CALL_BACKS - (i + 1), CallbackFactory__V___I.callbacksAvailable());
        }

        RuntimeException re = assertThrows(RuntimeException.class, () -> {
            new DummyCB();
        });
        assertEquals("No more Callbacks available! max: 16 reached", re.getMessage());

        cbs = null;

        System.gc();
        System.runFinalization();
        System.gc();

        assertEquals(CallbackFactory__V___I.MAX_CALL_BACKS, CallbackFactory__V___I.callbacksAvailable());
    }

    @Test
    public void testNativeFunctionPointer() throws Exception {
        final Callback__V___I testPtr = new Callback__V___I(MemoryAddress.ofLong(121)) {
            @Override
            protected void callback(int value) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };
        setCallback__V___I(testPtr);
        assertEquals(getCallback__V___I().toAddressable().address(), testPtr.toAddressable().address());
    }

    /**
     * Test of release method, of class IntConsumerCallbackFactory.
     */
    @Test
    public void testReleaseByGarbageCollector() throws Exception {
        System.out.println("release");
        final int[] intref = new int[1];
        final Callback__V___I NULL_PTR = new Callback__V___I(MemoryAddress.NULL) {
            @Override
            protected void callback(int value) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };
        final Thread t = Thread.currentThread();
        Callback__V___I callback = new Callback__V___I() {

            @Override
            protected void callback(int value) {
                if (!t.equals(Thread.currentThread())) {
                    intref[0] = value;
                } else {
                    intref[0] = -value;
                }
            }

        };
        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback.toAddressable().address());

        setCallback__V___I(callback);

        assertEquals(getCallback__V___I(), callback);
        assertSame(Callback__V___I.find(getCallback__V___I()), callback);

        intref[0] = 0;
        doCallback__V___I(true, 42);
        assertEquals(42, intref[0]);

        intref[0] = 0;
        new JnhwMi__V___I(getCallback__V___I().toAddressable().address(), rs).invoke__V__sI(42);
        assertEquals(-42, intref[0]);

        callback = null;

        System.runFinalization();
        System.gc();

        assertEquals(CallbackFactory__V___I.MAX_CALL_BACKS, CallbackFactory__V___I.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertEquals(getCallback__V___I(), nativeCallbackPointer);

        //Just check that the reference is gone...
        intref[0] = -1;
        doCallback__V___I(true, 84);
        assertEquals(-1, intref[0]);

        intref[0] = -1;
        //The logs shoud show: Unassigned callback for trampoline(0, 84)
        new JnhwMi__V___I(getCallback__V___I().toAddressable().address(), rs).invoke__V__sI(84);
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
        final Callback__V___I NULL_PTR = new Callback__V___I(MemoryAddress.NULL) {
            @Override
            protected void callback(int value) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        Callback__V___I callback = new Callback__V___I() {

            @Override
            protected void callback(int value) {
                intref[0] = value;
            }

        };
        CLEANER.register(callback, () -> {
            try {
                setCallback__V___I(NULL_PTR);
            } catch (Throwable ex) {
                ex.printStackTrace();
            }
        });

        setCallback__V___I(callback);

        assertEquals(getCallback__V___I(), callback);
        doCallback__V___I(true, 42);
        assertEquals(42, intref[0]);

        intref[0] = 0;
        new JnhwMi__V___I(getCallback__V___I().toAddressable().address(), rs).invoke__V__sI(42);
        assertEquals(42, intref[0]);

        callback = null;

        System.runFinalization();
        System.gc();

        //sleep here, to let the CLEANER do it cleanup....
        Thread.sleep(10);

        assertEquals(getCallback__V___I(), NULL_PTR);

    }
}
