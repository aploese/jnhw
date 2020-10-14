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
package de.ibapl.jnhw.posix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class PollTests {

    @Test
    public void testCreatePollFd() throws Exception {
        Poll.PollFds pollFds = new Poll.PollFds(2);
    }

    @Test
    public void testNPEpoll() throws Exception {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Poll.poll((Poll.PollFd) null, 1000);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Poll.poll((Poll.PollFd) null, 1000);
        });
    }

}
