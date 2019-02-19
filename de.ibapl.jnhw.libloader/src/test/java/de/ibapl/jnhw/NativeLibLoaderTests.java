package de.ibapl.jnhw;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NativeLibLoaderTests {
    
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

    final static String LIB_NON_EXISTANT = "non-existant";
    @Test
    public void testLoadNonExistingLib() throws Exception {
        NativeLibLoader.loadNativeLib(LIB_NON_EXISTANT, 0);
        Assertions.assertFalse(NativeLibLoader.isLibLoaded(LIB_NON_EXISTANT));
        Assertions.assertTrue(NativeLibLoader.hasLoadError(LIB_NON_EXISTANT));
        Throwable t = NativeLibLoader.getLoadError(LIB_NON_EXISTANT);
    }

    @Test
    public void testClear() throws Exception {
        NativeLibLoader.getOS();
    }

}
