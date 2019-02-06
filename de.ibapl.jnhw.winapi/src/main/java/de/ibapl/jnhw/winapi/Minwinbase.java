/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.LibJnhwWinApiLoader;
import de.ibapl.jnhw.OpaqueMemory;

/**
 *
 * @author aploese
 */
@Include("minwinbase.h")
public class Minwinbase extends LibJnhwWinApiLoader {

    public final static class OVERLAPPED extends OpaqueMemory {

        static {
            LibJnhwWinApiLoader.loadLibJnhwWinApi();
        }
        
        public final static native int sizeofOVERLAPPED();
        
        public final static native long Internal(long baseAddress);
        public final static native long InternalHigh(long baseAddress);
        private static native long hEvent(long baseAddress);
        private static native void hEvent(long baseAddress, long value);
        
        private Minwindef.HANDLE hEvent;
        
        public final void hEvent(Minwindef.HANDLE value) {
            hEvent = value;
            hEvent(baseAddress, hEvent.value);
        }
        
        //TODO test for modifications in native mem ???
        public final Minwindef.HANDLE hEvent() {
            return hEvent;
        }

        public OVERLAPPED() {
            super(sizeofOVERLAPPED(), true);
       }

    }

    public static class SECURITY_ATTRIBUTES extends OpaqueMemory {

        static {
            LibJnhwWinApiLoader.loadLibJnhwWinApi();
        }
        
        public final static native int sizeofSECURITY_ATTRIBUTES();

        public static final native long nLength(long baseAddress);
        private Minwindef.LPVOID lpSecurityDescriptor;
        private static native boolean bInheritHandle0(long baseAddress);

        public SECURITY_ATTRIBUTES() {
            super(sizeofSECURITY_ATTRIBUTES(), true);
       }
        
    };

}
