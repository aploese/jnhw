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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.NativeAddressHolder;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.OpaqueMemory;
import de.ibapl.jnhw.PointerArray;
import de.ibapl.jnhw.posix.Signal.Sigevent;
import de.ibapl.jnhw.posix.Time.Timespec;
import de.ibapl.jnhw.posix.sys.Types;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import java.nio.ByteBuffer;
import java.util.function.LongFunction;

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
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    /**
     * <b>POSIX:</b> A return value indicating that none of the requested
     * operations could be canceled since they are already complete.
     *
     * @return the native symbolic constant of AIO_ALLDONE.
     */
    @Define()
    public final static native int AIO_ALLDONE();

    /**
     * <b>POSIX:</b> A return value indicating that all requested operations
     * have been canceled.
     *
     * @return the native symbolic constant of AIO_CANCELED.
     */
    @Define()
    public final static native int AIO_CANCELED();

    /**
     * <b>POSIX:</b> A return value indicating that some of the requested
     * operations could not be canceled since they are in progress.
     *
     *
     * @return the native symbolic constant of AIO_NOTCANCELED.
     */
    @Define()

    public final static native int AIO_NOTCANCELED();

    public final static native boolean HAVE_AIO_H();

    /**
     * <b>POSIX:</b> A {@link lio_listio()} element operation option indicating
     * that no transfer is requested.
     *
     * @return the native symbolic constant of LIO_NOP.
     */
    @Define()
    public final static native int LIO_NOP();

    /**
     * <b>POSIX:</b> A {@link lio_listio()} synchronization operation indicating
     * that * the calling thread is to continue execution while the lio_listio()
     * operation is being performed, and no notification is given when the
     * operation is complete.
     *
     * @return the native symbolic constant of LIO_NOWAIT.
     */
    @Define()
    public final static native int LIO_NOWAIT();

    /**
     * <b>POSIX:</b> A {@link lio_listio()} element operation option requesting
     * a read.
     *
     * @return the native symbolic constant of LIO_READ.
     */
    @Define()
    public final static native int LIO_READ();

    /**
     * <b>POSIX:</b> A {@link lio_listio()} synchronization operation indicating
     * that the calling thread is to suspend until the lio_listio() operation is
     * complete.
     *
     * @return the native symbolic constant of LIO_WAIT.
     */
    @Define()
    public final static native int LIO_WAIT();

    /**
     * <b>POSIX:</b> A {@link lio_listio()} element operation option requesting
     * a write.
     *
     * @return the native symbolic constant of LIO_WRITE.
     */
    @Define()
    public final static native int LIO_WRITE();

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/aio_cancel.html">aio_cancel
     * - cancel an asynchronous I/O request</a>.
     *
     * On the native side the param fildes is taken from aiocb.aio_fildes.
     *
     * @param aiocbp points to the asynchronous I/O control block for a
     * particular request to be canceled. If aiocbp is NULL, then all
     * outstanding cancelable asynchronous I/O requests against fildes shall be
     * canceled.
     * @return {@link AIO_CANCELED} on succcess or {@link AIO_NOTCANCELED} if
     * not all outstanding operations cant be caqncelled.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native int aio_cancel(Aiocb aiocbp) throws NativeErrorException;

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
     */
    public final static native int aio_cancel(int fildes) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/aio_error.html">aio_error
     * - retrieve errors status for an asynchronous I/O operation</a>.
     *
     * @param aiocb prefers to an asynchronous I/O control block.
     * @return If the asynchronous I/O operation has completed successfully,
     * then 0 shall be returned. If the asynchronous operation has completed
     * unsuccessfully, then the error status is returned.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native int aio_error(Aiocb aiocb) throws NativeErrorException;

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
     */
    public final static native void aio_fsync(int op, Aiocb aiocb) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/aio_read.html">aio_read
     * - asynchronous read from a file</a>.
     *
     * @param aiocb refers to an asynchronous I/O control block
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void aio_read(Aiocb aiocb) throws NativeErrorException;

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
     */
    public final static native @Types.ssize_t
    long aio_return(Aiocb aiocb) throws NativeErrorException;

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
     */
    public final static native void aio_suspend(Aiocbs list, Timespec timeout) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/aio_suspend.html">aio_write
     * - asynchronous write to a file</a>.
     *
     * @param aiocb refers to an asynchronous I/O control block
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void aio_write(Aiocb aiocb) throws NativeErrorException;

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
     */
    public final static native void lio_listio(int mode, Aiocbs list, Sigevent sig) throws NativeErrorException;

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
     * aiocb}</a>.
     *
     */
    public static final class Aiocb<T extends OpaqueMemory> extends OpaqueMemory {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        /**
         * Get the real size of struct aiocb natively.
         *
         * @return the native value sizeof(struct aiocb).
         */
        public static native int sizeofAiocb();

        public static native int _aio_sigevent_value_Offset();

        /**
         * The signal number and value.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         */
        public final Sigevent<T> aio_sigevent;

        public Aiocb(OpaqueMemory owner, int offset) {
            super(owner, offset, sizeofAiocb());
            aio_sigevent = new Sigevent(this, _aio_sigevent_value_Offset());
        }

        public Aiocb() {
            super(sizeofAiocb(), true);
            aio_sigevent = new Sigevent(this, _aio_sigevent_value_Offset());
        }

        /**
         * TODO set ByteBuffer ???
         *
         * @param address
         */
        public Aiocb(NativeAddressHolder address) {
            super(address, sizeofAiocb());
            aio_sigevent = new Sigevent(this, _aio_sigevent_value_Offset());
        }

        /**
         * The file descriptor.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * @return the native value of aio_fildes.
         */
        public native int aio_fildes();

        /**
         * The file descriptor.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * @param aio_fildes the value of aio_fildes to be set natively.
         */
        public native void aio_fildes(int aio_fildes);

        /**
         * The file offset.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * @return the native value of aio_offset.
         */
        public native @Types.off_t
        long aio_offset();

        /**
         * The file offset.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * @param aio_offset the value of aio_offset to be set natively.
         */
        public native void aio_offset(@Types.off_t long aio_offset);

        private native long aio_buf0();
        /**
         * The location of buffer.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * @return the native value of aio_buf.
         */
        public <T> T aio_buf(LongFunction<T> producer) {
            return producer.apply(aio_buf0());
        }

        /**
         *
         * @param aio_buf
         * @param offset
         * @param length must not < 0
         */
        private native void aio_bufByteBuffer(ByteBuffer aio_buf, int offset, int length);

        /**
         *
         * @param aio_buf
         * @param offset
         * @param length must not < 0
         */
        private native void aio_bufOpaqueMemory(OpaqueMemory aio_buf, int offset, int length);

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
                aio_bufByteBuffer(null, 0, 0);
            } else {
                aio_bufByteBuffer(aio_buf, aio_buf.position(), aio_buf.remaining());
            }
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
                aio_bufOpaqueMemory(null, 0, 0);
            } else {
                aio_bufOpaqueMemory(aio_buf, 0, aio_buf.sizeInBytes);
            }
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
        public void aio_buf(OpaqueMemory aio_buf, int off, int aio_nbytes) {
            if (aio_buf == null) {
                aio_bufOpaqueMemory(null, 0, 0);
            } else {
                aio_bufOpaqueMemory(aio_buf, off, aio_nbytes);
            }
        }

        /**
         * The length of transfer.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * @return the native value of aio_nbytes.
         */
        public native long aio_nbytes();

        /**
         * The request priority offset.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * @return the native value of aio_reqprio.
         */
        public native int aio_reqprio();

        /**
         * The request priority offset.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * @param aio_reqprio the value of aio_reqprio to be set natively.
         */
        public native void aio_reqprio(int aio_reqprio);

        /**
         * The operation to be performed.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * @return the native value of aio_lio_opcode.
         */
        public native int aio_lio_opcode();

        /**
         * The operation to be performed.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
         * aiocb}</a>.
         *
         * @param aio_lio_opcode the value of aio_lio_opcode to be set natively.
         */
        public native void aio_lio_opcode(int aio_lio_opcode);

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/aio.h.html">{@code structure
     * aiocb}</a>.
     *
     */
    public static final class Aiocbs extends PointerArray<Aiocb> {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        public Aiocbs(int arraylength) {
            //get initialized mem
            super(arraylength, true);
        }

    }

}
