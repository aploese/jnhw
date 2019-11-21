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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.NotDefinedException;
import de.ibapl.jnhw.posix.sys.Stat;
import de.ibapl.jnhw.posix.sys.Types.mode_t;
import de.ibapl.jnhw.posix.sys.Types.off64_t;
import de.ibapl.jnhw.posix.sys.Types.off_t;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Wrapper around the {@code <fcntl.h>} header.
 *
 * <p>
 * <b>Todo:</b> struct flock, flock64
 * </p>
 *
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/fcntl.h.html">errno.h
 * - system error numbers</a>.
 *
 * @author aploese
 */
@Include("#include <fcntl.h>")
public final class Fcntl {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    /**
     * <b>POSIX:</b> Check access using effective user and group ID.
     *
     * @return the native symbolic constant of AT_AT_EACCESS.
     */
    @Define
    public final static native int AT_EACCESS();

    /**
     * <b>POSIX:</b> Use the current working directory to determine the target.
     * of relative file paths.
     *
     * @return the native symbolic constant of AT_FDCWD.
     */
    @Define
    public final static native int AT_FDCWD();

    /**
     * <b>POSIX:</b> Remove directory instead of file.
     *
     * @return the native symbolic constant of AT_REMOVEDIR.
     */
    @Define
    public final static native int AT_REMOVEDIR();

    /**
     * <b>POSIX:</b> Follow symbolic link.
     *
     * @return the native symbolic constant of AT_SYMLINK_FOLLOW.
     */
    @Define
    public final static native int AT_SYMLINK_FOLLOW();

    /**
     * <b>POSIX:</b> Do not follow symbolic links.
     *
     * @return the native symbolic constant of AT_SYMLINK_NOFOLLOW.
     */
    @Define
    public final static native int AT_SYMLINK_NOFOLLOW();

    /**
     * <b>POSIX:</b> Close the file descriptor upon execution of an exec family
     * function.
     *
     * @return the native symbolic constant of FD_CLOEXEC.
     */
    @Define
    public final static native int FD_CLOEXEC();

    /**
     * <b>POSIX:</b> .
     *
     * @return the native symbolic constant of .
     */
    @Define
    public final static native int FNONBLOCK();

    /**
     * <b>POSIX:</b> Duplicate file descriptor.
     *
     * @return the native symbolic constant of F_DUPFD.
     */
    @Define
    public final static native int F_DUPFD();

    /**
     * <b>POSIX:</b> Duplicate file descriptor with the close-on- exec flag
     * FD_CLOEXEC set.
     *
     * @return the native symbolic constant of F_DUPFD_CLOEXEC.
     */
    @Define
    public final static native int F_DUPFD_CLOEXEC();

    /**
     * <b>POSIX:</b> et file descriptor flags.
     *
     * @return the native symbolic constant of F_GETFD.
     */
    @Define
    public final static native int F_GETFD();

    /**
     * <b>POSIX:</b> Get file status flags and file access modes.
     *
     * @return the native symbolic constant of F_GETFL.
     */
    @Define
    public final static native int F_GETFL();

    /**
     * <b>POSIX:</b> Get record locking information.
     *
     * @return the native symbolic constant of F_GETLK.
     */
    @Define
    public final static native int F_GETLK();

    /**
     * <b>POSIX:</b> Get process or process group ID to receive SIGURG signals.
     *
     * @return the native symbolic constant of F_GETOWN.
     */
    @Define
    public final static native int F_GETOWN();

    /**
     * <b>POSIX:</b> Shared or read lock.
     *
     * @return the native symbolic constant of F_RDLCK.
     */
    @Define
    public final static native int F_RDLCK();

    /**
     * <b>POSIX:</b> Set file descriptor flags.
     *
     * @return the native symbolic constant of F_SETFD.
     */
    @Define
    public final static native int F_SETFD();

    /**
     * <b>POSIX:</b> Set file status flags.
     *
     * @return the native symbolic constant of F_SETFL.
     */
    @Define
    public final static native int F_SETFL();

    /**
     * <b>POSIX:</b> Set record locking information.
     *
     * @return the native symbolic constant of F_SETLK.
     */
    @Define
    public final static native int F_SETLK();

    /**
     * <b>POSIX:</b> Set record locking information; wait if blocked.
     *
     * @return the native symbolic constant of F_SETLKW.
     */
    @Define
    public final static native int F_SETLKW();

    /**
     * <b>POSIX:</b> Set process or process group ID to receive SIGURG signals.
     *
     * @return the native symbolic constant of F_SETOWN.
     */
    @Define
    public final static native int F_SETOWN();

    /**
     * <b>POSIX:</b> Unlock.
     *
     * @return the native symbolic constant of F_UNLCK.
     */
    @Define
    public final static native int F_UNLCK();

