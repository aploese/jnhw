/*
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
package de.ibapl.jnhw.x_open;

import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.posix.Signal;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;

/**
 * Wrapper around the {@code  <ucontext.h>} header.
 * https://www.gnu.org/software/libc/manual/html_node/System-V-contexts.html#index-setcontext
 *
 * @author aploese
 */
@Include("#include <ucontext.h>")
public class Ucontext {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    public final static native boolean HAVE_UCONTEXT_H();

    /**
     * Get user context and store it in variable pointed to by UCP.
     */
    public final static native void getcontext(Signal.Ucontext_t ucp) throws NativeErrorException;

    /* Set user context from information of variable pointed to by UCP.  */
    final static native void setcontext(final Signal.Ucontext_t ucp) throws NativeErrorException;

    /* Save current context in context variable pointed to by OUCP and set
   context from variable pointed to by UCP.  */
    final static native void swapcontext(Signal.Ucontext_t oucp, final Signal.Ucontext_t ucp) throws NativeErrorException;

    /* Manipulate user context UCP to continue with calling functions FUNC
   and the ARGC-1 parameters following ARGC when the context is used
   the next time in `setcontext' or `swapcontext'.

   We cannot say anything about the parameters FUNC takes; `void'
   is as good as any other choice.  */
//public final static native  void makecontext (Ucontext_t ucp, void (*__func) (void), int argc, ...) thrown NativeErrorException;
}
