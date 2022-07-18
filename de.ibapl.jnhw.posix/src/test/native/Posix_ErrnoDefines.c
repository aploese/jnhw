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
#include "jnhw-posix.h"

//We need the POSIX version ...
#if !defined(HAVE_ERRNO_H) || !defined(_POSIX_VERSION)
#else
#include <errno.h>

int getValueOf_E2BIG() {
    return E2BIG;
}

int getValueOf_EACCES() {
    return EACCES;
}

int getValueOf_EADDRINUSE() {
    return EADDRINUSE;
}

int getValueOf_EADDRNOTAVAIL() {
    return EADDRNOTAVAIL;
}

int* tryGetValueOf_EADV(int* value) {
#if defined (__linux__)
    *value = EADV;
#elif !defined(EADV)
    value = NULL;
#else
#error "EADV defined"
#endif
    return value;
}

int getValueOf_EAFNOSUPPORT() {
    return EAFNOSUPPORT;
}

int getValueOf_EAGAIN() {
    return EAGAIN;
}

int getValueOf_EALREADY() {
    return EALREADY;
}

int* tryGetValueOf_EBADE(int* value) {
#if defined (__linux__)
    *value = EBADE;
#elif !defined(EBADE)
    value = NULL;
#else
#error "EBADE defined"
#endif
    return value;
}

int getValueOf_EBADF() {
    return EBADF;
}

int* tryGetValueOf_EBADFD(int* value) {
#if defined (__linux__)
    *value = EBADFD;
#elif !defined(EBADFD)
    value = NULL;
#else
#error "EBADFD defined"
#endif
    return value;
}

int getValueOf_EBADMSG() {
    return EBADMSG;
}

int* tryGetValueOf_EBADR(int* value) {
#if defined (__linux__)
    *value = EBADR;
#elif !defined(EBADR)
    value = NULL;
#else
#error "EBADR defined"
#endif
    return value;
}

int* tryGetValueOf_EBADRQC(int* value) {
#if defined (__linux__)
    *value = EBADRQC;
#elif !defined(EBADRQC)
    value = NULL;
#else
#error "EBADRQC defined"
#endif
    return value;
}

int* tryGetValueOf_EBADSLT(int* value) {
#if defined (__linux__)
    *value = EBADSLT;
#elif !defined(EBADSLT)
    value = NULL;
#else
#error "EBADSLT defined"
#endif
    return value;
}

int* tryGetValueOf_EBFONT(int* value) {
#if defined (__linux__)
    *value = EBFONT;
#elif !defined(EBFONT)
    valkue = NULL;
#else
#error "EBFONT defined"
#endif
    return value;
}

int getValueOf_EBUSY() {
    return EBUSY;
}

int getValueOf_ECANCELED() {
    return ECANCELED;
}

int getValueOf_ECHILD() {
    return ECHILD;
}

int* tryGetValueOf_ECHRNG(int* value) {
#if defined (__linux__)
    *value = ECHRNG;
#elif !defined(ECHRNG)
    value = NULL;
#else
#error "ECHRNG defined"
#endif
    return value;
}

int* tryGetValueOf_ECOMM(int* value) {
#if defined (__linux__)
    *value = ECOMM;
#elif !defined(ECOMM)
    value = NULL;
#else
#error "ECOMM defined"
#endif
    return value;
}

int getValueOf_ECONNABORTED() {
    return ECONNABORTED;
}

int getValueOf_ECONNREFUSED() {
    return ECONNREFUSED;
}

int getValueOf_ECONNRESET() {
    return ECONNRESET;
}

int getValueOf_EDEADLK() {
    return EDEADLK;
}

int* tryGetValueOf_EDEADLOCK(int* value) {
#if defined (__linux__)
    *value = EDEADLOCK;
#elif !defined(EDEADLOCK)
    value = NULL;
#else
#error "EDEADLOCK defined"
#endif
    return value;
}

int getValueOf_EDESTADDRREQ() {
    return EDESTADDRREQ;
}

int* tryGetValueOf_EDOTDOT(int* value) {
#if defined (__linux__)
    *value = EDOTDOT;
#elif !defined(EDOTDOT)
    value = NULL;
#else
#error "EDOTDOT defined"
#endif
    return value;
}

int getValueOf_EDQUOT() {
    return EDQUOT;
}

int getValueOf_EEXIST() {
    return EEXIST;
}

int getValueOf_EFAULT() {
    return EFAULT;
}

int getValueOf_EFBIG() {
    return EFBIG;
}

int getValueOf_EHOSTDOWN() {
    return EHOSTDOWN;
}

