/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2023-2025, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.common.downcall;

import de.ibapl.jnhw.libloader.MemoryModel;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 */
public class Util {

    public final static Logger LOG = Logger.getLogger("d.i.j.c.downcall");
    public final static MemoryModel MEMORY_MODEL = MultiarchTupelBuilder.getMemoryModel();

    public static <T> T buidExistingMethod(SymbolLookup symbolLookup, String name, Function<MemorySegment, T> onSuccess) {
        final MemorySegment ms = symbolLookup.findOrThrow(name);
        return onSuccess.apply(ms);
    }

    public static <T> T buidOptionalMethod(SymbolLookup symbolLookup, String name, Function<MemorySegment, T> onSuccess, Supplier<T> onFailure) {
        final Optional<MemorySegment> oms = symbolLookup.find(name);
        if (oms.isEmpty()) {
            return onFailure.get();
        } else {
            return onSuccess.apply(oms.get());
        }
    }

}
