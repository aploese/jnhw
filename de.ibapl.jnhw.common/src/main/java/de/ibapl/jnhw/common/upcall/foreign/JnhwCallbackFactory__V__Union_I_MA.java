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

import de.ibapl.jnhw.common.upcall.CallbackFactory__V__Union_I_MA;
import de.ibapl.jnhw.common.upcall.Callback__V__Union_I_MA;
import de.ibapl.jnhw.common.util.jni.LibJnhwCommon;
import de.ibapl.jnhw.libloader.Arch;
import de.ibapl.jnhw.libloader.MemoryModel;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.UnionLayout;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 */
public class JnhwCallbackFactory__V__Union_I_MA extends CallbackFactory__V__Union_I_MA {

    public final static Logger LOG = Logger.getLogger("d.i.j.c.u.foreign");

    public final static UnionLayout LAYOUT__UNION_I_MA = MemoryLayout.unionLayout(
            ValueLayout.ADDRESS.withName("value_ptr"),
            ValueLayout.JAVA_INT.withName("value_int")
    );

    public final static VarHandle HANDLE_VALUE_PTR
            = LAYOUT__UNION_I_MA.varHandle(MemoryLayout.PathElement.groupElement("value_ptr"));
    public final static VarHandle HANDLE_VALUE_INT
            = LAYOUT__UNION_I_MA.varHandle(MemoryLayout.PathElement.groupElement("value_int"));

    public MemorySegment aquire(Callback__V__Union_I_MA cb) {
        for (int i = 0; i < MAX_CALL_BACKS; i++) {
            if (REFS[i] == null) {
                REFS[i] = cb;
                //Lazy initialize the handles
                if (NATIVE_SYMBOLS[i] == null) {
                    try {
                        NATIVE_SYMBOLS[i] = registerCallBack(i);
                    } catch (NoSuchMethodException | IllegalAccessException ex) {
                        LOG.log(Level.SEVERE, "Failed registerCallBack(" + i + ")", ex);
                        throw new RuntimeException(ex);
                    }
                }
                return NATIVE_SYMBOLS[i];
            }
        }
        //Hint: Try run GC to free any??? or add more cbs...
        throw new RuntimeException("No more Callbacks available! max: " + MAX_CALL_BACKS + " reached");
    }

    private final Linker NATIVE_LINKER;

    public JnhwCallbackFactory__V__Union_I_MA() {
        NATIVE_LINKER = Linker.nativeLinker();
    }
    private static final MemorySegment[] NATIVE_SYMBOLS = new MemorySegment[MAX_CALL_BACKS];

    private MemorySegment registerCallBack(int index) throws NoSuchMethodException, IllegalAccessException {
        try {
            MethodHandle handle = MethodHandles.lookup().findStatic(CallbackFactory__V__Union_I_MA.class, "trampoline_" + index, MethodType.methodType(void.class, MemorySegment.class));
            return NATIVE_LINKER.upcallStub(handle, FunctionDescriptor.ofVoid(LAYOUT__UNION_I_MA), LibJnhwCommon.arena());
        } catch (IllegalArgumentException iae) {

            //POWERPC "Fallback linker does not support by-value unions: [A4|I4]" so make all to lower case
            if (iae.getMessage().toLowerCase().contains("Fallback linker does not support by-value unions: [a4|i4]".toLowerCase())
                    || iae.getMessage().toLowerCase().contains("Fallback linker does not support by-value unions: [a8|i4]".toLowerCase())) {

                
                final MemoryModel mm = MultiarchTupelBuilder.getMemoryModel();
                switch (mm) {
                    case ILP32, LP64 -> {
                        // int 32 bit and pointer 64 or 32 bit
                        LOG.log(Level.SEVERE, "Build a by value on stack callback __V__Union_I_MA for memory model: {0}", mm);
                        MethodHandle handle = MethodHandles.lookup().findStatic(JnhwCallbackFactory__V__Union_I_MA.class, "trampoline_" + index + "_fallback_by_value", MethodType.methodType(void.class, MemorySegment.class));
                        return NATIVE_LINKER.upcallStub(handle, FunctionDescriptor.ofVoid(ValueLayout.ADDRESS), LibJnhwCommon.arena());
                    }
                    default ->
                        throw new RuntimeException("Can't build a callback for memory model: " + mm, iae);
                }

            } else {
                throw iae;
            }
        }
    }

    /**
     * this is just an estimation ...
     *
     * @return
     */
    @Override
    protected int callbacksAvailable0() {
        int result = 0;
        for (Callback__V__Union_I_MA cb : REFS) {
            if (cb == null) {
                result++;
            }
        }
        return result;
    }

    @Override
    protected MemorySegment aquire0(Callback__V__Union_I_MA cb) {
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
    protected void release0(Callback__V__Union_I_MA cb) {
        for (int i = 0; i < MAX_CALL_BACKS; i++) {
            if (REFS[i] == cb) {
                REFS[i] = null;
                return;
            }
        }
        throw new RuntimeException("Callback not aquiered!");
    }

}
