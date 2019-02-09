package de.ibapl.jnhw.posix;

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
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class TermiosTests {

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
    public void testNPEpoll() throws Exception {
        Assumptions.assumeFalse(LibJnhwLoader.getOS() == OS.WINDOWS);
        Assertions.assertThrows(NullPointerException.class, () -> {
            Poll.poll(null, 1000);
        });
    }
    
    @Test
    public void test_HAVE_TERMIOS_H() throws Exception {
        if (LibJnhwLoader.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Termios.HAVE_TERMIOS_H(), "not expected to have termios.h");
        } else {
            Assertions.assertTrue(Termios.HAVE_TERMIOS_H(), "expected to have termios.h");
        }
    }


}
