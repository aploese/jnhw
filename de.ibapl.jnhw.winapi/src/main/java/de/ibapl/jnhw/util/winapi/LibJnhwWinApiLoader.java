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

import de.ibapl.jnhw.libloader.LoadResult;
import de.ibapl.jnhw.libloader.LoadState;
import de.ibapl.jnhw.libloader.NativeLibResolver;

/**
 *
 * @author aploese
 */
public final class LibJnhwWinApiLoader {

    public final static String LIB_JNHW_WINAPI = "jnhw-winapi";
    public final static int LIB_JNHW_WINAPI_VERSION = 0;
    private static LoadResult LIB_JNHW_WINAPI_LOAD_RESULT;
    private final static Object loadLock = new Object();
    private static LoadState state = LoadState.INIT;

    protected static void doSystemLoad(String absoluteLibName) {
        System.load(absoluteLibName);
    }

    private LibJnhwWinApiLoader() {
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
        LIB_JNHW_WINAPI_LOAD_RESULT = NativeLibResolver.loadNativeLib(LIB_JNHW_WINAPI, LIB_JNHW_WINAPI_VERSION, LibJnhwWinApiLoader::doSystemLoad);
        synchronized (loadLock) {
            if (LIB_JNHW_WINAPI_LOAD_RESULT.isLoaded()) {
                state = LoadState.SUCCESS;
            } else {
                state = LoadState.FAILURE;
            }
        }
        return state;
    }

    public static LoadResult getLoadResult() {
        return LIB_JNHW_WINAPI_LOAD_RESULT;
    }

}
