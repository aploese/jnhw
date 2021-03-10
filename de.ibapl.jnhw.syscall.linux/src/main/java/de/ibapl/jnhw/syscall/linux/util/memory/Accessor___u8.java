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
package de.ibapl.jnhw.syscall.linux.util.memory;

import de.ibapl.jnhw.common.memory.OpaqueMemory32;

/**
 *
 * @author aploese
 */
public interface Accessor___u8 {

    byte __u8(OpaqueMemory32 mem, long offset);

    short __u8_AsShort(OpaqueMemory32 mem, long offset);

    void __u8(OpaqueMemory32 mem, long offset, byte value);

    void __u8_FromShort(OpaqueMemory32 mem, long offset, short value);

    public byte[] __u8_Array(OpaqueMemory32 mem, long offset, int lenght);

}
