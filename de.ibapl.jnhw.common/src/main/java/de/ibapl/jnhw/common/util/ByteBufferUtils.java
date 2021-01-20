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
package de.ibapl.jnhw.common.util;

import java.nio.ByteBuffer;

/**
 *
 * @author aploese
 */
public abstract class ByteBufferUtils {

    public static final String UTF8_ENCODING = "UTF-8";

    public static int calcBufferWriteBytes(ByteBuffer buffer) {
        final int remaining = buffer.remaining();
        if (remaining < 0) {
            throw new IllegalArgumentException("buffer.remaining must not < 0");
        }
        return remaining;
    }

    public static int calcBufferReadBytes(ByteBuffer buffer) {
        if (buffer.isReadOnly()) {
            throw new IllegalArgumentException("Read-only buffer");
        }
        final int remaining = buffer.remaining();
        if (remaining < 0) {
            throw new IllegalArgumentException("buffer.remaining must not < 0");
        }
        return remaining;
    }

    public static long fixBufferPos(final ByteBuffer buffer, final long byteTransferred) {
        if (byteTransferred > 0) {
            buffer.position((int) (buffer.position() + byteTransferred));
        }
        return byteTransferred;
    }

}
