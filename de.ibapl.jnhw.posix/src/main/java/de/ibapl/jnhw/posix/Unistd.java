package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.LibJnhwPosixLoader;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.util.ByteBufferUtils;
import java.nio.ByteBuffer;

@Include("#include <unistd.h>")
public final class Unistd extends de.ibapl.jnhw.isoc.Unistd {

    /**
     * 
     * @param read_fd
     * @param write_fd
     * 
     * @exception NullPointerException if <code>read_fd</code> or <code>write_fd</code> is <code>null</code>.
     * @throws de.ibapl.jnhw.NativeErrorException if an error occured .
     */
    public final static native void pipe(IntRef read_fd, IntRef write_fd) throws NativeErrorException;

    private Unistd() {

    }

}
