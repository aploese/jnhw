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

import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;

/**
 * Compare JNHW JNR and JNA create a timespec struct and call
 * {@code clock_gettime(CLOCK_MONOTONIC, timespec)} {@code ROUND} times. JNA is
 * slow becaus it must copy the members of struct timespec in ans out. JNHW uses
 * its own memory, if its preallocates its memory - is quit fast. JNR is faster
 * in set/get because it uses the internal memory access from the jre.
 *
 * JNHW can handle structures that varies in size and alignment across OS and
 * arch like struct termios (on linux mips some struct members are absent) or
 * stuct mcontext_t which has different sizes and alignments.
 *
 */
public class App {

    final static int ROUNDS = 10_000_000;

    public static void main(String[] args) {
        System.out.println("clock_settime");
        System.out.println("JNHW");
        assert de.ibapl.jnhw.posix.Errno.EPERM == Jnhw.clock_settime(de.ibapl.jnhw.posix.Time.CLOCK_REALTIME);
        System.out.println("JNA");
        assert de.ibapl.jnhw.posix.Errno.EPERM == Jna.clock_settime(de.ibapl.jnhw.posix.Time.CLOCK_REALTIME);
        System.out.println("JNR");
        assert de.ibapl.jnhw.posix.Errno.EPERM == Jnr.clock_settime(de.ibapl.jnhw.posix.Time.CLOCK_REALTIME);
        System.out.println("FFM");
        assert de.ibapl.jnhw.posix.Errno.EPERM == Ffm.clock_settime(de.ibapl.jnhw.posix.Time.CLOCK_REALTIME);
        System.out.println("clock_settime done");

        try {
            if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
                throw new RuntimeException();
            }

            System.out.println();
            System.out.println();

            long start = System.nanoTime();
            //Preallocate native memory in a heap
            Jnhw.runFullTest_HeapAllocated(ROUNDS);
            //Allocate new native memory in each loop
            //Jnhw.runFullTest_DirectAllocation(ROUNDS);
            printResult("JNHW runFullTest", start);
            start = System.nanoTime();
            Ffm.runFullTest_HeapAllocated(ROUNDS);
            //Ffm.runFullTest_DirectAllocation(ROUNDS);
            printResult("FFM  runFullTest", start);
            start = System.nanoTime();
            Jnr.runFullTest(ROUNDS);
            printResult("JNR  runFullTest", start);
            start = System.nanoTime();
            Jna.runFullTest(ROUNDS);
            printResult("JNA  runFullTest", start);
            System.out.println();

            start = System.nanoTime();
            Jnhw.clock_gettime(ROUNDS);
            printResult("JNHW clock_gettime", start);
            start = System.nanoTime();
            Ffm.clock_gettime(ROUNDS);
            printResult("FFM  clock_gettime", start);
            start = System.nanoTime();
            Jnr.clock_gettime(ROUNDS);
            printResult("JNR  clock_gettime", start);
            start = System.nanoTime();
            Jna.clock_gettime(ROUNDS);
            printResult("JNA  clock_gettime", start);
            System.out.println();

            start = System.nanoTime();
            //Preallocate native memory in a heap
            Jnhw.mem_HeapAllocated(ROUNDS);
            //Allocate new native memory in each loop
            //Jnhw.mem_DirectAllocation(ROUNDS);
            printResult("JNHW mem", start);
            start = System.nanoTime();
            Ffm.mem(ROUNDS);
            printResult("FFM  mem", start);
            start = System.nanoTime();
            Jnr.mem(ROUNDS);
            printResult("JNR  mem", start);
            start = System.nanoTime();
            Jna.mem(ROUNDS);
            printResult("JNA  mem", start);
            System.out.println();

            start = System.nanoTime();
            Jnhw.get(ROUNDS);
            printResult("JNHW get", start);
            start = System.nanoTime();
            Ffm.get(ROUNDS);
            printResult("FFM  get", start);
            start = System.nanoTime();
            Jnr.get(ROUNDS);
            printResult("JNR  get", start);
            start = System.nanoTime();
            Jna.get(ROUNDS);
            printResult("JNA  get", start);
            System.out.println();

            start = System.nanoTime();
            Jnhw.set(ROUNDS);
            printResult("JNHW set", start);
            start = System.nanoTime();
            Ffm.set(ROUNDS);
            printResult("FFM  set", start);
            start = System.nanoTime();
            Jnr.set(ROUNDS);
            printResult("JNR  set", start);
            start = System.nanoTime();
            Jna.set(ROUNDS);
            printResult("JNA  set", start);
            System.out.println();
        } catch (Exception e) {
            System.err.println("Ex: " + e);
            System.exit(1);
        }
    }

    private static void printResult(String prefix, long start) {
        long diff = System.nanoTime() - start;
        System.out.print(prefix);
        long nanoSec = diff % 1000;
        long microSec = (diff / 1000) % 1000;
        long milliSec = (diff / 1_000_000) % 1000;
        long sec = (diff / 1_000_000_000) % 1000;
        System.out.println(String.format(" took: %ds %dms %dµs %dns", sec, milliSec, microSec, nanoSec));
    }
}
