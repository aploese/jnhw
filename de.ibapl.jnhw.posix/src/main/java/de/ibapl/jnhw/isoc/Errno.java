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
package de.ibapl.jnhw.isoc;

import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.downcall.JnhwMh_MA___V;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.libloader.MultiarchInfo;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.librarys.LibcLoader;
import java.lang.foreign.ValueLayout;

/**
 * Wrapper around the {@code <errno.h>} header.
 *
 * @see(module-info) for markers See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/errno.h.html">errno.h
 * - system error numbers</a>.
 *
 * @author aploese
 */
@Include("#include <errno.h>")
public abstract class Errno {

    /**
     * glibc: #define errno (*__errno_location ()) FreeBSD: #define errno (*
     * __error())
     *
     */
    private final static JnhwMh_MA___V.ExceptionErased jnhw__errno_location = JnhwMh_MA___V.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            switch (MultiarchTupelBuilder.getOS()) {
        case DARWIN, FREE_BSD, OPEN_BSD ->
            "__error";
        case LINUX ->
            "__errno_location";
        default ->
            throw new RuntimeException("Dont know how to get errno location");
    },
            BaseDataType.C_int_pointer);

    public static interface BsdDefines {

        public final static int EDOM = 33;
        public final static int ERANGE = 34;
    }

    public static interface DarwinDefines extends BsdDefines {

        public final static int EILSEQ = 92;
    }

    public static interface FreeBsdDefines extends BsdDefines {

        public final static int EILSEQ = 86;
    }

    public static class LinuxDefines {

        public final int EDOM = 33;
        public final int ERANGE = 34;
        public final int EILSEQ;

        public LinuxDefines(MultiarchInfo multiarchInfo) {
            EILSEQ = switch (multiarchInfo.getArch()) {
                case MIPS, MIPS_64 ->
                    88;
                default ->
                    84;
            };
        }
    }

    public static interface OpenBsdDefines extends BsdDefines {

        public final static int EILSEQ = 84;
    }

    /**
     * ISOC,POSIX: Mathematics argument out of domain of function.
     *
     */
    @Define
    public final static int EDOM;

    /**
     * ISOC,POSIX: Illegal byte sequence.
     *
     */
    @Define
    public final static int EILSEQ;

    /**
     * ISOC,POSIX: Result too large.
     *
     */
    @Define
    public final static int ERANGE;

    public final static boolean HAVE_ERRNO_H;

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
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX -> {
                HAVE_ERRNO_H = true;
                final LinuxDefines linuxDefines = new LinuxDefines(MultiarchTupelBuilder.getMultiarch());
                EDOM = linuxDefines.EDOM;
                ERANGE = linuxDefines.ERANGE;
                EILSEQ = linuxDefines.EILSEQ;
            }
            case DARWIN -> {
                HAVE_ERRNO_H = true;
                EDOM = DarwinDefines.EDOM;
                EILSEQ = DarwinDefines.EILSEQ;
                ERANGE = DarwinDefines.ERANGE;
            }
            case FREE_BSD -> {
                HAVE_ERRNO_H = true;
                EDOM = FreeBsdDefines.EDOM;
                EILSEQ = FreeBsdDefines.EILSEQ;
                ERANGE = FreeBsdDefines.ERANGE;
            }
            case OPEN_BSD -> {
                HAVE_ERRNO_H = true;
                EDOM = OpenBsdDefines.EDOM;
                EILSEQ = OpenBsdDefines.EILSEQ;
                ERANGE = OpenBsdDefines.ERANGE;
            }
            case WINDOWS -> {
                HAVE_ERRNO_H = false;
                EDOM = 0;
                EILSEQ = 0;
                ERANGE = 0;
            }
            default ->
                throw new NoClassDefFoundError("No errno.h defines for " + MultiarchTupelBuilder.getMultiarch());
        }
    }

    /**
     * Read access to {@code errno}.
     *
     * See specs at:
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/errno.h.html">errno.h
     * - system error numbers</a>.
     *
     */
    public final static int errno() {
        return jnhw__errno_location.invoke_MA___V().get(ValueLayout.JAVA_INT, 0);
    }

    /**
     * Write access to {@code errno}.
     *
     * See specs at:
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/errno.h.html">errno.h
     * - system error numbers</a>.
     *
     */
    public final static void errno(int value) {
        jnhw__errno_location.invoke_MA___V().set(ValueLayout.JAVA_INT, 0, value);
    }

    static {
        NativeErrorException.addErrSymbolProvider(de.ibapl.jnhw.posix.Errno::getErrnoSymbol);
    }

    protected Errno() {

    }

}
