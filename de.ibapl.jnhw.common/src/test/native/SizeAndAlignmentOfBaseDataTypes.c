/**
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2022-2024, Arne Plöse and individual contributors as indicated
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
#include <stdint.h>

int isDefined__L64() {
#ifdef _L64
    return 1;
#else
    return 0;
#endif 
}

int isDefined__LP64() {
#ifdef _LP64
    return 1;
#else
    return 0;
#endif 
}

int isDefined__ILP64() {
#ifdef _ILP64
    return 1;
#else
    return 0;
#endif 
}

int isDefined__LLP64() {
#ifdef _LLP64
    return 1;
#else
    return 0;
#endif 
}

int isDefined__ILP32() {
#ifdef _ILP32
    return 1;
#else
    return 0;
#endif 
}

int isDefined__LP32() {
#ifdef _LP32
    return 1;
#else
    return 0;
#endif 
}

int alignOf_int8_t() {
    return __alignof__ (int8_t);
}

int alignOf_int16_t() {
    return __alignof__ (int16_t);
}

int alignOf_int32_t() {
    return __alignof__ (int32_t);
}

int alignOf_int64_t() {
    return __alignof__ (int64_t);
}

int alignOf_intptr_t() {
    return __alignof__ (intptr_t);
}

int sizeOf_intptr_t() {
    return sizeof (intptr_t);
}

int alignOf_pointer() {
    return __alignof__ (void*);
}

int sizeOf_pointer() {
    return sizeof (void*);
}

int alignOf_int() {
    return __alignof__ (int);
}

int sizeOf_int() {
    return sizeof (int);
}

int alignOf_long() {
    return __alignof__ (long);
}

int sizeOf_long() {
    return sizeof (long);
}

int alignOf_long_long() {
    return __alignof__ (long long);
}

int sizeOf_long_long() {
    return sizeof (long long);
}

int alignOf_float() {
    return __alignof__ (float);
}

int sizeOf_float() {
    return sizeof (float);
}

int alignOf_double() {
    return __alignof__ (double);
}

int sizeOf_double() {
    return sizeof (double);
}

int alignOf_long_double() {
    return __alignof__ (long double);
}


int sizeOf_long_double() {
    return sizeof (long double);
}

int get__BIGGEST_ALIGNMENT__() {
    return __BIGGEST_ALIGNMENT__;
}

uintptr_t JnhwUintptrT__MA___V_0x0000000080000000L() {
    return (uintptr_t)0x0000000080000000L;
}

intptr_t JnhwIntptrT__MA___V_0x0000000080000000L() {
    return (intptr_t)0x0000000080000000L;
}