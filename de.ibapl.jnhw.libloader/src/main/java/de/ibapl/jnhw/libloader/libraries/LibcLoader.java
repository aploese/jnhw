/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2023-2024, Arne Plöse and individual contributors as indicated
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
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.util.Optional;

/**
 *
 * @author aploese
 */
public final class LibcLoader {

    public final static SymbolLookup LIB_C_SYMBOL_LOOKUP;
    private final static Arena LIB_C_MEMORY_ARENA = Arena.ofShared();

    static {
        LIB_C_SYMBOL_LOOKUP = switch (MultiarchTupelBuilder.getOS()) {
            case APPLE -> //TODO Quick and dirty ... Symbol
                SymbolLookup.libraryLookup("libc.dylib", LIB_C_MEMORY_ARENA);
            case FREE_BSD -> //TODO Quick and dirty ... Symbol
                SymbolLookup.libraryLookup("libc.so.7", LIB_C_MEMORY_ARENA);
            case LINUX -> //TODO Quick and dirty ... Symbol
                SymbolLookup.libraryLookup("libc.so.6", LIB_C_MEMORY_ARENA);
            default ->
                throw new AssertionError("No idea where to find the libc");
        };
    }

//TODO unboundedAddress?
    /**
     *
     * @param name
     * @param byteSize
     * @return
     */
    public final static Optional<MemorySegment> find(String name, long byteSize) {
        Optional<MemorySegment> _result = LIB_C_SYMBOL_LOOKUP.find(name);
        if (_result.isPresent()) {
            return Optional.of(_result.get().reinterpret(byteSize));
        } else {
            return _result;
        }
    }

    public final static Arena arena() {
        return LIB_C_MEMORY_ARENA;
    }
}
