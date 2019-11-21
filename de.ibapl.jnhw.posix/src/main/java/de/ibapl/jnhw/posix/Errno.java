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
import de.ibapl.jnhw.NotDefinedException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Wrapper around the {@code <errno.h>} header.
 *
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/errno.h.html">errno.h
 * - system error numbers</a>.
 *
 * @author aploese
 */
@Include("#include <errno.h>")
public final class Errno extends de.ibapl.jnhw.isoc.Errno {

    /**
     * <b>POSIX:</b> Argument list too long.
     *
     * @return the native symbolic constant of E2BIG.
     */
    @Define
    public final static native int E2BIG();

    /**
     * <b>POSIX:</b> Permission denied.
     *
     * @return the native symbolic constant of EACCES.
     */
    @Define
    public final static native int EACCES();

    /**
     * <b>POSIX:</b> Address in use.
     *
     * @return the native symbolic constant of EADDRINUSE.
     */
    @Define
    public final static native int EADDRINUSE();

    /**
     * <b>POSIX:</b> Address not available.
     *
     * @return the native symbolic constant of EADDRNOTAVAIL.
     */
    @Define
    public final static native int EADDRNOTAVAIL();

    /**
     * <b>Non POSIX:</b> Advertise error.
     *
     * @return the native symbolic constant of EADV.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EADV() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Address family not supported.
     *
     * @return the native symbolic constant of EAFNOSUPPORT.
     */
    @Define
    public final static native int EAFNOSUPPORT();

    /**
     * <b>POSIX:</b> Resource unavailable, try again (may be the same value as
     * [EWOULDBLOCK]).
     *
     * @return the native symbolic constant of EAGAIN.
     */
    @Define
    public final static native int EAGAIN();

    /**
     * <b>POSIX:</b> Connection already in progress.
     *
     * @return the native symbolic constant of EALREADY.
     */
    @Define
    public final static native int EALREADY();

    /**
     * <b>Linux:</b> Invalid exchange.
     *
     * @return the native symbolic constant of EBADE.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EBADE() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Bad file descriptor.
     *
     * @return the native symbolic constant of EBADF.
     */
    @Define
    public final static native int EBADF();

    /**
     * <b>Linux:</b> File descriptor in bad state.
     *
     * @return the native symbolic constant of EBADFD.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EBADFD() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Bad message.
     *
     * @return the native symbolic constant of EBADMSG.
     */
    @Define
    public final static native int EBADMSG();

    /**
     * <b>Linux:</b> Invalid request descriptor.
     *
     * @return the native symbolic constant of EBADR.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EBADR() throws NotDefinedException;

    /**
     * <b>Linux:</b> Invalid request code.
     *
     * @return the native symbolic constant of EBADRQC.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EBADRQC() throws NotDefinedException;

    /**
     * <b>Linux:</b> Invalid slot.
     *
     * @return the native symbolic constant of EBADSLT.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EBADSLT() throws NotDefinedException;

    /**
     * <b>Linux:</b> Bad font file format
     *
     * @return the native symbolic constant of EBFONT.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EBFONT() throws NotDefinedException;

    /**
     * POSIX Device or resource busy.
     *
     * @return the native symbolic constant of EBUSY.
     */
    @Define
    public final static native int EBUSY();

    /**
     * <b>POSIX:</b> Operation canceled.
     *
     * @return the native symbolic constant of ECANCELED.
     */
    @Define
    public final static native int ECANCELED();

    /**
     * <b>POSIX:</b> No child processes.
     *
     * @return the native symbolic constant of ECHILD.
     */
    @Define
    public final static native int ECHILD();

    /**
     * <b>Linux:</b> Channel number out of range.
     *
     * @return the native symbolic constant of ECHRNG.
     * @throws NotDefinedException
     */
    @Define
    public final static native int ECHRNG() throws NotDefinedException;

    /**
     * <b>Linux:</b> Communication error on send.
     *
     * @return the native symbolic constant of ECOMM.
     * @throws NotDefinedException
     */
    @Define
    public final static native int ECOMM() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Connection aborted.
     *
     * @return the native symbolic constant of ECONNABORTED.
     */
    @Define
    public final static native int ECONNABORTED();

