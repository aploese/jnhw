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

import de.ibapl.jnhw.common.downcall.JnhwMh_BL___A;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI___A;
import de.ibapl.jnhw.common.downcall.JnhwMh_sL___A;
import de.ibapl.jnhw.common.downcall.JnhwMh_uL___A;
import de.ibapl.jnhw.common.util.ConversionsNative2Java;
import java.lang.foreign.Addressable;
import java.lang.foreign.MemorySegment;

/**
 *
 * @author aploese
 */
public class JniMi__I___A extends JniMethodInvoker implements JnhwMh_sI___A.ExceptionErased, JnhwMh_BL___A.ExceptionErased, JnhwMh_sL___A.ExceptionErased, JnhwMh_uL___A.ExceptionErased {

    protected final static native int invoke__I___A(long address, long arg1);

    public JniMi__I___A(MemorySegment methodAddress, String name) {
        super(methodAddress, name);
    }

    @Override
    public int invoke_sI___A(Addressable arg1) {
        try {
            return invoke__I___A(
                    ns.address().toRawLongValue(),
                    arg1.address().toRawLongValue());
        } catch (IllegalArgumentException | NullPointerException e) {
            throw e;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

    @Override
    public long invoke_sL___A(Addressable arg1) {
        try {
            return invoke__I___A(
                    ns.address().toRawLongValue(),
                    arg1.address().toRawLongValue());
        } catch (IllegalArgumentException | NullPointerException e) {
            throw e;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

    @Override
    public boolean invoke_BL___A(Addressable arg1) {
        try {
            return ConversionsNative2Java.int32_t_TO_boolean(
                    invoke__I___A(
                            ns.address().toRawLongValue(),
                            arg1.address().toRawLongValue()));
        } catch (IllegalArgumentException | NullPointerException e) {
            throw e;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

    @Override
    public long invoke_uL___A(Addressable arg1) {
        try {
            return ConversionsNative2Java.uint32_t_TO_long(
                    invoke__I___A(
                            ns.address().toRawLongValue(),
                            arg1.address().toRawLongValue()));
        } catch (IllegalArgumentException | NullPointerException e) {
            throw e;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

}
