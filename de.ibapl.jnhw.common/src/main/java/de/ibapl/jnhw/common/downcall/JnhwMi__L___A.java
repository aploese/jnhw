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
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sL___A;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_uL___A;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;

/**
 *
 * @author aploese
 */
public class JnhwMi__L___A extends JnhwMethodInvoker implements JnhwMh_sL___A, JnhwMh_uL___A {

    public JnhwMi__L___A(SymbolLookup symbolLookup, String name) {
        super(symbolLookup, name, FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS));
    }

    @Override
    public long invoke_uL___P(Pointer<?> arg1) {
        try {
            return (long) methodHandle.invokeExact(arg1.toAddressable());
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

    @Override
    public long invoke_sL___P(Pointer<?> arg1) {
        try {
            return (long) methodHandle.invokeExact(arg1.toAddressable());
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

}
