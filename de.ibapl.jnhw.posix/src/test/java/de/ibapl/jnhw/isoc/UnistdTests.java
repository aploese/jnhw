package de.ibapl.jnhw.isoc;

import de.ibapl.jnhw.LibJnhwLoader;
import de.ibapl.jnhw.OS;
import de.ibapl.jnhw.posix.Errno;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnistdTests {

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
    public void test_HAVE_UNISTD_H() throws Exception {
        Assertions.assertTrue(Unistd.HAVE_UNISTD_H(), "expected to have unistd.h");
    }

}
