/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2021-2024, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.common.test;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.downcall.JnhwMh__V__BL_sI;
import de.ibapl.jnhw.common.downcall.JnhwMh_sB___V;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI___V;
import de.ibapl.jnhw.libloader.LoadResult;
import de.ibapl.jnhw.libloader.LoadState;
import de.ibapl.jnhw.libloader.NativeLibResolver;
import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 */
public final class LibJnhwCommonTestLoader {

    public final static String LIB_JNHW_COMMON_TEST = "jnhw-common-test";
    private static LoadResult LIB_JNHW_COMMON_TEST_LOAD_RESULT;
    public final static int LIB_JNHW_COMMON_TEST_VERSION = 4;
    private final static Object loadLock = new Object();
    private static LoadState state = LoadState.INIT;
    public static SymbolLookup SYMBOL_LOOKUP = null;
    private static Arena MEM_ARENA = Arena.ofShared();

    static {
        LibJnhwCommonTestLoader.touch();
    }

    protected static void doLoadTestLib(String absoluteLibName) {
        SYMBOL_LOOKUP = SymbolLookup.libraryLookup(absoluteLibName, MEM_ARENA);
    }

    public static LoadResult getLoadResult() {
        return LIB_JNHW_COMMON_TEST_LOAD_RESULT;
    }

    /**
     * load but break any loop loading the lib will trigger OpacqueMemory to
     * trigger this again
     *
     * @return
     */
    public static LoadState touch() {
        synchronized (loadLock) {
            if (state != LoadState.INIT) {
                return state;
            }
            state = LoadState.LOADING;
        }
        LIB_JNHW_COMMON_TEST_LOAD_RESULT = NativeLibResolver.loadNativeLib(LIB_JNHW_COMMON_TEST, LIB_JNHW_COMMON_TEST_VERSION, LibJnhwCommonTestLoader::doLoadTestLib);
        synchronized (loadLock) {
            if (LIB_JNHW_COMMON_TEST_LOAD_RESULT.isLoaded()) {
                state = LoadState.SUCCESS;
            } else {
                state = LoadState.FAILURE;
            }
        }
        return state;
    }

    public static byte invokeExact__B__V(String name) {
        final MemorySegment methodAddress = SYMBOL_LOOKUP.findOrThrow(name);
        final MethodHandle mh = Linker.nativeLinker().downcallHandle(methodAddress, FunctionDescriptor.of(ValueLayout.JAVA_BYTE));
        try {
            return (byte) mh.invokeExact();
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void invokeExact_V__B(String name, byte value) {
        final MemorySegment methodAddress = SYMBOL_LOOKUP.findOrThrow(name);
        final MethodHandle mh = Linker.nativeLinker().downcallHandle(methodAddress, FunctionDescriptor.ofVoid(ValueLayout.JAVA_BYTE));
        try {
            mh.invokeExact(value);
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }
    }

    public static short invokeExact__S__V(String name) {
        final MemorySegment methodAddress = SYMBOL_LOOKUP.findOrThrow(name);
        final MethodHandle mh = Linker.nativeLinker().downcallHandle(methodAddress, FunctionDescriptor.of(ValueLayout.JAVA_SHORT));
        try {
            return (short) mh.invokeExact();
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void invokeExact_V__S(String name, short value) {
        final MemorySegment methodAddress = SYMBOL_LOOKUP.findOrThrow(name);
        final MethodHandle mh = Linker.nativeLinker().downcallHandle(methodAddress, FunctionDescriptor.ofVoid(ValueLayout.JAVA_SHORT));
        try {
            mh.invokeExact(value);
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }
    }

    public static int invokeExact__I__V(String name) {
        final MemorySegment methodAddress = SYMBOL_LOOKUP.findOrThrow(name);
        final MethodHandle mh = Linker.nativeLinker().downcallHandle(methodAddress, FunctionDescriptor.of(ValueLayout.JAVA_INT));
        try {
            return (int) mh.invokeExact();
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void invokeExact_V__I(String name, int value) {
        final MemorySegment methodAddress = SYMBOL_LOOKUP.findOrThrow(name);
        final MethodHandle mh = Linker.nativeLinker().downcallHandle(methodAddress, FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
        try {
            mh.invokeExact(value);
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }
    }

    public static long invokeExact__L__V(String name) {
        final MemorySegment methodAddress = SYMBOL_LOOKUP.findOrThrow(name);
        final MethodHandle mh = Linker.nativeLinker().downcallHandle(methodAddress, FunctionDescriptor.of(ValueLayout.JAVA_LONG));
        try {
            return (long) mh.invokeExact();
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void invokeExact_V__L(String name, long value) {
        final MemorySegment methodAddress = SYMBOL_LOOKUP.findOrThrow(name);
        final MethodHandle mh = Linker.nativeLinker().downcallHandle(methodAddress, FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG));
        try {
            mh.invokeExact(value);
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }
    }

    public static int invokeExact_Int_V(String name) {
        final MemorySegment methodAddress = SYMBOL_LOOKUP.findOrThrow(name);
        final MethodHandle mh = Linker.nativeLinker().downcallHandle(methodAddress, FunctionDescriptor.of(ValueLayout.JAVA_INT));
        try {
            return (int) mh.invokeExact();
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }
    }

    private LibJnhwCommonTestLoader() {
    }

}
