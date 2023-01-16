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
package de.ibapl.jnhw.libloader.librarys;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SymbolLookup;
import java.util.Optional;

/**
 *
 * @author aploese
 */
public class LibrtLoader {

    public final static SymbolLookup LIB_RT_SYMBOL_LOOKUP;
    private final static MemorySession LIB_RT_MEMORY_SESSION = MemorySession.openShared();

    static {
        //TODO Quick and dirty ...
//        LIB_RT_SYMBOL_LOOKUP = SymbolLookup.libraryLookup(Path.of("/lib/x86_64-linux-gnu/librt.so.1"), MemorySession.global());
        LIB_RT_SYMBOL_LOOKUP = SymbolLookup.libraryLookup("librt.so.1", LIB_RT_MEMORY_SESSION);
//TODO  does not work anymore       LIB_RT_SYMBOL_LOOKUP = SymbolLookup.libraryLookup("rt", MemorySession.global());
    }

    public static Optional<MemorySegment> lookup(String name) {
        return LIB_RT_SYMBOL_LOOKUP.lookup(name);
    }

}
