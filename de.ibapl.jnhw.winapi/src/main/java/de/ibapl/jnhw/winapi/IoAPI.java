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

import de.ibapl.jnhw.annotation.winapi.basetsd.ULONG_PTR;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.memory.Uint32_t;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import de.ibapl.jnhw.winapi.Minwinbase.OVERLAPPED;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;

/**
 * Wrapper around the
 * <a href="https://docs.microsoft.com/en-us/windows/win32/api/ioapi/">IoAPI.h</a>
 * header.
 *
 * @author aploese
 */
@Include("IoAPI.h")
public final class IoAPI {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwWinApiLoader.touch();
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/fileio/createiocompletionport">CreateIoCompletionPort</a>
     * Creates an input/output (I/O) completion port and associates it with a
     * specified file handle, or creates an I/O completion port that is not yet
     * associated with a file handle, allowing association at a later time.
     *
     * @param FileHandle An open file handle or INVALID_HANDLE_VALUE.
     * @param ExistingCompletionPort A handle to an existing I/O completion port
     * or NULL.
     * @param CompletionKey The per-handle user-defined completion key that is
     * included in every I/O completion packet for the specified file handle.
     * @param NumberOfConcurrentThreads The maximum number of threads that the
     * operating system can allow to concurrently process I/O completion packets
     * for the I/O completion port.
     *
     * @return
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static HANDLE CreateIoCompletionPort(HANDLE FileHandle, HANDLE ExistingCompletionPort, @ULONG_PTR long CompletionKey, int NumberOfConcurrentThreads) throws NativeErrorException {
        if (NumberOfConcurrentThreads < 0) {
            throw new IllegalArgumentException("NumberOfConcurrentThreads must >= 0!");
        }
        return HANDLE.of(CreateIoCompletionPort(HANDLE.getHandleValue(FileHandle), HANDLE.getHandleValueOrNULL(ExistingCompletionPort), CompletionKey, NumberOfConcurrentThreads));
    }

    private static native long CreateIoCompletionPort(long ptrFileHandle, long ptrExistingCompletionPort, @ULONG_PTR long CompletionKey, int NumberOfConcurrentThreads) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/ioapiset/nf-ioapiset-getqueuedcompletionstatus">GetQueuedCompletionStatus</a>
     * Attempts to dequeue an I/O completion packet from the specified I/O
     * completion port.
     *
     * @param CompletionPort A handle to the completion port.
     * @param lpNumberOfBytesTransferred A pointer to a variable that receives
     * the number of bytes transferred in a completed I/O operation.
     * @param lpCompletionKey A pointer to a variable that receives the
     * completion key value associated with the file handle whose I/O operation
     * has completed.
     * @param dwMilliseconds The number of milliseconds that the caller is
     * willing to wait for a completion packet to appear at the completion port.
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @return lpOverlapped A pointer to a variable that receives the address of
     * the OVERLAPPED structure that was specified when the completed I/O
     * operation was started.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static NativeAddressHolder<OVERLAPPED> GetQueuedCompletionStatus(HANDLE CompletionPort, Int32_t lpNumberOfBytesTransferred, @ULONG_PTR Uint32_t lpCompletionKey, long dwMilliseconds) throws NativeErrorException {
        if ((dwMilliseconds < 0) && (dwMilliseconds != Winbase.INFINITE)) {
            throw new IllegalArgumentException("dwMilliseconds must be >= 0");
        }
        return NativeAddressHolder.ofUintptr_t(GetQueuedCompletionStatus(HANDLE.getHandleValue(CompletionPort), AbstractNativeMemory.toUintptr_t(lpNumberOfBytesTransferred), AbstractNativeMemory.toUintptr_t(lpCompletionKey), dwMilliseconds));
    }

    private static native long GetQueuedCompletionStatus(long ptrCompletionPort, long ptrLpNumberOfBytesTransferred, long ptrLpCompletionKey, long dwMilliseconds) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/ioapiset/nf-ioapiset-postqueuedcompletionstatus">PostQueuedCompletionStatus</a>
     * Attempts to dequeue an I/O completion packet from the specified I/O
     * completion port.
     *
     * @param CompletionPort A handle to an I/O completion port to which the I/O
     * completion packet is to be posted.
     * @param dwNumberOfBytesTransferred The value to be returned through the
     * lpNumberOfBytesTransferred parameter of the GetQueuedCompletionStatus
     * function.
     * @param dwCompletionKey The value to be returned through the
     * lpCompletionKey parameter of the GetQueuedCompletionStatus function.
     * @param lpOverlapped The value to be returned through the lpOverlapped
     * parameter of the GetQueuedCompletionStatus function.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void PostQueuedCompletionStatus(HANDLE CompletionPort, int dwNumberOfBytesTransferred, @ULONG_PTR long dwCompletionKey, OVERLAPPED lpOverlapped) throws NativeErrorException {
        PostQueuedCompletionStatus(HANDLE.getHandleValue(CompletionPort), dwNumberOfBytesTransferred, dwCompletionKey, AbstractNativeMemory.toUintptr_tOrNULL(lpOverlapped));
    }

    private static native void PostQueuedCompletionStatus(long CompletionPort, int dwNumberOfBytesTransferred, @ULONG_PTR long dwCompletionKey, long ptrLpOverlapped) throws NativeErrorException;
}
