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
#include "jnhw-posix.h"
#include "de_ibapl_jnhw_posix_Errno.h"


#ifdef __cplusplus
extern "C" {
#endif

    //We need the POSIX version ...    
#if !defined(HAVE_ERRNO_H) || !defined(_POSIX_VERSION)

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Errno_initFields
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    }
#else
#include <errno.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Errno
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Errno_initFields
    (JNIEnv *env, jclass clazz) {
        if (JnhwSetStaticIntField(env, clazz, "EPERM", EPERM)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENOENT", ENOENT)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ESRCH", ESRCH)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EINTR", EINTR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EIO", EIO)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENXIO", ENXIO)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "E2BIG", E2BIG)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENOEXEC", ENOEXEC)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EBADF", EBADF)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ECHILD", ECHILD)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EAGAIN", EAGAIN)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENOMEM", ENOMEM)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EACCES", EACCES)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EFAULT", EFAULT)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENOTBLK", ENOTBLK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EBUSY", EBUSY)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EEXIST", EEXIST)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EXDEV", EXDEV)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENODEV", ENODEV)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENOTDIR", ENOTDIR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EISDIR", EISDIR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EINVAL", EINVAL)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENFILE", ENFILE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EMFILE", EMFILE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENOTTY", ENOTTY)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ETXTBSY", ETXTBSY)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EFBIG", EFBIG)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENOSPC", ENOSPC)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ESPIPE", ESPIPE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EROFS", EROFS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EMLINK", EMLINK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EPIPE", EPIPE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EDEADLK", EDEADLK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENAMETOOLONG", ENAMETOOLONG)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENOLCK", ENOLCK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENOSYS", ENOSYS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENOTEMPTY", ENOTEMPTY)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ELOOP", ELOOP)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EWOULDBLOCK", EWOULDBLOCK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENOMSG", ENOMSG)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EIDRM", EIDRM)) {
            return;
        }
#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ECHRNG", ECHRNG)) {
            return;
        }
#elif defined(ECHRNG)
#error "ECHRNG defined"
#endif


#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EL2NSYNC", EL2NSYNC)) {
            return;
        }
#elif defined(EL2NSYNC)
#error "EL2NSYNC defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EL3HLT", EL3HLT)) {
            return;
        }
#elif defined(EL3HLT)
#error "EL3HLT defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EL3RST", EL3RST)) {
            return;
        }
#elif defined(EL3RST)
#error "EL3RST defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ELNRNG", ELNRNG)) {
            return;
        }
#elif defined(ELNRNG)
#error "ELNRNG defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EUNATCH", EUNATCH)) {
            return;
        }
#elif defined(EUNATCH)
#error "EUNATCH defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ENOCSI", ENOCSI)) {
            return;
        }
#elif defined(ENOCSI)
#error "ENOCSI defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EL2HLT", EL2HLT)) {
            return;
        }
#elif defined(EL2HLT)
#error "EL2HLT defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EBADE", EBADE)) {
            return;
        }
#elif defined(EBADE)
#error "EBADE defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EBADR", EBADR)) {
            return;
        }
#elif defined(EBADR)
#error "EBADR defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EXFULL", EXFULL)) {
            return;
        }
#elif defined(EXFULL)
#error "EXFULL defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ENOANO", ENOANO)) {
            return;
        }
#elif defined(ENOANO)
#error "ENOANO defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EBADRQC", EBADRQC)) {
            return;
        }
#elif defined(EBADRQC)
#error "EBADRQC defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EBADSLT", EBADSLT)) {
            return;
        }
#elif defined(EBADSLT)
#error "EBADSLT defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EDEADLOCK", EDEADLOCK)) {
            return;
        }
#elif defined(EDEADLOCK)
#error "EDEADLOCK defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EBFONT", EBFONT)) {
            return;
        }
#elif defined(EBFONT)
#error "EBFONT defined"
#endif

