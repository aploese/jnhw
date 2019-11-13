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
/**
 * Very thin and safe wrapper classes around common used headers on a ISOC/POSIX/UNIX/Linux system.
 * <p>
 * A note to the markers used for the native symbolic constants and functions:
 * <ul>
 * <li>
 * <b>POSIX:</b> its a POSIX standard
 * </li><li>
 * <b>POSIX.ADV:</b> its an optional POSIX standard, <a href="https://pubs.opengroup.org/onlinepubs/9699919799/help/codes.html#ADV">ADV</a>.
 * </li><li>
 * <b>POSIX.SOI:</b> its an optional POSIX standard, <a href="https://pubs.opengroup.org/onlinepubs/9699919799/help/codes.html#SOI">SOI</a>.
 * </li><li>
 * <b>POSIX.XSI:</b> its an optional POSIX standard, <a href="https://pubs.opengroup.org/onlinepubs/9699919799/help/codes.html#XSI">XSI</a>.
 * </li><li>
 * <b>Non POSIX:</b> its not a POSIX standard, but its available on all plattforms.
 * </li><li>
 * <b>ISOC:</b> its an Iso C standard.
 * </li><li>
 * <b>Linux:</b> its Linux.
 * </li>
 * </ul>
 * </p>
 * 
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/">The Open Group Base Specifications Issue 7, 2018 edition
 *   IEEE Std 1003.1-2017 (Revision of IEEE Std 1003.1-2008)
 *   Copyright © 2001-2018 IEEE and The Open Group</a>.
 * 
 */
module de.ibapl.jnhw.posix {
    requires java.logging;

    requires transitive de.ibapl.jnhw.common;

    exports de.ibapl.jnhw.isoc;
    exports de.ibapl.jnhw.util.posix;
    exports de.ibapl.jnhw.unix.sys;
    exports de.ibapl.jnhw.posix;
    exports de.ibapl.jnhw.linux.sys;

}
