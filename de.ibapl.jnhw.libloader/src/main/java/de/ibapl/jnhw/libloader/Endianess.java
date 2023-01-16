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
package de.ibapl.jnhw.libloader;

/**
 * Only BIG and LITTLE are supported otherwise remove isBigEndian as a
 * shortcut...
 *
 * @author aploese
 */
public enum Endianess {
    BIG,
    LITTLE;

    /**
     * @return
     */
    public boolean isBigEndian() {
        return switch (this) {
            case BIG ->
                true;
            case LITTLE ->
                false;
            default ->
                throw new IllegalStateException("Expected only to have BIG and LITTLE but not: " + this);
        };
    }

    /**
     * @return
     */
    public boolean isLittleEndian() {
        return switch (this) {
            case BIG ->
                false;
            case LITTLE ->
                true;
            default ->
                throw new IllegalStateException("Expected only to have BIG and LITTLE but not: " + this);
        };
    }

}
