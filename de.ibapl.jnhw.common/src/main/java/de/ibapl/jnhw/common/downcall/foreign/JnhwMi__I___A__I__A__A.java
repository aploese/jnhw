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

import de.ibapl.jnhw.common.downcall.JnhwMh_sI___A_sI__A__A;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI___A_uL__A__A;
import de.ibapl.jnhw.common.util.ConversionsJava2Native;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

/**
 *
 * @author aploese
 */
public class JnhwMi__I___A__I__A__A extends JnhwMethodInvoker implements JnhwMh_sI___A_sI__A__A.ExceptionErased, JnhwMh_sI___A_uL__A__A.ExceptionErased {

    public JnhwMi__I___A__I__A__A(MemorySegment methodAddress, String name) {
        super(methodAddress, name, FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
    }

    @Override
    public int invoke_sI___A_sI__A__A(MemorySegment arg1, int arg2, MemorySegment arg3, MemorySegment arg4) {
        try {
            return (int) methodHandle.invokeExact(
                    arg1,
                    arg2,
                    arg3,
                    arg4);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw e;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

    @Override
    public int invoke_sI___A_uL__A__A(MemorySegment arg1, long arg2, MemorySegment arg3, MemorySegment arg4) {
        try {
            return (int) methodHandle.invokeExact(
                    arg1,
                    ConversionsJava2Native.long_TO_uint32_t(arg2),
                    arg3,
                    arg4);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw e;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

}
