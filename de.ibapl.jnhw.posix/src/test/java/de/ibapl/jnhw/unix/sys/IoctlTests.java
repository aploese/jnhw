package de.ibapl.jnhw.unix.sys;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;

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
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void noDefined_HAVE_SYS_IOCTL_H() throws Exception {
        Assertions.assertFalse(Ioctl.HAVE_SYS_IOCTL_H(), "not expected to have sys/ioctl.h");
    }

    @Test
    @DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void defined_HAVE_SYS_IOCTL_H() throws Exception {
        Assertions.assertTrue(Ioctl.HAVE_SYS_IOCTL_H(), "expected to have sys/ioctl.h");
    }

}
