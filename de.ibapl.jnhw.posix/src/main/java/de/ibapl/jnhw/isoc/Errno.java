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
package de.ibapl.jnhw.isoc;

import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.libloader.MultiarchInfo;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;

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

    public static interface Linux_Mips_Defines {

        public final static int EILSEQ = 88;
    }

    public static interface Linux_NonMips_Defines {

        public final static int EILSEQ = 84;

    }

    public static interface LinuxDefines {

        public final static int EDOM = 33;
        public final static int ERANGE = 34;
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
        LibJnhwPosixLoader.touch();
        final MultiarchInfo multiarchInfo = LibJnhwPosixLoader.getLoadResult().multiarchInfo;
        switch (multiarchInfo.getOS()) {
            case LINUX:
                HAVE_ERRNO_H = true;
                EDOM = LinuxDefines.EDOM;
                ERANGE = LinuxDefines.ERANGE;
                switch (multiarchInfo.getArch()) {
                    case MIPS:
                    case MIPS_64:
                        EILSEQ = Linux_Mips_Defines.EILSEQ;
                        break;
                    default:
                        EILSEQ = Linux_NonMips_Defines.EILSEQ;
                }
                break;
            case DARWIN:
                HAVE_ERRNO_H = true;
                EDOM = DarwinDefines.EDOM;
                EILSEQ = DarwinDefines.EILSEQ;
                ERANGE = DarwinDefines.ERANGE;
                break;
            case FREE_BSD:
                HAVE_ERRNO_H = true;
                EDOM = FreeBsdDefines.EDOM;
                EILSEQ = FreeBsdDefines.EILSEQ;
                ERANGE = FreeBsdDefines.ERANGE;
                break;
            case OPEN_BSD:
                HAVE_ERRNO_H = true;
                EDOM = OpenBsdDefines.EDOM;
                EILSEQ = OpenBsdDefines.EILSEQ;
                ERANGE = OpenBsdDefines.ERANGE;
                break;
            case WINDOWS:
                HAVE_ERRNO_H = false;
                EDOM = 0;
                EILSEQ = 0;
                ERANGE = 0;
                break;
            default:
                throw new NoClassDefFoundError("No fcntl.h defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
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
    public final static native int errno();

    /**
     * Write access to {@code errno}.
     *
     * See specs at:
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/errno.h.html">errno.h
     * - system error numbers</a>.
     *
     */
    public final static native void errno(int value);

    protected Errno() {

    }

}
