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

import de.ibapl.jnhw.common.LibJnhwCommonLoader;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import java.util.logging.Logger;

/**
 *
 * @author aploese TODO cleanup on GC
 */
public abstract class NativeRunnable extends OpaqueMemory32 {

    private final static Logger LOG = Logger.getLogger("d.i.j.c.NativeRunnable");

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwCommonLoader.touch();
    }

    @Override
    public BaseDataType getBaseDataType() {
        return BaseDataType.function;
    }

    @Override
    public String nativeToHexString() {
        switch (sizeInBytes) {
            case 4:
                return String.format("%08x", baseAddress);
            case 8:
                return String.format("%016x", baseAddress);
            default:
                throw new RuntimeException("Cant handle sizeInBytes: " + sizeInBytes);
        }
    }

    private native void aquireObjectRef();

    /**
     * release the object ref on the natice side to allow garbage collection of
     * this object
     */
    //TODO When???
    public native void releaseObjectRef();

    public static native int sizeOf_ObjectRef();

    public NativeRunnable() {
        super((OpaqueMemory32) null, 0, sizeOf_ObjectRef(), null);
        aquireObjectRef();
    }

    protected abstract void callback();

}
