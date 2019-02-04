/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ibapl.jnhw.util;

import java.nio.ByteBuffer;

/**
 *
 * @author aploese
 */
public abstract class ByteBufferUtils  {
    
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
