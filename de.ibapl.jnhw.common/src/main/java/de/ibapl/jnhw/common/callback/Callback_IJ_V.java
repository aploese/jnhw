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
package de.ibapl.jnhw.common.callback;

import de.ibapl.jnhw.common.nativepointer.FunctionPtr_IJ_V;
import de.ibapl.jnhw.common.LibJnhwCommonLoader;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import java.util.function.Function;

/**
 *
 * @author aploese
 */
public abstract class Callback_IJ_V extends FunctionPtr_IJ_V {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwCommonLoader.touch();
    }

    protected <T extends Callback_IJ_V> Callback_IJ_V(Function<T, NativeAddressHolder> producer) {
        super(producer);
    }

    protected Callback_IJ_V(NativeAddressHolder src) {
        super(src);
    }

    public static native int sizeofIntptr_t();

    public static native int alignofIntptr_t();

    /**
     * this will be called from the native code.
     *
     * @param value
     */
    protected abstract void callback(long value);

    /**
     * this will be called from the native code.
     *
     * @param value
     */
    protected abstract void callback(int value);
}
