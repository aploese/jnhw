package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;

@Include("winerr")
public abstract class Winerr {

    @Define
    public final static native int ERROR_SUCCESS();
    @Define
    public final static native int ERROR_FILE_NOT_FOUND();
    @Define
    public final static native int ERROR_ACCESS_DENIED();
    @Define
    public final static native int ERROR_GEN_FAILURE();
    @Define
    public final static native int ERROR_INVALID_PARAMETER();
    @Define
    public final static native int ERROR_IO_PENDING();
}
