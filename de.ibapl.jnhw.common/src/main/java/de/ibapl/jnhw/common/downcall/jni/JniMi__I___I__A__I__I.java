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

import de.ibapl.jnhw.common.downcall.JnhwMh_uI__uI__A_BL_uI;
import de.ibapl.jnhw.common.downcall.JnhwMh_uI__uI__A_uI_uI;
import de.ibapl.jnhw.common.util.ConversionsJava2Native;
import de.ibapl.jnhw.common.util.ConversionsNative2Java;
import java.lang.foreign.MemorySegment;

/**
 *
 * @author aploese
 */
public class JniMi__I___I__A__I__I extends JniMethodInvoker implements JnhwMh_uI__uI__A_uI_uI.ExceptionErased, JnhwMh_uI__uI__A_BL_uI.ExceptionErased {

    protected final static native int invoke__I___I__A__I__I(long address, int arg1, long arg2, int arg3, int arg4);

    public JniMi__I___I__A__I__I(MemorySegment methodAddress, String name) {
        super(methodAddress, name);
    }

    @Override
    public int invoke_uI__uI__A_uI_uI(int arg1, MemorySegment arg2, int arg3, int arg4) {
        try {
            return invoke__I___I__A__I__I(
                    ns.address(),
                    arg1,
                    arg2.address(),
                    arg3,
                    arg4);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw e;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

    @Override
    public long invoke_uL__uI__A_BL_uI(int arg1, MemorySegment arg2, boolean arg3, int arg4) {
        try {
            return ConversionsNative2Java.uint32_t_TO_long(
                    invoke__I___I__A__I__I(
                            ns.address(),
                            arg1,
                            arg2.address(),
                            ConversionsJava2Native.boolean_TO_int32_t(arg3),
                            arg4));
        } catch (IllegalArgumentException | NullPointerException e) {
            throw e;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

}
