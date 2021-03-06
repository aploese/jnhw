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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.posix.sys.Stat;
import de.ibapl.jnhw.annotation.posix.sys.types.mode_t;
import de.ibapl.jnhw.annotation.posix.sys.types.off64_t;
import de.ibapl.jnhw.annotation.posix.sys.types.off_t;
import de.ibapl.jnhw.common.util.IntDefine;
import de.ibapl.jnhw.libloader.MultiarchInfo;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;

/**
 * Wrapper around the {@code <fcntl.h>} header.
 *
 * <p>
 * <b>Todo:</b> struct flock, flock64
 * </p>
 *
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/fcntl.h.html">fcntl.h
 * - file control options</a>.
 *
 * @author aploese
 */
@Include("#include <fcntl.h>")
public final class Fcntl {

    public static interface LinuxDefines {

        public final static int AT_EACCESS = 0x200;
        public final static int AT_FDCWD = -100;
        public final static int AT_REMOVEDIR = 0x200;
        public final static int AT_SYMLINK_FOLLOW = 0x400;
        public final static int AT_SYMLINK_NOFOLLOW = 0x100;
        public final static int FD_CLOEXEC = 1;
        public final static int F_DUPFD = 0;
        public final static int F_DUPFD_CLOEXEC = 1030;
        public final static int F_GETFD = 1;
        public final static int F_GETFL = 3;
        public final static int F_RDLCK = 0;
        public final static int F_SETFD = 2;
        public final static int F_SETFL = 4;
        public final static int F_SETLK = 6;
        public final static int F_SETLKW = 7;
        public final static int F_UNLCK = 2;
        public final static int F_WRLCK = 1;
        public final static int O_ACCMODE = 0003;
        public final static int O_CLOEXEC = 02000000;
        public final static int O_RDONLY = 00;
        public final static int O_RDWR = 02;
        public final static int O_TRUNC = 01000;
        public final static int O_WRONLY = 01;
        public final static int POSIX_FADV_NORMAL = 0;
        public final static int POSIX_FADV_RANDOM = 1;
        public final static int POSIX_FADV_SEQUENTIAL = 2;
        public final static int POSIX_FADV_WILLNEED = 3;
    }

    public static interface Linux_I386_Defines {

        public final static int O_LARGEFILE = 0100000;
    }

    public static interface Linux_Arm_Defines {

        public final static int O_LARGEFILE = 0400000;
    }

    public static interface Linux_Mips_Defines {

        public final static int O_LARGEFILE = 020000;
    }

    public static interface Linux_Aarch64_Mips64_Ppc64_RiscV64_S390_X86_64_Defines {

        public final static int O_LARGEFILE = 0;
    }

    public static interface Linux_NonMips_Defines {

        public final static int F_GETLK = 5;
        public final static int F_GETOWN = 9;
        public final static int F_SETOWN = 8;
        public final static int O_APPEND = 02000;
        public final static int O_ASYNC = 020000;
        public final static int O_CREAT = 0100;
        public final static int O_DSYNC = 010000;
        public final static int O_EXCL = 0200;
        public final static int O_FSYNC = 04010000;
        public final static int O_NOCTTY = 0400;
        public final static int O_NONBLOCK = 04000;
        public final static int O_RSYNC = 04010000;
        public final static int O_SYNC = 04010000;
    }

    public static interface Linux_Aarch64_Arm_Defines {

        public final static int O_DIRECTORY = 040000;
        public final static int O_NOFOLLOW = 0100000;
    }

    public static interface Linux_Ppc64_Defines {

        public final static int O_DIRECTORY = 040000;
        public final static int O_NOFOLLOW = 0100000;
    }

    public static interface Linux_S390_Defines {

        public final static int POSIX_FADV_DONTNEED = 6;
        public final static int POSIX_FADV_NOREUSE = 7;

    }

    public static interface Linux_NonS390_Defines {

        public final static int POSIX_FADV_DONTNEED = 4;
        public final static int POSIX_FADV_NOREUSE = 5;

    }

    public static interface Linux_RiscV64_S390_Defines {

        public final static int O_DIRECTORY = 65536;
        public final static int O_NOFOLLOW = 131072;
    }

    public static interface Linux_I386_X86_64_Defines {

        public final static int O_DIRECTORY = 0200000;
        public final static int O_NOFOLLOW = 0400000;
    }

    public static interface Linux_Mips_Mips64_Defines {

        public final static int F_GETLK = 14;
        public final static int F_GETOWN = 23;
        public final static int F_SETOWN = 24;
        public final static int O_APPEND = 010;
        public final static int O_ASYNC = 010000;
        public final static int O_CREAT = 0400;
        public final static int O_DSYNC = 020;
        public final static int O_EXCL = 02000;
        public final static int O_FSYNC = 040020;
        public final static int O_NOCTTY = 04000;
        public final static int O_NONBLOCK = 0200;
        public final static int O_RSYNC = 040020;
        public final static int O_SYNC = 040020;

        public final static int O_DIRECTORY = 0200000;
        public final static int O_NOFOLLOW = 0400000;
    }

    public static interface BsdDefines {

        public final static int FD_CLOEXEC = 1;
        public final static int F_DUPFD = 0;
        public final static int F_GETFD = 1;
        public final static int F_GETFL = 3;
        public final static int F_RDLCK = 1;
        public final static int F_SETFD = 2;
        public final static int F_SETFL = 4;
        public final static int F_UNLCK = 2;
        public final static int F_WRLCK = 3;
        public final static int O_ACCMODE = 0003;
        public final static int O_RDONLY = 00;
        public final static int O_RDWR = 02;
        public final static int O_TRUNC = 1024;
        public final static int O_WRONLY = 01;

