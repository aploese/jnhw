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
module de.ibapl.jnhw.common {
    requires transitive java.logging;

    requires transitive de.ibapl.jnhw.libloader;

    requires jdk.unsupported;

    exports de.ibapl.jnhw.common;
    exports de.ibapl.jnhw.common.annotation;
    exports de.ibapl.jnhw.common.callback;
    exports de.ibapl.jnhw.common.datatypes;
    exports de.ibapl.jnhw.common.exception;
    exports de.ibapl.jnhw.common.memory;
    exports de.ibapl.jnhw.common.memory.layout;
    exports de.ibapl.jnhw.common.nativecall;
    exports de.ibapl.jnhw.common.nativepointer;
    exports de.ibapl.jnhw.common.references;
    exports de.ibapl.jnhw.common.util;
}
