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
package de.ibapl.jnhw.common.memory;

import de.ibapl.jnhw.common.datatypes.Native;
import de.ibapl.jnhw.common.util.JnhwFormater;
import java.io.IOException;

/**
 *
 * The base class for any chunk (i.e. pointer to or structs) of native memory.
 * The run method in MemoryCleaner will clean up the allocated memory after
 * finalizing this instance - if this instance owns the memory.
 *
 * @author aploese
 */
public abstract class OpaqueMemory32 extends AbstractNativeMemory implements Native {

    @FunctionalInterface
    public static interface OpaqueMemory32Producer<T extends OpaqueMemory32, P extends AbstractNativeMemory> {

        /**
         *
         * @param address the address to use.
         * @param parent the parent of the result with given address.
         * @return a cached or new OpaqueMemory.
         */
        T produce(NativeAddressHolder address, P parent);

    }

    public static void clear(OpaqueMemory32 mem) {
        memset(mem, (byte) 0);
    }

    public static void copy(byte[] src, int srcPos, OpaqueMemory32 dest, int destPos, int length) {
        MEM_ACCESS.copyMemory32(src, srcPos, dest, destPos, length);
    }

    public static void copy(OpaqueMemory32 src, int srcPos, byte[] dest, int destPos, int length) {
        MEM_ACCESS.copyMemory32(src, srcPos, dest, destPos, length);
    }

    public static void memset(OpaqueMemory32 mem, byte c) {
        MEM_ACCESS.setMemory32(mem, c);
    }

