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
/**
 * Classes to manage blocks of native memory.
 *
 */
/**
 * Naming conventions
 *
 * <table>
 * <tr><th>Coding</th><th>Native</th><th>Java</th></tr>
 * <tr><td>{@code sB}</td><td>{@code signed char int8_t}</td><td>{@code (signed) byte}</td></tr>
 * <tr><td>{@code uB}</td><td>{@code unsigned char uint8_t}</td><td>{@code (unsigned) byte uint8_t}</td></tr>
 * <tr><td>{@code sS}</td><td>{@code signed short int16_t}</td><td>{@code (signed) short}</td></tr>
 * <tr><td>{@code uS}</td><td>{@code unsigned short uint16_t}</td><td>{@code (unsigned) short}</td></tr>
 * <tr><td>{@code sI}</td><td>{@code signed int int32_t}</td><td>{@code (signed) int}</td></tr>
 * <tr><td>{@code uI}</td><td>{@code unsigned int uint32_t}</td><td>{@code (unsigned) int}</td></tr>
 * <tr><td>{@code sL}</td><td>{@code signed long int64_t}</td><td>{@code (signed) long}</td></tr>
 * <tr><td>{@code uL}</td><td>{@code unsigned long uint64_t}</td><td>{@code (unsigned) long}</td></tr>
 * <tr><td>{@code B}</td><td>{@code mapped to ...}</td><td>{@code boolean}</td></tr>
 * <tr><td>{@code MA}</td><td>{@code void * intptr_t}</td><td>{@code MemoryAddress}</td></tr>
 * <tr><td>{@code A}</td><td>{@code void * intptr_t}</td><td>{@code Addressable}</td></tr>
 * <tr><td>{@code P}</td><td>{@code Pointer}</td></tr>
 * <tr><td>{@code D}</td><td>{@code double}</td><td>{@code double}</td></tr>
 * <tr><td>{@code F}</td><td>{@code float}</td><td>{@code float}</td></tr>
 * <tr><td>{@code V}</td><td>{@code void}</td><td>{@code void}</td></tr>
 * </table>
 *
 * Examples:
 *
 * <table>
 * <tr><th>C code</th><th>Java code</th><tr>
 * <tr><td>{@code int invoke_sI__uB(unsigned char arg1)}</td><td>{@code int invoke_sI__uB(byte arg1)}</td></tr>
 * <tr><td>{@code void invoke__V___V()}</td><td>{@code void invoke__V___V()}</td></tr>
 * <td>{@code void *invoke_MA___A(void *arg1)}</td><td>{@code MemoryAddress invoke_MA___A(Addressable arg1)}</td></tr>
 * <td>{@code unsigned int invoke_uI__sI(int arg1)}</td><td>{@code long invoke_uL___B(boolean arg1)}</td></tr>
 * <td>{@code int invoke_sI__sI(int arg1)}</td><td>{@code boolean invoke__B__uI(int arg1)}</td></tr>
 * </table>
 *
 *
 */
package de.ibapl.jnhw.common.downcall.wrapper;
