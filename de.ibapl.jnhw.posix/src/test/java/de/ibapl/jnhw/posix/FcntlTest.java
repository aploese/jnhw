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
import static de.ibapl.jnhw.libloader.Arch.AARCH64;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.posix.sys.Stat;
import de.ibapl.jnhw.util.posix.Defines;
import de.ibapl.jnhw.util.posix.DefinesTest;
import java.io.File;
import java.util.Optional;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.condition.DisabledOnOs;

@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class FcntlTest {

    @BeforeAll
    public static void checkBeforeAll_HAVE_FCNTL_H() throws Exception {
        JnhwTestLogger.logBeforeAllBegin("checkBeforeAll_HAVE_FCNTL_H");
        Assertions.assertTrue(Fcntl.HAVE_FCNTL_H, "expected to have locale.h");
        JnhwTestLogger.logBeforeAllEnd("checkBeforeAll_HAVE_FCNTL_H");
    }

    @BeforeAll
    public static void checkBeforeAll_FcntlDefines() throws Exception {
        JnhwTestLogger.logBeforeAllBegin("checkBeforeAll_FcntlDefines");
        DefinesTest.testDefines(Fcntl.class, "HAVE_FCNTL_H");
        JnhwTestLogger.logBeforeAllEnd("checkBeforeAll_FcntlDefines");
    }

    @AfterAll
    public static void tearDownAfterClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterAll(testTnfo);
    }

    private Integer data = 44;
    private Optional<Integer> opt = Optional.of(data);
    private Supplier<Integer> supplier = () -> data;
    private IntSupplier intSupplier = () -> data;

    @BeforeEach
    public void setUp(TestInfo testInfo) throws Exception {
        JnhwTestLogger.logBeforeEach(testInfo);
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        JnhwTestLogger.logAfterEach(testInfo);
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
        switch (MultiarchTupelBuilder.getOS()) {
            case APPLE, FREE_BSD ->
                ErrnoTest.assertErrnoEquals(Errno.EEXIST, nee.errno);
            case LINUX -> {
                switch (MultiarchTupelBuilder.getArch()) {
                    case ARM, AARCH64, I386, S390_X ->
                        ErrnoTest.assertErrnoEquals(Errno.ENOENT, nee.errno);
                    case MIPS, MIPS_64, RISC_V_64, X86_64 ->
                        ErrnoTest.assertErrnoEquals(Errno.EEXIST, nee.errno);
                    case POWER_PC, POWER_PC_64 -> {
                        if (Errno.ENOENT == nee.errno) {
                            ErrnoTest.assertErrnoEquals(Errno.ENOENT, nee.errno);
                        } else {
                            ErrnoTest.assertErrnoEquals(Errno.EEXIST, nee.errno);
                        }
                    }
                    default ->
                        throw new RuntimeException("Dont know what to expect on errno: " + Errno.getErrnoSymbol(Errno.errno()) + " linux arch : " + MultiarchTupelBuilder.getMultiarch());
                }
            }
            default ->
                throw new RuntimeException("Dont know what to expect on errno: " + Errno.getErrnoSymbol(Errno.errno()) + " os : " + MultiarchTupelBuilder.getOS());
        }
    }

    @Test
    public void testOpen64() throws Exception {
        File file = File.createTempFile("jnhw-posix-fcntl64-test", ".txt");
        if (Defines._LARGEFILE64_SOURCE.isDefined()) {
            NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                Fcntl.open64(file.getAbsolutePath(), Fcntl.O_CREAT | Fcntl.O_EXCL, Stat.S_IRWXU | Stat.S_IRWXG);
            });
            switch (MultiarchTupelBuilder.getOS()) {
                case APPLE, FREE_BSD ->
                    ErrnoTest.assertErrnoEquals(Errno.EEXIST, nee.errno);
                case LINUX ->
                    ErrnoTest.assertErrnoEquals(Errno.EEXIST, nee.errno);
                default ->
                    throw new RuntimeException("Dont know what to expect on errno: " + Errno.getErrnoSymbol(Errno.errno()) + " os : " + MultiarchTupelBuilder.getOS());
            }
        } else {
            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                Fcntl.open64(file.getAbsolutePath(), Fcntl.O_CREAT | Fcntl.O_EXCL, Stat.S_IRWXU | Stat.S_IRWXG);
            });
        }
    }

    //Todo move this to sepetate test
    /*
rounds = 2_000_000_000
    Results:
int took: 53ms data: 2100654080
Optional<Integer> took: 54ms data: -93659136
Integer took: 55ms data: 2100654080
Supplier<Integer> took: 54ms data: 2100654080
IntSupplier took: 55ms data: 2100654080
     */
    //@Test
    public void testSpeedOfOptionalAccess() {
        final int rounds = 2_000_000_000;
        int testD = 0;
        long start;

        testD = 0;
        for (int i = 0; i < rounds; i++) {
            testD += data;
        }

        testD = 0;
        start = System.currentTimeMillis();
        for (int i = 0; i < rounds; i++) {
            testD += data;
        }
        System.out.println("int took: " + (System.currentTimeMillis() - start) + "ms data: " + testD);

        testD = 0;
        start = System.currentTimeMillis();
        for (int i = 0; i < rounds; i++) {
            testD += opt.orElseThrow(() -> new RuntimeException());
            testD += data;
        }
        System.out.println("Optional<Integer> took: " + (System.currentTimeMillis() - start) + "ms data: " + testD);

        testD = 0;
        start = System.currentTimeMillis();
        for (int i = 0; i < rounds; i++) {
            if (data != null) {
                testD += data;
            } else {
                throw new RuntimeException();
            }
        }
        System.out.println("Integer took: " + (System.currentTimeMillis() - start) + "ms data: " + testD);

        testD = 0;
        start = System.currentTimeMillis();
        for (int i = 0; i < rounds; i++) {
            testD += supplier.get();
        }
        System.out.println("Supplier<Integer> took: " + (System.currentTimeMillis() - start) + "ms data: " + testD);

        testD = 0;
        start = System.currentTimeMillis();
        for (int i = 0; i < rounds; i++) {
            testD += intSupplier.getAsInt();
        }
        System.out.println("IntSupplier took: " + (System.currentTimeMillis() - start) + "ms data: " + testD);

    }

}
