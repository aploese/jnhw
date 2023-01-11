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

import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI__A__A;
import java.lang.foreign.Addressable;
import java.lang.foreign.SymbolLookup;

/**
 *
 * @author aploese
 */
public class JniMi__I___I__A__A extends JniMethodInvoker implements JnhwMh_sI__sI__A__A {

    protected final static native int invoke__I___I__A__A(long address, int arg1, long arg2, long arg3);

    public JniMi__I___I__A__A(SymbolLookup symbolLookup, String name) {
        super(symbolLookup, name);
    }

    @Override
    public int invoke_sI__sI__A__A(int arg1, Addressable arg2, Addressable arg3) {
        try {
            return invoke__I___I__A__A(
                    ns.address().toRawLongValue(),
                    arg1,
                    arg2.address().toRawLongValue(),
                    arg3.address().toRawLongValue());
        } catch (IllegalArgumentException | NullPointerException e) {
            throw e;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

}