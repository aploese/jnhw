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
package de.ibapl.jnhw.libloader;

/**
 * The Application Binary Interface used.
 * 
 * @author aploese
 */
public enum Abi {
    /**
     * The GNU ABI
     */
    GNU("gnu"), 
    /**
     * GNU EABI Hard Floatingpoint
     */
    GNU_EABI_HF("gnueabihf"), 
    /**
     * GNU EABI Soft Floatingpoint
     */
    GNU_EABI("gnueabi"),
    /**
     * The GNU 64 bit ABI
     */
    GNU_ABI_64("gnuabi64"),
    /**
     * The BSD ABI
     */
    BSD("bsd"), 
    /**
     * Windows ABI on x86_64 (64 bit)
     */
    PE32_PLUS("pe32+"), 
    /**
     * Windows ABI on x86 or i386 (32 bit)
     * 
     */
    PE32("pe32");

    public final String abiName;

    private Abi(String abiName) {
        this.abiName = abiName;
    }

    @Override
    public String toString() {
        return abiName;
    }

}
