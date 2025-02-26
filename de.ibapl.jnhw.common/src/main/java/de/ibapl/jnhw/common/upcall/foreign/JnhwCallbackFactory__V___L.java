/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2023-2025, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.common.upcall.foreign;

import de.ibapl.jnhw.common.upcall.CallbackFactory__V___L;
import de.ibapl.jnhw.common.upcall.Callback__V___L;
import de.ibapl.jnhw.common.util.jni.LibJnhwCommon;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.logging.Level;

/**
 *
 * @author aploese
 */
public class JnhwCallbackFactory__V___L extends CallbackFactory__V___L {

    private final Linker NATIVE_LINKER;

    public JnhwCallbackFactory__V___L() {
        NATIVE_LINKER = Linker.nativeLinker();
    }
    private static final MemorySegment[] NATIVE_SYMBOLS = new MemorySegment[MAX_CALL_BACKS];

    private MemorySegment registerCallBack(int index) throws NoSuchMethodException, IllegalAccessException {
        MethodHandle handle = MethodHandles.lookup().findStatic(JnhwCallbackFactory__V___L.class, "trampoline_" + index, MethodType.methodType(void.class, long.class));
        return NATIVE_LINKER.upcallStub(handle, FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG), LibJnhwCommon.arena());
    }

    /**
     * this is just an estimation ...
     *
     * @return
     */
    @Override
    protected int callbacksAvailable0() {
        int result = 0;
        for (Callback__V___L cb : REFS) {
            if (cb == null) {
                result++;
            }
        }
        return result;
    }

    @Override
    protected MemorySegment aquire0(Callback__V___L cb) {
        for (int i = 0; i < MAX_CALL_BACKS; i++) {
            if (REFS[i] == null) {
                //Lazy initialize the handles
                if (NATIVE_SYMBOLS[i] == null) {
                    try {
                        NATIVE_SYMBOLS[i] = registerCallBack(i);
                    } catch (NoSuchMethodException | IllegalAccessException ex) {
                        LOG.log(Level.SEVERE, "Failed registerCallBack(" + i + ")", ex);
                        throw new RuntimeException(ex);
                    }
                }
                REFS[i] = cb;
                return NATIVE_SYMBOLS[i];
            }
        }
        //Hint: Try run GC to free any??? or add more cbs...
        throw new RuntimeException("No more Callbacks available! max: " + MAX_CALL_BACKS + " reached");
    }

    @Override
    protected void release0(Callback__V___L cb) {
        for (int i = 0; i < MAX_CALL_BACKS; i++) {
            if (REFS[i] == cb) {
                REFS[i] = null;
                return;
            }
        }
        throw new RuntimeException("Callback not aquiered!");
    }

}
