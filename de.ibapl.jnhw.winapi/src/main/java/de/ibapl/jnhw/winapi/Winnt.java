package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.LibJnhwWinApiLoader;
import de.ibapl.jnhw.LongRef;
import de.ibapl.jnhw.OpaqueMemory;

@Include("winnt.h")
public final class Winnt extends LibJnhwWinApiLoader {
    
    

    public static class ACCESS_MASK extends IntRef{

        public ACCESS_MASK(int value) {
            super(value);
        }
        
        public ACCESS_MASK() {
            super();
        }

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

        public LPWSTR(int size, boolean clearMemory) {
            super(size, clearMemory);
        }
        
//        private static native void setString(long baseAddress, CharSequence value);
        
//        public void set(CharSequence value) {
//            setString(baseAddress, value);
//        }

        private static native String getNullString(long baseAddress);
        
        /**
         * return the NULL terminated string @baseaddress 
         * @param value
         * @return 
         */
        public String getNullString(String value) {
            return getNullString(baseAddress);
        }

        public void clear() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }


}
