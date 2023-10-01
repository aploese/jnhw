/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI___A;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI___V;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.libraries.LibcLoader;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

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

    public static interface BsdDefines {

        public static final int EOF = -1;
        public static final int SEEK_CUR = 1;
        public static final int SEEK_END = 2;
        public static final int SEEK_SET = 0;
    }

    public static interface FreeBsdDefines extends BsdDefines {

    }

    public static interface LinuxDefines {

        public static final int EOF = -1;
        public static final int SEEK_CUR = 1;
        public static final int SEEK_END = 2;
        public static final int SEEK_SET = 0;
    }

    public static interface OpenBsdDefines extends BsdDefines {

    }

    /**
     * <b>POSIX:</b>End-of-file return value.
     *
     */
    @Define
    public static int EOF;

    public final static boolean HAVE_STDIO_H;

    /**
     * <b>POSIX:</b>seek relative to current position.
     *
     */
    @Define
    public static int SEEK_CUR;

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
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX -> {
                HAVE_STDIO_H = true;
                EOF = LinuxDefines.EOF;
                SEEK_CUR = LinuxDefines.SEEK_CUR;
                SEEK_END = LinuxDefines.SEEK_END;
                SEEK_SET = LinuxDefines.SEEK_SET;
            }
            case APPLE, FREE_BSD, OPEN_BSD -> {
                HAVE_STDIO_H = true;
                EOF = BsdDefines.EOF;
                SEEK_CUR = BsdDefines.SEEK_CUR;
                SEEK_END = BsdDefines.SEEK_END;
                SEEK_SET = BsdDefines.SEEK_SET;
            }
            default ->
                throw new NoClassDefFoundError("No stdio.h defines for " + MultiarchTupelBuilder.getMultiarch());
        }
    }

    private final static JnhwMh_sI___V.ExceptionErased getchar = JnhwMh_sI___V.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "getchar",
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI.ExceptionErased putchar = JnhwMh_sI__sI.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "putchar",
            BaseDataType.C_int,
            BaseDataType.C_int);

    private final static JnhwMh_sI___A.ExceptionErased remove = JnhwMh_sI___A.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "remove",
            BaseDataType.C_int,
            BaseDataType.C_const_char_pointer);

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/getchar.html">getchar
     * - get a byte from a stdin stream</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static char getchar() throws NativeErrorException {
        final int result = getchar.invoke_sI___V();
        if (result == EOF) {
            throw new NativeErrorException(Errno.errno());
        }
        return (char) result;
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/putchar.html">putchar
     * - put a byte on a stdout stream</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static void putchar(char c) throws NativeErrorException {
        final int result = putchar.invoke_sI__sI(c);
        if (result == EOF) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/remove.html">remove
     * - remove a file</a>.
     *
     * @param path the pathname naming the file.
     *
     * @throws NullPointerException if {@code path} is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void remove(String path) throws NativeErrorException {
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment _path = arena.allocate(path.length() + 1);
            _path.setUtf8String(0, path);
            int result = remove.invoke_sI___A(_path);
            if (result != 0) {
                throw new NativeErrorException(Errno.errno());
            }
        }
    }

}
