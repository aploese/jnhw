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

import java.lang.ref.WeakReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 * @param <A>
 * @param <B>
 */
public abstract class Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V<A extends OpaqueMemory, B extends OpaqueMemory> extends NativeCallback<Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V<A, B>> {

    private final static Logger LOG = Logger.getLogger("d.i.j.c.Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V");

    private static final WeakReference<Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V> refs[];

    private static native void initNative();

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwCommonLoader.touch();
        initNative();
        refs = new WeakReference[MAX_CALL_BACKS()];
        for (int i = 0; i < refs.length; i++) {
            refs[i] = new WeakReference(null);
        }
    }

    /**
     * this is just an estimation ...
     *
     * @return
     */
    public static int callbacksAvailable() {
        int result = 0;
        for (int i = 0; i < refs.length; i++) {
            if (refs[i].get() == null) {
                result++;
            }
        }
        return result;
    }

    public Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V() {
        super();
        aquire();
    }

    @SuppressWarnings("unused")
    private static void trampoline(final int index, final int value, final long a, final long b) {
        try {
            final var ref = refs[index].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline(%d, %d, 0x%08x, 0x%08x)", index, value, a, b));
            } else {
                ref.callback(value, ref.wrapA(a), ref.wrapB(b));
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline(%d, %d, 0x%08x, 0x%08x)", index, value, a, b), t);
        }
    }

    private static native long getNativeAddress(final int index);

    private synchronized void aquire() {
        for (int i = 0; i < refs.length; i++) {
            if (refs[i].get() == null) {
                refs[i] = new WeakReference(this);
                NativeFunctionPointer.setAddress(this, getNativeAddress(i));
                return;
            }
        }
        //Hint: Try run GC to free any??? or add more cbs...
        throw new RuntimeException("No more Callbacks available! max: " + MAX_CALL_BACKS() + " reached");
    }

    public static native int MAX_CALL_BACKS();

    /**
     * this will be called from the native code.
     *
     * @param value
     * @param a
     * @param b
     */
    protected abstract void callback(int value, A a, B b);

    protected abstract A wrapA(long address);

    protected abstract B wrapB(long address);

}
