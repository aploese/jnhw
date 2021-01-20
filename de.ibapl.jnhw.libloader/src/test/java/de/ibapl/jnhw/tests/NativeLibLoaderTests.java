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
package de.ibapl.jnhw.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.ibapl.jnhw.libloader.LoadResult;
import de.ibapl.jnhw.libloader.NativeLibResolver;

public class NativeLibLoaderTests {

    protected static void doSystemLoad(String absoluteLibName) {
        System.load(absoluteLibName);
    }

    final static String LIB_NON_EXISTANT = "non-existant";

    @Test
    public void testLoadNonExistingLib() {
        LoadResult lr = NativeLibResolver.loadNativeLib(LIB_NON_EXISTANT, 0, NativeLibLoaderTests::doSystemLoad);
        Assertions.assertFalse(lr.isLoaded());
        System.out.println(lr.loadError);
    }

}
