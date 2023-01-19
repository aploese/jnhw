/**
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
#include <stdint.h>
#include <assert.h>

//FreeBSD does not define _ISO_C_SOURCE 2011 if POSIX is set bug??? - so do not test datatypes on compile time...
#if defined(__FreeBSD__) && !defined(__JNHW_TEST_POSIX_DATATYPES)
#  define JNHW_ASSERT_DATA_TYPES(t1, t2)
#else
#  define JNHW_ASSERT_DATA_TYPES(t1, t2) \
    static_assert(sizeof(t1) == sizeof(t2), #t1 " sizeof not equals " #t2); \
    static_assert((0 < (t1)-1) == (0 < (t2)-1), #t1 " and " #t2 " sign mismatch ");
#endif

#if defined(__linux__)

//  glibc 2.28 does not define this ... later versions do.
//#  if !defined(__TIMESIZE)
//#    warning __TIMESIZE not defined
//#  endif

# if !defined(__WORDSIZE)
#  error __WORDSIZE not defined
# endif//if !defined(__WORDSIZE)

# if !defined(__WORDSIZE_TIME64_COMPAT32)
#  error  __WORDSIZE_TIME64_COMPAT32 not defined
# endif//if !defined(__WORDSIZE_TIME64_COMPAT32)

# define _JNHW__mode_t__IS__uint32_t 1
# define _JNHW__gid_t__IS__uint32_t 1
# define _JNHW__pid_t__IS__int32_t 1
# define _JNHW__clockid_t__IS__int32_t 1
# define _JNHW__uid_t__IS__uint32_t 1
# define _JNHW__speed_t__IS__uint32_t 1
# define _JNHW__tcflag_t__IS__uint32_t 1
# define _JNHW__timer_t__IS__intptr_t 1
# define _JNHW__cc_t__IS__uint8_t 1


//JNHW_ASSERT_DATA_TYPES(off64_t, int64_t)
//JNHW_ASSERT_DATA_TYPES(useconds_t, int32_t)
//JNHW_ASSERT_DATA_TYPES(pthread_attr_t, uint64_t)

# if defined(__LP64__)
#  define _JNHW__off_t__IS__int64_t 1
#  define _JNHW__ssize_t__IS__int64_t 1
#  define _JNHW__size_t__IS__uint64_t 1
#  define _JNHW__pthread_t__IS__uint64_t 1
#  define _JNHW__clock_t__IS__int64_t 1
#  define _JNHW__time_t__IS__int64_t 1
#  define _JNHW__nfds_t__IS__uint64_t 1
# else//if defined(__LP64__)
#  if defined(__ILP32__)
#   if defined(__SYSCALL_WORDSIZE) && __SYSCALL_WORDSIZE == 64
#    define _JNHW__off_t__IS__int64_t 1
#   else//if defined(__SYSCALL_WORDSIZE) && __SYSCALL_WORDSIZE == 64
#    define _JNHW__off_t__IS__int32_t 1
#   endif//if defined(__SYSCALL_WORDSIZE) && __SYSCALL_WORDSIZE == 64
#   if __WORDSIZE_TIME64_COMPAT32 == 1
#    define _JNHW__clock_t__IS__int64_t 1
#    define _JNHW__time_t__IS__int64_t 1
#   elif __WORDSIZE_TIME64_COMPAT32 == 0 //if __WORDSIZE_TIME64_COMPAT32 == 1
#    define _JNHW__clock_t__IS__int32_t 1
#    define _JNHW__time_t__IS__int32_t 1
#   else//elif __WORDSIZE_TIME64_COMPAT32 == 0
#    error Unknown value of __WORDSIZE_TIME64_COMPAT32
#   endif//elif __WORDSIZE_TIME64_COMPAT32 == 0
#  else//if defined(__ILP32__)
#   define _JNHW__off_t__IS__int32_t 1
#   define _JNHW__clock_t__IS__int32_t 1
#   define _JNHW__time_t__IS__int32_t 1
#  endif//if defined(__ILP32__)
#  define _JNHW__pthread_t__IS__uint32_t 1
#  define _JNHW__ssize_t__IS__int32_t 1
#  define _JNHW__size_t__IS__uint32_t 1
#  define _JNHW__clockid_t__IS__int32_t 1
#  define _JNHW__nfds_t__IS__uint32_t 1
# endif//if defined(__LP64__)

#elif defined(__FreeBSD__) || defined(__APPLE__)//if defined(__linux__)

# define _JNHW__mode_t__IS__uint16_t 1
# define _JNHW__gid_t__IS__uint32_t 1
# define _JNHW__pid_t__IS__int32_t 1
# define _JNHW__uid_t__IS__uint32_t 1
 
# if defined(__APPLE__)
//TODO clockid_t is an enum ... how to test?..
#  define _JNHW__clockid_t__IS__int32_t 1
#  define _JNHW__speed_t__IS__uint64_t 1
#  define _JNHW__tcflag_t__IS__uint64_t 1
#  define _JNHW__timer_t__IS__not_defined 1
# else//if defined(__APPLE__)
#  define _JNHW__clockid_t__IS__int32_t 1
#  define _JNHW__speed_t__IS__uint32_t 1
#  define _JNHW__tcflag_t__IS__uint32_t 1
#  define _JNHW__timer_t__IS__intptr_t 1
# endif//if defined(__APPLE__)

# define _JNHW__cc_t__IS__uint8_t 1
# define _JNHW__nfds_t__IS__uint32_t 1

//JNHW_ASSERT_DATA_TYPES(off64_t, int64_t)
//JNHW_ASSERT_DATA_TYPES(useconds_t, int32_t)
//JNHW_ASSERT_DATA_TYPES(pthread_attr_t, uint64_t)

# if defined(__LP64__)
#  define _JNHW__off_t__IS__int64_t 1
#  define _JNHW__ssize_t__IS__int64_t 1
#  define _JNHW__size_t__IS__uint64_t 1
#  define _JNHW__pthread_t__IS__uint64_t 1
#  if defined(__APPLE__)
#   define _JNHW__clock_t__IS__uint64_t 1
#  else//if defined(__APPLE__)
#   define _JNHW__clock_t__IS__int32_t 1
#  endif//if defined(__APPLE__)
#  define _JNHW__time_t__IS__int64_t 1
# endif//if defined(__LP64__)
#elif defined(__OpenBSD__)
# define _JNHW__mode_t__IS__uint32_t 1
# define _JNHW__gid_t__IS__uint32_t 1
# define _JNHW__pid_t__IS__int32_t 1
# define _JNHW__clockid_t__IS__int32_t 1
# define _JNHW__uid_t__IS__uint32_t 1
# define _JNHW__speed_t__IS__uint32_t 1
# define _JNHW__tcflag_t__IS__uint32_t 1
# define _JNHW__timer_t__IS__int32_t 1
# define _JNHW__cc_t__IS__uint8_t 1
# define _JNHW__pthread_t__IS__not_defined 1

//JNHW_ASSERT_DATA_TYPES(off64_t, int64_t)
//JNHW_ASSERT_DATA_TYPES(useconds_t, int32_t)
//JNHW_ASSERT_DATA_TYPES(pthread_attr_t, uint64_t)

# if defined(__LP64__)
#  define _JNHW__off_t__IS__int64_t 1
#  define _JNHW__ssize_t__IS__int64_t 1
#  define _JNHW__size_t__IS__uint64_t 1
#  define _JNHW__clock_t__IS__int64_t 1
#  define _JNHW__time_t__IS__int64_t 1
#  define _JNHW__nfds_t__IS__uint32_t 1
# endif//if defined(__LP64__)
#endif//elif defined(__OpenBSD__)


#if defined(_JNHW__mode_t__IS__uint16_t)
# define JNHW_ASSERT__mode_t__IS__uint16_t__OR__uint32_t JNHW_ASSERT_DATA_TYPES(mode_t, uint16_t)
#elif defined(_JNHW__mode_t__IS__uint32_t)
# define JNHW_ASSERT__mode_t__IS__uint16_t__OR__uint32_t JNHW_ASSERT_DATA_TYPES(mode_t, uint32_t)
#else
# error mode_t
#endif
# if defined(_JNHW__gid_t__IS__uint32_t)
# define JNHW_ASSERT__gid_t__IS__uint32_t JNHW_ASSERT_DATA_TYPES(gid_t, uint32_t)
#else
# error gid_t
#endif

#if defined(_JNHW__pid_t__IS__int32_t)
# define JNHW_ASSERT__pid_t__IS__int32_t JNHW_ASSERT_DATA_TYPES(pid_t, int32_t)
#else
# error pid_t
#endif

#if defined(_JNHW__clockid_t__IS__int32_t)
# define JNHW_ASSERT__clockid_t__IS__int32_t JNHW_ASSERT_DATA_TYPES(clockid_t, int32_t)
#else
# error clockid_t
#endif

#if defined(_JNHW__uid_t__IS__uint32_t)
# define JNHW_ASSERT__uid_t__IS__uint32_t JNHW_ASSERT_DATA_TYPES(uid_t, uint32_t)
#else
# error uid_t
#endif

#if defined(_JNHW__speed_t__IS__uint64_t)
# define JNHW_ASSERT__speed_t__IS__uint32_t__OR__uint64_t JNHW_ASSERT_DATA_TYPES(speed_t, uint64_t)
#elif defined(_JNHW__speed_t__IS__uint32_t)
# define JNHW_ASSERT__speed_t__IS__uint32_t__OR__uint64_t JNHW_ASSERT_DATA_TYPES(speed_t, uint32_t)
#else
# error speed_t
#endif

#if defined(_JNHW__tcflag_t__IS__uint32_t)
# define JNHW_ASSERT__tcflag_t__IS__uint32_t__OR__uint64_t JNHW_ASSERT_DATA_TYPES(tcflag_t, uint32_t)
#elif defined(_JNHW__tcflag_t__IS__uint64_t)
# define JNHW_ASSERT__tcflag_t__IS__uint32_t__OR__uint64_t  JNHW_ASSERT_DATA_TYPES(tcflag_t, uint64_t)
#else
# error tcflag_t
#endif

#if defined(_JNHW__cc_t__IS__uint8_t)
# define JNHW_ASSERT__cc_t__IS__uint8_t JNHW_ASSERT_DATA_TYPES(cc_t, uint8_t)
#else
# error cc_t
#endif

#if defined(_JNHW__off_t__IS__int64_t)
# define JNHW_ASSERT__off_t__IS__int64_t__OR__int32_t JNHW_ASSERT_DATA_TYPES(off_t, int64_t)
#elif defined(_JNHW__off_t__IS__int32_t)
# define JNHW_ASSERT__off_t__IS__int64_t__OR__int32_t JNHW_ASSERT_DATA_TYPES(off_t, int32_t)
#else
# error off_t
#endif

#if defined(_JNHW__ssize_t__IS__int64_t)
# define JNHW_ASSERT__ssize_t__IS__int64_t__OR__int32_t JNHW_ASSERT_DATA_TYPES(ssize_t, int64_t)
#elif defined(_JNHW__ssize_t__IS__int32_t)
# define JNHW_ASSERT__ssize_t__IS__int64_t__OR__int32_t JNHW_ASSERT_DATA_TYPES(ssize_t, int32_t)
#else
# error ssize_t
#endif

#if defined(_JNHW__size_t__IS__uint64_t)
# define JNHW_ASSERT__size_t__IS__uint64_t__OR__uint32_t JNHW_ASSERT_DATA_TYPES(size_t, uint64_t)
#elif defined(_JNHW__size_t__IS__uint32_t)
# define JNHW_ASSERT__size_t__IS__uint64_t__OR__uint32_t JNHW_ASSERT_DATA_TYPES(size_t, uint32_t)
#else
#error size_t
#endif

#if defined(_JNHW__pthread_t__IS__uint64_t)
# define JNHW_ASSERT__pthread_t__IS__uint64_t__OR__uint32_t__OR__not_defined JNHW_ASSERT_DATA_TYPES(pthread_t, uint64_t)
#elif defined(_JNHW__pthread_t__IS__uint32_t)
# define JNHW_ASSERT__pthread_t__IS__uint64_t__OR__uint32_t__OR__not_defined JNHW_ASSERT_DATA_TYPES(pthread_t, uint32_t)
#elif defined(_JNHW__pthread_t__IS__not_defined)
//Test for undeclaredness ??
# define JNHW_ASSERT__pthread_t__IS__uint64_t__OR__uint32_t__OR__not_defined JNHW_ASSERT_DATA_TYPES(uint32_t, uint32_t)
#else
# error pthread_t
#endif

#if defined(_JNHW__clock_t__IS__uint64_t)
# define JNHW_ASSERT__clock_t__IS__uint64__OR__int64_t__OR__int32_t JNHW_ASSERT_DATA_TYPES(clock_t, uint64_t)
#elif defined(_JNHW__clock_t__IS__int64_t)
# define JNHW_ASSERT__clock_t__IS__uint64__OR__int64_t__OR__int32_t JNHW_ASSERT_DATA_TYPES(clock_t, int64_t)
#elif defined(_JNHW__clock_t__IS__int32_t)
# define JNHW_ASSERT__clock_t__IS__uint64__OR__int64_t__OR__int32_t JNHW_ASSERT_DATA_TYPES(clock_t, int32_t)
#else
# error clock_t
#endif

#if defined(_JNHW__time_t__IS__int64_t)
# define JNHW_ASSERT__time_t__IS__int64_t__OR__int32_t JNHW_ASSERT_DATA_TYPES(time_t, int64_t)
#elif defined(_JNHW__time_t__IS__int32_t)
# define JNHW_ASSERT__time_t__IS__int64_t__OR__int32_t JNHW_ASSERT_DATA_TYPES(time_t, int32_t)
#else
# error time_t
#endif

#if defined(_JNHW__timer_t__IS__intptr_t)
# define JNHW_ASSERT__timer_t__IS__intptr_t__OR__int32_t__OR__not_defined JNHW_ASSERT_DATA_TYPES(timer_t, intptr_t)
#elif defined(_JNHW__timer_t__IS__int32_t)
# define JNHW_ASSERT__timer_t__IS__intptr_t__OR__int32_t__OR__not_defined JNHW_ASSERT_DATA_TYPES(timer_t, int32_t)
#elif defined(_JNHW__timer_t__IS__int64_t)
# define JNHW_ASSERT__timer_t__IS__intptr_t__OR__int32_t__OR__not_defined JNHW_ASSERT_DATA_TYPES(timer_t, int64_t)
#elif defined(_JNHW__timer_t__IS__not_defined)
# define JNHW_ASSERT__timer_t__IS__intptr_t__OR__int32_t__OR__not_defined !defined(timer_t)
#else
# error timer_t
#endif

#if defined(_JNHW__nfds_t__IS__uint64_t)
# define JNHW_ASSERT__nfds_t__IS__uint64_t__OR__uint32_t JNHW_ASSERT_DATA_TYPES(nfds_t, uint64_t)
#elif defined(_JNHW__nfds_t__IS__uint32_t)
# define JNHW_ASSERT__nfds_t__IS__uint64_t__OR__uint32_t JNHW_ASSERT_DATA_TYPES(nfds_t, uint32_t)
#else
# error nfds_t
#endif

#if defined(__JNHW_TEST_POSIX_DATATYPES)

#include <sys/types.h>
JNHW_ASSERT__mode_t__IS__uint16_t__OR__uint32_t
JNHW_ASSERT__gid_t__IS__uint32_t
JNHW_ASSERT__pid_t__IS__int32_t
JNHW_ASSERT__clockid_t__IS__int32_t
JNHW_ASSERT__uid_t__IS__uint32_t
JNHW_ASSERT__off_t__IS__int64_t__OR__int32_t
JNHW_ASSERT__ssize_t__IS__int64_t__OR__int32_t
JNHW_ASSERT__size_t__IS__uint64_t__OR__uint32_t
JNHW_ASSERT__pthread_t__IS__uint64_t__OR__uint32_t__OR__not_defined
JNHW_ASSERT__clock_t__IS__int64_t__OR__int32_t
JNHW_ASSERT__time_t__IS__int64_t__OR__int32_t
JNHW_ASSERT__timer_t__IS__intptr_t__OR__int32_t__OR__not_defined

#include <poll.h>
JNHW_ASSERT__nfds_t__IS__uint64_t__OR__uint32_t

#include <termios.h>
JNHW_ASSERT__speed_t__IS__uint32_t
JNHW_ASSERT__tcflag_t__IS__uint32_t
JNHW_ASSERT__cc_t__IS__uint8_t

#if defined(__linux__)

# if defined(__aarch64__) && !defined(__arm__)
#  if defined(__LP64__)
#   define JNHW_ARCH  "__aarch64__ __LP64__"
#  elif defined(__ILP32__)
#   error not seen __ILP32__ defined
#  else
#   error not seen __LP64__  and __ILP32__ not defined
# endif
# endif

# if defined(__alpha__)
#  if defined(JNHW_ARCH)
#   error arch found before #JNHW_ARCH
#  endif
#  if defined(__LP64__)
#   define JNHW_ARCH  "__alpha__ && __LP64__"
#  elif defined(__ILP32__)
#   error not seen __ILP32__ defined
#  else
#   error not seen __LP64__  and __ILP32__ not defined
#  endif
# endif

# if defined (__arm__) && !defined(__aarch64__)
#  if defined(JNHW_ARCH)
#   error arch found before #JNHW_ARCH
#  endif
#  if defined(__LP64__)
#   error not seen __LP64__  defined
#  elif defined(__ILP32__)
#   error not seen __ILP32__ defined
#  else
#   define JNHW_ARCH  "__arm__"
#  endif
# endif

# if defined(__hppa__)
#  if defined(JNHW_ARCH)
#   error arch found before #JNHW_ARCH
#  endif
#  if defined(__LP64__)
#   error not seen __LP64__  defined
#  elif defined(__ILP32__)
#   error not seen __ILP32__ defined
#  else
#   define JNHW_ARCH  "__hppa__"
#  endif
# endif

# if defined(__i386__) && defined(__i686__)
#  if defined(JNHW_ARCH)
#   error arch found before #JNHW_ARCH
#  endif
#  if defined(__LP64__)
#   error not seen __LP64__  defined
#  elif defined(__ILP32__)
#   define JNHW_ARCH  "__i386__ && __i686__ && __ILP32__"
#   if __WORDSIZE_TIME64_COMPAT32 != 0
#    error __WORDSIZE_TIME64_COMPAT32 != 0
#   endif
#   if defined(__SYSCALL_WORDSIZE)
#    error __SYSCALL_WORDSIZE is defined
#   endif
#  else
#   define JNHW_ARCH  "__i386__ && __i686__"
#  endif
# endif

# if defined(__m68k__)
#  if defined(JNHW_ARCH)
#   error arch found before #JNHW_ARCH
#  endif
#  if defined(__LP64__)
#   error not seen __LP64__  defined
#  elif defined(__ILP32__)
#   error not seen __ILP32__ defined
#  else
#   define JNHW_ARCH  "__m68k__"
#  endif
# endif

# if defined(__mips__) && __mips == 32
#  if defined(JNHW_ARCH)
#   error arch found before #JNHW_ARCH
#  endif
#  if defined(__LP64__)
#   error not seen __LP64__  defined
#  elif defined(__ILP32__)
#   error not seen __ILP32__ defined
#  else
#   define JNHW_ARCH  "__mips__ && __mips == 32"
#  endif
# endif

# if defined(__mips__) && __mips == 64
#  if defined(JNHW_ARCH)
#   error arch found before #JNHW_ARCH
#  endif
#  if defined(__LP64__)
#   define JNHW_ARCH  "__mips__ && __mips == 64 && __LP64__"
#  elif defined(__ILP32__)
#   error not seen __ILP32__ defined
#  else
#   error not seen __LP64__  and __ILP32__ not defined
#  endif
# endif

# if defined(__powerpc__) && !defined(__powerpc64__)
#  if defined(JNHW_ARCH)
#   error arch found before #JNHW_ARCH
#  endif
#  if defined(__LP64__)
#   error not seen __LP64__  defined
#  elif defined(__ILP32__)
#   error not seen __ILP32__ defined
#  else
#   define JNHW_ARCH  "__powerpc__ && !__powerpc64__"
#  endif
# endif

# if defined(__powerpc64__) && defined(__powerpc__)
#  if defined(JNHW_ARCH)
#   error arch found before #JNHW_ARCH
#  endif
#  if defined(__LP64__)
#   define JNHW_ARCH  "__powerpc__ && __powerpc64__ && __LP64__"
#  elif defined(__ILP32__)
#   error not seen __ILP32__ defined
#  else
#   error not seen __LP64__  and __ILP32__ not defined
#  endif
# endif

# if defined(__riscv)
#  if defined(JNHW_ARCH)
#   error arch found before #JNHW_ARCH
#  endif
#  if defined(__LP64__)
#   define JNHW_ARCH  "__riscv && __LP64__"
#  elif defined(__ILP32__)
#   error not seen __ILP32__ defined
#  else
#   error not seen __LP64__  and __ILP32__ not defined
#  endif
# endif

# if defined(__s390x__)
#  if defined(JNHW_ARCH)
#   error arch found before #JNHW_ARCH
#  endif
#  if defined(__LP64__)
#   define JNHW_ARCH  "__s390x__ && __LP64__"
#  elif defined(__ILP32__)
#   error not seen __ILP32__ defined
#  else
#   error not seen __LP64__  and __ILP32__ not defined
#  endif
# endif

# if defined(__sh__)
#  if defined(JNHW_ARCH)
#   error arch found before #JNHW_ARCH
#  endif
#  if defined(__LP64__)
#   error not seen __LP64__  defined
#  elif defined(__ILP32__)
#   error not seen __ILP32__ defined
#  else
#   define JNHW_ARCH  "__sh__"
#  endif
# endif

# if defined(__sparc__)
#  if defined(JNHW_ARCH)
#   error arch found before #JNHW_ARCH
#  endif
#  if defined(__LP64__)
#   define JNHW_ARCH  "__sparc__ && __LP64__"
#  elif defined(__ILP32__)
#   error not seen __ILP32__ defined
#  else
#   error not seen __LP64__  and __ILP32__ not defined
#  endif
# endif

# if defined(__amd64__) && defined(__x86_64__)
#  if defined(JNHW_ARCH)
#   error arch found before #JNHW_ARCH
#  endif
static_assert(__WORDSIZE_TIME64_COMPAT32 == 1, "__WORDSIZE_TIME64_COMPAT32 != 1");
static_assert(__SYSCALL_WORDSIZE == 64, "__SYSCALL_WORDSIZE != 64");
#  if defined(__LP64__)
#   define JNHW_ARCH  "__amd64__ && __x86_64__ && __LP64__"
#  elif defined(__ILP32__)
#   define JNHW_ARCH  "__amd64__ && __x86_64__ && __ILP32__"
#  else
#   error not seen __LP64__  and __ILP32__ not defined
#  endif
# endif

#endif //ifdef __linux__

#if defined(__FreeBSD__) || defined(__OpenBSD__)

# if defined(__amd64__) && defined(__x86_64__)
#  if defined(JNHW_ARCH)
#   error arch found before #JNHW_ARCH
#  endif
#  if defined(__LP64__)
#   define JNHW_ARCH  "__amd64__ && __x86_64__ && __LP64__"
#  elif defined(__ILP32__)
#   define JNHW_ARCH  "__amd64__ && __x86_64__ && __ILP32__"
#  else
#   error not seen __LP64__  and __ILP32__ not defined
#  endif
# endif
#endif

#if !defined(JNHW_ARCH)
# error arch not found
#endif

#endif
