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
package de.ibapl.jnhw.linux.sys;

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.LongRef;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Include("#include <sys/eventfd.h>")
public final class Eventfd {

    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    public static @interface eventfd_t {
    }

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    private Eventfd() {

    }

    public final static native boolean HAVE_SYS_EVENTFD_H();

    public final static native int eventfd(int count, int flags) throws NativeErrorException;

    public final static native int eventfd_read(int fd, @eventfd_t LongRef value) throws NativeErrorException;

    public final static native int eventfd_write(int fd, @eventfd_t long value) throws NativeErrorException;

    @Define
    public final static native int EFD_CLOEXEC();

    @Define
    public final static native int EFD_NONBLOCK();

    @Define
    public final static native int EFD_SEMAPHORE();

}
