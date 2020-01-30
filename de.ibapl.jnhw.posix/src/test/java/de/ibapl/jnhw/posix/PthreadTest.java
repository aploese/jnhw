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

import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.ObjectRef;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class PthreadTest {

    public PthreadTest() {
    }

    @BeforeAll
    public static void setUpClass() {
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
     * Test of pthread_self method, of class Pthread.
     */
    @Test
    public void testPthread_self() {
        System.out.println("pthread_self");
        Pthread.Pthread_t result = Pthread.pthread_self();
        Assertions.assertNotNull(result);
        System.out.println("PTHREAD ID: " + result);
    }

    /**
     * Test of pthread_equal method, of class Pthread.
     */
    @Test
    public void testPthread_equal() throws Exception {
        System.out.println("pthread_equal");
        final Pthread.Pthread_t t1 = Pthread.pthread_self();
        Assertions.assertTrue(Pthread.pthread_equal(t1, Pthread.pthread_self()));

        final ObjectRef<Pthread.Pthread_t> objectRef = new ObjectRef();
        Thread t2 = new Thread(() -> {
            objectRef.value = Pthread.pthread_self();
        });
        t2.start();
        t2.join();

        Assertions.assertNotEquals(t2.toString(), objectRef.value.toString());
        boolean result = Pthread.pthread_equal(t1, objectRef.value);
        Assertions.assertFalse(result);

    }

    /**
     * Test of pthread_getcpuclockid method, of class Pthread.
     */
    @Test
    public void testPthread_getcpuclockid() throws Exception {
        System.out.println("pthread_getcpuclockid");
        IntRef clock_id = new IntRef();
        Pthread.pthread_getcpuclockid(Pthread.pthread_self(), clock_id);
        Assertions.assertNotNull(clock_id.value);
    }

    @Test
    public void testPthread_t() {
        Pthread.Pthread_t pthread_t = new Pthread.Pthread_t();
        Assertions.assertNotNull(pthread_t.toString());
    }

    @Test
    public void testPthread_attr_t() {
        Pthread.Pthread_attr_t pthread_attr_t = new Pthread.Pthread_attr_t();
    }

}
