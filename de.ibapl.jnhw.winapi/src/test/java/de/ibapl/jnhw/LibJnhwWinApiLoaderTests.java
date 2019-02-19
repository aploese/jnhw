package de.ibapl.jnhw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LibJnhwWinApiLoaderTests {
    
    @Test
    public void testLinsLoaded() throws Exception {
        Assertions.assertTrue(LibJnhwWinApiLoader.isLibJnhwWinApiLoaded());
    }

}
