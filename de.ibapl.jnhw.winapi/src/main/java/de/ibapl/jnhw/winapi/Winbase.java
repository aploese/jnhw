package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.LibJnhwWinApiLoader;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.OpaqueMemory;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;

@Include("WinBase.h")
public abstract class Winbase extends LibJnhwWinApiLoader {

    public final static native boolean HAVE_WINBASE_H();

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

        public final static native int sizeofCOMSTAT();

        public COMSTAT(boolean clearMemory) {
            super(sizeofCOMSTAT(), clearMemory);
        }

        private static native boolean fCtsHold(long baseAddress);

        private static native boolean fDsrHold(long baseAddress);

        private static native boolean fRlsdHold(long baseAddress);

        private static native boolean fXoffHold(long baseAddress);

        private static native boolean fXoffSent(long baseAddress);

        private static native boolean fEof(long baseAddress);

        private static native boolean fTxim(long baseAddress);

        private static native int fReserved(long baseAddress);

        private static native int cbInQue(long baseAddress);

        private static native int cbOutQue(long baseAddress);

        public final boolean fCtsHold() {
            return fCtsHold(baseAddress);
        }

        public final boolean fDsrHold() {
            return fDsrHold(baseAddress);
        }

        public final boolean fRlsdHold() {
            return fRlsdHold(baseAddress);
        }

        public final boolean fXoffHold() {
            return fXoffHold(baseAddress);
        }

        public final boolean fXoffSent() {
            return fXoffSent(baseAddress);
        }

        public final boolean fEof() {
            return fEof(baseAddress);
        }

        public final boolean fTxim() {
            return fTxim(baseAddress);
        }

        public final int fReserved() {
            return fReserved(baseAddress);
        }

        public final int cbInQue() {
            return cbInQue(baseAddress);
        }

