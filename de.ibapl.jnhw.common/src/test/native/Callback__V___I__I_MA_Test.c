/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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
#include <stddef.h>
#include <stdint.h>

typedef void (*callback__V___I__I_MA)(int32_t, int32_t, void*);
static callback__V___I__I_MA ptrCallback__V___I__I_MA = NULL;

void setCallback__V___I__I_MA(callback__V___I__I_MA ptrCallback) {
    ptrCallback__V___I__I_MA = ptrCallback;
}

callback__V___I__I_MA getCallback__V___I__I_MA() {
    return ptrCallback__V___I__I_MA;
}

void doCallback__V___I__I_MA(int32_t a, int32_t b, void* ptrC) {
    ptrCallback__V___I__I_MA(a, b, ptrC);
}