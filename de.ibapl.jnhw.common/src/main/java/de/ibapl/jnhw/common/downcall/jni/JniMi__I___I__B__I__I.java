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

import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI_sB_sI_sI;
import java.lang.foreign.MemorySegment;

/**
 *
 * @author aploese
 */
public class JniMi__I___I__B__I__I extends JniMethodInvoker implements JnhwMh_sI__sI_sB_sI_sI.ExceptionErased {

    protected final static native int invoke__I___I__B__I__I(long address, int arg1, byte arg2, int arg3, int arg4);

    public JniMi__I___I__B__I__I(MemorySegment methodAddress, String name) {
        super(methodAddress, name);
    }

    @Override
    public int invoke_sI__sI_sB_sI_sI(int arg1, byte arg2, int arg3, int arg4) {
        try {
            return invoke__I___I__B__I__I(
                    ns.address(),
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

}
