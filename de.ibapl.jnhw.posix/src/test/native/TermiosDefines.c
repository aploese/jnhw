/**
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2021-2024, Arne Plöse and individual contributors as indicated
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
#include <stddef.h>

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
#if !defined(HAVE_TERMIOS_H) || !defined(_POSIX_VERSION)

int32_t getValueOf_HAVE_TERMIOS_H() {
    return 0;
}
#else
#include <termios.h>
#include <errno.h>

int32_t getValueOf_HAVE_TERMIOS_H() {
    return 1;
}

int32_t* tryGetValueOf__HAVE_STRUCT_TERMIOS_C_ISPEED(int32_t* value) {
#if defined(_HAVE_STRUCT_TERMIOS_C_ISPEED)
    *value = _HAVE_STRUCT_TERMIOS_C_ISPEED;
#else
    value = NULL;
#endif
    return value;
}

int32_t* tryGetValueOf__HAVE_STRUCT_TERMIOS_C_OSPEED(int32_t* value) {
#if defined(_HAVE_STRUCT_TERMIOS_C_OSPEED)
    *value = _HAVE_STRUCT_TERMIOS_C_OSPEED;
#else
value = NULL;
#endif
    return value;
}

int32_t getValueOf_B0() {
    return B0;
}

int32_t* tryGetValueOf_B1000000(int32_t* value) {
#if defined (__linux__) || defined(__FreeBSD__)
    *value = B1000000;
#else
#if !defined(B1000000)
value = NULL;
#else
#error "B1000000 defined"
#endif
#endif
    return value;
}

int32_t getValueOf_B110() {
    return B110;
}

int32_t getValueOf_B115200() {
    return B115200;
}

int32_t* tryGetValueOf_B1152000(int32_t* value) {
#if defined (__linux__)
    *value = B1152000;
#else
#if !defined(B1152000)
value = NULL;
#else
#error "B1152000 defined"
#endif
#endif
    return value;
}

int32_t getValueOf_B1200() {
    return B1200;
}

int32_t getValueOf_B134() {
    return B134;
}

int32_t getValueOf_B150() {
    return B150;
}

int32_t* tryGetValueOf_B1500000(int32_t* value) {
#if defined(__linux__) || defined(__FreeBSD__)
    *value = B1500000;
#else
#if !defined(B1500000)
    value = NULL;
#else
#error "B1500000 defined"
#endif
#endif
    return value;
}

int32_t getValueOf_B1800() {
    return B1800;
}

int32_t getValueOf_B19200() {
    return B19200;
}

int32_t getValueOf_B200() {
    return B200;
}

int32_t* tryGetValueOf_B2000000(int32_t* value) {
#if defined(__linux__) || defined(__FreeBSD__)
    *value = B2000000;
#else
#if !defined(B2000000)
    value = NULL;
#else
#error "B2000000 defined"
#endif
#endif
    return value;
}

int32_t getValueOf_B230400() {
    return B230400;
}

int32_t getValueOf_B2400() {
    return B2400;
}

int32_t* tryGetValueOf_B2500000(int32_t* value) {
#if (defined(__linux__) && !defined(__sparc__)) || defined(__FreeBSD__)
    *value = B2500000;
#else
#if !defined(B2500000)
    value = NULL;
#else
#error "B2500000 defined"
#endif
#endif
    return value;
}

int32_t getValueOf_B300() {
    return B300;
}

int32_t* tryGetValueOf_B3000000(int32_t* value) {
#if (defined(__linux__) && !defined(__sparc__)) || defined(__FreeBSD__)
    *value = B3000000;
#else
#if !defined(B3000000)
    value = NULL;
#else
#error "B3000000 defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_B3500000(int32_t* value) {
#if (defined(__linux__) && !defined(__sparc__)) || defined(__FreeBSD__)
    *value = B3500000;
#else
#if !defined(B3500000)
    value = NULL;
#else
#error "B3500000 defined"
#endif
#endif
    return value;
}

int32_t getValueOf_B38400() {
    return B38400;
}

int32_t* tryGetValueOf_B4000000(int32_t* value) {
#if (defined(__linux__) && !defined(__sparc__)) || defined(__FreeBSD__)
    *value = B4000000;
#else
#if !defined(B4000000)
    value = NULL;
#else
#error "B4000000 defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_B460800(int32_t* value) {
#if defined(__linux__) || defined(__FreeBSD__)
    *value = B460800;
#else
#if !defined(B460800)
    value = NULL;
#else
#error "B460800 defined"
#endif
#endif
    return value;
}

int32_t getValueOf_B4800() {
    return B4800;
}

int32_t getValueOf_B50() {
    return B50;
}

int32_t* tryGetValueOf_B500000(int32_t* value) {
#if defined(__linux__) || defined(__FreeBSD__)
    *value = B500000;
#else
#if !defined(B500000)
    value = NULL;
#else
#error "B500000 defined"
#endif
#endif
    return value;
}

int32_t getValueOf_B57600() {
    return B57600;
}

int32_t* tryGetValueOf_B576000(int32_t* value) {
#if defined (__linux__)
    *value = B576000;
#else
#if !defined(B576000)
    value = NULL;
#else
#error "B576000 defined"
#endif
#endif
    return value;
}

int32_t getValueOf_B600() {
    return B600;
}

int32_t getValueOf_B75() {
    return B75;
}

int32_t* tryGetValueOf_B921600(int32_t* value) {
#if defined (__linux__) || defined (__FreeBSD__)
    *value = B921600;
#else
#if !defined(B921600)
    value = NULL;
#else
#error "B921600 defined"
#endif
#endif
    return value;
}

int32_t getValueOf_B9600() {
    return B9600;
}

int32_t getValueOf_BRKINT() {
    return BRKINT;
}

int32_t* tryGetValueOf_BS0(int32_t* value) {
#if defined (__linux__) || defined (__APPLE__)
    *value = BS0;
#else
#if !defined(BS0)
    value = NULL;
#else
#error "BS0 defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_BS1(int32_t* value) {
#if defined (__linux__) || defined (__APPLE__)
    *value = BS1;
#else
#if !defined(BS1)
    value = NULL;
#else
#error "BS1 defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_BSDLY(int32_t* value) {
#if defined (__linux__) || defined (__APPLE__)
    *value = BSDLY;
#else
#if !defined(BSDLY)
    value = NULL;
#else
#error "BSDLY defined"
#endif
#endif
    return value;
}

int32_t getValueOf_CLOCAL() {
    return CLOCAL;
}

int32_t* tryGetValueOf_CMSPAR(int32_t* value) {
#if defined(__linux__)
#if defined(CMSPAR)
        //it is defined for mips at least since glibc 2.31
    *value = CMSPAR;
#else
    value = NULL;
#endif
#else
    value = NULL;
#endif
    return value;
}

int32_t* tryGetValueOf_CR0(int32_t* value) {
#if defined (__linux__) || defined (__APPLE__)
    *value = CR0;
#else
#if !defined(CR0)
    value = NULL;
#else
#error "CR0 defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_CR1(int32_t* value) {
#if defined (__linux__) || defined (__APPLE__)
    *value = CR1;
#else
#if !defined(CR1)
    value = NULL;
#else
#error "CR1 defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_CR2(int32_t* value) {
#if defined (__linux__) || defined (__APPLE__)
    *value = CR2;
#else
#if !defined(CR2)
    value = NULL;
#else
#error "CR2 defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_CR3(int32_t* value) {
#if defined (__linux__) || defined (__APPLE__)
    *value = CR3;
#else
#if !defined(CR3)
    value = NULL;
#else
#error "CR3 defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_CRDLY(int32_t* value) {
#if defined (__linux__) || defined (__APPLE__)
    *value = CRDLY;
#else
#if !defined(CRDLY)
    value = NULL;
#else
#error "CRDLY defined"
#endif
#endif
    return value;
}

int32_t getValueOf_CREAD() {
    return CREAD;
}

int32_t getValueOf_CRTSCTS() {
#if defined (__linux__)
// detect at compiletime if unsigned
    uint32_t RESULT = CRTSCTS;
    return (int32_t)RESULT;
#else
    return CRTSCTS;
#endif
}

int32_t getValueOf_CS5() {
    return CS5;
}

int32_t getValueOf_CS6() {
    return CS6;
}

int32_t getValueOf_CS7() {
    return CS7;
}

int32_t getValueOf_CS8() {
    return CS8;
}

int32_t getValueOf_CSIZE() {
    return CSIZE;
}

int32_t getValueOf_CSTOPB() {
    return CSTOPB;
}

int32_t getValueOf_ECHO() {
    return ECHO;
}

int32_t getValueOf_ECHOE() {
    return ECHOE;
}

int32_t getValueOf_ECHOK() {
    return ECHOK;
}

int32_t getValueOf_ECHONL() {
    return ECHONL;
}

int32_t* tryGetValueOf_FF0(int32_t* value) {
#if defined (__linux__) || defined (__APPLE__)
    *value = FF0;
#else
#if !defined(FF0)
    value = NULL;
#else
#error "FF0 defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_FF1(int32_t* value) {
#if defined (__linux__) || defined (__APPLE__)
    *value = FF1;
#else
#if !defined(FF1)
    value = NULL;
#else
#error "FF1 defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_FFDLY(int32_t* value) {
#if defined (__linux__) || defined (__APPLE__)
    *value = FFDLY;
#else
#if !defined(FFDLY)
    value = NULL;
#else
#error "FFDLY defined"
#endif
#endif
    return value;
}

int32_t getValueOf_HUPCL() {
    return HUPCL;
}

int32_t getValueOf_ICANON() {
    return ICANON;
}

int32_t getValueOf_ICRNL() {
    return ICRNL;
}

int32_t getValueOf_IEXTEN() {
    return IEXTEN;
}

int32_t getValueOf_IGNBRK() {
    return IGNBRK;
}

int32_t getValueOf_IGNCR() {
    return IGNCR;
}

int32_t getValueOf_IGNPAR() {
    return IGNPAR;
}

int32_t getValueOf_INLCR() {
    return INLCR;
}

int32_t getValueOf_INPCK() {
    return INPCK;
}

int32_t getValueOf_ISIG() {
    return ISIG;
}

int32_t getValueOf_ISTRIP() {
    return ISTRIP;
}

int32_t getValueOf_IXANY() {
    return IXANY;
}

int32_t getValueOf_IXOFF() {
    return IXOFF;
}

int32_t getValueOf_IXON() {
    return IXON;
}

int32_t getValueOf_NCCS() {
    return NCCS;
}

int32_t* tryGetValueOf_NL0(int32_t* value) {
#if defined (__linux__) || defined (__APPLE__)
    *value = NL0;
#else
#if !defined(NL0)
    value = NULL;
#else
#error "NL0 defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_NL1(int32_t* value) {
#if defined (__linux__) || defined (__APPLE__)
    *value = NL1;
#else
#if !defined(NL1)
    value = NULL;
#else
#error "NL1 defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_NLDLY(int32_t* value) {
#if defined (__linux__) || defined (__APPLE__)
    *value = NLDLY;
#else
#if !defined(NLDLY)
    value = NULL;
#else
#error "NLDLY defined"
#endif
#endif
    return value;
}

int32_t getValueOf_NOFLSH() {
#if defined (__APPLE__) || defined (__FreeBSD__) || defined (__OpenBSD__) || (defined(__linux__) && (defined(__powerpc__) || defined(__alpha__)))
        return (int32_t) NOFLSH;
#else
        return NOFLSH;
#endif
}

int32_t getValueOf_OCRNL() {
    return OCRNL;
}

int32_t* tryGetValueOf_OFDEL(int32_t* value) {
#if defined (__linux__) || defined (__APPLE__)
    *value = OFDEL;
#else
#if !defined(OFDEL)
    value = NULL;
#else
#error "OFDEL defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_OFILL(int32_t* value) {
#if defined (__linux__) || defined (__APPLE__)
    *value = OFILL;
#else
#if !defined(OFILL)
    value = NULL;
#else
#error "OFILL defined"
#endif
#endif
    return value;
}

int32_t getValueOf_ONLCR() {
    return ONLCR;
}

int32_t getValueOf_ONLRET() {
    return ONLRET;
}

int32_t getValueOf_ONOCR() {
    return ONOCR;
}

int32_t getValueOf_OPOST() {
    return OPOST;
}

int32_t getValueOf_PARENB() {
    return PARENB;
}

int32_t* tryGetValueOf_PAREXT(int32_t* value) {
#if !defined(PAREXT)
    value = NULL;
#else
#error "PAREXT defined"
#endif
    return value;
}

int32_t getValueOf_PARMRK() {
    return PARMRK;
}

int32_t getValueOf_PARODD() {
    return PARODD;
}

int32_t* tryGetValueOf_TAB0(int32_t* value) {
#if defined(__OpenBSD__)
#if !defined(TAB0)
    value = NULL;
#else
#error "TAB0 defined"
#endif
#else
    *value = TAB0;
#endif
    return value;
}

int32_t* tryGetValueOf_TAB1(int32_t* value) {
#if defined (__linux__) || defined (__APPLE__)
    *value = TAB1;
#else
#if !defined(TAB1)
    value = NULL;
#else
#error "TAB1 defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_TAB2(int32_t* value) {
#if defined (__linux__) || defined (__APPLE__)
    *value = TAB2;
#else
#if !defined(TAB2)
    value = NULL;
#else
#error "TAB2 defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_TAB3(int32_t* value) {
#if defined(__OpenBSD__)
#if !defined(TAB3)
    value = NULL;
#else
#error "TAB3 defined"
#endif
#else
    *value = TAB3;
#endif
    return value;
}

int32_t* tryGetValueOf_TABDLY(int32_t* value) {
#if defined(__OpenBSD__)
#if !defined(TABDLY)
    value = NULL;
#else
#error "TABDLY defined"
#endif
#else
    *value = TABDLY;
#endif
    return value;
}

int32_t getValueOf_TCIFLUSH() {
    return TCIFLUSH;
}

int32_t getValueOf_TCIOFF() {
    return TCIOFF;
}

int32_t getValueOf_TCIOFLUSH() {
    return TCIOFLUSH;
}

int32_t getValueOf_TCION() {
    return TCION;
}

int32_t getValueOf_TCOFLUSH() {
    return TCOFLUSH;
}

int32_t getValueOf_TCOOFF() {
    return TCOOFF;
}

int32_t getValueOf_TCOON() {
    return TCOON;
}

int32_t getValueOf_TCSADRAIN() {
    return TCSADRAIN;
}

int32_t getValueOf_TCSAFLUSH() {
    return TCSAFLUSH;
}

int32_t getValueOf_TCSANOW() {
    return TCSANOW;
}

int32_t getValueOf_TOSTOP() {
    return TOSTOP;
}

int32_t getValueOf_VEOF() {
    return VEOF;
}

int32_t getValueOf_VEOL() {
    return VEOL;
}

int32_t getValueOf_VERASE() {
    return VERASE;
}

int32_t getValueOf_VINTR() {
    return VINTR;
}

int32_t getValueOf_VKILL() {
    return VKILL;
}

int32_t getValueOf_VMIN() {
    return VMIN;
}

int32_t getValueOf_VQUIT() {
    return VQUIT;
}

int32_t getValueOf_VSTART() {
    return VSTART;
}

int32_t getValueOf_VSTOP() {
    return VSTOP;
}

int32_t getValueOf_VSUSP() {
    return VSUSP;
}

int32_t* tryGetValueOf_VT0(int32_t* value) {
#if defined (__linux__) || defined (__APPLE__)
    *value = VT0;
#else
#if !defined(VT0)
    value = NULL;
#else
#error "VT0 defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_VT1(int32_t* value) {
#if defined (__linux__) || defined (__APPLE__)
    *value = VT1;
#else
#if !defined(VT1)
    value = NULL;
#else
#error "VT1 defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_VTDLY(int32_t* value) {
#if defined (__linux__) || defined (__APPLE__)
    *value = VTDLY;
#else
#if !defined(VTDLY)
    value = NULL;
#else
#error "VTDLY defined"
#endif
#endif
    return value;
}

int32_t getValueOf_VTIME() {
    return VTIME;
}

#endif
