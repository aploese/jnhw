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
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Wrapper around the {@code<stdio.h>} header.
 *
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/stdio.h.html">stdio.h - standard buffered input/output</a>.
 *
 * @author aploese
 */
@Include("#include <stdio.h>")
public class Stdio {
    
    
    /**
     * See specs at:
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/stdio.h.html"><code>typedef
     * FILE</code></a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @interface FILE{
    }
    
    /**
     * See specs at:
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/stdio.h.html"><code>typedef
     * fpos_t</code></a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @interface fpos_t{
    }

    /**
     * See specs at:
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/stdio.h.html"><code>typedef
     * off_t</code></a>.
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sys/types.h.html"><code>typedef
     * off_t</code></a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @interface off_t{
    }

    /**
     * See specs at:
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/stdio.h.html"><code>typedef
     * size_t</code></a>.
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/stddef.h.html"><code>typedef
     * off_t</code></a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @interface size_t{
    }

    /**
     * See specs at:
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/stdio.h.html"><code>typedef
     * ssize_t</code></a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @interface ssize_t{
    }

    /**
     * See specs at:
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/stdio.h.html"><code>typedef
     * va_list</code></a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @interface va_list{
    }

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    public final static native boolean HAVE_STDIO_H();
    
    /**
     *
     * See specs at:
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/remove.html">remove - remove a file</a>.
     * @param path 
     * @throws de.ibapl.jnhw.NativeErrorException 
     */
    public static native void remove(String path) throws NativeErrorException;

    
}