#if defined(__FreeBSD__) || defined(__OpenBSD__)
#if defined(ENOSTR)
#error "ENOSTR defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "ENOSTR", ENOSTR)) {
            return;
        }
#endif

#if defined(__linux__) || defined(__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ENODATA", ENODATA)) {
            return;
        }
#elif defined(ENODATA)
#error "ENODATA defined"
#endif

#if defined(__linux__) || defined(__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ETIME", ETIME)) {
            return;
        }
#elif defined(ETIME)
#error "ETIME defined"
#endif

#if defined(__linux__) || defined(__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ENOSR", ENOSR)) {
            return;
        }
#elif defined(ENOSR)
#error "ENOSR defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ENONET", ENONET)) {
            return;
        }
#elif defined(ENONET)
#error "ENONET defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ENOPKG", ENOPKG)) {
            return;
        }
#elif defined(ENOPKG)
#error "ENOPKG defined"
#endif

        if (JnhwSetStaticIntField(env, clazz, "EREMOTE", EREMOTE)) {
            return;
        }

#if defined (__OpenBSD__)
#if defined(ENOLINK)
#error "ENOLINK defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "ENOLINK", ENOLINK)) {
            return;
        }
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EADV", EADV)) {
            return;
        }
#elif defined(EADV)
#error "EADV defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ESRMNT", ESRMNT)) {
            return;
        }
#elif defined(ESRMNT)
#error "ESRMNT defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ECOMM", ECOMM)) {
            return;
        }
#elif defined(ECOMM)
#error "ECOMM defined"
#endif

        if (JnhwSetStaticIntField(env, clazz, "EPROTO", EPROTO)) {
            return;

#if defined (__OpenBSD__)
#if defined(EMULTIHOP)
#error "EMULTIHOP defined"
#endif
#else
            if (JnhwSetStaticIntDefineField(env, clazz, "EMULTIHOP", EMULTIHOP)) {
                return;
            }
#endif

#if defined (__linux__)
            if (JnhwSetStaticIntDefineField(env, clazz, "EDOTDOT", EDOTDOT)) {
                return;
            }
#elif defined(EDOTDOT)
#error "EDOTDOT defined"
#endif


        }
        if (JnhwSetStaticIntField(env, clazz, "EBADMSG", EBADMSG)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EOVERFLOW", EOVERFLOW)) {
            return;
        }

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ENOTUNIQ", ENOTUNIQ)) {
            return;
        }
#elif defined(ENOTUNIQ)
#error "ENOTUNIQ defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EBADFD", EBADFD)) {
            return;
        }
#elif defined(EBADFD)
#error "EBADFD defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EREMCHG", EREMCHG)) {
            return;
        }
#elif defined(EREMCHG)
#error "EREMCHG defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ELIBACC", ELIBACC)) {
            return;
        }
#elif defined(ELIBACC)
#error "ELIBACC defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ELIBBAD", ELIBBAD)) {
            return;
        }
#elif defined(ELIBBAD)
#error "ELIBBAD defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ELIBSCN", ELIBSCN)) {
            return;
        }
#elif defined(ELIBSCN)
#error "ELIBSCN defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ELIBMAX", ELIBMAX)) {
            return;
        }
#elif defined(ELIBMAX)
#error "ELIBMAX defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ELIBEXEC", ELIBEXEC)) {
            return;
        }
#elif defined(ELIBEXEC)
#error "ELIBEXEC defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ERESTART", ERESTART)) {
            return;
        }
#elif defined(ERESTART)
#error "ERESTART defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ESTRPIPE", ESTRPIPE)) {
            return;
        }