    /**
     * <b>POSIX:</b> Connection refused.
     *
     * @return the native symbolic constant of ECONNREFUSED.
     */
    @Define
    public final static native int ECONNREFUSED();

    /**
     * <b>POSIX:</b> Connection reset.
     *
     * @return the native symbolic constant of ECONNRESET.
     */
    @Define
    public final static native int ECONNRESET();

    /**
     * <b>POSIX:</b> Resource deadlock would occur.
     *
     * @return the native symbolic constant of EDEADLK.
     */
    @Define
    public final static native int EDEADLK();

    /**
     * <b>Linux:</b> @see(EDEADLK)
     *
     * @return the native symbolic constant of EDEADLOCK.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EDEADLOCK() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Destination address required.
     *
     * @return the native symbolic constant of EDESTADDRREQ.
     */
    @Define
    public final static native int EDESTADDRREQ();

    /**
     * <b>Linux:</b> RFS specific error.
     *
     * @return the native symbolic constant of EDOTDOT.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EDOTDOT() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Reserved.
     *
     * @return the native symbolic constant of EDQUOT.
     */
    @Define
    public final static native int EDQUOT();

    /**
     * <b>POSIX:</b> File exists.
     *
     * @return the native symbolic constant of EEXIST.
     */
    @Define
    public final static native int EEXIST();

    /**
     * <b>POSIX:</b> Bad address.
     *
     * @return the native symbolic constant of EFAULT.
     */
    @Define
    public final static native int EFAULT();

    /**
     * <b>POSIX:</b> File too large.
     *
     * @return the native symbolic constant of EFBIG.
     */
    @Define
    public final static native int EFBIG();

    /**
     * <b>Non POSIX:</b> Host is down.
     *
     * @return the native symbolic constant of EHOSTDOWN.
     */
    @Define
    public final static native int EHOSTDOWN();

    /**
     * <b>POSIX:</b> Host is unreachable.
     *
     * @return the native symbolic constant of EHOSTUNREACH.
     */
    @Define
    public final static native int EHOSTUNREACH();

    /**
     * <b>Linux:</b> Memory page has hardware error.
     *
     * @return the native symbolic constant of EHWPOISON.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EHWPOISON() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Identifier removed.
     *
     * @return the native symbolic constant of EIDRM.
     */
    @Define
    public final static native int EIDRM();

    /**
     * <b>POSIX:</b> Operation in progress.
     *
     * @return the native symbolic constant of EINPROGRESS.
     */
    @Define
    public final static native int EINPROGRESS();

    /**
     * <b>POSIX:</b> Interrupted function.
     *
     * @return the native symbolic constant of EINTR.
     */
    @Define
    public final static native int EINTR();

    /**
     * <b>POSIX:</b> Invalid argument.
     *
     * @return the native symbolic constant of EINVAL.
     */
    @Define
    public final static native int EINVAL();

    /**
     * <b>POSIX:</b> I/O error.
     *
     * @return the native symbolic constant of EIO.
     */
    @Define
    public final static native int EIO();

    /**
     * <b>POSIX:</b> Socket is connected.
     *
     * @return the native symbolic constant of EISCONN.
     */
    @Define
    public final static native int EISCONN();

    /**
     * <b>POSIX:</b> Is a directory.
     *
     * @return the native symbolic constant of EISDIR.
     */
    @Define
    public final static native int EISDIR();

    /**
     * <b>Linux:</b> Is a named type file.
     *
     * @return the native symbolic constant of EISNAM.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EISNAM() throws NotDefinedException;

    /**
     * <b>Linux:</b> Key has expired.
     *
     * @return the native symbolic constant of EKEYEXPIRED.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EKEYEXPIRED() throws NotDefinedException;

    /**
     * <b>Linux:</b> Key was rejected by service.
     *
     * @return the native symbolic constant of EKEYREJECTED.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EKEYREJECTED() throws NotDefinedException;

    /**
     * <b>Linux:</b> Key has been revoked.
     *
     * @return the native symbolic constant of EKEYREVOKED.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EKEYREVOKED() throws NotDefinedException;

    /**
     * <b>Linux:</b> evel 2 halted.
     *
     * @return the native symbolic constant of EL2HLT.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EL2HLT() throws NotDefinedException;

    /**
     * <b>Linux:</b> Level 2 not synchronized.
     *
     * @return the native symbolic constant of EL2NSYNC.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EL2NSYNC() throws NotDefinedException;

    /**
     * <b>Linux:</b> Level 3 halted.
     *
     * @return the native symbolic constant of EL3HLT.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EL3HLT() throws NotDefinedException;

    /**
     * <b>Linux:</b> Level 3 reset.
     *
     * @return the native symbolic constant of EL3RST.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EL3RST() throws NotDefinedException;

    /**
     * <b>Linux:</b> Can not access a needed shared library.
     *
     * @return the native symbolic constant of ELIBACC.
     * @throws NotDefinedException
     */
    @Define
    public final static native int ELIBACC() throws NotDefinedException;

