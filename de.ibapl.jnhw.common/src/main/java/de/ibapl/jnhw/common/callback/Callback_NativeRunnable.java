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
package de.ibapl.jnhw.common.callback;

import de.ibapl.jnhw.common.LibJnhwCommonLoader;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 */
public class Callback_NativeRunnable extends NativeFunctionPointer implements NativeCallToJava {

    private final static Logger LOG = Logger.getLogger("d.i.j.c.Callback_NativeRunnable");
    /**
     * We only need one instance
     *
     */
    public static final Callback_NativeRunnable INSTANCE = new Callback_NativeRunnable();

    //TODO release globalRef on native side, if its not needed anymore ....
    private static native void initNative();

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwCommonLoader.touch();
        initNative();
    }

    private Callback_NativeRunnable() {
        super(aquire());
    }

    /**
     *
     * @return
     */
    private static NativeAddressHolder aquire() {
        return NativeAddressHolder.ofUintptr_t(aquire0());
    }

    private static native long aquire0();

}
