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
module de.ibapl.jnhw.common {
    requires transitive java.logging;

    requires transitive de.ibapl.jnhw.libloader;

    exports de.ibapl.jnhw.common.annotation;
    exports de.ibapl.jnhw.common.datatypes;
    exports de.ibapl.jnhw.common.downcall;
    exports de.ibapl.jnhw.common.downcall.foreign;
    exports de.ibapl.jnhw.common.downcall.jni;
    exports de.ibapl.jnhw.common.exception;
    exports de.ibapl.jnhw.common.memory;
    exports de.ibapl.jnhw.common.memory.layout;
    exports de.ibapl.jnhw.common.nativepointer;
    exports de.ibapl.jnhw.common.upcall;
    exports de.ibapl.jnhw.common.upcall.foreign;
    exports de.ibapl.jnhw.common.upcall.jni;
    exports de.ibapl.jnhw.common.util;
}
