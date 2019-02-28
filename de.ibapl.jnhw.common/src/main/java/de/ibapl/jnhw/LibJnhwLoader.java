/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2019, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw;

import de.ibapl.jnhw.libloader.LoadResult;
import de.ibapl.jnhw.libloader.NativeLibLoader;

/**
 *
 * @author aploese
 */
public final class LibJnhwLoader {

    public final static String LIB_JNHW = "jnhw";
    public final static int LIB_JNHW_VERSION = 0;
    public final static String LIB_JNHW_COMMON = "jnhw-common";
    public final static int LIB_JNHW_COMMON_VERSION = 0;
    public final static LoadResult LIB_JNHW_COMMON_LOAD_RESULT;
    public final static LoadResult LIB_JNHW_LOAD_RESULT;

    protected static void doSystemLoad(String absoluteLibName) {
        System.load(absoluteLibName);
    }

    static {
        LIB_JNHW_COMMON_LOAD_RESULT = NativeLibLoader.loadNativeLib(LIB_JNHW_COMMON, LIB_JNHW_COMMON_VERSION, LibJnhwLoader::doSystemLoad);
        LIB_JNHW_LOAD_RESULT = NativeLibLoader.loadNativeLib(LIB_JNHW, LIB_JNHW_VERSION, LibJnhwLoader::doSystemLoad);
    }

    private LibJnhwLoader() {
    }

    public static boolean touch() {
        return LIB_JNHW_COMMON_LOAD_RESULT.isLoaded() && LIB_JNHW_LOAD_RESULT.isLoaded();
    }

}
