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
package de.ibapl.jnhw.common.downcall.foreign;

import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI_sI__A;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI_uL__A;
import de.ibapl.jnhw.common.util.ConversionsJava2Native;
import java.lang.foreign.Addressable;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;

/**
 *
 * @author aploese
 */
public class JnhwMi__I___I__I__A extends JnhwMethodInvoker implements JnhwMh_sI__sI_sI__A, JnhwMh_sI__sI_uL__A {

    public JnhwMi__I___I__I__A(SymbolLookup symbolLookup, String name) {
        super(symbolLookup, name, FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    }

    private int invoke__I___I__I__A(int arg1, int arg2, Addressable arg3) {
        try {
            return (int) methodHandle.invokeExact(arg1, arg2, arg3);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw e;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

    @Override
    public final int invoke_sI__sI_sI__A(int arg1, int arg2, Addressable arg3) {
        return invoke__I___I__I__A(arg1, arg2, arg3);
    }

    public final int invoke_sI__uI_sI__A(int arg1, int arg2, Addressable arg3) {
        return invoke__I___I__I__A(arg1, arg2, arg3);
    }

    @Override
    public final int invoke_sI__sI_uL__A(int arg1, long arg2, Addressable arg3) {
        return invoke__I___I__I__A(
                arg1,
                ConversionsJava2Native.long_TO_uint32_t(arg2),
                arg3);
    }

}
