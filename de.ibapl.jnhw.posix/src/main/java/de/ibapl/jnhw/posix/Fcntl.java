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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.annotation.posix.sys.types.mode_t;
import de.ibapl.jnhw.annotation.posix.sys.types.off64_t;
import de.ibapl.jnhw.annotation.posix.sys.types.off_t;
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI___A_sI_VARARGS_NONE;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI___A_uI;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI_sI_VARARGS_NONE;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI_sL_sL;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI_sL_sL_sI;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.util.IntDefine;
import de.ibapl.jnhw.libloader.MultiarchInfo;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.posix.sys.Stat;
import de.ibapl.jnhw.libloader.librarys.LibcLoader;
import de.ibapl.jnhw.util.posix.PosixDataType;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI_sI_VARARGS_sI;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI___A_sI_VARARGS_uI;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI__A_sI_VARARGS_NONE;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI__A_sI_VARARGS_uI;

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

    public static interface BsdDefines {

        public final static int F_DUPFD = 0;
        public final static int F_GETFD = 1;
        public final static int F_GETFL = 3;
        public final static int F_GETOWN = 5;
        public final static int F_RDLCK = 1;
        public final static int F_SETFD = 2;
        public final static int F_SETFL = 4;
        public final static int F_SETOWN = 6;
        public final static int F_UNLCK = 2;
        public final static int F_WRLCK = 3;
        public final static int FD_CLOEXEC = 1;
        public final static int O_ACCMODE = 0003;
        public final static int O_APPEND = 8;
        public final static int O_ASYNC = 64;

        public final static int O_CREAT = 512;
        public final static int O_FSYNC = 128;
        public final static int O_NOFOLLOW = 256;
        public final static int O_NONBLOCK = 4;
        public final static int O_RDONLY = 00;
        public final static int O_RDWR = 02;
        public final static int O_SYNC = 128;
        public final static int O_TRUNC = 1024;
        public final static int O_WRONLY = 01;
    }

    public static interface DarwinDefines extends BsdDefines {

        public final static int AT_EACCESS = 16;
        public final static int AT_FDCWD = -2;
        public final static int AT_REMOVEDIR = 128;
        public final static int AT_SYMLINK_FOLLOW = 64;
        public final static int AT_SYMLINK_NOFOLLOW = 32;
        public final static int F_DUPFD_CLOEXEC = 67;
        public final static int F_GETLK = 7;
        public final static int F_SETLK = 8;
        public final static int F_SETLKW = 9;
        public final static int O_CLOEXEC = 16777216;
        public final static int O_DIRECTORY = 1048576;
        public final static int O_DSYNC = 4194304;
        public final static int O_EXCL = 2048;
        public final static int O_NOCTTY = 131072;

    }

    public static interface FreeBsdDefines extends BsdDefines {

        public final static int AT_EACCESS = 256;
        public final static int AT_FDCWD = -100;
        public final static int AT_REMOVEDIR = 2048;
        public final static int AT_SYMLINK_FOLLOW = 0x400;
        public final static int AT_SYMLINK_NOFOLLOW = 512;
        public final static int F_DUPFD_CLOEXEC = 17;
        public final static int F_GETLK = 11;
        public final static int F_SETLK = 12;
        public final static int F_SETLKW = 13;
        public final static int O_CLOEXEC = 1048576;
        public final static int O_DIRECTORY = 131072;
        public final static int O_DSYNC = 16777216;
        public final static int O_EXCL = 2048;
        public final static int O_EXEC = 262144;
        public final static int O_NOCTTY = 32768;
        public final static int O_SEARCH = 262144;
        public final static int O_TTY_INIT = 524288;
        public final static int POSIX_FADV_DONTNEED = 4;
        public final static int POSIX_FADV_NOREUSE = 5;
        public final static int POSIX_FADV_NORMAL = 0;
        public final static int POSIX_FADV_RANDOM = 1;
        public final static int POSIX_FADV_SEQUENTIAL = 2;
        public final static int POSIX_FADV_WILLNEED = 3;

    }

    public static class LinuxDefines {

        public final int AT_EACCESS = 0x200;
        public final int AT_FDCWD = -100;
        public final int AT_REMOVEDIR = 0x200;
        public final int AT_SYMLINK_FOLLOW = 0x400;
        public final int AT_SYMLINK_NOFOLLOW = 0x100;
        public final int F_DUPFD = 0;
        public final int F_DUPFD_CLOEXEC = 1030;
        public final int F_GETFD = 1;
        public final int F_GETFL = 3;
        public final int F_RDLCK = 0;
        public final int F_SETFD = 2;
        public final int F_SETFL = 4;
        public final int F_SETLK = 6;
        public final int F_SETLKW = 7;
        public final int F_UNLCK = 2;
        public final int F_WRLCK = 1;
        public final int FD_CLOEXEC = 1;
        public final int O_ACCMODE = 0003;
        public final int O_CLOEXEC = 02000000;
        public final int O_RDONLY = 00;
        public final int O_RDWR = 02;
        public final int O_TRUNC = 01000;
        public final int O_WRONLY = 01;
        public final int POSIX_FADV_NORMAL = 0;
        public final int POSIX_FADV_RANDOM = 1;
        public final int POSIX_FADV_SEQUENTIAL = 2;
        public final int POSIX_FADV_WILLNEED = 3;
        public final int POSIX_FADV_DONTNEED;
        public final int POSIX_FADV_NOREUSE;

        public final int F_GETLK;
        public final int F_GETOWN;
        public final int F_SETOWN;
        public final int O_APPEND;
        public final int O_ASYNC;
        public final int O_CREAT;
        public final int O_DIRECTORY;
        public final int O_DSYNC;
        public final int O_EXCL;
        public final int O_FSYNC;
        public final int O_NOCTTY;
        public final int O_NOFOLLOW;
        public final int O_NONBLOCK;

        public final int O_RSYNC;
        public final int O_SYNC;

        public final int O_LARGEFILE;

        public LinuxDefines(MultiarchInfo multiarchInfo) {
            switch (multiarchInfo.getArch()) {
                case MIPS, MIPS_64 -> {
                    F_GETLK = 14;
                    F_GETOWN = 23;
                    F_SETOWN = 24;
                    O_APPEND = 010;
                    O_ASYNC = 010000;
                    O_CREAT = 0400;
                    O_DSYNC = 020;
                    O_EXCL = 02000;
                    O_FSYNC = 040020;
                    O_NOCTTY = 04000;
                    O_NONBLOCK = 0200;
                    O_RSYNC = 040020;
                    O_SYNC = 040020;
                }
                default -> {
                    F_GETLK = 5;
                    F_GETOWN = 9;
                    F_SETOWN = 8;
                    O_APPEND = 02000;
                    O_ASYNC = 020000;
                    O_CREAT = 0100;
                    O_DSYNC = 010000;
                    O_EXCL = 0200;
                    O_FSYNC = 04010000;
                    O_NOCTTY = 0400;
                    O_NONBLOCK = 04000;
                    O_RSYNC = 04010000;
                    O_SYNC = 04010000;
                }
            }
            switch (multiarchInfo.getArch()) {
                case S390_X -> {
                    POSIX_FADV_DONTNEED = 6;
                    POSIX_FADV_NOREUSE = 7;
                }
                default -> {
                    POSIX_FADV_DONTNEED = 4;
                    POSIX_FADV_NOREUSE = 5;
                }
            }
            switch (multiarchInfo.getArch()) {
                case ARM, AARCH64 -> {
                    O_DIRECTORY = 040000;
                    O_NOFOLLOW = 0100000;
                }
                case I386, X86_64 -> {
                    O_DIRECTORY = 0200000;
                    O_NOFOLLOW = 0400000;
                }
                case MIPS, MIPS_64 -> {
                    O_DIRECTORY = 0200000;
                    O_NOFOLLOW = 0400000;
                }
                case POWER_PC_64 -> {
                    O_DIRECTORY = 040000;
                    O_NOFOLLOW = 0100000;
                }
                case RISC_V_64, S390_X -> {
                    O_DIRECTORY = 65536;
                    O_NOFOLLOW = 131072;
                }
                default ->
                    throw new RuntimeException("No O_DIRECTORY or O_NOFOLLOW for: " + multiarchInfo);
            }
            switch (multiarchInfo.getArch()) {
                case ARM ->
                    O_LARGEFILE = 0400000;
                case AARCH64, MIPS_64, POWER_PC_64, S390_X, X86_64 ->
                    O_LARGEFILE = 0;
                case I386 ->
                    O_LARGEFILE = 0100000;
                case MIPS ->
                    O_LARGEFILE = 020000;
                default ->
                    throw new RuntimeException("No O_LARGEFILE for: " + multiarchInfo);
            }
        }
    }

    public static interface OpenBsdDefines extends BsdDefines {

        public final static int AT_EACCESS = 1;
        public final static int AT_FDCWD = -100;
        public final static int AT_REMOVEDIR = 8;
        public final static int AT_SYMLINK_FOLLOW = 4;
        public final static int AT_SYMLINK_NOFOLLOW = 2;
        public final static int F_DUPFD_CLOEXEC = 10;
        public final static int F_GETLK = 7;
        public final static int F_SETLK = 8;
        public final static int F_SETLKW = 9;
        public final static int O_CLOEXEC = 65536;
        public final static int O_DIRECTORY = 131072;
        public final static int O_DSYNC = 128;
        public final static int O_EXCL = 2048;
        public final static int O_NOCTTY = 32768;
        public final static int O_RSYNC = 128;

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

    /**
     * <b>POSIX:</b> Close the file descriptor upon execution of an exec family
     * function.
     *
     */
    @Define
    public final static int FD_CLOEXEC;

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
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        SEEK_CUR = Stdio.SEEK_CUR;
        SEEK_END = Stdio.SEEK_END;
        SEEK_SET = Stdio.SEEK_SET;

        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX -> {
                HAVE_FCNTL_H = true;

                final LinuxDefines linuxDefines = new LinuxDefines(MultiarchTupelBuilder.getMultiarch());

                AT_EACCESS = linuxDefines.AT_EACCESS;
                AT_FDCWD = linuxDefines.AT_FDCWD;
                AT_REMOVEDIR = linuxDefines.AT_REMOVEDIR;
                AT_SYMLINK_FOLLOW = linuxDefines.AT_SYMLINK_FOLLOW;
                AT_SYMLINK_NOFOLLOW = linuxDefines.AT_SYMLINK_NOFOLLOW;

                FD_CLOEXEC = linuxDefines.FD_CLOEXEC;

                F_DUPFD = linuxDefines.F_DUPFD;
                F_DUPFD_CLOEXEC = linuxDefines.F_DUPFD_CLOEXEC;
                F_GETFD = linuxDefines.F_GETFD;
                F_GETFL = linuxDefines.F_GETFL;
                F_RDLCK = linuxDefines.F_RDLCK;
                F_SETFD = linuxDefines.F_SETFD;
                F_SETFL = linuxDefines.F_SETFL;
                F_SETLK = linuxDefines.F_SETLK;
                F_SETLKW = linuxDefines.F_SETLKW;
                F_UNLCK = linuxDefines.F_UNLCK;
                F_WRLCK = linuxDefines.F_WRLCK;

                O_ACCMODE = linuxDefines.O_ACCMODE;
                O_CLOEXEC = linuxDefines.O_CLOEXEC;
                O_EXEC = IntDefine.UNDEFINED;
                O_RDONLY = linuxDefines.O_RDONLY;
                O_RDWR = linuxDefines.O_RDWR;
                O_SEARCH = IntDefine.UNDEFINED;
                O_TRUNC = linuxDefines.O_TRUNC;
                O_TTY_INIT = IntDefine.UNDEFINED;
                O_WRONLY = linuxDefines.O_WRONLY;

                POSIX_FADV_NORMAL = IntDefine.toIntDefine(linuxDefines.POSIX_FADV_NORMAL);
                POSIX_FADV_RANDOM = IntDefine.toIntDefine(linuxDefines.POSIX_FADV_RANDOM);
                POSIX_FADV_SEQUENTIAL = IntDefine.toIntDefine(linuxDefines.POSIX_FADV_SEQUENTIAL);
                POSIX_FADV_WILLNEED = IntDefine.toIntDefine(linuxDefines.POSIX_FADV_WILLNEED);

                POSIX_FADV_DONTNEED = IntDefine.toIntDefine(linuxDefines.POSIX_FADV_DONTNEED);
                POSIX_FADV_NOREUSE = IntDefine.toIntDefine(linuxDefines.POSIX_FADV_NOREUSE);

                O_LARGEFILE = IntDefine.toIntDefine(linuxDefines.O_LARGEFILE);
                F_GETLK = linuxDefines.F_GETLK;
                F_GETOWN = linuxDefines.F_GETOWN;
                F_SETOWN = linuxDefines.F_SETOWN;
                O_APPEND = linuxDefines.O_APPEND;
                O_ASYNC = IntDefine.toIntDefine(linuxDefines.O_ASYNC);
                O_CREAT = linuxDefines.O_CREAT;
                O_DSYNC = linuxDefines.O_DSYNC;
                O_EXCL = linuxDefines.O_EXCL;
                O_FSYNC = IntDefine.toIntDefine(linuxDefines.O_FSYNC);
                O_NOCTTY = linuxDefines.O_NOCTTY;
                O_NONBLOCK = linuxDefines.O_NONBLOCK;
                O_RSYNC = IntDefine.toIntDefine(linuxDefines.O_RSYNC);
                O_SYNC = linuxDefines.O_SYNC;
                O_DIRECTORY = linuxDefines.O_DIRECTORY;
                O_NOFOLLOW = linuxDefines.O_NOFOLLOW;
            }
            case DARWIN, FREE_BSD, OPEN_BSD -> {
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
                switch (MultiarchTupelBuilder.getOS()) {
                    case DARWIN -> {
                        AT_EACCESS = DarwinDefines.AT_EACCESS;
                        AT_FDCWD = DarwinDefines.AT_FDCWD;
                        AT_REMOVEDIR = DarwinDefines.AT_REMOVEDIR;
                        AT_SYMLINK_FOLLOW = DarwinDefines.AT_SYMLINK_FOLLOW;
                        AT_SYMLINK_NOFOLLOW = DarwinDefines.AT_SYMLINK_NOFOLLOW;
                        F_DUPFD_CLOEXEC = DarwinDefines.F_DUPFD_CLOEXEC;
                        F_GETLK = DarwinDefines.F_GETLK;
                        F_SETLK = DarwinDefines.F_SETLK;
                        F_SETLKW = DarwinDefines.F_SETLKW;
                        O_CLOEXEC = DarwinDefines.O_CLOEXEC;
                        O_DIRECTORY = DarwinDefines.O_DIRECTORY;
                        O_DSYNC = DarwinDefines.O_DSYNC;
                        O_EXEC = IntDefine.UNDEFINED;
                        O_EXCL = DarwinDefines.O_EXCL;
                        O_NOCTTY = DarwinDefines.O_NOCTTY;
                        O_RSYNC = IntDefine.UNDEFINED;
                        O_SEARCH = IntDefine.UNDEFINED;
                        O_TTY_INIT = IntDefine.UNDEFINED;
                        POSIX_FADV_DONTNEED = IntDefine.UNDEFINED;
                        POSIX_FADV_NOREUSE = IntDefine.UNDEFINED;
                        POSIX_FADV_NORMAL = IntDefine.UNDEFINED;
                        POSIX_FADV_RANDOM = IntDefine.UNDEFINED;
                        POSIX_FADV_SEQUENTIAL = IntDefine.UNDEFINED;
                        POSIX_FADV_WILLNEED = IntDefine.UNDEFINED;
                    }
                    case FREE_BSD -> {
                        AT_EACCESS = FreeBsdDefines.AT_EACCESS;
                        AT_FDCWD = FreeBsdDefines.AT_FDCWD;
                        AT_REMOVEDIR = FreeBsdDefines.AT_REMOVEDIR;
                        AT_SYMLINK_FOLLOW = FreeBsdDefines.AT_SYMLINK_FOLLOW;
                        AT_SYMLINK_NOFOLLOW = FreeBsdDefines.AT_SYMLINK_NOFOLLOW;
                        F_DUPFD_CLOEXEC = FreeBsdDefines.F_DUPFD_CLOEXEC;
                        F_GETLK = FreeBsdDefines.F_GETLK;
                        F_SETLK = FreeBsdDefines.F_SETLK;
                        F_SETLKW = FreeBsdDefines.F_SETLKW;
                        O_CLOEXEC = FreeBsdDefines.O_CLOEXEC;
                        O_DIRECTORY = FreeBsdDefines.O_DIRECTORY;
                        O_DSYNC = FreeBsdDefines.O_DSYNC;
                        O_EXEC = IntDefine.toIntDefine(FreeBsdDefines.O_EXEC);
                        O_EXCL = FreeBsdDefines.O_EXCL;
                        O_NOCTTY = FreeBsdDefines.O_NOCTTY;
                        O_RSYNC = IntDefine.UNDEFINED;
                        O_SEARCH = IntDefine.toIntDefine(FreeBsdDefines.O_SEARCH);
                        O_TTY_INIT = IntDefine.toIntDefine(FreeBsdDefines.O_TTY_INIT);
                        POSIX_FADV_DONTNEED = IntDefine.toIntDefine(FreeBsdDefines.POSIX_FADV_DONTNEED);
                        POSIX_FADV_NOREUSE = IntDefine.toIntDefine(FreeBsdDefines.POSIX_FADV_NOREUSE);
                        POSIX_FADV_NORMAL = IntDefine.toIntDefine(FreeBsdDefines.POSIX_FADV_NORMAL);
                        POSIX_FADV_RANDOM = IntDefine.toIntDefine(FreeBsdDefines.POSIX_FADV_RANDOM);
                        POSIX_FADV_SEQUENTIAL = IntDefine.toIntDefine(FreeBsdDefines.POSIX_FADV_SEQUENTIAL);
                        POSIX_FADV_WILLNEED = IntDefine.toIntDefine(FreeBsdDefines.POSIX_FADV_WILLNEED);
                    }
                    case OPEN_BSD -> {
                        AT_EACCESS = OpenBsdDefines.AT_EACCESS;
                        AT_FDCWD = OpenBsdDefines.AT_FDCWD;
                        AT_REMOVEDIR = OpenBsdDefines.AT_REMOVEDIR;
                        AT_SYMLINK_FOLLOW = OpenBsdDefines.AT_SYMLINK_FOLLOW;
                        AT_SYMLINK_NOFOLLOW = OpenBsdDefines.AT_SYMLINK_NOFOLLOW;
                        F_DUPFD_CLOEXEC = OpenBsdDefines.F_DUPFD_CLOEXEC;
                        F_GETLK = OpenBsdDefines.F_GETLK;
                        F_SETLK = OpenBsdDefines.F_SETLK;
                        F_SETLKW = OpenBsdDefines.F_SETLKW;
                        O_CLOEXEC = OpenBsdDefines.O_CLOEXEC;
                        O_DIRECTORY = OpenBsdDefines.O_DIRECTORY;
                        O_DSYNC = OpenBsdDefines.O_DSYNC;
                        O_EXEC = IntDefine.UNDEFINED;
                        O_EXCL = OpenBsdDefines.O_EXCL;
                        O_NOCTTY = OpenBsdDefines.O_NOCTTY;
                        O_RSYNC = IntDefine.toIntDefine(OpenBsdDefines.O_RSYNC);
                        O_SEARCH = IntDefine.UNDEFINED;
                        O_TTY_INIT = IntDefine.UNDEFINED;
                        POSIX_FADV_DONTNEED = IntDefine.UNDEFINED;
                        POSIX_FADV_NOREUSE = IntDefine.UNDEFINED;
                        POSIX_FADV_NORMAL = IntDefine.UNDEFINED;
                        POSIX_FADV_RANDOM = IntDefine.UNDEFINED;
                        POSIX_FADV_SEQUENTIAL = IntDefine.UNDEFINED;
                        POSIX_FADV_WILLNEED = IntDefine.UNDEFINED;
                    }
                    default ->
                        throw new NoClassDefFoundError("No fcntl.h BSD defines for " + MultiarchTupelBuilder.getMultiarch());
                }
            }
            default ->
                throw new NoClassDefFoundError("No fcntl.h defines for " + MultiarchTupelBuilder.getMultiarch());
        }
    }

    private final static JnhwMh_sI___A_uI.ExceptionErased creat = JnhwMh_sI___A_uI.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "creat",
            BaseDataType.C_int,
            BaseDataType.C_const_char_pointer,
            PosixDataType.mode_t);

    private final static JnhwMh_sI___A_uI creat64 = JnhwMh_sI___A_uI.optionalOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "creat64",
            BaseDataType.C_int,
            BaseDataType.C_const_char_pointer,
            PosixDataType.mode_t);

    private final static JnhwMh_sI__sI_sI_VARARGS_NONE.ExceptionErased fcntl = JnhwMh_sI__sI_sI_VARARGS_NONE.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "fcntl",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI_sI_VARARGS_NONE fcntl64 = JnhwMh_sI__sI_sI_VARARGS_NONE.optionalOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "fcntl64",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI_sI_VARARGS_sI.ExceptionErased fcntl__VARARG_sI = JnhwMh_sI__sI_sI_VARARGS_sI.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "fcntl",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI_sI_VARARGS_sI fcntl64__VARARG_sI = JnhwMh_sI__sI_sI_VARARGS_sI.optionalOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "fcntl64",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_int);

    private final static JnhwMh_sI___A_sI_VARARGS_NONE.ExceptionErased open = JnhwMh_sI___A_sI_VARARGS_NONE.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "open",
            BaseDataType.C_int,
            BaseDataType.C_const_char_pointer,
            BaseDataType.C_int);

    private final static JnhwMh_sI___A_sI_VARARGS_NONE open64 = JnhwMh_sI___A_sI_VARARGS_NONE.optionalOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "open64",
            BaseDataType.C_int,
            BaseDataType.C_const_char_pointer,
            BaseDataType.C_int);

    private final static JnhwMh_sI___A_sI_VARARGS_uI.ExceptionErased open__VARARG_mode_t = JnhwMh_sI___A_sI_VARARGS_uI.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "open",
            BaseDataType.C_int,
            BaseDataType.C_const_char_pointer,
            BaseDataType.C_int,
            PosixDataType.mode_t);

    private final static JnhwMh_sI___A_sI_VARARGS_uI open64__VARARG_mode_t = JnhwMh_sI___A_sI_VARARGS_uI.optionalOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "open64",
            BaseDataType.C_int,
            BaseDataType.C_const_char_pointer,
            BaseDataType.C_int,
            PosixDataType.mode_t);

    private final static JnhwMh_sI__sI__A_sI_VARARGS_NONE.ExceptionErased openat = JnhwMh_sI__sI__A_sI_VARARGS_NONE.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "openat",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_const_char_pointer,
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI__A_sI_VARARGS_uI.ExceptionErased openat__VARARG_mode_t = JnhwMh_sI__sI__A_sI_VARARGS_uI.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "openat",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_const_char_pointer,
            BaseDataType.C_int,
            PosixDataType.mode_t);

    private final static JnhwMh_sI__sI__A_sI_VARARGS_NONE openat64 = JnhwMh_sI__sI__A_sI_VARARGS_NONE.optionalOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "openat64",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_const_char_pointer,
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI__A_sI_VARARGS_uI openat64__VARARG_mode_t = JnhwMh_sI__sI__A_sI_VARARGS_uI.optionalOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "openat64",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_const_char_pointer,
            BaseDataType.C_int,
            PosixDataType.mode_t);

    private final static JnhwMh_sI__sI_sL_sL_sI posix_fadvise = JnhwMh_sI__sI_sL_sL_sI.optionalOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "posix_fadvise",
            BaseDataType.C_int,
            BaseDataType.C_int,
            PosixDataType.off_t,
            PosixDataType.off_t,
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI_sL_sL_sI posix_fadvise64 = JnhwMh_sI__sI_sL_sL_sI.optionalOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "posix_fadvise64",
            BaseDataType.C_int,
            BaseDataType.C_int,
            PosixDataType.off_t,
            PosixDataType.off_t,
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI_sL_sL.ExceptionErased posix_fallocate = JnhwMh_sI__sI_sL_sL.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "posix_fallocate",
            BaseDataType.C_int,
            BaseDataType.C_int,
            PosixDataType.off_t,
            PosixDataType.off_t);

    private final static JnhwMh_sI__sI_sL_sL posix_fallocate64 = JnhwMh_sI__sI_sL_sL.optionalOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "posix_fallocate64",
            BaseDataType.C_int,
            BaseDataType.C_int,
            PosixDataType.off_t,
            PosixDataType.off_t);

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/creat.html">creat
     * - create a new file or rewrite an existing one</a>.
     *
     * @param path the pathname naming the file.
     * @param mode the file access modes from {@link Stat}.
     * @return a handle to the opend file.
     *
     */
    public final static int creat(String path, @mode_t int mode) throws NativeErrorException {
        try (MemorySession ms = MemorySession.openConfined()) {
            MemorySegment _path = MemorySegment.allocateNative(path.length() + 1, ms);
            _path.setUtf8String(0, path);
            final int result = creat.invoke_sI___A_uI(_path, mode);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            }
            return result;
        }
    }

    /**
     * <b>Linux:</b> Available if _LARGEFILE64_SOURCE is defined.
     *
     * @param path the pathname naming the file.
     * @param mode the file access modes from {@link Stat}.
     * @return a handle to the opend file.
     *
     * @throws NoSuchNativeMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static int creat64(String path, @mode_t int mode) throws NativeErrorException, NoSuchNativeMethodException {
        try (MemorySession ms = MemorySession.openConfined()) {
            MemorySegment _path = MemorySegment.allocateNative(path.length() + 1, ms);
            _path.setUtf8String(0, path);
            final int result = creat64.invoke_sI___A_uI(_path, mode);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            }
            return result;
        }
    }

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
    public final static int fcntl(int fildes, int cmd) throws NativeErrorException {
        final int result = fcntl.invoke_sI__sI_sI(fildes, cmd);
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        } else {
            return result;
        }
    }

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
    public final static int fcntl(int fildes, int cmd, int vararg_0) throws NativeErrorException {
        final int result = fcntl__VARARG_sI.invoke_sI__sI_sI_sI(fildes, cmd, vararg_0);
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        } else {
            return result;
        }
    }

    /**
     *
     * <b>Linux:</b> Available if _LARGEFILE64_SOURCE is defined.
     *
     * @param fildes a file descriptor
     * @param cmd the available values for cmd are defined in fcntl.h.
     * @return the value returned shall depend on cmd.
     *
     * @throws NoSuchNativeMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static int fcntl64(int fildes, int cmd) throws NativeErrorException, NoSuchNativeMethodException {
        final int result = fcntl64.invoke_sI__sI_sI(fildes, cmd);
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        } else {
            return result;
        }
    }

    /**
     *
     * <b>Linux:</b> Available if _LARGEFILE64_SOURCE is defined.
     *
     * @param fildes a file descriptor
     * @param cmd the available values for cmd are defined in fcntl.h.
     * @param vararg_0 the arg for some cmd.
     * @return the value returned shall depend on cmd.
     *
     * @throws NoSuchNativeMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static int fcntl64(int fildes, int cmd, int vararg_0) throws NativeErrorException, NoSuchNativeMethodException {
        final int result = fcntl64__VARARG_sI.invoke_sI__sI_sI_sI(fildes, cmd, vararg_0);
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        } else {
            return result;
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/open.html">open,
     * openat - open file</a>.
     *
     * @param path the pathname naming the file.
     * @param oflag the open flags.
     * @return a handle to the opend file.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int open(String path, int oflag) throws NativeErrorException {
        try (MemorySession ms = MemorySession.openConfined()) {
            MemorySegment _path = MemorySegment.allocateNative(path.length() + 1, ms);
            _path.setUtf8String(0, path);
            final int result = open.invoke_sI___A_sI(_path, oflag);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            } else {
                return result;
            }
        }
    }

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
     */
    public final static int open(String path, int oflag, @mode_t int mode) throws NativeErrorException {
        try (MemorySession ms = MemorySession.openConfined()) {
            MemorySegment _path = MemorySegment.allocateNative(path.length() + 1, ms);
            _path.setUtf8String(0, path);
            final int result = open__VARARG_mode_t.invoke_sI___A_sI_uI(_path, oflag, mode);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            }
            return result;
        }
    }

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
     * @throws NoSuchNativeMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static int open64(String path, int oflag) throws NativeErrorException, NoSuchNativeMethodException {
        try (MemorySession ms = MemorySession.openConfined()) {
            MemorySegment _path = MemorySegment.allocateNative(path.length() + 1, ms);
            _path.setUtf8String(0, path);
            final int result = open64.invoke_sI___A_sI(_path, oflag);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            }
            return result;
        }
    }

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
     * @throws NoSuchNativeMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static int open64(String path, int oflag, @mode_t int mode) throws NativeErrorException, NoSuchNativeMethodException {
        try (MemorySession ms = MemorySession.openConfined()) {
            MemorySegment _path = MemorySegment.allocateNative(path.length() + 1, ms);
            _path.setUtf8String(0, path);
            final int result = open64__VARARG_mode_t.invoke_sI___A_sI_uI(_path, oflag, mode);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            } else {
                return result;
            }
        }
    }

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
     */
    public final static int openat(int fd, String path, int oflag) throws NativeErrorException {
        try (MemorySession ms = MemorySession.openConfined()) {
            MemorySegment _path = MemorySegment.allocateNative(path.length() + 1, ms);
            _path.setUtf8String(0, path);
            final int result = openat.invoke_sI__sI__A_sI(fd, _path, oflag);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            } else {
                return result;
            }
        }
    }

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
     */
    public final static int openat(int fd, String path, int oflag, @mode_t int mode) throws NativeErrorException {
        try (MemorySession ms = MemorySession.openConfined()) {
            MemorySegment _path = MemorySegment.allocateNative(path.length() + 1, ms);
            _path.setUtf8String(0, path);
            final int result = openat__VARARG_mode_t.invoke_sI__sI__A_sI_uI(fd, _path, oflag, mode);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            } else {
                return result;
            }
        }
    }

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
     * @throws NoSuchNativeMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static int openat64(int fd, String path, int oflag) throws NativeErrorException, NoSuchNativeMethodException {
        try (MemorySession ms = MemorySession.openConfined()) {
            MemorySegment _path = MemorySegment.allocateNative(path.length() + 1, ms);
            _path.setUtf8String(0, path);
            final int result = openat64.invoke_sI__sI__A_sI(fd, _path, oflag);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            } else {
                return result;
            }
        }
    }

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
     * @throws NoSuchNativeMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static int openat64(int fd, String path, int oflag, @mode_t int mode) throws NativeErrorException, NoSuchNativeMethodException {
        try (MemorySession ms = MemorySession.openConfined()) {
            MemorySegment _path = MemorySegment.allocateNative(path.length() + 1, ms);
            _path.setUtf8String(0, path);
            final int result = openat64__VARARG_mode_t.invoke_sI__sI__A_sI_uI(fd, _path, oflag, mode);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            }
            return result;
        }
    }

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
     * @throws NoSuchNativeMethodException
     */
    public final static void posix_fadvise(int fildes, @off_t long offset, @off_t long len, int advice) throws NativeErrorException, NoSuchNativeMethodException {
        if (posix_fadvise.invoke_sI__sI_sL_sL_sI(fildes, offset, len, advice) == -1) {
            throw new NativeErrorException(Errno.errno());
        }
    }

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
     * @throws NoSuchNativeMethodException
     */
    public final static void posix_fadvise64(int fildes, @off64_t long offset, @off64_t long len, int advice) throws NativeErrorException, NoSuchNativeMethodException {
        if (posix_fadvise64.invoke_sI__sI_sL_sL_sI(fildes, offset, len, advice) == -1) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/posix_fallocate.html">posix_fallocate
     * - file space control (ADVANCED REALTIME)</a>.
     *
     * @param fildes a file descriptor
     * @param offset the offset.
     * @param len the length.
     *
     * @throws NoSuchNativeMethodException
     */
    public final static void posix_fallocate(int fildes, @off_t long offset, @off_t long len) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            if (posix_fallocate.invoke_sI__sI_sL_sL(fildes, offset, len) == -1) {
                throw new NativeErrorException(Errno.errno());
            }
        } catch (NullPointerException npe) {
            if (posix_fallocate == null) {
                throw new NoSuchNativeMethodException("posix_fallocate");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>Linux:</b> Available if _LARGEFILE64_SOURCE is defined.
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/posix_fallocate.html">posix_fallocate
     * - file space control (ADVANCED REALTIME)</a>.
     *
     * @param fildes a file descriptor
     * @param offset the offset.
     * @param len the length.
     *
     * @throws NoSuchNativeMethodException
     */
    public final static void posix_fallocate64(int fildes, @off64_t long offset, @off64_t long len) throws NativeErrorException, NoSuchNativeMethodException {
        if (posix_fallocate64.invoke_sI__sI_sL_sL(fildes, offset, len) == -1) {
            throw new NativeErrorException(Errno.errno());
        }
    }

}
