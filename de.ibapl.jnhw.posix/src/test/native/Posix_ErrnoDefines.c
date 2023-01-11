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
#include "jnhw-posix.h"

//We need the POSIX version ...
#if !defined(HAVE_ERRNO_H) || !defined(_POSIX_VERSION)
#else
#include <errno.h>

int32_t getValueOf_E2BIG() {
    return E2BIG;
}

int32_t getValueOf_EACCES() {
    return EACCES;
}

int32_t getValueOf_EADDRINUSE() {
    return EADDRINUSE;
}

int32_t getValueOf_EADDRNOTAVAIL() {
    return EADDRNOTAVAIL;
}

int32_t* tryGetValueOf_EADV(int32_t* value) {
#if defined (__linux__)
    *value = EADV;
#elif !defined(EADV)
    value = NULL;
#else
#error "EADV defined"
#endif
    return value;
}

int32_t getValueOf_EAFNOSUPPORT() {
    return EAFNOSUPPORT;
}

int32_t getValueOf_EAGAIN() {
    return EAGAIN;
}

int32_t getValueOf_EALREADY() {
    return EALREADY;
}

int32_t* tryGetValueOf_EBADE(int32_t* value) {
#if defined (__linux__)
    *value = EBADE;
#elif !defined(EBADE)
    value = NULL;
#else
#error "EBADE defined"
#endif
    return value;
}

int32_t getValueOf_EBADF() {
    return EBADF;
}

int32_t* tryGetValueOf_EBADFD(int32_t* value) {
#if defined (__linux__)
    *value = EBADFD;
#elif !defined(EBADFD)
    value = NULL;
#else
#error "EBADFD defined"
#endif
    return value;
}

int32_t getValueOf_EBADMSG() {
    return EBADMSG;
}

int32_t* tryGetValueOf_EBADR(int32_t* value) {
#if defined (__linux__)
    *value = EBADR;
#elif !defined(EBADR)
    value = NULL;
#else
#error "EBADR defined"
#endif
    return value;
}

int32_t* tryGetValueOf_EBADRQC(int32_t* value) {
#if defined (__linux__)
    *value = EBADRQC;
#elif !defined(EBADRQC)
    value = NULL;
#else
#error "EBADRQC defined"
#endif
    return value;
}

int32_t* tryGetValueOf_EBADSLT(int32_t* value) {
#if defined (__linux__)
    *value = EBADSLT;
#elif !defined(EBADSLT)
    value = NULL;
#else
#error "EBADSLT defined"
#endif
    return value;
}

int32_t* tryGetValueOf_EBFONT(int32_t* value) {
#if defined (__linux__)
    *value = EBFONT;
#elif !defined(EBFONT)
    valkue = NULL;
#else
#error "EBFONT defined"
#endif
    return value;
}

int32_t getValueOf_EBUSY() {
    return EBUSY;
}

int32_t getValueOf_ECANCELED() {
    return ECANCELED;
}

int32_t getValueOf_ECHILD() {
    return ECHILD;
}

int32_t* tryGetValueOf_ECHRNG(int32_t* value) {
#if defined (__linux__)
    *value = ECHRNG;
#elif !defined(ECHRNG)
    value = NULL;
#else
#error "ECHRNG defined"
#endif
    return value;
}

int32_t* tryGetValueOf_ECOMM(int32_t* value) {
#if defined (__linux__)
    *value = ECOMM;
#elif !defined(ECOMM)
    value = NULL;
#else
#error "ECOMM defined"
#endif
    return value;
}

int32_t getValueOf_ECONNABORTED() {
    return ECONNABORTED;
}

int32_t getValueOf_ECONNREFUSED() {
    return ECONNREFUSED;
}

int32_t getValueOf_ECONNRESET() {
    return ECONNRESET;
}

int32_t getValueOf_EDEADLK() {
    return EDEADLK;
}

int32_t* tryGetValueOf_EDEADLOCK(int32_t* value) {
#if defined (__linux__)
    *value = EDEADLOCK;
#elif !defined(EDEADLOCK)
    value = NULL;
#else
#error "EDEADLOCK defined"
#endif
    return value;
}

