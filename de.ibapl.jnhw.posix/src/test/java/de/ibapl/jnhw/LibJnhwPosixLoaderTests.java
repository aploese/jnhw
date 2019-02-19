package de.ibapl.jnhw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LibJnhwPosixLoaderTests {
    
    @Test
    public void testLinsLoaded() throws Exception {
        Assertions.assertTrue(LibJnhwPosixLoader.isLibJnhwPosixLoaded());
    }

}