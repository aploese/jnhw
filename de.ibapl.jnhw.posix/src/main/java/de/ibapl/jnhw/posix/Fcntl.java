package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.LibJnhwPosixLoader;
import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.NativeErrorException;

@Include("#include <fcntl.h>")
public final class Fcntl extends de.ibapl.jnhw.isoc.Fcntl {

    private Fcntl() {
    }

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

    public final static native int fcntl(int fd, int cmd) throws NativeErrorException;
    
    public final static native int fcntl(int fd, int cmd, int vararg_0) throws NativeErrorException;
}
