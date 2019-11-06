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
 * get the defines with gcc:
 * create an empty file c.c
 * run gcc -dD -dI -E c.c > c.txt
 * c.txt contains all macros.
 * add an <code>#include <headerFileName.h> to get the defines for that header.
 * @author aploese
 */
public class Defines {
    
    static {
        LibJnhwPosixLoader.touch();
    }

    public static native boolean __linux__();

    public static native boolean __APPLE__();

    /**
     * 
     * @return the major version at compile time
     */
    public static native int __FreeBSD__() throws NotDefinedException;
    
    public static native boolean _LARGEFILE64_SOURCE();
    
    /**
     * Its defined at different places:
     * Linux: bits/wordsize.h
     * FreeBSD: sys/stdint.h
     * 
     * so we keep his here for the moment.
     * 
     * @return 
     * @throws NotDefinedException if run on WINDOWS
     */
    public static native int __WORDSIZE();
    
}
