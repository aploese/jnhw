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
package de.ibapl.jnhw.posix.sys;

import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;

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

    public static interface BsdDefines {

        public final static int S_IRWXU = 00700;
        public final static int S_IRUSR = 00400;
        public final static int S_IWUSR = 00200;
        public final static int S_IXUSR = 00100;

        public final static int S_IRWXG = 00070;
        public final static int S_IRGRP = 00040;
        public final static int S_IWGRP = 00020;
        public final static int S_IXGRP = 00010;

        public final static int S_IRWXO = 00007;
        public final static int S_IROTH = 00004;
        public final static int S_IWOTH = 00002;
        public final static int S_IXOTH = 00001;

        public final static int S_ISUID = 0004000;
        public final static int S_ISGID = 0002000;
        public final static int S_ISVTX = 0001000;

        //TODO dummy values
        public final static int S_IFMT = 0;
        public final static int S_IFBLK = 0;
        public final static int S_IFCHR = 0;
        public final static int S_IFIFO = 0;
        public final static int S_IFREG = 0;
        public final static int S_IFDIR = 0;
        public final static int S_IFLNK = 0;
        public final static int S_IFSOCK = 0;
    }

    public static interface FreeBsdDefines extends BsdDefines {

    }

    public static interface LinuxDefines {

        public final static int S_IFMT = 00170000;
        public final static int S_IFBLK = 0060000;
        public final static int S_IFCHR = 0020000;
        public final static int S_IFIFO = 0010000;
        public final static int S_IFREG = 0100000;
        public final static int S_IFDIR = 0040000;
        public final static int S_IFLNK = 0120000;
        public final static int S_IFSOCK = 0140000;

        public final static int S_ISUID = 0004000;
        public final static int S_ISGID = 0002000;
        public final static int S_ISVTX = 0001000;

        public final static int S_IRWXU = 00700;
        public final static int S_IRUSR = 00400;
        public final static int S_IWUSR = 00200;
        public final static int S_IXUSR = 00100;

        public final static int S_IRWXG = 00070;
        public final static int S_IRGRP = 00040;
        public final static int S_IWGRP = 00020;
        public final static int S_IXGRP = 00010;

        public final static int S_IRWXO = 00007;
        public final static int S_IROTH = 00004;
        public final static int S_IWOTH = 00002;
        public final static int S_IXOTH = 00001;

    }

    public static interface OpenBsdDefines extends BsdDefines {

    }

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

    /**
     * <b>POSIX.XSI:</b> Type of file.
     *
     */
    @Define
    public final static int S_IFMT;

    /**
     * <b>POSIX.XSI:</b> Block special.
     *
     */
    @Define
    public final static int S_IFBLK;

    /**
     * <b>POSIX.XSI:</b> Character special.
     *
     */
    @Define
    public final static int S_IFCHR;

    /**
     * <b>POSIX.XSI:</b> FIFO special.
     *
     */
    @Define
    public final static int S_IFIFO;

    /**
     * <b>POSIX.XSI:</b> Regular.
     *
     */
    @Define
    public final static int S_IFREG;

    /**
     * <b>POSIX.XSI:</b> Directory.
     *
     */
    @Define
    public final static int S_IFDIR;

    /**
     * <b>POSIX.XSI:</b> Symbolic link.
     *
     */
    @Define
    public final static int S_IFLNK;

    /**
     * <b>POSIX.XSI:</b> Socket.
     *
     */
    @Define
    public final static int S_IFSOCK;

    /**
     *
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX:
                HAVE_SYS_STAT_H = true;
                S_IFMT = LinuxDefines.S_IFMT;
                S_IFBLK = LinuxDefines.S_IFBLK;
                S_IFCHR = LinuxDefines.S_IFCHR;
                S_IFIFO = LinuxDefines.S_IFIFO;
                S_IFREG = LinuxDefines.S_IFREG;
                S_IFDIR = LinuxDefines.S_IFDIR;
                S_IFLNK = LinuxDefines.S_IFLNK;
                S_IFSOCK = LinuxDefines.S_IFSOCK;

                S_IRGRP = LinuxDefines.S_IRGRP;
                S_IROTH = LinuxDefines.S_IROTH;
                S_IRUSR = LinuxDefines.S_IRUSR;
                S_IRWXG = LinuxDefines.S_IRWXG;
                S_IRWXO = LinuxDefines.S_IRWXO;
                S_IRWXU = LinuxDefines.S_IRWXU;
                S_ISGID = LinuxDefines.S_ISGID;
                S_ISUID = LinuxDefines.S_ISUID;
                S_ISVTX = LinuxDefines.S_ISVTX;
                S_IWGRP = LinuxDefines.S_IWGRP;
                S_IWOTH = LinuxDefines.S_IWOTH;
                S_IWUSR = LinuxDefines.S_IWUSR;
                S_IXGRP = LinuxDefines.S_IXGRP;
                S_IXOTH = LinuxDefines.S_IXOTH;
                S_IXUSR = LinuxDefines.S_IXUSR;

                break;
            case DARWIN:
            case FREE_BSD:
            case OPEN_BSD:
                HAVE_SYS_STAT_H = true;
                S_IFMT = BsdDefines.S_IFMT;
                S_IFBLK = BsdDefines.S_IFBLK;
                S_IFCHR = BsdDefines.S_IFCHR;
                S_IFIFO = BsdDefines.S_IFIFO;
                S_IFREG = BsdDefines.S_IFREG;
                S_IFDIR = BsdDefines.S_IFDIR;
                S_IFLNK = BsdDefines.S_IFLNK;
                S_IFSOCK = BsdDefines.S_IFSOCK;

                S_IRGRP = BsdDefines.S_IRGRP;
                S_IROTH = BsdDefines.S_IROTH;
                S_IRUSR = BsdDefines.S_IRUSR;
                S_IRWXG = BsdDefines.S_IRWXG;
                S_IRWXO = BsdDefines.S_IRWXO;
                S_IRWXU = BsdDefines.S_IRWXU;
                S_ISGID = BsdDefines.S_ISGID;
                S_ISUID = BsdDefines.S_ISUID;
                S_ISVTX = BsdDefines.S_ISVTX;
                S_IWGRP = BsdDefines.S_IWGRP;
                S_IWOTH = BsdDefines.S_IWOTH;
                S_IWUSR = BsdDefines.S_IWUSR;
                S_IXGRP = BsdDefines.S_IXGRP;
                S_IXOTH = BsdDefines.S_IXOTH;
                S_IXUSR = BsdDefines.S_IXUSR;
                break;
            default:
                throw new NoClassDefFoundError("No sys/stat.h defines for " + MultiarchTupelBuilder.getMultiarch());
        }
    }

    private Stat() {

    }

}
