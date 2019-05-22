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

/**
 * This exceptions is thrown if the jni native code detects an error. The error
 * number POSIX|ISO C call errno and Windows API call GetLastError() will be
 * stored in errno.
 * The value of errno is valid only if a called function sets the errno and flags the occurence of an error.
 * Once the call returns to the JVM the value of errno is uncertain, so this must be handled immediately after the call to that function. 
 * 
 * @author aploese
 */
public class NativeErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4007403267388096526L;
	public final int errno;

	public NativeErrorException(int errno) {
		super("Native error: " + errno);
		this.errno = errno;
	}

}
