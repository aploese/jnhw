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

import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI__sI_sI;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI__sI_uL;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI__uI_sI;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI__uI_uI;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_uI__uI_sI;
import de.ibapl.jnhw.common.util.ConversionsJava2Native;
import de.ibapl.jnhw.common.util.ConversionsNative2Java;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.SymbolLookup;
import jdk.incubator.foreign.ValueLayout;

/**
 *
 * @author aploese
 */
public class JnhwMi__I___I__I extends JnhwMethodInvoker implements JnhwMh_uI__uI_sI, JnhwMh_sI__sI_uL, JnhwMh_sI__sI_sI, JnhwMh_sI__uI_sI, JnhwMh_sI__uI_uI {

    public JnhwMi__I___I__I(SymbolLookup symbolLookup, String name) {
        super(symbolLookup, name, FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    }

    @Override
    public int invoke_uI__uI_sI(int arg1, int arg2) {
        try {
            return (int) methodHandle.invokeExact(arg1, arg2);
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

    @Override
    public long invoke_uL__uI__B(int arg1, boolean arg2) {
        try {
            return ConversionsNative2Java.uint32_t_TO_long(
                    (int) methodHandle.invokeExact(
                            arg1,
                            ConversionsJava2Native.boolean_TO_int32_t(arg2)));
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

    @Override
    public int invoke_sI__sI_uL(int arg1, long arg2) {
        try {
            return (int) methodHandle.invokeExact(arg1, ConversionsJava2Native.long_TO_uint32_t(arg2));
        } catch (IllegalArgumentException iae) {
            throw iae;
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

    @Override
    public int invoke_sI__sI_sI(int arg1, int arg2) {
        try {
            return (int) methodHandle.invokeExact(arg1, arg2);
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

    @Override
    public int invoke_sI__uI_sI(int arg1, int arg2) {
        try {
            return (int) methodHandle.invokeExact(arg1, arg2);
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

    @Override
    public int invoke_sI__uI_uI(int arg1, int arg2) {
        try {
            return (int) methodHandle.invokeExact(arg1, arg2);
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

}
