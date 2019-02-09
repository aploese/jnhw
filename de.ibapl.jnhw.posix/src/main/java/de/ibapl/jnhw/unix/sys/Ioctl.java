package de.ibapl.jnhw.unix.sys;

import de.ibapl.jnhw.LibJnhwPosixLoader;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.IntRef;

@Include("#include <sys/ioctl.h>")
public final class Ioctl extends LibJnhwPosixLoader {

    public final static native boolean HAVE_SYS_IOCTL_H();
    
    private Ioctl() {
        
    }

    public final static native int ioctl(int fd, long request) throws NativeErrorException;

    public final static native int ioctl(int fd, long request, IntRef value) throws NativeErrorException;

    @Define
    public final static native int FIONREAD();

    @Define
    public final static native int TIOCM_CTS();

    @Define
    public final static native int TIOCM_DTR();

    @Define
    public final static native int TIOCM_CAR();

    @Define
    public final static native int TIOCM_RTS();

    @Define
    public final static native int TIOCM_RNG();

    @Define
    public final static native int TIOCM_DSR();

    @Define
    public final static native int TIOCEXCL();

    @Define
    public final static native int TIOCSBRK();

    @Define
    public final static native int TIOCCBRK();

    @Define
    public final static native int TIOCMGET();

    @Define
    public final static native int TIOCMSET();

    @Define
    public final static native int TIOCOUTQ();

}
