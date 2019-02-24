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
import de.ibapl.jnhw.OpaqueMemory;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import static de.ibapl.jnhw.winapi.Winnt.HANDLE;

/**
 *
 * @author aploese
 */
@Include("minwinbase.h")
public class Minwinbase extends LibJnhwWinApiLoader {

//TODO   public final static native boolean HAVE_MINWINBASE_H();
    public final static class OVERLAPPED extends OpaqueMemory {

        static {
            LibJnhwWinApiLoader.touch();
        }

        public final static native int sizeofOVERLAPPED();

        private final static native long Internal(long baseAddress);

        private final static native long InternalHigh(long baseAddress);

        private static native long hEvent(long baseAddress);

        private static native void hEvent(long baseAddress, long value);

        private HANDLE hEvent;

        public OVERLAPPED(boolean clearMem) {
            super(sizeofOVERLAPPED(), clearMem);
        }

        public final void hEvent(HANDLE value) {
            hEvent = value;
            hEvent(baseAddress, hEvent.value);
        }

        //TODO test for modifications in native mem ???
        public final HANDLE hEvent() {
            return hEvent;
        }

    }

    public static class SECURITY_ATTRIBUTES extends OpaqueMemory {

        static {
            LibJnhwWinApiLoader.touch();
        }

        public final static native int sizeofSECURITY_ATTRIBUTES();

        private static final native long nLength(long baseAddress);
//        private Minwindef.LPVOID lpSecurityDescriptor;

        private static native boolean bInheritHandle(long baseAddress);

        public SECURITY_ATTRIBUTES() {
            super(sizeofSECURITY_ATTRIBUTES(), true);
        }

    };

}
