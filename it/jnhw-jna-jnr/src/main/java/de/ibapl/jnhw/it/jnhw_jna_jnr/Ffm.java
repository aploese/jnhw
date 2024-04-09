/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2022-2024, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.posix.Time;
import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

/**
 *
 * @author aploese
 */
public class Ffm {

    final static boolean DIRECT_ACCESS = true;

    final static ValueLayout TV_SEC_LAYOUT = ValueLayout.JAVA_LONG.withName("tv_sec");
    final static ValueLayout TV_NSEC_MEMORY_LAYOUT = ValueLayout.JAVA_LONG.withName("tv_nsec");
    final static MemoryLayout TIMESPEC_MEMORY_LAYOUT = MemoryLayout.structLayout(
            TV_SEC_LAYOUT,
            TV_NSEC_MEMORY_LAYOUT);
    final static VarHandle tv_sec = TIMESPEC_MEMORY_LAYOUT.varHandle(PathElement.groupElement("tv_sec"));
    final static VarHandle tv_nsec = TIMESPEC_MEMORY_LAYOUT.varHandle(PathElement.groupElement("tv_nsec"));

    final static Linker LINKER = Linker.nativeLinker();
    final static SymbolLookup SYMBOL_LOOKUP = LINKER.defaultLookup();
    final static MethodHandle clock_gettime = LINKER.downcallHandle(
            SYMBOL_LOOKUP.find("clock_gettime").get(),
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT, ValueLayout.ADDRESS)
    );
    final static MethodHandle clock_settime = LINKER.downcallHandle(
            SYMBOL_LOOKUP.find("clock_settime").get(),
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT, ValueLayout.ADDRESS)
    );

    final static int getErrno() {
        try {
            final MethodHandle errnoAddr = LINKER.downcallHandle(SYMBOL_LOOKUP.find("__errno_location").get(), FunctionDescriptor.of(ValueLayout.ADDRESS.withTargetLayout(MemoryLayout.paddingLayout(ValueLayout.JAVA_INT.byteSize()))));
            return ((MemorySegment) errnoAddr.invoke()).get(ValueLayout.JAVA_INT, 0);
        } catch (Throwable th) {
            throw new RuntimeException("Cant find errno", th);
        }
    }

    public static void runFullTest_HeapAllocated(final int count) {
        final int CLOCK_MONOTONIC = de.ibapl.jnhw.posix.Time.CLOCK_MONOTONIC;
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment heap = arena.allocate(1024);
            if (DIRECT_ACCESS) {
                for (int i = 0; i < count; i++) {
                    MemorySegment timespec = heap.asSlice(0, de.ibapl.jnhw.posix.Time.Timespec.sizeof);

                    if (((long) clock_gettime.invokeExact(CLOCK_MONOTONIC, timespec)) != 0) {
                        throw new RuntimeException("Errno: " + getErrno());
                    }
                    final long value = timespec.get(ValueLayout.JAVA_LONG, Time.Timespec.offsetof_Tv_sec);
                    timespec.set(ValueLayout.JAVA_LONG, Time.Timespec.offsetof_Tv_sec, timespec.get(ValueLayout.JAVA_LONG, Time.Timespec.offsetof_Tv_nsec));
                    timespec.set(ValueLayout.JAVA_LONG, Time.Timespec.offsetof_Tv_nsec, value);
                }
            } else {
                for (int i = 0; i < count; i++) {
                    MemorySegment timespec = heap.asSlice(0, de.ibapl.jnhw.posix.Time.Timespec.sizeof);

                    if (((long) clock_gettime.invokeExact(CLOCK_MONOTONIC, timespec)) != 0) {
                        throw new RuntimeException("Errno: " + getErrno());
                    }
                    final long value = (long) tv_sec.get(timespec);
                    tv_sec.set(timespec, (long) tv_nsec.get(timespec));
                    tv_nsec.set(timespec, value);
                }
            }
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static void runFullTest_DirectAllocation(final int count) {
        final int CLOCK_MONOTONIC = de.ibapl.jnhw.posix.Time.CLOCK_MONOTONIC;
        if (DIRECT_ACCESS) {
            for (int i = 0; i < count; i++) {
                try (Arena arena = Arena.ofConfined()) {
                    MemorySegment timespec = arena.allocate(de.ibapl.jnhw.posix.Time.Timespec.sizeof);

                    if (((long) clock_gettime.invokeExact(CLOCK_MONOTONIC, timespec)) != 0) {
                        throw new RuntimeException("Errno: " + getErrno());
                    }
                    final long value = timespec.get(ValueLayout.JAVA_LONG, Time.Timespec.offsetof_Tv_sec);
                    timespec.set(ValueLayout.JAVA_LONG, Time.Timespec.offsetof_Tv_sec, timespec.get(ValueLayout.JAVA_LONG, Time.Timespec.offsetof_Tv_nsec));
                    timespec.set(ValueLayout.JAVA_LONG, Time.Timespec.offsetof_Tv_nsec, value);
                } catch (Throwable th) {
                    throw new RuntimeException(th);
                }
            }
        } else {
            for (int i = 0; i < count; i++) {
                try (Arena arena = Arena.ofConfined()) {
                    MemorySegment timespec = arena.allocate(de.ibapl.jnhw.posix.Time.Timespec.sizeof);

                    if (((long) clock_gettime.invokeExact(CLOCK_MONOTONIC, timespec)) != 0) {
                        throw new RuntimeException("Errno: " + getErrno());
                    }
                    final long value = (long) tv_sec.get(timespec);
                    tv_sec.set(timespec, (long) tv_nsec.get(timespec));
                    tv_nsec.set(timespec, value);
                } catch (Throwable th) {
                    throw new RuntimeException(th);
                }
            }
        }
    }

    static volatile MemorySegment ts;

    public static void mem(final int count) {
        for (int i = 0; i < count; i++) {
            try (Arena arena = Arena.ofConfined()) {
                ts = arena.allocate(de.ibapl.jnhw.posix.Time.Timespec.sizeof);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
    }

    public static void clock_gettime(final int count) {
        final int CLOCK_MONOTONIC = de.ibapl.jnhw.posix.Time.CLOCK_MONOTONIC;
        try (Arena arena = Arena.ofConfined()) {
            final MemorySegment timespec = arena.allocate(de.ibapl.jnhw.posix.Time.Timespec.sizeof);
            for (int i = 0; i < count; i++) {
                if (((long) clock_gettime.invokeExact(CLOCK_MONOTONIC, timespec)) != 0) {
                    throw new RuntimeException("Errno: " + getErrno());
                }
            }
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static int clock_settime(final int clock) {
        try (Arena arena = Arena.ofConfined()) {
            final MemorySegment timespec = arena.allocate(de.ibapl.jnhw.posix.Time.Timespec.sizeof);
            if (((long) clock_settime.invokeExact(clock, timespec)) != 0) {
                return getErrno();
            } else {
                throw new RuntimeException("Expected error");
            }
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    static volatile long val;

    public static void get(final int count) {
        try (Arena arena = Arena.ofConfined()) {
            final MemorySegment timespec = arena.allocate(de.ibapl.jnhw.posix.Time.Timespec.sizeof);
            if (DIRECT_ACCESS) {
                for (int i = 0; i < count; i++) {
                    val = timespec.get(ValueLayout.JAVA_LONG, Time.Timespec.offsetof_Tv_sec);
                    val = timespec.get(ValueLayout.JAVA_LONG, Time.Timespec.offsetof_Tv_nsec);
                }
            } else {
                for (int i = 0; i < count; i++) {
                    val = ((long) tv_sec.get(timespec));
                    val = ((long) tv_nsec.get(timespec));
                }
            }
        }
    }

    public static void set(final int count) {
        try (Arena arena = Arena.ofConfined()) {
            final MemorySegment timespec = arena.allocate(de.ibapl.jnhw.posix.Time.Timespec.sizeof);
            if (DIRECT_ACCESS) {
                for (int i = 0; i < count; i++) {
                    timespec.set(ValueLayout.JAVA_LONG, Time.Timespec.offsetof_Tv_sec, val);
                    timespec.set(ValueLayout.JAVA_LONG, Time.Timespec.offsetof_Tv_nsec, val);
                }
            } else {
                for (int i = 0; i < count; i++) {
                    tv_sec.set(timespec, val);
                    tv_nsec.set(timespec, val);
                }
            }
        }
    }

}
