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
package de.ibapl.jnhw.common.util;

import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import java.lang.foreign.Linker;
import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 */
public enum NativeProvider {
    JAVA_FOREIGN,
    JNI;

    private final static Logger LOGGER = Logger.getLogger("d.i.j.c.u.NativeProvider");

    public final static NativeProvider DEFAULT_PROVIDER;

    static {
        //Fallback is jni
        NativeProvider provider = JNI;

        try {
            Linker nativeLinker = Linker.nativeLinker();
            if (nativeLinker != null) {
                provider = JAVA_FOREIGN;
            }
        } catch (UnsupportedOperationException e) {
            LOGGER.info("Found no java.lang.foreign.Linker for this platform: " + MultiarchTupelBuilder.getMultiarch());
        }
        DEFAULT_PROVIDER = provider;
    }

    public static <T> T getProvider(Supplier<T> javaForeignProvider, Supplier<T> jniProvider) {
        return switch (DEFAULT_PROVIDER) {
            case JAVA_FOREIGN ->
                javaForeignProvider.get();
            case JNI ->
                jniProvider.get();
            default ->
                throw new RuntimeException("Unknown DEFAULT_PROVIDER: " + DEFAULT_PROVIDER);
        };
    }

}
