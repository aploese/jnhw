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

import de.ibapl.jnhw.ByteRef;
import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.NotDefinedException;
import de.ibapl.jnhw.OpaqueMemory;
import de.ibapl.jnhw.util.ByteBufferUtils;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import java.nio.ByteBuffer;

@Include("#include <unistd.h>")
public final class Unistd {

	/**
	 * File number of stdin; 0.
	 * @return
	 */
    @Define
    public final static native int STDIN_FILENO();
	/**
	 * File number of stdout; 1.
	 * @return
	 */
    @Define
    public final static native int STDOUT_FILENO();
	/**
	 * File number of stderr; 2.
	 * @return
	 */
    @Define
    public final static native int STDERR_FILENO();

    public static native int SEEK_SET();

    public static native int SEEK_CUR();

    public static native int SEEK_END();

    public static native int SEEK_DATA() throws NotDefinedException;

    public static native int SEEK_HOLE() throws NotDefinedException;

    public static abstract class JnhwPrimitiveArrayCritical {

        public final static int write(int fildes, byte[] buf) throws NativeErrorException {
            return write(fildes, buf, 0, buf.length);
        }

        public final static int read(int fildes, byte[] buf) throws NativeErrorException {
            return read(fildes, buf, 0, buf.length);
        }

        public final static native int read(int fildes, byte[] buf, int pos, int len) throws NativeErrorException;

        public final static native int write(int fildes, byte[] buf, int pos, int len) throws NativeErrorException;

    }

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    public final static native boolean HAVE_UNISTD_H();

    public final static int write(int fildes, byte[] buf) throws NativeErrorException {
        return write(fildes, buf, 0, buf.length);
    }

    public final static int read(int fildes, byte[] buf) throws NativeErrorException {
        return read(fildes, buf, 0, buf.length);
    }

    public final static native int close(int fildes) throws NativeErrorException;

    /**
     *
     * @param fildes
     * @param buf
     * @param pos
     * @param len
     * @return
     * @throws NativeErrorException
     * @exception NullPointerException if <code>buf<code> is null.
     * @exception ArrayIndexOutOfBoundsException if <code>pos</code> or
     * <code>len</code> out of bounds.
     */
    public final static native int read(int fildes, byte[] buf, int pos, int len) throws NativeErrorException;

    private static native int read(int fildes, ByteBuffer buffer, int pos, int len) throws NativeErrorException;

    public final static int read(int fildes, ByteBuffer buffer) throws NativeErrorException {
        final int result;
        if (buffer.isDirect()) {
            result = read(fildes, buffer, buffer.position(), ByteBufferUtils.calcBufferReadBytes(buffer));
        } else {
            result = read(fildes, buffer.array(), buffer.position(), ByteBufferUtils.calcBufferReadBytes(buffer));
        }
        buffer.position(buffer.position() + result);
        return result;
    }

    public final static native int write(int fildes, OpaqueMemory mem, int pos, int len) throws NativeErrorException;

    public final static int write(int fildes, OpaqueMemory mem) throws NativeErrorException {
        return write(fildes, mem, 0, mem.sizeInBytes);
    }

    public final static native int write(int fildes, byte data) throws NativeErrorException;

    public final static native int read(int fildes, OpaqueMemory mem, int pos, int len) throws NativeErrorException;

    public final static int read(int fildes, OpaqueMemory mem) throws NativeErrorException {
        return read(fildes, mem, 0, mem.sizeInBytes);
    }

    public final static native int read(int fildes, ByteRef data) throws NativeErrorException;

    /**
     *
     * @param fildes
     * @param buf
     * @param pos
     * @param len
     * @return
     * @throws NativeErrorException
     * @exception NullPointerException if <code>buf<code> is null.
     * @exception ArrayIndexOutOfBoundsException if <code>pos</code> or
     * <code>len</code> out of bounds.
     */
    public final static native int write(int fildes, byte[] buf, int pos, int len) throws NativeErrorException;

    //We pass down ByteBuffer to get the native address and pass the other data onto the stack
    private static native int write(int fildes, ByteBuffer buffer, int pos, int len) throws NativeErrorException;

    public final static int write(int fildes, ByteBuffer buffer) throws NativeErrorException {
        final int result;
        if (buffer.isDirect()) {
            result = write(fildes, buffer, buffer.position(), ByteBufferUtils.calcBufferWriteBytes(buffer));
        } else {
            if (buffer.isReadOnly()) {
                // see buffer.array() why we do this is here.
                final int bytesToWrite = ByteBufferUtils.calcBufferWriteBytes(buffer);
                ByteBuffer _buf = ByteBuffer.allocateDirect(bytesToWrite);
                _buf.put(buffer);
                _buf.flip();
                //We haven't written anything yet, so fix the position for now.
                buffer.position(buffer.position() - bytesToWrite);
                result = write(fildes, _buf, _buf.position(), _buf.remaining());
            } else {
                result = write(fildes, buffer.array(), buffer.position(), ByteBufferUtils.calcBufferWriteBytes(buffer));
            }
        }
        buffer.position(buffer.position() + result);
        return result;
    }

    public final static native int usleep(int usleep) throws NativeErrorException;

    public final static native int lseek(int fildes, int offset, int whence) throws NativeErrorException;

    public final static native long lseek64(int fildes, long offset, int whence) throws NativeErrorException;

    /**
     *
     * @param read_fd
     * @param write_fd
     *
     * @exception NullPointerException if <code>read_fd</code> or
     * <code>write_fd</code> is <code>null</code>.
     * @throws de.ibapl.jnhw.NativeErrorException if an error occured .
     */
    public final static native void pipe(IntRef read_fd, IntRef write_fd) throws NativeErrorException;

    private Unistd() {

    }

}
