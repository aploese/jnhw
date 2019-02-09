package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.Include;
import static de.ibapl.jnhw.winapi.Winnt.HANDLE;

@Include("minwindef.h")
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