    /**
     * <b>Linux:</b> Accessing a corrupted shared library.
     *
     * @return the native symbolic constant of ELIBBAD.
     * @throws NotDefinedException
     */
    @Define
    public final static native int ELIBBAD() throws NotDefinedException;

    /**
     * <b>Linux:</b> Cannot exec a shared library directly.
     *
     * @return the native symbolic constant of ELIBEXEC.
     * @throws NotDefinedException
     */
    @Define
    public final static native int ELIBEXEC() throws NotDefinedException;

    /**
     * <b>Linux:</b> Attempting to link in too many shared libraries.
     *
     * @return the native symbolic constant of ELIBMAX.
     * @throws NotDefinedException
     */
    @Define
    public final static native int ELIBMAX() throws NotDefinedException;

    /**
     * <b>Linux:</b> .lib section in a.out corrupted.
     *
     * @return the native symbolic constant of ELIBSCN.
     * @throws NotDefinedException
     */
    @Define
    public final static native int ELIBSCN() throws NotDefinedException;

    /**
     * <b>Linux:</b> Link number out of range.
     *
     * @return the native symbolic constant of ELNRNG.
     * @throws NotDefinedException
     */
    @Define
    public final static native int ELNRNG() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Too many levels of symbolic links.
     *
     * @return the native symbolic constant of ELOOP.
     */
    @Define
    public final static native int ELOOP();

    /**
     * <b>Linux:</b> Wrong medium type.
     *
     * @return the native symbolic constant of EMEDIUMTYPE.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EMEDIUMTYPE() throws NotDefinedException;

    /**
     * <b>POSIX:</b> File descriptor value too large.
     *
     * @return the native symbolic constant of EMFILE.
     */
    @Define
    public final static native int EMFILE();

    /**
     * <b>POSIX:</b> Too many links.
     *
     * @return the native symbolic constant of EMLINK.
     */
    @Define
    public final static native int EMLINK();

    /**
     * <b>POSIX:</b> Message too large.
     *
     * @return the native symbolic c.
     */
    @Define
    public final static native int EMSGSIZE();

    /**
     * <b>POSIX:</b> Reserved.
     *
     * @return the native symbolic constant of EMULTIHOP.
     */
    @Define
    public final static native int EMULTIHOP();

    /**
     * <b>POSIX:</b> Filename too long.
     *
     * @return the native symbolic constant of ENAMETOOLONG.
     */
    @Define
    public final static native int ENAMETOOLONG();

    /**
     * <b>Linux:</b> No XENIX semaphores available.
     *
     * @return the native symbolic constant of ENAVAIL.
     * @throws NotDefinedException
     */
    @Define
    public final static native int ENAVAIL() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Network is down.
     *
     * @return the native symbolic constant of ENETDOWN.
     */
    @Define
    public final static native int ENETDOWN();

    /**
     * <b>POSIX:</b> Connection aborted by network.
     *
     * @return the native symbolic constant of ENETRESET.
     */
    @Define
    public final static native int ENETRESET();

    /**
     * <b>POSIX:</b> Network unreachable.
     *
     * @return the native symbolic constant of ENETUNREACH.
     */
    @Define
    public final static native int ENETUNREACH();

    /**
     * <b>POSIX:</b> Too many files open in system.
     *
     * @return the native symbolic constant of ENFILE.
     */
    @Define
    public final static native int ENFILE();

    /**
     * <b>Linux:</b> No anode.
     *
     * @return the native symbolic constant of ENOANO.
     * @throws NotDefinedException
     */
    @Define
    public final static native int ENOANO() throws NotDefinedException;