    /**
     * <b>POSIX:</b> Exclusive or write lock.
     *
     * @return the native symbolic constant of F_WRLCK.
     */
    @Define
    public final static native int F_WRLCK();

    public final static native boolean HAVE_FCNTL_H();

    /**
     * <b>POSIX:</b> Mask for file access modes.
     *
     * @return the native symbolic constant of O_ACCMODE.
     */
    @Define
    public final static native int O_ACCMODE();

    /**
     * <b>POSIX:</b> Set append mode.
     *
     * @return the native symbolic constant of O_APPEND.
     */
    @Define
    public final static native int O_APPEND();

    /**
     * <b>Non POSIX:</b> Enable signal-driven I/O.
     *
     * @return the native symbolic constant of .
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int O_ASYNC() throws NotDefinedException;

    /**
     * <b>POSIX:</b> The FD_CLOEXEC flag associated with the new descriptor
     * shall be set to close the file descriptor upon execution of an exec
     * family function.
     *
     * @return the native symbolic constant of O_CLOEXEC.
     */
    @Define
    public final static native int O_CLOEXEC();

    /**
     * <b>POSIX:</b> Create file if it does not exist.
     *
     * @return the native symbolic constant of O_CREAT.
     */
    @Define
    public final static native int O_CREAT();

    /**
     * <b>POSIX:</b> Fail if file is a non-directory file.
     *
     * @return the native symbolic constant of O_DIRECTORY.
     */
    @Define
    public final static native int O_DIRECTORY();

    /**
     * <b>POSIX.SIO:</b> Write according to synchronized I/O data integrity
     * completion.
     *
     * @return the native symbolic constant of O_DSYNC.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int O_DSYNC() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Exclusive use flag.
     *
     * @return the native symbolic constant of O_EXCL.
     */
    @Define
    public final static native int O_EXCL();

    /**
     * <b>POSIX:</b> Open for execute only (non-directory files).The result is
     * unspecified if this flag is applied to a directory.
     *
     * @return the native symbolic constant of O_EXEC.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int O_EXEC() throws NotDefinedException;

    /**
     * <b>Non POSIX:</b> enables synchronous writing for the file. .
     *
     * @return the native symbolic constant of O_FSYNC.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int O_FSYNC() throws NotDefinedException;

    /**
     * <b>Linux:</b> (LFS) Allow files whose sizes cannot be represented in an
     * off_t (but can be represented in an off64_t) to be opened. The
     * _LARGEFILE64_SOURCE macro must be defined (before including any header
     * files) in order to obtain this definition. Setting the _FILE_OFFSET_BITS
     * feature test macro to 64 (rather than using O_LARGEFILE) is the preferred
     * method of accessing large files on 32-bit systems (see
     * feature_test_macros(7)). .
     *
     * @return the native symbolic constant of O_LARGEFILE.
     */
    @Define
    public final static native int O_LARGEFILE();

    /**
     * <b>POSIX:</b> Do not assign controlling terminal.
     *
     * @return the native symbolic constant of O_NOCTTY.
     */
    @Define
    public final static native int O_NOCTTY();

    /**
     * <b>POSIX:</b> Do not follow symbolic links.
     *
     * @return the native symbolic constant of O_NOFOLLOW.
     */
    @Define
    public final static native int O_NOFOLLOW();

    /**
     * <b>POSIX:</b> Non-blocking mode.
     *
     * @return the native symbolic constant of O_NONBLOCK.
     */
    @Define
    public final static native int O_NONBLOCK();

    /**
     * <b>POSIX:</b> Open for reading only.
     *
     * @return the native symbolic constant of O_RDONLY.
     */
    @Define
    public final static native int O_RDONLY();

    /**
     * <b>POSIX:</b> Open for reading and writing.
     *
     * @return the native symbolic constant of O_RDWR.
     */
    @Define
    public final static native int O_RDWR();

    /**
     * <b>POSIX.SIO:</b> Synchronized read I/O operations.
     *
     * @return the native symbolic constant of O_RSYNC.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int O_RSYNC() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Open directory for search only. The result is unspecified
     * if this flag is applied to a non-directory file.
     *
     * @return the native symbolic constant of O_SEARCH.
     */
    @Define
    public final static native int O_SEARCH();

    /**
     * <b>POSIX:</b> Write according to synchronized I/O file integrity
     * completion.
     *
     * @return the native symbolic constant of O_SYNC.
     */
    @Define
    public final static native int O_SYNC();

    /**
     * <b>POSIX:</b> Truncate flag.
     *
     * @return the native symbolic constant of O_TRUNC.
     */
    @Define
    public final static native int O_TRUNC();

    /**
     * <b>POSIX:</b> Set the termios structure terminal parameters to a state
     * that provides conforming behavior.
     *
     * @return the native symbolic constant of O_TTY_INIT.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int O_TTY_INIT() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Open for writing only.
     *
     * @return the native symbolic constant of O_WRONLY.
     */
    @Define
    public final static native int O_WRONLY();