        public final static int F_GETOWN = 5;
        public final static int F_SETOWN = 6;
        public final static int O_APPEND = 8;
        public final static int O_ASYNC = 64;
        public final static int O_CREAT = 512;
        public final static int O_FSYNC = 128;
        public final static int O_NONBLOCK = 4;
        public final static int O_SYNC = 128;
        public final static int O_NOFOLLOW = 256;
    }

    public static interface DarwinDefines extends BsdDefines {

        public final static int AT_FDCWD = -2;
        public final static int AT_EACCESS = 16;
        public final static int AT_REMOVEDIR = 128;
        public final static int AT_SYMLINK_FOLLOW = 64;
        public final static int AT_SYMLINK_NOFOLLOW = 32;
        public final static int F_DUPFD_CLOEXEC = 67;
        public final static int F_GETLK = 7;
        public final static int F_SETLK = 8;
        public final static int F_SETLKW = 9;
        public final static int O_CLOEXEC = 16777216;
        public final static int O_DSYNC = 4194304;
        public final static int O_EXCL = 2048;
        public final static int O_DIRECTORY = 1048576;
        public final static int O_NOCTTY = 131072;

    }

    public static interface FreeBsdDefines extends BsdDefines {

        public final static int AT_FDCWD = -100;
        public final static int AT_EACCESS = 256;
        public final static int AT_REMOVEDIR = 2048;
        public final static int AT_SYMLINK_FOLLOW = 0x400;
        public final static int AT_SYMLINK_NOFOLLOW = 512;
        public final static int F_DUPFD_CLOEXEC = 17;
        public final static int F_GETLK = 11;
        public final static int F_SETLK = 12;
        public final static int F_SETLKW = 13;
        public final static int O_CLOEXEC = 1048576;
        public final static int O_EXEC = 262144;
        public final static int O_DSYNC = 16777216;
        public final static int O_EXCL = 2048;
        public final static int O_SEARCH = 262144;
        public final static int O_TTY_INIT = 524288;
        public final static int POSIX_FADV_DONTNEED = 4;
        public final static int POSIX_FADV_NOREUSE = 5;
        public final static int POSIX_FADV_NORMAL = 0;
        public final static int POSIX_FADV_RANDOM = 1;
        public final static int POSIX_FADV_SEQUENTIAL = 2;
        public final static int POSIX_FADV_WILLNEED = 3;
        public final static int O_DIRECTORY = 131072;
        public final static int O_NOCTTY = 32768;

    }

    public static interface OpenBsdDefines extends BsdDefines {

        public final static int AT_FDCWD = -100;
        public final static int AT_EACCESS = 1;
        public final static int AT_REMOVEDIR = 8;
        public final static int AT_SYMLINK_FOLLOW = 4;
        public final static int AT_SYMLINK_NOFOLLOW = 2;
        public final static int F_DUPFD_CLOEXEC = 10;
        public final static int F_GETLK = 7;
        public final static int F_SETLK = 8;
        public final static int F_SETLKW = 9;
        public final static int O_CLOEXEC = 65536;
        public final static int O_DSYNC = 128;
        public final static int O_EXCL = 2048;
        public final static int O_RSYNC = 128;
        public final static int O_DIRECTORY = 131072;
        public final static int O_NOCTTY = 32768;

    }

    public static interface Defines_LINUX_ARM extends LinuxDefines, Linux_NonMips_Defines, Linux_Aarch64_Arm_Defines, Linux_Arm_Defines {

    }

    public static interface Defines_LINUX_ARM64 extends LinuxDefines, Linux_NonMips_Defines, Linux_Aarch64_Arm_Defines, Linux_Aarch64_Mips64_Ppc64_RiscV64_S390_X86_64_Defines {

    }

    public static interface Defines_LINUX_I386 extends LinuxDefines, Linux_NonMips_Defines, Linux_I386_X86_64_Defines, Linux_I386_Defines {

    }

    public static interface Defines_LINUX_X86_64 extends LinuxDefines, Linux_NonMips_Defines, Linux_I386_X86_64_Defines, Linux_Aarch64_Mips64_Ppc64_RiscV64_S390_X86_64_Defines {

    }

    public static interface Defines_LINUX_MIPS extends LinuxDefines, Linux_Mips_Mips64_Defines, Linux_Mips_Defines {

    }

    public static interface Defines_LINUX_MIPS64 extends LinuxDefines, Linux_Mips_Mips64_Defines, Linux_Aarch64_Mips64_Ppc64_RiscV64_S390_X86_64_Defines {

    }

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

        final MultiarchInfo multiarchInfo = LibJnhwPosixLoader.getLoadResult().multiarchInfo;

        SEEK_CUR = Stdio.SEEK_CUR;
        SEEK_END = Stdio.SEEK_END;
        SEEK_SET = Stdio.SEEK_SET;

