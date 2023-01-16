/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.posix.sys.Stat;
import de.ibapl.jnhw.util.posix.Defines;
import de.ibapl.jnhw.util.posix.DefinesTest;
import java.io.File;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class FcntlTest {

    @BeforeAll
    public static void checkBeforeAll_HAVE_FCNTL_H() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Fcntl.HAVE_FCNTL_H, "not expected to have fcntl.h");
        } else {
            Assertions.assertTrue(Fcntl.HAVE_FCNTL_H, "expected to have locale.h");
        }
    }

    @BeforeAll
    public static void checkBeforeAll_FcntlDefines() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Fcntl.class, "HAVE_FCNTL_H");
    }

    @Test
    public void testNPEOpen() throws Exception {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Fcntl.open(null, 0);
        });
    }

    @Test
    public void testNPECreat() throws Exception {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Fcntl.creat(null, 0);
        });
    }

    @Test
    public void testOpen() throws Exception {
        File file = File.createTempFile("jnhw-posix-fcntl-test", ".txt");
        NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
            Fcntl.open(file.getAbsolutePath(), Fcntl.O_CREAT | Fcntl.O_EXCL, Stat.S_IRWXU | Stat.S_IRWXG);
        });
        switch (MultiarchTupelBuilder.getMultiarch()) {
            case AARCH64__LINUX__GNU, I386__LINUX__GNU, POWER_PC_64_LE__LINUX__GNU, X86_64__FREE_BSD__BSD ->
                Assertions.assertEquals(Errno.ENOENT, Errno.errno());
            case ARM__LINUX__GNU_EABI_HF, S390_X__LINUX__GNU, X86_64__LINUX__GNU ->
                Assertions.assertEquals(Errno.EEXIST, Errno.errno());
            default ->
                throw new RuntimeException("Dont know what to expect on errno: " + Errno.errno() + " platform : " + MultiarchTupelBuilder.getMultiarch());
        }
    }

    @Test
    public void testOpen64() throws Exception {
        File file = File.createTempFile("jnhw-posix-fcntl64-test", ".txt");
        if (Defines._LARGEFILE64_SOURCE.isDefined()) {
            NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                Fcntl.open64(file.getAbsolutePath(), Fcntl.O_CREAT | Fcntl.O_EXCL, Stat.S_IRWXU | Stat.S_IRWXG);
            });
            switch (MultiarchTupelBuilder.getMultiarch()) {
                case AARCH64__LINUX__GNU, I386__LINUX__GNU, POWER_PC_64_LE__LINUX__GNU, X86_64__FREE_BSD__BSD ->
                    Assertions.assertEquals(Errno.ENOENT, Errno.errno());
                case ARM__LINUX__GNU_EABI_HF, S390_X__LINUX__GNU, X86_64__LINUX__GNU ->
                    Assertions.assertEquals(Errno.EEXIST, Errno.errno());
                default ->
                    throw new RuntimeException("Dont know what to expect on errno: " + Errno.errno() + " platform : " + MultiarchTupelBuilder.getMultiarch());
            }
        } else {
            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                Fcntl.open64(file.getAbsolutePath(), Fcntl.O_CREAT | Fcntl.O_EXCL, Stat.S_IRWXU | Stat.S_IRWXG);
            });
        }
    }

    Integer data = 44;
    Optional<Integer> opt = Optional.of(data);

    //Todo move this to sepetate test
    /*
rounds = 1_000_000_000
    Results:
3 took: 95ms data: 1050327040
2 took: 30ms data: 2100654080
1 took: 29ms data: 1050327040
     */
    //  @Test
    public void testSpeedOfOptionalAccess() {
        final int rounds = 1_000_000_000;
        int testD = 0;
        long start;

        testD = 0;
        start = System.currentTimeMillis();
        for (int i = 0; i < rounds; i++) {
            testD += data;
        }
        System.out.println("3 took: " + (System.currentTimeMillis() - start) + "ms data: " + testD);

        testD = 0;
        start = System.currentTimeMillis();
        for (int i = 0; i < rounds; i++) {
            testD += opt.orElseThrow(() -> new RuntimeException());
            testD += data;
        }
        System.out.println("2 took: " + (System.currentTimeMillis() - start) + "ms data: " + testD);

        testD = 0;
        start = System.currentTimeMillis();
        for (int i = 0; i < rounds; i++) {
            if (data != null) {
                testD += data;
            } else {
                throw new RuntimeException();
            }
        }
        System.out.println("1 took: " + (System.currentTimeMillis() - start) + "ms data: " + testD);

    }

}
