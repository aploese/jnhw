package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.LongRef;
import de.ibapl.jnhw.OpaqueMemory;
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

        public HKEY(long value) {
            super(value);
        }
        
        
        public HKEY() {
            super();
        }
        
    }

    /**
     * Just the pointer to HKEY that where meaning it can be overwritten....
     */
    public static class PHKEY extends HKEY {
        
        public PHKEY(long value) {
            super(value);
        }
        
        
        public PHKEY() {
            super();
        }
        
    }
    
    

    public static class LPBYTE extends OpaqueMemory {

        final IntRef bufferEnd;

        public LPBYTE(int size, boolean clearMemory) {
            super(size, clearMemory);
            bufferEnd = new IntRef(size);
        }

        public void clear() {
        	OpaqueMemory.clear(this);
        	bufferEnd.value = sizeInBytes;
        }

        public void resetBufferEnd() {
        	bufferEnd.value = sizeInBytes;
        }

        public String toString(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
