/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.util.IntDefine;
import de.ibapl.jnhw.libloader.MultiarchInfo;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
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

    public static interface BsdDefines {

        public final static int EACCES = 13;
        public final static int EADDRINUSE = 48;
        public final static int EADDRNOTAVAIL = 49;
        public final static int EAFNOSUPPORT = 47;
        public final static int EAGAIN = 35;
        public final static int EALREADY = 37;
        public final static int EBADF = 9;
        public final static int EBUSY = 16;
        public final static int ECHILD = 10;
        public final static int ECONNABORTED = 53;
        public final static int ECONNREFUSED = 61;
        public final static int ECONNRESET = 54;
        public final static int EDEADLK = 11;
        public final static int EDESTADDRREQ = 39;
        public final static int EDQUOT = 69;
        public final static int EEXIST = 17;
        public final static int EFAULT = 14;
        public final static int EFBIG = 27;
        public final static int EHOSTDOWN = 64;
        public final static int EHOSTUNREACH = 65;
        public final static int EINPROGRESS = 36;
        public final static int EINTR = 4;
        public final static int EINVAL = 22;
        public final static int EIO = 5;
        public final static int EISCONN = 56;
        public final static int EISDIR = 21;
        public final static int ELOOP = 62;
        public final static int EMFILE = 24;
        public final static int EMLINK = 31;
        public final static int EMSGSIZE = 40;
        public final static int ENAMETOOLONG = 63;
        public final static int ENETDOWN = 50;
        public final static int ENETRESET = 52;
        public final static int ENETUNREACH = 51;
        public final static int ENFILE = 23;
        public final static int ENOBUFS = 55;
        public final static int ENODEV = 19;
        public final static int ENOENT = 2;
        public final static int ENOEXEC = 8;
        public final static int ENOLCK = 77;
        public final static int ENOMEM = 12;
        public final static int ENOPROTOOPT = 42;
        public final static int ENOSPC = 28;
        public final static int ENOSYS = 78;
        public final static int ENOTBLK = 15;
        public final static int ENOTCONN = 57;
        public final static int ENOTDIR = 20;
        public final static int ENOTEMPTY = 66;
        public final static int ENOTSOCK = 38;
        public final static int ENOTTY = 25;
        public final static int ENXIO = 6;
        public final static int EPERM = 1;
        public final static int EPFNOSUPPORT = 46;
        public final static int EPIPE = 32;
        public final static int EPROTONOSUPPORT = 43;
        public final static int EPROTOTYPE = 41;
        public final static int EREMOTE = 71;
        public final static int EROFS = 30;
        public final static int ESHUTDOWN = 58;
        public final static int ESOCKTNOSUPPORT = 44;
        public final static int ESPIPE = 29;
        public final static int ESRCH = 3;
        public final static int ESTALE = 70;
        public final static int ETIMEDOUT = 60;
        public final static int ETOOMANYREFS = 59;
        public final static int ETXTBSY = 26;
        public final static int EUSERS = 68;
        public final static int EWOULDBLOCK = 35;
        public final static int EXDEV = 18;
    }

    public static interface DarwinDefines extends BsdDefines {

        public final static int E2BIG = 7;
        public final static int EBADMSG = 94;
        public final static int ECANCELED = 89;
        public final static int EIDRM = 90;
        public final static int EMULTIHOP = 95;
        public final static int ENODATA = 96;
        public final static int ENOLINK = 97;
        public final static int ENOMSG = 91;
        public final static int ENOSR = 98;
        public final static int ENOSTR = 99;
        public final static int ENOTRECOVERABLE = 104;
        public final static int ENOTSUP = 45;
        public final static int EOPNOTSUPP = 102;
        public final static int EOVERFLOW = 84;
        public final static int EOWNERDEAD = 105;
        public final static int EPROTO = 100;
        public final static int ETIME = 101;
    }

    public static interface FreeBsdDefines extends BsdDefines {

        public final static int E2BIG = 7;
        public final static int EBADMSG = 89;
        public final static int ECANCELED = 85;
        public final static int EIDRM = 82;
        public final static int EMULTIHOP = 90;
        public final static int ENOLINK = 91;
        public final static int ENOMSG = 83;
        public final static int ENOTRECOVERABLE = 95;
        public final static int ENOTSUP = 45;
        public final static int EOPNOTSUPP = 45;
        public final static int EOVERFLOW = 84;
        public final static int EOWNERDEAD = 96;
        public final static int EPROTO = 92;
    }

    public static class LinuxDefines {

        public final int E2BIG = 7;
        public final int EACCES = 13;
        public final int EADV = 68;
        public final int EAGAIN = 11;
        public final int EBADF = 9;
        public final int EBFONT = 59;
        public final int EBUSY = 16;
        public final int ECHILD = 10;
        public final int ECOMM = 70;
        public final int EDOTDOT = 73;
        public final int EEXIST = 17;
        public final int EFAULT = 14;
        public final int EFBIG = 27;
        public final int EINTR = 4;
        public final int EINVAL = 22;
        public final int EIO = 5;
        public final int EISDIR = 21;
        public final int EMFILE = 24;
        public final int EMLINK = 31;
        public final int ENFILE = 23;
        public final int ENODATA = 61;
        public final int ENODEV = 19;
        public final int ENOENT = 2;
        public final int ENOEXEC = 8;
        public final int ENOLINK = 67;
        public final int ENOMEM = 12;
        public final int ENONET = 64;
        public final int ENOPKG = 65;
        public final int ENOSPC = 28;
        public final int ENOSR = 63;
        public final int ENOSTR = 60;
        public final int ENOTBLK = 15;
        public final int ENOTDIR = 20;
        public final int ENOTTY = 25;
        public final int ENXIO = 6;
        public final int EPERM = 1;
        public final int EPIPE = 32;
        public final int EPROTO = 71;
        public final int EREMOTE = 66;
        public final int EROFS = 30;
        public final int ESPIPE = 29;
        public final int ESRCH = 3;
        public final int ESRMNT = 69;
        public final int ETIME = 62;
        public final int ETXTBSY = 26;
        public final int EWOULDBLOCK = 11;
        public final int EXDEV = 18;

        public final int EDEADLOCK;

        public final int EADDRINUSE;
        public final int EADDRNOTAVAIL;
        public final int EAFNOSUPPORT;
        public final int EALREADY;
        public final int EBADE;
        public final int EBADFD;
        public final int EBADMSG;
        public final int EBADR;
        public final int EBADRQC;
        public final int EBADSLT;
        public final int ECANCELED;
        public final int ECHRNG;
        public final int ECONNABORTED;
        public final int ECONNREFUSED;
        public final int ECONNRESET;
        public final int EDEADLK;
        public final int EDESTADDRREQ;
        public final int EDQUOT;
        public final int EHOSTDOWN;
        public final int EHOSTUNREACH;
        public final int EHWPOISON;
        public final int EIDRM;
        public final int EINPROGRESS;
        public final int EISCONN;
        public final int EISNAM;
        public final int EKEYEXPIRED;
        public final int EKEYREJECTED;
        public final int EKEYREVOKED;
        public final int EL2HLT;
        public final int EL2NSYNC;
        public final int EL3HLT;
        public final int EL3RST;
        public final int ELIBACC;
        public final int ELIBBAD;
        public final int ELIBEXEC;
        public final int ELIBMAX;
        public final int ELIBSCN;
        public final int ELNRNG;
        public final int ELOOP;
        public final int EMEDIUMTYPE;
        public final int EMSGSIZE;
        public final int EMULTIHOP;
        public final int ENAMETOOLONG;
        public final int ENAVAIL;
        public final int ENETDOWN;
        public final int ENETRESET;
        public final int ENETUNREACH;
        public final int ENOANO;
        public final int ENOBUFS;
        public final int ENOCSI;
        public final int ENOKEY;
        public final int ENOLCK;
        public final int ENOMEDIUM;
        public final int ENOMSG;
        public final int ENOPROTOOPT;
        public final int ENOSYS;
        public final int ENOTCONN;
        public final int ENOTEMPTY;
        public final int ENOTNAM;
        public final int ENOTRECOVERABLE;
        public final int ENOTSOCK;
        public final int ENOTSUP;
        public final int ENOTUNIQ;
        public final int EOPNOTSUPP;
        public final int EOVERFLOW;
        public final int EOWNERDEAD;
        public final int EPFNOSUPPORT;
        public final int EPROTONOSUPPORT;
        public final int EPROTOTYPE;
        public final int EREMCHG;
        public final int EREMOTEIO;
        public final int ERESTART;
        public final int ERFKILL;
        public final int ESHUTDOWN;
        public final int ESOCKTNOSUPPORT;
        public final int ESTALE;
        public final int ESTRPIPE;
        public final int ETIMEDOUT;
        public final int ETOOMANYREFS;
        public final int EUCLEAN;
        public final int EUNATCH;
        public final int EUSERS;
        public final int EXFULL;

        public LinuxDefines(MultiarchInfo multiarchInfo) {
            switch (multiarchInfo.getArch()) {
                case MIPS, MIPS_64 -> {
                    EADDRINUSE = 125;
                    EADDRNOTAVAIL = 126;
                    EAFNOSUPPORT = 124;
                    EALREADY = 149;
                    EBADE = 50;
                    EBADFD = 81;
                    EBADMSG = 77;
                    EBADR = 51;
                    EBADRQC = 54;
                    EBADSLT = 55;
                    ECANCELED = 158;
                    ECHRNG = 37;
                    ECONNABORTED = 130;
                    ECONNREFUSED = 146;
                    ECONNRESET = 131;
                    EDEADLK = 45;
                    EDESTADDRREQ = 96;
                    EDQUOT = 1133;
                    EHOSTDOWN = 147;
                    EHOSTUNREACH = 148;
                    EHWPOISON = 168;
                    EIDRM = 36;
                    EINPROGRESS = 150;
                    EISCONN = 133;
                    EISNAM = 139;
                    EKEYEXPIRED = 162;
                    EKEYREJECTED = 164;
                    EKEYREVOKED = 163;
                    EL2HLT = 44;
                    EL2NSYNC = 38;
                    EL3HLT = 39;
                    EL3RST = 40;
                    ELIBACC = 83;
                    ELIBBAD = 84;
                    ELIBEXEC = 87;
                    ELIBMAX = 86;
                    ELIBSCN = 85;
                    ELNRNG = 41;
                    ELOOP = 90;
                    EMEDIUMTYPE = 160;
                    EMSGSIZE = 97;
                    EMULTIHOP = 74;
                    ENAMETOOLONG = 78;
                    ENAVAIL = 138;
                    ENETDOWN = 127;
                    ENETRESET = 129;
                    ENETUNREACH = 128;
                    ENOANO = 53;
                    ENOBUFS = 132;
                    ENOCSI = 43;
                    ENOKEY = 161;
                    ENOLCK = 46;
                    ENOMEDIUM = 159;
                    ENOMSG = 35;
                    ENOPROTOOPT = 99;
                    ENOSYS = 89;
                    ENOTCONN = 134;
                    ENOTEMPTY = 93;
                    ENOTNAM = 137;
                    ENOTRECOVERABLE = 166;
                    ENOTSOCK = 95;
                    ENOTSUP = 122;
                    ENOTUNIQ = 80;
                    EOPNOTSUPP = 122;
                    EOVERFLOW = 79;
                    EOWNERDEAD = 165;
                    EPFNOSUPPORT = 123;
                    EPROTONOSUPPORT = 120;
                    EPROTOTYPE = 98;
                    EREMCHG = 82;
                    EREMOTEIO = 140;
                    ERESTART = 91;
                    ERFKILL = 167;
                    ESHUTDOWN = 143;
                    ESOCKTNOSUPPORT = 121;
                    ESTALE = 151;
                    ESTRPIPE = 92;
                    ETIMEDOUT = 145;
                    ETOOMANYREFS = 144;
                    EUCLEAN = 135;
                    EUNATCH = 42;
                    EUSERS = 94;
                    EXFULL = 52;
                }
                default -> {
                    EADDRINUSE = 98;
                    EADDRNOTAVAIL = 99;
                    EAFNOSUPPORT = 97;
                    EALREADY = 114;
                    EBADE = 52;
                    EBADFD = 77;
                    EBADMSG = 74;
                    EBADR = 53;
                    EBADRQC = 56;
                    EBADSLT = 57;
                    ECANCELED = 125;
                    ECHRNG = 44;
                    ECONNABORTED = 103;
                    ECONNREFUSED = 111;
                    ECONNRESET = 104;
                    EDEADLK = 35;
                    EDESTADDRREQ = 89;
                    EDQUOT = 122;
                    EHOSTDOWN = 112;
                    EHOSTUNREACH = 113;
                    EHWPOISON = 133;
                    EIDRM = 43;
                    EINPROGRESS = 115;
                    EISCONN = 106;
                    EISNAM = 120;
                    EKEYEXPIRED = 127;
                    EKEYREJECTED = 129;
                    EKEYREVOKED = 128;
                    EL2HLT = 51;
                    EL2NSYNC = 45;
                    EL3HLT = 46;
                    EL3RST = 47;
                    ELIBACC = 79;
                    ELIBBAD = 80;
                    ELIBEXEC = 83;
                    ELIBMAX = 82;
                    ELIBSCN = 81;
                    ELNRNG = 48;
                    ELOOP = 40;
                    EMEDIUMTYPE = 124;
                    EMSGSIZE = 90;
                    EMULTIHOP = 72;
                    ENAMETOOLONG = 36;
                    ENAVAIL = 119;
                    ENETDOWN = 100;
                    ENETRESET = 102;
                    ENETUNREACH = 101;
                    ENOANO = 55;
                    ENOBUFS = 105;
                    ENOCSI = 50;
                    ENOKEY = 126;
                    ENOLCK = 37;
                    ENOMEDIUM = 123;
                    ENOMSG = 42;
                    ENOPROTOOPT = 92;
                    ENOSYS = 38;
                    ENOTCONN = 107;
                    ENOTEMPTY = 39;
                    ENOTNAM = 118;
                    ENOTRECOVERABLE = 131;
                    ENOTSOCK = 88;
                    ENOTSUP = 95;
                    ENOTUNIQ = 76;
                    EOPNOTSUPP = 95;
                    EOVERFLOW = 75;
                    EOWNERDEAD = 130;
                    EPFNOSUPPORT = 96;
                    EPROTONOSUPPORT = 93;
                    EPROTOTYPE = 91;
                    EREMCHG = 78;
                    EREMOTEIO = 121;
                    ERESTART = 85;
                    ERFKILL = 132;
                    ESHUTDOWN = 108;
                    ESOCKTNOSUPPORT = 94;
                    ESTALE = 116;
                    ESTRPIPE = 86;
                    ETIMEDOUT = 110;
                    ETOOMANYREFS = 109;
                    EUCLEAN = 117;
                    EUNATCH = 49;
                    EUSERS = 87;
                    EXFULL = 54;
                }
            }
            switch (multiarchInfo.getArch()) {
                case POWER_PC, POWER_PC_64 -> {
                    EDEADLOCK = 58;
                }
                case MIPS, MIPS_64 -> {
                    EDEADLOCK = 56;
                }
                default -> {
                    EDEADLOCK = 35;
                }
            }
        }
    }

    public static interface OpenBsdDefines extends BsdDefines {

        public final static int E2BIG = 1;
        public final static int EBADMSG = 92;
        public final static int ECANCELED = 88;
        public final static int EIDRM = 89;
        public final static int EMEDIUMTYPE = 86;
        public final static int ENOMEDIUM = 85;
        public final static int ENOMSG = 90;
        public final static int ENOTRECOVERABLE = 93;
        public final static int ENOTSUP = 91;
        public final static int EOPNOTSUPP = 45;
        public final static int EOVERFLOW = 87;
        public final static int EOWNERDEAD = 94;
        public final static int EPROTO = 95;
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

    static {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX -> {
                LinuxDefines linuxDefines = new Errno.LinuxDefines(MultiarchTupelBuilder.getMultiarch());
                E2BIG = linuxDefines.E2BIG;
                EACCES = linuxDefines.EACCES;
                EADV = IntDefine.toIntDefine(linuxDefines.EADV);
                EAGAIN = linuxDefines.EAGAIN;
                EBADF = linuxDefines.EBADF;
                EBFONT = IntDefine.toIntDefine(linuxDefines.EBFONT);
                EBUSY = linuxDefines.EBUSY;
                ECHILD = linuxDefines.ECHILD;
                ECOMM = IntDefine.toIntDefine(linuxDefines.ECOMM);
                EDOTDOT = IntDefine.toIntDefine(linuxDefines.EDOTDOT);
                EEXIST = linuxDefines.EEXIST;
                EFAULT = linuxDefines.EFAULT;
                EFBIG = linuxDefines.EFBIG;
                EINTR = linuxDefines.EINTR;
                EINVAL = linuxDefines.EINVAL;
                EIO = linuxDefines.EIO;
                EISDIR = linuxDefines.EISDIR;
                EMFILE = linuxDefines.EMFILE;
                EMLINK = linuxDefines.EMLINK;
                ENFILE = linuxDefines.ENFILE;
                ENODATA = IntDefine.toIntDefine(linuxDefines.ENODATA);
                ENODEV = linuxDefines.ENODEV;
                ENOENT = linuxDefines.ENOENT;
                ENOEXEC = linuxDefines.ENOEXEC;
                ENOLINK = IntDefine.toIntDefine(linuxDefines.ENOLINK);
                ENOMEM = linuxDefines.ENOMEM;
                ENONET = IntDefine.toIntDefine(linuxDefines.ENONET);
                ENOPKG = IntDefine.toIntDefine(linuxDefines.ENOPKG);
                ENOSPC = linuxDefines.ENOSPC;
                ENOSR = IntDefine.toIntDefine(linuxDefines.ENOSR);
                ENOSTR = IntDefine.toIntDefine(linuxDefines.ENOSTR);
                ENOTBLK = linuxDefines.ENOTBLK;
                ENOTDIR = linuxDefines.ENOTDIR;
                ENOTTY = linuxDefines.ENOTTY;
                ENXIO = linuxDefines.ENXIO;
                EPERM = linuxDefines.EPERM;
                EPIPE = linuxDefines.EPIPE;
                EPROTO = linuxDefines.EPROTO;
                EREMOTE = linuxDefines.EREMOTE;
                EROFS = linuxDefines.EROFS;
                ESPIPE = linuxDefines.ESPIPE;
                ESRCH = linuxDefines.ESRCH;
                ESRMNT = IntDefine.toIntDefine(linuxDefines.ESRMNT);
                ETIME = IntDefine.toIntDefine(linuxDefines.ETIME);
                ETXTBSY = linuxDefines.ETXTBSY;
                EWOULDBLOCK = linuxDefines.EWOULDBLOCK;
                EXDEV = linuxDefines.EXDEV;
                EADDRINUSE = linuxDefines.EADDRINUSE;
                EADDRNOTAVAIL = linuxDefines.EADDRNOTAVAIL;
                EAFNOSUPPORT = linuxDefines.EAFNOSUPPORT;
                EALREADY = linuxDefines.EALREADY;
                EBADE = IntDefine.toIntDefine(linuxDefines.EBADE);
                EBADFD = IntDefine.toIntDefine(linuxDefines.EBADFD);
                EBADMSG = linuxDefines.EBADMSG;
                EBADR = IntDefine.toIntDefine(linuxDefines.EBADR);
                EBADRQC = IntDefine.toIntDefine(linuxDefines.EBADRQC);
                EBADSLT = IntDefine.toIntDefine(linuxDefines.EBADSLT);
                ECANCELED = linuxDefines.ECANCELED;
                ECHRNG = IntDefine.toIntDefine(linuxDefines.ECHRNG);
                ECONNABORTED = linuxDefines.ECONNABORTED;
                ECONNREFUSED = linuxDefines.ECONNREFUSED;
                ECONNRESET = linuxDefines.ECONNRESET;
                EDEADLK = linuxDefines.EDEADLK;
                EDEADLOCK = IntDefine.toIntDefine(linuxDefines.EDEADLOCK);
                EDESTADDRREQ = linuxDefines.EDESTADDRREQ;
                EDQUOT = linuxDefines.EDQUOT;
                EHOSTDOWN = linuxDefines.EHOSTDOWN;
                EHOSTUNREACH = linuxDefines.EHOSTUNREACH;
                EHWPOISON = IntDefine.toIntDefine(linuxDefines.EHWPOISON);
                EIDRM = linuxDefines.EIDRM;
                EINPROGRESS = linuxDefines.EINPROGRESS;
                EISCONN = linuxDefines.EISCONN;
                EISNAM = IntDefine.toIntDefine(linuxDefines.EISNAM);
                EKEYEXPIRED = IntDefine.toIntDefine(linuxDefines.EKEYEXPIRED);
                EKEYREJECTED = IntDefine.toIntDefine(linuxDefines.EKEYREJECTED);
                EKEYREVOKED = IntDefine.toIntDefine(linuxDefines.EKEYREVOKED);
                EL2HLT = IntDefine.toIntDefine(linuxDefines.EL2HLT);
                EL2NSYNC = IntDefine.toIntDefine(linuxDefines.EL2NSYNC);
                EL3HLT = IntDefine.toIntDefine(linuxDefines.EL3HLT);
                EL3RST = IntDefine.toIntDefine(linuxDefines.EL3RST);
                ELIBACC = IntDefine.toIntDefine(linuxDefines.ELIBACC);
                ELIBBAD = IntDefine.toIntDefine(linuxDefines.ELIBBAD);
                ELIBEXEC = IntDefine.toIntDefine(linuxDefines.ELIBEXEC);
                ELIBMAX = IntDefine.toIntDefine(linuxDefines.ELIBMAX);
                ELIBSCN = IntDefine.toIntDefine(linuxDefines.ELIBSCN);
                ELNRNG = IntDefine.toIntDefine(linuxDefines.ELNRNG);
                ELOOP = linuxDefines.ELOOP;
                EMEDIUMTYPE = IntDefine.toIntDefine(linuxDefines.EMEDIUMTYPE);
                EMSGSIZE = linuxDefines.EMSGSIZE;
                EMULTIHOP = IntDefine.toIntDefine(linuxDefines.EMULTIHOP);
                ENAMETOOLONG = linuxDefines.ENAMETOOLONG;
                ENAVAIL = IntDefine.toIntDefine(linuxDefines.ENAVAIL);
                ENETDOWN = linuxDefines.ENETDOWN;
                ENETRESET = linuxDefines.ENETRESET;
                ENETUNREACH = linuxDefines.ENETUNREACH;
                ENOANO = IntDefine.toIntDefine(linuxDefines.ENOANO);
                ENOBUFS = linuxDefines.ENOBUFS;
                ENOCSI = IntDefine.toIntDefine(linuxDefines.ENOCSI);
                ENOKEY = IntDefine.toIntDefine(linuxDefines.ENOKEY);
                ENOLCK = linuxDefines.ENOLCK;
                ENOMEDIUM = IntDefine.toIntDefine(linuxDefines.ENOMEDIUM);
                ENOMSG = linuxDefines.ENOMSG;
                ENOPROTOOPT = linuxDefines.ENOPROTOOPT;
                ENOSYS = linuxDefines.ENOSYS;
                ENOTCONN = linuxDefines.ENOTCONN;
                ENOTEMPTY = linuxDefines.ENOTEMPTY;
                ENOTNAM = IntDefine.toIntDefine(linuxDefines.ENOTNAM);
                ENOTRECOVERABLE = linuxDefines.ENOTRECOVERABLE;
                ENOTSOCK = linuxDefines.ENOTSOCK;
                ENOTSUP = linuxDefines.ENOTSUP;
                ENOTUNIQ = IntDefine.toIntDefine(linuxDefines.ENOTUNIQ);
                EOPNOTSUPP = linuxDefines.EOPNOTSUPP;
                EOVERFLOW = linuxDefines.EOVERFLOW;
                EOWNERDEAD = linuxDefines.EOWNERDEAD;
                EPFNOSUPPORT = linuxDefines.EPFNOSUPPORT;
                EPROTONOSUPPORT = linuxDefines.EPROTONOSUPPORT;
                EPROTOTYPE = linuxDefines.EPROTOTYPE;
                EREMCHG = IntDefine.toIntDefine(linuxDefines.EREMCHG);
                EREMOTEIO = IntDefine.toIntDefine(linuxDefines.EREMOTEIO);
                ERESTART = IntDefine.toIntDefine(linuxDefines.ERESTART);
                ERFKILL = IntDefine.toIntDefine(linuxDefines.ERFKILL);
                ESHUTDOWN = linuxDefines.ESHUTDOWN;
                ESOCKTNOSUPPORT = linuxDefines.ESOCKTNOSUPPORT;
                ESTALE = linuxDefines.ESTALE;
                ESTRPIPE = IntDefine.toIntDefine(linuxDefines.ESTRPIPE);
                ETIMEDOUT = linuxDefines.ETIMEDOUT;
                ETOOMANYREFS = linuxDefines.ETOOMANYREFS;
                EUCLEAN = IntDefine.toIntDefine(linuxDefines.EUCLEAN);
                EUNATCH = IntDefine.toIntDefine(linuxDefines.EUNATCH);
                EUSERS = linuxDefines.EUSERS;
                EXFULL = IntDefine.toIntDefine(linuxDefines.EXFULL);
            }
            case DARWIN, FREE_BSD, OPEN_BSD -> {
                EACCES = BsdDefines.EACCES;
                EADDRINUSE = BsdDefines.EADDRINUSE;
                EADDRNOTAVAIL = BsdDefines.EADDRNOTAVAIL;
                EADV = IntDefine.UNDEFINED;
                EAFNOSUPPORT = BsdDefines.EAFNOSUPPORT;
                EAGAIN = BsdDefines.EAGAIN;
                EALREADY = BsdDefines.EALREADY;
                EBADE = IntDefine.UNDEFINED;
                EBADF = BsdDefines.EBADF;
                EBADFD = IntDefine.UNDEFINED;
                EBADR = IntDefine.UNDEFINED;
                EBADRQC = IntDefine.UNDEFINED;
                EBADSLT = IntDefine.UNDEFINED;
                EBFONT = IntDefine.UNDEFINED;
                EBUSY = BsdDefines.EBUSY;
                ECHILD = BsdDefines.ECHILD;
                ECHRNG = IntDefine.UNDEFINED;
                ECOMM = IntDefine.UNDEFINED;
                ECONNABORTED = BsdDefines.ECONNABORTED;
                ECONNREFUSED = BsdDefines.ECONNREFUSED;
                ECONNRESET = BsdDefines.ECONNRESET;
                EDEADLK = BsdDefines.EDEADLK;
                EDEADLOCK = IntDefine.UNDEFINED;
                EDESTADDRREQ = BsdDefines.EDESTADDRREQ;
                EDOTDOT = IntDefine.UNDEFINED;
                EDQUOT = BsdDefines.EDQUOT;
                EEXIST = BsdDefines.EEXIST;
                EFAULT = BsdDefines.EFAULT;
                EFBIG = BsdDefines.EFBIG;
                EHOSTDOWN = BsdDefines.EHOSTDOWN;
                EHOSTUNREACH = BsdDefines.EHOSTUNREACH;
                EHWPOISON = IntDefine.UNDEFINED;
                EINTR = BsdDefines.EINTR;
                EINVAL = BsdDefines.EINVAL;
                EINPROGRESS = BsdDefines.EINPROGRESS;
                EIO = BsdDefines.EIO;
                EISCONN = BsdDefines.EISCONN;
                EISDIR = BsdDefines.EISDIR;
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
                ELOOP = BsdDefines.ELOOP;
                EMFILE = BsdDefines.EMFILE;
                EMLINK = BsdDefines.EMLINK;
                EMSGSIZE = BsdDefines.EMSGSIZE;
                ENAMETOOLONG = BsdDefines.ENAMETOOLONG;
                ENAVAIL = IntDefine.UNDEFINED;
                ENETDOWN = BsdDefines.ENETDOWN;
                ENETRESET = BsdDefines.ENETRESET;
                ENETUNREACH = BsdDefines.ENETUNREACH;
                ENFILE = BsdDefines.ENFILE;
                ENODEV = BsdDefines.ENODEV;
                ENOENT = BsdDefines.ENOENT;
                ENOEXEC = BsdDefines.ENOEXEC;
                ENOMEM = BsdDefines.ENOMEM;
                ENONET = IntDefine.UNDEFINED;
                ENOPKG = IntDefine.UNDEFINED;
                ENOANO = IntDefine.UNDEFINED;
                ENOBUFS = BsdDefines.ENOBUFS;
                ENOCSI = IntDefine.UNDEFINED;
                ENOKEY = IntDefine.UNDEFINED;
                ENOLCK = BsdDefines.ENOLCK;
                ENOPROTOOPT = BsdDefines.ENOPROTOOPT;
                ENOSPC = BsdDefines.ENOSPC;
                ENOSYS = BsdDefines.ENOSYS;
                ENOTBLK = BsdDefines.ENOTBLK;
                ENOTCONN = BsdDefines.ENOTCONN;
                ENOTDIR = BsdDefines.ENOTDIR;
                ENOTEMPTY = BsdDefines.ENOTEMPTY;
                ENOTNAM = IntDefine.UNDEFINED;
                ENOTSOCK = BsdDefines.ENOTSOCK;
                ENOTTY = BsdDefines.ENOTTY;
                ENOTUNIQ = IntDefine.UNDEFINED;
                ENXIO = BsdDefines.ENXIO;
                EPERM = BsdDefines.EPERM;
                EPFNOSUPPORT = BsdDefines.EPFNOSUPPORT;
                EPIPE = BsdDefines.EPIPE;
                EPROTONOSUPPORT = BsdDefines.EPROTONOSUPPORT;
                EPROTOTYPE = BsdDefines.EPROTOTYPE;
                EREMCHG = IntDefine.UNDEFINED;
                EREMOTE = BsdDefines.EREMOTE;
                EREMOTEIO = IntDefine.UNDEFINED;
                ERESTART = IntDefine.UNDEFINED;
                ERFKILL = IntDefine.UNDEFINED;
                EROFS = BsdDefines.EROFS;
                ESHUTDOWN = BsdDefines.ESHUTDOWN;
                ESOCKTNOSUPPORT = BsdDefines.ESOCKTNOSUPPORT;
                ESPIPE = BsdDefines.ESPIPE;
                ESRCH = BsdDefines.ESRCH;
                ESRMNT = IntDefine.UNDEFINED;
                ESTALE = BsdDefines.ESTALE;
                ESTRPIPE = IntDefine.UNDEFINED;
                ETOOMANYREFS = BsdDefines.ETOOMANYREFS;
                ETIMEDOUT = BsdDefines.ETIMEDOUT;
                ETXTBSY = BsdDefines.ETXTBSY;
                EUCLEAN = IntDefine.UNDEFINED;
                EUNATCH = IntDefine.UNDEFINED;
                EUSERS = BsdDefines.EUSERS;
                EWOULDBLOCK = BsdDefines.EWOULDBLOCK;
                EXDEV = BsdDefines.EXDEV;
                EXFULL = IntDefine.UNDEFINED;
                switch (MultiarchTupelBuilder.getOS()) {
                    case DARWIN -> {
                        E2BIG = DarwinDefines.E2BIG;
                        EMEDIUMTYPE = IntDefine.UNDEFINED;
                        ENOMEDIUM = IntDefine.UNDEFINED;
                        EPROTO = DarwinDefines.EPROTO;
                        EBADMSG = DarwinDefines.EBADMSG;
                        ECANCELED = DarwinDefines.ECANCELED;
                        EIDRM = DarwinDefines.EIDRM;
                        ENOLINK = IntDefine.toIntDefine(DarwinDefines.ENOLINK);
                        ENOMSG = DarwinDefines.ENOMSG;
                        EMULTIHOP = IntDefine.toIntDefine(DarwinDefines.EMULTIHOP);
                        ENOTRECOVERABLE = DarwinDefines.ENOTRECOVERABLE;
                        ENOTSUP = DarwinDefines.ENOTSUP;
                        EOVERFLOW = DarwinDefines.EOVERFLOW;
                        EOWNERDEAD = DarwinDefines.EOWNERDEAD;
                        ENODATA = IntDefine.toIntDefine(DarwinDefines.ENODATA);
                        EOPNOTSUPP = DarwinDefines.EOPNOTSUPP;
                        ENOSR = IntDefine.toIntDefine(DarwinDefines.ENOSR);
                        ENOSTR = IntDefine.toIntDefine(DarwinDefines.ENOSTR);
                        ETIME = IntDefine.toIntDefine(DarwinDefines.ETIME);
                    }
                    case FREE_BSD -> {
                        E2BIG = FreeBsdDefines.E2BIG;
                        EMEDIUMTYPE = IntDefine.UNDEFINED;
                        ENOMEDIUM = IntDefine.UNDEFINED;
                        EPROTO = FreeBsdDefines.EPROTO;
                        EBADMSG = FreeBsdDefines.EBADMSG;
                        ECANCELED = FreeBsdDefines.ECANCELED;
                        EIDRM = FreeBsdDefines.EIDRM;
                        ENOLINK = IntDefine.toIntDefine(FreeBsdDefines.ENOLINK);
                        ENOMSG = FreeBsdDefines.ENOMSG;
                        EMULTIHOP = IntDefine.toIntDefine(FreeBsdDefines.EMULTIHOP);
                        ENOTRECOVERABLE = FreeBsdDefines.ENOTRECOVERABLE;
                        ENOTSUP = FreeBsdDefines.ENOTSUP;
                        EOVERFLOW = FreeBsdDefines.EOVERFLOW;
                        EOWNERDEAD = FreeBsdDefines.EOWNERDEAD;
                        ENODATA = IntDefine.UNDEFINED;
                        EOPNOTSUPP = FreeBsdDefines.EOPNOTSUPP;
                        ENOSR = IntDefine.UNDEFINED;
                        ENOSTR = IntDefine.UNDEFINED;
                        ETIME = IntDefine.UNDEFINED;
                    }
                    case OPEN_BSD -> {
                        E2BIG = OpenBsdDefines.E2BIG;
                        EMEDIUMTYPE = IntDefine.toIntDefine(OpenBsdDefines.EMEDIUMTYPE);
                        ENOMEDIUM = IntDefine.toIntDefine(OpenBsdDefines.ENOMEDIUM);
                        EPROTO = OpenBsdDefines.EPROTO;
                        EBADMSG = OpenBsdDefines.EBADMSG;
                        ECANCELED = OpenBsdDefines.ECANCELED;
                        EIDRM = OpenBsdDefines.EIDRM;
                        ENOLINK = IntDefine.UNDEFINED;
                        ENOMSG = OpenBsdDefines.ENOMSG;
                        EMULTIHOP = IntDefine.UNDEFINED;
                        ENOTRECOVERABLE = OpenBsdDefines.ENOTRECOVERABLE;
                        ENOTSUP = OpenBsdDefines.ENOTSUP;
                        EOVERFLOW = OpenBsdDefines.EOVERFLOW;
                        EOWNERDEAD = OpenBsdDefines.EOWNERDEAD;
                        ENODATA = IntDefine.UNDEFINED;
                        EOPNOTSUPP = OpenBsdDefines.EOPNOTSUPP;
                        ENOSR = IntDefine.UNDEFINED;
                        ENOSTR = IntDefine.UNDEFINED;
                        ETIME = IntDefine.UNDEFINED;
                    }
                    default ->
                        throw new NoClassDefFoundError("No errno.h BSD defines for " + MultiarchTupelBuilder.getMultiarch());
                }
            }
            default ->
                throw new NoClassDefFoundError("No errno.h defines for " + MultiarchTupelBuilder.getMultiarch());
        }
    }

    static {
        NativeErrorException.addErrSymbolProvider(Errno::getErrnoSymbol);
    }

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
