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
package de.ibapl.jnhw.common.upcall;

import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.upcall.foreign.JnhwCallbackFactory__V__Union_I_MA;
import de.ibapl.jnhw.common.upcall.jni.JniCallbackFactory__V__Union_I_MA;
import de.ibapl.jnhw.common.util.ConversionsNative2Java;
import de.ibapl.jnhw.common.util.NativeProvider;
import java.lang.foreign.MemorySegment;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 */
@SuppressWarnings("unchecked")
public abstract class CallbackFactory__V__Union_I_MA {

    protected final static Logger LOG = Logger.getLogger("d.i.j.c.CallbackFactory__V__Union_I_MA");
    private final static CallbackFactory__V__Union_I_MA INSTANCE = NativeProvider.getProvider(
            () -> new JnhwCallbackFactory__V__Union_I_MA(),
            () -> new JniCallbackFactory__V__Union_I_MA());
    public static final int MAX_CALL_BACKS = 16;
    protected static final Callback__V__Union_I_MA[] REFS = new Callback__V__Union_I_MA[MAX_CALL_BACKS];

    private final static ConversionsNative2Java.Address2Int FALLBACK_ADDRESS_TO_INT = ConversionsNative2Java.getAdress2Int();

    protected final static void trampoline_0(final long value_ptr, final int value_int) {
        try {
            REFS[0].callback(MemorySegment.ofAddress(value_ptr),
                    value_int
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format("Unassigned callback for trampoline_0(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format("Exception was thrown in  trampoline_0(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_0(final MemorySegment value) {
        try {
            REFS[0].callback(
                    (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                    (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_0(%s, %d)",
                            (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                            (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_0(%s)",
                            value),
                    t
            );
        }
    }

    protected final static void trampoline_0_fallback_by_value(final MemorySegment value) {
        try {
            REFS[0].callback(
                    value,
                    FALLBACK_ADDRESS_TO_INT.convert(value)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_0_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_0_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_1(final long value_ptr, final int value_int) {
        try {
            REFS[1].callback(MemorySegment.ofAddress(value_ptr),
                    value_int
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_1(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_1(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int),
                    t
            );
        }
    }

    protected final static void trampoline_1(final MemorySegment value) {
        try {
            REFS[1].callback(
                    (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                    (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
            );
        } catch (NullPointerException npe) {
            LOG.log(
                    Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_1(%s, %d)",
                            (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                            (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format(
                    "Exception was thrown in  trampoline_1(%s)",
                    value),
                    t
            );
        }
    }

    protected final static void trampoline_1_fallback_by_value(final MemorySegment value) {
        try {
            REFS[1].callback(
                    value,
                    FALLBACK_ADDRESS_TO_INT.convert(value)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_1_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_1_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_2(final long value_ptr, final int value_int) {
        try {
            REFS[2].callback(MemorySegment.ofAddress(value_ptr),
                    value_int
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_2(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_2(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_2(final MemorySegment value) {
        try {
            REFS[2].callback(
                    (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                    (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_2(%s, %d)",
                            (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                            (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_2(%s)",
                            value),
                    t
            );
        }
    }

    protected final static void trampoline_2_fallback_by_value(final MemorySegment value) {
        try {
            REFS[2].callback(
                    value,
                    FALLBACK_ADDRESS_TO_INT.convert(value)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_2_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_2_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_3(final long value_ptr, final int value_int) {
        try {
            REFS[3].callback(MemorySegment.ofAddress(value_ptr),
                    value_int
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_3(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_3(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_3(final MemorySegment value) {
        try {
            REFS[3].callback(
                    (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                    (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_3(%s, %d)",
                            (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                            (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_3(%s)",
                            value),
                    t);
        }
    }

    protected final static void trampoline_3_fallback_by_value(final MemorySegment value) {
        try {
            REFS[3].callback(
                    value,
                    FALLBACK_ADDRESS_TO_INT.convert(value)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_3_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_3_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_4(final long value_ptr, final int value_int) {
        try {
            REFS[4].callback(MemorySegment.ofAddress(value_ptr),
                    value_int
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_4(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_4(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_4(final MemorySegment value) {
        try {
            REFS[4].callback(
                    (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                    (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_4(%s, %d)",
                            (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                            (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_4(%s)",
                            value),
                    t
            );
        }
    }

    protected final static void trampoline_4_fallback_by_value(final MemorySegment value) {
        try {
            REFS[4].callback(
                    value,
                    FALLBACK_ADDRESS_TO_INT.convert(value)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_4_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_4_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_5(final long value_ptr, final int value_int) {
        try {
            REFS[5].callback(MemorySegment.ofAddress(value_ptr),
                    value_int
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_5(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_5(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_5(final MemorySegment value) {
        try {
            REFS[5].callback(
                    (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                    (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_5(%s, %d)",
                            (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                            (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_5(%s)",
                            value),
                    t
            );
        }
    }

    protected final static void trampoline_5_fallback_by_value(final MemorySegment value) {
        try {
            REFS[5].callback(
                    value,
                    FALLBACK_ADDRESS_TO_INT.convert(value)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_5_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_5_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_6(final long value_ptr, final int value_int) {
        try {
            REFS[6].callback(MemorySegment.ofAddress(value_ptr),
                    value_int
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_6(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_6(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_6(final MemorySegment value) {
        try {
            REFS[6].callback(
                    (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                    (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_6(%s, %d)",
                            (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                            (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_6(%s)",
                            value),
                    t
            );
        }
    }

    protected final static void trampoline_6_fallback_by_value(final MemorySegment value) {
        try {
            REFS[0].callback(
                    value,
                    FALLBACK_ADDRESS_TO_INT.convert(value)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_6_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_6_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_7(final long value_ptr, final int value_int) {
        try {
            REFS[7].callback(MemorySegment.ofAddress(value_ptr),
                    value_int
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_7(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_7(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_7(final MemorySegment value) {
        try {
            REFS[7].callback(
                    (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                    (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_7(%s, %d)",
                            (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                            (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_7(%s)",
                            value),
                    t
            );
        }
    }

    protected final static void trampoline_7_fallback_by_value(final MemorySegment value) {
        try {
            REFS[7].callback(
                    value,
                    FALLBACK_ADDRESS_TO_INT.convert(value)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_7_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_7_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_8(final long value_ptr, final int value_int) {
        try {
            REFS[8].callback(MemorySegment.ofAddress(value_ptr),
                    value_int
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_8(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_8(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_8(final MemorySegment value) {
        try {
            REFS[8].callback(
                    (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                    (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_8(%s, %d)",
                            (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                            (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_8(%s)",
                            value),
                    t
            );
        }
    }

    protected final static void trampoline_8_fallback_by_value(final MemorySegment value) {
        try {
            REFS[8].callback(
                    value,
                    FALLBACK_ADDRESS_TO_INT.convert(value)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_8_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_8_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_9(final long value_ptr, final int value_int) {
        try {
            REFS[9].callback(MemorySegment.ofAddress(value_ptr),
                    value_int);
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_9(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_9(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_9(final MemorySegment value) {
        try {
            REFS[9].callback(
                    (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                    (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format("Unassigned callback for trampoline_9(%s, %d)",
                            (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                            (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format("Exception was thrown in  trampoline_9(%s)",
                            value),
                    t
            );
        }
    }

    protected final static void trampoline_9_fallback_by_value(final MemorySegment value) {
        try {
            REFS[9].callback(
                    value,
                    FALLBACK_ADDRESS_TO_INT.convert(value)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_9_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_9_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_10(final long value_ptr, final int value_int) {
        try {
            REFS[10].callback(MemorySegment.ofAddress(value_ptr),
                    value_int
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_10(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_10(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_10(final MemorySegment value) {
        try {
            REFS[10].callback(
                    (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                    (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_10(%s, %d)",
                            (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                            (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_10(%s)",
                            value),
                    t
            );
        }
    }

    protected final static void trampoline_10_fallback_by_value(final MemorySegment value) {
        try {
            REFS[10].callback(
                    value,
                    FALLBACK_ADDRESS_TO_INT.convert(value)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_10_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_10_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_11(final long value_ptr, final int value_int) {
        try {
            REFS[11].callback(MemorySegment.ofAddress(value_ptr),
                    value_int
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_11(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_11(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_11(final MemorySegment value) {
        try {
            REFS[11].callback(
                    (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                    (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_11(%s, %d)",
                            (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                            (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_11(%s)",
                            value),
                    t
            );
        }
    }

    protected final static void trampoline_11_fallback_by_value(final MemorySegment value) {
        try {
            REFS[11].callback(
                    value,
                    FALLBACK_ADDRESS_TO_INT.convert(value)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_11_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_11_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_12(final long value_ptr, final int value_int) {
        try {
            REFS[12].callback(MemorySegment.ofAddress(value_ptr),
                    value_int
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_12(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_12(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_12(final MemorySegment value) {
        try {
            REFS[12].callback(
                    (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                    (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_12(%s, %d)",
                            (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                            (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_12(%s)",
                            value),
                    t
            );
        }
    }

    protected final static void trampoline_12_fallback_by_value(final MemorySegment value) {
        try {
            REFS[12].callback(
                    value,
                    FALLBACK_ADDRESS_TO_INT.convert(value)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_12_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_12_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_13(final long value_ptr, final int value_int) {
        try {
            REFS[13].callback(MemorySegment.ofAddress(value_ptr),
                    value_int
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_13(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_13(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_13(final MemorySegment value) {
        try {
            REFS[13].callback(
                    (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                    (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_13(%s, %d)",
                            (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                            (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_13(%s)",
                            value),
                    t
            );
        }
    }

    protected final static void trampoline_13_fallback_by_value(final MemorySegment value) {
        try {
            REFS[13].callback(
                    value,
                    FALLBACK_ADDRESS_TO_INT.convert(value)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_13_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_13_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_14(final long value_ptr, final int value_int) {
        try {
            REFS[14].callback(MemorySegment.ofAddress(value_ptr),
                    value_int
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_14(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_14(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_14(final MemorySegment value) {
        try {
            REFS[14].callback(
                    (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                    (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_14(%s, %d)",
                            (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                            (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_14(%s)",
                            value),
                    t
            );
        }
    }

    protected final static void trampoline_14_fallback_by_value(final MemorySegment value) {
        try {
            REFS[14].callback(
                    value,
                    FALLBACK_ADDRESS_TO_INT.convert(value)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_14_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_14_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_15(final long value_ptr, final int value_int) {
        try {
            REFS[15].callback(MemorySegment.ofAddress(value_ptr),
                    value_int
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_15(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_15(%s, %d)",
                            MemorySegment.ofAddress(value_ptr),
                            value_int
                    ),
                    t
            );
        }
    }

    protected final static void trampoline_15(final MemorySegment value) {
        try {
            REFS[15].callback(
                    (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                    (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_15(%s, %d)",
                            (MemorySegment) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_PTR.get(value, 0L),
                            (int) JnhwCallbackFactory__V__Union_I_MA.HANDLE_VALUE_INT.get(value, 0L)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_15(%s)",
                            value),
                    t
            );
        }
    }

    protected final static void trampoline_15_fallback_by_value(final MemorySegment value) {
        try {
            REFS[15].callback(
                    value,
                    FALLBACK_ADDRESS_TO_INT.convert(value)
            );
        } catch (NullPointerException npe) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Unassigned callback for trampoline_15_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    )
            );
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    String.format(
                            "Exception was thrown in  trampoline_15_fallback_by_value(%s, %d)",
                            value,
                            FALLBACK_ADDRESS_TO_INT.convert(value)
                    ),
                    t
            );
        }
    }

    static synchronized MemorySegment aquire(Callback__V__Union_I_MA cb) {
        return INSTANCE.aquire0(cb);
    }

    public static int callbacksAvailable() {
        return INSTANCE.callbacksAvailable0();
    }

    protected static Callback__V__Union_I_MA find(NativeFunctionPointer callbackPtr) {
        for (Callback__V__Union_I_MA cb : REFS) {
            if (cb != null) {
                if (cb.equals(callbackPtr)) {
                    return cb;
                }
            }
        }
        return null;
    }

    static synchronized void release(Callback__V__Union_I_MA cb) {
        INSTANCE.release0(cb);
    }

    protected abstract MemorySegment aquire0(Callback__V__Union_I_MA cb);

    protected abstract void release0(Callback__V__Union_I_MA cb);

    protected abstract int callbacksAvailable0();

}
