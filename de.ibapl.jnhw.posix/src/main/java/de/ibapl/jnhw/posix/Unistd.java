/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.annotation.posix.sys.types.gid_t;
import de.ibapl.jnhw.annotation.posix.sys.types.off64_t;
import de.ibapl.jnhw.annotation.posix.sys.types.off_t;
import de.ibapl.jnhw.annotation.posix.sys.types.pid_t;
import de.ibapl.jnhw.annotation.posix.sys.types.size_t;
import de.ibapl.jnhw.annotation.posix.sys.types.ssize_t;
import de.ibapl.jnhw.annotation.posix.sys.types.uid_t;
import de.ibapl.jnhw.annotation.posix.sys.types.useconds_t;
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.datatypes.MultiarchTupelBuilder;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI___A;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI___V;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI__sI;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI__uI;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI__uI_uI;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sL__sI;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sL__sI_sL_sI;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sL_sI__A_uL;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_uI___V;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.MemoryArray;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.util.ByteBufferUtils;
import de.ibapl.jnhw.common.util.IntDefine;
import de.ibapl.jnhw.util.posix.PosixDataType;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
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

    public static interface BsdDefines {

        public final static int _SC_AIO_LISTIO_MAX = 42;
        public final static int _SC_AIO_MAX = 43;
        public final static int _SC_AIO_PRIO_DELTA_MAX = 44;
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

    public static interface LinuxDefines {

        public final static long _POSIX_VERSION = 200809L;
        public final static int _SC_AIO_LISTIO_MAX = 23;
        public final static int _SC_AIO_MAX = 24;
        public final static int _SC_AIO_PRIO_DELTA_MAX = 25;
        public final static int SEEK_DATA = 3;
        public final static int SEEK_HOLE = 4;
        public final static int STDERR_FILENO = 2;
        public final static int STDIN_FILENO = 0;
        public final static int STDOUT_FILENO = 1;
        //TODO test real value
        public final static IntDefine _SC_MINSIGSTKSZ = IntDefine.toIntDefine(249);
        //TODO test real value
        public final static IntDefine _SC_SIGSTKSZ = IntDefine.toIntDefine(250);
    }

    public static interface OpenBsdDefines extends BsdDefines {

        public final static long _POSIX_VERSION = 200809;
    }

    /**
     * <b>POSIX:</b> Integer value indicating version of this standard
     * (C-language binding) to which the implementation conforms.
     *
     */
    @Define
    public final static long _POSIX_VERSION;

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
     * <b>GlibC(&gt; 2.34):</b> variable: {MINSIGSTKSZ}.
     *
     */
    @Define
    public final static IntDefine _SC_MINSIGSTKSZ;

    /**
     * <b>GlibC(&gt; 2.34):</b> variable: {SIGSTKSZ}.
     *
     */
    @Define
    public final static IntDefine _SC_SIGSTKSZ;

    public final static boolean HAVE_UNISTD_H;

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
            case LINUX:
                HAVE_UNISTD_H = true;
                _POSIX_VERSION = LinuxDefines._POSIX_VERSION;
                _SC_AIO_LISTIO_MAX = LinuxDefines._SC_AIO_LISTIO_MAX;
                _SC_AIO_MAX = LinuxDefines._SC_AIO_MAX;
                _SC_AIO_PRIO_DELTA_MAX = LinuxDefines._SC_AIO_PRIO_DELTA_MAX;
                _SC_MINSIGSTKSZ = LinuxDefines._SC_MINSIGSTKSZ;
                _SC_SIGSTKSZ = LinuxDefines._SC_SIGSTKSZ;
                SEEK_DATA = IntDefine.toIntDefine(LinuxDefines.SEEK_DATA);
                SEEK_HOLE = IntDefine.toIntDefine(LinuxDefines.SEEK_HOLE);
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
                _SC_MINSIGSTKSZ = IntDefine.UNDEFINED;
                _SC_SIGSTKSZ = IntDefine.UNDEFINED;
                STDERR_FILENO = BsdDefines.STDERR_FILENO;
                STDIN_FILENO = BsdDefines.STDIN_FILENO;
                STDOUT_FILENO = BsdDefines.STDOUT_FILENO;
                switch (MultiarchTupelBuilder.getOS()) {
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
                        throw new NoClassDefFoundError("No unistd.h BSD defines for " + MultiarchTupelBuilder.getMultiarch());
                }
                break;
            default:
                throw new NoClassDefFoundError("No unistd.h defines for " + MultiarchTupelBuilder.getMultiarch());
        }
    }

    public static class JnhwPipeFiledes extends MemoryArray<Int32_t> {

        public final static int ARRAY_LENGTH = 2;

        private static Int32_t createAtOffset(MemorySegment memorySegment, long elementoffset, int index) {
            return new Int32_t(memorySegment, elementoffset);
        }

        public final static JnhwPipeFiledes allocateNative(MemorySession ms) {
            return new JnhwPipeFiledes(MemorySegment.allocateNative(Int32_t.DATA_TYPE.SIZE_OF * ARRAY_LENGTH, ms), 0);
        }

        public JnhwPipeFiledes(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, new Int32_t[ARRAY_LENGTH], JnhwPipeFiledes::createAtOffset, Int32_t.DATA_TYPE.SIZE_OF);
        }

        public int readFd() {
            return get(0).int32_t();
        }

        public int writeFd() {
            return get(1).int32_t();
        }
    }

    private final static JnhwMh_sI__sI close = JnhwMh_sI__sI.of(
            "close",
            BaseDataType.C_int,
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI fsync = JnhwMh_sI__sI.of(
            "fsync",
            BaseDataType.C_int,
            BaseDataType.C_int);

    private final static JnhwMh_uI___V getegid = JnhwMh_uI___V.of(
            "getegid",
            PosixDataType.gid_t);

    private final static JnhwMh_uI___V geteuid = JnhwMh_uI___V.of(
            "geteuid",
            PosixDataType.uid_t);

    private final static JnhwMh_sI___V getpgrp = JnhwMh_sI___V.of(
            "getpgrp",
            PosixDataType.pid_t);

    private final static JnhwMh_sI___V getppid = JnhwMh_sI___V.of(
            "getppid",
            PosixDataType.pid_t);

    private final static JnhwMh_uI___V getgid = JnhwMh_uI___V.of(
            "getgid",
            PosixDataType.gid_t);

    private final static JnhwMh_uI___V getuid = JnhwMh_uI___V.of(
            "getuid",
            PosixDataType.uid_t);

    private final static JnhwMh_sI___V getpid = JnhwMh_sI___V.of(
            "getpid",
            PosixDataType.pid_t);

    private final static JnhwMh_sL__sI_sL_sI lseek = JnhwMh_sL__sI_sL_sI.of(
            "lseek",
            PosixDataType.off_t,
            BaseDataType.C_int,
            PosixDataType.off_t,
            BaseDataType.C_int);

    private final static JnhwMh_sL__sI_sL_sI lseek64 = JnhwMh_sL__sI_sL_sI.ofOrNull(
            "lseek64",
            PosixDataType.off_t,
            BaseDataType.C_int,
            PosixDataType.off_t,
            BaseDataType.C_int);

    private final static JnhwMh_sI___A pipe = JnhwMh_sI___A.of(
            "pipe",
            BaseDataType.C_int,
            BaseDataType.C_pointer);

    private final static JnhwMh_sL_sI__A_uL read = JnhwMh_sL_sI__A_uL.of(
            "read",
            PosixDataType.ssize_t,
            BaseDataType.C_int,
            BaseDataType.C_pointer,
            PosixDataType.size_t);

    private final static JnhwMh_sL__sI sysconf = JnhwMh_sL__sI.of(
            "sysconf",
            BaseDataType.C_long,
            BaseDataType.C_int);

    private final static JnhwMh_sI__uI setegid = JnhwMh_sI__uI.of(
            "setegid",
            BaseDataType.C_int,
            PosixDataType.gid_t);

    private final static JnhwMh_sI__uI seteuid = JnhwMh_sI__uI.of(
            "seteuid",
            BaseDataType.C_int,
            PosixDataType.uid_t);

    private final static JnhwMh_sI__uI_uI setregid = JnhwMh_sI__uI_uI.of(
            "setregid",
            BaseDataType.C_int,
            PosixDataType.gid_t,
            PosixDataType.gid_t);

    private final static JnhwMh_sI__uI_uI setreuid = JnhwMh_sI__uI_uI.of(
            "setreuid",
            BaseDataType.C_int,
            PosixDataType.uid_t,
            PosixDataType.uid_t);

    private final static JnhwMh_sI__uI setgid = JnhwMh_sI__uI.of(
            "setgid",
            BaseDataType.C_int,
            PosixDataType.gid_t);

    private final static JnhwMh_sI__uI setuid = JnhwMh_sI__uI.of(
            "setuid",
            BaseDataType.C_int,
            PosixDataType.uid_t);

    private final static JnhwMh_sL_sI__A_uL write = JnhwMh_sL_sI__A_uL.of(
            "write",
            PosixDataType.ssize_t,
            BaseDataType.C_int,
            BaseDataType.C_pointer,
            PosixDataType.size_t);

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/close.html">close
     * - close a file descriptor</a>.
     *
     * @param fildes an open file descriptor.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void close(int fildes) throws NativeErrorException {
        if (close.invoke_sI__sI(fildes) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

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
    public final static void fsync(int fildes) throws NativeErrorException {
        if (fsync.invoke_sI__sI(fildes) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/getegid.html">getegid
     * - get the effective group ID</a>.
     */
    @gid_t
    public final static int getegid() {
        return getegid.invoke_uI___V();
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/geteuid.html">geteuid
     * - get the effective user ID</a>.
     */
    @uid_t
    public final static int geteuid() {
        return geteuid.invoke_uI___V();
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/getgid.html">getgid
     * - get the real group ID</a>.
     *
     * @return the real group ID
     */
    @gid_t
    public final static int getgid() {
        return getgid.invoke_uI___V();
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/getpgrp.html">getpgrp
     * - get the process group ID of the calling process</a>.
     */
    @pid_t
    public final static int getpgrp() {
        return getpgrp.invoke_sI___V();
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/getpid.html">getpid
     * - get the process ID</a>.
     */
    @pid_t
    public final static int getpid() {
        return getpid.invoke_sI___V();
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/getppid.html">getppid
     * - get the parent process ID</a>.
     */
    @pid_t
    public final static int getppid() {
        return getppid.invoke_sI___V();
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/getuid.html">getuid
     * - get a real user ID</a>.
     */
    @uid_t
    public final static int getuid() {
        return getuid.invoke_uI___V();
    }

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
    @off_t
    public final static long lseek(int fildes, @off_t long offset, int whence) throws NativeErrorException {
        final long result = lseek.invoke_sL__sI_sL_sI(fildes, offset, whence);
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        } else {
            return result;
        }
    }

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
    @off64_t
    public final static long lseek64(int fildes, @off64_t long offset, int whence) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            final long result = lseek64.invoke_sL__sI_sL_sI(fildes, offset, whence);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            } else {
                return result;
            }
        } catch (NullPointerException npe) {
            if (lseek64 == null) {
                throw new NoSuchNativeMethodException("lseek64");
            } else {
                throw npe;
            }
        }
    }

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
    public final static void pipe(MemoryArray<Int32_t> fildes) throws NativeErrorException {
        if (fildes.length() != 2) {
            throw new IllegalArgumentException("Length must be 2 not " + fildes.length());
        }
        final int result = pipe.invoke_sI___P(fildes);
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/read.html">pread,
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
        try ( MemorySession ms = MemorySession.openConfined()) {
            final MemorySegment mem = MemorySegment.allocateNative(buf.length, ms);
            final long result = read.invoke_sL__sI_A_uL(fildes, mem, buf.length);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            }
            MemorySegment.ofArray(buf).copyFrom(mem);
            // buf.length is int, so it is save here to do so.
            return (int) result;
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/read.html">pread,
     * read - read from a file</a>.
     *
     * @param fildes a valid file descriptor open for reading
     * @param buf the byte array into which bytes are to be transferred.
     * @param destOff the start offset in {@code buf} to which the data is
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
    public final static int read(int fildes, byte[] buf, int destOff, @size_t int nbyte) throws NativeErrorException {
        Objects.checkFromIndexSize(destOff, nbyte, buf.length);
        try ( MemorySession ms = MemorySession.openConfined()) {
            final MemorySegment mem = MemorySegment.allocateNative(nbyte, ms);
            final long result = read.invoke_sL__sI_A_uL(fildes, mem, nbyte);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            }
            MemorySegment.ofArray(buf).asSlice(destOff, nbyte).copyFrom(mem);
            // buf.length is int, so it is save here to do so.
            return (int) result;
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/read.html">pread,
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
        final long result;
        if (buffer.isDirect()) {
            result = read.invoke_sL__sI_A_uL(fildes, MemorySegment.ofBuffer(buffer), buffer.remaining());
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            }
        } else if (buffer.hasArray()) {
            result = read(fildes, buffer.array(), buffer.arrayOffset() + buffer.position(), ByteBufferUtils.calcBufferReadBytes(buffer));
        } else {
            throw new IllegalArgumentException("Can't handle ByteBuffer of class: " + buffer.getClass());
        }
        // buf.length is int, so it is save here to do so.
        buffer.position(buffer.position() + (int) result);
        return (int) result;
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/read.html">pread,
     * read - read from a file</a>.
     *
     * @param fildes a valid file descriptor open for reading
     * @param mem the {@link OpaqueMemory} into which all bytes are to be
     * transferred.
     * @return The number of bytes read, possibly zero.
     *
     * @throws NullPointerException if {@code buf} is null.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @ssize_t
    public final static long read(int fildes, OpaqueMemory mem) throws NativeErrorException {
        final long result = read.invoke_sL__sI_P_uL(fildes, mem, mem.sizeof());
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        }
        return result;
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/read.html">pread,
     * read - read from a file</a>.
     *
     * @param fildes a valid file descriptor open for reading
     * @param mem the {@link MemorySegment} into which all bytes are to be
     * transferred.
     * @return The number of bytes read, possibly zero.
     *
     * @throws NullPointerException if {@code buf} is null.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @ssize_t
    public final static long read(int fildes, MemorySegment mem) throws NativeErrorException {
        final long result = read.invoke_sL__sI_A_uL(fildes, mem, mem.byteSize());
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        }
        return result;
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/read.html">pread,
     * read - read from a file</a>.
     *
     * @param fildes a valid file descriptor open for reading
     * @param mem the {@link OpaqueMemory} into which bytes are to be
     * transferred.
     * @param destOff the start offset in {@code mem} to which the data is
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
    public final static long read(int fildes, OpaqueMemory mem, long destOff, @size_t long nbyte) throws NativeErrorException {
        final long result = read.invoke_sL__sI_A_uL(fildes, OpaqueMemory.sliceMemorySegment(mem, destOff, nbyte), nbyte);
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        }
        return result;
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/read.html">pread,
     * read - read from a file</a>.
     *
     * @param fildes a valid file descriptor open for reading
     * @param mem the {@link MemorySegment} into which bytes are to be
     * transferred.
     * @param destOff the start offset in {@code mem} to which the data is
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
    public final static long read(int fildes, MemorySegment mem, long destOff, @size_t long nbyte) throws NativeErrorException {
        final long result = read.invoke_sL__sI_A_uL(fildes, mem.asSlice(destOff, nbyte), nbyte);
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        }
        return result;
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/setegid.html">setegid
     * - set effective user ID</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void setegid(@gid_t int gid) throws NativeErrorException {
        if (setegid.invoke_sI__uI(gid) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/seteuid.html">seteuid
     * - set effective user ID</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void seteuid(@uid_t int uid) throws NativeErrorException {
        if (seteuid.invoke_sI__uI(uid) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/setgid.html">setgid
     * - set group ID</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void setgid(@gid_t int gid) throws NativeErrorException {
        if (setgid.invoke_sI__uI(gid) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/setregid.html">setregid
     * - set real and effective group IDs</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void setregid(@gid_t int rgid, @gid_t int egid) throws NativeErrorException {
        if (setregid.invoke_sI__uI_uI(rgid, egid) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/setreuid.html">setreuid
     * - set real and effective user IDs</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void setreuid(@uid_t int ruid, @uid_t int euid) throws NativeErrorException {
        if (setreuid.invoke_sI__uI_uI(ruid, euid) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/setuid.html">setuid
     * - set user ID</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void setuid(@uid_t int uid) throws NativeErrorException {
        if (setuid.invoke_sI__uI(uid) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

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
    public final static long sysconf(int name) throws NativeErrorException {
        Errno.errno(0);
        final long result = sysconf.invoke_sL__sI(name);
        if ((result == -1) && (Errno.errno() != 0)) {
            throw new NativeErrorException(Errno.errno());
        } else {
            return result;
        }
    }

    /**
     * <b>LINUX,APPLE,BSD:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/usleep.html">usleep
     * - suspend execution for an interval</a>.
     *
     * POSIX.1-2001 declares this function obsolete; use nanosleep instead.
     * POSIX.1-2008 removes the specification of usleep().
     *
     * @param usleep the micro seconds to sleep.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     *
     */
    //TODO move to Linux?
    @Deprecated
    public final static void usleep(@useconds_t int usleep) throws NativeErrorException {
        throw new AssertionError("Not Implemented anymore!");
    }

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
        try ( MemorySession ms = MemorySession.openConfined()) {
            final MemorySegment mem = MemorySegment.allocateNative(buf.length, ms);
            mem.copyFrom(MemorySegment.ofArray(buf));
            final long result = write.invoke_sL__sI_A_uL(fildes, mem, buf.length);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            }
            // buf.length is int, so it is save here to do so.
            return (int) result;
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pwrite,
     * write - write on a file</a>.
     *
     * @param fildes a valid file descriptor open for writing
     * @param buf The byte array from which the bytes are to be retrieved for
     * writing.
     * @param srcOff the start offset in {@code buf}.
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
    public final static int write(int fildes, byte[] buf, int srcOff, @size_t int nbyte) throws NativeErrorException {
        Objects.checkFromIndexSize(srcOff, nbyte, buf.length);
        try ( MemorySession ms = MemorySession.openConfined()) {
            final MemorySegment mem = MemorySegment.allocateNative(nbyte, ms);
            mem.copyFrom(MemorySegment.ofArray(buf).asSlice(srcOff, nbyte));
            final long result = write.invoke_sL__sI_A_uL(fildes, mem, nbyte);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            }
            // buf.length is int, so it is save here to do so.
            return (int) result;
        }
    }

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
        final long result;
        if (buffer.isDirect()) {
            result = write.invoke_sL__sI_A_uL(fildes, MemorySegment.ofBuffer(buffer), buffer.remaining());
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            }
        } else if (buffer.hasArray()) {
            result = write(fildes, buffer.array(), buffer.arrayOffset() + buffer.position(), ByteBufferUtils.calcBufferWriteBytes(buffer));
        } else {
            throw new IllegalArgumentException("Can't handle ByteBuffer of class: " + buffer.getClass());
        }
        // buf.length is int, so it is save here to do so.
        buffer.position(buffer.position() + (int) result);
        return (int) result;
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
    public final static long write(int fildes, OpaqueMemory mem) throws NativeErrorException {
        final long result = write.invoke_sL__sI_P_uL(fildes, mem, mem.sizeof());
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        }
        return result;
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pwrite,
     * write - write on a file</a>.
     *
     * @param fildes a valid file descriptor open for writing
     * @param mem The {link MemorySegment} from which all bytes are to be
     * retrieved for writing.
     * @return The number of bytes written, possibly zero.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @ssize_t
    public final static long write(int fildes, MemorySegment mem) throws NativeErrorException {
        final long result = write.invoke_sL__sI_A_uL(fildes, mem, mem.byteSize());
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        }
        return result;
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pwrite,
     * write - write on a file</a>.
     *
     * @param fildes a valid file descriptor open for writing
     * @param mem The {link OpaqueMemory} from which the bytes are to be
     * retrieved for writing.
     * @param srcOff the start offset in {@code mem}.
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
    public final static long write(int fildes, OpaqueMemory mem,
            long srcOff, @size_t long nbyte) throws NativeErrorException {
        final long result = write.invoke_sL__sI_A_uL(fildes, OpaqueMemory.sliceMemorySegment(mem, srcOff, nbyte), nbyte);
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        }
        return result;
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pwrite,
     * write - write on a file</a>.
     *
     * @param fildes a valid file descriptor open for writing
     * @param mem The {link MemorySegment} from which the bytes are to be
     * retrieved for writing.
     * @param srcOff the start offset in {@code mem}.
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
    public final static long write(int fildes, MemorySegment mem,
            long srcOff, @size_t long nbyte) throws NativeErrorException {
        final long result = write.invoke_sL__sI_A_uL(fildes, mem.asSlice(srcOff, nbyte), nbyte);
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        }
        return result;
    }

    private Unistd() {
    }
}
