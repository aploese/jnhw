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

import de.ibapl.jnhw.common.downcall.JnhwMh_sL__sI__A_uL;
import java.lang.foreign.Addressable;
import java.lang.foreign.MemorySegment;

/**
 *
 * @author aploese
 */
public class JniMi__L___I__A__L extends JniMethodInvoker implements JnhwMh_sL__sI__A_uL.ExceptionErased {

    protected final static native long invoke__L___I__A__L(long address, int arg1, long arg2, long arg3);

    public JniMi__L___I__A__L(MemorySegment methodAddress, String name) {
        super(methodAddress, name);
    }

    @Override
    public long invoke_sL__sI__A_uL(int arg1, Addressable arg2, long arg3) {
        try {
            return invoke__L___I__A__L(
                    ns.address().toRawLongValue(),
                    arg1,
                    arg2.address().toRawLongValue(),
                    arg3);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw e;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

}
