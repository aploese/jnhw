package de.ibapl.jnhw.isoc;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

@DisabledOnOs(OS.WINDOWS)
public class ErrnoTests {

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
    public void testErrno() throws Exception {
        Errno.errno(Errno.ERANGE());
        Assertions.assertEquals(Errno.ERANGE(), Errno.errno(), "Cant Set errno");
        Errno.errno(Errno.EDOM());
        Assertions.assertEquals(Errno.EDOM(), Errno.errno(), "Cant Set errno");
    }

    @Test
    public void test_HAVE_ERRNO_H() throws Exception {
        Assertions.assertTrue(Errno.HAVE_ERRNO_H(), "expected to have errno.h");
    }

}