int32_t getValueOf_EDESTADDRREQ() {
    return EDESTADDRREQ;
}

int32_t* tryGetValueOf_EDOTDOT(int32_t* value) {
#if defined (__linux__)
    *value = EDOTDOT;
#elif !defined(EDOTDOT)
    value = NULL;
#else
#error "EDOTDOT defined"
#endif
    return value;
}

int32_t getValueOf_EDQUOT() {
    return EDQUOT;
}

int32_t getValueOf_EEXIST() {
    return EEXIST;
}

int32_t getValueOf_EFAULT() {
    return EFAULT;
}

int32_t getValueOf_EFBIG() {
    return EFBIG;
}

int32_t getValueOf_EHOSTDOWN() {
    return EHOSTDOWN;
}

int32_t getValueOf_EHOSTUNREACH() {
    return EHOSTUNREACH;
}

int32_t* tryGetValueOf_EHWPOISON(int32_t* value) {
#if defined (__linux__)
    *value = EHWPOISON;
#elif !defined(EHWPOISON)
    value = NULL;
#else
#error "EHWPOISON defined"
#endif
    return value;
}

int32_t getValueOf_EIDRM() {
    return EIDRM;
}

int32_t getValueOf_EINPROGRESS() {
    return EINPROGRESS;
}

int32_t getValueOf_EINTR() {
    return EINTR;
}

int32_t getValueOf_EINVAL() {
    return EINVAL;
}

int32_t getValueOf_EIO() {
    return EIO;
}

int32_t getValueOf_EISCONN() {
    return EISCONN;
}

int32_t getValueOf_EISDIR() {
    return EISDIR;
}

int32_t* tryGetValueOf_EISNAM(int32_t* value) {
#if defined (__linux__)
    *value = EISNAM;
#elif !defined(EISNAM)
    value = NULL;
#else
#error "EISNAM defined"
#endif
    return value;
}

int32_t* tryGetValueOf_EKEYEXPIRED(int32_t* value) {
#if defined (__linux__)
    *value = EKEYEXPIRED;
#elif !defined(EKEYEXPIRED)
    value = NULL;
#else
#error "EKEYEXPIRED defined"
#endif
    return value;
}

int32_t* tryGetValueOf_EKEYREJECTED(int32_t* value) {
#if defined (__linux__)
    *value = EKEYREJECTED;
#elif !defined(EKEYREJECTED)
    value = NULL;
#else
#error "EKEYREJECTED defined"
#endif
    return value;
}

int32_t* tryGetValueOf_EKEYREVOKED(int32_t* value) {
#if defined (__linux__)
    *value = EKEYREVOKED;
#elif !defined(EKEYREVOKED)
    value = NULL;
#else
#error "EKEYREVOKED defined"
#endif
    return value;
}

int32_t* tryGetValueOf_EL2HLT(int32_t* value) {
#if defined (__linux__)
    *value = EL2HLT;
#elif !defined(EL2HLT)
    value = NULL;
#else
#error "EL2HLT defined"
#endif
    return value;
}

int32_t* tryGetValueOf_EL2NSYNC(int32_t* value) {
#if defined (__linux__)
    *value = EL2NSYNC;
#elif !defined(EL2NSYNC)
    value = NULL;
#else
#error "EL2NSYNC defined"
#endif
    return value;
}

int32_t* tryGetValueOf_EL3HLT(int32_t* value) {
#if defined (__linux__)
    *value = EL3HLT;
#elif !defined(EL3HLT)
    value = NULL;
#else
#error "EL3HLT defined"
#endif
    return value;
}

int32_t* tryGetValueOf_EL3RST(int32_t* value) {
#if defined (__linux__)
    *value = EL3RST;
#elif !defined(EL3RST)
    value = NULL;
#else
#error "EL3RST defined"
#endif
    return value;
}

int32_t* tryGetValueOf_ELIBACC(int32_t* value) {
#if defined (__linux__)
    *value = ELIBACC;
#elif !defined(ELIBACC)
    value = NULL;
#else
#error "ELIBACC defined"
#endif
    return value;
}

