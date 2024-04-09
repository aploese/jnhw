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
#include "jnhw-posix.h"

    //We need the POSIX version ...
#if !defined(HAVE_LOCALE_H) || !defined(_POSIX_VERSION)

int32_t getValueOf_HAVE_LOCALE_H() {
    return 0;
}

#else
#include <locale.h>
#if defined (__APPLE__)
#include <xlocale.h>
#endif

int32_t getValueOf_HAVE_LOCALE_H() {
    return 1;
}


int32_t getValueOf_LC_ALL() {
    return LC_ALL;
}

int32_t getValueOf_LC_ALL_MASK() {
    return LC_ALL_MASK;
}

int32_t getValueOf_LC_COLLATE() {
    return LC_COLLATE;
}

int32_t getValueOf_LC_COLLATE_MASK() {
    return LC_COLLATE_MASK;
}

int32_t getValueOf_LC_CTYPE() {
    return LC_CTYPE;
}

int32_t getValueOf_LC_CTYPE_MASK() {
    return LC_CTYPE_MASK;
}

locale_t getValueOf_LC_GLOBAL_LOCALE() {
    return LC_GLOBAL_LOCALE;
}

int32_t getValueOf_LC_MESSAGES() {
    return LC_MESSAGES;
}

int32_t getValueOf_LC_MESSAGES_MASK() {
    return LC_MESSAGES_MASK;
}

int32_t getValueOf_LC_MONETARY() {
    return LC_MONETARY;
}

int32_t getValueOf_LC_MONETARY_MASK() {
    return LC_MONETARY_MASK;
}

int32_t getValueOf_LC_NUMERIC() {
    return LC_NUMERIC;
}

int32_t getValueOf_LC_NUMERIC_MASK() {
    return LC_NUMERIC_MASK;
}

int32_t getValueOf_LC_TIME() {
    return LC_TIME;
}

int32_t getValueOf_LC_TIME_MASK() {
    return LC_TIME_MASK;
}

#endif