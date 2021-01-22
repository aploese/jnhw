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

import de.ibapl.jnhw.common.exception.NotDefinedException;

/**
 *
 * @author aploese
 */
public class Defined {

    @FunctionalInterface
    public interface IntDefineSupplier {

        /**
         * Gets a result.
         *
         * @return a result
         */
        int getAsInt() throws NotDefinedException;
    }

    @FunctionalInterface
    public interface ShortDefineSupplier {

        /**
         * Gets a result.
         *
         * @return a result
         */
        short getAsShort() throws NotDefinedException;
    }

    public static boolean defined(IntDefineSupplier definedSupplier) {
        try {
            definedSupplier.getAsInt();
            return true;
        } catch (NotDefinedException e) {
            return false;
        }
    }

    public static boolean defined(ShortDefineSupplier definedSupplier) {
        try {
            definedSupplier.getAsShort();
            return true;
        } catch (NotDefinedException e) {
            return false;
        }
    }

    public static int getValueOr(IntDefineSupplier definedSupplier, int otherwise) {
        try {
            return definedSupplier.getAsInt();
        } catch (NotDefinedException e) {
            return otherwise;
        }
    }

    public static short getValueOr(ShortDefineSupplier definedSupplier, short otherwise) {
        try {
            return definedSupplier.getAsShort();
        } catch (NotDefinedException e) {
            return otherwise;
        }
    }
}
