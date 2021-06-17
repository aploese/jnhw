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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.util.posix.DefinesTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ErrnoTest {

    public static class NativeDefines extends de.ibapl.jnhw.isoc.ErrnoTest.NativeDefines {

        public final static native int E2BIG();

        public final static native int EACCES();

        public final static native int EADDRINUSE();

        public final static native int EADDRNOTAVAIL();

        public final static native Integer EADV();

        public final static native int EAFNOSUPPORT();

        public final static native int EAGAIN();

        public final static native int EALREADY();

        public final static native Integer EBADE();

        public final static native int EBADF();

        public final static native Integer EBADFD();

        public final static native int EBADMSG();

        public final static native Integer EBADR();

        public final static native Integer EBADRQC();

        public final static native Integer EBADSLT();

        public final static native Integer EBFONT();

        public final static native int EBUSY();

        public final static native int ECANCELED();

        public final static native int ECHILD();

        public final static native Integer ECHRNG();

        public final static native Integer ECOMM();

        public final static native int ECONNABORTED();

        public final static native int ECONNREFUSED();

        public final static native int ECONNRESET();

        public final static native int EDEADLK();

        public final static native Integer EDEADLOCK();

        public final static native int EDESTADDRREQ();

        public final static native Integer EDOTDOT();

        public final static native int EDQUOT();

        public final static native int EEXIST();

        public final static native int EFAULT();

        public final static native int EFBIG();

        public final static native int EHOSTDOWN();

        public final static native int EHOSTUNREACH();

        public final static native Integer EHWPOISON();

        public final static native int EIDRM();

        public final static native int EINPROGRESS();

        public final static native int EINTR();

        public final static native int EINVAL();

        public final static native int EIO();

        public final static native int EISCONN();

        public final static native int EISDIR();

        public final static native Integer EISNAM();

        public final static native Integer EKEYEXPIRED();

        public final static native Integer EKEYREJECTED();

        public final static native Integer EKEYREVOKED();

        public final static native Integer EL2HLT();

        public final static native Integer EL2NSYNC();

        public final static native Integer EL3HLT();

        public final static native Integer EL3RST();

        public final static native Integer ELIBACC();

        public final static native Integer ELIBBAD();

        public final static native Integer ELIBEXEC();

        public final static native Integer ELIBMAX();

        public final static native Integer ELIBSCN();

        public final static native Integer ELNRNG();

        public final static native int ELOOP();

        public final static native Integer EMEDIUMTYPE();

        public final static native int EMFILE();

        public final static native int EMLINK();

        public final static native int EMSGSIZE();

        public final static native Integer EMULTIHOP();

        public final static native int ENAMETOOLONG();

        public final static native Integer ENAVAIL();

        public final static native int ENETDOWN();

        public final static native int ENETRESET();

        public final static native int ENETUNREACH();

        public final static native int ENFILE();

        public final static native Integer ENOANO();

        public final static native int ENOBUFS();

        public final static native Integer ENOCSI();

        public final static native Integer ENODATA();

        public final static native int ENODEV();

        public final static native int ENOENT();

        public final static native int ENOEXEC();

        public final static native Integer ENOKEY();

        public final static native int ENOLCK();

        public final static native Integer ENOLINK();

        public final static native Integer ENOMEDIUM();

        public final static native int ENOMEM();

        public final static native int ENOMSG();

        public final static native Integer ENONET();

        public final static native Integer ENOPKG();

        public final static native int ENOPROTOOPT();

        public final static native int ENOSPC();

        public final static native Integer ENOSR();

        public final static native Integer ENOSTR();

        public final static native int ENOSYS();

        public final static native int ENOTBLK();

        public final static native int ENOTCONN();

        public final static native int ENOTDIR();

        public final static native int ENOTEMPTY();

        public final static native Integer ENOTNAM();

        public final static native int ENOTRECOVERABLE();

        public final static native int ENOTSOCK();

        public final static native int ENOTSUP();

        public final static native int ENOTTY();

        public final static native Integer ENOTUNIQ();

        public final static native int ENXIO();

        public final static native int EOPNOTSUPP();

        public final static native int EOVERFLOW();

        public final static native int EOWNERDEAD();

        public final static native int EPERM();

        public final static native int EPFNOSUPPORT();

        public final static native int EPIPE();

        public final static native int EPROTO();

        public final static native int EPROTONOSUPPORT();

        public final static native int EPROTOTYPE();

        public final static native Integer EREMCHG();

        public final static native int EREMOTE();

        public final static native Integer EREMOTEIO();

        public final static native Integer ERESTART();

        public final static native Integer ERFKILL();

        public final static native int EROFS();

        public final static native int ESHUTDOWN();

        public final static native int ESOCKTNOSUPPORT();

        public final static native int ESPIPE();

        public final static native int ESRCH();

        public final static native Integer ESRMNT();

        public final static native int ESTALE();

        public final static native Integer ESTRPIPE();

        public final static native Integer ETIME();

        public final static native int ETIMEDOUT();

        public final static native int ETOOMANYREFS();

        public final static native int ETXTBSY();

        public final static native Integer EUCLEAN();

        public final static native Integer EUNATCH();

        public final static native int EUSERS();

        public final static native int EWOULDBLOCK();

        public final static native int EXDEV();

        public final static native Integer EXFULL();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }
    private final static MultiarchTupelBuilder MULTIARCHTUPEL_BUILDER = new MultiarchTupelBuilder();

    @Test
    public void test_ErrnoDefines() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Errno.class, NativeDefines.class, "HAVE_ERRNO_H");
    }

    @Test
    public void testErrno() throws Exception {
        Assertions.assertTrue(Errno.HAVE_ERRNO_H);
        Assertions.assertNotEquals(Errno.ERANGE, Errno.EILSEQ);
        Errno.errno(Errno.ERANGE);
        Assertions.assertEquals(Errno.ERANGE, Errno.errno(), "Cant Set errno");
        Errno.errno(Errno.EDOM);
        Assertions.assertEquals(Errno.EDOM, Errno.errno(), "Cant Set errno");
    }

}
