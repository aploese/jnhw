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
package de.ibapl.jnhw.common.upcall;

import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.ref.WeakReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.NativeSymbol;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.ValueLayout;

/**
 *
 * @author aploese
 */
@SuppressWarnings("unchecked")
public class CallbackFactory__V___L {

    private final static Logger LOG = Logger.getLogger("d.i.j.c.CallbackFactory__V___L");

    private final static CLinker C_LINKER = CLinker.systemCLinker();

    public static final int MAX_CALL_BACKS = 16;

    private static final WeakReference<Callback__V___L> REFS[] = new WeakReference[MAX_CALL_BACKS];
    private static final NativeSymbol NATIVE_SYMBOLS[] = new NativeSymbol[MAX_CALL_BACKS];

    static {
        for (int i = 0; i < MAX_CALL_BACKS; i++) {
            REFS[i] = new WeakReference(null);
        }
    }

    static Callback__V___L find(NativeFunctionPointer callbackPtr) {
        for (WeakReference<Callback__V___L> wr : REFS) {
            Callback__V___L cb = wr.get();
            if (cb != null) {
                if (cb.equals(callbackPtr)) {
                    return cb;
                }
            }
        }
        return null;
    }

    static NativeSymbol registerCallBack(int index) throws NoSuchMethodException, IllegalAccessException {
        MethodHandle handle = MethodHandles.lookup().findStatic(CallbackFactory__V___L.class, "trampoline_" + index, MethodType.methodType(void.class, long.class));
        return C_LINKER.upcallStub(handle, FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG), ResourceScope.globalScope());
    }

    /**
     * this is just an estimation ...
     *
     * @return
     */
    public static int callbacksAvailable() {
        int result = 0;
        for (WeakReference<Callback__V___L> ref : REFS) {
            if (ref.get() == null) {
                result++;
            }
        }
        return result;
    }

    private static void trampoline_0(final long value) {
        try {
            final Callback__V___L ref = REFS[0].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_0(%d)", value));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_0(%d)", value), t);
        }
    }

    private static void trampoline_1(final long value) {
        try {
            final Callback__V___L ref = REFS[1].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_1(%d)", value));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_1(%d)", value), t);
        }
    }

    private static void trampoline_2(final long value) {
        try {
            final Callback__V___L ref = REFS[2].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_2(%d)", value));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_2(%d)", value), t);
        }
    }

    private static void trampoline_3(final long value) {
        try {
            final Callback__V___L ref = REFS[3].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_3(%d)", value));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_3(%d)", value), t);
        }
    }

    private static void trampoline_4(final long value) {
        try {
            final Callback__V___L ref = REFS[4].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_4(%d)", value));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_4(%d)", value), t);
        }
    }

    private static void trampoline_5(final long value) {
        try {
            final Callback__V___L ref = REFS[5].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_5(%d)", value));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_5(%d)", value), t);
        }
    }

    private static void trampoline_6(final long value) {
        try {
            final Callback__V___L ref = REFS[6].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_6(%d)", value));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_6(%d)", value), t);
        }
    }

    private static void trampoline_7(final long value) {
        try {
            final Callback__V___L ref = REFS[7].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_7(%d)", value));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_7(%d)", value), t);
        }
    }

    private static void trampoline_8(final long value) {
        try {
            final Callback__V___L ref = REFS[8].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_8(%d)", value));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_8(%d)", value), t);
        }
    }

    private static void trampoline_9(final long value) {
        try {
            final Callback__V___L ref = REFS[9].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_9(%d)", value));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_9(%d)", value), t);
        }
    }

    private static void trampoline_10(final long value) {
        try {
            final Callback__V___L ref = REFS[10].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_10(%d)", value));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_10(%d)", value), t);
        }
    }

    private static void trampoline_11(final long value) {
        try {
            final Callback__V___L ref = REFS[11].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_11(%d)", value));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_11(%d)", value), t);
        }
    }

    private static void trampoline_12(final long value) {
        try {
            final Callback__V___L ref = REFS[12].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_12(%d)", value));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_12(%d)", value), t);
        }
    }

    private static void trampoline_13(final long value) {
        try {
            final Callback__V___L ref = REFS[13].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_13(%d)", value));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_13(%d)", value), t);
        }
    }

    private static void trampoline_14(final long value) {
        try {
            final Callback__V___L ref = REFS[14].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_14(%d)", value));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_14(%d)", value), t);
        }
    }

    private static void trampoline_15(final long value) {
        try {
            final Callback__V___L ref = REFS[15].get();
            if (ref == null) {
                LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_15(%d)", value));
            } else {
                ref.callback(value);
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_15(%d)", value), t);
        }
    }

    static synchronized MemoryAddress aquire(Callback__V___L cb) {
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
