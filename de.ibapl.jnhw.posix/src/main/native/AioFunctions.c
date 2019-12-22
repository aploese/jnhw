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
#include "de_ibapl_jnhw_posix_Aio.h"

#ifdef HAVE_AIO_H

#include <aio.h>
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_posix_Aio
 * Method:    aio_cancel
 * Signature: (ILde/ibapl/jnhw/posix/Aio/Aiocb;)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_aio_1cancel
  (JNIEnv *, jclass, jint, jobject);

/*
 * Class:     de_ibapl_jnhw_posix_Aio
 * Method:    aio_error
 * Signature: (Lde/ibapl/jnhw/posix/Aio/Aiocb;)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_aio_1error
  (JNIEnv *, jclass, jobject);

/*
 * Class:     de_ibapl_jnhw_posix_Aio
 * Method:    aio_fsync
 * Signature: (ILde/ibapl/jnhw/posix/Aio/Aiocb;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_aio_1fsync
  (JNIEnv *, jclass, jint, jobject);

/*
 * Class:     de_ibapl_jnhw_posix_Aio
 * Method:    aio_read
 * Signature: (Lde/ibapl/jnhw/posix/Aio/Aiocb;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_aio_1read
  (JNIEnv *, jclass, jobject);

/*
 * Class:     de_ibapl_jnhw_posix_Aio
 * Method:    aio_return
 * Signature: (Lde/ibapl/jnhw/posix/Aio/Aiocb;)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Aio_aio_1return
  (JNIEnv *, jclass, jobject);

/*
 * Class:     de_ibapl_jnhw_posix_Aio
 * Method:    aio_suspend
 * Signature: (Lde/ibapl/jnhw/posix/Aio/Aiocbs;ILde/ibapl/jnhw/posix/Time/Timespec;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_aio_1suspend
  (JNIEnv *, jclass, jobject, jint, jobject);

/*
 * Class:     de_ibapl_jnhw_posix_Aio
 * Method:    aio_write
 * Signature: (Lde/ibapl/jnhw/posix/Aio/Aiocb;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_aio_1write
  (JNIEnv *, jclass, jobject);

/*
 * Class:     de_ibapl_jnhw_posix_Aio
 * Method:    lio_listio
 * Signature: (ILde/ibapl/jnhw/posix/Aio/Aiocbs;ILde/ibapl/jnhw/posix/Signal/Sigevent;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_lio_1listio
  (JNIEnv *, jclass, jint, jobject, jint, jobject);

#ifdef __cplusplus
}
#endif
#endif