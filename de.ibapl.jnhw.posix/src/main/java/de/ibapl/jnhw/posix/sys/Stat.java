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
package de.ibapl.jnhw.posix.sys;

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;

/**
 *
 * @author aploese
 */
@Include("#include <sys/stat.h>")
public class Stat {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    @Define
    public final static native boolean HAVE_SYS_STAT_H();

    @Define
    public final static native int S_IRWXU();

    @Define
    public final static native int S_IRUSR();

    @Define
    public final static native int S_IWUSR();

    @Define
    public final static native int S_IXUSR();

    @Define
    public final static native int S_IRWXG();

    @Define
    public final static native int S_IRGRP();

    @Define
    public final static native int S_IWGRP();

    @Define
    public final static native int S_IXGRP();

    @Define
    public final static native int S_IRWXO();

    @Define
    public final static native int S_IROTH();

    @Define
    public final static native int S_IWOTH();

    @Define
    public final static native int S_IXOTH();

    @Define
    public final static native int S_ISUID();

    @Define
    public final static native int S_ISGID();

    @Define
    public final static native int S_ISVTX();
}
