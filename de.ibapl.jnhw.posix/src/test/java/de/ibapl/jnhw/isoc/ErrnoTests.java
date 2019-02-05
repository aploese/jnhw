package de.ibapl.jnhw.isoc;

import de.ibapl.jnhw.posix.Errno;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ErrnoTests  {

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
            System.err.println("HALL");
            Errno.errno(Errno.E2BIG());
            Assertions.assertEquals(Errno.E2BIG(), Errno.errno(), "Cant Set errno");
            Errno.errno(Errno.EACCES());
            Assertions.assertEquals(Errno.EACCES(), Errno.errno(), "Cant Set errno");
        }
}
