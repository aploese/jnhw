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
#if HAVE_STDIO_H
#include <stdio.h>
#endif

#if HAVE_UNISTD_H
#include <unistd.h>
#endif

#ifdef _POSIX_VERSION

#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

#include "de_ibapl_jnhw_posix_Stdio.h"

    /*
     * Class:     de_ibapl_jnhw_posix_Stdio
     * Method:    remove
     * Signature: (Ljava/lang/String)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Stdio_remove
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring path) {
        if (path == NULL) {
            throw_NullPointerException(env, "file is null.");
            return;
        }
        const char* _path = (*env)->GetStringUTFChars(env, path, NULL);
        const int result = remove(_path);
        (*env)->ReleaseStringUTFChars(env, path, _path);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
    }



#ifdef __cplusplus
}
#endif
#endif
