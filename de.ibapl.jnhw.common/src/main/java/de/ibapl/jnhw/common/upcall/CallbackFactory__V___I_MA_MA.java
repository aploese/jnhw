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
import de.ibapl.jnhw.common.upcall.foreign.JnhwCallbackFactory__V___I_MA_MA;
import de.ibapl.jnhw.common.upcall.jni.JniCallbackFactory__V___I_MA_MA;
import de.ibapl.jnhw.common.util.NativeProvider;
import java.lang.foreign.MemoryAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 */
@SuppressWarnings("unchecked")
public abstract class CallbackFactory__V___I_MA_MA {

    protected final static Logger LOG = Logger.getLogger("d.i.j.c.CallbackFactory__V___I_MA_MA");
    private final static CallbackFactory__V___I_MA_MA INSTANCE = NativeProvider.getProvider(
            () -> new JnhwCallbackFactory__V___I_MA_MA(),
            () -> new JniCallbackFactory__V___I_MA_MA());
    public static final int MAX_CALL_BACKS = 16;
    protected static final Callback__V___I_MA_MA[] REFS = new Callback__V___I_MA_MA[MAX_CALL_BACKS];

    protected final static void trampoline_0(final int a, final long b, final long c) {
        try {
            REFS[0].callback(a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c));
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_0(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_0(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)), t);
        }
    }

    protected final static void trampoline_0(final int a, final MemoryAddress b, final MemoryAddress c) {
        try {
            REFS[0].callback(a, b, c);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_0(%d,%s,%s)", a, b, c));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_0(%d,%s,%s)", a, b, c), t);
        }
    }

    protected final static void trampoline_1(final int a, final long b, final long c) {
        try {
            REFS[1].callback(a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c));
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_1(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_1(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)), t);
        }
    }

    protected final static void trampoline_1(final int a, final MemoryAddress b, final MemoryAddress c) {
        try {
            REFS[1].callback(a, b, c);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_1(%d,%s,%s)", a, b, c));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_1(%d,%s,%s)", a, b, c), t);
        }
    }

    protected final static void trampoline_2(final int a, final long b, final long c) {
        try {
            REFS[2].callback(a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c));
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_2(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_2(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)), t);
        }
    }

    protected final static void trampoline_2(final int a, final MemoryAddress b, final MemoryAddress c) {
        try {
            REFS[2].callback(a, b, c);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_2(%d,%s,%s)", a, b, c));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_2(%d,%s,%s)", a, b, c), t);
        }
    }

    protected final static void trampoline_3(final int a, final long b, final long c) {
        try {
            REFS[3].callback(a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c));
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_3(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_3(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)), t);
        }
    }

    protected final static void trampoline_3(final int a, final MemoryAddress b, final MemoryAddress c) {
        try {
            REFS[3].callback(a, b, c);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_3(%d,%s,%s)", a, b, c));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_3(%d,%s,%s)", a, b, c), t);
        }
    }

    protected final static void trampoline_4(final int a, final long b, final long c) {
        try {
            REFS[4].callback(a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c));
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_4(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_4(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)), t);
        }
    }

    protected final static void trampoline_4(final int a, final MemoryAddress b, final MemoryAddress c) {
        try {
            REFS[4].callback(a, b, c);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_4(%d,%s,%s)", a, b, c));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_4(%d,%s,%s)", a, b, c), t);
        }
    }

    protected final static void trampoline_5(final int a, final long b, final long c) {
        try {
            REFS[5].callback(a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c));
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_5(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_5(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)), t);
        }
    }

    protected final static void trampoline_5(final int a, final MemoryAddress b, final MemoryAddress c) {
        try {
            REFS[5].callback(a, b, c);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_5(%d,%s,%s)", a, b, c));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_5(%d,%s,%s)", a, b, c), t);
        }
    }

    protected final static void trampoline_6(final int a, final long b, final long c) {
        try {
            REFS[6].callback(a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c));
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_6(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_6(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)), t);
        }
    }

    protected final static void trampoline_6(final int a, final MemoryAddress b, final MemoryAddress c) {
        try {
            REFS[6].callback(a, b, c);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_6(%d,%s,%s)", a, b, c));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_6(%d,%s,%s)", a, b, c), t);
        }
    }

    protected final static void trampoline_7(final int a, final long b, final long c) {
        try {
            REFS[7].callback(a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c));
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_7(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_7(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)), t);
        }
    }

    protected final static void trampoline_7(final int a, final MemoryAddress b, final MemoryAddress c) {
        try {
            REFS[7].callback(a, b, c);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_7(%d,%s,%s)", a, b, c));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_7(%d,%s,%s)", a, b, c), t);
        }
    }

    protected final static void trampoline_8(final int a, final long b, final long c) {
        try {
            REFS[8].callback(a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c));
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_8(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_8(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)), t);
        }
    }

    protected final static void trampoline_8(final int a, final MemoryAddress b, final MemoryAddress c) {
        try {
            REFS[8].callback(a, b, c);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_8(%d,%s,%s)", a, b, c));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_8(%d,%s,%s)", a, b, c), t);
        }
    }

    protected final static void trampoline_9(final int a, final long b, final long c) {
        try {
            REFS[9].callback(a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c));
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_9(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_9(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)), t);
        }
    }

    protected final static void trampoline_9(final int a, final MemoryAddress b, final MemoryAddress c) {
        try {
            REFS[9].callback(a, b, c);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_9(%d,%s,%s)", a, b, c));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_9(%d,%s,%s)", a, b, c), t);
        }
    }

    protected final static void trampoline_10(final int a, final long b, final long c) {
        try {
            REFS[10].callback(a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c));
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_10(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_10(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)), t);
        }
    }

    protected final static void trampoline_10(final int a, final MemoryAddress b, final MemoryAddress c) {
        try {
            REFS[10].callback(a, b, c);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_10(%d,%s,%s)", a, b, c));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_10(%d,%s,%s)", a, b, c), t);
        }
    }

    protected final static void trampoline_11(final int a, final long b, final long c) {
        try {
            REFS[11].callback(a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c));
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_11(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_11(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)), t);
        }
    }

    protected final static void trampoline_11(final int a, final MemoryAddress b, final MemoryAddress c) {
        try {
            REFS[11].callback(a, b, c);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_11(%d,%s,%s)", a, b, c));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_11(%d,%s,%s)", a, b, c), t);
        }
    }

    protected final static void trampoline_12(final int a, final long b, final long c) {
        try {
            REFS[12].callback(a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c));
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_12(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_12(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)), t);
        }
    }

    protected final static void trampoline_12(final int a, final MemoryAddress b, final MemoryAddress c) {
        try {
            REFS[12].callback(a, b, c);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_12(%d,%s,%s)", a, b, c));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_12(%d,%s,%s)", a, b, c), t);
        }
    }

    protected final static void trampoline_13(final int a, final long b, final long c) {
        try {
            REFS[13].callback(a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c));
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_13(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_13(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)), t);
        }
    }

    protected final static void trampoline_13(final int a, final MemoryAddress b, final MemoryAddress c) {
        try {
            REFS[13].callback(a, b, c);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_13(%d,%s,%s)", a, b, c));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_13(%d,%s,%s)", a, b, c), t);
        }
    }

    protected final static void trampoline_14(final int a, final long b, final long c) {
        try {
            REFS[14].callback(a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c));
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_14(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_14(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)), t);
        }
    }

    protected final static void trampoline_14(final int a, final MemoryAddress b, final MemoryAddress c) {
        try {
            REFS[14].callback(a, b, c);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_14(%d,%s,%s)", a, b, c));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_14(%d,%s,%s)", a, b, c), t);
        }
    }

    protected final static void trampoline_15(final int a, final long b, final long c) {
        try {
            REFS[15].callback(a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c));
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_15(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_15(%d,%s,%s)", a, MemoryAddress.ofLong(b), MemoryAddress.ofLong(c)), t);
        }
    }

    protected final static void trampoline_15(final int a, final MemoryAddress b, final MemoryAddress c) {
        try {
            REFS[15].callback(a, b, c);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE, String.format("Unassigned callback for trampoline_15(%d,%s,%s)", a, b, c));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Exception was thrown in  trampoline_15(%d,%s,%s)", a, b, c), t);
        }
    }

    static synchronized MemoryAddress aquire(Callback__V___I_MA_MA cb) {
        return INSTANCE.aquire0(cb);
    }

    public static int callbacksAvailable() {
        return INSTANCE.callbacksAvailable0();
    }

    protected static Callback__V___I_MA_MA find(NativeFunctionPointer callbackPtr) {
        for (Callback__V___I_MA_MA cb : REFS) {
            if (cb != null) {
                if (cb.equals(callbackPtr)) {
                    return cb;
                }
            }
        }
        return null;
    }

    static synchronized void release(Callback__V___I_MA_MA cb) {
        INSTANCE.release0(cb);
    }

    protected abstract MemoryAddress aquire0(Callback__V___I_MA_MA cb);

    protected abstract void release0(Callback__V___I_MA_MA cb);

    protected abstract int callbacksAvailable0();

}
