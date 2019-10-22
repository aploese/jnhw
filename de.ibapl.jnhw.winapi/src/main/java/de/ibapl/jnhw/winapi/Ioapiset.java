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
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import de.ibapl.jnhw.winapi.Minwinbase.OVERLAPPED;
import static de.ibapl.jnhw.winapi.Winnt.HANDLE;
import java.nio.ByteBuffer;

/**
 *
 * @author aploese
 */
@Include("ioapiset.h")
public final class Ioapiset {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwWinApiLoader.touch();
    }

    public final static native boolean HAVE_IOAPISET_H();

    
    public static native int GetOverlappedResult(HANDLE hFile, OVERLAPPED lpOverlapped, boolean bWait) throws NativeErrorException;

    public static native void CancelIoEx(HANDLE hFile, OVERLAPPED lpOverlapped) throws NativeErrorException;

    public static native void CancelIo(HANDLE hFile) throws NativeErrorException;

    /**
     * Get the number of bytes transferred and set lpBuffers position.
     * @param hFile
     * @param overlapped
     * @param lpBuffer
     * @param bWait
     * @throws NativeErrorException 
     */
    public final static int GetOverlappedResult(HANDLE hFile, OVERLAPPED overlapped, ByteBuffer lpBuffer, boolean bWait) throws NativeErrorException {
        int numberOfBytesTransferred =  GetOverlappedResult(hFile, overlapped, bWait);
        lpBuffer.position(lpBuffer.position() + numberOfBytesTransferred);
        return numberOfBytesTransferred;
    }

    public static void GetOverlappedResult(HANDLE hFile, OVERLAPPED lpOverlapped, IntRef lpNumberOfBytesTransferred, boolean bWait) throws NativeErrorException {
        lpNumberOfBytesTransferred.value = GetOverlappedResult(hFile, lpOverlapped, bWait);
    }
    
}
