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
package de.ibapl.jnhw.util.winapi.memory;

import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.memory.layout.StructLayoutFactory;
import de.ibapl.jnhw.common.memory.layout.StructLayoutFactoryImpl;

/**
 *
 * @author aploese
 */
public class WinApiStdStructLayoutFactory extends StructLayoutFactoryImpl {

    public WinApiStdStructLayoutFactory(Type type) {
        super(type);
    }

    public WinApiStdStructLayoutFactory(Type type, Alignment alignment) {
        super(type, alignment);
    }

    public long BOOL() {
        return int32_t();
    }

    public long BYTE() {
        return uint8_t();
    }

    public long DWORD() {
        return uint32_t();
    }

    public long HANDLE() {
        return uintptr_t();
    }

    public long PVOID() {
        return uintptr_t();
    }

    public long ULONG_PTR() {
        return uintptr_t();
    }

    public long WORD() {
        return uint16_t();
    }

}
