package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.LibJnhwWinApiLoader;
import de.ibapl.jnhw.LongRef;
import de.ibapl.jnhw.OpaqueMemory;

@Include("winnt.h")
public final class Winnt extends LibJnhwWinApiLoader {

    public final static native boolean HAVE_WINNT_H();

    @Define
    public final static native int MAXDWORD();

    @Define
    public final static native int GENERIC_READ();

    @Define
    public final static native int GENERIC_WRITE();

    @Define
    public final static native int KEY_READ();

    @Define
    public final static native int REG_NONE();

    @Define
    public final static native int REG_SZ();

    @Define
    public final static native int REG_EXPAND_SZ();

    @Define
    public final static native int REG_BINARY();

    @Define
    public final static native int REG_DWORD();

    @Define
    public final static native int REG_DWORD_LITTLE_ENDIAN();

    @Define
    public final static native int REG_DWORD_BIG_ENDIAN();

    @Define
    public final static native int REG_LINK();

    @Define
    public final static native int REG_MULTI_SZ();

    @Define
    public final static native int REG_RESOURCE_LIST();

    @Define
    public final static native int REG_FULL_RESOURCE_DESCRIPTOR();

    @Define
    public final static native int REG_RESOURCE_REQUIREMENTS_LIST();

    @Define
    public final static native int REG_QWORD();

    @Define
    public final static native int REG_QWORD_LITTLE_ENDIAN();

    public static class HANDLE extends LongRef {

        public HANDLE(long value) {
            this.value = value;
        }

        public HANDLE() {
        }

    }

    /**
     *
     * The wrapper for a ByteBuffer. The position of the buffer is always 0! It
     * must be reset to 0 if changed. The limit of the buffer is always amount
     * of valid bytes in the buffer and must be set if the amount of valid bytes
     * changed.
     */
    public static class LPWSTR extends OpaqueMemory {

        public final static int SIZE_OF_WCHAR = 2;

        /**
         * Skip the last two 0 bytes aka the last 0 char
         * @param lpData
         * @return
         */
        public static String stringValueOfNullTerminated(Minwindef.LPBYTE lpData) {
            return getString(lpData.baseAddress, lpData.bufferEnd.value / SIZE_OF_WCHAR - 1);
        }

        final IntRef bufferEnd;

        /**
         * Creates space for a Wide String (16 bit)
         *
         * @param elementLength 
         * @param clearMemory
         */
        public LPWSTR(int elementLength, boolean clearMemory) {
            super(elementLength, SIZE_OF_WCHAR, clearMemory);
            bufferEnd = new IntRef(elementLength);
        }

//        private static native void setString(long baseAddress, String value);
//        public void set(String value) {
//            setString(baseAddress, value);
//        }
        private static native String getString(long baseAddress, int charLength);

        /**
         * return the NULL terminated string @baseaddress
         *
         * @return
         */
        public String getString() {
            return getString(baseAddress, bufferEnd.value);
        }

        public void clear() {
            OpaqueMemory.clear(this);
            bufferEnd.value = sizeInBytes / SIZE_OF_WCHAR;
        }

        public void resetBufferEnd() {
            bufferEnd.value = sizeInBytes;
        }

    }

}
