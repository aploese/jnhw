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
package de.ibapl.jnhw.it.jnhw_jna_jnr;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;

/**
 *
 * @author aploese
 */
public class Jna {

    @Structure.FieldOrder({"tv_sec","tv_nsec"})
    public static class Timespec extends Structure {

        public long tv_sec;
        public long tv_nsec;

    }

    public interface LibC extends Library {

        int clock_gettime(int clock_id, Timespec timespec);

        int errno();
    }

    static LibC libc = (LibC)Native.load("c", LibC.class);

    public static void runFullTest(final int count) {
        final int CLOCK_MONOTONIC = de.ibapl.jnhw.posix.Time.CLOCK_MONOTONIC();

        for (int i = 0; i < count; i++) {
            Timespec timespec = new Timespec();
            if (libc.clock_gettime(CLOCK_MONOTONIC, timespec) != 0) {
                throw new RuntimeException("Errno: " + libc.errno());
            }
            final long val = timespec.tv_sec;
            timespec.tv_sec = timespec.tv_nsec;
            timespec.tv_nsec = val;
        }
    }

    static volatile Timespec ts;

    public static void mem(final int count) {
        for (int i = 0; i < count; i++) {
            ts = new Timespec();
        }
    }

    public static void clock_gettime(final int count) {
        final int CLOCK_MONOTONIC = de.ibapl.jnhw.posix.Time.CLOCK_MONOTONIC();
        final Timespec timespec = new Timespec();
        for (int i = 0; i < count; i++) {
            libc.clock_gettime(CLOCK_MONOTONIC, timespec);
        }
    }

    static volatile long val;

    public static void get(final int count) {
        final Timespec timespec = new Timespec();
        for (int i = 0; i < count; i++) {
            val = timespec.tv_sec + timespec.tv_nsec;
        }
    }

    //TODO UNION and test if native set ???
    public static void set(final int count) {
        final Timespec timespec = new Timespec();
        for (int i = 0; i < count; i++) {
            timespec.tv_sec = val;
            timespec.tv_nsec = val;
        }
    }

}