#elif defined(ESTRPIPE)
#error "ESTRPIPE defined"
#endif

        if (JnhwSetStaticIntField(env, clazz, "EUSERS", EUSERS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENOTSOCK", ENOTSOCK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EDESTADDRREQ", EDESTADDRREQ)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EMSGSIZE", EMSGSIZE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EPROTOTYPE", EPROTOTYPE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENOPROTOOPT", ENOPROTOOPT)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EPROTONOSUPPORT", EPROTONOSUPPORT)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ESOCKTNOSUPPORT", ESOCKTNOSUPPORT)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EOPNOTSUPP", EOPNOTSUPP)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EPFNOSUPPORT", EPFNOSUPPORT)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EAFNOSUPPORT", EAFNOSUPPORT)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EADDRINUSE", EADDRINUSE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EADDRNOTAVAIL", EADDRNOTAVAIL)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENETDOWN", ENETDOWN)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENETUNREACH", ENETUNREACH)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENETRESET", ENETRESET)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ECONNABORTED", ECONNABORTED)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ECONNRESET", ECONNRESET)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENOBUFS", ENOBUFS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EISCONN", EISCONN)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENOTCONN", ENOTCONN)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ESHUTDOWN", ESHUTDOWN)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ETOOMANYREFS", ETOOMANYREFS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ETIMEDOUT", ETIMEDOUT)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ECONNREFUSED", ECONNREFUSED)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EHOSTDOWN", EHOSTDOWN)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EHOSTUNREACH", EHOSTUNREACH)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EALREADY", EALREADY)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "EINPROGRESS", EINPROGRESS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ESTALE", ESTALE)) {
            return;
        }
#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EUCLEAN", EUCLEAN)) {
            return;
        }
#elif defined(EUCLEAN)
#error "EUCLEAN defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ENOTNAM", ENOTNAM)) {
            return;
        }
#elif defined(ENOTNAM)
#error "ENOTNAM defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ENAVAIL", ENAVAIL)) {
            return;
        }
#elif defined(ENAVAIL)
#error "ENAVAIL defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EISNAM", EISNAM)) {
            return;
        }
#elif defined(EISNAM)
#error "EISNAM defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EREMOTEIO", EREMOTEIO)) {
            return;
        }
#elif defined(EREMOTEIO)
#error "EREMOTEIO defined"
#endif
        if (JnhwSetStaticIntField(env, clazz, "EDQUOT", EDQUOT)) {
            return;
        }

#if defined (__linux__) || defined(__OpenBSD__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ENOMEDIUM", ENOMEDIUM)) {
            return;
        }
#elif defined(ENOMEDIUM)
#error "ENOMEDIUM defined"
#endif

#if defined (__linux__) || defined(__OpenBSD__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EMEDIUMTYPE", EMEDIUMTYPE)) {
            return;
        }
#elif defined(EMEDIUMTYPE)
#error "EMEDIUMTYPE defined"
#endif

        if (JnhwSetStaticIntField(env, clazz, "ECANCELED", ECANCELED)) {
            return;
        }

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ENOKEY", ENOKEY)) {
            return;
        }
#elif defined(ENOKEY)
#error "ENOKEY defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EKEYEXPIRED", EKEYEXPIRED)) {
            return;
        }
#elif defined(EKEYEXPIRED)
#error "EKEYEXPIRED defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EKEYREVOKED", EKEYREVOKED)) {
            return;
        }
#elif defined(EKEYREVOKED)
#error "EKEYREVOKED defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EKEYREJECTED", EKEYREJECTED)) {
            return;
        }
#elif defined(EKEYREJECTED)
#error "EKEYREJECTED defined"
#endif

        if (JnhwSetStaticIntField(env, clazz, "EOWNERDEAD", EOWNERDEAD)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ENOTRECOVERABLE", ENOTRECOVERABLE)) {
            return;
        }

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "ERFKILL", ERFKILL)) {
            return;
        }
#elif defined(ERFKILL)
#error "ERFKILL defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "EHWPOISON", EHWPOISON)) {
            return;
        }
#elif defined(EHWPOISON)
#error "EHWPOISON defined"
#endif

        if (JnhwSetStaticIntField(env, clazz, "ENOTSUP", ENOTSUP)) {
            return;
        }
    }

#ifdef __cplusplus
}
#endif
#endif
