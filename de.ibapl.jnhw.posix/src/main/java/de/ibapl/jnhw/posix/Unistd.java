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
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.OpaqueMemory64;
import de.ibapl.jnhw.common.util.ByteBufferUtils;
import de.ibapl.jnhw.annotation.posix.sys.types.gid_t;
import de.ibapl.jnhw.annotation.posix.sys.types.off64_t;
import de.ibapl.jnhw.annotation.posix.sys.types.off_t;
import de.ibapl.jnhw.annotation.posix.sys.types.pid_t;
import de.ibapl.jnhw.annotation.posix.sys.types.size_t;
import de.ibapl.jnhw.annotation.posix.sys.types.ssize_t;
import de.ibapl.jnhw.annotation.posix.sys.types.uid_t;
import de.ibapl.jnhw.annotation.posix.sys.types.useconds_t;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.Int8_t;
import de.ibapl.jnhw.common.util.IntDefine;
import de.ibapl.jnhw.libloader.MultiarchInfo;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/**
 * Wrapper around the {@code <stdio.h>} header.
 *
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/unistd.h.html">unistd.h
 * - standard symbolic constants and types</a>.
 *
 * @author aploese
 */
@Include("#include <unistd.h>")
public final class Unistd {

    public static interface LinuxDefines {

        public final static long _POSIX_VERSION = 200809L;
        public final static int _SC_AIO_LISTIO_MAX = 23;
        public final static int _SC_AIO_MAX = 24;
        public final static int _SC_AIO_PRIO_DELTA_MAX = 25;
        public final static int SEEK_CUR = 1;
        public final static int SEEK_DATA = 3;
        public final static int SEEK_END = 2;
        public final static int SEEK_HOLE = 4;
        public final static int SEEK_SET = 0;
        public final static int STDERR_FILENO = 2;
        public final static int STDIN_FILENO = 0;
        public final static int STDOUT_FILENO = 1;
    }

    public static interface BsdDefines {

        public final static int _SC_AIO_LISTIO_MAX = 42;
        public final static int _SC_AIO_MAX = 43;
        public final static int _SC_AIO_PRIO_DELTA_MAX = 44;
        public final static int SEEK_CUR = 1;
        public final static int SEEK_END = 2;
        public final static int SEEK_SET = 0;
        public final static int STDERR_FILENO = 2;
        public final static int STDIN_FILENO = 0;
        public final static int STDOUT_FILENO = 1;
    }

    public static interface DarwinDefines extends BsdDefines {

        public final static long _POSIX_VERSION = 200112;
        public final static int SEEK_DATA = 4;
        public final static int SEEK_HOLE = 3;

    }

    public static interface FreeBsdDefines extends BsdDefines {

        public final static long _POSIX_VERSION = 200112;
        public final static int SEEK_DATA = 3;
        public final static int SEEK_HOLE = 4;

    }

    public static interface OpenBsdDefines extends BsdDefines {

