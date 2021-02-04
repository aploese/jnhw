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

import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.memory.Memory32Heap;
import de.ibapl.jnhw.posix.Time;

/**
 *
 * @author aploese
 */
public class Jnhw {

    public static void runFullTest_HeapAllocated(final int count) throws NativeErrorException {
        final int CLOCK_MONOTONIC = Time.CLOCK_MONOTONIC;
        final Memory32Heap heap = new Memory32Heap(Time.Timespec.sizeof(), false);
        for (int i = 0; i < count; i++) {
            final Time.Timespec timespec = new Time.Timespec(heap, 0);
            Time.clock_gettime(CLOCK_MONOTONIC, timespec);
            final long val = timespec.tv_sec();
            timespec.tv_sec(timespec.tv_nsec());
            timespec.tv_nsec(val);
        }
    }

    public static void runFullTest_DirectAllocation(final int count) throws NativeErrorException {
        final int CLOCK_MONOTONIC = Time.CLOCK_MONOTONIC;
        for (int i = 0; i < count; i++) {
            final Time.Timespec timespec = new Time.Timespec();
            Time.clock_gettime(CLOCK_MONOTONIC, timespec);
            final long val = timespec.tv_sec();
            timespec.tv_sec(timespec.tv_nsec());
            timespec.tv_nsec(val);
        }
    }

    static volatile Time.Timespec ts;

    /**
     * allocate memory in advance.
     *
     * @param count
     */
    public static void mem_HeapAllocated(final int count) {
        final Memory32Heap heap = new Memory32Heap(Time.Timespec.sizeof(), false);
        for (int i = 0; i < count; i++) {
            ts = new Time.Timespec(heap, 0);
        }
    }

    public static void mem_DirectAllocation(final int count) {
        for (int i = 0; i < count; i++) {
            ts = new Time.Timespec();
        }
    }

    public static void clock_gettime(final int count) throws NativeErrorException {
        final int CLOCK_MONOTONIC = Time.CLOCK_MONOTONIC;
        final Time.Timespec timespec = new Time.Timespec();
        for (int i = 0; i < count; i++) {
            Time.clock_gettime(CLOCK_MONOTONIC, timespec);
        }
    }

    static volatile long val;

    public static void get(final int count) {
        final Time.Timespec timespec = new Time.Timespec();
        for (int i = 0; i < count; i++) {
            val = timespec.tv_sec() + timespec.tv_nsec();
        }
    }

    public static void set(final int count) {
        final Time.Timespec timespec = new Time.Timespec();
        for (int i = 0; i < count; i++) {
            timespec.tv_sec(val);
            timespec.tv_nsec(val);
        }
    }
}
