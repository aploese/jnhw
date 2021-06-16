/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2021, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Wrapper around the {@code <stdio.h>} header.
 *
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/stdio.h.html">stdio.h
 * - standard buffered input/output</a>.
 *
 * @author aploese
 */
@Include("#include <stdio.h>")
public class Stdio {

    public static class LinuxDefines {

        public static final int EOF = -1;
        public static final int SEEK_CUR = 1;
        public static final int SEEK_END = 2;
        public static final int SEEK_SET = 0;

    }

    /**
     * Make sure the native lib is loaded
     *
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        LibJnhwPosixLoader.touch();
        switch (LibJnhwPosixLoader.getLoadResult().multiarchInfo.getOS()) {
            case LINUX:
                HAVE_STDIO_H = true;
                EOF = LinuxDefines.EOF;
                SEEK_CUR = LinuxDefines.SEEK_CUR;
                SEEK_END = LinuxDefines.SEEK_END;
                SEEK_SET = LinuxDefines.SEEK_SET;
                break;
            default:
                throw new NoClassDefFoundError("No stdio.h defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
        }
    }

    public final static boolean HAVE_STDIO_H;

    /**
     * <b>POSIX:</b>seek relative to current position.
     *
     */
    @Define
    public static int SEEK_CUR;

    /**
     * <b>POSIX:</b>End-of-file return value.
     *
     */
    @Define
    public static int EOF;

    /**
     * <b>POSIX:</b> Seek relative to end-of-file.
     *
     */
    @Define
    public static int SEEK_END;

    /**
     * <b>POSIX:</b> Seek relative to start-of-file.
     *
     */
    @Define
    public static int SEEK_SET;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/getchar.html">getchar
     * - get a byte from a stdin stream</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static native char getchar() throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/putchar.html">putchar
     * - put a byte on a stdout stream</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static native void putchar(char c) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/remove.html">remove
     * - remove a file</a>.
     *
     * @param path the pathname naming the file.
     *
     * @throws NullPointerException if {@code file} is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static native void remove(String path) throws NativeErrorException;

}
