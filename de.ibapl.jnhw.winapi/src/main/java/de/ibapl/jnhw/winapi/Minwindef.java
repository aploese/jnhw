package de.ibapl.jnhw.winapi;

public abstract class Minwindef {

    @Deprecated
    public static class LPVOID {

        public long address;

        public LPVOID(long address) {
            this.address = address;
        }

        LPVOID() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    public static class HKEY extends HANDLE {

        private HKEY(long value) {
            super(value);
        }

        public HKEY() {
            super();
        }

    }

    /**
     * Just the pointer to HKEY that where meaning it can be overwritten....
     */
    public final static class PHKEY extends HKEY {
        
    }
    
    
    //TODO Win32 use int instead of long???
    public static class HANDLE {

        public long value;

        protected HANDLE(long value) {
            this.value = value;
        }

        protected HANDLE() {
        }

    }

    /**
     *
     * The wrapper for a ByteBuffer. The position of the buffer is always 0! It
     * must be reset to 0 if changed. The limit of the buffer is always amount
     * of valid bytes in the buffer and must be set if the amount of valid bytes
     * changed.
     */
    public static class LPWSTR {

        public LPWSTR(int size) {
        }

        public LPWSTR(String value) {
        }

        public void clear() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    public static class LPBYTE {

        public LPBYTE(int size) {
        }

        public void clear() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public String toString(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
