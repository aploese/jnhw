/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2019, Arne Plöse and individual contributors as indicated
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

#ifdef HAVE_POLL_H

#include "de_ibapl_jnhw_posix_Poll.h"
#include <poll.h>
#include <errno.h>


#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Poll
     * Method:    poll
     * Signature: (Lde/ibapl/jnhw/StructArray;I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Poll_poll
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject pollFdArray, jint timeout) {
        if (pollFdArray == NULL) {
            throw_NullPointerException(env, "pollFd array");
            return -1;
        }
        nfds_t nfds = LENGTH_OF_STRUCTURE_ARRAY(pollFdArray);
        int result = poll(UNWRAP_OPAQUE_MEM_TO_VOID_PTR(pollFdArray), nfds, timeout);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }


#ifdef __cplusplus
}
#endif
#endif
