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


/**
 *
 * @author aploese
 */
public abstract class LibJnhwPosixLoader extends LibJnhwLoader {
    
    public final static String LIB_JNHW_POSIX = "jnhw-posix";
    public final static int LIB_JNHW_POSIX_VERSION = 0;

    public static boolean isLibJnhwPosixLoaded() {
            return LibJnhwLoader.isLibJnhwLoaded() && NativeLibLoader.isLibLoaded(LIB_JNHW_POSIX);
    }

    public static String getLibJnhwPosixLoadedName() {
        return NativeLibLoader.getLibLoadedName(LIB_JNHW_POSIX);
    }

    

    static {
        loadLibJnhwPosix();
    }

    public final static void loadLibJnhwPosix() {
        NativeLibLoader.loadNativeLib(LIB_JNHW_POSIX, LIB_JNHW_POSIX_VERSION);
    }

    public static Throwable getLoadException() {
        if (LibJnhwLoader.isLibJnhwLoaded()) {
            return NativeLibLoader.getLoadError(LIB_JNHW_POSIX);
        } else {
            return LibJnhwLoader.getLoadException();
        }
    }

    protected LibJnhwPosixLoader() {
    }

}