        public final int cbOutQue() {
            return cbOutQue(baseAddress);
        }
    }

    public final static class DCB extends OpaqueMemory {

        public DCB(boolean clearMemory) {
            super(sizeofDCB(), clearMemory);
            DCBlength(baseAddress, sizeofDCB());
        }

        public final static native int sizeofDCB();

        //TODO set this in init!!!
        private static native void DCBlength(long baseAddress, int value);

        private static native int DCBlength(long baseAddress);

        private static native int BaudRate(long baseAddress);

        private static native void BaudRate(long baseAddress, int value);

        private static native boolean fBinary(long baseAddress);

        private static native boolean fParity(long baseAddress);

        private static native boolean fOutxCtsFlow(long baseAddress);

        private static native void fOutxCtsFlow(long baseAddress, boolean value);

        private static native boolean fOutxDsrFlow(long baseAddress);

        private static native int fDtrControl(long baseAddress);

        private static native boolean fDsrSensitivity(long baseAddress);

        private static native boolean fTXContinueOnXoff(long baseAddress);

        private static native boolean fOutX(long baseAddress);

        private static native void fOutX(long baseAddress, boolean value);

        private static native boolean fInX(long baseAddress);

        private static native void fInX(long baseAddress, boolean value);

        private static native boolean fErrorChar(long baseAddress);

        private static native boolean fNull(long baseAddress);

        private static native int fRtsControl(long baseAddress);

        private static native void fRtsControl(long baseAddress, int value);

        private static native boolean fAbortOnError(long baseAddress);

        private static native int fDummy2(long baseAddress);

        private static native short wReserved(long baseAddress);

        private static native short XonLim(long baseAddress);

        private static native short XoffLim(long baseAddress);

        private static native byte ByteSize(long baseAddress);

        private static native void ByteSize(long baseAddress, byte value);

        private static native byte Parity(long baseAddress);

        private static native void Parity(long baseAddress, byte value);

        private static native byte StopBits(long baseAddress);

        private static native void StopBits(long baseAddress, byte value);

        private static native char XonChar(long baseAddress);

        private static native void XonChar(long baseAddress, char value);

        private static native char XoffChar(long baseAddress);

        private static native void XoffChar(long baseAddress, char value);

        private static native char ErrorChar(long baseAddress);

        private static native char EofChar(long baseAddress);

        private static native char EvtChar(long baseAddress);

        private static native short wReserved1(long baseAddress);

        public int BaudRate() {
            return BaudRate(baseAddress);
        }

        public void BaudRate(int value) {
            BaudRate(baseAddress, value);
        }

        public boolean fBinary() {
            return fBinary(baseAddress);
        }

        public boolean fParity() {
            return fParity(baseAddress);
        }

        public boolean fOutxCtsFlow() {
            return fOutxCtsFlow(baseAddress);
        }

        public void fOutxCtsFlow(boolean value) {
            fOutxCtsFlow(baseAddress, value);
        }

        public boolean fOutxDsrFlow() {
            return fOutxDsrFlow(baseAddress);
        }

        public int fDtrControl() {
            return fDtrControl(baseAddress);
        }

        public boolean fDsrSensitivity() {
            return fDsrSensitivity(baseAddress);
        }

        public boolean fTXContinueOnXoff() {
            return fTXContinueOnXoff(baseAddress);
        }

        public boolean fOutX() {
            return fOutX(baseAddress);
        }

        public void fOutX(boolean value) {
            fOutX(baseAddress, value);
        }

        public boolean fInX() {
            return fInX(baseAddress);
        }

        public void fInX(boolean value) {
            fInX(baseAddress, value);
        }

        public boolean fErrorChar() {
            return fErrorChar(baseAddress);
        }

        public boolean fNull() {
            return fNull(baseAddress);
        }

        public int fRtsControl() {
            return fRtsControl(baseAddress);
        }

        public void fRtsControl(int value) {
            fRtsControl(baseAddress, value);
        }

        public boolean fAbortOnError() {
            return fAbortOnError(baseAddress);
        }

        public int fDummy2() {
            return fDummy2(baseAddress);
        }

        public short wReserved() {
            return wReserved(baseAddress);
        }

        public short XonLim() {
            return XonLim(baseAddress);
        }

        public short XoffLim() {
            return XoffLim(baseAddress);
        }

        public byte ByteSize() {
            return ByteSize(baseAddress);
        }

        public void ByteSize(byte value) {
            ByteSize(baseAddress, value);
        }

        public byte Parity() {
            return Parity(baseAddress);
        }

        public void Parity(byte value) {
            Parity(baseAddress, value);
        }

        public byte StopBits() {
            return StopBits(baseAddress);
        }

        public void StopBits(byte value) {
            StopBits(baseAddress, value);
        }

        public char XonChar() {
            return XonChar(baseAddress);
        }

        public void XonChar(char value) {
            XonChar(baseAddress, value);
        }

        public char XoffChar() {
            return XoffChar(baseAddress);
        }

        public void XoffChar(char value) {
            XoffChar(baseAddress, value);
        }

        public char ErrorChar() {
            return ErrorChar(baseAddress);
        }

        public char EofChar() {
            return EofChar(baseAddress);
        }

        public char EvtChar() {
            return EvtChar(baseAddress);
        }

        public short wReserved1() {
            return wReserved(baseAddress);
        }

    }

    public final static class COMMTIMEOUTS extends OpaqueMemory {

        public final static native int sizeofCOMMTIMEOUTS();

        public COMMTIMEOUTS(boolean clearMemory) {
            super(sizeofCOMMTIMEOUTS(), clearMemory);
        }

        private static native int ReadIntervalTimeout(long baseAddress);

        private static native void ReadIntervalTimeout(long baseAddress, int value);

        private static native int ReadTotalTimeoutMultiplier(long baseAddress);

        private static native void ReadTotalTimeoutMultiplier(long baseAddress, int value);

        private static native int ReadTotalTimeoutConstant(long baseAddress);

        private static native void ReadTotalTimeoutConstant(long baseAddress, int value);

        private static native int WriteTotalTimeoutMultiplier(long baseAddress);

        private static native void WriteTotalTimeoutMultiplier(long baseAddress, int value);

        private static native int WriteTotalTimeoutConstant(long baseAddress);

        private static native void WriteTotalTimeoutConstant(long baseAddress, int value);

        public int ReadIntervalTimeout() {
            return ReadIntervalTimeout(baseAddress);
        }

        public void ReadIntervalTimeout(int value) {
            ReadIntervalTimeout(baseAddress, value);
        }

        public int ReadTotalTimeoutMultiplier() {
            return ReadTotalTimeoutMultiplier(baseAddress);
        }

        public void ReadTotalTimeoutMultiplier(int value) {
            ReadTotalTimeoutMultiplier(baseAddress, value);
        }

        public int ReadTotalTimeoutConstant() {
            return ReadTotalTimeoutConstant(baseAddress);
        }

        public void ReadTotalTimeoutConstant(int value) {
            ReadTotalTimeoutConstant(baseAddress, value);
        }

        public int WriteTotalTimeoutMultiplier() {
            return WriteTotalTimeoutMultiplier(baseAddress);
        }

        public void WriteTotalTimeoutMultiplier(int value) {
            WriteTotalTimeoutMultiplier(baseAddress, value);
        }

        public int WriteTotalTimeoutConstant() {
            return WriteTotalTimeoutConstant(baseAddress);
        }

        public void WriteTotalTimeoutConstant(int value) {
            WriteTotalTimeoutConstant(baseAddress, value);
        }

    }
    @Define
    private static native long INVALID_HANDLE_VALUE0();
    
    public final static HANDLE INVALID_HANDLE_VALUE() {
        return new HANDLE(INVALID_HANDLE_VALUE0());
    }

    private static native void CloseHandle(long hObject) throws NativeErrorException;

    public final static void CloseHandle(HANDLE hObject) throws NativeErrorException {
        CloseHandle(hObject.value);
    }

    private static native void ClearCommBreak(long hFile) throws NativeErrorException;

    public final static void ClearCommBreak(HANDLE hFile) throws NativeErrorException {
        ClearCommBreak(hFile.value);
    }

    private static native void ClearCommError(long hFile, IntRef lpErrors, long lpStat) throws NativeErrorException;

    public final static void ClearCommError(HANDLE hFile, IntRef lpErrors, COMSTAT lpStat) throws NativeErrorException {
        ClearCommError(hFile.value, lpErrors, lpStat.baseAddress);
    }

    private static native void EscapeCommFunction(long hFile, int dwFunc) throws NativeErrorException;

    public final static void EscapeCommFunction(HANDLE hFile, int dwFunc) throws NativeErrorException {
        EscapeCommFunction(hFile.value, dwFunc);
    }

    private static native void GetCommModemStatus(long hFile, IntRef lpModemStat) throws NativeErrorException;

    public final static void GetCommModemStatus(HANDLE hFile, IntRef lpModemStat) throws NativeErrorException {
        GetCommModemStatus(hFile.value, lpModemStat);
    }

    private static native void GetCommState(long hFile, long lpDCB) throws NativeErrorException;

    public final static void GetCommState(HANDLE hFile, DCB lpDCB) throws NativeErrorException {
        GetCommState(hFile.value, lpDCB.baseAddress);
    }

    private static native void GetCommTimeouts(long hFile, long lpCommTimeouts) throws NativeErrorException;

    public final static void GetCommTimeouts(HANDLE hFile, COMMTIMEOUTS lpCommTimeouts) throws NativeErrorException {
        GetCommTimeouts(hFile.value, lpCommTimeouts.baseAddress);
    }

    private static native void SetCommBreak(long hFile) throws NativeErrorException;

    public final static void SetCommBreak(HANDLE hFile) throws NativeErrorException {
        SetCommBreak(hFile.value);
    }

    private static native void SetCommState(long hFile, long lpDCB) throws NativeErrorException;

    public final static void SetCommState(HANDLE hFile, DCB lpDCB) throws NativeErrorException {
        SetCommState(hFile.value, lpDCB.baseAddress);
    }

    private static native void SetCommTimeouts(long hFile, long lpCommTimeouts) throws NativeErrorException;

    public final static void SetCommTimeouts(HANDLE hFile, COMMTIMEOUTS lpCommTimeouts) throws NativeErrorException {
        SetCommTimeouts(hFile.value, lpCommTimeouts.baseAddress);
    }

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