int getValueOf_EHOSTUNREACH() {
    return EHOSTUNREACH;
}

int* tryGetValueOf_EHWPOISON(int* value) {
#if defined (__linux__)
    *value = EHWPOISON;
#elif !defined(EHWPOISON)
    value = NULL;
#else
#error "EHWPOISON defined"
#endif
    return value;
}

int getValueOf_EIDRM() {
    return EIDRM;
}

int getValueOf_EINPROGRESS() {
    return EINPROGRESS;
}

int getValueOf_EINTR() {
    return EINTR;
}

int getValueOf_EINVAL() {
    return EINVAL;
}

int getValueOf_EIO() {
    return EIO;
}

int getValueOf_EISCONN() {
    return EISCONN;
}

int getValueOf_EISDIR() {
    return EISDIR;
}

int* tryGetValueOf_EISNAM(int* value) {
#if defined (__linux__)
    *value = EISNAM;
#elif !defined(EISNAM)
    value = NULL;
#else
#error "EISNAM defined"
#endif
    return value;
}

int* tryGetValueOf_EKEYEXPIRED(int* value) {
#if defined (__linux__)
    *value = EKEYEXPIRED;
#elif !defined(EKEYEXPIRED)
    value = NULL;
#else
#error "EKEYEXPIRED defined"
#endif
    return value;
}

int* tryGetValueOf_EKEYREJECTED(int* value) {
#if defined (__linux__)
    *value = EKEYREJECTED;
#elif !defined(EKEYREJECTED)
    value = NULL;
#else
#error "EKEYREJECTED defined"
#endif
    return value;
}

int* tryGetValueOf_EKEYREVOKED(int* value) {
#if defined (__linux__)
    *value = EKEYREVOKED;
#elif !defined(EKEYREVOKED)
    value = NULL;
#else
#error "EKEYREVOKED defined"
#endif
    return value;
}

int* tryGetValueOf_EL2HLT(int* value) {
#if defined (__linux__)
    *value = EL2HLT;
#elif !defined(EL2HLT)
    value = NULL;
#else
#error "EL2HLT defined"
#endif
    return value;
}

int* tryGetValueOf_EL2NSYNC(int* value) {
#if defined (__linux__)
    *value = EL2NSYNC;
#elif !defined(EL2NSYNC)
    value = NULL;
#else
#error "EL2NSYNC defined"
#endif
    return value;
}

int* tryGetValueOf_EL3HLT(int* value) {
#if defined (__linux__)
    *value = EL3HLT;
#elif !defined(EL3HLT)
    value = NULL;
#else
#error "EL3HLT defined"
#endif
    return value;
}

int* tryGetValueOf_EL3RST(int* value) {
#if defined (__linux__)
    *value = EL3RST;
#elif !defined(EL3RST)
    value = NULL;
#else
#error "EL3RST defined"
#endif
    return value;
}

int* tryGetValueOf_ELIBACC(int* value) {
#if defined (__linux__)
    *value = ELIBACC;
#elif !defined(ELIBACC)
    value = NULL;
#else
#error "ELIBACC defined"
#endif
    return value;
}

int* tryGetValueOf_ELIBBAD(int* value) {
#if defined (__linux__)
    *value = ELIBBAD;
#elif !defined(ELIBBAD)
    value = NULL;
#else
#error "ELIBBAD defined"
#endif
    return value;
}

int* tryGetValueOf_ELIBEXEC(int* value) {
#if defined (__linux__)
    *value = ELIBEXEC;
#elif !defined(ELIBEXEC)
    value = NULL;
#else
#error "ELIBEXEC defined"
#endif
    return value;
}

int* tryGetValueOf_ELIBMAX(int* value) {
#if defined (__linux__)
    *value = ELIBMAX;
#elif !defined(ELIBMAX)
    value = NULL;
#else
#error "ELIBMAX defined"
#endif
    return value;
}

int* tryGetValueOf_ELIBSCN(int* value) {
#if defined (__linux__)
    *value = ELIBSCN;
#elif !defined(ELIBSCN)
    value = NULL;
#else
#error "ELIBSCN defined"
#endif
    return value;
}

int* tryGetValueOf_ELNRNG(int* value) {
#if defined (__linux__)
    *value = ELNRNG;
#elif !defined(ELNRNG)
    value = NULL;
#else
#error "ELNRNG defined"
#endif
    return value;
}

int getValueOf_ELOOP() {
    return ELOOP;
}

int* tryGetValueOf_EMEDIUMTYPE(int* value) {
#if defined (__linux__) || defined(__OpenBSD__)
    *value = EMEDIUMTYPE;
#elif !defined(EMEDIUMTYPE)
    value = NULL;
#else
#error "EMEDIUMTYPE defined"
#endif
    return value;
}