    /**
     * <b>POSIX:</b> No buffer space available.
     *
     * @return the native symbolic constant of ENOBUFS.
     */
    @Define
    public final static native int ENOBUFS();

    /**
     * <b>Linux:</b> No CSI structure available.
     *
     * @return the native symbolic constant of ENOCSI.
     * @throws NotDefinedException
     */
    @Define
    public final static native int ENOCSI() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> No message is available on the STREAM head read queue.
     *
     * @return the native symbolic constant of ENODATA.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int ENODATA() throws NotDefinedException;

    /**
     * <b>POSIX:</b> No such device.
     *
     * @return the native symbolic constant of ENODEV.
     */
    @Define
    public final static native int ENODEV();

    /**
     * <b>POSIX:</b> No such file or directory.
     *
     * @return the native symbolic constant of ENOENT.
     */
    @Define
    public final static native int ENOENT();

    /**
     * <b>POSIX:</b> Executable file format error.
     *
     * @return the native symbolic constant of ENOEXEC.
     */
    @Define
    public final static native int ENOEXEC();

    /**
     * <b>Linux:</b> Required key not available
     *
     * @return the native symbolic constant of ENOKEY.
     * @throws NotDefinedException
     */
    @Define
    public final static native int ENOKEY() throws NotDefinedException;

    /**
     * <b>POSIX:</b> No locks available.
     *
     * @return the native symbolic constant of ENOLCK.
     */
    @Define
    public final static native int ENOLCK();

    /**
     * <b>POSIX:</b> Reserved.
     *
     * @return the native symbolic constant of ENOLINK.
     */
    @Define
    public final static native int ENOLINK();

    /**
     * <b>Linux:</b> No medium found.
     *
     * @return the native symbolic constant of ENOMEDIUM.
     * @throws NotDefinedException
     */
    @Define
    public final static native int ENOMEDIUM() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Not enough space.
     *
     * @return the native symbolic constant of ENOMEM.
     */
    @Define
    public final static native int ENOMEM();

    /**
     * <b>POSIX:</b> No message of the desired type.
     *
     * @return the native symbolic constant of ENOMSG.
     */
    @Define
    public final static native int ENOMSG();

    /**
     * <b>Linux:</b> Machine is not on the network.
     *
     * @return the native symbolic constant of ENONET.
     * @throws NotDefinedException
     */
    @Define
    public final static native int ENONET() throws NotDefinedException;

    /**
     * <b>Linux:</b> Package not installed.
     *
     * @return the native symbolic constant of ENOPKG.
     * @throws NotDefinedException
     */
    @Define
    public final static native int ENOPKG() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Protocol not available.
     *
     * @return the native symbolic constant of ENOPROTOOPT.
     */
    @Define
    public final static native int ENOPROTOOPT();

    /**
     * <b>POSIX:</b> No space left on device.
     *
     * @return the native symbolic constant of ENOSPC.
     */
    @Define
    public final static native int ENOSPC();

    /**
     * <b>POSIX.XSI:</b> No STREAM resources.
     *
     * @return the native symbolic constant of ENOSR.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int ENOSR() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> Not a STREAM.
     *
     * @return the native symbolic constant of ENOSTR.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int ENOSTR() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Functionality not supported.
     *
     * @return the native symbolic constant of ENOSYS.
     */
    @Define
    public final static native int ENOSYS();

    /**
     * <b>Non POSIX:</b> Block device required.
     *
     * @return the native symbolic constant of ENOTBLK.
     */
    @Define
    public final static native int ENOTBLK();

    /**
     * <b>POSIX:</b> The socket is not connected.
     *
     * @return the native symbolic constant of ENOTCONN.
     */
    @Define
    public final static native int ENOTCONN();

    /**
     * <b>POSIX:</b> Not a directory or a symbolic link to a directory.
     *
     * @return the native symbolic constant of ENOTDIR.
     */
    @Define
    public final static native int ENOTDIR();

    /**
     * <b>POSIX:</b> Directory not empty.
     *
     * @return the native symbolic constant of ENOTEMPTY.
     */
    @Define
    public final static native int ENOTEMPTY();

    /**
     * <b>Linux:</b> Not a XENIX named type file.
     *
     * @return the native symbolic constant of ENOTNAM.
     * @throws NotDefinedException
     */
    @Define
    public final static native int ENOTNAM() throws NotDefinedException;

