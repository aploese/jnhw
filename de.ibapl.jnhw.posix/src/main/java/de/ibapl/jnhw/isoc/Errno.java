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
        EDOM = 0;
        EILSEQ = 0;
        ERANGE = 0;
        HAVE_ERRNO_H = false;
        initFields();
    }

    private static native void initFields();

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
