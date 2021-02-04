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
#include "de_ibapl_jnhw_posix_Termios.h"

#ifdef __cplusplus
extern "C" {
#endif

    //We need the POSIX version ...    
#if !defined(HAVE_TERMIOS_H) || !defined(_POSIX_VERSION)

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_initFields
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    }
#else
#include <termios.h>
#include <errno.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Termios
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_initFields
    (JNIEnv *env, jclass clazz) {

        if (JnhwSetStaticBooleanField(env, clazz, "HAVE_TERMIOS_H", JNI_TRUE)) {
            return;
        }

#if defined(_HAVE_STRUCT_TERMIOS_C_ISPEED)
        if (JnhwSetStaticIntDefineField(env, clazz, "_HAVE_STRUCT_TERMIOS_C_ISPEED", _HAVE_STRUCT_TERMIOS_C_ISPEED)) {
            return;
        }
#endif

#if defined(_HAVE_STRUCT_TERMIOS_C_OSPEED)
        if (JnhwSetStaticIntDefineField(env, clazz, "_HAVE_STRUCT_TERMIOS_C_OSPEED", _HAVE_STRUCT_TERMIOS_C_OSPEED)) {
            return;
        }
#endif

        if (JnhwSetStaticIntField(env, clazz, "B0", B0)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "B50", B50)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "B75", B75)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "B110", B110)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "B134", B134)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "B150", B150)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "B200", B200)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "B300", B300)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "B600", B600)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "B1200", B1200)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "B1800", B1800)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "B2400", B2400)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "B4800", B4800)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "B9600", B9600)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "B19200", B19200)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "B38400", B38400)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "B57600", B57600)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "B115200", B115200)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "B230400", B230400)) {
            return;
        }
#if defined (__linux__) || defined (__FreeBSD__)
        if (JnhwSetStaticIntDefineField(env, clazz, "B460800", B460800)) {
            return;
        }
#elif defined(B460800)
#error "B460800 defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "B500000", B500000)) {
            return;
        }
#elif defined(B500000)
#error "B500000 defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "B576000", B576000)) {
            return;
        }
#elif defined(B576000)
#error "B576000 defined"
#endif

#if defined (__linux__) || defined (__FreeBSD__)
        if (JnhwSetStaticIntDefineField(env, clazz, "B921600", B921600)) {
            return;
        }
#elif defined(B921600)
#error "B921600 defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "B1000000", B1000000)) {
            return;
        }
#elif defined(B1000000)
#error "B1000000 defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "B1152000", B1152000)) {
            return;
        }
#elif defined(B1152000)
#error "B1152000 defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "B1500000", B1500000)) {
            return;
        }
#elif defined(B1500000)
#error "B1500000 defined"
#endif

#if defined (__linux__)
        if (JnhwSetStaticIntDefineField(env, clazz, "B2000000", B2000000)) {
            return;
        }
#elif defined(B2000000)
#error "B2000000 defined"
#endif

#if defined (__linux__) && !defined(__sparc__)
        if (JnhwSetStaticIntDefineField(env, clazz, "B2500000", B2500000)) {
            return;
        }
#elif defined(B2500000)
#error "B2500000 defined"
#endif

#if defined (__linux__) && !defined(__sparc__)
        if (JnhwSetStaticIntDefineField(env, clazz, "B3000000", B3000000)) {
            return;
        }
#elif defined(B3000000)
#error "B3000000 defined"
#endif

#if defined (__linux__) && !defined(__sparc__)
        if (JnhwSetStaticIntDefineField(env, clazz, "B3500000", B3500000)) {
            return;
        }
#elif defined(B3500000)
#error "B3500000 defined"
#endif

#if defined (__linux__) && !defined(__sparc__)
        if (JnhwSetStaticIntDefineField(env, clazz, "B4000000", B4000000)) {
            return;
        }
#elif defined(B4000000)
#error "B4000000 defined"
#endif

        if (JnhwSetStaticIntField(env, clazz, "CLOCAL", CLOCAL)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ECHO", ECHO)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ECHOE", ECHOE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ECHOK", ECHOK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ECHONL", ECHONL)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ICANON", ICANON)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "IEXTEN", IEXTEN)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ISIG", ISIG)) {
            return;
        }

#if defined (__APPLE__) || defined (__FreeBSD__) || defined (__OpenBSD__) || (defined(__linux__) && (defined(__powerpc__) || defined(__alpha__)))
        if (JnhwSetStaticIntField(env, clazz, "NOFLSH", (int32_t) NOFLSH)) {
            return;
        }
#else
        if (JnhwSetStaticIntField(env, clazz, "NOFLSH", NOFLSH)) {
            return;
        }
#endif

        if (JnhwSetStaticIntField(env, clazz, "TOSTOP", TOSTOP)) {
            return;
        }

#if defined(__linux__) && !defined(__mips__)
        if (JnhwSetStaticIntDefineField(env, clazz, "CMSPAR", CMSPAR)) {
            return;
        }
#elif defined(CMSPAR)
#error "CMSPAR defined"
#endif

        if (JnhwSetStaticIntField(env, clazz, "CREAD", CREAD)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "CRTSCTS", (int32_t) CRTSCTS)) {
            return;
        }

        if (JnhwSetStaticIntField(env, clazz, "CS5", CS5)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "CS6", CS6)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "CS7", CS7)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "CS8", CS8)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "CSIZE", CSIZE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "CSTOPB", CSTOPB)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "BRKINT", BRKINT)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ICRNL", ICRNL)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "IGNBRK", IGNBRK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "IGNCR", IGNCR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "IGNPAR", IGNPAR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "INLCR", INLCR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "INPCK", INPCK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ISTRIP", ISTRIP)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "IXANY", IXANY)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "IXOFF", IXOFF)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "IXON", IXON)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "PARENB", PARENB)) {
            return;
        }

