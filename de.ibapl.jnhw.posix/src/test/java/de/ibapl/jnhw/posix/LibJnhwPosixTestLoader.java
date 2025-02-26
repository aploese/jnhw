/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2020-2025, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.datatypes.Sign;
import de.ibapl.jnhw.common.downcall.JnhwMh_MA___A;
import de.ibapl.jnhw.common.downcall.JnhwMh_MA___A_sI;
import de.ibapl.jnhw.common.downcall.JnhwMh_MA___V;
import de.ibapl.jnhw.common.downcall.JnhwMh_sB___A;
import de.ibapl.jnhw.common.downcall.JnhwMh_sB___V;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI___V;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sB_sI;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI_sB_sI_sI;
import de.ibapl.jnhw.common.downcall.JnhwMh_sL___V;
import de.ibapl.jnhw.common.downcall.JnhwMh_sS___V;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.IntPtr_t;
import de.ibapl.jnhw.libloader.LoadResult;
import de.ibapl.jnhw.libloader.LoadState;
import de.ibapl.jnhw.libloader.NativeLibResolver;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 */
public final class LibJnhwPosixTestLoader {

    private final static Logger LOG = Logger.getLogger("d.i.j.p.LibJnhwPosixTestLoader");

    public final static String LIB_JNHW_POSIX_TEST = "jnhw-posix-test";
    private static LoadResult LIB_JNHW_POSIX_TEST_LOAD_RESULT;
    public final static int LIB_JNHW_POSIX_TEST_VERSION = 4;
    private final static Object loadLock = new Object();
    private static LoadState state = LoadState.INIT;
    public static SymbolLookup SYMBOL_LOOKUP = null;
    public final static Arena MEMORY_ARENA = Arena.ofShared();

    static {
        LibJnhwPosixTestLoader.touch();
    }

    protected static void doLoadTestLib(String absoluteLibName) {
        SYMBOL_LOOKUP = SymbolLookup.libraryLookup(absoluteLibName, MEMORY_ARENA);
    }

    public static LoadResult getLoadResult() {
        return LIB_JNHW_POSIX_TEST_LOAD_RESULT;
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
        LIB_JNHW_POSIX_TEST_LOAD_RESULT = NativeLibResolver.loadNativeLib(LIB_JNHW_POSIX_TEST, LIB_JNHW_POSIX_TEST_VERSION, LibJnhwPosixTestLoader::doLoadTestLib);
        synchronized (loadLock) {
            if (LIB_JNHW_POSIX_TEST_LOAD_RESULT.isLoaded()) {
                state = LoadState.SUCCESS;
            } else {
                state = LoadState.FAILURE;
            }
        }
        return state;
    }

    public static byte invoke_sB___V(String name) {
        return JnhwMh_sB___V.mandatoryOf(SYMBOL_LOOKUP, name, BaseDataType.int8_t).invoke_sB___V();
    }

    public static short invoke_sS___V(String name) {
        return JnhwMh_sS___V.mandatoryOf(SYMBOL_LOOKUP, name, BaseDataType.int16_t).invoke_sS___V();
    }

    //sync with PosixDataTYpesTest.c
    private final static byte SIGNED = 0x01;
    private final static byte UNSIGNED = 0x02;
    private final static byte NO_SIGN = 0x04;

    public static Sign invokeExact_CharToSign_V(String name) {
        return switch (JnhwMh_sB___V.mandatoryOf(SYMBOL_LOOKUP, name, BaseDataType.int8_t).invoke_sB___V()) {
            case SIGNED ->
                Sign.Signed;
            case UNSIGNED ->
                Sign.Unsigned;
            case NO_SIGN ->
                Sign.No_Sign;
            default ->
                throw new RuntimeException("Cant get sign of: " + name + " value from native is: " + JnhwMh_sB___V.mandatoryOf(SYMBOL_LOOKUP, name, BaseDataType.int8_t).invoke_sB___V());
        };
    }

    public static boolean invokeExact_CharToBool_V(String name) {
        return JnhwMh_sB___V.mandatoryOf(SYMBOL_LOOKUP, name, BaseDataType.int8_t).invoke_sB___V() != 0;
    }

