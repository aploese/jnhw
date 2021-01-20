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
package de.ibapl.jnhw.common.memory;

import de.ibapl.jnhw.common.annotation.int32_t;
import de.ibapl.jnhw.common.LibJnhwCommonLoader;
import de.ibapl.jnhw.common.annotation.AlignOf;
import de.ibapl.jnhw.common.annotation.SizeOf;
import de.ibapl.jnhw.common.datatypes.BaseDataTypes;

/**
 *
 * @author aploese
 */
@int32_t
public class Int32_t extends NativeIntNumber {


    /**
     * Make sure the native lib is loaded.
     */
    static {
        LibJnhwCommonLoader.touch();
    }

    @SizeOf
    public static native int sizeof();

    @AlignOf
    public static native int alignof();

    public Int32_t(boolean clearMem) {
        super(sizeof(), clearMem);
    }

    public Int32_t(OpaqueMemory32 owner, int offset) {
        super(owner, offset, sizeof());
    }

    public native @int32_t
    int rawInt32_t();

    public native void rawInt32_t(@int32_t int value);

    @Override
    public native String nativeToString();

    @Override
    public BaseDataTypes getBaseDataType() {
        return BaseDataTypes.int32_t;
    }

    @Override
    public String nativeToHexString() {
        return nativeInt32ToHexString();
    }

}
