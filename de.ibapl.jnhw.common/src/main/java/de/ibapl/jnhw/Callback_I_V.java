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
 */
public abstract class Callback_I_V extends NativeCallback<Callback_I_V> {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwCommonLoader.touch();
    }

    private final static Logger LOG = Logger.getLogger("d.i.j.c.CallBack_I_V");

    private static WeakReference<Callback_I_V> ref_0 = new WeakReference<>(null);
    private static WeakReference<Callback_I_V> ref_1 = new WeakReference<>(null);

    public static int callbacksAvailable() {
        int result = 0;
        if (ref_0.get() == null) {
            result++;
        }
        if (ref_1.get() == null) {
            result++;
        }
        return result;
    }

    public Callback_I_V() {
        super();
        aquire();
    }

    private static void cb_0(int value) {
        final Callback_I_V ref = ref_0.get();
        if (ref == null) {
            LOG.log(Level.SEVERE, "Unassigned callback for cb_0({0})", new Object[]{value});
        } else {
            ref.callback(value);
        }
    }

    private static void cb_1(int value) {
        final Callback_I_V ref = ref_1.get();
        if (ref == null) {
            LOG.log(Level.SEVERE, "Unassigned callback for cb_1({0})", new Object[]{value});
        } else {
            ref.callback(value);
        }
    }

    private static native long getNativeAddress_0();

    private static native long getNativeAddress_1();

    private synchronized void aquire() {
        if (ref_0.get() == null) {
            ref_0 = new WeakReference<>(this);
            NativeFunctionPointer.setAddress(this, getNativeAddress_0());
        } else if (ref_1.get() == null) {
            ref_1 = new WeakReference<>(this);
            NativeFunctionPointer.setAddress(this, getNativeAddress_1());
        } else {
            //Hint: Try run GC to free any??? or add more cbs...
            throw new RuntimeException("No more Callbacks available! max: " + MAX_CALL_BACKS() + " reached");
        }
    }

    public static native int MAX_CALL_BACKS();

    /**
     * this will be called from the native code.
     *
     * @param value
     */
    protected abstract void callback(int value);

}
