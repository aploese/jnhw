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
import de.ibapl.jnhw.OpaqueMemory;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;

@Include("winnt.h")
public final class Winnt {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwWinApiLoader.touch();
    }

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

    public static class HANDLE {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwWinApiLoader.touch();
        }
        
        private final boolean mutable;
        private long value;

        /**
         * This must be tested if it is always -1L As it ist to be expected.
         */
        private final static long INVALID_HANDLE_VALUE = -1L;

        public HANDLE(long value, boolean mutable) {
            this.value = value;
            this.mutable = mutable;
        }

        public HANDLE() {
            this.mutable = true;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 11 * hash + (int) (this.value ^ (this.value >>> 32));
            return hash;
        }

        /**
         * TODO implement Windows equals system...
         *
         * @param obj
         * @return
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final HANDLE other = (HANDLE) obj;
            if (this.value != other.value) {
                return false;
            }
            return true;
        }

        /**
         * Test for validity: isSameHandleValue(Winbase.INVALID_HANDLE_VALUE());
         *
         * @param o
         * @return
         */
        public boolean isSameHandleValue(HANDLE o) {
            return value == o.value;
        }

        public boolean isValid() {
            return value != INVALID_HANDLE_VALUE;
        }

        public void invalidate() {
            if (!mutable) {
                throw new IllegalStateException("cant invalidate, HANDLE is not mutable!");
            }
            value = INVALID_HANDLE_VALUE;
        }

        public void set(HANDLE newValue) {
            if (!mutable) {
                throw new IllegalStateException("cant set, HANDLE is not mutable!");
            }
            value = newValue.value;
        }

        public void clear() {
            if (!mutable) {
                throw new IllegalStateException("cant clear, HANDLE is not mutable!");
            }
            value = 0;
        }

        public static HANDLE newInvalidHandle() {
            return new HANDLE(INVALID_HANDLE_VALUE, true);
        }

    }

    /**
     *
     * The wrapper for a byte buffer. The position of the buffer is always 0! It
     * must be reset to 0 if changed. The limit of the buffer is always amount
     * of valid bytes in the buffer and must be set if the amount of valid bytes
     * changed.
     */
    public static class LPWSTR extends OpaqueMemory {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwWinApiLoader.touch();
        }

        public final static int SIZE_OF_WCHAR = 2;

        /**
         * Skip the last two 0 bytes aka the last 0 char
         *
         * @param lpData
         * @return
         */
        public static String stringValueOfNullTerminated(Minwindef.LPBYTE lpData) {
            return getString(lpData, lpData.bufferEnd / SIZE_OF_WCHAR - 1);
        }

        int bufferEnd;

        /**
         * Creates space for a Wide String (16 bit)
         *
         * @param elementLength
         * @param clearMemory
         */
        public LPWSTR(int elementLength, boolean clearMemory) {
            super(elementLength, SIZE_OF_WCHAR, clearMemory);
            bufferEnd = elementLength;
        }

//        private static native void setString(long baseAddress, String value);
//        public void set(String value) {
//            setString(baseAddress, value);
//        }
        private static native String getString(OpaqueMemory lpByte, int charLength);

        /**
         * return the NULL terminated string @baseaddress
         *
         * @return
         */
        public String getString() {
            return getString(this, bufferEnd);
        }

        public void clear() {
            OpaqueMemory.clear(this);
            bufferEnd = sizeInBytes / SIZE_OF_WCHAR;
        }

        public void resetBufferEnd() {
            bufferEnd = sizeInBytes;
        }

    }

}
