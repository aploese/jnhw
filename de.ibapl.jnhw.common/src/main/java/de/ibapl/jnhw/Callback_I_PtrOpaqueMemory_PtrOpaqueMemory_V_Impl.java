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
public abstract class Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V_Impl<A extends OpaqueMemory, B extends OpaqueMemory> extends Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V<A, B> implements NativeCallToJava {

    private final static Logger LOG = Logger.getLogger("d.i.j.c.Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V_Impl");

    private static final WeakReference<Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V_Impl> refs[];

    public static Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V_Impl find(NativeFunctionPointer callbackPtr) {
        for (WeakReference<Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V_Impl> wr : refs) {
            Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V_Impl cb = wr.get();
            if (cb != null) {
                if (cb.equals(callbackPtr)) {
                    return cb;
                }
            }
        }
        return null;
    }

    //TODO release globalRef on native side, if its not deeded anymore ....
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

    public Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V_Impl() {
        super(Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V_Impl::aquire);
    }

    @SuppressWarnings("unused")
    private static void trampoline(final int index, final int value, final NativeAddressHolder a, final NativeAddressHolder b) {
        try {
            final Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V_Impl ref = refs[index].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline(%d, %d, %s, %s)", index, value, a, b));
            } else {
                ref.callback(value, ref.wrapA(a), ref.wrapB(b));
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline(%d, %d, %s, %s)", index, value, a, b), t);
        }
    }

    private static native NativeAddressHolder getNativeAddress(final int index);

    /**
     * TODO make arg of type
     * Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V_Impl<?, ?>
     *
     * @param cb
     * @return
     */
    private static synchronized NativeAddressHolder aquire(Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V<?, ?> cb) {
        for (int i = 0; i < refs.length; i++) {
            if (refs[i].get() == null) {
                refs[i] = new WeakReference(cb);
                return getNativeAddress(i);
            }
        }
        //Hint: Try run GC to free any??? or add more cbs...
        throw new RuntimeException("No more Callbacks available! max: " + MAX_CALL_BACKS() + " reached");
    }

    public static native int MAX_CALL_BACKS();

    protected abstract A wrapA(NativeAddressHolder address);

    protected abstract B wrapB(NativeAddressHolder address);

}
