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
package de.ibapl.jnhw.common.downcall.jni;

import de.ibapl.jnhw.common.downcall.JnhwMh_MA__sI;
import de.ibapl.jnhw.common.downcall.JnhwMh_MA__uI;
import java.lang.foreign.MemorySegment;

/**
 *
 * @author aploese
 */
public class JniMi_MA___I extends JniMethodInvoker implements JnhwMh_MA__sI.ExceptionErased, JnhwMh_MA__uI.ExceptionErased {

    protected final static native long invoke_MA___I(long address, int arg1);

    public JniMi_MA___I(MemorySegment methodAddress, String name) {
        super(methodAddress, name);
    }

    @Override
    public MemorySegment invoke_MA__sI(int arg1) {
        try {
            return MemorySegment.ofAddress(
                    invoke_MA___I(
                            ns.address(),
                            arg1),
                     Long.MAX_VALUE);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw e;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

    @Override
    public MemorySegment invoke_MA__uI(int arg1) {
        try {
            return MemorySegment.ofAddress(
                    invoke_MA___I(
                            ns.address(),
                            arg1),
                     Long.MAX_VALUE);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw e;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

}
