/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.posix.sys;

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;

/**
 * Wrapper around the {@code  <sys/stat.h>} header.
 *
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sys_stat.h.html">sys/stat.h
 * - data returned by the stat() function</a>.
 *
 * @author aploese
 */
@Include("#include <sys/stat.h>")
public class Stat {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    public final static native boolean HAVE_SYS_STAT_H();

    /**
     * <b>POSIX:</b> Read permission, group; <b>Numeric value:</b> 040.
     *
     * @return the native symbolic constant of S_IRGRP.
     */
    @Define
    public final static native int S_IRGRP();

    /**
     * <b>POSIX:</b> Read permission, others; <b>Numeric value:</b> 04.
     *
     * @return the native symbolic constant of S_IROTH.
     */
    @Define
    public final static native int S_IROTH();

    /**
     * <b>POSIX:</b> Read permission, owner; <b>Numeric value:</b> 0400.
     *
     * @return the native symbolic constant of S_IRUSR.
     */
    @Define
    public final static native int S_IRUSR();

    /**
     * <b>POSIX:</b> Read, write, execute/search by group; <b>Numeric value:</b>
     * 070.
     *
     * @return the native symbolic constant of S_IRWXG.
     */
    @Define
    public final static native int S_IRWXG();

    /**
     * <b>POSIX:</b> Read, write, execute/search by others; <b>Numeric
     * value:</b> 07.
     *
     * @return the native symbolic constant of S_IRWXO.
     */
    @Define
    public final static native int S_IRWXO();

    /**
     * <b>POSIX:</b> Read, write, execute/search by owner; <b>Numeric value:</b>
     * 0700.
     *
     * @return the native symbolic constant of S_IRWXU.
     */
    @Define
    public final static native int S_IRWXU();

    /**
     * <b>POSIX:</b> Set-group-ID on execution; <b>Numeric value:</b> 02000.
     *
     * @return the native symbolic constant of S_ISGID.
     */
    @Define
    public final static native int S_ISGID();

    /**
     * <b>POSIX:</b> Set-user-ID on execution; <b>Numeric value:</b> 04000.
     *
     * @return the native symbolic constant of S_ISUID.
     */
    @Define
    public final static native int S_ISUID();

    /**
     * <b>POSIX.XSI:</b> On directories, restricted deletion flag; <b>Numeric
     * value:</b> 01000.
     *
     * @return the native symbolic constant of S_ISVTX.
     */
    @Define
    public final static native int S_ISVTX();

    /**
     * <b>POSIX:</b> Write permission, group; <b>Numeric value:</b> 020.
     *
     * @return the native symbolic constant of S_IWGRP.
     */
    @Define
    public final static native int S_IWGRP();

    /**
     * <b>POSIX:</b> Write permission, others; <b>Numeric value:</b> 02.
     *
     * @return the native symbolic constant of S_IWOTH.
     */
    @Define
    public final static native int S_IWOTH();

    /**
     * <b>POSIX:</b> Write permission, owner; <b>Numeric value:</b> 0200.
     *
     * @return the native symbolic constant of S_IWUSR.
     */
    @Define
    public final static native int S_IWUSR();

    /**
     * <b>POSIX:</b> Execute/search permission, group; <b>Numeric value:</b>
     * 010.
     *
     * @return the native symbolic constant of S_IXGRP.
     */
    @Define
    public final static native int S_IXGRP();

    /**
     * <b>POSIX:</b> Execute/search permission, others; <b>Numeric value:</b>
     * 01.
     *
     * @return the native symbolic constant of S_IXOTH.
     */
    @Define
    public final static native int S_IXOTH();

    /**
     * <b>POSIX:</b> Execute/search permission, owner; <b>Numeric value:</b>
     * 0100.
     *
     * @return the native symbolic constant of S_IXUSR.
     */
    @Define
    public final static native int S_IXUSR();

    private Stat() {

    }

}
