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
#if !defined(HAVE_PTHREAD_H) || !defined(_POSIX_VERSION)

int32_t getValueOf_HAVE_PTHREAD_H() {
    return 0;
}

#else
#include <pthread.h>

int32_t getValueOf_HAVE_PTHREAD_H() {
    return 1;
}

int32_t getValueOf_PTHREAD_EXPLICIT_SCHED() {
    return PTHREAD_EXPLICIT_SCHED;
}

int32_t getValueOf_PTHREAD_INHERIT_SCHED() {
    return PTHREAD_INHERIT_SCHED;
}

int32_t getValueOf_PTHREAD_CANCEL_DISABLE() {
    return PTHREAD_CANCEL_DISABLE;
}

int32_t getValueOf_PTHREAD_CANCEL_ENABLE() {
    return PTHREAD_CANCEL_ENABLE;
}

int32_t getValueOf_PTHREAD_CANCEL_DEFERRED() {
    return PTHREAD_CANCEL_DEFERRED;
}

int32_t getValueOf_PTHREAD_CANCEL_ASYNCHRONOUS() {
    return PTHREAD_CANCEL_ASYNCHRONOUS;
}

#endif
