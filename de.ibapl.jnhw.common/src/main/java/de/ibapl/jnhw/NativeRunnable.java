/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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

import java.util.logging.Logger;

/**
 *
 * @author aploese TODO cleanup on GC
 */
public abstract class NativeRunnable extends OpaqueMemory {

    private final static Logger LOG = Logger.getLogger("d.i.j.c.NativeRunnable");

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwCommonLoader.touch();
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
        super(sizeOf_ObjectRef(), false);
        aquireObjectRef();
    }

    protected abstract void callback();

}
