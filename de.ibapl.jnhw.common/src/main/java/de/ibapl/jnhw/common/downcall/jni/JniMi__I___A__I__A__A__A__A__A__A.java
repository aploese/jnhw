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

import de.ibapl.jnhw.common.downcall.JnhwMh_sI___A_uI__A__A__A__A__A__A;
import java.lang.foreign.Addressable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;

/**
 *
 * @author aploese
 */
public class JniMi__I___A__I__A__A__A__A__A__A extends JniMethodInvoker implements JnhwMh_sI___A_uI__A__A__A__A__A__A.ExceptionErased {

    protected final static native int invoke__I___A__I__A__A__A__A__A__A(long address, long arg1, int arg2, long arg3, long arg4, long arg5, long arg6, long arg7, long arg8);

    public JniMi__I___A__I__A__A__A__A__A__A(MemorySegment methodAddress, String name) {
        super(methodAddress, name);
    }

    @Override
    public int invoke_sI___A_uI__A__A__A__A__A__A(Addressable arg1, int arg2, Addressable arg3, Addressable arg4, Addressable arg5, Addressable arg6, Addressable arg7, Addressable arg8) {
        try {
            return invoke__I___A__I__A__A__A__A__A__A(
                    ns.address().toRawLongValue(),
                    arg1.address().toRawLongValue(),
                    arg2,
                    arg3.address().toRawLongValue(),
                    arg4.address().toRawLongValue(),
                    arg5.address().toRawLongValue(),
                    arg6.address().toRawLongValue(),
                    arg7.address().toRawLongValue(),
                    arg8.address().toRawLongValue());
        } catch (IllegalArgumentException | NullPointerException e) {
            throw e;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

}
