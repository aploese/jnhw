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
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.common.callback.Callback_I_I_Mem_V_Impl;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.memory.layout.StructLayout;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import de.ibapl.jnhw.util.winapi.memory.Accessor_DWORD;
import de.ibapl.jnhw.util.winapi.memory.WinApiStruct32;
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

        HAVE_MINWINBASE_H = false;

        initFields();
    }

    private static native void initFields();

    public final static boolean HAVE_MINWINBASE_H;

    /**
     * <b>WIN:</b> <a href="https://docs.microsoft.com/en-us/windows/win32/api/minwinbase/ns-minwinbase-overlapped">{@code structure
     * OVERLAPPED}</a>.
     *
     */
    public final static class OVERLAPPED extends WinApiStruct32 {

        public static class Layout extends StructLayout {

            public final long Internal;
            public final long InternalHigh;
            public final long Offset;
            public final long OffsetHigh;
            public final long Pointer;
            public final long hEvent;
            public final Alignment alignment;
            public final int sizeof;

            public Layout(long sizeof, int alignof) {
                super();
                Internal = -1;
                InternalHigh = -1;
                Offset = -1;
                OffsetHigh = -1;
                Pointer = -1;
                hEvent = -1;
                this.sizeof = (int) sizeof;
                this.alignment = Alignment.fromAlignof(alignof);
            }

            @Override
            public int getSizeof() {
                return sizeof;
            }

            @Override
            public Alignment getAlignment() {
                return alignment;
            }
        }

        private static native Layout native2Layout(Class<Layout> layoutClass);

        public final static Layout LAYOUT;

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwWinApiLoader.touch();
            LAYOUT = native2Layout(Layout.class);
        }

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
        public final long Internal() {
            return ACCESSOR_ULONG_PTR.ULONG_PTR(this, LAYOUT.Internal);
        }

        /**
         * The number of bytes transferred for the I/O request. The system sets
         * this member if the request is completed without errors.
         * <br>
         * The InternalHigh member was originally reserved for system use and
         * its behavior may change.
         *
         * @return the native value of InternalHigh;
         */
        public final long InternalHigh() {
            return ACCESSOR_ULONG_PTR.ULONG_PTR(this, LAYOUT.InternalHigh);
        }

        /**
         * The low-order portion of the file position at which to start the I/O
         * request, as specified by the user.
         *
         * @return
         */
        public final long Offset() {
            return ACCESSOR_DWORD.DWORD(this, LAYOUT.Offset);
        }

        public final void Offset(long value) {
            ACCESSOR_DWORD.DWORD(this, LAYOUT.Offset, value);
        }

        /**
         * The high-order portion of the file position at which to start the I/O
         * request, as specified by the user.
         *
         * @return
         */
        public final long OffsetHigh() {
            return ACCESSOR_DWORD.DWORD(this, LAYOUT.OffsetHigh);
        }

        public final void OffsetHigh(long value) {
            ACCESSOR_DWORD.DWORD(this, LAYOUT.OffsetHigh, value);
        }

        /**
         * Reserved for system use; do not use after initialization to zero.
         *
         * @return
         */
        public final NativeAddressHolder Pointer() {
            return ACCESSOR_PVOID.PVOID(this, LAYOUT.InternalHigh);
        }

        /**
         * @param hEvent the value of hEvent to be set natively.
         */
        public void hEvent(HANDLE hEvent) {
            ACCESSOR_HANDLE.HANDLE(this, LAYOUT.hEvent, hEvent);
        }

        /**
         * @return the native value of hEvent;
         */
        public HANDLE hEvent() {
            return ACCESSOR_HANDLE.HANDLE(this, LAYOUT.hEvent);
        }

        public OVERLAPPED() {
            //always clean field Pointer must be zero!
            super((OpaqueMemory32) null, 0, LAYOUT.sizeof, SET_MEM_TO_0);
        }

        public OVERLAPPED(NativeAddressHolder addressHolder) {
            super(addressHolder, LAYOUT.sizeof);
        }

    }

    public abstract static class LPOVERLAPPED_COMPLETION_ROUTINE extends Callback_I_I_Mem_V_Impl<OVERLAPPED> {

        @Override
        protected abstract void callback(int dwErrorCode, int dwNumberOfBytesTransfered, OVERLAPPED lpOverlapped);

    }

    /**
     * <b>WIN:</b> <a href="https://docs.microsoft.com/en-us/previous-versions/windows/desktop/legacy/aa379560(v=vs.85)">{@code structure
     * SECURITY_ATTRIBUTES}</a>.
     *
     */
    public static class SECURITY_ATTRIBUTES extends WinApiStruct32 {

        public static class Layout extends StructLayout {

            public final long nLength;
            public final long lpSecurityDescriptor;
            public final long bInheritHandle;
            public final Alignment alignment;
            public final int sizeof;

            public Layout(long sizeof, int alignof) {
                super();
                nLength = -1;
                lpSecurityDescriptor = -1;
                bInheritHandle = -1;
                this.sizeof = (int) sizeof;
                this.alignment = Alignment.fromAlignof(alignof);
            }

            @Override
            public int getSizeof() {
                return sizeof;
            }

            @Override
            public Alignment getAlignment() {
                return alignment;
            }
        }

        private static native Layout native2Layout(Class<Layout> layoutClass);

        public final static Layout LAYOUT;

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwWinApiLoader.touch();
            LAYOUT = native2Layout(Layout.class);
        }

        /**
         * @return the native value of nLength;
         */
        public final long nLength() {
            return ACCESSOR_DWORD.DWORD(this, LAYOUT.nLength);
        }

        public final void nLength(long nLength) {
            ACCESSOR_DWORD.DWORD(this, LAYOUT.nLength, nLength);
        }

        public NativeAddressHolder lpSecurityDescriptor() {
            return ACCESSOR_PVOID.PVOID(this, LAYOUT.lpSecurityDescriptor);
        }

        public void lpSecurityDescriptor(NativeAddressHolder lpSecurityDescriptor) {
            ACCESSOR_PVOID.PVOID(this, LAYOUT.lpSecurityDescriptor, lpSecurityDescriptor);
        }

        /**
         * @return the native value of bInheritHandle;
         */
        public boolean bInheritHandle() {
            return ACCESSOR_BOOL.BOOL(this, LAYOUT.bInheritHandle);
        }

        public void bInheritHandle(boolean bInheritHandle) {
            ACCESSOR_BOOL.BOOL(this, LAYOUT.bInheritHandle, bInheritHandle);
        }

        public SECURITY_ATTRIBUTES() {
            super((OpaqueMemory32) null, 0, LAYOUT.sizeof, SET_MEM_TO_0);
        }

    };

}
