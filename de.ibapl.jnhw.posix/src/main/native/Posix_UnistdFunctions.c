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
#include "../../../config.h"
#include "jnhw.h"
#if HAVE_UNISTD_H
# include <unistd.h>
#endif

#ifdef _POSIX_VERSION

#include "de_ibapl_jnhw_posix_Unistd.h"
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    pipe
     * Signature: (Lde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/IntRef;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Unistd_pipe
    (JNIEnv *env, jclass clazz, jobject read_fd_ref, jobject write_fd_ref) {
        if (read_fd_ref == NULL) {
            throw_NullPointerException(env, "read_fd_ref is null");
            return;
        }
        if (write_fd_ref == NULL) {
            throw_NullPointerException(env, "write_fd_ref is null");
            return;
        }
        int fdes[2];
        int result = pipe(fdes);
        (*env)->SetIntField(env, read_fd_ref, de_ibapl_jnhw_IntRef_value_ID, fdes[0]);
        (*env)->SetIntField(env, write_fd_ref, de_ibapl_jnhw_IntRef_value_ID, fdes[1]);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
    }


#ifdef __cplusplus
}
#endif
#endif