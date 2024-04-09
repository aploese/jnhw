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
package de.ibapl.jnhw.common.util.jni;

import de.ibapl.jnhw.libloader.Arch;
import de.ibapl.jnhw.libloader.LoadResult;
import de.ibapl.jnhw.libloader.NativeLibResolver;
import de.ibapl.jnhw.libloader.OS;
import java.lang.foreign.Arena;

/**
 *
 * @author aploese
 */
public class LibJnhwCommon {

    public final static String LIB_JNHW_COMMON = "jnhw-common";
    public final static int LIB_JNHW_COMMON_VERSION = 4;

    private final static Arena LIB_JNHW_COMMON_MEMORY_ARENA = Arena.ofShared();

    private static LoadResult LIB_JNHW_COMMON_LOAD_RESULT;

    static {
        if (NativeLibResolver.getOS() == OS.LINUX && NativeLibResolver.getArch() == Arch.X86_64) {
            //TODO Force loading? - for nativeProvider.propertyName
        } else {
            LIB_JNHW_COMMON_LOAD_RESULT = NativeLibResolver.loadNativeLib(LIB_JNHW_COMMON, LIB_JNHW_COMMON_VERSION, LibJnhwCommon::doSystemLoad);
        }
    }

    protected static void doSystemLoad(String absoluteLibName) {
        System.load(absoluteLibName);
    }

    public static LoadResult getLoadResult() {
        return LIB_JNHW_COMMON_LOAD_RESULT;
    }

    public static LoadResult touch() {
        return LIB_JNHW_COMMON_LOAD_RESULT;
    }

    public static Arena arena() {
        return LIB_JNHW_COMMON_MEMORY_ARENA;
    }

}
