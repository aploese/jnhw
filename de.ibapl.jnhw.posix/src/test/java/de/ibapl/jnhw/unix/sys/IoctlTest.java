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
package de.ibapl.jnhw.unix.sys;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.posix.LibJnhwPosixTestLoader;
import de.ibapl.jnhw.util.posix.DefinesTest;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class IoctlTest {

    static {
        LibJnhwPosixTestLoader.touch();
    }

    @BeforeAll
    public static void checkBeforeAll_HAVE_SYS_IOCTL_H() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Ioctl.HAVE_SYS_IOCTL_H, "not expected to have sys/ioctl.h");
        } else {
            Assertions.assertTrue(Ioctl.HAVE_SYS_IOCTL_H, "expected to have sys/ioctl.h");
        }
    }

    @BeforeAll
    public static void checkBeforeAll_IoctlDefines() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Ioctl.class, "HAVE_SYS_IOCTL_H");
    }

    private MemorySession ms;

    @BeforeEach
    public void setUp() throws Exception {
        ms = MemorySession.openConfined();
    }

    @AfterEach
    public void tearDown() throws Exception {
        ms.close();
    }

    @Test
    public void test_IOC() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX:
                final int linuxValue = Ioctl._IOC(Ioctl._IOC_NONE.get(), 'U', 22, 408);
                Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI__sI_sB_sI_sI("get_IOC", Ioctl._IOC_NONE.get(), (byte) 'U', 22, 408), linuxValue);
                Assertions.assertEquals(22, Ioctl._IOC_NR(linuxValue));
                Assertions.assertEquals(408, Ioctl._IOC_SIZE(linuxValue));
                Assertions.assertEquals('U', Ioctl._IOC_TYPE(linuxValue));
                break;
            case DARWIN:
            case FREE_BSD:
            case OPEN_BSD:
                final int bsdValue = Ioctl._IOC(Ioctl.IOC_VOID.get(), 'U', 22, 408);
                Assertions.assertEquals(408, Ioctl.IOCPARM_LEN(bsdValue));
                Assertions.assertEquals('U', Ioctl.IOCGROUP(bsdValue));
                Assertions.assertEquals(536892694, Ioctl.IOCBASECMD(bsdValue));
                break;
            default:
                throw new RuntimeException("Implement OS: " + MultiarchTupelBuilder.getOS());
        }
    }

    @Test
    public void test_IO() throws Exception {
        final int value = Ioctl._IO('U', 1);
        Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI__sB_sI("get_IO", (byte) 'U', 1), value);
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX:
                Assertions.assertEquals(Ioctl._IOC_NONE.get(), Ioctl._IOC_DIR(value));
                Assertions.assertEquals(1, Ioctl._IOC_NR(value));
                Assertions.assertEquals(0, Ioctl._IOC_SIZE(value));
                Assertions.assertEquals('U', Ioctl._IOC_TYPE(value));
                break;
            case DARWIN:
            case FREE_BSD:
            case OPEN_BSD:
                Assertions.assertEquals(0, Ioctl.IOCPARM_LEN(value));
                Assertions.assertEquals('U', Ioctl.IOCGROUP(value));
                Assertions.assertEquals(536892673, Ioctl.IOCBASECMD(value));
                break;
            default:
                throw new RuntimeException("Implement OS: " + MultiarchTupelBuilder.getOS());
        }
    }

    @Test
    public void test_IOR() throws Exception {
        final int value = Ioctl._IOR('U', 21, BaseDataType.int32_t.SIZE_OF);
        Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI__sB_sI("get_IOR_int32_t", (byte) 'U', 21), value);
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX:
                Assertions.assertEquals(Ioctl._IOC_READ.get(), Ioctl._IOC_DIR(value));
                Assertions.assertEquals(21, Ioctl._IOC_NR(value));
                Assertions.assertEquals(BaseDataType.int32_t.SIZE_OF, Ioctl._IOC_SIZE(value));
                Assertions.assertEquals('U', Ioctl._IOC_TYPE(value));
                break;
            case DARWIN:
            case FREE_BSD:
            case OPEN_BSD:
                Assertions.assertEquals(BaseDataType.int32_t.SIZE_OF, Ioctl.IOCPARM_LEN(value));
                Assertions.assertEquals('U', Ioctl.IOCGROUP(value));
                Assertions.assertEquals(1073763605, Ioctl.IOCBASECMD(value));
                break;
            default:
                throw new RuntimeException("Implement OS: " + MultiarchTupelBuilder.getOS());
        }
    }

    @Test
    public void test_IOW() throws Exception {
        final int value = Ioctl._IOW('A', 65, BaseDataType.int32_t.SIZE_OF);
        Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI__sB_sI("get_IOW_int32_t", (byte) 'A', 65), value);
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX:
                Assertions.assertEquals(Ioctl._IOC_WRITE.get(), Ioctl._IOC_DIR(value));
                Assertions.assertEquals(65, Ioctl._IOC_NR(value));
                Assertions.assertEquals(BaseDataType.int32_t.SIZE_OF, Ioctl._IOC_SIZE(value));
                Assertions.assertEquals('A', Ioctl._IOC_TYPE(value));
                break;
            case DARWIN:
            case FREE_BSD:
            case OPEN_BSD:
                Assertions.assertEquals(BaseDataType.int32_t.SIZE_OF, Ioctl.IOCPARM_LEN(value));
                Assertions.assertEquals('A', Ioctl.IOCGROUP(value));
                Assertions.assertEquals(-2147466943, Ioctl.IOCBASECMD(value));
                break;
            default:
                throw new RuntimeException("Implement OS: " + MultiarchTupelBuilder.getOS());
        }
    }

    @Test
    public void test_IOWR() throws Exception {
        final int value = Ioctl._IOWR('U', 7, BaseDataType.int32_t.SIZE_OF);
        Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI__sB_sI("get_IOWR_int32_t", (byte) 'U', 7), value);
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX:
                Assertions.assertEquals(Ioctl._IOC_READ.get() | Ioctl._IOC_WRITE.get(), Ioctl._IOC_DIR(value));
                Assertions.assertEquals(7, Ioctl._IOC_NR(value));
                Assertions.assertEquals(BaseDataType.int32_t.SIZE_OF, Ioctl._IOC_SIZE(value));
                Assertions.assertEquals('U', Ioctl._IOC_TYPE(value));
                break;
            case DARWIN:
            case FREE_BSD:
            case OPEN_BSD:
                Assertions.assertEquals(BaseDataType.int32_t.SIZE_OF, Ioctl.IOCPARM_LEN(value));
                Assertions.assertEquals('U', Ioctl.IOCGROUP(value));
                Assertions.assertEquals(-1073720057, Ioctl.IOCBASECMD(value));
                break;
            default:
                throw new RuntimeException("Implement OS: " + MultiarchTupelBuilder.getOS());
        }
    }

    @Test
    public void test_IOC_DIR() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX:
                final int arg = 1;
                final Int32_t resultArg = Int32_t.allocateNative(ms);
                MemoryAddress result = LibJnhwPosixTestLoader.invoke_MA___A_sI("tryGet_IOC_DIR", resultArg.toAddressable(), arg);
                Assertions.assertNotEquals(MemoryAddress.NULL, result);
                Assertions.assertEquals(resultArg.int32_t(), Ioctl._IOC_DIR(arg));
                break;
            default:
                throw new RuntimeException("Implement OS: " + MultiarchTupelBuilder.getOS());
        }
    }

    @Test
    public void test_IOC_NR() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX:
                final int arg = 1;
                final Int32_t resultArg = Int32_t.allocateNative(ms);
                MemoryAddress result = LibJnhwPosixTestLoader.invoke_MA___A_sI("tryGet_IOC_NR", resultArg.toAddressable(), arg);
                Assertions.assertNotEquals(MemoryAddress.NULL, result);
                Assertions.assertEquals(resultArg.int32_t(), Ioctl._IOC_NR(arg));
                break;
            default:
                throw new RuntimeException("Implement OS: " + MultiarchTupelBuilder.getOS());
        }
    }

    @Test
    public void test_IOC_SIZE() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX:
                final int arg = 1;
                final Int32_t resultArg = Int32_t.allocateNative(ms);
                MemoryAddress result = LibJnhwPosixTestLoader.invoke_MA___A_sI("tryGet_IOC_SIZE", resultArg.toAddressable(), arg);
                Assertions.assertNotEquals(MemoryAddress.NULL, result);
                Assertions.assertEquals(resultArg.int32_t(), Ioctl._IOC_SIZE(arg));
                break;
            default:
                throw new RuntimeException("Implement OS: " + MultiarchTupelBuilder.getOS());
        }
    }

    @Test
    public void test_IOC_TYPE() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX:
                final int arg = 1;
                final Int32_t resultArg = Int32_t.allocateNative(ms);
                MemoryAddress result = LibJnhwPosixTestLoader.invoke_MA___A_sI("tryGet_IOC_TYPE", resultArg.toAddressable(), arg);
                Assertions.assertNotEquals(MemoryAddress.NULL, result);
                Assertions.assertEquals(resultArg.int32_t(), Ioctl._IOC_TYPE(arg));
                break;
            default:
                throw new RuntimeException("Implement OS: " + MultiarchTupelBuilder.getOS());
        }
    }

    @Test
    public void test_IOCPARM_LEN() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX:
                final Int32_t resultArg = Int32_t.allocateNative(ms);
                MemoryAddress result = LibJnhwPosixTestLoader.invoke_MA___A_sI("tryGet_IOCPARM_LEN", resultArg.toAddressable(), 1);
                Assertions.assertEquals(MemoryAddress.NULL, result);
                Assertions.assertThrows(NoSuchMethodException.class, () -> {
                    Ioctl.IOCPARM_LEN(1);
                });
                break;
            default:
                throw new RuntimeException("Implement OS: " + MultiarchTupelBuilder.getOS());
        }
    }

    @Test
    public void test_IOCBASECMD() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX:
                final Int32_t resultArg = Int32_t.allocateNative(ms);
                MemoryAddress result = LibJnhwPosixTestLoader.invoke_MA___A_sI("tryGet_IOCBASECMD", resultArg.toAddressable(), 1);
                Assertions.assertEquals(MemoryAddress.NULL, result);
                Assertions.assertThrows(NoSuchMethodException.class, () -> {
                    Ioctl.IOCBASECMD(1);
                });
                break;
            default:
                throw new RuntimeException("Implement OS: " + MultiarchTupelBuilder.getOS());
        }
    }

    @Test
    public void test_IOCGROUP() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX:
                final Int32_t resultArg = Int32_t.allocateNative(ms);
                MemoryAddress result = LibJnhwPosixTestLoader.invoke_MA___A_sI("tryGet_IOCGROUP", resultArg.toAddressable(), 1);
                Assertions.assertEquals(MemoryAddress.NULL, result);
                Assertions.assertThrows(NoSuchMethodException.class, () -> {
                    Ioctl.IOCGROUP(1);
                });
                break;
            default:
                throw new RuntimeException("Implement OS: " + MultiarchTupelBuilder.getOS());
        }
    }

}
