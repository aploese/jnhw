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
package de.ibapl.jnhw.unix.sys;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.NativeLibResolver;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.posix.LibJnhwPosixTestLoader;
import de.ibapl.jnhw.util.posix.DefinesTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class IoctlTest {

    public static class NativeDefines {

        public final static native boolean HAVE_SYS_IOCTL_H();

        public final static native int FIONREAD();

        public final static native int TIOCCBRK();

        public final static native int TIOCEXCL();

        public final static native Integer TIOCGICOUNT();

        public final static native Integer TIOCGSOFTCAR();

        public final static native int TIOCMBIC();

        public final static native int TIOCMBIS();

        public final static native int TIOCMGET();

        public final static native Integer TIOCMIWAIT();

        public final static native int TIOCMSET();

        public final static native int TIOCM_CAR();

        public final static native int TIOCM_CD();

        public final static native int TIOCM_CTS();

        public final static native int TIOCM_DSR();

        public final static native int TIOCM_DTR();

        public final static native int TIOCM_LE();

        public final static native int TIOCM_RI();

        public final static native int TIOCM_RNG();

        public final static native int TIOCM_RTS();

        public final static native int TIOCM_SR();

        public final static native int TIOCM_ST();

        public final static native int TIOCOUTQ();

        public final static native int TIOCSBRK();

        public final static native Integer TIOCSSOFTCAR();

        public final static native Integer IOCPARM_MASK();

        public final static native Integer IOCPARM_MAX();

        public final static native Integer IOC_VOID();

        public final static native int IOC_OUT();

        public final static native int IOC_IN();

        public final static native int IOC_INOUT();

        public final static native Integer IOC_DIRMASK();

        public final static native Integer _IOC_NRBITS();

        public final static native Integer _IOC_TYPEBITS();

        public final static native Integer _IOC_SIZEBITS();

        public final static native Integer _IOC_DIRBITS();

        public final static native Integer _IOC_NRMASK();

        public final static native Integer _IOC_TYPEMASK();

        public final static native Integer _IOC_SIZEMASK();

        public final static native Integer _IOC_DIRMASK();

        public final static native Integer _IOC_NRSHIFT();

        public final static native Integer _IOC_TYPESHIFT();

        public final static native Integer _IOC_SIZESHIFT();

        public final static native Integer _IOC_DIRSHIFT();

        public final static native Integer _IOC_NONE();

        public final static native Integer _IOC_READ();

        public final static native Integer _IOC_WRITE();

        public final static native Integer IOCSIZE_MASK();

        public final static native Integer IOCSIZE_SHIFT();

        static {
            LibJnhwPosixTestLoader.touch();
        }

    }

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        LibJnhwPosixTestLoader.touch();
    }

    public final static MultiarchTupelBuilder MULTIARCHTUPEL_BUILDER = new MultiarchTupelBuilder();

    @BeforeAll
    public static void checkBeforeAll_HAVE_SYS_IOCTL_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Ioctl.HAVE_SYS_IOCTL_H, "not expected to have sys/ioctl.h");
        } else {
            Assertions.assertTrue(Ioctl.HAVE_SYS_IOCTL_H, "expected to have sys/ioctl.h");
        }
    }

    @BeforeAll
    public static void checkBeforeAll_IoctlDefines() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Ioctl.class, NativeDefines.class, "HAVE_SYS_IOCTL_H");
    }

    private native int get_IOR_int32_t(char c, int i);

    private native int get_IOW_int32_t(char c, int i);

    private native int get_IOWR_int32_t(char c, int i);

    @Test
    public void test_IOC() throws Exception {
        final int value = Ioctl._IOC(Ioctl._IOC_NONE.get(), 'U', 22, 408);
        switch (NativeLibResolver.getOS()) {
            case LINUX:
                Assertions.assertEquals(Ioctl._IOC_NONE.get(), Ioctl._IOC_DIR(value));
                Assertions.assertEquals(22, Ioctl._IOC_NR(value));
                Assertions.assertEquals(408, Ioctl._IOC_SIZE(value));
                Assertions.assertEquals('U', Ioctl._IOC_TYPE(value));
                break;
            case OPEN_BSD:
                Assertions.assertEquals(-1, Ioctl.IOCPARM_LEN(value));
                Assertions.assertEquals(-1, Ioctl.IOCGROUP(value));
                Assertions.assertEquals(-1, Ioctl.IOCBASECMD(value));
            default:
                throw new RuntimeException("Implement OS: " + NativeLibResolver.getOS());
        }
    }

    @Test
    public void test_IO() throws Exception {
        final int value = Ioctl._IO('U', 1);
        switch (NativeLibResolver.getOS()) {
            case LINUX:
                Assertions.assertEquals(Ioctl._IOC_NONE.get(), Ioctl._IOC_DIR(value));
                Assertions.assertEquals(1, Ioctl._IOC_NR(value));
                Assertions.assertEquals(0, Ioctl._IOC_SIZE(value));
                Assertions.assertEquals('U', Ioctl._IOC_TYPE(value));
                break;
            case OPEN_BSD:
                Assertions.assertEquals(-1, Ioctl.IOCPARM_LEN(value));
                Assertions.assertEquals(-1, Ioctl.IOCGROUP(value));
                Assertions.assertEquals(-1, Ioctl.IOCBASECMD(value));
            default:
                throw new RuntimeException("Implement OS: " + NativeLibResolver.getOS());
        }
    }

    @Test
    public void test_IOR() throws Exception {
        final int value = Ioctl._IOR('U', 21, BaseDataType.int32_t.SIZE_OF);
        Assertions.assertEquals(get_IOR_int32_t('U', 21), value);
        switch (NativeLibResolver.getOS()) {
            case LINUX:
                Assertions.assertEquals(Ioctl._IOC_READ.get(), Ioctl._IOC_DIR(value));
                Assertions.assertEquals(21, Ioctl._IOC_NR(value));
                Assertions.assertEquals(4, Ioctl._IOC_SIZE(value));
                Assertions.assertEquals('U', Ioctl._IOC_TYPE(value));
                break;
            case OPEN_BSD:
                Assertions.assertEquals(-1, Ioctl.IOCPARM_LEN(value));
                Assertions.assertEquals(-1, Ioctl.IOCGROUP(value));
                Assertions.assertEquals(-1, Ioctl.IOCBASECMD(value));
            default:
                throw new RuntimeException("Implement OS: " + NativeLibResolver.getOS());
        }
    }

    @Test
    public void test_IOW() throws Exception {
        final int value = Ioctl._IOW('A', 65, BaseDataType.int32_t.SIZE_OF);
        Assertions.assertEquals(get_IOW_int32_t('A', 65), value);
        switch (NativeLibResolver.getOS()) {
            case LINUX:
                Assertions.assertEquals(Ioctl._IOC_WRITE.get(), Ioctl._IOC_DIR(value));
                Assertions.assertEquals(65, Ioctl._IOC_NR(value));
                Assertions.assertEquals(4, Ioctl._IOC_SIZE(value));
                Assertions.assertEquals('A', Ioctl._IOC_TYPE(value));
                break;
            case OPEN_BSD:
                Assertions.assertEquals(-1, Ioctl.IOCPARM_LEN(value));
                Assertions.assertEquals(-1, Ioctl.IOCGROUP(value));
                Assertions.assertEquals(-1, Ioctl.IOCBASECMD(value));
            default:
                throw new RuntimeException("Implement OS: " + NativeLibResolver.getOS());
        }
    }

    @Test
    public void test_IOWR() throws Exception {
        final int value = Ioctl._IOWR('U', 7, BaseDataType.int32_t.SIZE_OF);
        Assertions.assertEquals(get_IOWR_int32_t('U', 7), value);
        switch (NativeLibResolver.getOS()) {
            case LINUX:
                Assertions.assertEquals(Ioctl._IOC_READ.get() | Ioctl._IOC_WRITE.get(), Ioctl._IOC_DIR(value));
                Assertions.assertEquals(7, Ioctl._IOC_NR(value));
                Assertions.assertEquals(4, Ioctl._IOC_SIZE(value));
                Assertions.assertEquals('U', Ioctl._IOC_TYPE(value));
                break;
            case OPEN_BSD:
                Assertions.assertEquals(-1, Ioctl.IOCPARM_LEN(value));
                Assertions.assertEquals(-1, Ioctl.IOCGROUP(value));
                Assertions.assertEquals(-1, Ioctl.IOCBASECMD(value));
            default:
                throw new RuntimeException("Implement OS: " + NativeLibResolver.getOS());
        }
    }

}
