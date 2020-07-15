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
package de.ibapl.jnhw.util.posix;

import de.ibapl.jnhw.NotDefinedException;

/**
 * get the defines with gcc: create an empty file c.c run
 * {@code gcc -dD -dI -E c.c &gt; c.txt} c.txt contains all macros. add an
 * {@code #include &lt;headerFileName.h>} to get the defines for that header.
 *
 * @author aploese
 */
public class Defines {

    static {
        LibJnhwPosixLoader.touch();
    }

//TODO implement @Define???
    public static native boolean _LARGEFILE_SOURCE();
    /**
     * _LARGEFILE64_SOURCE was defined at native compile time. If
     * _LARGEFILE64_SOURCE was defined then all largefile64 functions (i.e.
     * open64, read64, fseek64, ...) are available.
     *
     * @return true if symbol {@code _LARGEFILE64_SOURCE} was defined at compile
     * time of the native code.
     */
    public static native boolean _LARGEFILE64_SOURCE();

    /**
     * @return true if symbol {@code __APPLE__} was defined at compile time of
     * the native code.
     */
    public static native boolean __APPLE__();

    /**
     *
     * @return the major version at compile time
     * @throws de.ibapl.jnhw.NotDefinedException if {@code __FreeBSD__} was
     * defined at compile time of the native code.
     */
    public static native int __FreeBSD__() throws NotDefinedException;
    
    /**
     * Its defined at different places: Linux: bits/wordsize.h FreeBSD:
     * sys/stdint.h
     *
     * so we keep his here for the moment.
     *_POSIX_C_SOURCE
     * @return
     * @throws NotDefinedException if run on WINDOWS
     */
    public static native int __WORDSIZE();
    
//TODO implement
    public static native int _FILE_OFFSET_BITS();
    
//TODO implement
    public static native int _POSIX_C_SOURCE();
    
//TODO implement
    public static native int __POSIX_VISIBLE();

//TODO implement
    public static native int _XOPEN_SOURCE();
    
//TODO implement
    public static native int _XOPEN_SOURCE_EXTENDED();

    /**
     * @return true if symbol {@code __linux__} was defined at compile time of
     * the native code.
     */
    public static native boolean __linux__();

}
