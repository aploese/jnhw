/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.LibJnhwWinApiLoader;
import de.ibapl.jnhw.OpaqueMemory;
import static de.ibapl.jnhw.winapi.Winnt.HANDLE;

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
        
        private final static native long Internal(long baseAddress);
        private final static native long InternalHigh(long baseAddress);
        private static native long hEvent(long baseAddress);
        private static native void hEvent(long baseAddress, long value);
        
        private HANDLE hEvent;

        public OVERLAPPED(boolean clearMem) {
            super(sizeofOVERLAPPED(), clearMem);
        }
        
        public final void hEvent(HANDLE value) {
            hEvent = value;
            hEvent(baseAddress, hEvent.value);
        }
        
        //TODO test for modifications in native mem ???
        public final HANDLE hEvent() {
            return hEvent;
        }

    }

    public static class SECURITY_ATTRIBUTES extends OpaqueMemory {

        static {
            LibJnhwWinApiLoader.loadLibJnhwWinApi();
        }
        
        public final static native int sizeofSECURITY_ATTRIBUTES();

        private static final native long nLength(long baseAddress);
        private Minwindef.LPVOID lpSecurityDescriptor;
        private static native boolean bInheritHandle(long baseAddress);

        public SECURITY_ATTRIBUTES() {
            super(sizeofSECURITY_ATTRIBUTES(), true);
       }
        
    };

}
