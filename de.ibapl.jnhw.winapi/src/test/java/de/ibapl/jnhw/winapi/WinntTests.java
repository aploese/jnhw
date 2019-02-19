package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.LibJnhwLoader;
import de.ibapl.jnhw.NativeLibLoader;
import de.ibapl.jnhw.OS;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

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
        if (NativeLibLoader.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Winnt.HAVE_WINNT_H(), "expected to have winnt.h");
        } else {
            Assertions.assertFalse(Winnt.HAVE_WINNT_H(), "not expected to have winnt.h");
        }
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testMAXDWORD() throws Exception {
        Winnt.MAXDWORD();
    }

}
