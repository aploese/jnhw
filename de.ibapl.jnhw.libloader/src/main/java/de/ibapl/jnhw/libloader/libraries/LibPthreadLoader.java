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
package de.ibapl.jnhw.libloader.libraries;

import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SymbolLookup;
import java.util.Optional;

/**
 *
 * @author aploese
 */
public class LibPthreadLoader {

    public final static SymbolLookup LIB_PTHREAD_SYMBOL_LOOKUP;
    private final static MemorySession LIB_PTHREAD_MEMORY_SESSION = MemorySession.openShared();

    static {
        LIB_PTHREAD_SYMBOL_LOOKUP = switch (MultiarchTupelBuilder.getOS()) {
            case LINUX -> //TODO Quick and dirty ... Symbol
                throw new AssertionError("Linux has no lib pthread! its in libc");
            case DARWIN -> //TODO Quick and dirty ... Symbol
                SymbolLookup.libraryLookup("libpthread.dylib", LIB_PTHREAD_MEMORY_SESSION);
            case FREE_BSD -> //TODO Quick and dirty ... Symbol
                SymbolLookup.libraryLookup("libpthread.so", LIB_PTHREAD_MEMORY_SESSION);
            default ->
                throw new AssertionError("No idea where to find the libpthread");
        };
    }

    public static Optional<MemorySegment> lookup(String name) {
        return LIB_PTHREAD_SYMBOL_LOOKUP.lookup(name);
    }
}
