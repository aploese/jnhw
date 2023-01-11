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
package de.ibapl.jnhw.libloader;

import java.net.URL;

/**
 * The result with some information on how the native lib was loaded.
 *
 * @author aploese
 */
public class LoadResult {

    static LoadResult successFromLibraryPath(String libName, String systemLibName, String libFileName) {
        return new LoadResult(null, libName, systemLibName, null, libFileName, null);
    }

    static LoadResult successFromClassPath(MultiarchInfo multiarchInfo, String libName, String systemLibName, URL classPathLibURL) {
        return new LoadResult(multiarchInfo, libName, systemLibName, classPathLibURL, classPathLibURL.getFile(), null);
    }

    static LoadResult successFromTempCopy(MultiarchInfo multiarchInfo, String libName, String systemLibName, URL classPathLibURL, String libFileName) {
        return new LoadResult(multiarchInfo, libName, systemLibName, classPathLibURL, classPathLibURL.getFile(), null);
    }

    public static LoadResult fail(String libName, String systemLibName, Throwable loadError) {
        return new LoadResult(null, libName, systemLibName, null, null, loadError);
    }

    public static LoadResult fail(MultiarchInfo multiarchInfo, String libName, String systemLibName, Throwable loadError) {
        return new LoadResult(multiarchInfo, libName, systemLibName, null, null, loadError);
    }

    private LoadResult(MultiarchInfo multiarchInfo, String libName, String systemLibName, URL resourdeURL, String libFileName, Throwable loadError) {
        this.multiarchInfo = multiarchInfo;
        this.libName = libName;
        this.systemLibName = systemLibName;
        this.resourdeURL = resourdeURL;
        this.libFileName = libFileName;
        this.loadError = loadError;
    }

    public final MultiarchInfo multiarchInfo;
    public final String libName;
    public final String systemLibName;
    public final URL resourdeURL;
    public final String libFileName;
    public final Throwable loadError;

    public boolean isLoaded() {
        return loadError == null;
    }

    public boolean isError() {
        return loadError != null;
    }

}
