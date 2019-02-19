package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.LibJnhwLoader;
import de.ibapl.jnhw.NativeLibLoader;
import de.ibapl.jnhw.OS;
import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

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
        if (NativeLibLoader.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Synchapi.HAVE_SYNCHAPI_H(), "expected to have synchapi.h");
        } else {
            Assertions.assertFalse(Synchapi.HAVE_SYNCHAPI_H(), "not expected to have synchapi.h");
        }
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testWaitForSingleTimeout() throws Exception {
        final Winnt.HANDLE hEvent = Synchapi.CreateEventW(null, true, false, null);
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(5000), () -> {
            long result = Synchapi.WaitForSingleObject(hEvent, 1000);
            Assertions.assertEquals(Winbase.WAIT_TIMEOUT(), result);
            return null;
        });
        Winbase.CloseHandle(hEvent);
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testWaitForSingleSignaled() throws Exception {
        final Winnt.HANDLE hEvent = Synchapi.CreateEventW(null, true, false, null);
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(5000), () -> {
            new Thread(() -> {
                try {
                    Thread.sleep(100);
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
