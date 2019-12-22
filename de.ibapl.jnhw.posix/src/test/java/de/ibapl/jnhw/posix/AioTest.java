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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class AioTest {

    public AioTest() {
    }

    /**
     * Test of aio_cancel method, of class Aio.
     */
    @Test
    public void testAio_cancel() throws Exception {
        System.out.println("aio_cancel");
        int fildes = 0;
        Aio.Aiocb aiocbp = null;
        int expResult = 0;
        int result = Aio.aio_cancel(fildes, aiocbp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aio_error method, of class Aio.
     */
    @Test
    public void testAio_error() throws Exception {
        System.out.println("aio_error");
        Aio.Aiocb aiocb = null;
        int expResult = 0;
        int result = Aio.aio_error(aiocb);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aio_fsync method, of class Aio.
     */
    @Test
    public void testAio_fsync() throws Exception {
        System.out.println("aio_fsync");
        int op = 0;
        Aio.Aiocb aiocb = null;
        Aio.aio_fsync(op, aiocb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aio_read method, of class Aio.
     */
    @Test
    public void testAio_read() throws Exception {
        System.out.println("aio_read");
        Aio.Aiocb aiocb = null;
        Aio.aio_read(aiocb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aio_return method, of class Aio.
     */
    @Test
    public void testAio_return() throws Exception {
        System.out.println("aio_return");
        Aio.Aiocb aiocb = null;
        long expResult = 0L;
        long result = Aio.aio_return(aiocb);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aio_suspend method, of class Aio.
     */
    @Test
    public void testAio_suspend() throws Exception {
        System.out.println("aio_suspend");
        Aio.Aiocbs aiocb = null;
        int nent = 0;
        Time.Timespec timeout = null;
        Aio.aio_suspend(aiocb, nent, timeout);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aio_write method, of class Aio.
     */
    @Test
    public void testAio_write() throws Exception {
        System.out.println("aio_write");
        Aio.Aiocb aiocb = null;
        Aio.aio_write(aiocb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lio_listio method, of class Aio.
     */
    @Test
    public void testLio_listio() throws Exception {
        System.out.println("lio_listio");
        int mode = 0;
        Aio.Aiocbs list = null;
        int nent = 0;
        Signal.Sigevent sig = null;
        Aio.lio_listio(mode, list, nent, sig);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    /**
     * Test of sigaction method, of class Signal.
     */
    @Test
    public void testAiocbs() throws Exception {
        fail(" _AioAiocbs.c \n"
                + ".");
    }

}
