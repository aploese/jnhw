/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.annotation.posix.sys.types.off_t;
import de.ibapl.jnhw.annotation.posix.sys.types.size_t;
import de.ibapl.jnhw.annotation.posix.sys.types.ssize_t;
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.datatypes.MultiarchTupelBuilder;
import de.ibapl.jnhw.common.datatypes.Pointer;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI___A;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI___A_sI__A;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI__sI__A;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI__sI__A_sI__A;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sL___A;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeException;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.memory.PointerArray;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.util.IntDefine;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import de.ibapl.jnhw.posix.Signal.Sigevent;
import de.ibapl.jnhw.posix.Time.Timespec;
import de.ibapl.jnhw.util.posix.LibrtLoader;
import de.ibapl.jnhw.util.posix.PosixDataType;
import de.ibapl.jnhw.util.posix.memory.PosixStruct;
import java.io.IOException;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.nio.ByteBuffer;

/**
 * Wrapper around the {@code <aio.h>} header.
 *
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">aio.h
 * - asynchronous input and output</a>.
 *
 * @author aploese
 */
@Include("#include <aio.h>")
public class Aio {

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
     * aiocb}</a>.
     *
     */
    public static final class Aiocb<T extends OpaqueMemory> extends PosixStruct {

        public final static Alignment alignof;
        public final static long offsetof_Aio_buf;
        public final static long offsetof_Aio_fildes;
        public final static long offsetof_Aio_lio_opcode;
        public final static long offsetof_Aio_nbytes;
        public final static long offsetof_Aio_offset;
        public final static long offsetof_Aio_reqprio;
        public final static long offsetof_Aio_sigevent;
        public final static int sizeof;

        static {
            switch (MultiarchTupelBuilder.getOS()) {
                case LINUX:
                    switch (MultiarchTupelBuilder.getMemoryModel()) {
                        case ILP32:
                            offsetof_Aio_fildes = 0;
                            offsetof_Aio_offset = 104;
                            offsetof_Aio_buf = 12;
                            offsetof_Aio_nbytes = 16;
                            offsetof_Aio_reqprio = 8;
                            offsetof_Aio_sigevent = 20;
                            offsetof_Aio_lio_opcode = 4;
                            alignof = Alignment.AT_4;
                            sizeof = 144;
                            break;
                        case LP64:
                            offsetof_Aio_fildes = 0;
                            offsetof_Aio_offset = 128;
                            offsetof_Aio_buf = 16;
                            offsetof_Aio_nbytes = 24;
                            offsetof_Aio_reqprio = 8;
                            offsetof_Aio_sigevent = 32;
                            offsetof_Aio_lio_opcode = 4;
                            alignof = Alignment.AT_8;
                            sizeof = 168;
                            break;
                        default:
                            throw new NoClassDefFoundError("No aio.h defines for " + MultiarchTupelBuilder.getMultiarch());
                    }
                    break;
                case DARWIN:
                    offsetof_Aio_fildes = 0;
                    offsetof_Aio_offset = 8;
                    offsetof_Aio_buf = 16;
                    offsetof_Aio_nbytes = 24;
                    offsetof_Aio_reqprio = 32;
                    offsetof_Aio_sigevent = 40;
                    offsetof_Aio_lio_opcode = 72;
                    alignof = Alignment.AT_8;
                    sizeof = 80;
                    break;
                case FREE_BSD:
                    offsetof_Aio_fildes = 0;
                    offsetof_Aio_offset = 8;
                    offsetof_Aio_buf = 16;
                    offsetof_Aio_nbytes = 24;
                    offsetof_Aio_reqprio = 52;
                    offsetof_Aio_sigevent = 80;
                    offsetof_Aio_lio_opcode = 48;
                    alignof = Alignment.AT_8;
                    sizeof = 160;
                    break;
                case OPEN_BSD:
                    offsetof_Aio_fildes = -1;
                    offsetof_Aio_offset = -1;
                    offsetof_Aio_buf = -1;
                    offsetof_Aio_nbytes = -1;
                    offsetof_Aio_reqprio = -1;
                    offsetof_Aio_sigevent = -1;
                    offsetof_Aio_lio_opcode = -1;
                    alignof = null;
                    sizeof = 0;
                    break;
                default:
                    throw new NoClassDefFoundError("No aio.h OS defines for " + MultiarchTupelBuilder.getMultiarch());
            }
        }

        private Object aio_buf;
        /**
         * The signal number and value.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         */
        public final Sigevent<T> aio_sigevent;

        public static Aiocb tryAllocateNative(MemorySession ms) throws NoSuchNativeTypeException {
            if (alignof == null) {
                throw new NoSuchNativeTypeException("aiocb");
            }
            return new Aiocb(MemorySegment.allocateNative(sizeof, ms), 0);
        }

        /**
         * TODO set ByteBuffer ???
         *
         * @param address
         */
        public static Aiocb tryOfAddress(MemoryAddress address, MemorySession ms) throws NoSuchNativeTypeException {
            if (alignof == null) {
                throw new NoSuchNativeTypeException("aiocb");
            }
            return new Aiocb(MemorySegment.ofAddress(address, sizeof, ms), 0);
        }

        public Aiocb(MemorySegment memorySegment, long offset) throws NoSuchNativeTypeException {
            super(memorySegment, offset, sizeof);
            if (alignof == null) {
                throw new NoSuchNativeTypeException("aiocb");
            }
            aio_sigevent = new Sigevent(this.memorySegment, Aiocb.offsetof_Aio_sigevent);
        }

        /**
         * The location of buffer.<b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb} </a>.
         *
         * @return the native value of aio_buf.
         */
        public MemoryAddress aio_buf() {
            return MEM_ACCESS.uintptr_t(memorySegment, Aiocb.offsetof_Aio_buf);
        }

        /**
         * The location of buffer.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * aio_nbytes will also be set
         *
         * @param aio_buf the value of aio_buf to be set natively.
         */
        public void aio_buf(ByteBuffer aio_buf) {
            if (aio_buf == null) {
                MEM_ACCESS.uintptr_t(memorySegment, Aiocb.offsetof_Aio_buf, MemoryAddress.NULL);
                ACCESSOR_SIZE_T.size_t(memorySegment, Aiocb.offsetof_Aio_nbytes, 0);
            } else {
                MEM_ACCESS.uintptr_t(memorySegment, Aiocb.offsetof_Aio_buf, aio_buf);
                ACCESSOR_SIZE_T.size_t(memorySegment, Aiocb.offsetof_Aio_nbytes, aio_buf.remaining());
            }
            this.aio_buf = aio_buf;
        }

        /**
         * The location of buffer.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * aio_nbytes will also be set
         *
         * @param aio_buf the value of aio_buf to be set natively.
         */
        public void aio_buf(OpaqueMemory aio_buf) {
            if (aio_buf == null) {
                MEM_ACCESS.uintptr_t(memorySegment, Aiocb.offsetof_Aio_buf, MemoryAddress.NULL);
                ACCESSOR_SIZE_T.size_t(memorySegment, Aiocb.offsetof_Aio_nbytes, 0);
            } else {
                MEM_ACCESS.uintptr_t(memorySegment, Aiocb.offsetof_Aio_buf, OpaqueMemory.getMemorySegment(aio_buf));
                ACCESSOR_SIZE_T.size_t(memorySegment, Aiocb.offsetof_Aio_nbytes, aio_buf.sizeof());
            }
            this.aio_buf = aio_buf;
        }

        /**
         * The location of buffer.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * aio_nbytes will also be set
         *
         * @param aio_buf the value of aio_buf to be set natively.
         */
        public void aio_buf(MemorySegment aio_buf) {
            if (aio_buf == null) {
                MEM_ACCESS.uintptr_t(memorySegment, Aiocb.offsetof_Aio_buf, MemoryAddress.NULL);
                ACCESSOR_SIZE_T.size_t(memorySegment, Aiocb.offsetof_Aio_nbytes, 0);
            } else {
                MEM_ACCESS.uintptr_t(memorySegment, Aiocb.offsetof_Aio_buf, aio_buf);
                ACCESSOR_SIZE_T.size_t(memorySegment, Aiocb.offsetof_Aio_nbytes, aio_buf.byteSize());
            }
            this.aio_buf = aio_buf;
        }

        /**
         * The location of buffer.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * aio_nbytes will also be set
         *
         * @throws ArrayIndexOutOfBoundsException if {@code off} or
         * {@code aio_nbytes} out of bounds.
         *
         *
         * @param aio_buf the value of aio_buf to be set natively.
         */
        public void aio_buf(OpaqueMemory aio_buf, int off, @size_t int aio_nbytes) {
            if (aio_buf == null) {
                if (off != 0) {
                    throw new IllegalArgumentException("off must be 0");
                }
                if (aio_nbytes != 0) {
                    throw new IllegalArgumentException("aio_nbytes must be 0");
                }
                MEM_ACCESS.uintptr_t(memorySegment, Aiocb.offsetof_Aio_buf, MemoryAddress.NULL);
                ACCESSOR_SIZE_T.size_t(memorySegment, Aiocb.offsetof_Aio_nbytes, 0);
            } else {
                if ((off < 0) || (off >= aio_buf.sizeof())) {
                    throw new IllegalArgumentException("off not in range");
                }
                if ((aio_nbytes < 0) || (aio_nbytes + off >= aio_buf.sizeof())) {
                    throw new IllegalArgumentException("aio_nbytes not in range");
                }
                //Todo add off ???
                MEM_ACCESS.uintptr_t(memorySegment, Aiocb.offsetof_Aio_buf, OpaqueMemory.getMemorySegment(aio_buf).asSlice(off, aio_nbytes));
                ACCESSOR_SIZE_T.size_t(memorySegment, Aiocb.offsetof_Aio_nbytes, aio_nbytes);
            }
            this.aio_buf = aio_buf;
        }

        /**
         * The location of buffer.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * aio_nbytes will also be set
         *
         * @throws ArrayIndexOutOfBoundsException if {@code off} or
         * {@code aio_nbytes} out of bounds.
         *
         *
         * @param aio_buf the value of aio_buf to be set natively.
         */
        public void aio_buf(MemorySegment aio_buf, long off, @size_t long aio_nbytes) {
            if (aio_buf == null) {
                if (off != 0) {
                    throw new IllegalArgumentException("off must be 0");
                }
                if (aio_nbytes != 0) {
                    throw new IllegalArgumentException("aio_nbytes must be 0");
                }
                MEM_ACCESS.uintptr_t(memorySegment, Aiocb.offsetof_Aio_buf, MemoryAddress.NULL);
                ACCESSOR_SIZE_T.size_t(memorySegment, Aiocb.offsetof_Aio_nbytes, 0);
            } else {
                if ((off < 0) || (off >= aio_buf.byteSize())) {
                    throw new IllegalArgumentException("off not in range");
                }
                if ((aio_nbytes < 0) || (aio_nbytes + off >= aio_buf.byteSize())) {
                    throw new IllegalArgumentException("aio_nbytes not in range");
                }
                //Todo add off ???
                MEM_ACCESS.uintptr_t(memorySegment, Aiocb.offsetof_Aio_buf, aio_buf.asSlice(off, aio_nbytes));
                ACCESSOR_SIZE_T.size_t(memorySegment, Aiocb.offsetof_Aio_nbytes, aio_nbytes);
            }
            this.aio_buf = aio_buf;
        }

        /**
         * The location of buffer.<b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb} </a>.
         *
         * @return the native value of aio_buf.
         */
        public ByteBuffer aio_bufAsByteBuffer() {
            final MemoryAddress result = aio_buf();
            if (aio_buf == null) {
                if (MemoryAddress.NULL.equals(result)) {
                    return null;
                } else {
                    throw new RuntimeException("aio_buf_ expected to be NULL, but was " + result.toString());
                }
            } else if (aio_buf instanceof ByteBuffer) {
                //TODO result inside of allocated memory?
                return (ByteBuffer) aio_buf;
            } else {
                throw new RuntimeException("Actual class of aio_buf\"" + aio_buf.getClass() + "\" is not ByteBuffer");
            }
        }

        /**
         * The location of buffer.<b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb} </a>.
         *
         * @return the native value of aio_buf.
         */
        public OpaqueMemory aio_bufAsOpaqueMemory() {
            final MemoryAddress result = aio_buf();
            if (aio_buf == null) {
                if (MemoryAddress.NULL.equals(result)) {
                    return null;
                } else {
                    throw new RuntimeException("aio_buf_ expected to be NULL, but was " + result.toString());
                }
            } else if (aio_buf instanceof OpaqueMemory) {
                //TODO result inside of allocated memory?
                return (OpaqueMemory) aio_buf;
            } else {
                throw new RuntimeException("Actual class of aio_buf\"" + aio_buf.getClass() + "\" is not OpaqueMemory");
            }
        }

        /**
         * The location of buffer.<b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb} </a>.
         *
         * @return the native value of aio_buf.
         */
        public MemorySegment aio_bufAsMemorySegment() {
            final MemoryAddress result = aio_buf();
            if (aio_buf == null) {
                if (MemoryAddress.NULL.equals(result)) {
                    return null;
                } else {
                    throw new RuntimeException("aio_buf_ expected to be NULL, but was " + result.toString());
                }
            } else if (aio_buf instanceof MemorySegment) {
                //TODO result inside of allocated memory?
                return (MemorySegment) aio_buf;
            } else {
                throw new RuntimeException("Actual class of aio_buf\"" + aio_buf.getClass() + "\" is not MemorySegment");
            }
        }

        /**
         * The file descriptor.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * @return the native value of aio_fildes.
         */
        public int aio_fildes() {
            return MEM_ACCESS.int32_t(memorySegment, Aiocb.offsetof_Aio_fildes);
        }

        /**
         * The file descriptor.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * @param aio_fildes the value of aio_fildes to be set natively.
         */
        public void aio_fildes(int aio_fildes) {
            MEM_ACCESS.int32_t(memorySegment, Aiocb.offsetof_Aio_fildes, aio_fildes);
        }

        /**
         * The operation to be performed.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * @return the native value of aio_lio_opcode.
         */
        public int aio_lio_opcode() {
            return MEM_ACCESS.int32_t(memorySegment, Aiocb.offsetof_Aio_lio_opcode);
        }

        /**
         * The operation to be performed.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * @param aio_lio_opcode the value of aio_lio_opcode to be set natively.
         */
        public void aio_lio_opcode(int aio_lio_opcode) {
            MEM_ACCESS.int32_t(memorySegment, Aiocb.offsetof_Aio_lio_opcode, aio_lio_opcode);
        }

        /**
         * The length of transfer.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * This is set while setting buf to ByteBuffer.remaining() or
         * OpaqueMemorys size....
         *
         * @return the native value of aio_nbytes.
         */
        @size_t
        public long aio_nbytes() {
            return ACCESSOR_SIZE_T.size_t(memorySegment, Aiocb.offsetof_Aio_nbytes);
        }

        /**
         * The file offset.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * @return the native value of aio_offset.
         */
        @off_t
        public long aio_offset() {
            return ACCESSOR_OFF_T.off_t(memorySegment, Aiocb.offsetof_Aio_offset);
        }

        /**
         * The file offset.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * @param aio_offset the value of aio_offset to be set natively.
         */
        public void aio_offset(@off_t long aio_offset) {
            ACCESSOR_OFF_T.off_t(memorySegment, Aiocb.offsetof_Aio_offset, aio_offset);
        }

        /**
         * The request priority offset.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * @return the native value of aio_reqprio.
         */
        public int aio_reqprio() {
            return MEM_ACCESS.int32_t(memorySegment, Aiocb.offsetof_Aio_reqprio);
        }

        /**
         * The request priority offset.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * @param aio_reqprio the value of aio_reqprio to be set natively.
         */
        public void aio_reqprio(int aio_reqprio) {
            MEM_ACCESS.int32_t(memorySegment, Aiocb.offsetof_Aio_reqprio, aio_reqprio);
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendIntMember("aio_fildes", aio_fildes());
            jsb.appendUnsignedLongMember("aio_offset", aio_offset());
            jsb.appendAddressMember("aio_buf", aio_buf());
            jsb.appendUnsignedLongMember("aio_nbytes", aio_nbytes());
            jsb.appendIntMember("aio_reqprio", aio_reqprio());
            jsb.appendStruct32Member("aio_sigevent", aio_sigevent);
            jsb.appendHexIntMember("aio_lio_opcode", aio_lio_opcode());
            jsb.close();
        }

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
     * aiocb}</a>.
     *
     */
    public static final class Aiocbs extends PointerArray<Aiocb> {

        public final static Aiocbs tryAllocateNative(MemorySession ms, int arraylength) throws NoSuchNativeTypeException {
            if (Aiocb.alignof == null) {
                throw new NoSuchNativeTypeException("aiocb");
            }
            return new Aiocbs(MemorySegment.allocateNative(BaseDataType.uintptr_t.SIZE_OF * arraylength, ms), 0, arraylength);
        }

        public Aiocbs(MemorySegment memorySegment, long offset, int arrayLength) throws NoSuchNativeTypeException {
            super(memorySegment, offset, arrayLength);
            if (Aiocb.alignof == null) {
                throw new NoSuchNativeTypeException("aiocb");
            }
        }

    }

    public static interface DarwinDefines {

        public final static int AIO_ALLDONE = 1;
        public final static int AIO_CANCELED = 2;
        public final static int AIO_NOTCANCELED = 4;
        public final static int LIO_NOP = 0;
        public final static int LIO_NOWAIT = 1;
        public final static int LIO_READ = 1;
        public final static int LIO_WAIT = 2;
        public final static int LIO_WRITE = 2;

    }

    public static interface FreeBsdDefines {

        public final static int AIO_ALLDONE = 3;
        public final static int AIO_CANCELED = 1;
        public final static int AIO_NOTCANCELED = 2;
        public final static int LIO_NOP = 0;
        public final static int LIO_NOWAIT = 0;
        public final static int LIO_READ = 2;
        public final static int LIO_WAIT = 1;
        public final static int LIO_WRITE = 1;

    }

    public static interface LinuxDefines {

        public final static int AIO_ALLDONE = 2;
        public final static int AIO_CANCELED = 0;
        public final static int AIO_NOTCANCELED = 1;
        public final static int LIO_NOP = 2;
        public final static int LIO_NOWAIT = 1;
        public final static int LIO_READ = 0;
        public final static int LIO_WAIT = 0;
        public final static int LIO_WRITE = 1;

    }

    /**
     * <b>POSIX:</b> A return value indicating that none of the requested
     * operations could be canceled since they are already complete.
     *
     */
    @Define()
    public final static IntDefine AIO_ALLDONE;

    /**
     * <b>POSIX:</b> A return value indicating that all requested operations
     * have been canceled.
     *
     */
    @Define()
    public final static IntDefine AIO_CANCELED;

    /**
     * <b>POSIX:</b> A return value indicating that some of the requested
     * operations could not be canceled since they are in progress.
     *
     */
    @Define()
    public final static IntDefine AIO_NOTCANCELED;

    public final static boolean HAVE_AIO_H;

    /**
     * <b>POSIX:</b> A {@link #lio_listio(int, Aiocbs, Sigevent)} element
     * operation option indicating that no transfer is requested.
     *
     */
    @Define()
    public final static IntDefine LIO_NOP;

    /**
     * <b>POSIX:</b> A {@link #lio_listio(int, Aiocbs, Sigevent)}
     * synchronization operation indicating that the calling thread is to
     * continue execution while the lio_listio() operation is being performed,
     * and no notification is given when the operation is complete.
     *
     */
    @Define()
    public final static IntDefine LIO_NOWAIT;

    /**
     * <b>POSIX:</b> A {@link #lio_listio(int, Aiocbs, Sigevent)} element
     * operation option requesting a read.
     *
     */
    @Define()
    public final static IntDefine LIO_READ;

    /**
     * <b>POSIX:</b> A {@link #lio_listio(int, Aiocbs, Sigevent)}
     * synchronization operation indicating that the calling thread is to
     * suspend until the lio_listio() operation is complete.
     *
     */
    @Define()
    public final static IntDefine LIO_WAIT;

    /**
     * <b>POSIX:</b> A {@link #lio_listio(int, Aiocbs, Sigevent)} element
     * operation option requesting a write.
     *
     */
    @Define()
    public final static IntDefine LIO_WRITE;

    /**
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX:
                HAVE_AIO_H = true;
                AIO_ALLDONE = IntDefine.toIntDefine(LinuxDefines.AIO_ALLDONE);
                AIO_CANCELED = IntDefine.toIntDefine(LinuxDefines.AIO_CANCELED);
                AIO_NOTCANCELED = IntDefine.toIntDefine(LinuxDefines.AIO_NOTCANCELED);
                LIO_NOP = IntDefine.toIntDefine(LinuxDefines.LIO_NOP);
                LIO_NOWAIT = IntDefine.toIntDefine(LinuxDefines.LIO_NOWAIT);
                LIO_READ = IntDefine.toIntDefine(LinuxDefines.LIO_READ);
                LIO_WAIT = IntDefine.toIntDefine(LinuxDefines.LIO_WAIT);
                LIO_WRITE = IntDefine.toIntDefine(LinuxDefines.LIO_WRITE);
                break;
            case DARWIN:
                HAVE_AIO_H = true;
                AIO_ALLDONE = IntDefine.toIntDefine(DarwinDefines.AIO_ALLDONE);
                AIO_CANCELED = IntDefine.toIntDefine(DarwinDefines.AIO_CANCELED);
                AIO_NOTCANCELED = IntDefine.toIntDefine(DarwinDefines.AIO_NOTCANCELED);
                LIO_NOP = IntDefine.toIntDefine(DarwinDefines.LIO_NOP);
                LIO_NOWAIT = IntDefine.toIntDefine(DarwinDefines.LIO_NOWAIT);
                LIO_READ = IntDefine.toIntDefine(DarwinDefines.LIO_READ);
                LIO_WAIT = IntDefine.toIntDefine(DarwinDefines.LIO_WAIT);
                LIO_WRITE = IntDefine.toIntDefine(DarwinDefines.LIO_WRITE);
                break;
            case FREE_BSD:
                HAVE_AIO_H = true;
                AIO_ALLDONE = IntDefine.toIntDefine(FreeBsdDefines.AIO_ALLDONE);
                AIO_CANCELED = IntDefine.toIntDefine(FreeBsdDefines.AIO_CANCELED);
                AIO_NOTCANCELED = IntDefine.toIntDefine(FreeBsdDefines.AIO_NOTCANCELED);
                LIO_NOP = IntDefine.toIntDefine(FreeBsdDefines.LIO_NOP);
                LIO_NOWAIT = IntDefine.toIntDefine(FreeBsdDefines.LIO_NOWAIT);
                LIO_READ = IntDefine.toIntDefine(FreeBsdDefines.LIO_READ);
                LIO_WAIT = IntDefine.toIntDefine(FreeBsdDefines.LIO_WAIT);
                LIO_WRITE = IntDefine.toIntDefine(FreeBsdDefines.LIO_WRITE);
                break;
            case OPEN_BSD:
            case WINDOWS:
                HAVE_AIO_H = false;
                AIO_ALLDONE = IntDefine.UNDEFINED;
                AIO_CANCELED = IntDefine.UNDEFINED;
                AIO_NOTCANCELED = IntDefine.UNDEFINED;
                LIO_NOP = IntDefine.UNDEFINED;
                LIO_NOWAIT = IntDefine.UNDEFINED;
                LIO_READ = IntDefine.UNDEFINED;
                LIO_WAIT = IntDefine.UNDEFINED;
                LIO_WRITE = IntDefine.UNDEFINED;
                break;
            default:
                throw new NoClassDefFoundError("No aio.h defines for " + MultiarchTupelBuilder.getMultiarch());
        }
    }

    private final static JnhwMh_sI__sI__A aio_cancel = JnhwMh_sI__sI__A.ofOrNull(
            LibrtLoader.LIB_RT_SYMBOL_LOOKUP,
            "aio_cancel",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sI___A aio_error = JnhwMh_sI___A.ofOrNull(
            LibrtLoader.LIB_RT_SYMBOL_LOOKUP,
            "aio_error",
            BaseDataType.C_int,
            BaseDataType.C_const_struct_pointer);

    private final static JnhwMh_sI__sI__A aio_fsync = JnhwMh_sI__sI__A.ofOrNull(
            LibrtLoader.LIB_RT_SYMBOL_LOOKUP,
            "aio_fsync",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sI___A aio_read = JnhwMh_sI___A.ofOrNull(
            LibrtLoader.LIB_RT_SYMBOL_LOOKUP,
            "aio_read",
            BaseDataType.C_int,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sL___A aio_return = JnhwMh_sL___A.ofOrNull(
            LibrtLoader.LIB_RT_SYMBOL_LOOKUP,
            "aio_return",
            PosixDataType.ssize_t,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sI___A_sI__A aio_suspend = JnhwMh_sI___A_sI__A.ofOrNull(
            LibrtLoader.LIB_RT_SYMBOL_LOOKUP,
            "aio_suspend",
            BaseDataType.C_int,
            BaseDataType.C_const_struct_array,
            BaseDataType.C_int,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sI___A aio_write = JnhwMh_sI___A.ofOrNull(
            LibrtLoader.LIB_RT_SYMBOL_LOOKUP,
            "aio_write",
            BaseDataType.C_int,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sI__sI__A_sI__A lio_listio = JnhwMh_sI__sI__A_sI__A.ofOrNull(
            LibrtLoader.LIB_RT_SYMBOL_LOOKUP,
            "lio_listio",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_const_struct_array,
            BaseDataType.C_int,
            BaseDataType.C_struct_pointer);

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/aio_cancel.html">aio_cancel
     * - cancel an asynchronous I/O request</a>.On the native side the param
     * fildes is taken from aiocb.aio_fildes.
     *
     *
     * @param aiocbp points to the asynchronous I/O control block for a
     * particular request to be canceled. If aiocbp is NULL, then all
     * outstanding cancelable asynchronous I/O requests against fildes shall be
     * canceled.
     * @return {@link #AIO_CANCELED } on succcess or {@link AIO_NOTCANCELED} if
     * not all outstanding operations cant be cancelled.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method aio_cancel is not
     * available natively.
     */
    public final static int aio_cancel(Aiocb aiocbp) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            final int result = aio_cancel.invoke_sI__sI__P(aiocbp.aio_fildes(), aiocbp);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            } else {
                return result;
            }
        } catch (NullPointerException npe) {
            if (aio_cancel == null) {
                throw new NoSuchNativeMethodException("aio_cancel");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/aio_cancel.html">aio_cancel
     * - cancel an asynchronous I/O request</a>.
     *
     * On the native side aiocbp is passed as NULL parameter. If aiocbp is NULL,
     * then all outstanding cancelable asynchronous I/O requests against fildes
     * shall be canceled.
     *
     * @param fildes a valid file descriptor.
     *
     * @return {@link AIO_CANCELED} on succcess or {@link AIO_NOTCANCELED} if
     * not all outstanding operations cant be caqncelled.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method aio_cancel is not
     * available natively.
     */
    public final static int aio_cancel(int fildes) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            final int result = aio_cancel.invoke_sI__sI__P(fildes, Pointer.NULL);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            } else {
                return result;
            }
        } catch (NullPointerException npe) {
            if (aio_cancel == null) {
                throw new NoSuchNativeMethodException("aio_cancel");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/aio_error.html">aio_error
     * - retrieve errors status for an asynchronous I/O operation</a>.
     *
     * @param aiocb prefers to an asynchronous I/O control block.
     * @return If the asynchronous I/O operation has completed successfully,
     * then false is returned. If the asynchronous operation as not yet
     * completed, then true is returned. Otherwise NativeErrorException is
     * thrown.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method aio_error is not
     * available natively.
     */
    public final static int aio_error(Aiocb aiocb) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            final int result = aio_error.invoke_sI___P(aiocb);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            } else {
                return result;
            }
        } catch (NullPointerException npe) {
            if (aio_error == null) {
                throw new NoSuchNativeMethodException("aio_error");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/aio_fsync.html">aio_fsync
     * - asynchronous file synchronization</a>.
     *
     * @param op either {@code O_DSYNC} or {@code O_SYNC}
     * @param aiocb refers to an asynchronous I/O control block
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method aio_fsync is not
     * available natively.
     */
    public final static void aio_fsync(int op, Aiocb aiocb) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            if (aio_fsync.invoke_sI__sI__P(op, aiocb) != 0) {
                throw new NativeErrorException(Errno.errno());
            }
        } catch (NullPointerException npe) {
            if (aio_fsync == null) {
                throw new NoSuchNativeMethodException("aio_fsync");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/aio_read.html">aio_read
     * - asynchronous read from a file</a>.
     *
     * @param aiocb refers to an asynchronous I/O control block
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method aio_read is not
     * available natively.
     */
    public final static void aio_read(Aiocb aiocb) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            if (aio_read.invoke_sI___P(aiocb) != 0) {
                throw new NativeErrorException(Errno.errno());
            }
        } catch (NullPointerException npe) {
            if (aio_read == null) {
                throw new NoSuchNativeMethodException("aio_read");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/aio_return.html">aio_return
     * - retrieve return status of an asynchronous I/O operation</a>.
     *
     * @param aiocb refers to an asynchronous I/O control block
     * @return If the asynchronous I/O operation has completed, thern the number
     * of transferred bytes are returned. If the asynchronous I/O operation *
     * has not yet completed, the results of aio_return() are undefined.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method aio_return is not
     * available natively.
     */
    @ssize_t
    public final static long aio_return(Aiocb aiocb) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            final long result = aio_return.invoke_sL___P(aiocb);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            } else {
                return result;
            }
        } catch (NullPointerException npe) {
            if (aio_return == null) {
                throw new NoSuchNativeMethodException("aio_return");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/aio_suspend.html">aio_suspend
     * - wait for an asynchronous I/O request</a>.
     *
     * @param list refers to an asynchronous I/O control blocks to suspend.
     * @param timeout
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method aio_suspend is not
     * available natively.
     */
    public final static void aio_suspend(Aiocbs list, Timespec timeout) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            if (aio_suspend.invoke_sI___P_sI__P(list, list.length(), timeout) != 0) {
                throw new NativeErrorException(Errno.errno());
            }
        } catch (NullPointerException npe) {
            if (aio_suspend == null) {
                throw new NoSuchNativeMethodException("aio_suspend");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/aio_suspend.html">aio_write
     * - asynchronous write to a file</a>.
     *
     * @param aiocb refers to an asynchronous I/O control block
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method aio_write is not
     * available natively.
     */
    public final static void aio_write(Aiocb aiocb) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            if (aio_write.invoke_sI___P(aiocb) != 0) {
                throw new NativeErrorException(Errno.errno());
            }
        } catch (NullPointerException npe) {
            if (aio_write == null) {
                throw new NoSuchNativeMethodException("aio_write");
            } else {
                throw npe;
            }
        }
    }

    public final static void lio_listio(int mode, Aiocbs list) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            if (lio_listio.invoke_sI__sI__P_sI__P(mode, list, list.length(), Pointer.NULL) != 0) {
                throw new NativeErrorException(Errno.errno());
            }
        } catch (NullPointerException npe) {
            if (lio_listio == null) {
                throw new NoSuchNativeMethodException("lio_listio");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/lio_listio.html">lio_listio
     * - list directed I/O</a>.
     *
     * @param mode
     * @param list refers to an asynchronous I/O control blocks.
     * @param sig
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method lio_listio is not
     * available natively.
     */
    public final static void lio_listio(int mode, Aiocbs list, Sigevent sig) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            if (lio_listio.invoke_sI__sI__P_sI__P(mode, list, list.length(), sig) != 0) {
                throw new NativeErrorException(Errno.errno());
            }
        } catch (NullPointerException npe) {
            if (lio_listio == null) {
                throw new NoSuchNativeMethodException("lio_listio");
            } else {
                throw npe;
            }
        }
    }

}
