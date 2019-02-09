package de.ibapl.jnhw.isoc;

import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.LibJnhwPosixLoader;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.util.ByteBufferUtils;
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

    protected Unistd() {

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
     * @exception ArrayIndexOutOfBoundsException if <code>pos</code> or <code>len</code> out of bounds.
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
     * @exception ArrayIndexOutOfBoundsException if <code>pos</code> or <code>len</code> out of bounds.
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

}
