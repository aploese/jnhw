/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.datatypes.MultiarchTupelBuilder;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.util.posix.PosixDataType;
import jdk.incubator.foreign.MemoryAddress;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh__A__sI__A;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_MA__sI;

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

    public final static boolean HAVE_STRING_H;

    /**
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        switch (MultiarchTupelBuilder.getOS()) {
            case DARWIN:
            case FREE_BSD:
            case OPEN_BSD:
            case LINUX:
                HAVE_STRING_H = true;
                break;
            case WINDOWS:
                HAVE_STRING_H = false;
                break;
            default:
                throw new NoClassDefFoundError("No string.h defines for " + MultiarchTupelBuilder.getMultiarch());
        }
    }
    private final static JnhwMh_MA__sI strerror = JnhwMh_MA__sI.of(
            "strerror",
            BaseDataType.C_char_pointer,
            BaseDataType.C_int);

    private final static JnhwMh__A__sI__A strerror_l = JnhwMh__A__sI__A.ofOrNull(
            "strerror_l",
            BaseDataType.C_char_pointer,
            BaseDataType.C_int,
            PosixDataType.locale_t);

    private final static JnhwMh_MA__sI strsignal = JnhwMh_MA__sI.of(
            "strsignal",
            BaseDataType.C_char_pointer,
            BaseDataType.C_int);

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/strerror_l.html">strerror,
     * strerror_l, strerror_r - get error message string</a>.
     */
    public final static String strerror(int errnum) throws NativeErrorException {
        final MemoryAddress result = strerror.invoke_MA__sI(errnum);
        if (result == MemoryAddress.NULL) {
            throw new NativeErrorException(Errno.errno());
        }
        return result.getUtf8String(0);
    }

    /**
     * <b>POSIX.CX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/strerror_l.html">strerror,
     * strerror_l, strerror_r - get error message string</a>.
     *
     * @throws NoSuchNativeMethodException if the method strerror_l is not
     * available natively.
     */
    public final static String strerror_l(int errnum, Locale.Locale_t locale) throws NoSuchNativeMethodException, NativeErrorException {
        try {
            final MemoryAddress result = strerror_l.invoke_MA__sI_P(errnum, locale);
            if (result == MemoryAddress.NULL) {
                throw new NativeErrorException(Errno.errno());
            }
            return result.getUtf8String(0);
        } catch (NullPointerException npe) {
            if (strerror_l == null) {
                throw new NoSuchNativeMethodException("strerror_l");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>POSIX.CX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/strerror_l.html">strsignal
     * - get name of signal</a>.
     */
    public final static String strsignal(int signum) {
        final MemoryAddress result = strsignal.invoke_MA__sI(signum);
        if (result == MemoryAddress.NULL) {
            return null;
        }
        return result.getUtf8String(0);
    }

}
