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
import de.ibapl.jnhw.LibJnhwWinApiLoader;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.winapi.Minwinbase.OVERLAPPED;
import static de.ibapl.jnhw.winapi.Winnt.HANDLE;
import java.nio.ByteBuffer;

/**
 *
 * @author aploese
 */
@Include("ioapiset.h")
public final class Ioapiset extends LibJnhwWinApiLoader {

    public final static native boolean HAVE_IOAPISET_H();

    private static native void GetOverlappedResult(long hFile, long lpOverlapped, IntRef lpNumberOfBytesTransferred, boolean bWait) throws NativeErrorException;

    private static native void CancelIoEx(long hFile, long lpOverlapped) throws NativeErrorException;

    private static native void CancelIo(long hFile) throws NativeErrorException;

    public final static void GetOverlappedResult(HANDLE hFile, OVERLAPPED lpOverlapped, IntRef lpNumberOfBytesTransferred, boolean bWait) throws NativeErrorException {
        GetOverlappedResult(hFile.value, lpOverlapped.baseAddress, lpNumberOfBytesTransferred, bWait);
    }

    public final static void GetOverlappedResult(HANDLE hFile, OVERLAPPED overlapped, IntRef lpNumberOfBytesTransferred, boolean bWait, ByteBuffer lpBuffer) throws NativeErrorException {
        GetOverlappedResult(hFile.value, overlapped.baseAddress, lpNumberOfBytesTransferred, bWait);
        lpBuffer.position(lpBuffer.position() + lpNumberOfBytesTransferred.value);
    }

    public final static void CancelIoEx(HANDLE hFile, OVERLAPPED lpOverlapped) throws NativeErrorException {
        CancelIoEx(hFile.value, lpOverlapped != null ? lpOverlapped.baseAddress : 0L);
    }

    public final static void CancelIo(HANDLE hFile) throws NativeErrorException {
        CancelIo(hFile.value);
    }
}
