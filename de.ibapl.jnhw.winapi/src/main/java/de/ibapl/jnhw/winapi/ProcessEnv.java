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
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;

public class ProcessEnv {
	/**
	 * Make sure the native lib is loaded
	 */
	static {
		LibJnhwWinApiLoader.touch();
	}

	public final static native boolean HAVE_PROCESSENV_H();


	private static HANDLE STD_INPUT_HANDLE;
	private static HANDLE STD_OUTPUT_HANDLE;
	private static HANDLE STD_ERROR_HANDLE;

	public final static native int STD_INPUT_HANDLE();

	public final static native int STD_OUTPUT_HANDLE();

	public final static native int STD_ERROR_HANDLE();

	private static native long GetStdHandle0(int nStdHandle) throws NativeErrorException;

	public final static HANDLE GetStdHandle(int nStdHandle) throws NativeErrorException {
		if (nStdHandle == STD_INPUT_HANDLE()) {
			if (STD_INPUT_HANDLE == null) {
				STD_INPUT_HANDLE = new HANDLE(GetStdHandle0(nStdHandle));
				return STD_INPUT_HANDLE;
			}
		} else if (nStdHandle == STD_OUTPUT_HANDLE()) {
			if (STD_OUTPUT_HANDLE == null) {
				STD_OUTPUT_HANDLE = new HANDLE(GetStdHandle0(nStdHandle));
				return STD_OUTPUT_HANDLE;
			}
		} else if (nStdHandle == STD_ERROR_HANDLE()) {
			if (STD_ERROR_HANDLE == null) {
				STD_ERROR_HANDLE = new HANDLE(GetStdHandle0(nStdHandle));
				return STD_ERROR_HANDLE;
			}
		}
		return new HANDLE(GetStdHandle0(nStdHandle));
	}

}
