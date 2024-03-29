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
package de.ibapl.jnhw.it.hello_world;

import de.ibapl.jnhw.common.exception.NativeErrorException;
import static de.ibapl.jnhw.winapi.Fileapi.WriteFile;
import static de.ibapl.jnhw.winapi.ProcessEnv.GetStdHandle;
import de.ibapl.jnhw.winapi.WinDef.LPDWORD;
import static de.ibapl.jnhw.winapi.Winbase.STD_OUTPUT_HANDLE;
import java.lang.foreign.Arena;

public class Windows {

    public static void sayHello() throws NativeErrorException {
        try (Arena arena = Arena.ofConfined()) {
            LPDWORD bytesWritten = LPDWORD.allocateNative(arena);
            WriteFile(GetStdHandle(STD_OUTPUT_HANDLE), "Hello World! from WIN API\n".getBytes(), bytesWritten);
            System.out.println("Bytes written: " + bytesWritten.uint32_t());
        }
    }

}
