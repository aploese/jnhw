package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;

@Include("winerror.h")
public abstract class Winerror {

    public final static native boolean HAVE_WINERROR_H();

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
    @Define
    public final static native int ERROR_NO_MORE_ITEMS();

	@Define
    public final static native int ERROR_MORE_DATA();
	
}
