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
package de.ibapl.jnhw.isoc;

import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.util.ByteBufferUtils;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import java.nio.ByteBuffer;

@Include("#include <unistd.h>")
public abstract class Unistd extends LibJnhwPosixLoader {

    public final static native boolean HAVE_UNISTD_H();

    public final static int write(int fd, byte[] buf) throws NativeErrorException {
        return write(fd, buf, 0, buf.length);
    }

    public final static int read(int fd, byte[] buf) throws NativeErrorException {
        return read(fd, buf, 0, buf.length);
    }

    public final static native int close(int fd) throws NativeErrorException;

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
                byte[] _buf = new byte[ByteBufferUtils.calcBufferWriteBytes(buffer)];
                buffer.get(_buf);
                //We haven't written anything yet, so fix the position for now.
                buffer.position(buffer.position() - _buf.length);
                result = write(fildes, _buf, buffer.position(), ByteBufferUtils.calcBufferWriteBytes(buffer));
            } else {
                result = write(fildes, buffer.array(), buffer.position(), ByteBufferUtils.calcBufferWriteBytes(buffer));
            }
        }
        buffer.position(buffer.position() + result);
        return result;
    }

    public final static native int usleep(int usleep) throws NativeErrorException;

    protected Unistd() {

    }

}
