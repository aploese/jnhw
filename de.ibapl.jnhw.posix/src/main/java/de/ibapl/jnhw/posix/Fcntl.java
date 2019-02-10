package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.LibJnhwPosixLoader;
import de.ibapl.jnhw.NativeErrorException;

@Include("#include <fcntl.h>")
public final class Fcntl extends LibJnhwPosixLoader {

    public final static native boolean HAVE_FCNTL_H();

    @Define
    public final static native int O_RDWR();

    @Define
    public final static native int FNONBLOCK();

    @Define
    public final static native int O_NOCTTY();

    @Define
    public final static native int O_NONBLOCK();

    @Define
    public final static native int F_GETFL();

    @Define
    public final static native int F_SETFL();

    /**
     * Creates the named file with the mode flags.
     *
     * @param file
     * @param mode
     * @return a handle to the opend file.
     *
     * @exception NullPointerException if <code>file</code> is
     * <code>null</code>.
     *
     * @throws NativeErrorException
     */
    public final static native int creat(CharSequence file, int mode) throws NativeErrorException;

    public final static native int fcntl(int fd, int cmd) throws NativeErrorException;

    public final static native int fcntl(int fd, int cmd, int vararg_0) throws NativeErrorException;

    /**
     * Opens the named file with the flags.
     *
     * @param file
     * @param oflag
     * @return a handle to the opend file.
     *
     * @exception NullPointerException if <code>file</code> is
     * <code>null</code>.
     *
     * @throws NativeErrorException
     */
    public final static native int open(CharSequence file, int oflag) throws NativeErrorException;

    private Fcntl() {
    }
}
