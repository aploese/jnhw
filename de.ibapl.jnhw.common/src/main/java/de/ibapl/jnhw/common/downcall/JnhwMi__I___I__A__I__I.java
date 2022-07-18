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
import jdk.incubator.foreign.FunctionDescriptor;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI__sI__A_sI_uI;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_uI__uI__A_uI_uI;
import de.ibapl.jnhw.common.util.ConversionsJava2Native;
import de.ibapl.jnhw.common.util.ConversionsNative2Java;
import jdk.incubator.foreign.Addressable;
import jdk.incubator.foreign.MemorySegment;

/**
 *
 * @author aploese
 */
public class JnhwMi__I___I__A__I__I extends JnhwMethodInvoker implements JnhwMh_sI__sI__A_sI_uI, JnhwMh_uI__uI__A_uI_uI {

    public JnhwMi__I___I__A__I__I(SymbolLookup symbolLookup, String name) {
        super(symbolLookup, name, FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    }

    @Override
    public int invoke_sI__sI__P_sI_uI(int arg1, Pointer<?> arg2, int arg3, int arg4) {
        try {
            return (int) methodHandle.invokeExact(arg1, arg2.toAddressable(), arg3, arg4);
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

    @Override
    public int invoke_sI__sI__A_sI_uI(int arg1, Addressable arg2, int arg3, int arg4) {
        try {
            return (int) methodHandle.invokeExact(arg1, arg2, arg3, arg4);
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

    @Override
    public int invoke_uI__uI__P_uI_uI(int arg1, Pointer<?> arg2, int arg3, int arg4) {
        try {
            return (int) methodHandle.invokeExact(arg1, arg2.toAddressable(), arg3, arg4);
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

    @Override
    public long invoke_uL__uI__P__B_uL(int arg1, Pointer<?> arg2, boolean arg3, long arg4) {
        try {
            return ConversionsNative2Java.uint32_t_TO_long(
                    (int) methodHandle.invokeExact(
                            arg1,
                            arg2.toAddressable(),
                            ConversionsJava2Native.boolean_TO_int32_t(arg3),
                            ConversionsJava2Native.long_TO_uint32_t(arg4)));
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

}
