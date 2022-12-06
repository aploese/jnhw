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
package de.ibapl.jnhw.common.downcall;

import de.ibapl.jnhw.common.datatypes.Pointer;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_MA___A__A;

/**
 *
 * @author aploese
 */
public class JnhwMi_MA___A__A extends JnhwMethodInvoker implements JnhwMh_MA___A__A {

    public JnhwMi_MA___A__A(SymbolLookup symbolLookup, String name) {
        super(symbolLookup, name, FunctionDescriptor.of(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
    }

    @Override
    public MemoryAddress invoke_MA___P__P(Pointer<?> arg1, Pointer<?> arg2) {
        try {
            return (MemoryAddress) methodHandle.invokeExact(arg1.toAddressable(), arg2.toAddressable());
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

}
