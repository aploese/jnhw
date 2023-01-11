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
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.util.ConversionsNative2Java;
import de.ibapl.jnhw.util.winapi.WinApiDataType;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.ref.WeakReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 */
@SuppressWarnings("unchecked")
final class CallbackFactoryPAPCFUNC {

    private final static Logger LOG = Logger.getLogger("d.i.j.w.CallbackFactoryPAPCFUNC");

    private final static Linker NATIVE_LINKER = Linker.nativeLinker();

    public static final int MAX_CALL_BACKS = 16;

    private static final WeakReference<Winnt.PAPCFUNC> REFS[] = new WeakReference[MAX_CALL_BACKS];
    private static final MemorySegment NATIVE_SYMBOLS[] = new MemorySegment[MAX_CALL_BACKS];

    static {
        for (int i = 0; i < MAX_CALL_BACKS; i++) {
            REFS[i] = new WeakReference(null);
        }
    }

    static Winnt.PAPCFUNC find(NativeFunctionPointer callbackPtr) {
        for (WeakReference<Winnt.PAPCFUNC> wr : REFS) {
            Winnt.PAPCFUNC cb = wr.get();
            if (cb != null) {
                if (cb.equals(callbackPtr)) {
                    return cb;
                }
            }
        }
        return null;
    }

