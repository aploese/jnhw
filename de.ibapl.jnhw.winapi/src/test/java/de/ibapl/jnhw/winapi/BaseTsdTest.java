/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.Callback_IJ_V;
import de.ibapl.jnhw.libloader.MultiarchInfo;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.WordSize;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import de.ibapl.jnhw.winapi.BaseTsd;
import org.junit.jupiter.api.condition.EnabledOnOs;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aploese
 */
@EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class BaseTsdTest {

    private static WordSize WORD_SIZE;

    @BeforeAll
    public static void setUpClass() {
        MultiarchInfo multiarchInfo = new MultiarchTupelBuilder().guessMultiarch().iterator().next();
        WORD_SIZE = multiarchInfo.getWordSize();
    }

    public BaseTsdTest() {
    }

    /**
     * Test of sizeofULONG_PTR.
     */
    @Test
    public void testULONG_PTR() {
        System.out.println("test ULONG_PTR");
        switch (WORD_SIZE) {
            case _32_BIT:
                assertEquals(4, BaseTsd.sizeofULONG_PTR());
                break;
            case _64_BIT:
                assertEquals(8, BaseTsd.sizeofULONG_PTR());
                break;
            default:
                throw new RuntimeException("Can't handle Wordsize " + WORD_SIZE);
        }
    }

}
