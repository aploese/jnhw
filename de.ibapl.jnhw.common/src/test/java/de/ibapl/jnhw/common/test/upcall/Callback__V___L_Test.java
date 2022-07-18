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
import de.ibapl.jnhw.common.nativepointer.FunctionPtr__V___L;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import de.ibapl.jnhw.common.upcall.CallbackFactory__V___L;
import de.ibapl.jnhw.common.upcall.Callback__V___L;
import java.lang.invoke.MethodHandle;
import java.lang.ref.Cleaner;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.ValueLayout;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import de.ibapl.jnhw.common.downcall.JnhwMi__V___L;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 */
public class Callback__V___L_Test {

    private final static MethodHandle setCallback__V___L;
    private final static MethodHandle getCallback__V___L;
    private final static MethodHandle doCallback__V___L;

    static {
        System.err.println("TODO setCallback__V___L 1");
        System.err.flush();
//        LibJnhwCommonTestLoader.touch();
        System.err.println("TODO setCallback__V___L 2");
        System.err.flush();
        setCallback__V___L = LibJnhwCommonTestLoader.downcallHandle("setCallback__V___L", FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
        System.err.println("TODO getCallback__V___L 3");
        System.err.flush();
        getCallback__V___L = LibJnhwCommonTestLoader.downcallHandle("getCallback__V___L", FunctionDescriptor.of(ValueLayout.ADDRESS));
        System.err.println("TODO doCallback__V___L 4");
        System.err.flush();
        doCallback__V___L = LibJnhwCommonTestLoader.downcallHandle("doCallback__V___L", FunctionDescriptor.ofVoid(ValueLayout.JAVA_BOOLEAN, ValueLayout.JAVA_LONG));
        System.err.println("TODO doCallback__V___L 5");
        System.err.flush();
    }

    private ResourceScope rs;

    private class DummyCB extends Callback__V___L {

        @Override
        protected void callback(long value) {
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

    private static FunctionPtr__V___L getCallback__V___L() {
        try {
            return FunctionPtr__V___L.wrap((MemoryAddress) getCallback__V___L.invokeExact());
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void setCallback__V___L(FunctionPtr__V___L callback) {
        try {
            setCallback__V___L.invokeExact(callback.toAddressable());
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static void doCallback__V___L(boolean newThread, long value) {
        try {
            doCallback__V___L.invokeExact(newThread, value);
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
        int maxCB = CallbackFactory__V___L.MAX_CALL_BACKS;
        assertEquals(16, maxCB);
        Callback__V___L[] cbs = new Callback__V___L[maxCB];
        for (int i = 0; i < cbs.length; i++) {
            cbs[i] = new DummyCB();
            assertEquals(maxCB - (i + 1), CallbackFactory__V___L.callbacksAvailable());
        }

        RuntimeException re = assertThrows(RuntimeException.class, () -> {
            new DummyCB();
        });
        assertEquals("No more Callbacks available! max: 16 reached", re.getMessage());

        cbs = null;

        System.runFinalization();
        System.gc();

        assertEquals(maxCB, CallbackFactory__V___L.callbacksAvailable());
    }

    @Test
    public void testNativeFunctionPointer() {
        final Callback__V___L testPtr = new Callback__V___L(MemoryAddress.ofLong(121)) {
            @Override
            protected void callback(long value) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };
        setCallback__V___L(testPtr);
        assertEquals(getCallback__V___L(), testPtr);
    }

    /**
     * Test of release method, of class IntConsumerCallbackFactory.
     */
    @Test
    public void testReleaseByGarbageCollector() {
        System.out.println("release");
        final long[] longRef = new long[1];
        final Callback__V___L NULL_PTR = new Callback__V___L(MemoryAddress.NULL) {
            @Override
            protected void callback(long value) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        };
        final Thread t = Thread.currentThread();
        Callback__V___L callback = new Callback__V___L() {

            @Override
            protected void callback(long value) {
                if (!t.equals(Thread.currentThread())) {
                    longRef[0] = value;
                }
            }

        };
        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback.toAddressable().address());

        setCallback__V___L(callback);

        assertEquals(getCallback__V___L(), callback);
        assertSame(Callback__V___L.find(getCallback__V___L()), callback);
        doCallback__V___L(true, 42);
        assertEquals(42, longRef[0]);

        callback = null;

        System.runFinalization();
        System.gc();

        assertEquals(CallbackFactory__V___L.MAX_CALL_BACKS, CallbackFactory__V___L.callbacksAvailable());
        //it is still callable, but its is only logged...
        assertEquals(getCallback__V___L(), nativeCallbackPointer);

        //Just check that the reference is gone...
        longRef[0] = -1;
        doCallback__V___L(false, 84);
        assertEquals(-1, longRef[0]);
    }

    /**
     * Test of release method, of class IntConsumerCallbackFactory.
     */
    @Test
    public void testReleaseByGarbageCollectorAndCleanup() throws Exception {
        System.out.println("release");
        Cleaner CLEANER = Cleaner.create();

        final long[] longRef = new long[1];
        final Callback__V___L NULL_PTR = new Callback__V___L(MemoryAddress.NULL) {
            @Override
            protected void callback(long value) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        Callback__V___L callback = new Callback__V___L() {

            @Override
            protected void callback(long value) {
                longRef[0] = value;
            }

        };
        CLEANER.register(callback, () -> {
            setCallback__V___L(NULL_PTR);
        });

        setCallback__V___L(callback);

        assertEquals(getCallback__V___L(), callback);
        doCallback__V___L(true, 42);
        assertEquals(42, longRef[0]);

        longRef[0] = -1;
        new JnhwMi__V___L(getCallback__V___L().toAddressable().address(), rs).invoke__V__sL(42L);
        assertEquals(42, longRef[0]);

        callback = null;

        System.runFinalization();
        System.gc();

        //sleep here, to let the CLEANER do it cleanup....
        Thread.sleep(10);

        assertEquals(getCallback__V___L(), NULL_PTR);

    }
}
