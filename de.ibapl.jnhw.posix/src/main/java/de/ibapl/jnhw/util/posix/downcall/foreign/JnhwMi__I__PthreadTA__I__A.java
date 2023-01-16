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
package de.ibapl.jnhw.util.posix.downcall.foreign;

import de.ibapl.jnhw.common.downcall.foreign.JnhwMi__I___A__I__A;
import de.ibapl.jnhw.posix.Pthread;
import de.ibapl.jnhw.util.posix.downcall.JnhwMh_sI__PthreadT__sI__A;
import java.lang.foreign.Addressable;
import java.lang.foreign.MemorySegment;

/**
 *
 * @author aploese
 */
public class JnhwMi__I__PthreadTA__I__A extends JnhwMi__I___A__I__A implements JnhwMh_sI__PthreadT__sI__A.ExceptionErased {

    public JnhwMi__I__PthreadTA__I__A(MemorySegment methodAddress, String name) {
        super(methodAddress, name);
    }

    @Override
    public int invoke_sI__PthreadT__sI__A(Pthread.Pthread_t arg1, int arg2, Addressable arg3) {
        return invoke_sI___A_sI__A(arg1.toAddressable(), arg2, arg3);
    }

}
