/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.annotation.winapi.basetsd.BOOL;
import de.ibapl.jnhw.annotation.winapi.basetsd.DWORD;
import de.ibapl.jnhw.annotation.winapi.basetsd.PVOID;
import de.ibapl.jnhw.annotation.winapi.basetsd.ULONG_PTR;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.memory.layout.StructLayout;
import de.ibapl.jnhw.common.memory.layout.StructLayoutFactory;
import de.ibapl.jnhw.common.memory.layout.UnionLayout;
import de.ibapl.jnhw.common.upcall.Callback__V___I__I_MA;
import de.ibapl.jnhw.util.winapi.memory.WinApiStdStructLayoutFactory;
import de.ibapl.jnhw.util.winapi.memory.WinApiStruct;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;
import java.lang.foreign.Addressable;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;

/**
 * Wrapper around the
 * <a href="https://docs.microsoft.com/en-us/windows/win32/api/minwinbase/">minwinbase.h</a>
 * header.
 *
 * @author aploese
 */
@Include("minwinbase.h")
public class Minwinbase {

    public abstract static class LPOVERLAPPED_COMPLETION_ROUTINE extends Callback__V___I__I_MA<LPOVERLAPPED> {

        @Override
        protected abstract void callback(int dwErrorCode, int dwNumberOfBytesTransferred, MemoryAddress lpOverlapped);

    }

    /**
     * <b>WIN:</b> <a href="https://docs.microsoft.com/en-us/windows/win32/api/minwinbase/ns-minwinbase-overlapped">{@code structure
     * OVERLAPPED}</a>.
     *
     */
    public final static class LPOVERLAPPED extends WinApiStruct {

        public static LPOVERLAPPED allocateNative(MemorySession ms) {
            return new LPOVERLAPPED(MemorySegment.allocateNative(Layout.sizeof, ms), 0);
        }

        public static class Layout extends StructLayout {

            public static class DUMMYUNIONNAMELayout extends UnionLayout {

                public static class DUMMYSTRUCTNAMELayout extends StructLayout {

                    public final static Alignment alignment;
                    public final static long Offset;
                    public final static long OffsetHigh;
                    public final static int sizeof;

                    static {
                        final WinApiStdStructLayoutFactory slf = new WinApiStdStructLayoutFactory(StructLayoutFactory.Type.STRUCT);
                        Offset = slf.DWORD();
                        OffsetHigh = slf.DWORD();
                        sizeof = (int) slf.getSizeof();
                        alignment = slf.getAlignment();
                    }

                }

                public final static Alignment alignment;
                public final static long DUMMYSTRUCTNAME;
                public final static long Pointer;
                public final static int sizeof;

                static {
                    WinApiStdStructLayoutFactory slf = new WinApiStdStructLayoutFactory(StructLayoutFactory.Type.UNION);
                    Pointer = slf.PVOID();
                    DUMMYSTRUCTNAME = slf.struct(DUMMYSTRUCTNAMELayout.sizeof, DUMMYSTRUCTNAMELayout.alignment);
                    sizeof = (int) slf.getSizeof();
                    alignment = slf.getAlignment();
                }

            }

            public final static Alignment alignment;
            public final static long DUMMYUNIONNAME;
            public final static long hEvent;
            public final static long Internal;
            public final static long InternalHigh;
            public final static long Offset;
            public final static long OffsetHigh;
            public final static long Pointer;
            public final static int sizeof;

            static {
                final WinApiStdStructLayoutFactory slf = new WinApiStdStructLayoutFactory(StructLayoutFactory.Type.STRUCT);

                Internal = slf.ULONG_PTR();
                InternalHigh = slf.ULONG_PTR();
                DUMMYUNIONNAME = slf.struct(DUMMYUNIONNAMELayout.sizeof, DUMMYUNIONNAMELayout.alignment);
                Offset = DUMMYUNIONNAME + DUMMYUNIONNAMELayout.DUMMYSTRUCTNAME + DUMMYUNIONNAMELayout.DUMMYSTRUCTNAMELayout.Offset;
                OffsetHigh = DUMMYUNIONNAME + DUMMYUNIONNAMELayout.DUMMYSTRUCTNAME + DUMMYUNIONNAMELayout.DUMMYSTRUCTNAMELayout.OffsetHigh;
                Pointer = DUMMYUNIONNAME + DUMMYUNIONNAMELayout.Pointer;
                hEvent = slf.HANDLE();
                sizeof = (int) slf.getSizeof();
                alignment = slf.getAlignment();
            }

        }