    public static byte getByte(OpaqueMemory32 mem, int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index < 0");
        }
        if (index >= mem.sizeInBytes) {
            throw new IndexOutOfBoundsException("index > mem.sizeInBytes");
        }
        return MEM_ACCESS.int8_t(mem, index);
    }

    public static void setByte(OpaqueMemory32 mem, int index, byte value) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index < 0");
        }
        if (index >= mem.sizeInBytes) {
            throw new IndexOutOfBoundsException("index > mem.sizeInBytes");
        }
        MEM_ACCESS.int8_t(mem, index, value);
    }

    public static byte[] toBytes(OpaqueMemory32 mem) {
        final byte[] result = new byte[mem.sizeInBytes];
        copy(mem, 0, result, 0, mem.sizeInBytes);
        return result;
    }

    public final int sizeInBytes;

    /**
     * Create a static memory slice which will NOT be freed - its static.
     *
     * @param addressHolder the base address.
     * @param sizeInBytes the size.
     */
    protected OpaqueMemory32(NativeAddressHolder addressHolder, int sizeInBytes) {
        super(addressHolder);
        this.sizeInBytes = sizeInBytes;
    }

    /**
     *
     * @param owner
     * @param offset
     * @param sizeInBytes
     */
    protected OpaqueMemory32(AbstractNativeMemory owner, long offset, int sizeInBytes, SetMem setMem) {
        super(owner, offset, sizeInBytes);
        if ((owner != null)) {
            if ((offset + sizeInBytes > owner.getSizeInBytes())) {
                throw new IndexOutOfBoundsException("end will be outside (after)) of owner");
            }
        }
        this.sizeInBytes = sizeInBytes;
        assert setMem != null;
        if (setMem == SetMem.DO_NOT_SET) {
            //no-op
        } else if (owner == null) {
            memset(this, setMem.value);
        } else if (setMem.force) {
            memset(this, setMem.value);
        } else {
            throw new IllegalArgumentException("Try to set memory which has an owner, use force if you realloy mean to set the mem.");
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (this.baseAddress ^ (this.baseAddress >>> 32));
        hash = 37 * hash + this.sizeInBytes;
        return hash;
    }

    @Override
    public boolean equals(Object obj
    ) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof OpaqueMemory64) {
            final OpaqueMemory64 other = (OpaqueMemory64) obj;
            if (this.baseAddress != other.baseAddress) {
                return false;
            }
            return this.sizeInBytes == other.sizeInBytes;
        } else if (obj instanceof OpaqueMemory32) {
            final OpaqueMemory32 other = (OpaqueMemory32) obj;
            if (this.baseAddress != other.baseAddress) {
                return false;
            }
            return this.sizeInBytes == other.sizeInBytes;
        }
        return false;
    }

    @Override
    public void nativeToString(Appendable sb, String indentPrefix,
            String indent) throws IOException {
        //Ignore indent and indentPrefix
        printMemory(sb, this, true);
    }

    @Override
    public String nativeToString() {
        StringBuilder sb = new StringBuilder();
        try {
            nativeToString(sb, "", "");
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
        return sb.toString();
    }

    public final static String printMemory(final OpaqueMemory32 mem, final boolean printAddress) {
        StringBuilder sb = new StringBuilder();
        try {
            printMemory(sb, mem, printAddress);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
        return sb.toString();
    }

    public final static void printMemory(Appendable sb, final OpaqueMemory32 mem, final boolean printAddress) throws IOException {
        StringBuilder ascii = new StringBuilder();
        final int BLOCK_SIZE = 16;
        final int BLOCK_REMINDER = mem.sizeInBytes % BLOCK_SIZE;
        assert BLOCK_REMINDER >= 0;
        final int BLOCK_COUNT = mem.sizeInBytes / BLOCK_SIZE + (BLOCK_REMINDER == 0 ? 0 : 1);
        byte[] block = new byte[BLOCK_SIZE];
        for (int i = 0; i < BLOCK_COUNT; i++) {
            int currentBlockSize;
            if ((i == BLOCK_COUNT - 1) && (BLOCK_REMINDER > 0)) {
                copy(mem, mem.sizeInBytes - BLOCK_REMINDER, block, 0, BLOCK_REMINDER);
                currentBlockSize = BLOCK_SIZE - BLOCK_REMINDER;
            } else {
                copy(mem, i * BLOCK_SIZE, block, 0, BLOCK_SIZE);
                currentBlockSize = BLOCK_SIZE;
            }
            if (printAddress) {
                sb.append(JnhwFormater.formatAddress(mem.baseAddress + BLOCK_SIZE * i)).append(": ");
            }

            for (int j = 0; j < BLOCK_SIZE; j++) {
                switch (j) {
                    case 4:
                    case 12:
                        if (j < currentBlockSize) {
                            sb.append(String.format(" %02x", block[j]));
                            if ((block[j] < 0x20) || (block[j] >= 0x7f)) {
                                //replace all control and non 7 bit ASCII chars by a single dot.
                                ascii.append('.');
                            } else {
                                ascii.append((char) block[j]);
                            }
                        } else {
                            sb.append("   ");
                        }
                        break;
                    case 8:
                        if (j < currentBlockSize) {
                            sb.append(String.format("  %02x", block[j]));
                            if ((block[j] < 0x20) || (block[j] >= 0x7f)) {
                                //replace all control and non 7 bit ASCII chars by a single dot.
                                ascii.append('.');
                            } else {
                                ascii.append((char) block[j]);
                            }
                        } else {
                            sb.append("    ");
                        }
                        break;
                    default:
                        if (j < currentBlockSize) {
                            sb.append(String.format("%02x", block[j]));
                            if ((block[j] < 0x20) || (block[j] >= 0x7f)) {
                                //replace all control and non 7 bit ASCII chars by a single dot.
                                ascii.append('.');
                            } else {
                                ascii.append((char) block[j]);
                            }
                        } else {
                            sb.append("  ");
                        }
                }
            }
            sb.append(" | ");
            sb.append(ascii);
            if (i != BLOCK_COUNT - 1) {
                ascii.delete(0, ascii.length());
                sb.append('\n');
            }
        }
    }

    @Override
    final public String toString() {
        return String.format("{baseAddress : %s, sizeInBytes : %d, memoryOwner : %s}", JnhwFormater.formatAddress(baseAddress), sizeInBytes, parent == this ? "this" : parent);
    }

    @Override
    protected final long getSizeInBytes() {
        return sizeInBytes;
    }

}