    /**
     * <b>POSIX.ADV:</b> The application expects that it will not access the
     * specified data in the near future.
     *
     * @return the native symbolic constant of POSIX_FADV_DONTNEED.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int POSIX_FADV_DONTNEED() throws NotDefinedException;

    /**
     * <b>POSIX.ADV:</b> The application expects to access the specified data
     * once and then not reuse it thereafter.
     *
     * @return the native symbolic constant of POSIX_FADV_NOREUSE.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int POSIX_FADV_NOREUSE() throws NotDefinedException;

    /**
     * <b>POSIX.ADV:</b> The application has no advice to give on its behavior
     * with respect to the specified data.It is the default characteristic if no
     * advice is given for an open file.
     *
     * @return the native symbolic constant of POSIX_FADV_NORMAL.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int POSIX_FADV_NORMAL() throws NotDefinedException;

    /**
     * <b>POSIX.ADV:</b> The application expects to access the specified data in
     * a random order.
     *
     * @return the native symbolic constant of POSIX_FADV_RANDOM.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int POSIX_FADV_RANDOM() throws NotDefinedException;

    /**
     * <b>POSIX.ADV:</b> The application expects to access the specified data
     * sequentially from lower offsets to higher offsets.
     *
     * @return the native symbolic constant of POSIX_FADV_SEQUENTIAL.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int POSIX_FADV_SEQUENTIAL() throws NotDefinedException;

    /**
     * <b>POSIX.ADV:</b> The application expects to access the specified data in
     * the near future.
     *
     * @return the native symbolic constant of POSIX_FADV_WILLNEED.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int POSIX_FADV_WILLNEED() throws NotDefinedException;

    /**
     * <b>POSIX:</b> same as defined in stdio.h.
     *
     * @return the native symbolic constant of SEEK_CUR.
     */
    @Define
    public final static native int SEEK_CUR();

    /**
     * <b>POSIX:</b> same as defined in stdio.h.
     *
     * @return the native symbolic constant of SEEK_END.
     */
    @Define
    public final static native int SEEK_END();

    /**
     * <b>POSIX:</b> same as defined in stdio.h.
     *
     * @return the native symbolic constant of SEEK_SET.
     */
    @Define
    public final static native int SEEK_SET();

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
     * @throws de.ibapl.jnhw.NoSuchMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static native int creat64(String path, @mode_t int mode) throws NativeErrorException, de.ibapl.jnhw.NoSuchMethodException;

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
     * @throws de.ibapl.jnhw.NoSuchMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static native int fcntl64(int fildes, int cmd) throws NativeErrorException, de.ibapl.jnhw.NoSuchMethodException;

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
     * @throws de.ibapl.jnhw.NoSuchMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static native int fcntl64(int fildes, int cmd, int vararg_0) throws NativeErrorException, de.ibapl.jnhw.NoSuchMethodException;

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
     * @throws de.ibapl.jnhw.NoSuchMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static native int open64(String path, int oflag) throws NativeErrorException, de.ibapl.jnhw.NoSuchMethodException;

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
     * @throws de.ibapl.jnhw.NoSuchMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static native int open64(String path, int oflag, @mode_t int mode) throws NativeErrorException, de.ibapl.jnhw.NoSuchMethodException;

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
     * @throws de.ibapl.jnhw.NoSuchMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static native int openat64(int fd, String path, int oflag) throws NativeErrorException, de.ibapl.jnhw.NoSuchMethodException;

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
     * @throws de.ibapl.jnhw.NoSuchMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static native int openat64(int fd, String path, int oflag, @mode_t int mode) throws NativeErrorException, de.ibapl.jnhw.NoSuchMethodException;

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
    public final static native void posix_fadvise(int fildes, @off_t long offset, @off_t long len, int advice) throws NativeErrorException;

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
     * @throws de.ibapl.jnhw.NoSuchMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static native void posix_fadvise64(int fildes, @off64_t long offset, @off64_t long len, int advice) throws NativeErrorException, de.ibapl.jnhw.NoSuchMethodException;

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
    public final static native void posix_fallocate(int fildes, @off_t long offset, @off_t long len) throws NativeErrorException;

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
     * @throws de.ibapl.jnhw.NoSuchMethodException if _LARGEFILE64_SOURCE is not
     * defined. returns an error code.
     */
    public final static native void posix_fallocate64(int fildes, @off64_t long offset, @off64_t long len) throws NativeErrorException, de.ibapl.jnhw.NoSuchMethodException;

    private Fcntl() {
    }

    /**
     * See specs at:
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/fcntl.h.html">{@code typedef
     * pid_t}</a>.
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sys/types.h.html">{@code typedef
     * pid_t}</a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @interface pid_t {
    }

}
