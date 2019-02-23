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

import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.NativeErrorException;

@Include("#include <unistd.h>")
public final class Unistd extends de.ibapl.jnhw.isoc.Unistd {

    /**
     *
     * @param read_fd
     * @param write_fd
     *
     * @exception NullPointerException if <code>read_fd</code> or
     * <code>write_fd</code> is <code>null</code>.
     * @throws de.ibapl.jnhw.NativeErrorException if an error occured .
     */
    public final static native void pipe(IntRef read_fd, IntRef write_fd) throws NativeErrorException;

    private Unistd() {

    }

}
