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

#include <stddef.h>
#include <signal.h>

//We need the POSIX version ...
#if defined(HAVE_SIGNAL_H) && defined(_POSIX_VERSION)

typedef void (*callback__V__UnionSigval)(union sigval);
static callback__V__UnionSigval ptrCallback__V__UnionSigval = NULL;

void setCallback__V__UnionSigval(callback__V__UnionSigval ptrCallback) {
    ptrCallback__V__UnionSigval = ptrCallback;
}

callback__V__UnionSigval getCallback__V__UnionSigval() {
    return ptrCallback__V__UnionSigval;
}

void doCallback__V__UnionSigval_A(void* sival_ptr) {
    union sigval value;
    value.sival_int = 0;
    value.sival_ptr = sival_ptr;
    ptrCallback__V__UnionSigval(value);
}

void doCallback__V__UnionSigval_I(int sival_int) {
    union sigval value;
    value.sival_ptr = NULL;
    value.sival_int = sival_int;
    ptrCallback__V__UnionSigval(value);
}

#endif