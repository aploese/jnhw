/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.NoSuchNativeMethodException;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;

/**
 * Wrapper around the {@code <string.h>} header.
 *
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/string.h.html">string.h
 * - string operations</a>.
 *
 * @author aploese
 */
@Include("#include <string.h>")
public class StringHeader {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    public final static native boolean HAVE_STRING_H();

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/strerror_l.html">strerror,
     * strerror_l, strerror_r - get error message string</a>.
     */
    public final static native String strerror(int errnum);

    /**
     * <b>POSIX.CX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/strerror_l.html">strerror,
     * strerror_l, strerror_r - get error message string</a>.
     *
     * @throws NoSuchNativeMethodException if the method strerror_l is not available natively.
     */
    public final static native String strerror_l(int errnum, Locale.Locale_t locale) throws NoSuchNativeMethodException;

    /**
     * <b>POSIX.CX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/strerror_l.html">strsignal
     * - get name of signal</a>.
     */
    public final static native String strsignal(int signum);

}
