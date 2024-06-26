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
package de.ibapl.jnhw.util.posix.upcall;

import de.ibapl.jnhw.common.datatypes.Pointer;
import de.ibapl.jnhw.common.upcall.Callback__V__Union_I_MA;
import java.lang.foreign.MemorySegment;
import java.util.function.Function;

/**
 *
 * @author aploese
 * @param <A>
 */
public abstract class Callback__V__UnionSigval<A extends Pointer> extends Callback__V__Union_I_MA<A> {

    protected <T extends Callback__V__UnionSigval<A>> Callback__V__UnionSigval(Function<T, MemorySegment> producer) {
        super(producer);
    }

    protected Callback__V__UnionSigval(MemorySegment address) {
        super(address);
    }

    public Callback__V__UnionSigval() {
        super();
    }

}
