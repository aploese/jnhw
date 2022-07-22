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
import jdk.incubator.foreign.SymbolLookup;
import jdk.incubator.foreign.ValueLayout;
import de.ibapl.jnhw.common.util.ConversionsJava2Native;
import de.ibapl.jnhw.common.util.ConversionsNative2Java;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.Addressable;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI__A_sI_uI;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_uI___A_uI__B;

/**
 *
 * @author aploese
 */
public class JnhwMi__I___A__I__I extends JnhwMethodInvoker implements JnhwMh_sI__A_sI_uI, JnhwMh_uI___A_uI__B {

    public JnhwMi__I___A__I__I(SymbolLookup symbolLookup, String name) {
        super(symbolLookup, name, FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    }

    @Override
    public int invoke_sI__P_sI_uI(Pointer<?> arg1, int arg2, int arg3) {
        try {
            return (int) methodHandle.invokeExact(arg1.toAddressable(), arg2, arg3);
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

    @Override
    public int invoke_sI__A_sI_uI(Addressable arg1, int arg2, int arg3) {
        try {
            return (int) methodHandle.invokeExact(arg1, arg2, arg3);
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

    @Override
    public int invoke_uI__P_uI_B(Pointer<?> arg1, int arg2, boolean arg3) {
        try {
            return (int) methodHandle.invokeExact(
                    arg1.toAddressable(),
                    arg2,
                    ConversionsJava2Native.boolean_TO_int32_t(arg3));
        } catch (NullPointerException | IllegalArgumentException ex) {
            throw ex;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

}
