/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ibapl.jnhw.winapi;

/**
 *
 * @author aploese
 */
public class Minwinbase {

    public static class OVERLAPPED {

       long Internal;
        long InternalHigh;
        public Minwindef.HANDLE hEvent;

        public OVERLAPPED(boolean zeroMemory) {
            	//do in native OVERLAPPED overlapped = {};
       }

    }

    public static class SECURITY_ATTRIBUTES {

        long nLength;
        Minwindef.LPVOID lpSecurityDescriptor;
        boolean bInheritHandle;
    };

}
