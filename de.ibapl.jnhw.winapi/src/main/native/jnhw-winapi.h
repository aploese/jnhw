/**
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
#ifndef _jnhw_winapi_H
#define _jnhw_winapi_H

#include "../../../config.h"
#include "jnhw-common.h"

//TODO move this definition to the Makefile???
#ifdef HAVE_WINDOWS_H

// For cross compiling set the version to Win10
#ifdef _WIN32_WINNT
#undef _WIN32_WINNT
#endif

#define _WIN32_WINNT _WIN32_WINNT_WIN10
#include <windows.h>
#endif

#ifdef __cplusplus
extern "C" {
#endif
    
#define JNHW_CLASS_NAME_HANDLE "de/ibapl/jnhw/winapi/Winnt$HANDLE"
#define JNHW_CLASS_NAME_LPWSTR "de/ibapl/jnhw/winapi/Winnt$LPWSTR"
#define JNHW_CLASS_NAME_LPBYTE "de/ibapl/jnhw/winapi/WinDef$LPBYTE"

     extern jclass de_ibapl_jnhw_winapi_Winnt_HANDLE_Class;
     extern jfieldID de_ibapl_jnhw_winapi_Winnt_HANDLE_value_ID;
     extern jmethodID de_ibapl_jnhw_winapi_Winnt_HANDLE_init_ID;
     extern jfieldID de_ibapl_jnhw_winapi_Winnt_LPWSTR_bufferEnd_ID;
     extern jfieldID de_ibapl_jnhw_winapi_WinDef_LPBYTE_bufferEnd_ID;
     

#define UNWRAP_HANDLE(handle) (HANDLE) (uintptr_t) (*env)->GetLongField(env, (handle), de_ibapl_jnhw_winapi_Winnt_HANDLE_value_ID)   
#define UNWRAP_HANDLE_OR_NULL(handle) (handle) == NULL ? NULL : UNWRAP_HANDLE(handle)
#define CREATE_HANDLE(value) (*env)->NewObject(env, de_ibapl_jnhw_winapi_Winnt_HANDLE_Class, de_ibapl_jnhw_winapi_Winnt_HANDLE_init_ID, (jlong) (uintptr_t) value)

#define UNWRAP_PHANDLE(handle) UNWRAP_OPAQUE_MEM_TO(PHANDLE, handle)

#define UNWRAP_HKEY(hKey) (HKEY) (uintptr_t) (*env)->GetLongField(env, (hKey), de_ibapl_jnhw_winapi_Winnt_HANDLE_value_ID)   

#define UNWRAP_PHKEY(handle)  UNWRAP_OPAQUE_MEM_TO(PHKEY, handle)   
     
#define UNWRAP_OVERLAPPED(overlapped) UNWRAP_OPAQUE_MEM_TO(OVERLAPPED*, overlapped)
#define UNWRAP_LPOVERLAPPED(lpOverlapped) UNWRAP_OPAQUE_MEM_TO(LPOVERLAPPED, lpOverlapped)
#define UNWRAP_LPOVERLAPPED_OR_NULL(lpOverlapped) UNWRAP_OPAQUE_MEM_TO_OR_NULL(LPOVERLAPPED, lpOverlapped)
     
//TODOO DWORD => unit32_t or uint64_t     
#define UNWRAP_LPOVERLAPPED_COMPLETION_ROUTINE(lpCompletionRoutine) UNWRAP_NATIVE_FUNCTION_POINTER_TO(LPOVERLAPPED_COMPLETION_ROUTINE, lpCompletionRoutine)
     
#define UNWRAP_SECURITY_ATTRIBUTES(securityAttributes) UNWRAP_OPAQUE_MEM_TO(SECURITY_ATTRIBUTES*, securityAttributes)

#define UNWRAP_LPSECURITY_ATTRIBUTES(lpSecurityAttributes) UNWRAP_OPAQUE_MEM_TO(LPSECURITY_ATTRIBUTES, lpSecurityAttributes)
#define UNWRAP_LPSECURITY_ATTRIBUTES_OR_NULL(lpSecurityAttributes) UNWRAP_OPAQUE_MEM_TO_OR_NULL(LPSECURITY_ATTRIBUTES, lpSecurityAttributes)
        
#define UNWRAP_LPCOMSTAT_OR_NULL(lpComstat) UNWRAP_OPAQUE_MEM_TO_OR_NULL(LPCOMSTAT, lpComstat)   

#define UNWRAP_LPDCB(lpDCB) UNWRAP_OPAQUE_MEM_TO(LPDCB, lpDCB)

#define UNWRAP_LPCOMMTIMEOUTS(lpCOMMTIMEOUTS) UNWRAP_OPAQUE_MEM_TO(LPCOMMTIMEOUTS, lpCOMMTIMEOUTS)

#define UNWRAP_LPWSTR(lpWSTR) UNWRAP_OPAQUE_MEM_TO(LPWSTR, lpWSTR)

#define UNWRAP_LPBYTE(lpBYTE) UNWRAP_OPAQUE_MEM_TO(LPBYTE, lpBYTE)

#define UNWRAP_COMSTAT(comstat) UNWRAP_OPAQUE_MEM_TO(COMSTAT*, comstat)

#define UNWRAP_DCB(dcb) UNWRAP_OPAQUE_MEM_TO(DCB*, dcb)

#define UNWRAP_COMMTIMEOUTS(commTimeOuts) UNWRAP_OPAQUE_MEM_TO(COMMTIMEOUTS*, commTimeOuts)

#define UNWRAP_PAPCFUNC(pfnAPC) ss

#ifdef __cplusplus
}
#endif

#endif