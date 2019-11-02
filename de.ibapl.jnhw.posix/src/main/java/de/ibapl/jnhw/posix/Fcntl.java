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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.NotDefinedException;
import de.ibapl.jnhw.posix.sys.Types.mode_t;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;

@Include("#include <fcntl.h>")
public final class Fcntl {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    public final static native boolean HAVE_FCNTL_H();

    @Define
    public final static native int O_RDONLY();

    @Define
    public final static native int O_WRONLY();

    @Define
    public final static native int O_RDWR();

    @Define
    public final static native int O_EXEC() throws NotDefinedException;

    @Define
    public final static native int O_SEARCH();

    @Define
    public final static native int O_APPEND();

    @Define
    public final static native int O_CLOEXEC();

    @Define
    public final static native int O_CREAT();

    @Define
    public final static native int O_DIRECTORY();

    @Define
    public final static native int O_EXCL();

    @Define
    public final static native int O_NOCTTY();

    @Define
    public final static native int O_NOFOLLOW();

    @Define
    public final static native int O_NONBLOCK();

    @Define
    public final static native int O_SYNC();

    @Define
    public final static native int O_TRUNC();

    @Define
    public final static native int O_TTY_INIT() throws NotDefinedException;

    @Define
    public final static native int O_DSYNC() throws NotDefinedException;

    @Define
    public final static native int O_RSYNC() throws NotDefinedException;

    @Define
    public final static native int O_FSYNC() throws NotDefinedException;

    @Define
    public final static native int O_ASYNC() throws NotDefinedException;

    @Define
    public final static native int O_ACCMODE();
    
    @Define
    public final static native int F_DUPFD();

    @Define
    public final static native int F_DUPFD_CLOEXEC();

    @Define
    public final static native int F_GETFD();

    @Define
    public final static native int F_SETFD();

    @Define
    public final static native int F_GETFL();

    @Define
    public final static native int F_SETFL();
    
    @Define
    public final static native int F_GETOWN();

    @Define
    public final static native int F_SETOWN();
    
    @Define
    public final static native int FNONBLOCK();

    @Define
    public final static native int FD_CLOEXEC();


    /**
     * Creates the named file with the mode flags.
     *
     * @param file
     * @param mode
     * @return a handle to the opend file.
     *
     * @exception NullPointerException if <code>file</code> is
     * <code>null</code>.
     *
     * @throws NativeErrorException
     */
    public final static native int creat(String file, @mode_t int mode) throws NativeErrorException;

    public final static native int fcntl(int fd, int cmd) throws NativeErrorException;

    public final static native int fcntl(int fd, int cmd, int vararg_0) throws NativeErrorException;

    /**
     * Opens the named file with the flags.
     *
     * @param file
     * @param oflag
     * @return a handle to the opend file.
     *
     * @exception NullPointerException if <code>file</code> is
     * <code>null</code>.
     *
     * @throws NativeErrorException
     */
    public final static native int open(String file, int oflag) throws NativeErrorException;

    private Fcntl() {
    }
}
