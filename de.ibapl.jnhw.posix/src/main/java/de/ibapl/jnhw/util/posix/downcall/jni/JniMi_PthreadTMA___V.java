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
package de.ibapl.jnhw.util.posix.downcall.jni;

import de.ibapl.jnhw.common.downcall.jni.JniMi_MA___V;
import de.ibapl.jnhw.posix.Pthread;
import de.ibapl.jnhw.util.posix.downcall.JnhwMh_PthreadT___V;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentScope;

/**
 *
 * @author aploese
 */
public class JniMi_PthreadTMA___V extends JniMi_MA___V implements JnhwMh_PthreadT___V.ExceptionErased {

    public JniMi_PthreadTMA___V(MemorySegment methodAddress, String name) {
        super(methodAddress, name);
    }

    @Override
    public Pthread.Pthread_t invoke_PthreadT___V(SegmentScope ms) {
        return Pthread.Pthread_t.ofAddress(invoke_MA___V().address(), ms);
    }

}
