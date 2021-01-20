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
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.common.callbacks.Callback_I_I_PtrAbstractNativeMemory_V_Impl;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.annotation.SizeOf;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;

/**
 * Wrapper around the
 * <a href="https://docs.microsoft.com/en-us/windows/win32/api/minwinbase/">minwinbase.h</a>
 * header.
 *
 * @author aploese
 */
@Include("minwinbase.h")
public class Minwinbase {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwWinApiLoader.touch();
    }

    public final static native boolean HAVE_MINWINBASE_H();

    /**
     * <b>WIN:</b> <a href="https://docs.microsoft.com/en-us/windows/win32/api/minwinbase/ns-minwinbase-overlapped">{@code structure
     * OVERLAPPED}</a>.
     *
     */
    public final static class OVERLAPPED extends Struct32 {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwWinApiLoader.touch();
        }

        /**
         * Get the real size of struct OVERLAPPED natively.
         *
         * @return the native value sizeof(struct OVERLAPPED).
         */
        @SizeOf
        public final static native int sizeof();

        /**
         * The status code for the I/O request. When the request is issued, the
         * system sets this member to STATUS_PENDING to indicate that the
         * operation has not yet started. When the request is completed, the
         * system sets this member to the status code for the completed request.
         * <br>
         * The Internal member was originally reserved for system use and its
         * behavior may change.
         *
         * @return the native value of Internal;
         *
         */
        public final native long Internal();

        /**
         * The number of bytes transferred for the I/O request. The system sets
         * this member if the request is completed without errors.
         * <br>
         * The InternalHigh member was originally reserved for system use and
         * its behavior may change.
         *
         * @return the native value of InternalHigh;
         */
        public final native long InternalHigh();

        /**
         * @param hEvent the value of hEvent to be set natively.
         */
        public native void hEvent(HANDLE hEvent);

        /**
         * @return the native value of hEvent;
         */
        public native HANDLE hEvent();

        public OVERLAPPED() {
            //always clean field Pointer must be zero!
            super(sizeof(), true);
        }

        public OVERLAPPED(NativeAddressHolder addressHolder) {
            super(addressHolder, sizeof());
        }

    }

    public abstract static class LPOVERLAPPED_COMPLETION_ROUTINE extends Callback_I_I_PtrAbstractNativeMemory_V_Impl<OVERLAPPED> {

        @Override
        protected abstract void callback(int dwErrorCode, int dwNumberOfBytesTransfered, OVERLAPPED lpOverlapped);

    }

    /**
     * <b>WIN:</b> <a href="https://docs.microsoft.com/en-us/previous-versions/windows/desktop/legacy/aa379560(v=vs.85)">{@code structure
     * SECURITY_ATTRIBUTES}</a>.
     *
     */
    public static class SECURITY_ATTRIBUTES extends Struct32 {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwWinApiLoader.touch();
        }

        /**
         * Get the real size of struct SECURITY_ATTRIBUTES natively.
         *
         * @return the native value sizeof(struct SECURITY_ATTRIBUTES).
         */
        @SizeOf
        public final static native int sizeof();

        /**
         * @return the native value of nLength;
         */
        public final native long nLength();
//        private Minwindef.LPVOID lpSecurityDescriptor;

        /**
         * @return the native value of bInheritHandle;
         */
        public native boolean bInheritHandle();

        public SECURITY_ATTRIBUTES() {
            super(sizeof(), true);
        }

    };

}
