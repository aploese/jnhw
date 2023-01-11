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

import de.ibapl.jnhw.common.downcall.JnhwMh_sI___A_sI_uI;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI___A_uL_sI;
import de.ibapl.jnhw.common.downcall.JnhwMh_uI___A_uI_BL;
import de.ibapl.jnhw.common.util.ConversionsJava2Native;
import java.lang.foreign.Addressable;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;

/**
 *
 * @author aploese
 */
public class JnhwMi__I___A__I__I extends JnhwMethodInvoker implements JnhwMh_sI___A_sI_uI, JnhwMh_uI___A_uI_BL, JnhwMh_sI___A_uL_sI {

    public JnhwMi__I___A__I__I(SymbolLookup symbolLookup, String name) {
        super(symbolLookup, name, FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    }

    @Override
    public int invoke_sI___A_sI_uI(Addressable arg1, int arg2, int arg3) {
        try {
            return (int) methodHandle.invokeExact(arg1, arg2, arg3);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw e;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

    @Override
    public int invoke_uI___A_uI_BL(Addressable arg1, int arg2, boolean arg3) {
        try {
            return (int) methodHandle.invokeExact(
                    arg1,
                    arg2,
                    ConversionsJava2Native.boolean_TO_int32_t(arg3));
        } catch (NullPointerException | IllegalArgumentException ex) {
            throw ex;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

    @Override
    public int invoke_sI___A_uL_sI(Addressable arg1, long arg2, int arg3) {
        try {
            return (int) methodHandle.invokeExact(
                    arg1,
                    ConversionsJava2Native.long_TO_uint32_t(arg2),
                    arg3);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw e;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

}
