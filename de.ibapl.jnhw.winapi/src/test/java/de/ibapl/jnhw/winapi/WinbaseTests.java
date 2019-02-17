package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.LibJnhwLoader;
import de.ibapl.jnhw.OS;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

public class WinbaseTests {

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
    public void test_HAVE_WINBASE_H() throws Exception {
        if (LibJnhwLoader.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Winbase.HAVE_WINBASE_H(), "expected to have winbase.h");
        } else {
            Assertions.assertFalse(Winbase.HAVE_WINBASE_H(), "not expected to have winbase.h");
        }
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testDefines() throws Exception {
        Winbase.CLRBREAK();
        Winnt.HANDLE h = Winbase.INVALID_HANDLE_VALUE();
        Assertions.assertTrue(h.value != 0); 
    }

}
