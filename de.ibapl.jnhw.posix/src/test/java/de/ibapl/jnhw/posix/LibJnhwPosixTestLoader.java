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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
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
import java.lang.foreign.Addressable;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SymbolLookup;
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
    public static SymbolLookup LIB_JNHW_POSIX_TEST_SYMBOL_LOOKUP = null;
    private final static MemorySession LIB_JNHW_POSIX_TEST_MEMORY_SESSION = MemorySession.openShared();

    static {
        LibJnhwPosixTestLoader.touch();
    }

    protected static void doLoadTestLib(String absoluteLibName) {
        LIB_JNHW_POSIX_TEST_SYMBOL_LOOKUP = SymbolLookup.libraryLookup(absoluteLibName, LIB_JNHW_POSIX_TEST_MEMORY_SESSION);
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
        return JnhwMh_sB___V.mandatoryOf(LIB_JNHW_POSIX_TEST_SYMBOL_LOOKUP, name, BaseDataType.int8_t).invoke_sB___V();
    }

    public static short invoke_sS___V(String name) {
        return JnhwMh_sS___V.mandatoryOf(LIB_JNHW_POSIX_TEST_SYMBOL_LOOKUP, name, BaseDataType.int16_t).invoke_sS___V();
    }

    public static boolean invokeExact_CharToBool_V(String name) {
        return JnhwMh_sB___V.mandatoryOf(LIB_JNHW_POSIX_TEST_SYMBOL_LOOKUP, name, BaseDataType.int8_t).invoke_sB___V() != 0;
    }

    public static boolean invokeExact_CharToBool_Adr(String name, Addressable arg1) {
        return JnhwMh_sB___A.mandatoryOf(LIB_JNHW_POSIX_TEST_SYMBOL_LOOKUP, name, BaseDataType.int8_t, BaseDataType.intptr_t).invoke_sB___A(arg1) != 0;
    }

    public static int invoke_sI___V(String name) {
        return JnhwMh_sI___V.mandatoryOf(LIB_JNHW_POSIX_TEST_SYMBOL_LOOKUP, name, BaseDataType.int32_t).invoke_sI___V();
    }

    public static int invoke_sI__sB_sI(String name, byte arg1, int arg2) {
        return JnhwMh_sI__sB_sI.mandatoryOf(LIB_JNHW_POSIX_TEST_SYMBOL_LOOKUP, name, BaseDataType.int32_t, BaseDataType.int8_t, BaseDataType.int32_t).invoke_sI__sB_sI(arg1, arg2);
    }

    public static int invoke_sI__sI_sB_sI_sI(String name, int arg1, byte arg2, int arg3, int arg4) {
        return JnhwMh_sI__sI_sB_sI_sI.mandatoryOf(LIB_JNHW_POSIX_TEST_SYMBOL_LOOKUP, name, BaseDataType.int32_t, BaseDataType.int32_t, BaseDataType.int8_t, BaseDataType.int32_t, BaseDataType.int32_t).invoke_sI__sI_sB_sI_sI(arg1, arg2, arg3, arg4);
    }

    public static MemoryAddress invoke_MA___V(String name) {
        return JnhwMh_MA___V.mandatoryOf(LIB_JNHW_POSIX_TEST_SYMBOL_LOOKUP, name, BaseDataType.intptr_t).invoke_MA___V();
    }

    public static MemoryAddress invoke_MA___A_sI(String name, Addressable arg1, int arg2) {
        return JnhwMh_MA___A_sI.mandatoryOf(LIB_JNHW_POSIX_TEST_SYMBOL_LOOKUP, name, BaseDataType.uintptr_t, BaseDataType.uintptr_t, BaseDataType.int32_t).invoke_MA___A_sI(arg1, arg2);
    }

    public static long invoke_sL___V(String name) {
        return JnhwMh_sL___V.mandatoryOf(LIB_JNHW_POSIX_TEST_SYMBOL_LOOKUP, name, BaseDataType.int64_t).invoke_sL___V();
    }

    public static MemoryAddress invoke_MA___A(String name, Addressable arg1) {
        return JnhwMh_MA___A.mandatoryOf(LIB_JNHW_POSIX_TEST_SYMBOL_LOOKUP, name, BaseDataType.uintptr_t, BaseDataType.uintptr_t).invoke_MA___A(arg1);
    }

    public static Integer getClassIntegerDefine(String name) {
        try (MemorySession ms = MemorySession.openConfined()) {
            Int32_t value = Int32_t.allocateNative(ms);
            MemoryAddress result = invoke_MA___A("tryGetValueOf_" + name, value.toAddressable().address());
            if (MemoryAddress.NULL == result) {
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

    public static MemoryAddress getAdrDefine(String name) {
        return invoke_MA___V("getValueOf_" + name);
    }

    private LibJnhwPosixTestLoader() {
    }

    public static MemoryAddress tryGetAdrDefine(String name) {
        try (MemorySession ms = MemorySession.openConfined()) {
            IntPtr_t value = IntPtr_t.allocateNative(ms);
            MemoryAddress result = invoke_MA___A("tryGetValueOf_" + name, value.toAddressable().address());
            if (MemoryAddress.NULL == result) {
                return null;
            } else {
                return value.get();
            }
        }
    }

}
