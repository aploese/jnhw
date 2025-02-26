/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2023-2025, Arne Plöse and individual contributors as indicated
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
import java.text.MessageFormat;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 */
public enum NativeProvider {
    JAVA_FOREIGN,
    JNI;

    public final static String NATIVE_PROVIDER_PROPERTY = "de.ibapl.jnhw.common.util.NativeProvider";

    private final static Logger LOGGER = Logger.getLogger("d.i.j.c.u.NativeProvider");

    public final static NativeProvider DEFAULT_PROVIDER;

    static {
        //set fallback to jni
        NativeProvider provider = JNI;
        try {
            Linker nativeLinker = Linker.nativeLinker();
            if (nativeLinker != null) {
                provider = JAVA_FOREIGN;
            }
        } catch (UnsupportedOperationException | ExceptionInInitializerError e) {
            LOGGER.log(Level.SEVERE, e, () -> {
                return MessageFormat.format("Found no java.lang.foreign.Linker for this platform: {0}", MultiarchTupelBuilder.getMultiarch());
            });
        }

        String nativeProviderProperty = System.getProperty(NATIVE_PROVIDER_PROPERTY);
        if (nativeProviderProperty == null) {
            if (provider == JAVA_FOREIGN) {
                LOGGER.log(Level.INFO, "Use platform default native provider: {0} java foreign impl: {1}", new Object[]{provider, Linker.nativeLinker()});
            } else {
                LOGGER.log(Level.INFO, "Use platform default native provider: {0}", provider);
            }
        } else {
            switch (nativeProviderProperty) {
                case "JAVA_FOREIGN" -> {
                    if (provider != JAVA_FOREIGN) {
                        String msg = "Can't set JAVA_FOREIGN as native pßrovider only JNI is available";
                        LOGGER.severe(msg);
                        throw new RuntimeException(msg);
                    } else {
                        LOGGER.log(Level.INFO, "Use JAVA_FOREIGN native provider ava foreign impl: {0}", Linker.nativeLinker());
                    }
                }
                case "JNI" -> {
                    LOGGER.info("Use JNI native provider ");
                    provider = JNI;
                }
                default -> {
                    String msg = "Unknown value \"" + nativeProviderProperty + "\" for system property: \"" + NATIVE_PROVIDER_PROPERTY + "\" values are: JAVA_FOREIGN, JNI";
                    LOGGER.severe(msg);
                    throw new RuntimeException(msg);
                }
            }
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
