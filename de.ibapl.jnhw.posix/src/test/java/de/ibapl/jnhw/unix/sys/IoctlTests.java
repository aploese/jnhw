package de.ibapl.jnhw.unix.sys;

import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.LibJnhwLoader;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.OS;
import de.ibapl.jnhw.isoc.Errno;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IoctlTests {

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void test_HAVE_SYS_IOCTL_H() throws Exception {
        if (LibJnhwLoader.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Ioctl.HAVE_SYS_IOCTL_H(), "not expected to have sys/ioctl.h");
        } else {
            Assertions.assertTrue(Ioctl.HAVE_SYS_IOCTL_H(), "expected to have sys/ioctl.h");
        }
    }


}