int32_t* tryGetValueOf_ELIBBAD(int32_t* value) {
#if defined (__linux__)
    *value = ELIBBAD;
#elif !defined(ELIBBAD)
    value = NULL;
#else
#error "ELIBBAD defined"
#endif
    return value;
}

int32_t* tryGetValueOf_ELIBEXEC(int32_t* value) {
#if defined (__linux__)
    *value = ELIBEXEC;
#elif !defined(ELIBEXEC)
    value = NULL;
#else
#error "ELIBEXEC defined"
#endif
    return value;
}

int32_t* tryGetValueOf_ELIBMAX(int32_t* value) {
#if defined (__linux__)
    *value = ELIBMAX;
#elif !defined(ELIBMAX)
    value = NULL;
#else
#error "ELIBMAX defined"
#endif
    return value;
}

int32_t* tryGetValueOf_ELIBSCN(int32_t* value) {
#if defined (__linux__)
    *value = ELIBSCN;
#elif !defined(ELIBSCN)
    value = NULL;
#else
#error "ELIBSCN defined"
#endif
    return value;
}

int32_t* tryGetValueOf_ELNRNG(int32_t* value) {
#if defined (__linux__)
    *value = ELNRNG;
#elif !defined(ELNRNG)
    value = NULL;
#else
#error "ELNRNG defined"
#endif
    return value;
}

int32_t getValueOf_ELOOP() {
    return ELOOP;
}

int32_t* tryGetValueOf_EMEDIUMTYPE(int32_t* value) {
#if defined (__linux__) || defined(__OpenBSD__)
    *value = EMEDIUMTYPE;
#elif !defined(EMEDIUMTYPE)
    value = NULL;
#else
#error "EMEDIUMTYPE defined"
#endif
    return value;
}

int32_t getValueOf_EMFILE() {
    return EMFILE;
}

int32_t getValueOf_EMLINK() {
    return EMLINK;
}

int32_t getValueOf_EMSGSIZE() {
    return EMSGSIZE;
}

int32_t* tryGetValueOf_EMULTIHOP(int32_t* value) {
#if defined (__OpenBSD__)
#if !defined(EMULTIHOP)
    value = NULL;
#else
#error "EMULTIHOP defined"
#endif
#else
    *value = EMULTIHOP;
#endif
    return value;
}

int32_t getValueOf_ENAMETOOLONG() {
    return ENAMETOOLONG;
}

int32_t* tryGetValueOf_ENAVAIL(int32_t* value) {
#if defined (__linux__)
    *value = ENAVAIL;
#elif !defined(ENAVAIL)
    value = NULL;
#else
#error "ENAVAIL defined"
#endif
    return value;
}

int32_t getValueOf_ENETDOWN() {
    return ENETDOWN;
}

int32_t getValueOf_ENETRESET() {
    return ENETRESET;
}

int32_t getValueOf_ENETUNREACH() {
    return ENETUNREACH;
}

int32_t getValueOf_ENFILE() {
    return ENFILE;
}

int32_t* tryGetValueOf_ENOANO(int32_t* value) {
#if defined (__linux__)
    *value = ENOANO;
#elif !defined(ENOANO)
    value = NULL;
#else
#error "ENOANO defined"
#endif
    return value;
}

int32_t getValueOf_ENOBUFS() {
    return ENOBUFS;
}

int32_t* tryGetValueOf_ENOCSI(int32_t* value) {
#if defined (__linux__)
    *value = ENOCSI;
#elif !defined(ENOCSI)
    value = NULL;
#else
#error "ENOCSI defined"
#endif
    return value;
}

int32_t* tryGetValueOf_ENODATA(int32_t* value) {
#if defined(__linux__) || defined(__APPLE__)
    *value = ENODATA;
#elif !defined(ENODATA)
    value = NULL;
#else
#error "ENODATA defined"
#endif
    return value;
}

int32_t getValueOf_ENODEV() {
    return ENODEV;
}

int32_t getValueOf_ENOENT() {
    return ENOENT;
}

int32_t getValueOf_ENOEXEC() {
    return ENOEXEC;
}