        public final static long _POSIX_VERSION = 200809;
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
        switch (multiarchInfo.getOS()) {
            case LINUX:
                HAVE_UNISTD_H = true;
                _POSIX_VERSION = LinuxDefines._POSIX_VERSION;
                _SC_AIO_LISTIO_MAX = LinuxDefines._SC_AIO_LISTIO_MAX;
                _SC_AIO_MAX = LinuxDefines._SC_AIO_MAX;
                _SC_AIO_PRIO_DELTA_MAX = LinuxDefines._SC_AIO_PRIO_DELTA_MAX;
                SEEK_CUR = LinuxDefines.SEEK_CUR;
                SEEK_DATA = IntDefine.toIntDefine(LinuxDefines.SEEK_DATA);
                SEEK_END = LinuxDefines.SEEK_END;
                SEEK_HOLE = IntDefine.toIntDefine(LinuxDefines.SEEK_HOLE);
                SEEK_SET = LinuxDefines.SEEK_SET;
                STDERR_FILENO = LinuxDefines.STDERR_FILENO;
                STDIN_FILENO = LinuxDefines.STDIN_FILENO;
                STDOUT_FILENO = LinuxDefines.STDOUT_FILENO;
                break;
            case DARWIN:
            case FREE_BSD:
            case OPEN_BSD:
                HAVE_UNISTD_H = true;
                _SC_AIO_LISTIO_MAX = BsdDefines._SC_AIO_LISTIO_MAX;
                _SC_AIO_MAX = BsdDefines._SC_AIO_MAX;
                _SC_AIO_PRIO_DELTA_MAX = BsdDefines._SC_AIO_PRIO_DELTA_MAX;
                SEEK_CUR = BsdDefines.SEEK_CUR;
                SEEK_END = BsdDefines.SEEK_END;
                SEEK_SET = BsdDefines.SEEK_SET;
                STDERR_FILENO = BsdDefines.STDERR_FILENO;
                STDIN_FILENO = BsdDefines.STDIN_FILENO;
                STDOUT_FILENO = BsdDefines.STDOUT_FILENO;
                switch (multiarchInfo.getOS()) {
                    case DARWIN:
                        _POSIX_VERSION = DarwinDefines._POSIX_VERSION;
                        SEEK_DATA = IntDefine.toIntDefine(DarwinDefines.SEEK_DATA);
                        SEEK_HOLE = IntDefine.toIntDefine(DarwinDefines.SEEK_HOLE);
                        break;
                    case FREE_BSD:
                        _POSIX_VERSION = FreeBsdDefines._POSIX_VERSION;
                        SEEK_DATA = IntDefine.toIntDefine(FreeBsdDefines.SEEK_DATA);
                        SEEK_HOLE = IntDefine.toIntDefine(FreeBsdDefines.SEEK_HOLE);
                        break;
                    case OPEN_BSD:
                        _POSIX_VERSION = OpenBsdDefines._POSIX_VERSION;
                        SEEK_DATA = IntDefine.UNDEFINED;
                        SEEK_HOLE = IntDefine.UNDEFINED;
                        break;
                    default:
                        throw new NoClassDefFoundError("No unistd.h BSD defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
                }
                break;
            default:
                throw new NoClassDefFoundError("No unistd.h defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
        }
    }

    public final static boolean HAVE_UNISTD_H;

    /**
     * <b>POSIX:</b> variable: {AIO_LISTIO_MAX}.
     *
     */
    @Define
    public final static int _SC_AIO_LISTIO_MAX;

    /**
     * <b>POSIX:</b> variable: {AIO_MAX}.
     *
     */
    @Define
    public final static int _SC_AIO_MAX;

    /**
     * <b>POSIX:</b> variable: {AIO_PRIO_DELTA_MAX}.
     *
     */
    @Define
    public final static int _SC_AIO_PRIO_DELTA_MAX;

    /**
     * <b>POSIX:</b>seek relative to current position. This must be the same
     * value as {@link de.ibapl.jnhw.posix.Stdio.SEEK_CUR()}.
     *
     */
    @Define
    public final static int SEEK_CUR;

    /**
     * <b>Linux,Apple:</b> Adjust the file offset to the next location in the
     * file greater than or equal to offset containing data.
     *
     */
    @Define
    public final static IntDefine SEEK_DATA;

    /**
     * <b>POSIX:</b> Seek relative to end-of-file. This must be the same value
     * as {@link de.ibapl.jnhw.posix.Stdio.SEEK_END}.
     *
     */
    @Define
    public final static int SEEK_END;

    /**
     * <b>POSIX:</b> Adjust the file offset to the next hole in the file greater
     * than or equal to offset.
     *
     */
    @Define
    public final static IntDefine SEEK_HOLE;

    /**
     * <b>POSIX:</b> Seek relative to start-of-file. This must be the same value
     * as {@link de.ibapl.jnhw.posix.Stdio.SEEK_SET}.
     *
     */
    @Define
    public final static int SEEK_SET;

    /**
     * <b>POSIX:</b> File number of stderr; 2.
     *
     */
    @Define
    public final static int STDERR_FILENO;

    /**
     * <b>POSIX:</b> File number of stdin; 0.
     *
     */
    @Define
    public final static int STDIN_FILENO;

    /**
     * <b>POSIX:</b> File number of stdout; 1.
     *
     */
    @Define
    public final static int STDOUT_FILENO;

    /**
     * <b>POSIX:</b> Integer value indicating version of this standard
     * (C-language binding) to which the implementation conforms.
     *
     */
    @Define
    public final static long _POSIX_VERSION;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/close.html">close
     * - close a file descriptor</a>.
     *
     * @param fildes an open file descriptor.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void close(int fildes) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/fsync.html">fsync
     * - synchronize changes to a file</a>.
     *
     * @param fildes a valid filedescriptor.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void fsync(int fildes) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/getgid.html">getgid
     * - get the real group ID</a>.
     *
     * @return the real group ID
     */
    public final native static @gid_t
    int getgid();

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/getegid.html">getegid
     * - get the effective group ID</a>.
     */
    public final native static @gid_t
    int getegid();

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/setgid.html">setgid
     * - set group ID</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final native static void setgid(@gid_t int gid) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/setegid.html">setegid
     * - set effective user ID</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final native static void setegid(@gid_t int gid) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/setregid.html">setregid
     * - set real and effective group IDs</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final native static void setregid(@gid_t int rgid, @gid_t int egid) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/geteuid.html">geteuid
     * - get the effective user ID</a>.
     */
    public final native static @uid_t
    int geteuid();

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/seteuid.html">seteuid
     * - set effective user ID</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final native static void seteuid(@uid_t int uid) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/getpgrp.html">getpgrp
     * - get the process group ID of the calling process</a>.
     */
    public final native static @pid_t
    int getpgrp();

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/getpid.html">getpid
     * - get the process ID</a>.
     */
    public final native static @pid_t
    int getpid();

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/getppid.html">getppid
     * - get the parent process ID</a>.
     */
    public final native static @pid_t
    int getppid();

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/setreuid.html">setreuid
     * - set real and effective user IDs</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final native static void setreuid(@uid_t int ruid, @uid_t int euid) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/getuid.html">getuid
     * - get a real user ID</a>.
     */
    public final native static @uid_t
    int getuid();

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/setuid.html">setuid
     * - set user ID</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final native static void setuid(@uid_t int uid) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/lseek.html">lseek
     * - move the read/write file offset</a>.
     *
     * @param fildes a valid file descriptor.
     * @param offset depending on the size of @see SizeOf.off_t {@code int} or
     * {@code long} may be used.
     * @param whence one of
     * {@link SEEK_SET}, {@link SEEK_CUR}, {@link SEEK_END}.
     * @return the position depending on the size of @see SizeOf.off_t
     * {@code int} or {@code long} may be used.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native @off_t
    int lseek(int fildes, @off_t int offset, int whence) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/lseek.html">lseek
     * - move the read/write file offset</a>.
     *
     * @param fildes a valid file descriptor.
     * @param offset depending on the size of @see SizeOf.off_t {@code int} or
     * {@code long} may be used.
     * @param whence one of
     * {@link SEEK_SET}, {@link SEEK_CUR}, {@link SEEK_END}.
     * @return the position depending on the size of @see SizeOf.off_t
     * {@code int} or {@code long} may be used.
     *
     * @throws IndexOutOfBoundsException if offset is greater or smaller as the
     * native off_t can hold.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native @off_t
    long lseek(int fildes, @off_t long offset, int whence) throws NativeErrorException;

    /**
     * <b>Linux:</b> Available if _LARGEFILE64_SOURCE is defined.
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/lseek.html">lseek
     * - move the read/write file offset</a>.
     *
     * @param fildes a valid file descriptor.
     * @param offset alway 64 bit.
     * @param whence one of
     * {@link SEEK_SET}, {@link SEEK_CUR}, {@link SEEK_END}.
     * @return the position depending on the size of @see SizeOf.off_t
     * {@code int} or {@code long} may be used.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if _LARGEFILE64_SOURCE is not
     * defined.
     */
    public final static native @off64_t
    long lseek64(int fildes, @off64_t long offset, int whence) throws NativeErrorException, NoSuchNativeMethodException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pipe.html">pipe
     * - create an interprocess channel</a>.
     *
     * @param read_fd the file descriptor for reading
     * @param write_fd the file descriptor for writing
     *
     * @throws NullPointerException if {@code read_fd} or {@code write_fd} is
     * {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void pipe(Int32_t read_fd, Int32_t write_fd) throws NativeErrorException {
        pipe(AbstractNativeMemory.toUintptr_t(read_fd), AbstractNativeMemory.toUintptr_t(write_fd));
    }

    public final static native void pipe(long ptrRead_fd, long ptrRwrite_fd) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pread,
     * read - read from a file</a>.
     *
     * @param fildes a valid file descriptor open for reading
     * @param buf the byte array into which all bytes are to be transferred.
     * @return The number of bytes read, possibly zero.
     *
     * @throws NullPointerException if {@code buf} is null.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @ssize_t
    public final static int read(int fildes, byte[] buf) throws NativeErrorException {
        return read0(fildes, buf, 0, buf.length);
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pread,
     * read - read from a file</a>.
     *
     * @param fildes a valid file descriptor open for reading
     * @param buf the byte array into which bytes are to be transferred.
     * @param off the start offset in {@code buf} to which the data is
     * transferred.
     * @param nbyte the maximum number of bytes to read.
     * @return The number of bytes read, possibly zero.
     *
     * @throws NullPointerException if {@code buf} is null.
     * @throws ArrayIndexOutOfBoundsException if {@code off} or {@code nByte}
     * out of bounds.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @ssize_t
    public final static int read(int fildes, byte[] buf, int off, @size_t int nbyte) throws NativeErrorException {
        Objects.checkFromIndexSize(off, nbyte, buf.length);
        return read0(fildes, buf, off, nbyte);
    }

    private static native int read0(int fildes, byte[] buf, int off, @size_t int nbyte) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pread,
     * read - read from a file</a>.
     *
     * Read the bytes between {@link ByteBuffer#position()} and
     * {@link ByteBuffer#limit()} from the file. After sucessful reading,
     * position is updated accordingly to the number of bytes read.
     *
     * @param fildes a valid file descriptor open for reading
     * @param buffer the {@link ByteBuffer} into which bytes are to be
     * transferred between position and limit.
     * @return The number of bytes read, possibly zero.
     *
     * @throws NullPointerException if {@code buffer} is null.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @ssize_t
    public final static int read(int fildes, ByteBuffer buffer) throws NativeErrorException {
        final int result;
        if (buffer.isDirect()) {
            result = read(fildes, buffer, buffer.position(), ByteBufferUtils.calcBufferReadBytes(buffer));
        } else {
            if (buffer.hasArray()) {
                result = read0(fildes, buffer.array(), buffer.arrayOffset() + buffer.position(), ByteBufferUtils.calcBufferReadBytes(buffer));
            } else {
                throw new IllegalArgumentException("Can't handle ByteBuffer of class: " + buffer.getClass());
            }
        }
        buffer.position(buffer.position() + result);
        return result;
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pread,
     * read - read from a file</a>.
     *
     * @param fildes a valid file descriptor open for reading
     * @param mem the {@link OpaqueMemory32} into which bytes are to be
     * transferred.
     * @param off the start offset in {@code mem} to which the data is
     * transferred.
     * @param nbyte the maximum number of bytes to read.
     * @return The number of bytes read, possibly zero.
     *
     * @throws NullPointerException if {@code mem} is null.
     *
     * @throws ArrayIndexOutOfBoundsException if {@code off} or {@code nByte}
     * out of bounds.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @ssize_t
    public final static int read(int fildes, OpaqueMemory32 mem, int off, @size_t int nbyte) throws NativeErrorException {
        OpaqueMemory32.checkIndex(mem, off, nbyte);
        return read(fildes, AbstractNativeMemory.toUintptr_t(mem), off, nbyte);
    }

    private static native int read(int fildes, long ptrMem, int off, int nbyte) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pread,
     * read - read from a file</a>.
     *
     * @param fildes a valid file descriptor open for reading
     * @param mem the {@link OpaqueMemory64} into which bytes are to be
     * transferred.
     * @param off the start offset in {@code mem} to which the data is
     * transferred.
     * @param nbyte the maximum number of bytes to read.
     * @return The number of bytes read, possibly zero.
     *
     * @throws NullPointerException if {@code mem} is null.
     *
     * @throws ArrayIndexOutOfBoundsException if {@code off} or {@code nByte}
     * out of bounds.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @ssize_t
    public final static long read(int fildes, OpaqueMemory64 mem, long off, @size_t long nbyte) throws NativeErrorException {
        OpaqueMemory64.checkIndex(mem, off, nbyte);
        return read(fildes, AbstractNativeMemory.toUintptr_t(mem), off, nbyte);
    }

    private static native long read(int fildes, long ptrMem, long off, long nbyte) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pread,
     * read - read from a file</a>.
     *
     * @param fildes a valid file descriptor open for reading
     * @param mem the {@link OpaqueMemory32} into which all bytes are to be
     * transferred.
     * @return The number of bytes read, possibly zero.
     *
     * @throws NullPointerException if {@code buf} is null.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @ssize_t
    public final static int read(int fildes, OpaqueMemory32 mem) throws NativeErrorException {
        return read(fildes, AbstractNativeMemory.toUintptr_t(mem), 0, mem.sizeInBytes);
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pread,
     * read - read from a file</a>.
     *
     * @param fildes a valid file descriptor open for reading
     * @param mem the {@link OpaqueMemory32} into which all bytes are to be
     * transferred.
     * @return The number of bytes read, possibly zero.
     *
     * @throws NullPointerException if {@code buf} is null.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @ssize_t
    public final static long read(int fildes, OpaqueMemory64 mem) throws NativeErrorException {
        return read(fildes, AbstractNativeMemory.toUintptr_t(mem), 0, mem.sizeInBytes);
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/read.html">pread,
     * read - read from a file</a>.
     *
     * @param fildes a valid file descriptor open for reading
     * @param data the {@link ByteRef} into which the single byte is to be
     * transferred.
     * @return On succes 1.
     *
     * @throws NullPointerException if {@code data} is null.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @ssize_t
    public final static int read(int fildes, Int8_t data) throws NativeErrorException {
        return read(fildes, AbstractNativeMemory.toUintptr_t(data), 0, 1);
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/read.html">pread,
     * read - read from a file</a>.
     *
     *
     * @param fildes a valid file descriptor open for reading
     * @return the unsigned byte in the low byte and the length in the upper
     * byte. if nothing was read the value of the lower byte is unspecific, the
     * length must be 0.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native short read(int fildes) throws NativeErrorException;

    private static native int read(int fildes, ByteBuffer buffer, int off, int nByte) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sysconf.html">pwrite,
     * sysconf - get configurable system variables</a>.
     *
     * @param name the name argument represents the system variable to be
     * queried.
     * @return the current variable value on the system.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @ssize_t
    public final static native long sysconf(int name) throws NativeErrorException;

    /**
     * <b>LINUX,APPLE,BSD:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/usleep.html">usleep
     * - suspend execution for an interval</a>.
     *
     * @param usleep the micro seconds to sleep.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void usleep(@useconds_t int usleep) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pwrite,
     * write - write on a file</a>.
     *
     * @param fildes a valid file descriptor open for writing
     * @param buf The byte array from which all bytes are to be retrieved for
     * writing.
     * @return The number of bytes written, possibly zero.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @ssize_t
    public final static int write(int fildes, byte[] buf) throws NativeErrorException {
        return write0(fildes, buf, 0, buf.length);
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pwrite,
     * write - write on a file</a>.
     *
     * @param fildes a valid file descriptor open for writing
     * @param mem The {link OpaqueMemory} from which the bytes are to be
     * retrieved for writing.
     * @param off the start offset in {@code mem}.
     * @param nbyte the number of bytes to write.
     * @return The number of bytes written, possibly zero.
     *
     * @throws NullPointerException if {@code mem} is null.
     * @throws ArrayIndexOutOfBoundsException if {@code off} or {@code nByte}
     * out of bounds.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @ssize_t
    public final static int write(int fildes, OpaqueMemory32 mem, int off, @size_t int nbyte) throws NativeErrorException {
        OpaqueMemory32.checkIndex(mem, off, nbyte);
        return write(fildes, AbstractNativeMemory.toUintptr_t(mem), off, nbyte);
    }

    private static native int write(int fildes, long ptrMem, int off, int nbyte) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pwrite,
     * write - write on a file</a>.
     *
     * @param fildes a valid file descriptor open for writing
     * @param mem The {link OpaqueMemory} from which the bytes are to be
     * retrieved for writing.
     * @param off the start offset in {@code mem}.
     * @param nbyte the number of bytes to write.
     * @return The number of bytes written, possibly zero.
     *
     * @throws NullPointerException if {@code mem} is null.
     * @throws ArrayIndexOutOfBoundsException if {@code off} or {@code nByte}
     * out of bounds.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @ssize_t
    public final static long write(int fildes, OpaqueMemory64 mem, long off, @size_t long nbyte) throws NativeErrorException, NoSuchNativeMethodException {
        OpaqueMemory64.checkIndex(mem, off, nbyte);
        return write(fildes, AbstractNativeMemory.toUintptr_t(mem), off, nbyte);
    }

    private static native long write(int fildes, long ptrMem, long off, long nbyte) throws NativeErrorException, NoSuchNativeMethodException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pwrite,
     * write - write on a file</a>.
     *
     * @param fildes a valid file descriptor open for writing
     * @param mem The {link OpaqueMemory} from which all bytes are to be
     * retrieved for writing.
     * @return The number of bytes written, possibly zero.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @ssize_t
    public final static int write(int fildes, OpaqueMemory32 mem) throws NativeErrorException {
        return write(fildes, AbstractNativeMemory.toUintptr_t(mem), 0, mem.sizeInBytes);
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pwrite,
     * write - write on a file</a>.
     *
     * @param fildes a valid file descriptor open for writing
     * @param mem The {link OpaqueMemory} from which all bytes are to be
     * retrieved for writing.
     * @return The number of bytes written, possibly zero.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @ssize_t
    public final static long write(int fildes, OpaqueMemory64 mem) throws NativeErrorException, NoSuchNativeMethodException {
        return write(fildes, AbstractNativeMemory.toUintptr_t(mem), 0, mem.sizeInBytes);
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pwrite,
     * write - write on a file</a>.
     *
     * @param fildes a valid file descriptor open for writing
     * @param data The single byte to write.
     * @return on succes 1.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @ssize_t
    public final static native int write(int fildes, byte data) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pwrite,
     * write - write on a file</a>.
     *
     * @param fildes a valid file descriptor open for writing
     * @param buf The byte array from which the bytes are to be retrieved for
     * writing.
     * @param off the start offset in {@code buf}.
     * @param nbyte the number of bytes to write.
     * @return The number of bytes written, possibly zero.
     *
     * @throws NullPointerException if {@code buf} is null.
     * @throws ArrayIndexOutOfBoundsException if {@code off} or {@code nByte}
     * out of bounds.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @ssize_t
    public final static int write(int fildes, byte[] buf, int off, @size_t int nbyte) throws NativeErrorException {
        Objects.checkFromIndexSize(off, nbyte, buf.length);
        return write0(fildes, buf, off, nbyte);
    }

    private static native int write0(int fildes, byte[] buf, int off, @size_t int nbyte) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pwrite,
     * write - write on a file</a>.
     *
     * Write the bytes between {@link ByteBuffer#position()} and
     * {@link ByteBuffer#limit()} to the file. After sucessful writing, position
     * is updated accordingly to the number of written bytes.
     *
     * @param fildes a valid file descriptor open for writing
     * @param buffer The {link ByteBuffer} from which the bytes between position
     * and limit are to be retrieved for writing.
     * @return The number of bytes written, possibly zero.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @ssize_t
    public final static int write(int fildes, ByteBuffer buffer) throws NativeErrorException {
        final int result;
        if (buffer.isDirect()) {
            result = write(fildes, buffer, buffer.position(), ByteBufferUtils.calcBufferWriteBytes(buffer));
        } else {
            if (buffer.hasArray()) {
                result = write(fildes, buffer.array(), buffer.arrayOffset() + buffer.position(), ByteBufferUtils.calcBufferWriteBytes(buffer));
            } else {
                throw new IllegalArgumentException("Can't handle ByteBuffer of class: " + buffer.getClass());
            }
        }
        buffer.position(buffer.position() + result);
        return result;
    }

    //We pass down ByteBuffer to get the native address and pass the other data onto the stack
    private static native int write(int fildes, ByteBuffer buffer, int off, int nByte) throws NativeErrorException;

    public static boolean jnhwIsSingeByteRead(short nread) {
        return (nread & 0xFF00) == 0x0100;
    }

    public static byte jnhwSingeByteReadToByte(short nread) {
        return (byte) (nread & 0xFF);
    }

    public static int jnhwSingeByteReadToInt(short nread) {
        return nread & 0x00FF;
    }

    private Unistd() {
    }

    public static abstract class JnhwPrimitiveArrayCritical {

        static {
            LibJnhwPosixLoader.touch();
        }

        /**
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pwrite,
         * write - write on a file</a>.
         *
         * @param fildes a valid file descriptor open for writing
         * @param buf The byte array from which all bytes are to be retrieved
         * for writing.
         * @return The number of bytes written, possibly zero.
         *
         * @throws NativeErrorException if the return value of the native
         * function indicates an error.
         */
        public final static @ssize_t
        int write(int fildes, byte[] buf) throws NativeErrorException {
            return write0(fildes, buf, 0, buf.length);
        }

        /**
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pread,
         * read - read from a file</a>.
         *
         * @param fildes a valid file descriptor open for reading
         * @param buf the byte array into which all bytes are to be transferred.
         * @return The number of bytes read, possibly zero.
         *
         * @throws NativeErrorException if the return value of the native
         * function indicates an error.
         */
        public final static @ssize_t
        int read(int fildes, byte[] buf) throws NativeErrorException {
            return read0(fildes, buf, 0, buf.length);
        }

        /**
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pread,
         * read - read from a file</a>.
         *
         * @param fildes a valid file descriptor open for reading
         * @param buf the byte array into which bytes are to be transferred.
         * @param off the start offset in {@code buf} to which the data is
         * transferred.
         * @param nbyte the maximum number of bytes to read.
         * @return The number of bytes read, possibly zero.
         *
         * @throws NullPointerException if {@code buf} is null.
         * @throws ArrayIndexOutOfBoundsException if {@code off} or
         * {@code nByte} out of bounds.
         *
         * @throws NativeErrorException if the return value of the native
         * function indicates an error.
         */
        @ssize_t
        public final static int read(int fildes, byte[] buf, int off, @size_t int nbyte) throws NativeErrorException {
            Objects.checkFromIndexSize(off, nbyte, buf.length);
            return read0(fildes, buf, off, nbyte);
        }

        private static native int read0(int fildes, byte[] buf, int off, @size_t int nbyte) throws NativeErrorException;

        /**
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pwrite,
         * write - write on a file</a>.
         *
         * @param fildes a valid file descriptor open for writing
         * @param buf The byte array from which the bytes are to be retrieved
         * for writing.
         * @param off the start offset in {@code buf}.
         * @param nbyte the number of bytes to write.
         * @return The number of bytes written, possibly zero.
         *
         * @throws NullPointerException if {@code buf} is null.
         * @throws ArrayIndexOutOfBoundsException if {@code off} or
         * {@code nByte} out of bounds.
         *
         * @throws NativeErrorException if the return value of the native
         * function indicates an error.
         */
        @ssize_t
        public final static int write(int fildes, byte[] buf, int off, @size_t int nbyte) throws NativeErrorException {
            Objects.checkFromIndexSize(off, nbyte, buf.length);
            return write0(fildes, buf, off, nbyte);
        }

        private static native int write0(int fildes, byte[] buf, int off, @size_t int nbyte) throws NativeErrorException;
    }
}
