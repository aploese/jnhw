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
import de.ibapl.jnhw.annontation.posix.sys.types.mode_t;
import de.ibapl.jnhw.annontation.posix.sys.types.off64_t;
import de.ibapl.jnhw.annontation.posix.sys.types.off_t;
import de.ibapl.jnhw.common.util.IntDefine;
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

        HAVE_FCNTL_H = false;

        AT_EACCESS = 0;
        AT_FDCWD = 0;
        AT_REMOVEDIR = 0;
        AT_SYMLINK_FOLLOW = 0;
        AT_SYMLINK_NOFOLLOW = 0;

        FD_CLOEXEC = 0;

        F_DUPFD = 0;
        F_DUPFD_CLOEXEC = 0;
        F_GETFD = 0;
        F_GETFL = 0;
        F_GETLK = 0;
        F_GETOWN = 0;
        F_RDLCK = 0;
        F_SETFD = 0;
        F_SETFL = 0;
        F_SETLK = 0;
        F_SETLKW = 0;
        F_SETOWN = 0;
        F_UNLCK = 0;
        F_WRLCK = 0;

        O_ACCMODE = 0;
        O_APPEND = 0;
        O_ASYNC = IntDefine.UNDEFINED;
        O_CLOEXEC = 0;
        O_CREAT = 0;
        O_DIRECTORY = 0;
        O_DSYNC = IntDefine.UNDEFINED;
        O_EXCL = 0;
        O_EXEC = IntDefine.UNDEFINED;
        O_FSYNC = IntDefine.UNDEFINED;
        O_LARGEFILE = IntDefine.UNDEFINED;
        O_NOCTTY = 0;
        O_NOFOLLOW = 0;
        O_NONBLOCK = 0;
        O_RDONLY = 0;
        O_RDWR = 0;
        O_RSYNC = IntDefine.UNDEFINED;
        O_SEARCH = IntDefine.UNDEFINED;
        O_SYNC = 0;
        O_TRUNC = 0;
        O_TTY_INIT = IntDefine.UNDEFINED;
        O_WRONLY = 0;

        POSIX_FADV_DONTNEED = IntDefine.UNDEFINED;
        POSIX_FADV_NOREUSE = IntDefine.UNDEFINED;
        POSIX_FADV_NORMAL = IntDefine.UNDEFINED;
        POSIX_FADV_RANDOM = IntDefine.UNDEFINED;
        POSIX_FADV_SEQUENTIAL = IntDefine.UNDEFINED;
        POSIX_FADV_WILLNEED = IntDefine.UNDEFINED;

        SEEK_CUR = 0;
        SEEK_END = 0;
        SEEK_SET = 0;

        initFields();
    }

    private static native void initFields();

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
    public final static IntDefine O_DSYNC;

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
    public final static native int creat(String path, @mode_t int mode) throws NativeErrorException;

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
    public final static native int creat64(String path, @mode_t int mode) throws NativeErrorException, NoSuchNativeMethodException;

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
    public final static native int open(String path, int oflag) throws NativeErrorException;

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
    public final static native int open(String path, int oflag, @mode_t int mode) throws NativeErrorException;

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
    public final static native int open64(String path, int oflag) throws NativeErrorException, NoSuchNativeMethodException;

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
    public final static native int open64(String path, int oflag, @mode_t int mode) throws NativeErrorException, NoSuchNativeMethodException;

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
    public final static native int openat(int fd, String path, int oflag) throws NativeErrorException;

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
    public final static native int openat(int fd, String path, int oflag, @mode_t int mode) throws NativeErrorException;

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
    public final static native int openat64(int fd, String path, int oflag) throws NativeErrorException, NoSuchNativeMethodException;

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
    public final static native int openat64(int fd, String path, int oflag, @mode_t int mode) throws NativeErrorException, NoSuchNativeMethodException;

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

    private Fcntl() {
    }

}
