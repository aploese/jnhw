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
#if !defined(HAVE_SYS_STAT_H) || !defined(_POSIX_VERSION)

int32_t getValueOf_HAVE_SYS_STAT_H() {
    return 0;
}
#else
#include <sys/stat.h>

int32_t getValueOf_HAVE_SYS_STAT_H() {
    return 1;
}

int32_t getValueOf_S_IFMT() {
    return S_IFMT;
}

int32_t getValueOf_S_IFBLK() {
    return S_IFBLK;
}

int32_t getValueOf_S_IFCHR() {
    return S_IFCHR;
}

int32_t getValueOf_S_IFIFO() {
    return S_IFIFO;
}

int32_t getValueOf_S_IFREG() {
    return S_IFREG;
}

int32_t getValueOf_S_IFDIR() {
    return S_IFDIR;
}

int32_t getValueOf_S_IFLNK() {
    return S_IFLNK;
}

int32_t getValueOf_S_IFSOCK() {
    return S_IFSOCK;
}

int32_t getValueOf_S_IRGRP() {
    return S_IRGRP;
}

int32_t getValueOf_S_IROTH() {
    return S_IROTH;
}

int32_t getValueOf_S_IRUSR() {
    return S_IRUSR;
}

int32_t getValueOf_S_IRWXG() {
    return S_IRWXG;
}

int32_t getValueOf_S_IRWXO() {
    return S_IRWXO;
}

int32_t getValueOf_S_IRWXU() {
    return S_IRWXU;
}

int32_t getValueOf_S_ISGID() {
    return S_ISGID;
}

int32_t getValueOf_S_ISUID() {
    return S_ISUID;
}

int32_t getValueOf_S_ISVTX() {
    return S_ISVTX;
}

int32_t getValueOf_S_IWGRP() {
    return S_IWGRP;
}

int32_t getValueOf_S_IWOTH() {
    return S_IWOTH;
}

int32_t getValueOf_S_IWUSR() {
    return S_IWUSR;
}

int32_t getValueOf_S_IXGRP() {
    return S_IXGRP;
}

int32_t getValueOf_S_IXOTH() {
    return S_IXOTH;
}

int32_t getValueOf_S_IXUSR() {
    return S_IXUSR;
}

#endif