int32_t* tryGetValueOf_ENOKEY(int32_t* value) {
#if defined (__linux__)
    *value = ENOKEY;
#elif !defined(ENOKEY)
    value = NULL;
#else
#error "ENOKEY defined"
#endif
    return value;
}

int32_t getValueOf_ENOLCK() {
    return ENOLCK;
}

int32_t* tryGetValueOf_ENOLINK(int32_t* value) {
#if defined (__OpenBSD__)
#if !defined(ENOLINK)
    value = NULL;
#else
#error "ENOLINK defined"
#endif
#else
    *value = ENOLINK;
#endif
    return value;
}

int32_t* tryGetValueOf_ENOMEDIUM(int32_t* value) {
#if defined (__linux__) || defined(__OpenBSD__)
    *value = ENOMEDIUM;
#elif !defined(ENOMEDIUM)
    value = NULL;
#else
#error "ENOMEDIUM defined"
#endif
    return value;
}

int32_t getValueOf_ENOMEM() {
    return ENOMEM;
}

int32_t getValueOf_ENOMSG() {
    return ENOMSG;
}

int32_t* tryGetValueOf_ENONET(int32_t* value) {
#if defined (__linux__)
    *value = ENONET;
#elif !defined(ENONET)
        value = NULL;
#else
#error "ENONET defined"
#endif
    return value;
}

int32_t* tryGetValueOf_ENOPKG(int32_t* value) {
#if defined (__linux__)
    *value = ENOPKG;
#elif !defined(ENOPKG)
    value = NULL;
#else
#error "ENOPKG defined"
#endif
    return value;
}

int32_t getValueOf_ENOPROTOOPT() {
    return ENOPROTOOPT;
}

int32_t getValueOf_ENOSPC() {
    return ENOSPC;
}

int32_t* tryGetValueOf_ENOSR(int32_t* value) {
#if defined(__linux__) || defined(__APPLE__)
    *value = ENOSR;
#elif !defined(ENOSR)
    value = NULL;
#else
#error "ENOSR defined"
#endif
    return value;
}

int32_t* tryGetValueOf_ENOSTR(int32_t* value) {
#if defined(__FreeBSD__) || defined(__OpenBSD__)
#if !defined(ENOSTR)
    value = NULL;
#else
#error "ENOSTR defined"
#endif
#else
    *value = ENOSTR;
#endif
    return value;
}

int32_t getValueOf_ENOSYS() {
    return ENOSYS;
}

int32_t getValueOf_ENOTBLK() {
    return ENOTBLK;
}

int32_t getValueOf_ENOTCONN() {
    return ENOTCONN;
}

int32_t getValueOf_ENOTDIR() {
    return ENOTDIR;
}

int32_t getValueOf_ENOTEMPTY() {
    return ENOTEMPTY;
}

int32_t* tryGetValueOf_ENOTNAM(int32_t* value) {
#if defined (__linux__)
    *value = ENOTNAM;
#elif !defined(ENOTNAM)
    value = NULL;
#else
#error "ENOTNAM defined"
#endif
    return value;
}

int32_t getValueOf_ENOTRECOVERABLE() {
    return ENOTRECOVERABLE;
}

int32_t getValueOf_ENOTSOCK() {
    return ENOTSOCK;
}

int32_t getValueOf_ENOTSUP() {
    return ENOTSUP;
}

int32_t getValueOf_ENOTTY() {
    return ENOTTY;
}

int32_t* tryGetValueOf_ENOTUNIQ(int32_t* value) {
#if defined (__linux__)
    *value = ENOTUNIQ;
#elif !defined(ENOTUNIQ)
        value = NULL;
#else
#error "ENOTUNIQ defined"
#endif
    return value;
}

int32_t getValueOf_ENXIO() {
    return ENXIO;
}

int32_t getValueOf_EOPNOTSUPP() {
    return EOPNOTSUPP;
}

int32_t getValueOf_EOVERFLOW() {
    return EOVERFLOW;
}

int32_t getValueOf_EOWNERDEAD() {
    return EOWNERDEAD;
}

int32_t getValueOf_EPERM() {
    return EPERM;
}

int32_t getValueOf_EPFNOSUPPORT() {
    return EPFNOSUPPORT;
}

