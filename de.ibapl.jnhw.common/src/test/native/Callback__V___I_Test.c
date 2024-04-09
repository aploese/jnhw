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
#include "../../../config.h"
//First go for windows.h because mingw has a pthread.h too...

#include <stdint.h>

#ifdef HAVE_SYS_TYPES_H
#include <sys/types.h>
#endif

#ifdef HAVE_WINDOWS_H
#include <windows.h>
#elif defined HAVE_PTHREAD_H
#include <pthread.h>
#endif

typedef void (*callback__V___I)(int32_t);
static callback__V___I ptrCallback__V___I = NULL;

void setCallback__V___I(callback__V___I ptrCallback) {
    ptrCallback__V___I = ptrCallback;
}

callback__V___I getCallback__V___I() {
    return ptrCallback__V___I;
}

#ifdef HAVE_WINDOWS_H

//TODO This does not compile : __attribute__ ((visibility ("hidden")))
 DWORD WINAPI thr_fn_V_PtrInt32_t(LPVOID args) {
    ptrCallback__V___I(*((int32_t*) args));
        return 0;
}

#elif defined HAVE_PTHREAD_H
__attribute__ ((visibility ("hidden"))) void * thr_fn_V_PtrInt32_t(void *args) {
    ptrCallback__V___I(*((int32_t*) args));
        return NULL;
}

#else
    error "Neither pthread.h for POSIX nor windows.h for windows are available ... giving up"
#endif


void doCallback__V___I(int8_t newThread, int32_t value) {
    if (newThread) {

#ifdef HAVE_WINDOWS_H

        HANDLE hThread;
        DWORD dwThreadId;

        hThread = CreateThread(
            NULL, // default security attributes
            0, // use default stack size
            thr_fn_V_PtrInt32_t, // thread function name
            &value, // argument to thread function
            0, // use default creation flags
            &dwThreadId); // returns the thread identifier
            if (hThread == NULL) {
                ExitProcess(3);
        }
        WaitForSingleObject(hThread, INFINITE);
        CloseHandle(hThread);

#elif defined HAVE_PTHREAD_H

        pthread_t thread;
        pthread_create(&thread, NULL, thr_fn_V_PtrInt32_t, &value);
        pthread_join(thread, NULL);

#else
        error "Neither pthread.h for POSIX nor windows.h for windows are available ... giving up"
#endif
    } else {
        ptrCallback__V___I(value);
    }
}