    /**
     * <b>POSIX:</b> State not recoverable.
     *
     * @return the native symbolic constant of ENOTRECOVERABLE.
     */
    @Define
    public final static native int ENOTRECOVERABLE();

    /**
     * <b>POSIX:</b> Not a socket.
     *
     * @return the native symbolic constant of ENOTSOCK.
     */
    @Define
    public final static native int ENOTSOCK();

    /**
     * <b>Non POSIX:</b> Not supported (may be the same value as [@see
     * EOPNOTSUPP]).
     *
     * @return the native symbolic constant of ENOTSUP.
     */
    @Define
    public final static native int ENOTSUP();

    /**
     * <b>POSIX:</b> Inappropriate I/O control operation.
     *
     * @return the native symbolic constant of ENOTTY.
     */
    @Define
    public final static native int ENOTTY();

    /**
     * <b>Linux:</b> Name not unique on network.
     *
     * @return the native symbolic constant of ENOTUNIQ.
     * @throws NotDefinedException
     */
    @Define
    public final static native int ENOTUNIQ() throws NotDefinedException;

    /**
     * <b>POSIX:</b> No such device or address.
     *
     * @return the native symbolic constant of ENXIO.
     */
    @Define
    public final static native int ENXIO();

    /**
     * <b>POSIX:</b> Operation not supported on socket (may be the same value as
     * [@see ENOTSUP]).
     *
     * @return the native symbolic constant of EOPNOTSUPP.
     */
    @Define
    public final static native int EOPNOTSUPP();

    /**
     * <b>POSIX:</b> Value too large to be stored in data type.
     *
     * @return the native symbolic constant of EOVERFLOW.
     */
    @Define
    public final static native int EOVERFLOW();

    /**
     * <b>POSIX:</b> Previous owner died.
     *
     * @return the native symbolic constant of EOWNERDEAD.
     */
    @Define
    public final static native int EOWNERDEAD();

    /**
     * <b>POSIX:</b> Operation not permitted.
     *
     * @return the native symbolic constant of EPERM.
     */
    @Define
    public final static native int EPERM();

    /**
     * <b>Non POSIX:</b> Protocol family not supported.
     *
     * @return the native symbolic constant of EPFNOSUPPORT.
     */
    @Define
    public final static native int EPFNOSUPPORT();

    /**
     * <b>POSIX:</b> Broken pipe.
     *
     * @return the native symbolic constant of EPIPE.
     */
    @Define
    public final static native int EPIPE();

    /**
     * <b>POSIX:</b> Protocol error.
     *
     * @return the native symbolic constant of EPROTO.
     */
    @Define
    public final static native int EPROTO();

    /**
     * <b>POSIX:</b> Protocol not supported.
     *
     * @return the native symbolic constant of EPROTONOSUPPORT.
     */
    @Define
    public final static native int EPROTONOSUPPORT();

    /**
     * <b>POSIX:</b> Protocol wrong type for socket.
     *
     * @return the native symbolic constant of EPROTOTYPE.
     */
    @Define
    public final static native int EPROTOTYPE();

    /**
     * <b>Linux:</b> Remote address changed.
     *
     * @return the native symbolic constant of EREMCHG.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EREMCHG() throws NotDefinedException;

    /**
     * <b>Non POSIX:</b> Object is remote
     *
     * @return the native symbolic constant of EREMOTE.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EREMOTE() throws NotDefinedException;

    /**
     * <b>Linux:</b> Remote I/O error.
     *
     * @return the native symbolic constant of EREMOTEIO.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EREMOTEIO() throws NotDefinedException;

    /**
     * <b>Linux:</b> Interrupted system call should be restarted.
     *
     * @return the native symbolic constant of ERESTART.
     * @throws NotDefinedException
     */
    @Define
    public final static native int ERESTART() throws NotDefinedException;

    /**
     * <b>Linux:</b> Operation not possible due to RF-kill.
     *
     * @return the native symbolic constant of ERFKILL.
     * @throws NotDefinedException
     */
    @Define
    public final static native int ERFKILL() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Read-only file system.
     *
     * @return the native symbolic constant of EROFS.
     */
    @Define
    public final static native int EROFS();

