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
package de.ibapl.jnhw.common.upcall.jni;

import de.ibapl.jnhw.common.upcall.CallbackFactory__V___I_MA_MA;
import de.ibapl.jnhw.common.upcall.Callback__V___I_MA_MA;
import de.ibapl.jnhw.common.util.jni.LibJnhwCommon;
import java.lang.foreign.MemorySegment;

/**
 *
 * @author aploese
 */
public class JniCallbackFactory__V___I_MA_MA extends CallbackFactory__V___I_MA_MA {

    static {
        LibJnhwCommon.touch();
    }

    private static final MemorySegment[] NATIVE_SYMBOLS = new MemorySegment[MAX_CALL_BACKS];

    private static native long registerCallBack(int index, Class clazz, String staticMethodName);

    private static native int releaseCallBack(int index);

    private MemorySegment registerCallBack(int index) {
        final long result = registerCallBack(index, JniCallbackFactory__V___I_MA_MA.class, "trampoline_" + index);
        if (result == 0) {
            final String msg = "Can't get native callback ref for: \"trampoline_" + index + "\"";
            LOG.severe(msg);
            throw new RuntimeException(msg);
        }
        return MemorySegment.ofAddress(result).reinterpret(LibJnhwCommon.arena(), null);
    }

    private static native int getMaxCallBacks();

    /**
     * this is just an estimation ...
     *
     * @return
     */
    @Override
    protected int callbacksAvailable0() {
        int result = 0;
        for (Callback__V___I_MA_MA cb : REFS) {
            if (cb == null) {
                result++;
            }
        }
        return result;
    }

    @Override
    protected MemorySegment aquire0(Callback__V___I_MA_MA cb) {
        for (int i = 0; i < MAX_CALL_BACKS; i++) {
            if (REFS[i] == null) {
                REFS[i] = cb;
                //Lazy initialize the handles
                if (NATIVE_SYMBOLS[i] == null) {
                    NATIVE_SYMBOLS[i] = registerCallBack(i);
                }
                return NATIVE_SYMBOLS[i];
            }
        }
        //Hint: Try run GC to free any??? or add more cbs...
        throw new RuntimeException("No more Callbacks available! max: " + MAX_CALL_BACKS + " reached");
    }

    @Override
    protected void release0(Callback__V___I_MA_MA cb) {
        for (int i = 0; i < MAX_CALL_BACKS; i++) {
            if (REFS[i] == cb) {
                REFS[i] = null;
                NATIVE_SYMBOLS[i] = null;
                releaseCallBack(i);
                return;
            }
        }
        throw new RuntimeException("Callback not aquiered!");
    }

}
