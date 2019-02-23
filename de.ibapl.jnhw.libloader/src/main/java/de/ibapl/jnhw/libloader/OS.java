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
package de.ibapl.jnhw.libloader;

/**
 *
 * @author aploese
 */
public enum OS {
    LINUX("linux", "lib%1$s.so.%2$d"),
    WINDOWS("windows", "lib%1$s-%2$d.dll"),
    SOLARIS("solaris", "lib%1$s.so.%2$d"),
    FREE_BSD("freebsd", "lib%1$s.so.%2$d"),
    MAC_OS_X("macosx", "lib%1$s.%2$d.dylib");

    public final String osName;
    public final String formatLibNameString;

    private OS(String osName, String formatLibNameString) {
        this.osName = osName;
        this.formatLibNameString = formatLibNameString;
    }

    @Override
    public String toString() {
        return osName;
    }

    String formatLibName(String libName, int libToolInterfaceVersion) {
        return String.format(formatLibNameString, libName, libToolInterfaceVersion);
    }

}
