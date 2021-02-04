/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2021, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
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
     *
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        LibJnhwPosixLoader.touch();

        HAVE_SYS_STAT_H = false;
        S_IRGRP = 0;
        S_IROTH = 0;
        S_IRUSR = 0;
        S_IRWXG = 0;
        S_IRWXO = 0;
        S_IRWXU = 0;
        S_ISGID = 0;
        S_ISUID = 0;
        S_ISVTX = 0;
        S_IWGRP = 0;
        S_IWOTH = 0;
        S_IWUSR = 0;
        S_IXGRP = 0;
        S_IXOTH = 0;
        S_IXUSR = 0;

        initFields();
    }

    private static native void initFields();

    public final static boolean HAVE_SYS_STAT_H;

    /**
     * <b>POSIX:</b> Read permission, group; <b>Numeric value:</b> 040.
     *
     */
    @Define
    public final static int S_IRGRP;

    /**
     * <b>POSIX:</b> Read permission, others; <b>Numeric value:</b> 04.
     *
     */
    @Define
    public final static int S_IROTH;

    /**
     * <b>POSIX:</b> Read permission, owner; <b>Numeric value:</b> 0400.
     *
     */
    @Define
    public final static int S_IRUSR;

    /**
     * <b>POSIX:</b> Read, write, execute/search by group; <b>Numeric value:</b>
     * 070.
     *
     */
    @Define
    public final static int S_IRWXG;

    /**
     * <b>POSIX:</b> Read, write, execute/search by others; <b>Numeric
     * value:</b> 07.
     *
     */
    @Define
    public final static int S_IRWXO;

    /**
     * <b>POSIX:</b> Read, write, execute/search by owner; <b>Numeric value:</b>
     * 0700.
     *
     */
    @Define
    public final static int S_IRWXU;

    /**
     * <b>POSIX:</b> Set-group-ID on execution; <b>Numeric value:</b> 02000.
     *
     */
    @Define
    public final static int S_ISGID;

    /**
     * <b>POSIX:</b> Set-user-ID on execution; <b>Numeric value:</b> 04000.
     *
     */
    @Define
    public final static int S_ISUID;

    /**
     * <b>POSIX.XSI:</b> On directories, restricted deletion flag; <b>Numeric
     * value:</b> 01000.
     *
     */
    @Define
    public final static int S_ISVTX;

    /**
     * <b>POSIX:</b> Write permission, group; <b>Numeric value:</b> 020.
     *
     */
    @Define
    public final static int S_IWGRP;

    /**
     * <b>POSIX:</b> Write permission, others; <b>Numeric value:</b> 02.
     *
     */
    @Define
    public final static int S_IWOTH;

    /**
     * <b>POSIX:</b> Write permission, owner; <b>Numeric value:</b> 0200.
     *
     */
    @Define
    public final static int S_IWUSR;

    /**
     * <b>POSIX:</b> Execute/search permission, group; <b>Numeric value:</b>
     * 010.
     *
     */
    @Define
    public final static int S_IXGRP;

    /**
     * <b>POSIX:</b> Execute/search permission, others; <b>Numeric value:</b>
     * 01.
     *
     */
    @Define
    public final static int S_IXOTH;

    /**
     * <b>POSIX:</b> Execute/search permission, owner; <b>Numeric value:</b>
     * 0100.
     *
     */
    @Define
    public final static int S_IXUSR;

    private Stat() {

    }

}
