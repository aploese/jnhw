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

import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
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
            case FREE_BSD:
            case OPEN_BSD:
                HAVE_STRING_H = true;
                break;
            case WINDOWS:
                HAVE_STRING_H = false;
                break;
            default:
                throw new NoClassDefFoundError("No string.h defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
        }
    }

    public final static boolean HAVE_STRING_H;

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
     * @throws NoSuchNativeMethodException if the method strerror_l is not
     * available natively.
     */
    public final static String strerror_l(int errnum, Locale.Locale_t locale) throws NoSuchNativeMethodException {
        return strerror_l(errnum, Locale.Locale_t.getNativeValue(locale));
    }

    private static native String strerror_l(int errnum, long nativeLocale) throws NoSuchNativeMethodException;

    /**
     * <b>POSIX.CX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/strerror_l.html">strsignal
     * - get name of signal</a>.
     */
    public final static native String strsignal(int signum);

}