    public static boolean invokeExact_CharToBool_Adr(String name, MemorySegment arg1) {
        return JnhwMh_sB___A.mandatoryOf(SYMBOL_LOOKUP, name, BaseDataType.int8_t, BaseDataType.intptr_t).invoke_sB___A(arg1) != 0;
    }

    public static int invoke_sI___V(String name) {
        return JnhwMh_sI___V.mandatoryOf(SYMBOL_LOOKUP, name, BaseDataType.int32_t).invoke_sI___V();
    }

    public static int invoke_sI__sB_sI(String name, byte arg1, int arg2) {
        return JnhwMh_sI__sB_sI.mandatoryOf(SYMBOL_LOOKUP, name, BaseDataType.int32_t, BaseDataType.int8_t, BaseDataType.int32_t).invoke_sI__sB_sI(arg1, arg2);
    }

    public static int invoke_sI__sI_sB_sI_sI(String name, int arg1, byte arg2, int arg3, int arg4) {
        return JnhwMh_sI__sI_sB_sI_sI.mandatoryOf(SYMBOL_LOOKUP, name, BaseDataType.int32_t, BaseDataType.int32_t, BaseDataType.int8_t, BaseDataType.int32_t, BaseDataType.int32_t).invoke_sI__sI_sB_sI_sI(arg1, arg2, arg3, arg4);
    }

    public static MemorySegment invoke_MA___V(String name, long targetSize) {
        return JnhwMh_MA___V.mandatoryOf(SYMBOL_LOOKUP, name, BaseDataType.intptr_t, targetSize).invoke_MA___V();
    }

    public static MemorySegment invoke_MA___A_sI(String name, MemorySegment arg1, int arg2, long targetByteSize) {
        return JnhwMh_MA___A_sI.mandatoryOf(SYMBOL_LOOKUP, name, BaseDataType.uintptr_t, BaseDataType.uintptr_t, BaseDataType.int32_t, targetByteSize).invoke_MA___A_sI(arg1, arg2);
    }

    public static long invoke_sL___V(String name) {
        return JnhwMh_sL___V.mandatoryOf(SYMBOL_LOOKUP, name, BaseDataType.int64_t).invoke_sL___V();
    }

    public static MemorySegment invoke_MA___A(String name, MemorySegment arg1, long targetByteSize) {
        return JnhwMh_MA___A.mandatoryOf(SYMBOL_LOOKUP, name, BaseDataType.uintptr_t, BaseDataType.uintptr_t, targetByteSize).invoke_MA___A(arg1);
    }

    public static Integer getClassIntegerDefine(String name) {
        try (Arena arena = Arena.ofConfined()) {
            Int32_t value = Int32_t.allocateNative(arena);
            MemorySegment result = invoke_MA___A("tryGetValueOf_" + name, value.toMemorySegment(), 0);
            if (result.address() == 0L) {
                return null;
            } else {
                return value.int32_t();
            }
        }
    }

    public static int getByteDefine(String name) {
        return invoke_sB___V("getValueOf_" + name);
    }

    public static int getShortDefine(String name) {
        return invoke_sS___V("getValueOf_" + name);
    }

    public static int getIntDefine(String name) {
        return invoke_sI___V("getValueOf_" + name);
    }

    public static long getLongDefine(String name) {
        return invoke_sL___V("getValueOf_" + name);
    }

    public static MemorySegment getAdrDefine(String name) {
        return invoke_MA___V("getValueOf_" + name, 0);
    }

    public static MemorySegment find(String name) {
        return SYMBOL_LOOKUP.find(name).orElseThrow(() -> new NoSuchElementException("lookup for: \"" + name + "\" in: \"" + LIB_JNHW_POSIX_TEST_LOAD_RESULT.libFileName + "\" failed"));
    }

    private LibJnhwPosixTestLoader() {
    }

    public static MemorySegment tryGetAdrDefine(String name) {
        try (Arena arena = Arena.ofConfined()) {
            IntPtr_t value = IntPtr_t.allocateNative(arena);
            MemorySegment result = invoke_MA___A("tryGetValueOf_" + name, value.toMemorySegment(), 0);
            if (result.address() == 0L) {
                return null;
            } else {
                return value.get();
            }
        }
    }

}
