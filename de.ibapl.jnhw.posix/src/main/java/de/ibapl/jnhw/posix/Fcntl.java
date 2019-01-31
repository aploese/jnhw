package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.LibJnhwLoader;
import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.NativeErrorException;

@Include("#include <fcntl.h>")
public final class Fcntl extends LibJnhwLoader {

    private Fcntl() {
    }

    public final static native int creat(CharSequence file, int mode);

    @Define
    public final static native int FNONBLOCK();

    @Define
    public final static native int O_RDWR();

    @Define
    public final static native int O_NOCTTY();

    @Define
    public final static native int O_NONBLOCK();

    public final static native int open(CharSequence file, int oflag) throws NativeErrorException;
}
