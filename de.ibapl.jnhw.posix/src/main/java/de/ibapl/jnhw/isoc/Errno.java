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
package de.ibapl.jnhw.isoc;

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;

/**
 * Wrapper around the {@code<errno.h>} header.
 * @see(module-info) for markers
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/errno.h.html">errno.h
 * - system error numbers</a>.
 *
 * @author aploese
 */
@Include("#include <errno.h>")
public abstract class Errno {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    protected Errno() {

    }

    public final static native boolean HAVE_ERRNO_H();

    /**
     * ISOC,POSIX: Mathematics argument out of domain of function.
     *
     * @return the native symbolic constant of EDOM.
     */
    @Define
    public final static native int EDOM();

    /**
     * ISOC,POSIX: Illegal byte sequence.
     *
     * @return the native symbolic constant of EILSEQ,
     */
    @Define
    public final static native int EILSEQ();

    /**
     * ISOC,POSIX: Result too large.
     *
     * @return the native symbolic constant of ERANGE.
     */
    @Define
    public final static native int ERANGE();

    /**
     * Read access to <code>errno</code>.
     *
     * See specs at:
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/errno.h.html">errno.h
     * - system error numbers</a>.
     *
     * @author aploese
     */
    public final static native int errno();

    /**
     * Write access to <code>errno</code>.
     *
     * See specs at:
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/errno.h.html">errno.h
     * - system error numbers</a>.
     *
     * @author aploese
     */
    public final static native void errno(int value);

}
