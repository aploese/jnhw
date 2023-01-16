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
package de.ibapl.jnhw.x_open;

import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI___A;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI___A__A;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.posix.Errno;
import de.ibapl.jnhw.posix.Signal;
import de.ibapl.jnhw.libloader.librarys.LibcLoader;
import java.util.Optional;

/**
 * Wrapper around the {@code  <ucontext.h>} header.
 * https://www.gnu.org/software/libc/manual/html_node/System-V-contexts.html#index-setcontext
 *
 * @author aploese
 */
@Include("#include <ucontext.h>")
public class Ucontext {

    public final static boolean HAVE_UCONTEXT_H = switch (MultiarchTupelBuilder.getOS()) {
        case DARWIN, OPEN_BSD ->
            false;
        case FREE_BSD, LINUX ->
            true;
        default ->
            throw new NoClassDefFoundError("No ucontext.h defines for " + MultiarchTupelBuilder.getMultiarch());
    };

    private final static JnhwMh_sI___A getcontext = JnhwMh_sI___A.optionalOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "getcontext",
            BaseDataType.C_int,
            BaseDataType.C_const_struct_pointer);

    private final static JnhwMh_sI___A setcontext = JnhwMh_sI___A.optionalOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "setcontext",
            BaseDataType.C_int,
            BaseDataType.C_const_struct_pointer);

    private final static JnhwMh_sI___A__A swapcontext = JnhwMh_sI___A__A.optionalOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "swapcontext",
            BaseDataType.C_int,
            BaseDataType.C_const_struct_pointer,
            BaseDataType.C_const_struct_pointer);

    /**
     * Get user context and store it in variable pointed to by UCP.
     */
    public final static void getcontext(Signal.Ucontext_t ucp) throws NativeErrorException, NoSuchNativeMethodException {
        if (getcontext.invoke_sI___P(ucp) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * Set user context from information of variable pointed to by UCP.
     */
    final static void setcontext(final Signal.Ucontext_t ucp) throws NativeErrorException, NoSuchNativeMethodException {
        if (setcontext.invoke_sI___P(ucp) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * Save current context in context variable pointed to by OUCP and set
     * context from variable pointed to by UCP.
     */
    final static void swapcontext(Signal.Ucontext_t oucp, final Signal.Ucontext_t ucp) throws NativeErrorException, NoSuchNativeMethodException {
        if (swapcontext.invoke_sI___P__P(oucp, ucp) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /* Manipulate user context UCP to continue with calling functions FUNC
   and the ARGC-1 parameters following ARGC when the context is used
   the next time in `setcontext' or `swapcontext'.

   We cannot say anything about the parameters FUNC takes; `void'
   is as good as any other choice.  */
//public final static native  void makecontext (Ucontext_t ucp, void (*__func) (void), int argc, ...) thrown NativeErrorException;
}
