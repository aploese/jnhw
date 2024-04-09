/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2023-2024, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.downcall.JnhwMh_MA___A;
import java.lang.foreign.MemorySegment;

/**
 *
 * @author aploese
 */
public class JniMi_MA___A extends JniMethodInvoker implements JnhwMh_MA___A.ExceptionErased {

    protected final static native long invoke_MA___A(long address, long arg1);

    private final long targetByteSize;

    public JniMi_MA___A(MemorySegment methodAddress, String name, long targetByteSize) {
        super(methodAddress, name);
        this.targetByteSize = targetByteSize;
    }

    @Override
    public MemorySegment invoke_MA___A(MemorySegment arg1) {
        try {
            if (targetByteSize == 0) {
                return MemorySegment.ofAddress(
                        invoke_MA___A(
                                ns.address(),
                                arg1.address()));
            } else {
                return MemorySegment.ofAddress(
                        invoke_MA___A(
                                ns.address(),
                                arg1.address())).reinterpret(targetByteSize);
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw e;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }
}