    /**
     * <b>Non POSIX:</b> Cannot send after transport endpoint shutdown.
     *
     * @return the native symbolic constant of ESHUTDOWN.
     */
    @Define
    public final static native int ESHUTDOWN();

    /**
     * <b>Non POSIX:</b> Socket type not supported
     *
     * @return the native symbolic constant of ESOCKTNOSUPPORT.
     */
    @Define
    public final static native int ESOCKTNOSUPPORT();

    /**
     * <b>POSIX:</b> Invalid seek.
     *
     * @return the native symbolic constant of ESPIPE.
     */
    @Define
    public final static native int ESPIPE();

    /**
     * <b>POSIX:</b> No such process.
     *
     * @return the native symbolic constant of ESRCH.
     */
    @Define
    public final static native int ESRCH();

    /**
     * <b>Linux:</b> Srmount error.
     *
     * @return the native symbolic constant of ESRMNT.
     * @throws NotDefinedException
     */
    @Define
    public final static native int ESRMNT() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Reserved.
     *
     * @return the native symbolic constant of ESTALE.
     */
    @Define
    public final static native int ESTALE();

    /**
     * <b>Linux:</b> Streams pipe error.
     *
     * @return the native symbolic constant of ESTRPIPE.
     * @throws NotDefinedException
     */
    @Define
    public final static native int ESTRPIPE() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Stream @see ioctl_H.ioctl() timeout.
     *
     * @return the native symbolic constant of ETIME.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int ETIME() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Connection timed out.
     *
     * @return the native symbolic constant of ETIMEDOUT.
     */
    @Define
    public final static native int ETIMEDOUT();

    /**
     * <b>Non POSIX:</b> Too many references: cannot splice.
     *
     * @return the native symbolic constant of ETOOMANYREFS.
     */
    @Define
    public final static native int ETOOMANYREFS();

    /**
     * <b>POSIX:</b> Text file busy.
     *
     * @return the native symbolic constant of ETXTBSY.
     */
    @Define
    public final static native int ETXTBSY();

    /**
     * <b>Linux:</b> Structure needs cleaning.
     *
     * @return the native symbolic constant of EUCLEAN.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EUCLEAN() throws NotDefinedException;

    /**
     * <b>Linux:</b> Protocol driver not attached.
     *
     * @return the native symbolic constant of EUNATCH.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EUNATCH() throws NotDefinedException;

    /**
     * <b>Non POSIX:</b> Too many users.
     *
     * @return the native symbolic constant of EUSERS.
     */
    @Define
    public final static native int EUSERS();

    /**
     * <b>POSIX:</b> Operation would block (may be the same value as [@see
     * EAGAIN]).
     *
     * @return the native symbolic constant of EWOULDBLOCK.
     */
    @Define
    public final static native int EWOULDBLOCK();

    /**
     * <b>POSIX:</b> Cross-device link.
     *
     * @return the native symbolic constant of EXDEV.
     */
    @Define
    public final static native int EXDEV();

    /**
     * <b>Linux:</b> Exchange full.
     *
     * @return the native symbolic constant of EXFULL.
     * @throws NotDefinedException
     */
    @Define
    public final static native int EXFULL() throws NotDefinedException;

    /**
     * Translate the native errno to its symbolic constant name.
     *
     * @param errno
     * @return
     */
    public final static String getErrnoSymbol(int errno) {
        for (Method m : Errno.class.getMethods()) {
            if (m.getAnnotation(Define.class) != null) {
                try {
                    Number res = (Number) m.invoke(Errno.class);
                    if (errno == res.intValue()) {
                        return m.getName();
                    }
                } catch (InvocationTargetException ite) {
                    if (ite.getCause() instanceof NotDefinedException) {
                        //no-op
                    } else {
                        Logger.getLogger(Errno.class.getName()).log(Level.SEVERE, "Unknown ex in Errno.getErrnoSymbol(int)", ite);
                    }
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(Errno.class.getName()).log(Level.SEVERE, "Unknown ex in Errno.getErrnoSymbol(int)", ex);
                } catch (Exception e) {
                    if (e instanceof NotDefinedException) {
                        //no-op
                    } else {
                        //something unexpected happend...
                        throw e;
                    }
                }
            }
        }
        return "Unknown errno: " + errno;
    }

    protected Errno() {

    }

}
