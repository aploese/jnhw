/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.common.downcall;

import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh__V__sI;
import java.lang.reflect.Member;
import jdk.incubator.foreign.Addressable;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SymbolLookup;
import jdk.incubator.foreign.ValueLayout;

/**
 *
 * @author aploese
 */
public class JnhwMi__V___I extends JnhwMethodInvoker implements JnhwMh__V__sI {

    private final static FunctionDescriptor FD = FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT);

    public JnhwMi__V___I(SymbolLookup symbolLookup, String name) {
        super(symbolLookup, name, FD);
    }

    public JnhwMi__V___I(Addressable addressable, ResourceScope scope) {
        super(addressable, FD, scope);
    }

    @Override
    public void invoke__V__sI(int arg1) {
        try {
            methodHandle.invokeExact(arg1);
        } catch (NullPointerException npe) {
            throw npe;
        } catch (Throwable t) {
            throw createRuntimeExceptionInvoke(t);
        }
    }

}
