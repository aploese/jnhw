/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2021, Arne Plöse and individual contributors as indicated
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
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class JnhwFormaterTest {

    private final static MultiarchTupelBuilder MULTIARCH_TUPEL_BUILDER = new MultiarchTupelBuilder();

    public JnhwFormaterTest() {
    }

    @Test
    public void testFormatAddress() {
        switch (MULTIARCH_TUPEL_BUILDER.getWordSize()) {
            case _64_BIT:
                assertEquals("0xfedcba9876543210", JnhwFormater.formatAddress(0xfedcba9876543210L));
                break;
            case _32_BIT:
                assertEquals("0xfedcba98", JnhwFormater.formatAddress(0x00000000fedcba98L));
                assertEquals("0x(!>>>)fedcba98(<<<!)76543210", JnhwFormater.formatAddress(0xfedcba9876543210L));
                assertEquals("0x(!>>>)00000098(<<<!)76543210", JnhwFormater.formatAddress(0x0000009876543210L));
                break;
            default:
                throw new RuntimeException();
        }
    }

}
