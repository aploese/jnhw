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
package de.ibapl.jnhw.winapi;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.condition.EnabledOnOs;

/**
 *
 * @author apl
 */
@EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class ErrhandlingapiTest {
    
    public ErrhandlingapiTest() {
    }
    
    /**
     * Test of GetLastError method, of class Errhandlingapi.
     */
    @Test
    public void testGetLastError() {
        System.out.println("GetLastError");
        int result = Errhandlingapi.GetLastError();
    }

    /**
     * Test of SetLastError method, of class Errhandlingapi.
     */
    @Test
    public void testSetLastError() {
        Errhandlingapi.SetLastError(Winerror.ERROR_ACCESS_DENIED());
        assertEquals(Winerror.ERROR_ACCESS_DENIED(), Errhandlingapi.GetLastError());
        Errhandlingapi.SetLastError(Winerror.ERROR_SUCCESS());
        assertEquals(Winerror.ERROR_SUCCESS(), Errhandlingapi.GetLastError());
    }

}
