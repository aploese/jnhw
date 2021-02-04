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

import de.ibapl.jnhw.common.callback.Callback_NativeRunnable;
import de.ibapl.jnhw.common.references.IntRef;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.callback.NativeRunnable;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class NativeRunnableTest {

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        LibJnhwCommonTestLoader.touch();
    }

    @BeforeEach
    public void setUpBefore() throws Exception {
        System.runFinalization();
        System.gc();
    }

    public NativeRunnableTest() {
    }

    private static native NativeFunctionPointer getCallbackPtr();

    private static native void setCallback(Callback_NativeRunnable callback);

    private static native void doCallTheCallback(NativeRunnable a);

    private static native void doCallRunnable(Runnable runnable);

    private static native void doCallTheWrongCallbackPtr();

    /**
     * Test of release method, of class IntConsumerCallbackFactory.
     */
    @Test
    public void testCallback() {
        System.out.println("release");
        final IntRef intRef = new IntRef(0);
        NativeRunnable nativeRunnable = new NativeRunnable() {
            @Override
            protected void callback() {
                intRef.value = 42;
            }

        };
        Callback_NativeRunnable callback_NativeRunnable = Callback_NativeRunnable.INSTANCE;

        setCallback(callback_NativeRunnable);

        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback_NativeRunnable);
        assertEquals(getCallbackPtr(), nativeCallbackPointer);

        doCallTheCallback(nativeRunnable);

        assertEquals(42, intRef.value);

    }

    /**
     * Test of
     */
    @Disabled
    @Test
    public void testWrongPtr() {
        System.out.println("release");

        Callback_NativeRunnable callback_NativeRunnable = Callback_NativeRunnable.INSTANCE;

        setCallback(callback_NativeRunnable);

        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback_NativeRunnable);
        assertEquals(getCallbackPtr(), nativeCallbackPointer);

        doCallTheWrongCallbackPtr();

    }

    /**
     * Test of release method, of class IntConsumerCallbackFactory.
     */
    @Disabled
    @Test
    public void testCallbackWithRunnable() {
        System.out.println("release");
        final IntRef intRef = new IntRef(0);
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                intRef.value = 42;
            }

        };
        Callback_NativeRunnable callback_NativeRunnable = Callback_NativeRunnable.INSTANCE;

        setCallback(callback_NativeRunnable);

        final NativeFunctionPointer nativeCallbackPointer = NativeFunctionPointer.wrap(callback_NativeRunnable);

        assertEquals(getCallbackPtr(), nativeCallbackPointer);

        doCallRunnable(runnable);

        assertEquals(42, intRef.value);
    }

}
