package de.ibapl.jnhw.linux.sys;

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.LibJnhwLoader;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.LongRef;

@Include("#include <sys/eventfd.h>")
public final class Eventfd extends LibJnhwLoader {

    private Eventfd() {

    }

    private static native void initNative(Class<LongRef> longRef);

    static {
        initNative(LongRef.class);
    }

    public final static native int eventfd(int count, int flags) throws NativeErrorException;

    public final static native int eventfd_read(int fd, LongRef value) throws NativeErrorException;

    public final static native int eventfd_write(int fd, long value) throws NativeErrorException;

    @Define
    public final static native int EFD_CLOEXEC();

    @Define
    public final static native int EFD_NONBLOCK();

    @Define
    public final static native int EFD_SEMAPHORE();

}
