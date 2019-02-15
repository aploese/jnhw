package de.ibapl.jnhw.posix;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import de.ibapl.jnhw.LibJnhwLoader;

    @DisabledOnOs(OS.WINDOWS)
public class FcntlTests {

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
    public void test_HAVE_FCNTL_H() throws Exception {
        if (LibJnhwLoader.getOS() == de.ibapl.jnhw.OS.WINDOWS) {
        	Assertions.assertFalse(Fcntl.HAVE_FCNTL_H(), "expected not to have fcntl.h");
        } else {
        	Assertions.assertTrue(Fcntl.HAVE_FCNTL_H(), "expected to have fcntl.h");
        }
    }

}
