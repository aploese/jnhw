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
package de.ibapl.jnhw.common.test.memory.layout;

/**
 * the underlaying struct shall be defined as follows:
 * <pre>{@code
 * struct SimpleStructure {
 *  int8_t first;
 *  int16_t second;
 *  int8_t third;
 *  int32_t forth;
 *  int8_t fifth;
 *  int64_t sixth;
 *  int8_t seventh;
 *  int64_t eighth;
 * }
 * }</pre> struct SimpleStructure {
 *
 * @author aploese
 */
interface SimpeStructure {

    byte first();

    void first(byte value);

    short second();

    void second(short value);

    byte third();

    void third(byte value);

    int forth();

    void forth(int value);

    byte fifth();

    void fifth(byte value);

    long sixth();

    void sixth(long value);

    byte seventh();

    void seventh(byte value);

    long eighth();

    void eighth(long value);

}
