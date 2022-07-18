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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.IntPtr_t;
import de.ibapl.jnhw.libloader.LoadResult;
import de.ibapl.jnhw.libloader.LoadState;
import de.ibapl.jnhw.libloader.NativeLibResolver;
import java.lang.invoke.MethodHandle;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.incubator.foreign.Addressable;
import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.NativeSymbol;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SymbolLookup;
import jdk.incubator.foreign.ValueLayout;

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
    private final static CLinker C_LINKER = CLinker.systemCLinker();

    static {
        LibJnhwPosixTestLoader.touch();
    }

    protected static void doSystemLoad(String absoluteLibName) {
        System.load(absoluteLibName);
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
        LIB_JNHW_POSIX_TEST_LOAD_RESULT = NativeLibResolver.loadNativeLib(LIB_JNHW_POSIX_TEST, LIB_JNHW_POSIX_TEST_VERSION, LibJnhwPosixTestLoader::doSystemLoad);
        synchronized (loadLock) {
            if (LIB_JNHW_POSIX_TEST_LOAD_RESULT.isLoaded()) {
                state = LoadState.SUCCESS;
            } else {
                state = LoadState.FAILURE;
            }
        }
        return state;
    }

    private static MethodHandle downcallHandle(String name, FunctionDescriptor function) throws NoSuchNativeMethodException {
        SymbolLookup loaderLookup = SymbolLookup.loaderLookup();
        try {
            NativeSymbol ns = loaderLookup.lookup(name).orElseThrow(() -> {
                return new NoSuchNativeMethodException(name);
            });
            return C_LINKER.downcallHandle(ns, function);
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, "d.i.j.p.LibJnhwPosixTestLoader.downcallHandle(\"" + name + "\")", t);
            throw t;
        }
    }

    public static byte invokeExact_Byte_V(String name) {
        try {
            final MethodHandle handle = downcallHandle(name, FunctionDescriptor.of(ValueLayout.JAVA_BYTE));
            return (byte) handle.invokeExact();
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, "d.i.j.p.LibJnhwPosixTestLoader.invokeExact_Byte_V(\"" + name + "\")", t);
            throw new RuntimeException(t);
        }
    }

    public static short invokeExact_Short_V(String name) {
        try {
            final MethodHandle handle = downcallHandle(name, FunctionDescriptor.of(ValueLayout.JAVA_SHORT));
            return (short) handle.invokeExact();
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, "d.i.j.p.LibJnhwPosixTestLoader.invokeExact_Short_V(\"" + name + "\")", t);
            throw new RuntimeException(t);
        }
    }

    public static boolean invokeExact_CharToBool_V(String name) {
        try {
            final MethodHandle handle = downcallHandle(name, FunctionDescriptor.of(ValueLayout.JAVA_BYTE));
            return ((byte) handle.invokeExact()) != 0;
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, "d.i.j.p.LibJnhwPosixTestLoader.invokeExact_CharToBool_V(\"" + name + "\")", t);
            throw new RuntimeException(t);
        }
    }

    public static boolean invokeExact_CharToBool_Adr(String name, Addressable adr) {
        try {
            final MethodHandle handle = downcallHandle(name, FunctionDescriptor.of(ValueLayout.JAVA_BYTE, ValueLayout.ADDRESS));
            return ((byte) handle.invokeExact(adr)) != 0;
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, "d.i.j.p.LibJnhwPosixTestLoader.invokeExact_CharToBool_Adr(\"" + name + "\")", t);
            throw new RuntimeException(t);
        }
    }

    public static int invokeExact_Int_V(String name) {
        try {
            final MethodHandle handle = downcallHandle(name, FunctionDescriptor.of(ValueLayout.JAVA_INT));
            return (int) handle.invokeExact();
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, "d.i.j.p.LibJnhwPosixTestLoader.invokeExact_Int_V(\"" + name + "\")", t);
            throw new RuntimeException(t);
        }
    }

    public static int invokeExact_Int_Byte_Int(String name, byte arg1, int arg2) {
        try {
            final MethodHandle handle = downcallHandle(name, FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_BYTE, ValueLayout.JAVA_INT));
            return (int) handle.invokeExact(arg1, arg2);
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, "d.i.j.p.LibJnhwPosixTestLoader.invokeExact_Int_Byte_Int(\"" + name + "\")", t);
            throw new RuntimeException(t);
        }
    }

    public static int invokeExact_Int_Int_Byte_Int_Int(String name, int arg1, byte arg2, int arg3, int arg4) {
        try {
            final MethodHandle handle = downcallHandle(name, FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_BYTE, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
            return (int) handle.invokeExact(arg1, arg2, arg3, arg4);
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, "d.i.j.p.LibJnhwPosixTestLoader.invokeExact_Int_Byte_Int(\"" + name + "\")", t);
            throw new RuntimeException(t);
        }
    }

    public static MemoryAddress invokeExact_Adr_V(String name) {
        try {
            final MethodHandle handle = downcallHandle(name, FunctionDescriptor.of(ValueLayout.ADDRESS));
            return (MemoryAddress) handle.invokeExact();
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, "d.i.j.p.LibJnhwPosixTestLoader.invokeExact_Adr_V(\"" + name + "\")", t);
            throw new RuntimeException(t);
        }
    }

    public static MemoryAddress invokeExact_MA___A_sI(String name, Addressable arg1, int arg2) {
        try {
            final MethodHandle handle = downcallHandle(name, FunctionDescriptor.of(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT));
            return (MemoryAddress) handle.invokeExact(arg1, arg2);
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, "d.i.j.p.LibJnhwPosixTestLoader.invokeExact_Adr_Adr_Int(\"" + name + "\")", t);
            throw new RuntimeException(t);
        }
    }

    public static long invokeExact_Long_V(String name) {
        try {
            final MethodHandle handle = downcallHandle(name, FunctionDescriptor.of(ValueLayout.JAVA_LONG));
            return (long) handle.invokeExact();
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, "d.i.j.p.LibJnhwPosixTestLoader.invokeExact_Long_V(\"" + name + "\")", t);
            throw new RuntimeException(t);
        }
    }

    public static MemoryAddress invokeExact_Adr_Adr(String name, Addressable address) {
        try {
            final MethodHandle handle = downcallHandle(name, FunctionDescriptor.of(ValueLayout.ADDRESS, ValueLayout.ADDRESS));
            return (MemoryAddress) handle.invokeExact(address);
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, "d.i.j.p.LibJnhwPosixTestLoader.invokeExact_Adr_Adr(\"" + name + "\")", t);
            throw new RuntimeException(t);
        }
    }

    public static Integer getClassIntegerDefine(String name) {
        try ( ResourceScope scope = ResourceScope.newConfinedScope()) {
            Int32_t value = Int32_t.allocateNative(scope);
            MemoryAddress result = LibJnhwPosixTestLoader.invokeExact_Adr_Adr("tryGetValueOf_" + name, value.toAddressable().address());
            if (MemoryAddress.NULL == result) {
                return null;
            } else {
                return value.int32_t();
            }
        }
    }

    public static int getByteDefine(String name) {
        return LibJnhwPosixTestLoader.invokeExact_Byte_V("getValueOf_" + name);
    }

    public static int getShortDefine(String name) {
        return LibJnhwPosixTestLoader.invokeExact_Short_V("getValueOf_" + name);
    }

    public static int getIntDefine(String name) {
        return LibJnhwPosixTestLoader.invokeExact_Int_V("getValueOf_" + name);
    }

    public static long getLongDefine(String name) {
        return LibJnhwPosixTestLoader.invokeExact_Long_V("getValueOf_" + name);
    }

    public static MemoryAddress getAdrDefine(String name) {
        return LibJnhwPosixTestLoader.invokeExact_Adr_V("getValueOf_" + name);
    }

    private LibJnhwPosixTestLoader() {
    }

    public static MemoryAddress tryGetAdrDefine(String name) {
        try ( ResourceScope scope = ResourceScope.newConfinedScope()) {
            IntPtr_t value = IntPtr_t.allocateNative(scope);
            MemoryAddress result = LibJnhwPosixTestLoader.invokeExact_Adr_Adr("tryGetValueOf_" + name, value.toAddressable().address());
            if (MemoryAddress.NULL == result) {
                return null;
            } else {
                return value.get();
            }
        }
    }

}