int getValueOf_EMFILE() {
    return EMFILE;
}

int getValueOf_EMLINK() {
    return EMLINK;
}

int getValueOf_EMSGSIZE() {
    return EMSGSIZE;
}

int* tryGetValueOf_EMULTIHOP(int* value) {
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

int getValueOf_ENAMETOOLONG() {
    return ENAMETOOLONG;
}

int* tryGetValueOf_ENAVAIL(int* value) {
#if defined (__linux__)
    *value = ENAVAIL;
#elif !defined(ENAVAIL)
    value = NULL;
#else
#error "ENAVAIL defined"
#endif
    return value;
}

int getValueOf_ENETDOWN() {
    return ENETDOWN;
}

int getValueOf_ENETRESET() {
    return ENETRESET;
}

int getValueOf_ENETUNREACH() {
    return ENETUNREACH;
}

int getValueOf_ENFILE() {
    return ENFILE;
}

int* tryGetValueOf_ENOANO(int* value) {
#if defined (__linux__)
    *value = ENOANO;
#elif !defined(ENOANO)
    value = NULL;
#else
#error "ENOANO defined"
#endif
    return value;
}

int getValueOf_ENOBUFS() {
    return ENOBUFS;
}

int* tryGetValueOf_ENOCSI(int* value) {
#if defined (__linux__)
    *value = ENOCSI;
#elif !defined(ENOCSI)
    value = NULL;
#else
#error "ENOCSI defined"
#endif
    return value;
}

int* tryGetValueOf_ENODATA(int* value) {
#if defined(__linux__) || defined(__APPLE__)
    *value = ENODATA;
#elif !defined(ENODATA)
    value = NULL;
#else
#error "ENODATA defined"
#endif
    return value;
}

int getValueOf_ENODEV() {
    return ENODEV;
}

int getValueOf_ENOENT() {
    return ENOENT;
}

int getValueOf_ENOEXEC() {
    return ENOEXEC;
}

int* tryGetValueOf_ENOKEY(int* value) {
#if defined (__linux__)
    *value = ENOKEY;
#elif !defined(ENOKEY)
    value = NULL;
#else
#error "ENOKEY defined"
#endif
    return value;
}

int getValueOf_ENOLCK() {
    return ENOLCK;
}

int* tryGetValueOf_ENOLINK(int* value) {
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

int* tryGetValueOf_ENOMEDIUM(int* value) {
#if defined (__linux__) || defined(__OpenBSD__)
    *value = ENOMEDIUM;
#elif !defined(ENOMEDIUM)
    value = NULL;
#else
#error "ENOMEDIUM defined"
#endif
    return value;
}

int getValueOf_ENOMEM() {
    return ENOMEM;
}

int getValueOf_ENOMSG() {
    return ENOMSG;
}

int* tryGetValueOf_ENONET(int* value) {
#if defined (__linux__)
    *value = ENONET;
#elif !defined(ENONET)
        value = NULL;
#else
#error "ENONET defined"
#endif
    return value;
}

int* tryGetValueOf_ENOPKG(int* value) {
#if defined (__linux__)
    *value = ENOPKG;
#elif !defined(ENOPKG)
    value = NULL;
#else
#error "ENOPKG defined"
#endif
    return value;
}

int getValueOf_ENOPROTOOPT() {
    return ENOPROTOOPT;
}

int getValueOf_ENOSPC() {
    return ENOSPC;
}

int* tryGetValueOf_ENOSR(int* value) {
#if defined(__linux__) || defined(__APPLE__)
    *value = ENOSR;
#elif !defined(ENOSR)
    value = NULL;
#else
#error "ENOSR defined"
#endif
    return value;
}

int* tryGetValueOf_ENOSTR(int* value) {
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

int getValueOf_ENOSYS() {
    return ENOSYS;
}

int getValueOf_ENOTBLK() {
    return ENOTBLK;
}

int getValueOf_ENOTCONN() {
    return ENOTCONN;
}

int getValueOf_ENOTDIR() {
    return ENOTDIR;
}

int getValueOf_ENOTEMPTY() {
    return ENOTEMPTY;
}

int* tryGetValueOf_ENOTNAM(int* value) {
#if defined (__linux__)
    *value = ENOTNAM;
#elif !defined(ENOTNAM)
    value = NULL;
#else
#error "ENOTNAM defined"
#endif
    return value;
}

int getValueOf_ENOTRECOVERABLE() {
    return ENOTRECOVERABLE;
}

int getValueOf_ENOTSOCK() {
    return ENOTSOCK;
}

int getValueOf_ENOTSUP() {
    return ENOTSUP;
}

int getValueOf_ENOTTY() {
    return ENOTTY;
}

int* tryGetValueOf_ENOTUNIQ(int* value) {
#if defined (__linux__)
    *value = ENOTUNIQ;
#elif !defined(ENOTUNIQ)
        value = NULL;
#else
#error "ENOTUNIQ defined"
#endif
    return value;
}

int getValueOf_ENXIO() {
    return ENXIO;
}

int getValueOf_EOPNOTSUPP() {
    return EOPNOTSUPP;
}

int getValueOf_EOVERFLOW() {
    return EOVERFLOW;
}

int getValueOf_EOWNERDEAD() {
    return EOWNERDEAD;
}

int getValueOf_EPERM() {
    return EPERM;
}

int getValueOf_EPFNOSUPPORT() {
    return EPFNOSUPPORT;
}

int getValueOf_EPIPE() {
    return EPIPE;
}

int getValueOf_EPROTO() {
    return EPROTO;
}

int getValueOf_EPROTONOSUPPORT() {
    return EPROTONOSUPPORT;
}

int getValueOf_EPROTOTYPE() {
    return EPROTOTYPE;
}

int* tryGetValueOf_EREMCHG(int* value) {
#if defined (__linux__)
    *value = EREMCHG;
#elif !defined(EREMCHG)
    value = NULL;
#else
#error "EREMCHG defined"
#endif
    return value;
}

int getValueOf_EREMOTE() {
    return EREMOTE;
}

int* tryGetValueOf_EREMOTEIO(int* value) {
#if defined (__linux__)
    *value = EREMOTEIO;
#elif !defined(EREMOTEIO)
    value = NULL;
#else
#error "EREMOTEIO defined"
#endif
    return value;
}

int* tryGetValueOf_ERESTART(int* value) {
#if defined (__linux__)
    *value = ERESTART;
#elif !defined(ERESTART)
    value = NULL;
#else
#error "ERESTART defined"
#endif
    return value;
}

int* tryGetValueOf_ERFKILL(int* value) {
#if defined (__linux__)
    *value = ERFKILL;
#elif !defined(ERFKILL)
    value = NULL;
#else
#error "ERFKILL defined"
#endif
    return value;
}

int getValueOf_EROFS() {
    return EROFS;
}

int getValueOf_ESHUTDOWN() {
    return ESHUTDOWN;
}

int getValueOf_ESOCKTNOSUPPORT() {
    return ESOCKTNOSUPPORT;
}

int getValueOf_ESPIPE() {
    return ESPIPE;
}

int getValueOf_ESRCH() {
    return ESRCH;
}

int* tryGetValueOf_ESRMNT(int* value) {
#if defined (__linux__)
    *value = ESRMNT;
#elif !defined(ESRMNT)
    value = NULL;
#else
#error "ESRMNT defined"
#endif
    return value;
}

int getValueOf_ESTALE() {
    return ESTALE;
}

int* tryGetValueOf_ESTRPIPE(int* value) {
#if defined (__linux__)
    *value = ESTRPIPE;
#elif !defined(ESTRPIPE)
    value = NULL;
#else
#error "ESTRPIPE defined"
#endif
    return value;
}

int* tryGetValueOf_ETIME(int* value) {
#if defined(__linux__) || defined(__APPLE__)
    *value = ETIME;
#elif !defined(ETIME)
    value = NULL;
#else
#error "ETIME defined"
#endif
    return value;
}

int getValueOf_ETIMEDOUT() {
    return ETIMEDOUT;
}

int getValueOf_ETOOMANYREFS() {
    return ETOOMANYREFS;
}

int getValueOf_ETXTBSY() {
    return ETXTBSY;
}

int* tryGetValueOf_EUCLEAN(int* value) {
#if defined (__linux__)
    *value = EUCLEAN;
#elif !defined(EUCLEAN)
    value = NULL;
#else
#error "EUCLEAN defined"
#endif
    return value;
}

int* tryGetValueOf_EUNATCH(int* value) {
#if defined (__linux__)
    *value = EUNATCH;
#elif !defined(EUNATCH)
    value = NULL;
#else
#error "EUNATCH defined"
#endif
    return value;
}

int getValueOf_EUSERS() {
    return EUSERS;
}

int getValueOf_EWOULDBLOCK() {
    return EWOULDBLOCK;
}

int getValueOf_EXDEV() {
    return EXDEV;
}

int* tryGetValueOf_EXFULL(int* value) {
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
