package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.LibJnhwLoader;
import de.ibapl.jnhw.OS;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinntTests {

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
    public void test_HAVE_WINNT_H() throws Exception {
        if (LibJnhwLoader.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Winnt.HAVE_WINNT_H(), "expected to have winnt.h");
        } else {
            Assertions.assertFalse(Winnt.HAVE_WINNT_H(), "not expected to have winnt.h");
        }
    }

}
