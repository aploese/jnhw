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

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author aploese
 */
public class OutputStreamAppender implements Appendable {

    final OutputStream os;

    public OutputStreamAppender(OutputStream os) {
        this.os = os;
    }

    @Override
    public Appendable append(CharSequence csq) throws IOException {
        if (csq instanceof String) {
            os.write(((String) csq).getBytes());
        } else {
            append(csq, 0, csq.length());
        }
        return this;
    }

    @Override
    public Appendable append(CharSequence csq, int start, int end) throws IOException {
        byte[] val = new byte[csq.length()];
        for (int i = start; i < end; i++) {
            val[i] = (byte) csq.charAt(i);
        }
        os.write(val);
        return this;
    }

    @Override
    public Appendable append(char c) throws IOException {
        os.write(c);
        return this;
    }

    public void flush() throws IOException {
        os.flush();
    }

}