int32_t getValueOf_EPIPE() {
    return EPIPE;
}

int32_t getValueOf_EPROTO() {
    return EPROTO;
}

int32_t getValueOf_EPROTONOSUPPORT() {
    return EPROTONOSUPPORT;
}

int32_t getValueOf_EPROTOTYPE() {
    return EPROTOTYPE;
}

int32_t* tryGetValueOf_EREMCHG(int32_t* value) {
#if defined (__linux__)
    *value = EREMCHG;
#elif !defined(EREMCHG)
    value = NULL;
#else
#error "EREMCHG defined"
#endif
    return value;
}

int32_t getValueOf_EREMOTE() {
    return EREMOTE;
}

int32_t* tryGetValueOf_EREMOTEIO(int32_t* value) {
#if defined (__linux__)
    *value = EREMOTEIO;
#elif !defined(EREMOTEIO)
    value = NULL;
#else
#error "EREMOTEIO defined"
#endif
    return value;
}

int32_t* tryGetValueOf_ERESTART(int32_t* value) {
#if defined (__linux__)
    *value = ERESTART;
#elif !defined(ERESTART)
    value = NULL;
#else
#error "ERESTART defined"
#endif
    return value;
}

int32_t* tryGetValueOf_ERFKILL(int32_t* value) {
#if defined (__linux__)
    *value = ERFKILL;
#elif !defined(ERFKILL)
    value = NULL;
#else
#error "ERFKILL defined"
#endif
    return value;
}

int32_t getValueOf_EROFS() {
    return EROFS;
}

int32_t getValueOf_ESHUTDOWN() {
    return ESHUTDOWN;
}

int32_t getValueOf_ESOCKTNOSUPPORT() {
    return ESOCKTNOSUPPORT;
}

int32_t getValueOf_ESPIPE() {
    return ESPIPE;
}

int32_t getValueOf_ESRCH() {
    return ESRCH;
}

int32_t* tryGetValueOf_ESRMNT(int32_t* value) {
#if defined (__linux__)
    *value = ESRMNT;
#elif !defined(ESRMNT)
    value = NULL;
#else
#error "ESRMNT defined"
#endif
    return value;
}

int32_t getValueOf_ESTALE() {
    return ESTALE;
}

int32_t* tryGetValueOf_ESTRPIPE(int32_t* value) {
#if defined (__linux__)
    *value = ESTRPIPE;
#elif !defined(ESTRPIPE)
    value = NULL;
#else
#error "ESTRPIPE defined"
#endif
    return value;
}

int32_t* tryGetValueOf_ETIME(int32_t* value) {
#if defined(__linux__) || defined(__APPLE__)
    *value = ETIME;
#elif !defined(ETIME)
    value = NULL;
#else
#error "ETIME defined"
#endif
    return value;
}

int32_t getValueOf_ETIMEDOUT() {
    return ETIMEDOUT;
}

int32_t getValueOf_ETOOMANYREFS() {
    return ETOOMANYREFS;
}

int32_t getValueOf_ETXTBSY() {
    return ETXTBSY;
}

int32_t* tryGetValueOf_EUCLEAN(int32_t* value) {
#if defined (__linux__)
    *value = EUCLEAN;
#elif !defined(EUCLEAN)
    value = NULL;
#else
#error "EUCLEAN defined"
#endif
    return value;
}

int32_t* tryGetValueOf_EUNATCH(int32_t* value) {
#if defined (__linux__)
    *value = EUNATCH;
#elif !defined(EUNATCH)
    value = NULL;
#else
#error "EUNATCH defined"
#endif
    return value;
}

int32_t getValueOf_EUSERS() {
    return EUSERS;
}

int32_t getValueOf_EWOULDBLOCK() {
    return EWOULDBLOCK;
}

int32_t getValueOf_EXDEV() {
    return EXDEV;
}

int32_t* tryGetValueOf_EXFULL(int32_t* value) {
#if defined (__linux__)
    *value = EXFULL;
#elif !defined(EXFULL)
    value = NULL;
#else
#error "EXFULL defined"
#endif
    return value;
}

#endif
