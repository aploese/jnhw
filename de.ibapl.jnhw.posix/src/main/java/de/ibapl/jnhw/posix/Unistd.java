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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.ByteRef;
import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.NoSuchNativeMethodException;
import de.ibapl.jnhw.NotDefinedException;
import de.ibapl.jnhw.OpaqueMemory;
import de.ibapl.jnhw.posix.sys.Types.gid_t;
import de.ibapl.jnhw.posix.sys.Types.off64_t;
import de.ibapl.jnhw.posix.sys.Types.off_t;
import de.ibapl.jnhw.posix.sys.Types.pid_t;
import de.ibapl.jnhw.posix.sys.Types.size_t;
import de.ibapl.jnhw.posix.sys.Types.ssize_t;
import de.ibapl.jnhw.posix.sys.Types.uid_t;
import de.ibapl.jnhw.posix.sys.Types.useconds_t;
import de.ibapl.jnhw.util.ByteBufferUtils;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import java.nio.ByteBuffer;

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

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    public final static native boolean HAVE_UNISTD_H();

    /**
     * <b>POSIX:</b>seek relative to current position. This must be the same
     * value as {@link de.ibapl.jnhw.posix.Stdio.SEEK_CUR()}.
     *
     * @return the native symbolic constant of SEEK_CUR.
     */
    @Define
    public static native int SEEK_CUR();

    /**
     * <b>Linux,Apple:</b> Adjust the file offset to the next location in the
     * file greater than or equal to offset containing data.
     *
     * @return the native symbolic constant of SEEK_DATA.
     * @throws NotDefinedException if SEEK_DATA is not defined natively.
     */
    @Define
    public static native int SEEK_DATA() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Seek relative to end-of-file. This must be the same value
     * as {@link de.ibapl.jnhw.posix.Stdio.SEEK_END}.
     *
     * @return the native symbolic constant of SEEK_END.
     */
    @Define
    public static native int SEEK_END();

    /**
     * <b>POSIX:</b> Adjust the file offset to the next hole in the file greater
     * than or equal to offset.
     *
     * @return the native symbolic constant of SEEK_HOLE.
     * @throws NotDefinedException if SEEK_HOLE is not defined natively.
     */
    @Define
    public static native int SEEK_HOLE() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Seek relative to start-of-file. This must be the same value
     * as {@link de.ibapl.jnhw.posix.Stdio.SEEK_SET}.
     *
     * @return the native symbolic constant of SEEK_SET.
     */
    @Define
    public static native int SEEK_SET();

    /**
     * <b>POSIX:</b> File number of stderr; 2.
     *
     * @return the native symbolic constant of STDERR_FILENO.
     */
    @Define
    public final static native int STDERR_FILENO();

    /**
     * <b>POSIX:</b> File number of stdin; 0.
     *
     * @return the native symbolic constant of STDIN_FILENO.
     */
    @Define
    public final static native int STDIN_FILENO();

    /**
     * <b>POSIX:</b> File number of stdout; 1.
     *
     * @return the native symbolic constant of STDOUT_FILENO.
     */
    @Define
    public final static native int STDOUT_FILENO();

    /**
     * <b>POSIX:</b> Integer value indicating version of this standard
     * (C-language binding) to which the implementation conforms.
     *
     * @return the native symbolic constant of _POSIX_VERSION.
     */
    public static native int _POSIX_VERSION();

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
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/getegid.html">getegid
     * - get the effective group ID</a>.
     */
    public final native static @gid_t
    int getegid();

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/geteuid.html">geteuid
     * - get the effective user ID</a>.
     */
    public final native static @uid_t
    int geteuid();
    //TODO java doc + gid APUE page 256ff

    public final native static void seteuid(@uid_t int uid);

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

    public final native static void setreuid(@uid_t int uid);

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/getuid.html">getuid
     * - get a real user ID</a>.
     */
    public final native static @uid_t
    int getuid();

    public final native static void setuid(@uid_t int uid);

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
    public final static native void pipe(IntRef read_fd, IntRef write_fd) throws NativeErrorException;

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
    public final static @ssize_t
    int read(int fildes, byte[] buf) throws NativeErrorException {
        return read(fildes, buf, 0, buf.length);
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
    public final static native @ssize_t
    int read(int fildes, byte[] buf, int off, @size_t int nbyte) throws NativeErrorException;

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
    public final static @ssize_t
    int read(int fildes, ByteBuffer buffer) throws NativeErrorException {
        final int result;
        if (buffer.isDirect()) {
            result = read_ArgsOK(fildes, buffer, buffer.position(), ByteBufferUtils.calcBufferReadBytes(buffer));
        } else {
            result = read(fildes, buffer.array(), buffer.position(), ByteBufferUtils.calcBufferReadBytes(buffer));
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
     * @param mem the {@link OpaqueMemory} into which bytes are to be
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
    public final static native @ssize_t
    int read(int fildes, OpaqueMemory mem, int off, @size_t int nbyte) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/write.html">pread,
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
    public final static @ssize_t
    int read(int fildes, OpaqueMemory mem) throws NativeErrorException {
        return read(fildes, mem, 0, mem.sizeInBytes);
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
    public final static native @ssize_t
    int read(int fildes, ByteRef data) throws NativeErrorException;

    private static native int read_ArgsOK(int fildes, ByteBuffer buffer, int off, int nByte) throws NativeErrorException;

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
    public final static @ssize_t
    int write(int fildes, byte[] buf) throws NativeErrorException {
        return write(fildes, buf, 0, buf.length);
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
    public final static native @ssize_t
    int write(int fildes, OpaqueMemory mem, int off, @size_t int nbyte) throws NativeErrorException;

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
    public final static @ssize_t
    int write(int fildes, OpaqueMemory mem) throws NativeErrorException {
        return write(fildes, mem, 0, mem.sizeInBytes);
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
    public final static native @ssize_t
    int write(int fildes, byte data) throws NativeErrorException;

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
    public final static native @ssize_t
    int write(int fildes, byte[] buf, int off, @size_t int nbyte) throws NativeErrorException;

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
    public final static @ssize_t
    int write(int fildes, ByteBuffer buffer) throws NativeErrorException {
        final int result;
        if (buffer.isDirect()) {
            result = write_ArgsOK(fildes, buffer, buffer.position(), ByteBufferUtils.calcBufferWriteBytes(buffer));
        } else {
            if (buffer.isReadOnly()) {
                // see buffer.array() why we do this is here.
                final int bytesToWrite = ByteBufferUtils.calcBufferWriteBytes(buffer);
                ByteBuffer _buf = ByteBuffer.allocateDirect(bytesToWrite);
                _buf.put(buffer);
                _buf.flip();
                //We haven't written anything yet, so fix the position for now.
                buffer.position(buffer.position() - bytesToWrite);
                result = write_ArgsOK(fildes, _buf, _buf.position(), _buf.remaining());
            } else {
                result = write(fildes, buffer.array(), buffer.position(), ByteBufferUtils.calcBufferWriteBytes(buffer));
            }
        }
        buffer.position(buffer.position() + result);
        return result;
    }

    //We pass down ByteBuffer to get the native address and pass the other data onto the stack
    private static native int write_ArgsOK(int fildes, ByteBuffer buffer, int off, int nByte) throws NativeErrorException;

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
            return write(fildes, buf, 0, buf.length);
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
            return read(fildes, buf, 0, buf.length);
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
        public final static native @ssize_t
        int read(int fildes, byte[] buf, int off, @size_t int nbyte) throws NativeErrorException;

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
        public final static native @ssize_t
        int write(int fildes, byte[] buf, int off, @size_t int nbyte) throws NativeErrorException;

    }
}
