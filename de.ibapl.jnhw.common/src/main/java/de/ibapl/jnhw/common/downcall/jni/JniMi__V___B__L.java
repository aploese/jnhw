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

import de.ibapl.jnhw.common.downcall.JnhwMh__V__BL_sL;
import de.ibapl.jnhw.common.util.ConversionsJava2Native;
import java.lang.foreign.SymbolLookup;

/**
 *
 * @author aploese
 */
public class JniMi__V___B__L extends JniMethodInvoker implements JnhwMh__V__BL_sL {

    protected final static native void invoke__V___B__L(long address, byte arg1, long arg2);

    public JniMi__V___B__L(SymbolLookup symbolLookup, String name) {
        super(symbolLookup, name);
    }

    @Override
    public void invoke__V__BL_sL(boolean arg1, long arg2) {
        try {
            invoke__V___B__L(
                    ns.address().toRawLongValue(),
                    ConversionsJava2Native.boolean_TO_int8_t(arg1),
                    arg2);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw e;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

}
