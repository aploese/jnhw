package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.LibJnhwLoader;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.util.ByteBufferUtils;
import java.nio.ByteBuffer;

@Include("#include <unistd.h>")
public class Unistd extends LibJnhwLoader {

    public static int write(int fd, byte[] buf) throws NativeErrorException {
        return write(fd, buf, 0, buf.length);
    }

    private Unistd() {

    }

    public final static native int close(int fd) throws NativeErrorException;

    public final static native int read(int fildes, byte[] buf, int pos, int len) throws NativeErrorException;

    private final static native int read(int fildes, ByteBuffer buffer, int pos, int len) throws NativeErrorException;

    public final static int read(int fildes, ByteBuffer buffer) throws NativeErrorException {
        final int result = read(fildes, buffer, buffer.position(), ByteBufferUtils.calcBufferReadBytes(buffer));
        buffer.position(buffer.position() + result);
        return result;
    }
    
    public final static native int write(int fildes, byte[] buf, int pos, int len) throws NativeErrorException;

    //We put down ByteBuffer to get the native address and pass the other data onto the stack
    private final static native int write(int fildes, ByteBuffer buffer, int pos, int len) throws NativeErrorException;

    public final static int write(int fildes, ByteBuffer buffer) throws NativeErrorException {
        final int result = write(fildes, buffer, buffer.position(), ByteBufferUtils.calcBufferWriteBytes(buffer));
        buffer.position(buffer.position() + result);
        return result;
    }

    public final static native int usleep(int usleep) throws NativeErrorException;

}
