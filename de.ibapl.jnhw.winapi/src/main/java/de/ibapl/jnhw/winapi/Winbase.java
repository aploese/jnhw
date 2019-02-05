package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.winapi.Minwindef.HANDLE;

public abstract class Winbase {

    public final static native int WAIT_FAILED();
    public final static native int WAIT_OBJECT_0();

    public final static native int WAIT_ABANDONED();
    public final static native int WAIT_TIMEOUT();
    
    public final static native int FILE_FLAG_OVERLAPPED();
    public final static native int RTS_CONTROL_DISABLE();
    public final static native int RTS_CONTROL_HANDSHAKE();

    /**
     * Read only, we do not need to write anything.
     */
     public static class COMSTAT {

        public final native boolean fCtsHold();
        public final native boolean fDsrHold();
        public final native boolean fRlsdHold();
        public final native boolean fXoffHold();
        public final native boolean fXoffSent();
        public final native boolean fEof();
        public final native boolean fTxim();
        public final native int fReserved();
        public final native int cbInQue();
        public final native int cbOutQue();
    }
     
    public final static class DCB {
        
        public DCB() {
            super();
            DCBlength(sizeofDCB());
        }

        public final static native int sizeofDCB();
        //TODO set this in init!!!
        public  native int DCBlength(int value);
        public  native int BaudRate();
        public  native void BaudRate(int value);
        public  native boolean fBinary();
        public  native  boolean fParity();
        public  native  boolean fOutxCtsFlow();
        public  native  void fOutxCtsFlow(boolean value);
        public  native boolean fOutxDsrFlow();
        public  native int fDtrControl();
        public  native boolean fDsrSensitivity();
        public  native boolean fTXContinueOnXoff();
        public  native  boolean fOutX();
        public  native  void fOutX(boolean value);
        public  native  boolean fInX();
        public  native  void fInX(boolean value);
        public  native boolean fErrorChar();
        public  native boolean fNull();
        public  native  int fRtsControl();
        public  native  void fRtsControl(int value);
        public  native boolean fAbortOnError();
        public  native int fDummy2();
        public  native short wReserved();
        public  native short XonLim();
        public  native short XoffLim();
        public  native  byte ByteSize();
        public  native  void ByteSize(byte value);
        public  native  byte Parity();
        public  native  void Parity(byte value);
        public  native  byte StopBits();
        public  native  void StopBits(byte value);
        public  native  char XonChar();
        public  native  void XonChar(char value);
        public  native  char XoffChar();
        public  native  void XoffChar(char value);
        public  native char ErrorChar();
        public  native char EofChar();
        public  native char EvtChar();
        public native short wReserved1();
    }

    public final static class COMMTIMEOUTS {

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

    public final static native HANDLE INVALID_HANDLE_VALUE();

    public final static native  void CloseHandle(HANDLE hObject) throws NativeErrorException;

    public final static native void ClearCommBreak(HANDLE hFile) throws NativeErrorException;

    public final static native void ClearCommError(HANDLE hFile, IntRef lpErrors, COMSTAT lpStat) throws NativeErrorException;

    public final static native void EscapeCommFunction(HANDLE hFile, int dwFunc) throws NativeErrorException;

    public final static native void GetCommModemStatus(HANDLE hFile, IntRef lpModemStat) throws NativeErrorException;

    public final static native void GetCommState(HANDLE hFile, DCB lpDCB) throws NativeErrorException;

    public final static native void GetCommTimeouts(HANDLE hFile, COMMTIMEOUTS lpCommTimeouts) throws NativeErrorException;

    public final static native void SetCommBreak(HANDLE hFile) throws NativeErrorException;

    public final static native void SetCommState(HANDLE hFile, DCB lpDCB) throws NativeErrorException;

    public final static native void SetCommTimeouts(HANDLE hFile, COMMTIMEOUTS lpCommTimeouts) throws NativeErrorException;

    public final static native byte NOPARITY();
    public final static native byte ODDPARITY();
    public final static native byte EVENPARITY();
    public final static native byte MARKPARITY();
    public final static native byte SPACEPARITY();

    public final static native byte ONESTOPBIT();
    public final static native byte ONE5STOPBITS();
    public final static native byte TWOSTOPBITS();

    public final static native int INFINITE();

    public final static native int SETRTS();
    public final static native int CLRRTS();
    public final static native int SETDTR();
    public final static native int CLRDTR();
    public final static native int SETBREAK();
    public final static native int CLRBREAK();

    public final static native int MS_CTS_ON();
    public final static native int MS_DSR_ON();
    public final static native int MS_RING_ON();
    public final static native int MS_RLSD_ON();

    public final static native int GetLastError();

}