    static MemorySegment registerCallBack(int index) throws NoSuchMethodException, IllegalAccessException {
        switch (WinApiDataType.ULONG_PTR.SIZE_OF) {
            case 4 -> {
                final MethodHandle handle = MethodHandles.lookup().findStatic(CallbackFactoryPAPCFUNC.class, "trampoline32_" + index, MethodType.methodType(void.class, int.class));
                return NATIVE_LINKER.upcallStub(handle, FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT), MemorySession.global());
            }
            case 8 -> {
                final MethodHandle handle = MethodHandles.lookup().findStatic(CallbackFactoryPAPCFUNC.class, "trampoline64_" + index, MethodType.methodType(void.class, long.class));
                return NATIVE_LINKER.upcallStub(handle, FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG), MemorySession.global());
            }
            default ->
                throw new RuntimeException("Can't handle sizeof ULONG_PTR = " + WinApiDataType.ULONG_PTR.SIZE_OF);
        }
    }

    /**
     * this is just an estimation ...
     *
     * @return
     */
    public static int callbacksAvailable() {
        int result = 0;
        for (WeakReference<Winnt.PAPCFUNC> ref : REFS) {
            if (ref.get() == null) {
                result++;
            }
        }
        return result;
    }

    private static void trampoline32_0(int value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[0].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline32_0()"));
            } else {
                ref.callback(ConversionsNative2Java.uint32_t_TO_long(value));
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline32_0()"), t);
        }
    }

    private static void trampoline32_1(int value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[1].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline32_1()"));
            } else {
                ref.callback(ConversionsNative2Java.uint32_t_TO_long(value));
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline32_1()"), t);
        }
    }

    private static void trampoline32_2(int value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[2].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline32_2()"));
            } else {
                ref.callback(ConversionsNative2Java.uint32_t_TO_long(value));
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline32_2()"), t);
        }
    }

    private static void trampoline32_3(int value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[3].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline32_3()"));
            } else {
                ref.callback(ConversionsNative2Java.uint32_t_TO_long(value));
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline32_3()"), t);
        }
    }

    private static void trampoline32_4(int value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[4].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline32_4()"));
            } else {
                ref.callback(ConversionsNative2Java.uint32_t_TO_long(value));
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline32_4()"), t);
        }
    }

    private static void trampoline32_5(int value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[5].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline32_5()"));
            } else {
                ref.callback(ConversionsNative2Java.uint32_t_TO_long(value));
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline32_5()"), t);
        }
    }

    private static void trampoline32_6(int value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[6].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline32_6()"));
            } else {
                ref.callback(ConversionsNative2Java.uint32_t_TO_long(value));
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline32_6()"), t);
        }
    }

    private static void trampoline32_7(int value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[7].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline32_7()"));
            } else {
                ref.callback(ConversionsNative2Java.uint32_t_TO_long(value));
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline32_7()"), t);
        }
    }

    private static void trampoline32_8(int value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[8].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline32_8()"));
            } else {
                ref.callback(ConversionsNative2Java.uint32_t_TO_long(value));
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline32_8()"), t);
        }
    }

    private static void trampoline32_9(int value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[9].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline32_9()"));
            } else {
                ref.callback(ConversionsNative2Java.uint32_t_TO_long(value));
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline32_9()"), t);
        }
    }

    private static void trampoline32_10(int value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[10].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline32_10()"));
            } else {
                ref.callback(ConversionsNative2Java.uint32_t_TO_long(value));
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline32_10()"), t);
        }
    }

    private static void trampoline32_11(int value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[11].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline32_11()"));
            } else {
                ref.callback(ConversionsNative2Java.uint32_t_TO_long(value));
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline32_11()"), t);
        }
    }

    private static void trampoline32_12(int value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[12].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline32_12()"));
            } else {
                ref.callback(ConversionsNative2Java.uint32_t_TO_long(value));
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline32_12()"), t);
        }
    }

    private static void trampoline32_13(int value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[13].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline32_13()"));
            } else {
                ref.callback(ConversionsNative2Java.uint32_t_TO_long(value));
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline32_13()"), t);
        }
    }

    private static void trampoline32_14(int value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[14].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline32_14()"));
            } else {
                ref.callback(ConversionsNative2Java.uint32_t_TO_long(value));
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline32_14()"), t);
        }
    }

    private static void trampoline32_15(int value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[15].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline32_15()"));
            } else {
                ref.callback(ConversionsNative2Java.uint32_t_TO_long(value));
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline32_15()"), t);
        }
    }

    private static void trampoline64_0(long value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[0].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline64_0()"));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline64_0()"), t);
        }
    }

    private static void trampoline64_1(long value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[1].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline64_1()"));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline64_1()"), t);
        }
    }

    private static void trampoline64_2(long value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[2].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline64_2()"));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline64_2()"), t);
        }
    }

    private static void trampoline64_3(long value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[3].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline64_3()"));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline64_3()"), t);
        }
    }

    private static void trampoline64_4(long value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[4].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline64_4()"));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline64_4()"), t);
        }
    }

    private static void trampoline64_5(long value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[5].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline64_5()"));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline64_5()"), t);
        }
    }

    private static void trampoline64_6(long value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[6].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline64_6()"));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline64_6()"), t);
        }
    }

    private static void trampoline64_7(long value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[7].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline64_7()"));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline64_7()"), t);
        }
    }

    private static void trampoline64_8(long value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[8].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline64_8()"));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline64_8()"), t);
        }
    }

    private static void trampoline64_9(long value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[9].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline64_9()"));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline64_9()"), t);
        }
    }

    private static void trampoline64_10(long value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[10].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline64_10()"));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline64_10()"), t);
        }
    }

    private static void trampoline64_11(long value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[11].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline64_11()"));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline64_11()"), t);
        }
    }

    private static void trampoline64_12(long value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[12].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline64_12()"));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline64_12()"), t);
        }
    }

    private static void trampoline64_13(long value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[13].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline64_13()"));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline64_13()"), t);
        }
    }

    private static void trampoline64_14(long value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[14].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline64_14()"));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline64_14()"), t);
        }
    }

    private static void trampoline64_15(long value) {
        try {
            final Winnt.PAPCFUNC ref = REFS[15].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline64_15()"));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline64_15()"), t);
        }
    }

    public static synchronized MemoryAddress aquire(Winnt.PAPCFUNC cb) {
        for (int i = 0; i < MAX_CALL_BACKS; i++) {
            if (REFS[i].get() == null) {
                REFS[i] = new WeakReference(cb);
                //Lazy initialize the handles
                if (NATIVE_SYMBOLS[i] == null) {
                    try {
                        NATIVE_SYMBOLS[i] = registerCallBack(i);
                    } catch (NoSuchMethodException | IllegalAccessException ex) {
                        LOG.log(Level.SEVERE, "Failed registerCallBack(" + i + ")", ex);
                        throw new RuntimeException(ex);
                    }
                }
                return NATIVE_SYMBOLS[i].address();
            }
        }
        //Hint: Try run GC to free any??? or add more cbs...
        throw new RuntimeException("No more Callbacks available! max: " + MAX_CALL_BACKS + " reached");
    }
}
