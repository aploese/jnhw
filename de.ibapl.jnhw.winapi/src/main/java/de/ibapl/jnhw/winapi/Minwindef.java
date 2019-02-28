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
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.OpaqueMemory;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import static de.ibapl.jnhw.winapi.Winnt.HANDLE;

@Include("minwindef.h")
public abstract class Minwindef {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwWinApiLoader.touch();
    }

    public static class HKEY extends HANDLE {

        public HKEY(long value) {
            super(value);
        }

        public HKEY() {
            super();
        }

    }

    /**
     * Just the pointer to HKEY that where meaning it can be set in a function
     * call ....
     */
    public static class PHKEY extends HKEY {

        public PHKEY(long value) {
            super(value);
        }

        public PHKEY() {
            super();
        }

    }

    public static class LPBYTE extends OpaqueMemory {

        final IntRef bufferEnd;

        public LPBYTE(int size, boolean clearMemory) {
            super(size, clearMemory);
            bufferEnd = new IntRef(size);
        }

        public void clear() {
            OpaqueMemory.clear(this);
            bufferEnd.value = sizeInBytes;
        }

        public void resetBufferEnd() {
            bufferEnd.value = sizeInBytes;
        }

    }
}
