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
import java.lang.foreign.Addressable;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh__A__sI__A__A;

/**
 *
 * @author aploese
 */
public class JnhwMi_MA___I__A__A extends JnhwMethodInvoker implements JnhwMh__A__sI__A__A {

    public JnhwMi_MA___I__A__A(SymbolLookup symbolLookup, String name) {
        super(symbolLookup, name, FunctionDescriptor.of(ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
    }

    @Override
    public MemoryAddress invoke_MA__sI_P_P(int arg1, Pointer<?> arg2, Pointer<?> arg3) {
        try {
            return (MemoryAddress) methodHandle.invokeExact(arg1, arg2.toAddressable(), arg3.toAddressable());
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

    @Override
    public MemoryAddress invoke_MA__sI_A_P(int arg1, Addressable arg2, Pointer<?> arg3) {
        try {
            return (MemoryAddress) methodHandle.invokeExact(arg1, arg2, arg3.toAddressable());
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

}
