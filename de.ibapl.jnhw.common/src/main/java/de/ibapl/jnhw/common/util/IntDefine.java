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

/**
 *
 * @author aploese
 */
public abstract class IntDefine {

    //Called from native code
    private static IntDefine toIntDefine(int value) {
        return new IntDefined(value);
    }

    public final static IntDefine UNDEFINED = new IntDefine() {

        @Override
        public boolean isDefined() {
            return false;
        }

        @Override
        public int get() {
            throw new RuntimeException("NOT Defined");
        }

        @Override
        public boolean isEqualsTo(int value) {
            return false;
        }
    };

    final static class IntDefined extends IntDefine {

        private final int value;

        private IntDefined(int value) {
            this.value = value;
        }

        @Override
        public boolean isDefined() {
            return true;
        }

        @Override
        public int get() {
            return value;
        }

        @Override
        public boolean isEqualsTo(int value) {
            return this.value == value;
        }
    }

    public abstract boolean isDefined();

    public abstract int get();

    public abstract boolean isEqualsTo(int value);

}
