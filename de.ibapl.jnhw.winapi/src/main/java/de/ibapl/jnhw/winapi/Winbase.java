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

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.OpaqueMemory;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;

@Include("WinBase.h")
public abstract class Winbase {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwWinApiLoader.touch();
    }

    public final static native boolean HAVE_WINBASE_H();

    @Define
    public final static native int STD_INPUT_HANDLE();

    @Define
    public final static native int STD_OUTPUT_HANDLE();

    @Define
    public final static native int STD_ERROR_HANDLE();

    @Define
    public final static native int WAIT_FAILED();

    @Define
    public final static native int WAIT_OBJECT_0();

    @Define
    public final static native int WAIT_ABANDONED();

    @Define
    public final static native int WAIT_TIMEOUT();

    @Define
    public final static native int FILE_FLAG_OVERLAPPED();

    @Define
    public final static native int RTS_CONTROL_DISABLE();

    @Define
    public final static native int RTS_CONTROL_HANDSHAKE();

    /**
     * Read only, we do not need to write anything.
     */
    public static class COMSTAT extends OpaqueMemory {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwWinApiLoader.touch();
        }

        public final static native int sizeofCOMSTAT();

        public COMSTAT(boolean clearMemory) {
            super(sizeofCOMSTAT(), clearMemory);
        }

        public native boolean fCtsHold();

        public native boolean fDsrHold();

        public native boolean fRlsdHold();

        public native boolean fXoffHold();

        public native boolean fXoffSent();

        public native boolean fEof();

        public native boolean fTxim();

        public native int fReserved();

        public native int cbInQue();

        public native int cbOutQue();
    }

    public final static class DCB extends OpaqueMemory {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwWinApiLoader.touch();
        }

        public DCB(boolean clearMemory) {
            super(sizeofDCB(), clearMemory);
            DCBlength(sizeofDCB());
        }

        public final static native int sizeofDCB();

        //TODO set this in init!!!
        public native void DCBlength(int value);

        public native int DCBlength();

        public native int BaudRate();

        public native void BaudRate(int value);

        public native boolean fBinary();

        public native boolean fParity();

        public native boolean fOutxCtsFlow();

        public native void fOutxCtsFlow(boolean value);

        public native boolean fOutxDsrFlow();

        public native int fDtrControl();

        public native boolean fDsrSensitivity();

        public native boolean fTXContinueOnXoff();

        public native boolean fOutX();

        public native void fOutX(boolean value);

        public native boolean fInX();

        public native void fInX(boolean value);

        public native boolean fErrorChar();

        public native boolean fNull();

        public native int fRtsControl();

        public native void fRtsControl(int value);

        public native boolean fAbortOnError();

        public native int fDummy2();

        public native short wReserved();

        public native short XonLim();

        public native short XoffLim();

        public native byte ByteSize();

        public native void ByteSize(byte value);

        public native byte Parity();

        public native void Parity(byte value);

        public native byte StopBits();

        public native void StopBits(byte value);

        public native char XonChar();

        public native void XonChar(char value);

        public native char XoffChar();

        public native void XoffChar(char value);

        public native char ErrorChar();

        public native char EofChar();

        public native char EvtChar();

        public native short wReserved1();

    }

    public final static class COMMTIMEOUTS extends OpaqueMemory {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwWinApiLoader.touch();
        }

        public final static native int sizeofCOMMTIMEOUTS();

        public COMMTIMEOUTS(boolean clearMemory) {
            super(sizeofCOMMTIMEOUTS(), clearMemory);
        }

        public native int ReadIntervalTimeout();

        public native void ReadIntervalTimeout(int value);

        public native int ReadTotalTimeoutMultiplier();

        public native void ReadTotalTimeoutMultiplier(int value);

        public native int ReadTotalTimeoutConstant();

        public native void ReadTotalTimeoutConstant(int value);

        public native int WriteTotalTimeoutMultiplier();

        public native void WriteTotalTimeoutMultiplier(int value);

        public native int WriteTotalTimeoutConstant();

        public native void WriteTotalTimeoutConstant(int value);

    }

    private static HANDLE INVALID_HANDLE_VALUE;

    @Define
    public final static native HANDLE create_INVALID_HANDLE_VALUE();

    @Define
    public final static HANDLE INVALID_HANDLE_VALUE() {
        if (INVALID_HANDLE_VALUE == null) {
            INVALID_HANDLE_VALUE = create_INVALID_HANDLE_VALUE();
        }
        return INVALID_HANDLE_VALUE;
    }

    public final native static void CloseHandle(HANDLE hObject) throws NativeErrorException;

    public final native static void ClearCommBreak(HANDLE hFile) throws NativeErrorException;

    public final static native void ClearCommError(HANDLE hFile, IntRef lpErrors, COMSTAT lpStat) throws NativeErrorException;

    public final static native void EscapeCommFunction(HANDLE hFile, int dwFunc) throws NativeErrorException;

    public final static native void GetCommModemStatus(HANDLE hFile, IntRef lpModemStat) throws NativeErrorException;

    public final static native void GetCommState(HANDLE hFile, DCB lpDCB) throws NativeErrorException;

    public final static native void GetCommTimeouts(HANDLE hFile, COMMTIMEOUTS lpCommTimeouts) throws NativeErrorException;

    public final static native void SetCommBreak(HANDLE hFile) throws NativeErrorException;

    public final static native void SetCommState(HANDLE hFile, DCB lpDCB) throws NativeErrorException;

    public final static native void SetCommTimeouts(HANDLE hFile, COMMTIMEOUTS lpCommTimeouts) throws NativeErrorException;

    @Define
    public final static native byte NOPARITY();

    @Define
    public final static native byte ODDPARITY();

    @Define
    public final static native byte EVENPARITY();

    @Define
    public final static native byte MARKPARITY();

    @Define
    public final static native byte SPACEPARITY();

    @Define
    public final static native byte ONESTOPBIT();

    @Define
    public final static native byte ONE5STOPBITS();

    @Define
    public final static native byte TWOSTOPBITS();

    @Define
    public final static native int INFINITE();

    @Define
    public final static native int SETRTS();

    @Define
    public final static native int CLRRTS();

    @Define
    public final static native int SETDTR();

    @Define
    public final static native int CLRDTR();

    @Define
    public final static native int SETBREAK();

    @Define
    public final static native int CLRBREAK();

    @Define
    public final static native int MS_CTS_ON();

    @Define
    public final static native int MS_DSR_ON();

    @Define
    public final static native int MS_RING_ON();

    @Define
    public final static native int MS_RLSD_ON();

    @Define
    public final static native int GetLastError();

}
