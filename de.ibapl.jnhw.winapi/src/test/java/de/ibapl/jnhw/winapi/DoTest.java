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

import de.ibapl.jnhw.OpaqueMemory;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DoTest {


    @Test
    public void doTest_1() throws Exception {
        Assertions.assertEquals(11, Fileapi.doTest(10, 1));
    }

    @Test
    public void doTest_2() throws Exception {
        Assertions.assertEquals(11, Fileapi.doTest(null, 10, 1));
    }
    @Test
    public void doTest_3() throws Exception {
        Assertions.assertEquals(11, Fileapi.doTest(null, 10, 1, null));
    }
    @Test
    public void doTest_4() throws Exception {
        Assertions.assertEquals(11, Fileapi.doTest(null, null, 10, 1));
    }
    @Test
    public void doTest_5() throws Exception {
        Assertions.assertEquals(15, Fileapi.doTest(null, (ByteBuffer)null, 10, 3, null));
    }
    @Test
    public void doTest_6() throws Exception {
        Assertions.assertEquals(13, Fileapi.doTest(null, (OpaqueMemory)null, 10, 2, null));
    }
}
