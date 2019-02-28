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
package de.ibapl.jnhw.util.winapi;

import de.ibapl.jnhw.LibJnhwLoader;
import de.ibapl.jnhw.libloader.LoadResult;
import de.ibapl.jnhw.libloader.NativeLibLoader;

/**
 *
 * @author aploese
 */
public final class LibJnhwWinApiLoader {

    public final static String LIB_JNHW_WINAPI = "jnhw-winapi";
    public final static int LIB_JNHW_WINAPI_VERSION = 0;
    public final static LoadResult LIB_JNHW_WINAPI_LOAD_RESULT;

    protected static void doSystemLoad(String absoluteLibName) {
        System.load(absoluteLibName);
    }

    /**
     * Here the lib is loaded any exceptions are not thrown ar class load time
     */
    static {
        LibJnhwLoader.touch();
        LIB_JNHW_WINAPI_LOAD_RESULT = NativeLibLoader.loadNativeLib(LIB_JNHW_WINAPI, LIB_JNHW_WINAPI_VERSION, LibJnhwWinApiLoader::doSystemLoad);
    }

    private LibJnhwWinApiLoader() {
    }

    /**
     * Make sure the native lib is loaded
     *
     * @return true if loaded
     */
    public static boolean touch() {
        return LIB_JNHW_WINAPI_LOAD_RESULT.isLoaded();
    }
}
