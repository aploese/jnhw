/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2021-2024, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.it.jnhw_jna_jnr;

import jnr.ffi.LibraryLoader;
import jnr.ffi.Struct;
import jnr.ffi.annotations.Out;
import jnr.ffi.annotations.Transient;

/**
 *
 * @author aploese
 */
public class Jnr {

    public static final class Timespec extends Struct {

        public final time_t tv_sec = new time_t();
        public final SignedLong tv_nsec = new SignedLong();

        public Timespec(jnr.ffi.Runtime runtime) {
            super(runtime);
        }
    }

    public interface LibC {

        int clock_gettime(int clock_id, @Out @Transient Timespec timespec);

        int clock_settime(int clock_id, @Out @Transient Timespec timespec);

    }

    static LibC libc = LibraryLoader.create(LibC.class).load("c");
    static jnr.ffi.Runtime runtime = jnr.ffi.Runtime.getRuntime(libc);

    public static void runFullTest(final int count) {
        final int CLOCK_MONOTONIC = de.ibapl.jnhw.posix.Time.CLOCK_MONOTONIC;

        for (int i = 0; i < count; i++) {
            Timespec timespec = new Timespec(runtime);
            if (libc.clock_gettime(CLOCK_MONOTONIC, timespec) != 0) {
                throw new RuntimeException("Errno: " + runtime.getLastError());
            }
            final long val = timespec.tv_sec.longValue();
            timespec.tv_sec.set(timespec.tv_nsec.longValue());
            timespec.tv_nsec.set(val);
        }
    }

    static volatile Timespec ts;

    public static void mem(final int count) {
        for (int i = 0; i < count; i++) {
            ts = new Timespec(runtime);
        }
    }

    public static void clock_gettime(final int count) {
        final int CLOCK_MONOTONIC = de.ibapl.jnhw.posix.Time.CLOCK_MONOTONIC;
        final Timespec timespec = new Timespec(runtime);
        for (int i = 0; i < count; i++) {
            if (libc.clock_gettime(CLOCK_MONOTONIC, timespec) != 0) {
                throw new RuntimeException("Errno: " + runtime.getLastError());
            }
        }
    }

    public static int clock_settime(final int clock) {
        final Timespec timespec = new Timespec(runtime);
        if (libc.clock_settime(clock, timespec) != 0) {
            return runtime.getLastError();
        } else {
            throw new RuntimeException("Expected error");
        }
    }

    static volatile long val;

    public static void get(final int count) {
        final Timespec timespec = new Timespec(runtime);
        for (int i = 0; i < count; i++) {
            val = timespec.tv_sec.longValue();
            val = timespec.tv_nsec.longValue();
        }
    }

    public static void set(final int count) {
        final Timespec timespec = new Timespec(runtime);
        for (int i = 0; i < count; i++) {
            timespec.tv_sec.set(val);
            timespec.tv_nsec.set(val);
        }
    }

}
