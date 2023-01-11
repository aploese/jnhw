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

import de.ibapl.jnhw.common.downcall.JnhwMh__D__sL_sL;
import de.ibapl.jnhw.common.util.ConversionsJava2Native;
import java.lang.foreign.SymbolLookup;

/**
 *
 * @author aploese
 */
public class JniMi__D___I__I extends JniMethodInvoker implements JnhwMh__D__sL_sL {

    protected final static native double invoke__D___I__I(long address, int arg1, int arg2);

    public JniMi__D___I__I(SymbolLookup symbolLookup, String name) {
        super(symbolLookup, name);
    }

    @Override
    public double invoke__D__sL_sL(long arg1, long arg2) {
        try {
            return invoke__D___I__I(
                    ns.address().toRawLongValue(),
                    ConversionsJava2Native.long_TO_int32_t(arg1),
                    ConversionsJava2Native.long_TO_int32_t(arg2));
        } catch (IllegalArgumentException | NullPointerException e) {
            throw e;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

}