        public LPOVERLAPPED(MemorySegment memorySegment, long offset) {
            //always clean field Pointer must be zero!
            super(memorySegment, offset, Layout.sizeof);
            this.memorySegment.fill((byte) 0);
        }

        /**
         * @return the native value of hEvent;
         */
        public HANDLE hEvent() {
            return ACCESSOR_HANDLE.HANDLE(memorySegment, Layout.hEvent);
        }

        /**
         * @param hEvent the value of hEvent to be set natively.
         */
        public void hEvent(HANDLE hEvent) {
            ACCESSOR_HANDLE.HANDLE(memorySegment, Layout.hEvent, hEvent);
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
        @ULONG_PTR
        public final long Internal() {
            return ACCESSOR_ULONG_PTR.ULONG_PTR(memorySegment, Layout.Internal);
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
        @ULONG_PTR
        public final long InternalHigh() {
            return ACCESSOR_ULONG_PTR.ULONG_PTR(memorySegment, Layout.InternalHigh);
        }

        /**
         * The low-order portion of the file position at which to start the I/O
         * request, as specified by the user.
         *
         * @return
         */
        @DWORD
        public final long Offset() {
            return ACCESSOR_DWORD.DWORD_AsLong(memorySegment, Layout.Offset);
        }

        public final void Offset(@DWORD long value) {
            ACCESSOR_DWORD.DWORD_FromLong(memorySegment, Layout.Offset, value);
        }

        /**
         * The high-order portion of the file position at which to start the I/O
         * request, as specified by the user.
         *
         * @return
         */
        @DWORD
        public final long OffsetHigh() {
            return ACCESSOR_DWORD.DWORD_AsLong(memorySegment, Layout.OffsetHigh);
        }

        public final void OffsetHigh(@DWORD long value) {
            ACCESSOR_DWORD.DWORD_FromLong(memorySegment, Layout.OffsetHigh, value);
        }

        /**
         * Reserved for system use; do not use after initialization to zero.
         *
         * @return
         */
        @PVOID
        public final MemoryAddress Pointer() {
            return ACCESSOR_PVOID.PVOID(memorySegment, Layout.InternalHigh);
        }

    }

    /**
     * <b>WIN:</b> <a href="https://docs.microsoft.com/en-us/previous-versions/windows/desktop/legacy/aa379560(v=vs.85)">{@code structure
     * SECURITY_ATTRIBUTES}</a>.
     *
     */
    public static class SECURITY_ATTRIBUTES extends WinApiStruct {

        public static class Layout extends StructLayout {

            public final static Alignment alignment;
            public final static long bInheritHandle;
            public final static long lpSecurityDescriptor;
            public final static long nLength;
            public final static int sizeof;

            static {
                WinApiStdStructLayoutFactory slf = new WinApiStdStructLayoutFactory(StructLayoutFactory.Type.STRUCT);
                nLength = slf.DWORD();
                lpSecurityDescriptor = slf.PVOID();
                bInheritHandle = slf.BOOL();
                sizeof = (int) slf.getSizeof();
                alignment = slf.getAlignment();
            }

        }

        public SECURITY_ATTRIBUTES(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, Layout.sizeof);
        }

        /**
         * @return the native value of bInheritHandle;
         */
        @BOOL
        public boolean bInheritHandle() {
            return ACCESSOR_BOOL.BOOL(memorySegment, Layout.bInheritHandle);
        }

        public void bInheritHandle(@BOOL boolean bInheritHandle) {
            ACCESSOR_BOOL.BOOL(memorySegment, Layout.bInheritHandle, bInheritHandle);
        }

        @PVOID
        public MemoryAddress lpSecurityDescriptor() {
            return ACCESSOR_PVOID.PVOID(memorySegment, Layout.lpSecurityDescriptor);
        }

        public void lpSecurityDescriptor(@PVOID Addressable lpSecurityDescriptor) {
            ACCESSOR_PVOID.PVOID(memorySegment, Layout.lpSecurityDescriptor, lpSecurityDescriptor);
        }

        /**
         * @return the native value of nLength;
         */
        @DWORD
        public final long nLength() {
            return ACCESSOR_DWORD.DWORD_AsLong(memorySegment, Layout.nLength);
        }

        public final void nLength(@DWORD long nLength) {
            ACCESSOR_DWORD.DWORD_FromLong(memorySegment, Layout.nLength, nLength);
        }

    }

}
