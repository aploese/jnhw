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

import java.lang.ref.Cleaner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * The base class for any native chunk (i.e. pointer to or structs) of memory.
 * The run method in MemoryCleaner will clean up the allocated memory after
 * finalizing this instance - if this instance owns the memory.
 * 
 * @author aploese
 */
public class OpaqueMemory {

	private static final Cleaner cleaner = Cleaner.create();

	static class MemoryCleaner implements Runnable {

		final long baseAddress;

		MemoryCleaner(final long baseAddress) {
			this.baseAddress = baseAddress;
		}

		public void run() {
			try {
				// LOG.log(Level.FINEST, String.format("Finalize: try free memory @0x%016x size:
				// %d", baseAddress, sizeInBytes));
				free(baseAddress);
				// LOG.log(Level.FINEST, String.format("memory @0x%016x freed", baseAddress));
			} catch (Throwable t) {
				LOG.log(Level.SEVERE,
						String.format("Finalize: Memory Leak freeing memory @0x%016x failed", baseAddress), t);
			}

		}
	}

	protected final static Logger LOG = Logger.getLogger("de.ibapl.libjnhw");

	/**
	 * Make sure the native lib is loaded
	 */
	static {
		LibJnhwLoader.touch();
	}

	public final long baseAddress;
	public final int sizeInBytes;
	public final OpaqueMemory memoryOwner;

	// get value of define from errno.
	public static final native int ENOMEM();

	private static final native long malloc(int sizeInBytes) throws NativeErrorException;

	private static final native long calloc(int elements, int sizeInBytes) throws NativeErrorException;

	private static final native void free(long baseAddress);

	private static native void memset(long baseAddress, byte c, int size);

	public static final void clear(OpaqueMemory mem) {
		memset(mem.baseAddress, (byte) 0, mem.sizeInBytes);
	}

	public OpaqueMemory(int sizeInBytes, boolean clearMem) {
		this.sizeInBytes = sizeInBytes;
		try {
			if (clearMem) {
				baseAddress = calloc(1, sizeInBytes);
			} else {
				baseAddress = malloc(sizeInBytes);
			}
		} catch (NativeErrorException nee) {
			if (nee.errno == ENOMEM()) {
				throw new OutOfMemoryError("Can't allocate " + sizeInBytes + " bytes ENOMEM");
			} else {
				throw new RuntimeException("Can't allocate " + sizeInBytes + " bytes ");
			}
		}
		memoryOwner = this;
		cleaner.register(this, new MemoryCleaner(baseAddress));
	}

	public OpaqueMemory(int elements, int sizeInBytes, boolean clearMem) {
		this.sizeInBytes = sizeInBytes * elements;
		try {
			if (clearMem) {
				baseAddress = calloc(elements, sizeInBytes);
			} else {
				baseAddress = malloc(sizeInBytes * elements);
			}
		} catch (NativeErrorException nee) {
			if (nee.errno == ENOMEM()) {
				throw new OutOfMemoryError("Can't allocate " + sizeInBytes * elements + " bytes ENOMEM");
			} else {
				throw new RuntimeException("Can't allocate " + sizeInBytes * elements + " bytes ");
			}
		}
		memoryOwner = this;
		cleaner.register(this, new MemoryCleaner(baseAddress));
	}

	public OpaqueMemory(OpaqueMemory owner, long baseAddress, int sizeInBytes) {
		final long offset = baseAddress - owner.baseAddress;
		if (sizeInBytes < 0) {
			throw new IllegalArgumentException("negative size");
		}
		if (offset < 0) {
			throw new IllegalArgumentException("start outside (before) mem area");
		}
		if (offset + sizeInBytes > owner.sizeInBytes) {
			throw new IllegalArgumentException("end will be outside (after)) of owner");
		}
		this.baseAddress = baseAddress;
		this.sizeInBytes = sizeInBytes;
		memoryOwner = owner;
	}

}
