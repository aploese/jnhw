/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2019, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw;

import java.util.Arrays;
import java.util.logging.Logger;

public final class Defined {

    private final static Logger LOG = Logger.getLogger(Defined.class.getCanonicalName());

    public final static Defined DEFINED = new Defined();
    public final static Defined NOT_DEFINED = null;

    public final static boolean isDefined(Defined value) {
        return value == DEFINED;
    }

    public final static boolean isDefined(Byte value) {
        return value != null;
    }

    public final static boolean isDefined(byte value) {
        LOG.warning("Called  isDefined(byte) from " + Arrays.toString(new Exception().getStackTrace()));
        return true;
    }

    public final static boolean isDefined(Short value) {
        return value != null;
    }

    public final static boolean isDefined(short value) {
        LOG.warning("Called  isDefined(short) from " + Arrays.toString(new Exception().getStackTrace()));
        return true;
    }

    public final static boolean isDefined(Integer value) {
        return value != null;
    }

    public final static boolean isDefined(int value) {
        LOG.warning("Called  isDefined(int) from " + Arrays.toString(new Exception().getStackTrace()));
        return true;
    }

    public final static boolean isDefined(Long value) {
        return value != null;
    }

    public final static boolean isDefined(long value) {
        LOG.warning("Called  isDefined(long) from " + Arrays.toString(new Exception().getStackTrace()));
        return true;
    }

    public final static boolean isDefined(Float value) {
        return value != null;
    }

    public final static boolean isDefined(float value) {
        LOG.warning("Called  isDefined(float) from " + Arrays.toString(new Exception().getStackTrace()));
        return true;
    }

    public final static boolean isDefined(Double value) {
        return value != null;
    }

    public final static boolean isDefined(double value) {
        LOG.warning("Called  isDefined(double) from " + Arrays.toString(new Exception().getStackTrace()));
        return true;
    }

    private Defined() {

    }

    public String toString() {
        return "defined";
    }
}
