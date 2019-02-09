package de.ibapl.jnhw.isoc;

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.LibJnhwPosixLoader;

@Include("#include <errno.h>")
public abstract class Errno extends LibJnhwPosixLoader {

    protected Errno() {

    }

    public final static native boolean HAVE_ERRNO_H();

    /**
     * Mathematics argument out of domain of function.
     */
    @Define
    public final static native int EDOM();

    /**
     * Illegal byte sequence.
     */
    @Define
    public final static native int EILSEQ();

    /**
     * Result too large.
     */
    @Define
    public final static native int ERANGE();

    public final static native int errno();

    public final static native void errno(int value);

}
