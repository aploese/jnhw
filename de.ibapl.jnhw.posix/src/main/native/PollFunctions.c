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
#include "de_ibapl_jnhw_posix_Poll.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _POSIX_VERSION
#include <poll.h>
#include <errno.h>

#include <assert.h>

    JNHW_ASSERT__nfds_t__IS__uint64_t__OR__uint32_t

    /*
     * Class:     de_ibapl_jnhw_posix_Poll
     * Method:    poll
     * Signature: (JII)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Poll_poll
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrPollFds, jint elements, jint timeout) {
        const int result = poll((struct pollfd*) (uintptr_t) ptrPollFds, (uint32_t) elements, timeout);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

#endif
#ifdef __cplusplus
}
#endif
