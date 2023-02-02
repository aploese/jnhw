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
package de.ibapl.jnhw.common.test;

import de.ibapl.jnhw.common.util.JnhwFormater;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import java.lang.foreign.MemorySegment;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 *
 * @author aploese
 */
public class JnhwFormaterTest {

    @BeforeAll
    public static void setUpBeforeClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeAll(testTnfo);
    }

    @AfterAll
    public static void tearDownAfterClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterAll(testTnfo);
    }

    public JnhwFormaterTest() {
    }

    @BeforeEach
    public void setUpBeforeEach(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeEach(testTnfo);
    }

    @AfterEach
    public void tearDownAfterEach(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterEach(testTnfo);
    }

    @Test
    public void testFormatAddress() {
        switch (MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer) {
            case _64_BIT ->
                assertEquals("0xfedcba9876543210", JnhwFormater.formatAddress(MemorySegment.ofAddress(0xfedcba9876543210L)));
            case _32_BIT -> {
                assertEquals("0xfedcba98", JnhwFormater.formatAddress(MemorySegment.ofAddress(0x00000000fedcba98L)));
                assertEquals("0x(!>>>)fedcba98(<<<!)76543210", JnhwFormater.formatAddress(MemorySegment.ofAddress(0xfedcba9876543210L)));
                assertEquals("0x(!>>>)00000098(<<<!)76543210", JnhwFormater.formatAddress(MemorySegment.ofAddress(0x0000009876543210L)));
            }
            default ->
                throw new RuntimeException();
        }
    }

}
