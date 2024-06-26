/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2021-2024, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.common.exception;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.function.IntFunction;

/**
 * This exceptions is thrown if the jni native code detects an error. The error
 * number POSIX|ISO C call errno and Windows API call GetLastError() will be
 * stored in errno. The value of errno is valid only if a called function sets
 * the errno and flags the occurence of an error. Once the call returns to the
 * JVM the value of errno is uncertain, so this must be handled immediately
 * after the call to that function.
 *
 * @author aploese
 */
public class NativeErrorException extends NativeException {

    private static List<IntFunction<String>> ERRNO_SYMBOL_PROVIDERS = new LinkedList<>();

    private final static HashMap<Integer, String> ERRNO_SYMBOL_MAP = new HashMap<>();

    private final static String formatDefaultMessage(final int errno) {
        String symbol = ERRNO_SYMBOL_MAP.get(errno);
        if (symbol == null) {
            for (IntFunction<String> provider : ERRNO_SYMBOL_PROVIDERS) {
                symbol = provider.apply(errno);
                if (symbol != null) {
                    ERRNO_SYMBOL_MAP.put(errno, symbol);
                    break;
                }
            }
            if (symbol == null) {
                symbol = String.valueOf(errno);
                ERRNO_SYMBOL_MAP.put(errno, symbol);
            }
        }
        return "Native error: " + symbol;
    }

    /**
     *
     */
    private static final long serialVersionUID = 4007403267388096526L;
    public final int errno;

    public NativeErrorException(final int errno) {
        super(formatDefaultMessage(errno));
        this.errno = errno;
    }

    public NativeErrorException(int errno, String msg) {
        super(msg);
        this.errno = errno;
    }

    public static void addErrSymbolProvider(IntFunction<String> provider) {
        ERRNO_SYMBOL_PROVIDERS.add(provider);
    }

}
