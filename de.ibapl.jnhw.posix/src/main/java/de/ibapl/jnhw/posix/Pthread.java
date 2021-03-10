/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2021, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.annontation.posix.sys.types.clockid_t;
import de.ibapl.jnhw.annontation.posix.sys.types.pthread_attr_t;
import de.ibapl.jnhw.annontation.posix.sys.types.pthread_t;
import de.ibapl.jnhw.common.annotation.AlignOf;
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.annotation.SizeOf;
import de.ibapl.jnhw.common.references.IntRef;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import java.io.IOException;

/**
 * Wrapper around the {@code <pthread.h>} header.
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
     *
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        LibJnhwPosixLoader.touch();

        HAVE_PTHREAD_H = false;
        PTHREAD_CANCEL_ASYNCHRONOUS = 0;
        PTHREAD_CANCEL_DEFERRED = 0;
        PTHREAD_CANCEL_DISABLE = 0;
        PTHREAD_CANCEL_ENABLE = 0;
        PTHREAD_EXPLICIT_SCHED = 0;
        PTHREAD_INHERIT_SCHED = 0;

        initFields();
    }

    private static native void initFields();

    /**
     * <b>POSIX.TPS:</b>
     *
     */
    @Define
    public final static int PTHREAD_EXPLICIT_SCHED;

    /**
     * <b>POSIX.TPS:</b>
     *
     */
    @Define
    public final static int PTHREAD_INHERIT_SCHED;

    public final static boolean HAVE_PTHREAD_H;

    private static native void pthread_self0(Pthread_t result);

    /**
     * <b>POSIX.TPS:</b>
     *
     */
    @Define
    public final static int PTHREAD_CANCEL_DISABLE;

    /**
     * <b>POSIX.TPS:</b>
     *
     */
    @Define
    public final static int PTHREAD_CANCEL_ENABLE;

    /**
     * <b>POSIX.TPS:</b>
     *
     */
    @Define
    public final static int PTHREAD_CANCEL_DEFERRED;

    /**
     * <b>POSIX.TPS:</b>
     *
     */
    @Define
    public final static int PTHREAD_CANCEL_ASYNCHRONOUS;

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
     * <b>POSIX[TPS]:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_attr_getinheritsched.html">pthread_attr_getinheritsched,
     * pthread_attr_setinheritsched - get and set the inheritsched attribute
     * (REALTIME THREADS)</a>.
     *
     * @param attr
     *
     * @return the value of the native inheritsched arg.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native int pthread_attr_getinheritsched(Pthread_attr_t attr) throws NativeErrorException;

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_attr_getschedparam.html">pthread_attr_getschedparam,
     * pthread_attr_setschedparam - get and set the schedparam attribute</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void pthread_attr_getschedparam(Pthread_attr_t attr, Sched.Sched_param param) throws NativeErrorException;

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_attr_setinheritsched.html">pthread_attr_getinheritsched,
     * pthread_attr_setinheritsched - get and set the inheritsched attribute
     * (REALTIME THREADS)</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void pthread_attr_setinheritsched(Pthread_attr_t attr, int inheritsched) throws NativeErrorException;

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_attr_setschedparam.html">pthread_attr_getschedparam,
     * pthread_attr_setschedparam - get and set the schedparam attribute</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void pthread_attr_setschedparam(Pthread_attr_t attr, Sched.Sched_param param) throws NativeErrorException;

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_getschedparam.html">pthread_getschedparam,
     * pthread_setschedparam - dynamic thread scheduling parameters access
     * (REALTIME THREADS)</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void pthread_getschedparam(Pthread_t thread, IntRef policy, Sched.Sched_param param) throws NativeErrorException;

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_setschedparam.html">pthread_getschedparam,
     * pthread_setschedparam - dynamic thread scheduling parameters access
     * (REALTIME THREADS)</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void pthread_setschedparam(Pthread_t thread, int policy, Sched.Sched_param param) throws NativeErrorException;

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_setschedprio.html">pthread_setschedprio
     * - dynamic thread scheduling parameters access (REALTIME THREADS)</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method pthread_setschedprio is
     * not available natively.
     */
    public final static native void pthread_setschedprio(Pthread_t thread, int prio) throws NativeErrorException, NoSuchNativeMethodException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_getcpuclockid.html">pthread_getcpuclockid
     * - access a thread CPU-time clock (ADVANCED REALTIME THREADS)</a>.
     */
    public final static native void pthread_getcpuclockid(Pthread_t thread_id, @clockid_t IntRef clock_id) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_attr_destroy.html">pthread_attr_destroy,
     * pthread_attr_init - destroy and initialize the thread attributes
     * object</a>.
     */
    public final static native void pthread_attr_destroy(Pthread_attr_t attr);

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_attr_destroy.html">pthread_attr_destroy,
     * pthread_attr_init - destroy and initialize the thread attributes
     * object</a>.
     */
    public final static native void pthread_attr_init(Pthread_attr_t attr);

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/pthread.h.html">{@code typedef
     * pthread_attr_t}</a>.
     *
     * @author aploese
     */
    @pthread_attr_t
    public static final class Pthread_attr_t extends Struct32 {

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
        @SizeOf
        public static native int sizeof();

        @AlignOf
        public static native int alignof();

        public Pthread_attr_t() {
            this(null, 0, null);
        }

        public Pthread_attr_t(OpaqueMemory32 owner, int offset) {
            this(owner, offset, null);
        }

        public Pthread_attr_t(NativeAddressHolder baseAddress) {
            super(baseAddress, sizeof());
        }

        public Pthread_attr_t(OpaqueMemory32 parent, int offset, Byte setMem) {
            super(parent, offset, sizeof(), setMem);
        }

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/pthread.h.html">{@code typedef
     * pthread_t}</a>.
     *
     * @author aploese
     */
    @pthread_t
    public static final class Pthread_t extends Struct32 {

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
        @SizeOf
        public static native int sizeof();

        @AlignOf
        public static native int alignof();

        public Pthread_t() {
            this(null, 0, null);
        }

        public Pthread_t(OpaqueMemory32 owner, int offset) {
            this(owner, offset, null);
        }

        public Pthread_t(OpaqueMemory32 parent, int offset, Byte setMem) {
            super(parent, offset, sizeof(), setMem);
        }

        public Pthread_t(NativeAddressHolder baseAddress) {
            super(baseAddress, sizeof());
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            sb.append(nativeToString());
        }

        @Override
        public native String nativeToString();

    }

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_cancel.html">pthread_cancel
     * - cancel execution of a thread</a>.
     *
     * TEST CRASHES
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    final static native void pthread_cancel(Pthread_t thread) throws NativeErrorException;

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_testcancel.html">pthread_setcancelstate,
     * pthread_setcanceltype, pthread_testcancel - set cancelability state</a>.
     *
     * TEST CRASHES
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    final static native void pthread_testcancel() throws NativeErrorException;

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_setcancelstate.html">pthread_setcancelstate,
     * pthread_setcanceltype, pthread_testcancel - set cancelability state</a>.
     *
     * TEST CRASHES
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @return oldstate - the 2. argument int *oldstate.
     */
    final static native int pthread_setcancelstate(int state) throws NativeErrorException;

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_setcanceltype.html">pthread_setcancelstate,
     * pthread_setcanceltype, pthread_testcancel - set cancelability state</a>.
     *
     * TEST CRASHES
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @return oldtype - the 2. argument int *oldtype.
     */
    final static native int pthread_setcanceltype(int type) throws NativeErrorException;

}
