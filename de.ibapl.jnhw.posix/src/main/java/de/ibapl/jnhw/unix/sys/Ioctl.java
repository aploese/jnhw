/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2019, Arne Plöse and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package de.ibapl.jnhw.unix.sys;

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;

@Include("#include <sys/ioctl.h>")
public final class Ioctl {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    public final static native boolean HAVE_SYS_IOCTL_H();

    private Ioctl() {

    }

    public final static native int ioctl(int fd, long request) throws NativeErrorException;

    public final static native int ioctl(int fd, long request, IntRef value) throws NativeErrorException;

    @Define
    public final static native long FIONREAD();

    @Define
    public final static native long TIOCM_CTS();

    @Define
    public final static native long TIOCM_DTR();

    @Define
    public final static native long TIOCM_CAR();

    @Define
    public final static native long TIOCM_RTS();

    @Define
    public final static native long TIOCM_RNG();

    @Define
    public final static native long TIOCM_DSR();

    @Define
    public final static native long TIOCEXCL();

    @Define
    public final static native long TIOCSBRK();

    @Define
    public final static native long TIOCCBRK();

    @Define
    public final static native long TIOCMGET();

    @Define
    public final static native long TIOCMSET();

    @Define
    public final static native long TIOCOUTQ();

}
