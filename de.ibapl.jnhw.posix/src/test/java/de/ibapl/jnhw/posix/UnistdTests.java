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
package de.ibapl.jnhw.posix;

import java.nio.ByteBuffer;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

import de.ibapl.jnhw.IntRef;

@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class UnistdTests {

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
    }

    byte[] writeBytes = "Hello world".getBytes();
    byte[] readBytes = new byte[1024];

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    //TODO move to isoc
    @Test
    public void testPipe() throws Exception {
        IntRef reaDFD = new IntRef();
        IntRef writeFD = new IntRef();
        Unistd.pipe(reaDFD, writeFD);
        int written = Unistd.write(writeFD.value, writeBytes);
        int read = Unistd.read(reaDFD.value, readBytes, 0, writeBytes.length);
        Assertions.assertEquals(writeBytes.length, written);
        Assertions.assertEquals(written, read);
        for (int i = 0; i < read; i++) {
            Assertions.assertEquals((char) writeBytes[i], (char) readBytes[i]);
        }
    }

    @Test
    public void testPipeWriteWrongArgs() throws Exception {
        IntRef readFD = new IntRef();
        IntRef writeFD = new IntRef();
        Assertions.assertThrows(NullPointerException.class, () -> {
            Unistd.pipe(null, writeFD);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Unistd.pipe(readFD, null);
        });
    }

    @Test
    public void testBufWriteWrongArgs() throws Exception {
        IntRef readFD = new IntRef();
        IntRef writeFD = new IntRef();

        Unistd.pipe(readFD, writeFD);

        Assertions.assertThrows(NullPointerException.class, () -> {
            Unistd.write(writeFD.value, (byte[]) null);
        });

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Unistd.write(writeFD.value, new byte[8], 1, 10);
        });

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Unistd.write(writeFD.value, new byte[8], -3, 10);
        });

    }

    @Test
    public void testBufReadWrongArgs() throws Exception {
        IntRef readFD = new IntRef();
        IntRef writeFD = new IntRef();

        Unistd.pipe(readFD, writeFD);

        Assertions.assertThrows(NullPointerException.class, () -> {
            Unistd.read(readFD.value, (byte[]) null);
        });

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Unistd.read(readFD.value, new byte[8], 1, 10);
        });

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Unistd.read(readFD.value, new byte[8], -3, 10);
        });

    }

    @Test
    public void testPipeWithHeapBuffer() throws Exception {
        IntRef reaDFD = new IntRef();
        IntRef writeFD = new IntRef();
        Unistd.pipe(reaDFD, writeFD);
        ByteBuffer writeBuffer = ByteBuffer.allocate(this.writeBytes.length);
        writeBuffer.put(writeBytes);
        writeBuffer.flip();
        writeBuffer = writeBuffer.asReadOnlyBuffer();

        ByteBuffer readBuffer = ByteBuffer.allocate(this.writeBytes.length);

        int written = Unistd.write(writeFD.value, writeBuffer);
        int read = Unistd.read(reaDFD.value, readBuffer);
        Assertions.assertEquals(written, read);

        Assertions.assertEquals(writeBytes.length, writeBuffer.position());
        Assertions.assertEquals(writeBytes.length, readBuffer.position());
        readBuffer.flip();
        readBuffer.get(readBytes, 0, writeBytes.length);

        for (int i = 0; i < read; i++) {
            Assertions.assertEquals((char) writeBytes[i], (char) readBytes[i]);
        }
    }

}