        switch (multiarchInfo.getOS()) {
            case LINUX:
                HAVE_FCNTL_H = true;

                AT_EACCESS = LinuxDefines.AT_EACCESS;
                AT_FDCWD = LinuxDefines.AT_FDCWD;
                AT_REMOVEDIR = LinuxDefines.AT_REMOVEDIR;
                AT_SYMLINK_FOLLOW = LinuxDefines.AT_SYMLINK_FOLLOW;
                AT_SYMLINK_NOFOLLOW = LinuxDefines.AT_SYMLINK_NOFOLLOW;

                FD_CLOEXEC = LinuxDefines.FD_CLOEXEC;

                F_DUPFD = LinuxDefines.F_DUPFD;
                F_DUPFD_CLOEXEC = LinuxDefines.F_DUPFD_CLOEXEC;
                F_GETFD = LinuxDefines.F_GETFD;
                F_GETFL = LinuxDefines.F_GETFL;
                F_RDLCK = LinuxDefines.F_RDLCK;
                F_SETFD = LinuxDefines.F_SETFD;
                F_SETFL = LinuxDefines.F_SETFL;
                F_SETLK = LinuxDefines.F_SETLK;
                F_SETLKW = LinuxDefines.F_SETLKW;
                F_UNLCK = LinuxDefines.F_UNLCK;
                F_WRLCK = LinuxDefines.F_WRLCK;

                O_ACCMODE = LinuxDefines.O_ACCMODE;
                O_CLOEXEC = LinuxDefines.O_CLOEXEC;
                O_EXEC = IntDefine.UNDEFINED;
                O_RDONLY = LinuxDefines.O_RDONLY;
                O_RDWR = LinuxDefines.O_RDWR;
                O_SEARCH = IntDefine.UNDEFINED;
                O_TRUNC = LinuxDefines.O_TRUNC;
                O_TTY_INIT = IntDefine.UNDEFINED;
                O_WRONLY = LinuxDefines.O_WRONLY;

                POSIX_FADV_NORMAL = IntDefine.toIntDefine(LinuxDefines.POSIX_FADV_NORMAL);
                POSIX_FADV_RANDOM = IntDefine.toIntDefine(LinuxDefines.POSIX_FADV_RANDOM);
                POSIX_FADV_SEQUENTIAL = IntDefine.toIntDefine(LinuxDefines.POSIX_FADV_SEQUENTIAL);
                POSIX_FADV_WILLNEED = IntDefine.toIntDefine(LinuxDefines.POSIX_FADV_WILLNEED);

                switch (multiarchInfo.getArch()) {
                    case S390_X:
                        POSIX_FADV_DONTNEED = IntDefine.toIntDefine(Linux_S390_Defines.POSIX_FADV_DONTNEED);
                        POSIX_FADV_NOREUSE = IntDefine.toIntDefine(Linux_S390_Defines.POSIX_FADV_NOREUSE);
                        break;
                    default:
                        POSIX_FADV_DONTNEED = IntDefine.toIntDefine(Linux_NonS390_Defines.POSIX_FADV_DONTNEED);
                        POSIX_FADV_NOREUSE = IntDefine.toIntDefine(Linux_NonS390_Defines.POSIX_FADV_NOREUSE);
                }

                switch (multiarchInfo.getArch()) {
                    case AARCH64:
                    case MIPS_64:
                    case POWER_PC_64:
                    case RISC_V_64:
                    case S390_X:
                    case X86_64:
                        O_LARGEFILE = IntDefine.toIntDefine(Linux_Aarch64_Mips64_Ppc64_RiscV64_S390_X86_64_Defines.O_LARGEFILE);
                        break;
                    case ARM:
                        O_LARGEFILE = IntDefine.toIntDefine(Linux_Arm_Defines.O_LARGEFILE);
                        break;
                    case I386:
                        O_LARGEFILE = IntDefine.toIntDefine(Linux_I386_Defines.O_LARGEFILE);
                        break;
                    case MIPS:
                        O_LARGEFILE = IntDefine.toIntDefine(Linux_Mips_Defines.O_LARGEFILE);
                        break;
                    default:
                        throw new NoClassDefFoundError("No fcntl.h defines for " + multiarchInfo);
                }

                switch (multiarchInfo.getArch()) {
                    case MIPS:
                    case MIPS_64:
                        F_GETLK = Linux_Mips_Mips64_Defines.F_GETLK;
                        F_GETOWN = Linux_Mips_Mips64_Defines.F_GETOWN;
                        F_SETOWN = Linux_Mips_Mips64_Defines.F_SETOWN;
                        O_APPEND = Linux_Mips_Mips64_Defines.O_APPEND;
                        O_ASYNC = IntDefine.toIntDefine(Linux_Mips_Mips64_Defines.O_ASYNC);
                        O_CREAT = Linux_Mips_Mips64_Defines.O_CREAT;
                        O_DSYNC = Linux_Mips_Mips64_Defines.O_DSYNC;
                        O_EXCL = Linux_Mips_Mips64_Defines.O_EXCL;
                        O_FSYNC = IntDefine.toIntDefine(Linux_Mips_Mips64_Defines.O_FSYNC);
                        O_NOCTTY = Linux_Mips_Mips64_Defines.O_NOCTTY;
                        O_NONBLOCK = Linux_Mips_Mips64_Defines.O_NONBLOCK;
                        O_RSYNC = IntDefine.toIntDefine(Linux_Mips_Mips64_Defines.O_RSYNC);
                        O_SYNC = Linux_Mips_Mips64_Defines.O_SYNC;

                        break;
                    default:
                        F_GETLK = Linux_NonMips_Defines.F_GETLK;
                        F_GETOWN = Linux_NonMips_Defines.F_GETOWN;
                        F_SETOWN = Linux_NonMips_Defines.F_SETOWN;
                        O_APPEND = Linux_NonMips_Defines.O_APPEND;
                        O_ASYNC = IntDefine.toIntDefine(Linux_NonMips_Defines.O_ASYNC);
                        O_CREAT = Linux_NonMips_Defines.O_CREAT;
                        O_DSYNC = Linux_NonMips_Defines.O_DSYNC;
                        O_EXCL = Linux_NonMips_Defines.O_EXCL;
                        O_FSYNC = IntDefine.toIntDefine(Linux_NonMips_Defines.O_FSYNC);
                        O_NOCTTY = Linux_NonMips_Defines.O_NOCTTY;
                        O_NONBLOCK = Linux_NonMips_Defines.O_NONBLOCK;
                        O_RSYNC = IntDefine.toIntDefine(Linux_NonMips_Defines.O_RSYNC);
                        O_SYNC = Linux_NonMips_Defines.O_SYNC;

                }
                switch (multiarchInfo.getArch()) {
                    case AARCH64:
                    case ARM:
                        O_DIRECTORY = Linux_Aarch64_Arm_Defines.O_DIRECTORY;
                        O_NOFOLLOW = Linux_Aarch64_Arm_Defines.O_NOFOLLOW;
                        break;
                    case MIPS:
                    case MIPS_64:
                        O_DIRECTORY = Linux_Mips_Mips64_Defines.O_DIRECTORY;
                        O_NOFOLLOW = Linux_Mips_Mips64_Defines.O_NOFOLLOW;
                        break;
                    case POWER_PC_64:
                        O_DIRECTORY = Linux_Ppc64_Defines.O_DIRECTORY;
                        O_NOFOLLOW = Linux_Ppc64_Defines.O_NOFOLLOW;
                        break;
                    case RISC_V_64:
                    case S390_X:
                        O_DIRECTORY = Linux_RiscV64_S390_Defines.O_DIRECTORY;
                        O_NOFOLLOW = Linux_RiscV64_S390_Defines.O_NOFOLLOW;
                        break;
                    case I386:
                    case X86_64:
                        O_DIRECTORY = Linux_I386_X86_64_Defines.O_DIRECTORY;
                        O_NOFOLLOW = Linux_I386_X86_64_Defines.O_NOFOLLOW;
                        break;
                    default:
                        throw new NoClassDefFoundError("No fcntl.h defines for " + multiarchInfo);
                }
                break;
            case DARWIN:
            case FREE_BSD:
            case OPEN_BSD:
                HAVE_FCNTL_H = true;

                FD_CLOEXEC = BsdDefines.FD_CLOEXEC;

                F_DUPFD = BsdDefines.F_DUPFD;
                F_GETFD = BsdDefines.F_GETFD;
                F_GETFL = BsdDefines.F_GETFL;
                F_RDLCK = BsdDefines.F_RDLCK;
                F_SETFD = BsdDefines.F_SETFD;
                F_SETFL = BsdDefines.F_SETFL;
                F_UNLCK = BsdDefines.F_UNLCK;
                F_WRLCK = BsdDefines.F_WRLCK;

                O_ACCMODE = BsdDefines.O_ACCMODE;
                O_RDONLY = BsdDefines.O_RDONLY;
                O_RDWR = BsdDefines.O_RDWR;
                O_TRUNC = BsdDefines.O_TRUNC;
                O_WRONLY = BsdDefines.O_WRONLY;
                O_NOFOLLOW = BsdDefines.O_NOFOLLOW;

                O_LARGEFILE = IntDefine.UNDEFINED;
                F_GETOWN = BsdDefines.F_GETOWN;
                F_SETOWN = BsdDefines.F_SETOWN;
                O_APPEND = BsdDefines.O_APPEND;
                O_ASYNC = IntDefine.toIntDefine(BsdDefines.O_ASYNC);
                O_CREAT = BsdDefines.O_CREAT;
                O_FSYNC = IntDefine.toIntDefine(BsdDefines.O_FSYNC);
                O_NONBLOCK = BsdDefines.O_NONBLOCK;
                O_SYNC = BsdDefines.O_SYNC;
                switch (multiarchInfo.getOS()) {
                    case DARWIN:
                        AT_FDCWD = DarwinDefines.AT_FDCWD;
                        AT_EACCESS = DarwinDefines.AT_EACCESS;
                        AT_REMOVEDIR = DarwinDefines.AT_REMOVEDIR;
                        AT_SYMLINK_FOLLOW = DarwinDefines.AT_SYMLINK_FOLLOW;
                        AT_SYMLINK_NOFOLLOW = DarwinDefines.AT_SYMLINK_NOFOLLOW;
                        F_DUPFD_CLOEXEC = DarwinDefines.F_DUPFD_CLOEXEC;
                        F_SETLK = DarwinDefines.F_SETLK;
                        F_SETLKW = DarwinDefines.F_SETLKW;
                        O_NOCTTY = DarwinDefines.O_NOCTTY;
                        O_CLOEXEC = DarwinDefines.O_CLOEXEC;
                        POSIX_FADV_DONTNEED = IntDefine.UNDEFINED;
                        POSIX_FADV_NOREUSE = IntDefine.UNDEFINED;
                        POSIX_FADV_NORMAL = IntDefine.UNDEFINED;
                        POSIX_FADV_RANDOM = IntDefine.UNDEFINED;
                        POSIX_FADV_SEQUENTIAL = IntDefine.UNDEFINED;
                        POSIX_FADV_WILLNEED = IntDefine.UNDEFINED;
                        F_GETLK = DarwinDefines.F_GETLK;
                        O_DIRECTORY = DarwinDefines.O_DIRECTORY;
                        O_DSYNC = DarwinDefines.O_DSYNC;
                        O_EXEC = IntDefine.UNDEFINED;
                        O_EXCL = DarwinDefines.O_EXCL;
                        O_RSYNC = IntDefine.UNDEFINED;
                        O_SEARCH = IntDefine.UNDEFINED;
                        O_TTY_INIT = IntDefine.UNDEFINED;

                        break;
                    case FREE_BSD:
                        AT_FDCWD = FreeBsdDefines.AT_FDCWD;
                        AT_EACCESS = FreeBsdDefines.AT_EACCESS;
                        AT_REMOVEDIR = FreeBsdDefines.AT_REMOVEDIR;
                        AT_SYMLINK_FOLLOW = FreeBsdDefines.AT_SYMLINK_FOLLOW;
                        AT_SYMLINK_NOFOLLOW = FreeBsdDefines.AT_SYMLINK_NOFOLLOW;
                        F_DUPFD_CLOEXEC = FreeBsdDefines.F_DUPFD_CLOEXEC;
                        F_SETLK = FreeBsdDefines.F_SETLK;
                        F_SETLKW = FreeBsdDefines.F_SETLKW;
                        O_NOCTTY = FreeBsdDefines.O_NOCTTY;
                        O_CLOEXEC = FreeBsdDefines.O_CLOEXEC;
                        POSIX_FADV_DONTNEED = IntDefine.toIntDefine(FreeBsdDefines.POSIX_FADV_DONTNEED);
                        POSIX_FADV_NOREUSE = IntDefine.toIntDefine(FreeBsdDefines.POSIX_FADV_NOREUSE);
                        POSIX_FADV_NORMAL = IntDefine.toIntDefine(FreeBsdDefines.POSIX_FADV_NORMAL);
                        POSIX_FADV_RANDOM = IntDefine.toIntDefine(FreeBsdDefines.POSIX_FADV_RANDOM);
                        POSIX_FADV_SEQUENTIAL = IntDefine.toIntDefine(FreeBsdDefines.POSIX_FADV_SEQUENTIAL);
                        POSIX_FADV_WILLNEED = IntDefine.toIntDefine(FreeBsdDefines.POSIX_FADV_WILLNEED);
                        F_GETLK = FreeBsdDefines.F_GETLK;
                        O_EXEC = IntDefine.toIntDefine(FreeBsdDefines.O_EXEC);
                        O_DIRECTORY = FreeBsdDefines.O_DIRECTORY;
                        O_DSYNC = FreeBsdDefines.O_DSYNC;
                        O_EXCL = FreeBsdDefines.O_EXCL;
                        O_RSYNC = IntDefine.UNDEFINED;
                        O_SEARCH = IntDefine.toIntDefine(FreeBsdDefines.O_SEARCH);
                        O_TTY_INIT = IntDefine.toIntDefine(FreeBsdDefines.O_TTY_INIT);
                        break;
                    case OPEN_BSD:
                        AT_FDCWD = OpenBsdDefines.AT_FDCWD;
                        AT_EACCESS = OpenBsdDefines.AT_EACCESS;
                        AT_REMOVEDIR = OpenBsdDefines.AT_REMOVEDIR;
                        AT_SYMLINK_FOLLOW = OpenBsdDefines.AT_SYMLINK_FOLLOW;
                        AT_SYMLINK_NOFOLLOW = OpenBsdDefines.AT_SYMLINK_NOFOLLOW;
                        F_DUPFD_CLOEXEC = OpenBsdDefines.F_DUPFD_CLOEXEC;
                        F_SETLK = OpenBsdDefines.F_SETLK;
                        F_SETLKW = OpenBsdDefines.F_SETLKW;
                        O_NOCTTY = OpenBsdDefines.O_NOCTTY;
                        O_CLOEXEC = OpenBsdDefines.O_CLOEXEC;
                        POSIX_FADV_DONTNEED = IntDefine.UNDEFINED;
                        POSIX_FADV_NOREUSE = IntDefine.UNDEFINED;
                        POSIX_FADV_NORMAL = IntDefine.UNDEFINED;
                        POSIX_FADV_RANDOM = IntDefine.UNDEFINED;
                        POSIX_FADV_SEQUENTIAL = IntDefine.UNDEFINED;
                        POSIX_FADV_WILLNEED = IntDefine.UNDEFINED;
                        F_GETLK = OpenBsdDefines.F_GETLK;
                        O_DIRECTORY = OpenBsdDefines.O_DIRECTORY;
                        O_DSYNC = OpenBsdDefines.O_DSYNC;
                        O_EXEC = IntDefine.UNDEFINED;
                        O_EXCL = OpenBsdDefines.O_EXCL;
                        O_RSYNC = IntDefine.toIntDefine(OpenBsdDefines.O_RSYNC);
                        O_SEARCH = IntDefine.UNDEFINED;
                        O_TTY_INIT = IntDefine.UNDEFINED;

                        break;
                    default:
                        throw new NoClassDefFoundError("No fcntl.h BSD defines for " + multiarchInfo);
                }
                break;
            default:
                throw new NoClassDefFoundError("No fcntl.h defines for " + multiarchInfo);
        }
    }

    /**
     * <b>POSIX:</b> Check access using effective user and group ID.
     *
     */
    @Define
    public final static int AT_EACCESS;

    /**
     * <b>POSIX:</b> Use the current working directory to determine the target.
     * of relative file paths.
     *
     */
    @Define
    public final static int AT_FDCWD;

    /**
     * <b>POSIX:</b> Remove directory instead of file.
     *
     */
    @Define
    public final static int AT_REMOVEDIR;

    /**
     * <b>POSIX:</b> Follow symbolic link.
     *
     */
    @Define
    public final static int AT_SYMLINK_FOLLOW;

    /**
     * <b>POSIX:</b> Do not follow symbolic links.
     *
     */
    @Define
    public final static int AT_SYMLINK_NOFOLLOW;

    /**
     * <b>POSIX:</b> Close the file descriptor upon execution of an exec family
     * function.
     *
     */
    @Define
    public final static int FD_CLOEXEC;

    /**
     * <b>POSIX:</b> Duplicate file descriptor.
     *
     */
    @Define
    public final static int F_DUPFD;

    /**
     * <b>POSIX:</b> Duplicate file descriptor with the close-on-exec flag
     * FD_CLOEXEC set.
     *
     */
    @Define
    public final static int F_DUPFD_CLOEXEC;

    /**
     * <b>POSIX:</b> et file descriptor flags.
     *
     */
    @Define
    public final static int F_GETFD;

    /**
     * <b>POSIX:</b> Get file status flags and file access modes.
     *
     */
    @Define
    public final static int F_GETFL;

    /**
     * <b>POSIX:</b> Get record locking information.
     *
     */
    @Define
    public final static int F_GETLK;

    /**
     * <b>POSIX:</b> Get process or process group ID to receive SIGURG signals.
     *
     */
    @Define
    public final static int F_GETOWN;

    /**
     * <b>POSIX:</b> Shared or read lock.
     *
     */
    @Define
    public final static int F_RDLCK;

    /**
     * <b>POSIX:</b> Set file descriptor flags.
     *
     */
    @Define
    public final static int F_SETFD;

    /**
     * <b>POSIX:</b> Set file status flags.
     *
     */
    @Define
    public final static int F_SETFL;

    /**
     * <b>POSIX:</b> Set record locking information.
     *
     */
    @Define
    public final static int F_SETLK;

    /**
     * <b>POSIX:</b> Set record locking information; wait if blocked.
     *
     */
    @Define
    public final static int F_SETLKW;

    /**
     * <b>POSIX:</b> Set process or process group ID to receive SIGURG signals.
     *
     */
    @Define
    public final static int F_SETOWN;

    /**
     * <b>POSIX:</b> Unlock.
     *
     */
    @Define
    public final static int F_UNLCK;

    /**
     * <b>POSIX:</b> Exclusive or write lock.
     *
     */
    @Define
    public final static int F_WRLCK;

    public final static boolean HAVE_FCNTL_H;

    /**
     * <b>POSIX:</b> Mask for file access modes.
     *
     */
    @Define
    public final static int O_ACCMODE;

    /**
     * <b>POSIX:</b> Set append mode.
     *
     */
    @Define
    public final static int O_APPEND;

    /**
     * <b>Non POSIX:</b> Enable signal-driven I/O.
     *
     */
    @Define
    public final static IntDefine O_ASYNC;

    /**
     * <b>POSIX:</b> The FD_CLOEXEC flag associated with the new descriptor
     * shall be set to close the file descriptor upon execution of an exec
     * family function.
     *
     */
    @Define
    public final static int O_CLOEXEC;

    /**
     * <b>POSIX:</b> Create file if it does not exist.
     *
     */
    @Define
    public final static int O_CREAT;

    /**
     * <b>POSIX:</b> Fail if file is a non-directory file.
     *
     */
    @Define
    public final static int O_DIRECTORY;

    /**
     * <b>POSIX.SIO:</b> Write according to synchronized I/O data integrity
     * completion.
     *
     */
    @Define
    public final static int O_DSYNC;

    /**
     * <b>POSIX:</b> Exclusive use flag.
     *
     */
    @Define
    public final static int O_EXCL;

    /**
     * <b>POSIX:</b> Open for execute only (non-directory files).The result is
     * unspecified if this flag is applied to a directory.
     *
     */
    @Define
    public final static IntDefine O_EXEC;

    /**
     * <b>Non POSIX:</b> enables synchronous writing for the file. .
     *
     */
    @Define
    public final static IntDefine O_FSYNC;

    /**
     * <b>Linux:</b> (LFS) Allow files whose sizes cannot be represented in an
     * off_t (but can be represented in an off64_t) to be opened. The
     * _LARGEFILE64_SOURCE macro must be defined (before including any header
     * files) in order to obtain this definition. Setting the _FILE_OFFSET_BITS
     * feature test macro to 64 (rather than using O_LARGEFILE) is the preferred
     * method of accessing large files on 32-bit systems (see
     * feature_test_macros(7)). .
     *
     */
    @Define
    public final static IntDefine O_LARGEFILE;

    /**
     * <b>POSIX:</b> Do not assign controlling terminal.
     *
     */
    @Define
    public final static int O_NOCTTY;

    /**
     * <b>POSIX:</b> Do not follow symbolic links.
     *
     */
    @Define
    public final static int O_NOFOLLOW;

    /**
     * <b>POSIX:</b> Non-blocking mode.
     *
     */
    @Define
    public final static int O_NONBLOCK;

    /**
     * <b>POSIX:</b> Open for reading only.
     *
     */
    @Define
    public final static int O_RDONLY;

    /**
     * <b>POSIX:</b> Open for reading and writing.
     *
     */
    @Define
    public final static int O_RDWR;

    /**
     * <b>POSIX.SIO:</b> Synchronized read I/O operations.
     *
     */
    @Define
    public final static IntDefine O_RSYNC;

    /**
     * <b>POSIX:</b> Open directory for search only. The result is unspecified
     * if this flag is applied to a non-directory file.
     *
     */
    @Define
    public final static IntDefine O_SEARCH;

    /**
     * <b>POSIX:</b> Write according to synchronized I/O file integrity
     * completion.
     *
     */
    @Define
    public final static int O_SYNC;

    /**
     * <b>POSIX:</b> Truncate flag.
     *
     */
    @Define
    public final static int O_TRUNC;

    /**
     * <b>POSIX:</b> Set the termios structure terminal parameters to a state
     * that provides conforming behavior.
     *
     */
    @Define
    public final static IntDefine O_TTY_INIT;

    /**
     * <b>POSIX:</b> Open for writing only.
     *
     */
    @Define
    public final static int O_WRONLY;

    /**
     * <b>POSIX.ADV:</b> The application expects that it will not access the
     * specified data in the near future.
     *
     */
    @Define
    public final static IntDefine POSIX_FADV_DONTNEED;

    /**
     * <b>POSIX.ADV:</b> The application expects to access the specified data
     * once and then not reuse it thereafter.
     *
     */
    @Define
    public final static IntDefine POSIX_FADV_NOREUSE;

    /**
     * <b>POSIX.ADV:</b> The application has no advice to give on its behavior
     * with respect to the specified data.It is the default characteristic if no
     * advice is given for an open file.
     *
     */
    @Define
    public final static IntDefine POSIX_FADV_NORMAL;

    /**
     * <b>POSIX.ADV:</b> The application expects to access the specified data in
     * a random order.
     *
     */
    @Define
    public final static IntDefine POSIX_FADV_RANDOM;

    /**
     * <b>POSIX.ADV:</b> The application expects to access the specified data
     * sequentially from lower offsets to higher offsets.
     *
     */
    @Define
    public final static IntDefine POSIX_FADV_SEQUENTIAL;

    /**
     * <b>POSIX.ADV:</b> The application expects to access the specified data in
     * the near future.
     *
     */
    @Define
    public final static IntDefine POSIX_FADV_WILLNEED;

    /**
     * <b>POSIX:</b> same as defined in stdio.h.
     *
     */
    @Define
    public final static int SEEK_CUR;

    /**
     * <b>POSIX:</b> same as defined in stdio.h.
     *
     */
    @Define
    public final static int SEEK_END;

    /**
     * <b>POSIX:</b> same as defined in stdio.h.
     *
     */
    @Define
    public final static int SEEK_SET;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/creat.html">creat
     * - create a new file or rewrite an existing one</a>.
     *
     * @param path the pathname naming the file.
     * @param mode the file access modes from {@link Stat}.
     * @return a handle to the opend file.
     *
     * @throws NullPointerException if {@code file} is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int creat(String path, @mode_t int mode) throws NativeErrorException {
        if (path == null) {
            throw new NullPointerException("path is null.");
        }
        return creat0(path, mode);
    }

    private static native int creat0(String path, @mode_t int mode) throws NativeErrorException;

    /**
     * <b>Linux:</b> Available if _LARGEFILE64_SOURCE is defined.
     *
     * @param path the pathname naming the file.
     * @param mode the file access modes from {@link Stat}.
     * @return a handle to the opend file.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static int creat64(String path, @mode_t int mode) throws NativeErrorException, NoSuchNativeMethodException {
        if (path == null) {
            throw new NullPointerException("path is null.");
        }
        return creat64_0(path, mode);
    }

    private static native int creat64_0(String path, @mode_t int mode) throws NativeErrorException, NoSuchNativeMethodException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/fcntl.html">fcntl
     * - file control</a>.
     *
     * @param fildes a file descriptor
     * @param cmd the available values for cmd are defined in fcntl.h.
     * @return the value returned shall depend on cmd.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native int fcntl(int fildes, int cmd) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/fcntl.html">fcntl
     * - file control</a>.
     *
     * @param fildes a file descriptor
     * @param cmd the available values for cmd are defined in fcntl.h.
     * @param vararg_0 the arg for some cmd.
     * @return the value returned shall depend on cmd.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native int fcntl(int fildes, int cmd, int vararg_0) throws NativeErrorException;

    /**
     *
     * <b>Linux:</b> Available if _LARGEFILE64_SOURCE is defined.
     *
     * @param fildes a file descriptor
     * @param cmd the available values for cmd are defined in fcntl.h.
     * @return the value returned shall depend on cmd.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static native int fcntl64(int fildes, int cmd) throws NativeErrorException, NoSuchNativeMethodException;

    /**
     *
     * <b>Linux:</b> Available if _LARGEFILE64_SOURCE is defined.
     *
     * @param fildes a file descriptor
     * @param cmd the available values for cmd are defined in fcntl.h.
     * @param vararg_0 the arg for some cmd.
     * @return the value returned shall depend on cmd.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static native int fcntl64(int fildes, int cmd, int vararg_0) throws NativeErrorException, NoSuchNativeMethodException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/open.html">open,
     * openat - open file</a>.
     *
     * @param path the pathname naming the file.
     * @param oflag the open flags.
     * @return a handle to the opend file.
     *
     * @throws NullPointerException if {@code file} is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int open(String path, int oflag) throws NativeErrorException {
        if (path == null) {
            throw new NullPointerException("path is null.");
        }
        return open0(path, oflag);
    }

    private static native int open0(String path, int oflag) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/open.html">open,
     * openat - open file</a>.
     *
     * @param path the pathname naming the file.
     * @param oflag the open flags.
     * @param mode the file access modes from {@link Stat}.
     * @return a handle to the opend file.
     *
     * @throws NullPointerException if {@code file} is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int open(String path, int oflag, @mode_t int mode) throws NativeErrorException {
        if (path == null) {
            throw new NullPointerException("path is null.");
        }
        return open0(path, oflag, mode);
    }

    private static native int open0(String path, int oflag, int mode) throws NativeErrorException;

    /**
     * <b>Linux:</b> Available if _LARGEFILE64_SOURCE is defined.
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/open.html">open,
     * openat - open file</a>.
     *
     * @param path the pathname naming the file.
     * @param oflag the open flags.
     * @return a handle to the opend file.
     *
     * @throws NullPointerException if {@code file} is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static int open64(String path, int oflag) throws NativeErrorException, NoSuchNativeMethodException {
        if (path == null) {
            throw new NullPointerException("path is null.");
        }
        return open64_0(path, oflag);
    }

    private static native int open64_0(String path, int oflag) throws NativeErrorException, NoSuchNativeMethodException;

    /**
     * <b>Linux:</b> Available if _LARGEFILE64_SOURCE is defined.
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/open.html">open,
     * openat - open file</a>.
     *
     * @param path the pathname naming the file.
     * @param oflag the open flags.
     * @param mode the file access modes from {@link Stat}.
     * @return a handle to the opend file.
     *
     * @throws NullPointerException if {@code file} is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static int open64(String path, int oflag, @mode_t int mode) throws NativeErrorException, NoSuchNativeMethodException {
        if (path == null) {
            throw new NullPointerException("path is null.");
        }
        return open64_0(path, oflag, mode);
    }

    private static native int open64_0(String path, int oflag, @mode_t int mode) throws NativeErrorException, NoSuchNativeMethodException;

    /**
     *
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/open.html">open,
     * openat - open file</a>.
     *
     * @param fd a filedescriptor of a directory.
     * @param path the pathname naming the file. If relative fd points to the
     * parent direcory.
     * @param oflag the open flags.
     * @return a handle to the opend file.
     *
     * @throws NullPointerException if {@code file} is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int openat(int fd, String path, int oflag) throws NativeErrorException {
        if (path == null) {
            throw new NullPointerException("path is null.");
        }
        return openat0(fd, path, oflag);
    }

    private static native int openat0(int fd, String path, int oflag) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/open.html">open,
     * openat - open file</a>.
     *
     * @param fd a filedescriptor of a directory.
     * @param path the pathname naming the file. If relative fd points to the
     * parent direcory.
     * @param oflag the open flags.
     * @param mode the file access modes from {@link Stat}.
     * @return a handle to the opend file.
     *
     * @throws NullPointerException if {@code file} is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int openat(int fd, String path, int oflag, @mode_t int mode) throws NativeErrorException {
        if (path == null) {
            throw new NullPointerException("path is null.");
        }
        return openat0(fd, path, oflag, mode);
    }

    private static native int openat0(int fd, String path, int oflag, @mode_t int mode) throws NativeErrorException;

    /**
     * <b>Linux:</b> Available if _LARGEFILE64_SOURCE is defined.
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/open.html">open,
     * openat - open file</a>.
     *
     * @param fd a filedescriptor of a directory.
     * @param path the pathname naming the file. If relative fd points to the
     * parent direcory.
     * @param oflag the open flags.
     * @return a handle to the opend file.
     *
     * @throws NullPointerException if {@code file} is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static int openat64(int fd, String path, int oflag) throws NativeErrorException, NoSuchNativeMethodException {
        if (path == null) {
            throw new NullPointerException("path is null.");
        }
        return openat64_0(fd, path, oflag);
    }

    private static native int openat64_0(int fd, String path, int oflag) throws NativeErrorException, NoSuchNativeMethodException;

    /**
     * <b>Linux:</b> Available if _LARGEFILE64_SOURCE is defined.
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/open.html">open,
     * openat - open file</a>.
     *
     * @param fd a filedescriptor of a directory.
     * @param path the pathname naming the file. If relative fd points to the
     * parent direcory.
     * @param oflag the open flags.
     * @param mode the file access modes from {@link Stat}.
     * @return a handle to the opend file.
     *
     * @throws NullPointerException if {@code file} is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static int openat64(int fd, String path, int oflag, @mode_t int mode) throws NativeErrorException, NoSuchNativeMethodException {
        if (path == null) {
            throw new NullPointerException("path is null.");
        }
        return openat64_0(fd, path, oflag, mode);
    }

    private static native int openat64_0(int fd, String path, int oflag, @mode_t int mode) throws NativeErrorException, NoSuchNativeMethodException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/posix_fadvise.html">posix_fadvise
     * - file advisory information (ADVANCED REALTIME)</a>.
     *
     * @param fildes a file descriptor
     * @param offset the offset.
     * @param len the length.
     * @param advice the advice to be applied to the data is specified by the
     * advice parameter.
     *
     * @throws NativeErrorException if the return value of the native function
     * returns an error code.
     */
    public final static native void posix_fadvise(int fildes, @off_t long offset, @off_t long len, int advice) throws NativeErrorException, NoSuchNativeMethodException;

    /**
     * <b>Linux:</b> Available if _LARGEFILE64_SOURCE is defined.
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/posix_fadvise.html">posix_fadvise
     * - file advisory information (ADVANCED REALTIME)</a>.
     *
     * @param fildes a file descriptor
     * @param offset the offset.
     * @param len the length.
     * @param advice the advice to be applied to the data is specified by the
     * advice parameter.
     *
     * @throws NativeErrorException if the return value of the native function
     * returns an error code.
     * @throws NoSuchNativeMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static native void posix_fadvise64(int fildes, @off64_t long offset, @off64_t long len, int advice) throws NativeErrorException, NoSuchNativeMethodException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/posix_fallocate.html">posix_fallocate
     * - file space control (ADVANCED REALTIME)</a>.
     *
     * @param fildes a file descriptor
     * @param offset the offset.
     * @param len the length.
     *
     * @throws NativeErrorException if the return value of the native function
     * returns an error code.
     */
    public final static native void posix_fallocate(int fildes, @off_t long offset, @off_t long len) throws NativeErrorException, NoSuchNativeMethodException;

    /**
     * <b>Linux:</b> Available if _LARGEFILE64_SOURCE is defined.
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/posix_fallocate.html">posix_fallocate
     * - file space control (ADVANCED REALTIME)</a>.
     *
     * @param fildes a file descriptor
     * @param offset the offset.
     * @param len the length.
     *
     * @throws NativeErrorException if the return value of the native function
     * @throws NoSuchNativeMethodException if _LARGEFILE64_SOURCE is not
     * defined. returns an error code.
     */
    public final static native void posix_fallocate64(int fildes, @off64_t long offset, @off64_t long len) throws NativeErrorException, NoSuchNativeMethodException;

}
