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
package de.ibapl.jnhw.common.upcall;

import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.upcall.foreign.JnhwCallbackFactory__V___L;
import de.ibapl.jnhw.common.upcall.jni.JniCallbackFactory__V___L;
import de.ibapl.jnhw.common.util.NativeProvider;
import java.lang.foreign.MemorySegment;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 */
@SuppressWarnings("unchecked")
public abstract class CallbackFactory__V___L {

    protected final static Logger LOG = Logger.getLogger("d.i.j.c.CallbackFactory__V___L");

    private final static CallbackFactory__V___L INSTANCE = NativeProvider.getProvider(
            () -> new JnhwCallbackFactory__V___L(),
            () -> new JniCallbackFactory__V___L());

    public static final int MAX_CALL_BACKS = 16;
    protected static final Callback__V___L[] REFS = new Callback__V___L[MAX_CALL_BACKS];

    static synchronized MemorySegment aquire(Callback__V___L cb) {
        return INSTANCE.aquire0(cb);
    }

    public static int callbacksAvailable() {
        return INSTANCE.callbacksAvailable0();
    }

    protected static Callback__V___L find(NativeFunctionPointer callbackPtr) {
        for (Callback__V___L cb : REFS) {
            if (cb != null) {
                if (cb.equals(callbackPtr)) {
                    return cb;
                }
            }
        }
        return null;
    }

    static synchronized void release(Callback__V___L cb) {
        INSTANCE.release0(cb);
    }

    protected final static void trampoline_0(final long value) {
        try {
            REFS[0].callback(value);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_0(%d)", value));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_0(%d)", value), t);
        }
    }

    protected final static void trampoline_1(final long value) {
        try {
            REFS[1].callback(value);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_1(%d)", value));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_1(%d)", value), t);
        }
    }

    protected final static void trampoline_2(final long value) {
        try {
            REFS[2].callback(value);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_2(%d)", value));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_2(%d)", value), t);
        }
    }

    protected final static void trampoline_3(final long value) {
        try {
            REFS[3].callback(value);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_3(%d)", value));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_3(%d)", value), t);
        }
    }

    protected final static void trampoline_4(final long value) {
        try {
            REFS[4].callback(value);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_4(%d)", value));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_4(%d)", value), t);
        }
    }

    protected final static void trampoline_5(final long value) {
        try {
            REFS[5].callback(value);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_5(%d)", value));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_5(%d)", value), t);
        }
    }

    protected final static void trampoline_6(final long value) {
        try {
            REFS[6].callback(value);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_6(%d)", value));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_6(%d)", value), t);
        }
    }

    protected final static void trampoline_7(final long value) {
        try {
            REFS[7].callback(value);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_7(%d)", value));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_7(%d)", value), t);
        }
    }

    protected final static void trampoline_8(final long value) {
        try {
            REFS[8].callback(value);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_8(%d)", value));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_8(%d)", value), t);
        }
    }

    protected final static void trampoline_9(final long value) {
        try {
            REFS[9].callback(value);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_9(%d)", value));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_9(%d)", value), t);
        }
    }

    protected final static void trampoline_10(final long value) {
        try {
            REFS[10].callback(value);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_10(%d)", value));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_10(%d)", value), t);
        }
    }

    protected final static void trampoline_11(final long value) {
        try {
            REFS[11].callback(value);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_11(%d)", value));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_11(%d)", value), t);
        }
    }

    protected final static void trampoline_12(final long value) {
        try {
            REFS[12].callback(value);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_12(%d)", value));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_12(%d)", value), t);
        }
    }

    protected final static void trampoline_13(final long value) {
        try {
            REFS[13].callback(value);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_13(%d)", value));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_13(%d)", value), t);
        }
    }

    protected final static void trampoline_14(final long value) {
        try {
            REFS[14].callback(value);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_14(%d)", value));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_14(%d)", value), t);
        }
    }

    protected final static void trampoline_15(final long value) {
        try {
            REFS[15].callback(value);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_15(%d)", value));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_15(%d)", value), t);
        }
    }

    protected abstract MemorySegment aquire0(Callback__V___L cb);

    protected abstract void release0(Callback__V___L cb);

    protected abstract int callbacksAvailable0();

}