#if defined(PAREXT)
#error "PAREXT defined"
#endif

        if (JnhwSetStaticIntField(env, clazz, "PARMRK", PARMRK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "OPOST", OPOST)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ONLCR", ONLCR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "OCRNL", OCRNL)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ONOCR", ONOCR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ONLRET", ONLRET)) {
            return;
        }

#if defined (__linux__) || defined (__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "OFDEL", OFDEL)) {
            return;
        }
#elif defined(OFDEL)
#error "OFDEL defined"
#endif

#if defined (__linux__) || defined (__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "OFILL", OFILL)) {
            return;
        }
#elif defined(OFILL)
#error "OFILL defined"
#endif

#if defined (__linux__) || defined (__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "NLDLY", NLDLY)) {
            return;
        }
#elif defined(NLDLY)
#error "NLDLY defined"
#endif

#if defined (__linux__) || defined (__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "NL0", NL0)) {
            return;
        }
#elif defined(NL0)
#error "NL0 defined"
#endif

#if defined (__linux__) || defined (__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "NL1", NL1)) {
            return;
        }
#elif defined(NL1)
#error "NL1 defined"
#endif

#if defined (__linux__) || defined (__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "CRDLY", CRDLY)) {
            return;
        }
#elif defined(CRDLY)
#error "CRDLY defined"
#endif

#if defined (__linux__) || defined (__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "CR0", CR0)) {
            return;
        }
#elif defined(CR0)
#error "CR0 defined"
#endif

#if defined (__linux__) || defined (__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "CR1", CR1)) {
            return;
        }
#elif defined(CR1)
#error "CR1 defined"
#endif

#if defined (__linux__) || defined (__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "CR2", CR2)) {
            return;
        }
#elif defined(CR2)
#error "CR2 defined"
#endif

#if defined (__linux__) || defined (__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "CR3", CR3)) {
            return;
        }
#elif defined(CR3)
#error "CR3 defined"
#endif

#if defined(__OpenBSD__)
#if defined(TABDLY)
#error "TABDLY defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "TABDLY", TABDLY)) {
            return;
        }
#endif

#if defined(__OpenBSD__)
#if defined(TAB0)
#error "TAB0 defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "TAB0", TAB0)) {
            return;
        }
#endif

#if defined (__linux__) || defined (__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "TAB1", TAB1)) {
            return;
        }
#elif defined(TAB1)
#error "TAB1 defined"
#endif

#if defined (__linux__) || defined (__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "TAB2", TAB2)) {
            return;
        }
#elif defined(TAB2)
#error "TAB2 defined"
#endif

#if defined(__OpenBSD__)
#if defined(TAB3)
#error "TAB3 defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "TAB3", TAB3)) {
            return;
        }
#endif

#if defined (__linux__) || defined (__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "BSDLY", BSDLY)) {
            return;
        }
#elif defined(BSDLY)
#error "BSDLY defined"
#endif

#if defined (__linux__) || defined (__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "BS0", BS0)) {
            return;
        }
#elif defined(BS0)
#error "BS0 defined"
#endif

#if defined (__linux__) || defined (__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "BS1", BS1)) {
            return;
        }
#elif defined(BS1)
#error "BS1 defined"
#endif

#if defined (__linux__) || defined (__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "VTDLY", VTDLY)) {
            return;
        }
#elif defined(VTDLY)
#error "VTDLY defined"
#endif

#if defined (__linux__) || defined (__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "VT0", VT0)) {
            return;
        }
#elif defined(VT0)
#error "VT0 defined"
#endif

#if defined (__linux__) || defined (__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "VT1", VT1)) {
            return;
        }
#elif defined(VT1)
#error "VT1 defined"
#endif

#if defined (__linux__) || defined (__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "FFDLY", FFDLY)) {
            return;
        }
#elif defined(FFDLY)
#error "FFDLY defined"
#endif

#if defined (__linux__) || defined (__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "FF0", FF0)) {
            return;
        }
#elif defined(FF0)
#error "FF0 defined"
#endif

#if defined (__linux__) || defined (__APPLE__)
        if (JnhwSetStaticIntDefineField(env, clazz, "FF1", FF1)) {
            return;
        }
#elif defined(FF1)
#error "FF1 defined"
#endif

        if (JnhwSetStaticIntField(env, clazz, "PARODD", PARODD)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "HUPCL", HUPCL)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TCSANOW", TCSANOW)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TCSADRAIN", TCSADRAIN)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TCSAFLUSH", TCSAFLUSH)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TCIFLUSH", TCIFLUSH)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TCIOFLUSH", TCIOFLUSH)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TCOFLUSH", TCOFLUSH)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TCIOFF", TCIOFF)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TCION", TCION)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TCOOFF", TCOOFF)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TCOON", TCOON)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "VEOF", VEOF)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "VEOL", VEOL)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "VERASE", VERASE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "VINTR", VINTR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "VKILL", VKILL)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "VMIN", VMIN)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "VQUIT", VQUIT)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "VSTART", VSTART)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "VSTOP", VSTOP)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "VSUSP", VSUSP)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "VTIME", VTIME)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "NCCS", NCCS)) {
            return;
        }
    }

#endif
#ifdef __cplusplus
}
#endif
