package de.ibapl.jnhw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LibJnhwLoaderTests {
    
    @Test
    public void testLinsLoaded() throws Exception {
        Assertions.assertTrue(LibJnhwLoader.isLibJnhwLoaded());
    }

}
