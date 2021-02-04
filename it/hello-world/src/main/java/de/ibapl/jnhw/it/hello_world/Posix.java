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
package de.ibapl.jnhw.it.hello_world;

import de.ibapl.jnhw.common.exception.NativeErrorException;
//Import only the needed define from the wrapper of posix's unistd.h.h
import static de.ibapl.jnhw.posix.Unistd.STDOUT_FILENO;
//Import only the needed method from the wrapper of iso c's unistd.h.h
import static de.ibapl.jnhw.posix.Unistd.write;

public class Posix {

    public static void sayHello() throws NativeErrorException {
        int bytesWritten = write(STDOUT_FILENO, "Hello World! from POSIX\n".getBytes());
        System.out.println("Bytes written: " + bytesWritten);
    }

}
