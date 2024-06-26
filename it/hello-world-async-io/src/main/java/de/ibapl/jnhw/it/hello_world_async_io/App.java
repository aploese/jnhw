/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2021-2024, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.it.hello_world_async_io;

import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import java.io.File;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws Exception {
        try (Arena arena = Arena.ofConfined()) {
            String STRING_TO_WRITE = "\n\t\tHello World! - AIO from POSIX\n\n";
            final MemorySegment aioBuffer = arena.allocate(STRING_TO_WRITE.length() + 1, 1);
            aioBuffer.setString(0, STRING_TO_WRITE);
            final File file = File.createTempFile("JNHW-Win-aio", "txt");

            if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
                Windows.aio(file, aioBuffer, true);
            } else {
                new Posix(true).aio(file, aioBuffer);
            }
        }
    }
}
