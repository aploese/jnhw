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

    public static class LinuxDefines {

        public final static int E2BIG = 1;

        public final static int EACCES = 13;
        public final static int EADDRINUSE = 98;
        public final static int EADDRNOTAVAIL = 99;
        public final static int EADV = 68;
        public final static int EAFNOSUPPORT = 97;
        public final static int EAGAIN = 11;
        public final static int EALREADY = 114;

        public final static int EBADE = 52;
        public final static int EBADF = 9;
        public final static int EBADFD = 77;
        public final static int EBADMSG = 74;
        public final static int EBADR = 53;
        public final static int EBADRQC = 56;
        public final static int EBADSLT = 57;
        public final static int EBFONT = 59;
        public final static int EBUSY = 16;

        public final static int ECANCELED = 125;
        public final static int ECHILD = 10;
        public final static int ECHRNG = 44;
        public final static int ECOMM = 70;
        public final static int ECONNABORTED = 103;
        public final static int ECONNREFUSED = 111;
        public final static int ECONNRESET = 104;

        public final static int EDEADLK = 35;
        public final static int EDEADLOCK = 35;
        public final static int EDESTADDRREQ = 89;
        public final static int EDOTDOT = 73;
        public final static int EDQUOT = 122;

        public final static int EEXIST = 17;

        public final static int EFAULT = 14;
        public final static int EFBIG = 27;

        public final static int EHOSTDOWN = 112;
        public final static int EHOSTUNREACH = 113;
        public final static int EHWPOISON = 133;

        public final static int EIDRM = 43;
        public final static int EINPROGRESS = 115;
        public final static int EINTR = 4;
        public final static int EINVAL = 22;
        public final static int EIO = 5;
        public final static int EISCONN = 106;
        public final static int EISDIR = 21;
        public final static int EISNAM = 120;

        public final static int EKEYEXPIRED = 127;
        public final static int EKEYREJECTED = 129;
        public final static int EKEYREVOKED = 128;

        public final static int EL2HLT = 51;
        public final static int EL2NSYNC = 45;
        public final static int EL3HLT = 46;
        public final static int EL3RST = 47;
        public final static int ELIBACC = 79;
        public final static int ELIBBAD = 80;
        public final static int ELIBEXEC = 83;
        public final static int ELIBMAX = 82;
        public final static int ELIBSCN = 81;
        public final static int ELNRNG = 48;
        public final static int ELOOP = 40;

        public final static int EMEDIUMTYPE = 124;
        public final static int EMFILE = 24;
        public final static int EMLINK = 31;
        public final static int EMSGSIZE = 90;
        public final static int EMULTIHOP = 72;

        public final static int ENAMETOOLONG = 36;
        public final static int ENAVAIL = 119;
        public final static int ENETDOWN = 100;
        public final static int ENETRESET = 102;
        public final static int ENETUNREACH = 101;
        public final static int ENFILE = 23;
        public final static int ENOANO = 55;
        public final static int ENOBUFS = 105;
        public final static int ENOCSI = 50;
        public final static int ENODATA = 61;
        public final static int ENODEV = 19;
        public final static int ENOENT = 2;
        public final static int ENOEXEC = 8;
        public final static int ENOKEY = 126;
        public final static int ENOLCK = 37;
        public final static int ENOLINK = 67;
        public final static int ENOMEDIUM = 123;
        public final static int ENOMEM = 12;
        public final static int ENOMSG = 42;
        public final static int ENONET = 64;
        public final static int ENOPKG = 65;
        public final static int ENOPROTOOPT = 92;
        public final static int ENOSPC = 28;
        public final static int ENOSR = 63;
        public final static int ENOSTR = 60;
        public final static int ENOSYS = 38;
        public final static int ENOTBLK = 15;
        public final static int ENOTCONN = 107;
        public final static int ENOTDIR = 20;
        public final static int ENOTEMPTY = 39;
        public final static int ENOTNAM = 118;
        public final static int ENOTRECOVERABLE = 131;
        public final static int ENOTSOCK = 88;
        public final static int ENOTSUP = 95;
        public final static int ENOTTY = 25;
        public final static int ENOTUNIQ = 76;
        public final static int ENXIO = 6;

        public final static int EOPNOTSUPP = 95;
        public final static int EOVERFLOW = 75;
        public final static int EOWNERDEAD = 130;

        public final static int EPERM = 1;
        public final static int EPFNOSUPPORT = 96;
        public final static int EPIPE = 32;
        public final static int EPROTO = 71;
        public final static int EPROTONOSUPPORT = 93;
        public final static int EPROTOTYPE = 91;

        public final static int EREMCHG = 78;
        public final static int EREMOTE = 66;
        public final static int EREMOTEIO = 121;
        public final static int ERESTART = 85;
        public final static int ERFKILL = 132;
        public final static int EROFS = 30;

        public final static int ESHUTDOWN = 108;
        public final static int ESOCKTNOSUPPORT = 94;
        public final static int ESPIPE = 29;
        public final static int ESRCH = 3;
        public final static int ESRMNT = 69;
        public final static int ESTALE = 116;
        public final static int ESTRPIPE = 86;

        public final static int ETIME = 62;
        public final static int ETIMEDOUT = 110;
        public final static int ETOOMANYREFS = 109;
        public final static int ETXTBSY = 26;

        public final static int EUCLEAN = 117;
        public final static int EUNATCH = 49;
        public final static int EUSERS = 87;

        public final static int EWOULDBLOCK = 11;

        public final static int EXDEV = 18;
        public final static int EXFULL = 54;

    }

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();

        switch (LibJnhwPosixLoader.getLoadResult().multiarchInfo.getOS()) {
            case LINUX:
                E2BIG = LinuxDefines.E2BIG;

                EACCES = LinuxDefines.EACCES;
                EADDRINUSE = LinuxDefines.EADDRINUSE;
                EADDRNOTAVAIL = LinuxDefines.EADDRNOTAVAIL;
                EADV = IntDefine.toIntDefine(LinuxDefines.EADV);

                EAFNOSUPPORT = LinuxDefines.EAFNOSUPPORT;
                EAGAIN = LinuxDefines.EAGAIN;
                EALREADY = LinuxDefines.EALREADY;

                EBADE = IntDefine.toIntDefine(LinuxDefines.EBADE);
                EBADF = LinuxDefines.EBADF;
                EBADFD = IntDefine.toIntDefine(LinuxDefines.EBADFD);

                EBADMSG = LinuxDefines.EBADMSG;
                EBADR = IntDefine.toIntDefine(LinuxDefines.EBADR);

                EBADRQC = IntDefine.toIntDefine(LinuxDefines.EBADRQC);

                EBADSLT = IntDefine.toIntDefine(LinuxDefines.EBADSLT);

                EBFONT = IntDefine.toIntDefine(LinuxDefines.EBFONT);

                EBUSY = LinuxDefines.EBUSY;

                ECANCELED = LinuxDefines.ECANCELED;
                ECHILD = LinuxDefines.ECHILD;
                ECHRNG = IntDefine.toIntDefine(LinuxDefines.ECHRNG);

                ECOMM = IntDefine.toIntDefine(LinuxDefines.ECOMM);

                ECONNABORTED = LinuxDefines.ECONNABORTED;
                ECONNREFUSED = LinuxDefines.ECONNREFUSED;
                ECONNRESET = LinuxDefines.ECONNRESET;

                EDEADLK = LinuxDefines.EDEADLK;
                EDEADLOCK = IntDefine.toIntDefine(LinuxDefines.EDEADLOCK);

                EDESTADDRREQ = LinuxDefines.EDESTADDRREQ;
                EDOTDOT = IntDefine.toIntDefine(LinuxDefines.EDOTDOT);

                EDQUOT = LinuxDefines.EDQUOT;

                EEXIST = LinuxDefines.EEXIST;

                EFAULT = LinuxDefines.EFAULT;
                EFBIG = LinuxDefines.EFBIG;

                EHOSTDOWN = LinuxDefines.EHOSTDOWN;
                EHOSTUNREACH = LinuxDefines.EHOSTUNREACH;
                EHWPOISON = IntDefine.toIntDefine(LinuxDefines.EHWPOISON);

                EIDRM = LinuxDefines.EIDRM;
                EINPROGRESS = LinuxDefines.EINPROGRESS;
                EINTR = LinuxDefines.EINTR;
                EINVAL = LinuxDefines.EINVAL;
                EIO = LinuxDefines.EIO;
                EISCONN = LinuxDefines.EISCONN;
                EISDIR = LinuxDefines.EISDIR;
                EISNAM = IntDefine.toIntDefine(LinuxDefines.EISNAM);

                EKEYEXPIRED = IntDefine.toIntDefine(LinuxDefines.EKEYEXPIRED);

                EKEYREJECTED = IntDefine.toIntDefine(LinuxDefines.EKEYREJECTED);

                EKEYREVOKED = IntDefine.toIntDefine(LinuxDefines.EKEYREVOKED);

                EL2HLT = IntDefine.toIntDefine(LinuxDefines.EL2HLT);

                EL2NSYNC = IntDefine.toIntDefine(LinuxDefines.EL2NSYNC);

                EL3HLT = IntDefine.toIntDefine(LinuxDefines.EL3HLT);

                EL3RST = IntDefine.toIntDefine(LinuxDefines.EL3RST);

                ELIBACC = IntDefine.toIntDefine(LinuxDefines.ELIBACC);

                ELIBBAD = IntDefine.toIntDefine(LinuxDefines.ELIBBAD);

                ELIBEXEC = IntDefine.toIntDefine(LinuxDefines.ELIBEXEC);

                ELIBMAX = IntDefine.toIntDefine(LinuxDefines.ELIBMAX);

                ELIBSCN = IntDefine.toIntDefine(LinuxDefines.ELIBSCN);

                ELNRNG = IntDefine.toIntDefine(LinuxDefines.ELNRNG);

                ELOOP = LinuxDefines.ELOOP;

                EMEDIUMTYPE = IntDefine.toIntDefine(LinuxDefines.EMEDIUMTYPE);

                EMFILE = LinuxDefines.EMFILE;
                EMLINK = LinuxDefines.EMLINK;
                EMSGSIZE = LinuxDefines.EMSGSIZE;
                EMULTIHOP = IntDefine.toIntDefine(LinuxDefines.EMULTIHOP);

                ENAMETOOLONG = LinuxDefines.ENAMETOOLONG;
                ENAVAIL = IntDefine.toIntDefine(LinuxDefines.ENAVAIL);

                ENETDOWN = LinuxDefines.ENETDOWN;
                ENETRESET = LinuxDefines.ENETRESET;
                ENETUNREACH = LinuxDefines.ENETUNREACH;
                ENFILE = LinuxDefines.ENFILE;
                ENOANO = IntDefine.toIntDefine(LinuxDefines.ENOANO);

                ENOBUFS = LinuxDefines.ENOBUFS;
                ENOCSI = IntDefine.toIntDefine(LinuxDefines.ENOCSI);

                ENODATA = IntDefine.toIntDefine(LinuxDefines.ENODATA);

                ENODEV = LinuxDefines.ENODEV;
                ENOENT = LinuxDefines.ENOENT;
                ENOEXEC = LinuxDefines.ENOEXEC;
                ENOKEY = IntDefine.toIntDefine(LinuxDefines.ENOKEY);

                ENOLCK = LinuxDefines.ENOLCK;
                ENOLINK = IntDefine.toIntDefine(LinuxDefines.ENOLINK);

                ENOMEDIUM = IntDefine.toIntDefine(LinuxDefines.ENOMEDIUM);

                ENOMEM = LinuxDefines.ENOMEM;
                ENOMSG = LinuxDefines.ENOMSG;
                ENONET = IntDefine.toIntDefine(LinuxDefines.ENONET);

                ENOPKG = IntDefine.toIntDefine(LinuxDefines.ENOPKG);

                ENOPROTOOPT = LinuxDefines.ENOPROTOOPT;
                ENOSPC = LinuxDefines.ENOSPC;
                ENOSR = IntDefine.toIntDefine(LinuxDefines.ENOSR);

                ENOSTR = IntDefine.toIntDefine(LinuxDefines.ENOSTR);

                ENOSYS = LinuxDefines.ENOSYS;
                ENOTBLK = LinuxDefines.ENOTBLK;
                ENOTCONN = LinuxDefines.ENOTCONN;
                ENOTDIR = LinuxDefines.ENOTDIR;
                ENOTEMPTY = LinuxDefines.ENOTEMPTY;
                ENOTNAM = IntDefine.toIntDefine(LinuxDefines.ENOTNAM);

                ENOTRECOVERABLE = LinuxDefines.ENOTRECOVERABLE;
                ENOTSOCK = LinuxDefines.ENOTSOCK;
                ENOTSUP = LinuxDefines.ENOTSUP;
                ENOTTY = LinuxDefines.ENOTTY;
                ENOTUNIQ = IntDefine.toIntDefine(LinuxDefines.ENOTUNIQ);

                ENXIO = LinuxDefines.ENXIO;

                EOPNOTSUPP = LinuxDefines.EOPNOTSUPP;
                EOVERFLOW = LinuxDefines.EOVERFLOW;
                EOWNERDEAD = LinuxDefines.EOWNERDEAD;

                EPERM = LinuxDefines.EPERM;
                EPFNOSUPPORT = LinuxDefines.EPFNOSUPPORT;
                EPIPE = LinuxDefines.EPIPE;
                EPROTO = LinuxDefines.EPROTO;
                EPROTONOSUPPORT = LinuxDefines.EPROTONOSUPPORT;
                EPROTOTYPE = LinuxDefines.EPROTOTYPE;

                EREMCHG = IntDefine.toIntDefine(LinuxDefines.EREMCHG);

                EREMOTE = LinuxDefines.EREMOTE;
                EREMOTEIO = IntDefine.toIntDefine(LinuxDefines.EREMOTEIO);

                ERESTART = IntDefine.toIntDefine(LinuxDefines.ERESTART);

                ERFKILL = IntDefine.toIntDefine(LinuxDefines.ERFKILL);

                EROFS = LinuxDefines.EROFS;

                ESHUTDOWN = LinuxDefines.ESHUTDOWN;
                ESOCKTNOSUPPORT = LinuxDefines.ESOCKTNOSUPPORT;
                ESPIPE = LinuxDefines.ESPIPE;
                ESRCH = LinuxDefines.ESRCH;
                ESRMNT = IntDefine.toIntDefine(LinuxDefines.ESRMNT);

                ESTALE = LinuxDefines.ESTALE;
                ESTRPIPE = IntDefine.toIntDefine(LinuxDefines.ESTRPIPE);

                ETIME = IntDefine.toIntDefine(LinuxDefines.ETIME);

                ETIMEDOUT = LinuxDefines.ETIMEDOUT;
                ETOOMANYREFS = LinuxDefines.ETOOMANYREFS;
                ETXTBSY = LinuxDefines.ETXTBSY;

                EUCLEAN = IntDefine.toIntDefine(LinuxDefines.EUCLEAN);

                EUNATCH = IntDefine.toIntDefine(LinuxDefines.EUNATCH);

                EUSERS = LinuxDefines.EUSERS;

                EWOULDBLOCK = LinuxDefines.EWOULDBLOCK;

                EXDEV = LinuxDefines.EXDEV;
                EXFULL = IntDefine.toIntDefine(LinuxDefines.EXFULL);

                break;
            default:
                throw new NoClassDefFoundError("No fcntl.h defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
        }
    }

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
            if (f.getAnnotation(Define.class) != null) {
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
