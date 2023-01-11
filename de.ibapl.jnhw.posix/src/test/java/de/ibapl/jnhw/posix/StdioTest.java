/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.util.posix.DefinesTest;
import java.io.File;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

/**
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class StdioTest {

    @BeforeAll
    public static void checkBeforeAll_HAVE_STDIO_H() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Stdio.HAVE_STDIO_H, "not expected to have stdio.h");
        } else {
            Assertions.assertTrue(Stdio.HAVE_STDIO_H, "expected to have stdio.h");
        }
    }

    @BeforeAll
    public static void checkBeforeAll_StdioDefines() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Stdio.class, "HAVE_STDIO_H");
    }

    /**
     * Test of remove method, of class Stdio.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        File f = File.createTempFile("jnhw-test", "");
        f.deleteOnExit();
        assertTrue(f.exists());
        Stdio.remove(f.getAbsolutePath());
        assertFalse(f.exists());
    }

}
