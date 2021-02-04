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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.util.IntDefine;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import java.lang.reflect.Field;
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
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
        E2BIG = 0;

        EACCES = 0;
        EADDRINUSE = 0;
        EADDRNOTAVAIL = 0;
        EADV = IntDefine.UNDEFINED;
        EAFNOSUPPORT = 0;
        EAGAIN = 0;
        EALREADY = 0;

        EBADE = IntDefine.UNDEFINED;
        EBADF = 0;
        EBADFD = IntDefine.UNDEFINED;
        EBADMSG = 0;
        EBADR = IntDefine.UNDEFINED;
        EBADRQC = IntDefine.UNDEFINED;
        EBADSLT = IntDefine.UNDEFINED;
        EBFONT = IntDefine.UNDEFINED;
        EBUSY = 0;

        ECANCELED = 0;
        ECHILD = 0;
        ECHRNG = IntDefine.UNDEFINED;
        ECOMM = IntDefine.UNDEFINED;
        ECONNABORTED = 0;
        ECONNREFUSED = 0;
        ECONNRESET = 0;

        EDEADLK = 0;
        EDEADLOCK = IntDefine.UNDEFINED;
        EDESTADDRREQ = 0;
        EDOTDOT = IntDefine.UNDEFINED;
        EDQUOT = 0;

        EEXIST = 0;

        EFAULT = 0;
        EFBIG = 0;

        EHOSTDOWN = 0;
        EHOSTUNREACH = 0;
        EHWPOISON = IntDefine.UNDEFINED;

        EIDRM = 0;
        EINPROGRESS = 0;
        EINTR = 0;
        EINVAL = 0;
        EIO = 0;
        EISCONN = 0;
        EISDIR = 0;
        EISNAM = IntDefine.UNDEFINED;

        EKEYEXPIRED = IntDefine.UNDEFINED;
        EKEYREJECTED = IntDefine.UNDEFINED;
        EKEYREVOKED = IntDefine.UNDEFINED;

        EL2HLT = IntDefine.UNDEFINED;
        EL2NSYNC = IntDefine.UNDEFINED;
        EL3HLT = IntDefine.UNDEFINED;
        EL3RST = IntDefine.UNDEFINED;
        ELIBACC = IntDefine.UNDEFINED;
        ELIBBAD = IntDefine.UNDEFINED;
        ELIBEXEC = IntDefine.UNDEFINED;
        ELIBMAX = IntDefine.UNDEFINED;
        ELIBSCN = IntDefine.UNDEFINED;
        ELNRNG = IntDefine.UNDEFINED;
        ELOOP = 0;

        EMEDIUMTYPE = IntDefine.UNDEFINED;
        EMFILE = 0;
        EMLINK = 0;
        EMSGSIZE = 0;
        EMULTIHOP = IntDefine.UNDEFINED;

        ENAMETOOLONG = 0;
        ENAVAIL = IntDefine.UNDEFINED;
        ENETDOWN = 0;
        ENETRESET = 0;
        ENETUNREACH = 0;
        ENFILE = 0;
        ENOANO = IntDefine.UNDEFINED;
        ENOBUFS = 0;
        ENOCSI = IntDefine.UNDEFINED;
        ENODATA = IntDefine.UNDEFINED;
        ENODEV = 0;
        ENOENT = 0;
        ENOEXEC = 0;
        ENOKEY = IntDefine.UNDEFINED;
        ENOLCK = 0;
        ENOLINK = IntDefine.UNDEFINED;
        ENOMEDIUM = IntDefine.UNDEFINED;
        ENOMEM = 0;
        ENOMSG = 0;
        ENONET = IntDefine.UNDEFINED;
        ENOPKG = IntDefine.UNDEFINED;
        ENOPROTOOPT = 0;
        ENOSPC = 0;
        ENOSR = IntDefine.UNDEFINED;
        ENOSTR = IntDefine.UNDEFINED;
        ENOSYS = 0;
        ENOTBLK = 0;
        ENOTCONN = 0;
        ENOTDIR = 0;
        ENOTEMPTY = 0;
        ENOTNAM = IntDefine.UNDEFINED;
        ENOTRECOVERABLE = 0;
        ENOTSOCK = 0;
        ENOTSUP = 0;
        ENOTTY = 0;
        ENOTUNIQ = IntDefine.UNDEFINED;
        ENXIO = 0;

        EOPNOTSUPP = 0;
        EOVERFLOW = 0;
        EOWNERDEAD = 0;

        EPERM = 0;
        EPFNOSUPPORT = 0;
        EPIPE = 0;
        EPROTO = 0;
        EPROTONOSUPPORT = 0;
        EPROTOTYPE = 0;

        EREMCHG = IntDefine.UNDEFINED;
        EREMOTE = 0;
        EREMOTEIO = IntDefine.UNDEFINED;
        ERESTART = IntDefine.UNDEFINED;
        ERFKILL = IntDefine.UNDEFINED;
        EROFS = 0;

        ESHUTDOWN = 0;
        ESOCKTNOSUPPORT = 0;
        ESPIPE = 0;
        ESRCH = 0;
        ESRMNT = IntDefine.UNDEFINED;
        ESTALE = 0;
        ESTRPIPE = IntDefine.UNDEFINED;

        ETIME = IntDefine.UNDEFINED;
        ETIMEDOUT = 0;
        ETOOMANYREFS = 0;
        ETXTBSY = 0;

        EUCLEAN = IntDefine.UNDEFINED;
        EUNATCH = IntDefine.UNDEFINED;
        EUSERS = 0;

        EWOULDBLOCK = 0;

        EXDEV = 0;
        EXFULL = IntDefine.UNDEFINED;

        initFields();
    }

    private static native void initFields();

    /**
     * <b>POSIX:</b> Argument list too long.
     *
     */
    @Define
    public final static int E2BIG;

    /**
     * <b>POSIX:</b> Permission denied.
     *
     */
    @Define
    public final static int EACCES;

    /**
     * <b>POSIX:</b> Address in use.
     *
     */
    @Define
    public final static int EADDRINUSE;

    /**
     * <b>POSIX:</b> Address not available.
     *
     */
    @Define
    public final static int EADDRNOTAVAIL;

    /**
     * <b>Non POSIX:</b> Advertise error.
     *
     */
    @Define
    public final static IntDefine EADV;

    /**
     * <b>POSIX:</b> Address family not supported.
     *
     */
    @Define
    public final static int EAFNOSUPPORT;

    /**
     * <b>POSIX:</b> Resource unavailable, try again (may be the same value as
     * [EWOULDBLOCK]).
     *
     */
    @Define
    public final static int EAGAIN;

    /**
     * <b>POSIX:</b> Connection already in progress.
     *
     */
    @Define
    public final static int EALREADY;

    /**
     * <b>Linux:</b> Invalid exchange.
     *
     */
    @Define
    public final static IntDefine EBADE;

    /**
     * <b>POSIX:</b> Bad file descriptor.
     *
     */
    @Define
    public final static int EBADF;

    /**
     * <b>Linux:</b> File descriptor in bad state.
     *
     */
    @Define
    public final static IntDefine EBADFD;

    /**
     * <b>POSIX:</b> Bad message.
     *
     */
    @Define
    public final static int EBADMSG;

    /**
     * <b>Linux:</b> Invalid request descriptor.
     *
     */
    @Define
    public final static IntDefine EBADR;

    /**
     * <b>Linux:</b> Invalid request code.
     *
     */
    @Define
    public final static IntDefine EBADRQC;

    /**
     * <b>Linux:</b> Invalid slot.
     *
     */
    @Define
    public final static IntDefine EBADSLT;

    /**
     * <b>Linux:</b> Bad font file format
     *
     */
    @Define
    public final static IntDefine EBFONT;

    /**
     * POSIX Device or resource busy.
     *
     */
    @Define
    public final static int EBUSY;

    /**
     * <b>POSIX:</b> Operation canceled.
     *
     */
    @Define
    public final static int ECANCELED;

    /**
     * <b>POSIX:</b> No child processes.
     *
     */
    @Define
    public final static int ECHILD;

    /**
     * <b>Linux:</b> Channel number out of range.
     *
     */
    @Define
    public final static IntDefine ECHRNG;

    /**
     * <b>Linux:</b> Communication error on send.
     *
     */
    @Define
    public final static IntDefine ECOMM;

    /**
     * <b>POSIX:</b> Connection aborted.
     *
     */
    @Define
    public final static int ECONNABORTED;

    /**
     * <b>POSIX:</b> Connection refused.
     *
     */
    @Define
    public final static int ECONNREFUSED;

    /**
     * <b>POSIX:</b> Connection reset.
     *
     */
    @Define
    public final static int ECONNRESET;

    /**
     * <b>POSIX:</b> Resource deadlock would occur.
     *
     */
    @Define
    public final static int EDEADLK;

    /**
     * <b>Linux:</b> @see(EDEADLK)
     *
     */
    @Define
    public final static IntDefine EDEADLOCK;

    /**
     * <b>POSIX:</b> Destination address required.
     *
     */
    @Define
    public final static int EDESTADDRREQ;

    /**
     * <b>Linux:</b> RFS specific error.
     *
     */
    @Define
    public final static IntDefine EDOTDOT;

    /**
     * <b>POSIX:</b> Reserved.
     *
     */
    @Define
    public final static int EDQUOT;

    /**
     * <b>POSIX:</b> File exists.
     *
     */
    @Define
    public final static int EEXIST;

    /**
     * <b>POSIX:</b> Bad address.
     *
     */
    @Define
    public final static int EFAULT;

    /**
     * <b>POSIX:</b> File too large.
     *
     */
    @Define
    public final static int EFBIG;

    /**
     * <b>Non POSIX:</b> Host is down.
     *
     */
    @Define
    public final static int EHOSTDOWN;

    /**
     * <b>POSIX:</b> Host is unreachable.
     *
     */
    @Define
    public final static int EHOSTUNREACH;

    /**
     * <b>Linux:</b> Memory page has hardware error.
     *
     */
    @Define
    public final static IntDefine EHWPOISON;

    /**
     * <b>POSIX:</b> Identifier removed.
     *
     */
    @Define
    public final static int EIDRM;

    /**
     * <b>POSIX:</b> Operation in progress.
     *
     */
    @Define
    public final static int EINPROGRESS;

    /**
     * <b>POSIX:</b> Interrupted function.
     *
     */
    @Define
    public final static int EINTR;

    /**
     * <b>POSIX:</b> Invalid argument.
     *
     */
    @Define
    public final static int EINVAL;

    /**
     * <b>POSIX:</b> I/O error.
     *
     */
    @Define
    public final static int EIO;

    /**
     * <b>POSIX:</b> Socket is connected.
     *
     */
    @Define
    public final static int EISCONN;

    /**
     * <b>POSIX:</b> Is a directory.
     *
     */
    @Define
    public final static int EISDIR;

    /**
     * <b>Linux:</b> Is a named type file.
     *
     */
    @Define
    public final static IntDefine EISNAM;

    /**
     * <b>Linux:</b> Key has expired.
     *
     */
    @Define
    public final static IntDefine EKEYEXPIRED;

    /**
     * <b>Linux:</b> Key was rejected by service.
     *
     */
    @Define
    public final static IntDefine EKEYREJECTED;

    /**
     * <b>Linux:</b> Key has been revoked.
     *
     */
    @Define
    public final static IntDefine EKEYREVOKED;

    /**
     * <b>Linux:</b> evel 2 halted.
     *
     */
    @Define
    public final static IntDefine EL2HLT;

    /**
     * <b>Linux:</b> Level 2 not synchronized.
     *
     */
    @Define
    public final static IntDefine EL2NSYNC;

    /**
     * <b>Linux:</b> Level 3 halted.
     *
     */
    @Define
    public final static IntDefine EL3HLT;

    /**
     * <b>Linux:</b> Level 3 reset.
     *
     */
    @Define
    public final static IntDefine EL3RST;

    /**
     * <b>Linux:</b> Can not access a needed shared library.
     *
     */
    @Define
    public final static IntDefine ELIBACC;

    /**
     * <b>Linux:</b> Accessing a corrupted shared library.
     *
     */
    @Define
    public final static IntDefine ELIBBAD;

    /**
     * <b>Linux:</b> Cannot exec a shared library directly.
     *
     */
    @Define
    public final static IntDefine ELIBEXEC;

    /**
     * <b>Linux:</b> Attempting to link in too many shared libraries.
     *
     */
    @Define
    public final static IntDefine ELIBMAX;

    /**
     * <b>Linux:</b> .lib section in a.out corrupted.
     *
     */
    @Define
    public final static IntDefine ELIBSCN;

    /**
     * <b>Linux:</b> Link number out of range.
     *
     */
    @Define
    public final static IntDefine ELNRNG;

    /**
     * <b>POSIX:</b> Too many levels of symbolic links.
     *
     */
    @Define
    public final static int ELOOP;

    /**
     * <b>Linux:</b> Wrong medium type.
     *
     */
    @Define
    public final static IntDefine EMEDIUMTYPE;

    /**
     * <b>POSIX:</b> File descriptor value too large.
     *
     */
    @Define
    public final static int EMFILE;

    /**
     * <b>POSIX:</b> Too many links.
     *
     */
    @Define
    public final static int EMLINK;

    /**
     * <b>POSIX:</b> Message too large.
     *
     */
    @Define
    public final static int EMSGSIZE;

    /**
     * <b>POSIX:</b> Reserved.
     *
     */
    @Define
    public final static IntDefine EMULTIHOP;

    /**
     * <b>POSIX:</b> Filename too long.
     *
     */
    @Define
    public final static int ENAMETOOLONG;

    /**
     * <b>Linux:</b> No XENIX semaphores available.
     *
     */
    @Define
    public final static IntDefine ENAVAIL;

    /**
     * <b>POSIX:</b> Network is down.
     *
     */
    @Define
    public final static int ENETDOWN;

    /**
     * <b>POSIX:</b> Connection aborted by network.
     *
     */
    @Define
    public final static int ENETRESET;

    /**
     * <b>POSIX:</b> Network unreachable.
     *
     */
    @Define
    public final static int ENETUNREACH;

    /**
     * <b>POSIX:</b> Too many files open in system.
     *
     */
    @Define
    public final static int ENFILE;

    /**
     * <b>Linux:</b> No anode.
     *
     */
    @Define
    public final static IntDefine ENOANO;

    /**
     * <b>POSIX:</b> No buffer space available.
     *
     */
    @Define
    public final static int ENOBUFS;

    /**
     * <b>Linux:</b> No CSI structure available.
     *
     */
    @Define
    public final static IntDefine ENOCSI;

    /**
     * <b>POSIX.XSI:</b> No message is available on the STREAM head read queue.
     *
     */
    @Define
    public final static IntDefine ENODATA;

    /**
     * <b>POSIX:</b> No such device.
     *
     */
    @Define
    public final static int ENODEV;

    /**
     * <b>POSIX:</b> No such file or directory.
     *
     */
    @Define
    public final static int ENOENT;

    /**
     * <b>POSIX:</b> Executable file format error.
     *
     */
    @Define
    public final static int ENOEXEC;

    /**
     * <b>Linux:</b> Required key not available
     *
     */
    @Define
    public final static IntDefine ENOKEY;

    /**
     * <b>POSIX:</b> No locks available.
     *
     */
    @Define
    public final static int ENOLCK;

    /**
     * <b>POSIX:</b> Reserved.
     *
     */
    @Define
    public final static IntDefine ENOLINK;

    /**
     * <b>Linux:</b> No medium found.
     *
     */
    @Define
    public final static IntDefine ENOMEDIUM;

    /**
     * <b>POSIX:</b> Not enough space.
     *
     */
    @Define
    public final static int ENOMEM;

    /**
     * <b>POSIX:</b> No message of the desired type.
     *
     */
    @Define
    public final static int ENOMSG;

    /**
     * <b>Linux:</b> Machine is not on the network.
     *
     */
    @Define
    public final static IntDefine ENONET;

    /**
     * <b>Linux:</b> Package not installed.
     *
     */
    @Define
    public final static IntDefine ENOPKG;

    /**
     * <b>POSIX:</b> Protocol not available.
     *
     */
    @Define
    public final static int ENOPROTOOPT;

    /**
     * <b>POSIX:</b> No space left on device.
     *
     */
    @Define
    public final static int ENOSPC;

    /**
     * <b>POSIX.XSI:</b> No STREAM resources.
     *
     */
    @Define
    public final static IntDefine ENOSR;

    /**
     * <b>POSIX.XSI:</b> Not a STREAM.
     *
     */
    @Define
    public final static IntDefine ENOSTR;

    /**
     * <b>POSIX:</b> Functionality not supported.
     *
     */
    @Define
    public final static int ENOSYS;

    /**
     * <b>Non POSIX:</b> Block device required.
     *
     */
    @Define
    public final static int ENOTBLK;

    /**
     * <b>POSIX:</b> The socket is not connected.
     *
     */
    @Define
    public final static int ENOTCONN;

    /**
     * <b>POSIX:</b> Not a directory or a symbolic link to a directory.
     *
     */
    @Define
    public final static int ENOTDIR;

    /**
     * <b>POSIX:</b> Directory not empty.
     *
     */
    @Define
    public final static int ENOTEMPTY;

    /**
     * <b>Linux:</b> Not a XENIX named type file.
     *
     */
    @Define
    public final static IntDefine ENOTNAM;

    /**
     * <b>POSIX:</b> State not recoverable.
     *
     */
    @Define
    public final static int ENOTRECOVERABLE;

    /**
     * <b>POSIX:</b> Not a socket.
     *
     */
    @Define
    public final static int ENOTSOCK;

    /**
     * <b>Non POSIX:</b> Not supported (may be the same value as [@see
     * EOPNOTSUPP]).
     *
     */
    @Define
    public final static int ENOTSUP;

    /**
     * <b>POSIX:</b> Inappropriate I/O control operation.
     *
     */
    @Define
    public final static int ENOTTY;

    /**
     * <b>Linux:</b> Name not unique on network.
     *
     */
    @Define
    public final static IntDefine ENOTUNIQ;

    /**
     * <b>POSIX:</b> No such device or address.
     *
     */
    @Define
    public final static int ENXIO;

    /**
     * <b>POSIX:</b> Operation not supported on socket (may be the same value as
     * [@see ENOTSUP]).
     *
     */
    @Define
    public final static int EOPNOTSUPP;

    /**
     * <b>POSIX:</b> Value too large to be stored in data type.
     *
     */
    @Define
    public final static int EOVERFLOW;

    /**
     * <b>POSIX:</b> Previous owner died.
     *
     */
    @Define
    public final static int EOWNERDEAD;

    /**
     * <b>POSIX:</b> Operation not permitted.
     *
     */
    @Define
    public final static int EPERM;

    /**
     * <b>Non POSIX:</b> Protocol family not supported.
     *
     */
    @Define
    public final static int EPFNOSUPPORT;

    /**
     * <b>POSIX:</b> Broken pipe.
     *
     */
    @Define
    public final static int EPIPE;

    /**
     * <b>POSIX:</b> Protocol error.
     *
     */
    @Define
    public final static int EPROTO;

    /**
     * <b>POSIX:</b> Protocol not supported.
     *
     */
    @Define
    public final static int EPROTONOSUPPORT;

    /**
     * <b>POSIX:</b> Protocol wrong type for socket.
     *
     */
    @Define
    public final static int EPROTOTYPE;

    /**
     * <b>Linux:</b> Remote address changed.
     *
     */
    @Define
    public final static IntDefine EREMCHG;

    /**
     * <b>Non POSIX:</b> Object is remote
     *
     */
    @Define
    public final static int EREMOTE;

    /**
     * <b>Linux:</b> Remote I/O error.
     *
     */
    @Define
    public final static IntDefine EREMOTEIO;

    /**
     * <b>Linux:</b> Interrupted system call should be restarted.
     *
     */
    @Define
    public final static IntDefine ERESTART;

    /**
     * <b>Linux:</b> Operation not possible due to RF-kill.
     *
     */
    @Define
    public final static IntDefine ERFKILL;

    /**
     * <b>POSIX:</b> Read-only file system.
     *
     */
    @Define
    public final static int EROFS;

    /**
     * <b>Non POSIX:</b> Cannot send after transport endpoint shutdown.
     *
     */
    @Define
    public final static int ESHUTDOWN;

    /**
     * <b>Non POSIX:</b> Socket type not supported
     *
     */
    @Define
    public final static int ESOCKTNOSUPPORT;

    /**
     * <b>POSIX:</b> Invalid seek.
     *
     */
    @Define
    public final static int ESPIPE;

    /**
     * <b>POSIX:</b> No such process.
     *
     */
    @Define
    public final static int ESRCH;

    /**
     * <b>Linux:</b> Srmount error.
     *
     */
    @Define
    public final static IntDefine ESRMNT;

    /**
     * <b>POSIX:</b> Reserved.
     *
     */
    @Define
    public final static int ESTALE;

    /**
     * <b>Linux:</b> Streams pipe error.
     *
     */
    @Define
    public final static IntDefine ESTRPIPE;

    /**
     * <b>POSIX:</b> Stream @see ioctl_H.ioctl() timeout.
     *
     */
    @Define
    public final static IntDefine ETIME;

    /**
     * <b>POSIX:</b> Connection timed out.
     *
     */
    @Define
    public final static int ETIMEDOUT;

    /**
     * <b>Non POSIX:</b> Too many references: cannot splice.
     *
     */
    @Define
    public final static int ETOOMANYREFS;

    /**
     * <b>POSIX:</b> Text file busy.
     *
     */
    @Define
    public final static int ETXTBSY;

    /**
     * <b>Linux:</b> Structure needs cleaning.
     *
     */
    @Define
    public final static IntDefine EUCLEAN;

    /**
     * <b>Linux:</b> Protocol driver not attached.
     *
     */
    @Define
    public final static IntDefine EUNATCH;

    /**
     * <b>Non POSIX:</b> Too many users.
     *
     */
    @Define
    public final static int EUSERS;

    /**
     * <b>POSIX:</b> Operation would block (may be the same value as [@see
     * EAGAIN]).
     *
     */
    @Define
    public final static int EWOULDBLOCK;

    /**
     * <b>POSIX:</b> Cross-device link.
     *
     */
    @Define
    public final static int EXDEV;

    /**
     * <b>Linux:</b> Exchange full.
     *
     */
    @Define
    public final static IntDefine EXFULL;

    /**
     * Translate the native errno to its symbolic constant name.
     *
     * @param errno
     * @return
     */
    public final static String getErrnoSymbol(int errno) {
        for (Field f : Errno.class.getFields()) {
            if (f.getAnnotation(Define.class) != IntDefine.UNDEFINED) {
                try {
                    Object res = (Object) f.get(Errno.class);
                    if (res instanceof Integer) {
                        if (errno == ((Integer) res)) {
                            return f.getName();
                        } else if (res instanceof IntDefine) {
                            final IntDefine i = (IntDefine) res;
                            if (i.isDefined()) {
                                if (errno == i.get()) {
                                    return f.getName();
                                }
                            }
                        }
                    }
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(Errno.class.getName()).log(Level.SEVERE, "Unknown ex in Errno.getErrnoSymbol(int)", ex);
                }
            }
        }
        return "Unknown errno: " + errno;
    }

    protected Errno() {

    }

}
