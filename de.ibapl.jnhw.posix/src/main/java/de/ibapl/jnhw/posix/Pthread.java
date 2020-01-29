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
import de.ibapl.jnhw.OpaqueMemory;
import de.ibapl.jnhw.posix.sys.Types;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;

/**
 * Wrapper around the {@code <aio.h>} header.
 *
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/pthread.h.html">pthread.h
 * - threads</a>.
 *
 * @author aploese
 */
@Include("#include <pthread.h>")
public class Pthread {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    public final static native boolean HAVE_PTHREAD_H();

    private static native void pthread_self0(Pthread_t result);

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_self.html">pthread_self
     * - get the calling thread ID</a>.
     */
    public final static Pthread_t pthread_self() {
        final Pthread_t result = new Pthread_t();
        pthread_self0(result);
        return result;
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_equal.html">pthread_equal
     * - pthread_equal - compare thread IDs</a>.
     */
    public final static native boolean pthread_equal(Pthread_t t1, Pthread_t t2);

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_getcpuclockid.html">pthread_getcpuclockid
     * - access a thread CPU-time clock (ADVANCED REALTIME THREADS)</a>.
     */
    public final static native void pthread_getcpuclockid(Pthread_t thread_id, @Types.clockid_t IntRef clock_id) throws NativeErrorException;

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/pthread.h.html">{@code typedef
     * pthread_attr_t}</a>.
     *
     * @author aploese
     */
    @Types.pthread_attr_t
    public static final class Pthread_attr_t extends OpaqueMemory {

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        /**
         * Get the real size of struct pthread_attr_t natively.
         *
         * @return the native value sizeof(struct pthread_attr_t).
         */
        public static native int sizeofPthread_attr_t();

        public Pthread_attr_t() {
            super(sizeofPthread_attr_t(), false);
        }

        public Pthread_attr_t(OpaqueMemory owner, int offset) {
            super(owner, offset, sizeofPthread_attr_t());
        }

        public Pthread_attr_t(long baseAddress) {
            super(baseAddress, sizeofPthread_attr_t());
        }

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/pthread.h.html">{@code typedef
     * pthread_t}</a>.
     *
     * @author aploese
     */
    @Types.pthread_t
    public static final class Pthread_t extends OpaqueMemory {

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        /**
         * Get the real size of struct pthread_t natively.
         *
         * @return the native value sizeof(struct pthread_t).
         */
        public static native int sizeofPthread_t();

        public Pthread_t() {
            super(sizeofPthread_t(), false);
        }

        public Pthread_t(OpaqueMemory owner, int offset) {
            super(owner, offset, sizeofPthread_t());
        }

        public Pthread_t(long baseAddress) {
            super(baseAddress, sizeofPthread_t());
        }

        @Override
        public native String toString();

    }
}
