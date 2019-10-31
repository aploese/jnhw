/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2019, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.util.posix;

import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.posix.Termios;
import java.util.function.IntSupplier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aploese
 */
public class DefinedTest {
    
    private static MultiarchTupelBuilder multiarchTupelBuilder;
    
    public DefinedTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        multiarchTupelBuilder = new MultiarchTupelBuilder();
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of __linux__ method, of class Defined.
     */
    @Test
    public void test__linux__() {
        System.out.println("__linux__");
        assertEquals(multiarchTupelBuilder.getOs() == OS.LINUX, Defined.__linux__());
    }

    /**
     * Test of __APPLE__ method, of class Defined.
     */
    @Test
    public void test__APPLE__() {
        System.out.println("__APPLE__");
        assertEquals(multiarchTupelBuilder.getOs() == OS.MAC_OS_X, Defined.__APPLE__());
    }

    /**
     * Test of __FreeBSD__ method, of class Defined.
     */
    @Test
    public void test__FreeBSD__() {
        System.out.println("__FreeBSD__");
        assertEquals(multiarchTupelBuilder.getOs() == OS.FREE_BSD, Defined.__FreeBSD__());
    }

    /**
     * Test of defined method, of class Defined.
     */
    @Test
    public void testDefined() {
        System.out.println("defined");
        assertTrue(Defined.defined(Termios::B0));
//TODO move to termios        assertFalse( Defined.defined(Termios::CMSPAR));
    }
    
}
