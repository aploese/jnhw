package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.LibJnhwLoader;
import de.ibapl.jnhw.OS;
import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SynchapiTests {

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
    public void test_HAVE_SYNCAPI_H() throws Exception {
        if (LibJnhwLoader.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Synchapi.HAVE_SYNCAPI_H(), "expected to have synchapi.h");
        } else {
            Assertions.assertFalse(Synchapi.HAVE_SYNCAPI_H(), "not expected to have synchapi.h");
        }
    }

    @Test
    public void testWaitForSingleTimeout() throws Exception {
        Assumptions.assumeTrue(LibJnhwLoader.getOS() == OS.WINDOWS);
        final Winnt.HANDLE hEvent = Synchapi.CreateEventW(null, true, false, null);
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(5000), () -> {
            long result = Synchapi.WaitForSingleObject(hEvent, 1000);
            Assertions.assertEquals(Winbase.WAIT_TIMEOUT(), result);
            return null;
        });
        Winbase.CloseHandle(hEvent);
    }

    @Test
    public void testWaitForSingleSignaled() throws Exception {
        Assumptions.assumeTrue(LibJnhwLoader.getOS() == OS.WINDOWS);
        final Winnt.HANDLE hEvent = Synchapi.CreateEventW(null, true, false, null);
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(5000), () -> {
            new Thread(() -> {
                try {
                    wait(100);
                    Synchapi.SetEvent(hEvent);
                } catch (InterruptedException ie) {
                    throw new RuntimeException(ie);
                }

            }).start();
            long result = Synchapi.WaitForSingleObject(hEvent, 1000);
            Assertions.assertEquals(Winbase.WAIT_OBJECT_0(), result);
            return null;
        });
        Winbase.CloseHandle(hEvent);
    }
}
