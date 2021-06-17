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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class FcntlTest {

    public static class NativeDefines {

        public final static native boolean HAVE_FCNTL_H();

        public final static native int AT_EACCESS();

        public final static native int AT_FDCWD();

        public final static native int AT_REMOVEDIR();

        public final static native int AT_SYMLINK_FOLLOW();

        public final static native int AT_SYMLINK_NOFOLLOW();

        public final static native int FD_CLOEXEC();

        public final static native int F_DUPFD();

        public final static native int F_DUPFD_CLOEXEC();

        public final static native int F_GETFD();

        public final static native int F_GETFL();

        public final static native int F_GETLK();

        public final static native int F_GETOWN();

        public final static native int F_RDLCK();

        public final static native int F_SETFD();

        public final static native int F_SETFL();

        public final static native int F_SETLK();

        public final static native int F_SETLKW();

        public final static native int F_SETOWN();

        public final static native int F_UNLCK();

        public final static native int F_WRLCK();

        public final static native int O_ACCMODE();

        public final static native int O_APPEND();

        public final static native Integer O_ASYNC();

        public final static native int O_CLOEXEC();

        public final static native int O_CREAT();

        public final static native int O_DIRECTORY();

        public final static native Integer O_DSYNC();

        public final static native int O_EXCL();

        public final static native Integer O_EXEC();

        public final static native Integer O_FSYNC();

        public final static native Integer O_LARGEFILE();

        public final static native int O_NOCTTY();

        public final static native int O_NOFOLLOW();

        public final static native int O_NONBLOCK();

        public final static native int O_RDONLY();

        public final static native int O_RDWR();

        public final static native Integer O_RSYNC();

        public final static native Integer O_SEARCH();

        public final static native int O_SYNC();

        public final static native int O_TRUNC();

        public final static native Integer O_TTY_INIT();

        public final static native int O_WRONLY();

        public final static native Integer POSIX_FADV_DONTNEED();

        public final static native Integer POSIX_FADV_NOREUSE();

        public final static native Integer POSIX_FADV_NORMAL();

        public final static native Integer POSIX_FADV_RANDOM();

        public final static native Integer POSIX_FADV_SEQUENTIAL();

        public final static native Integer POSIX_FADV_WILLNEED();

        public final static native int SEEK_CUR();

        public final static native int SEEK_END();

        public final static native int SEEK_SET();

        static {
            LibJnhwPosixTestLoader.touch();
        }

    }

    private final static MultiarchTupelBuilder MULTIARCHTUPEL_BUILDER = new MultiarchTupelBuilder();

    @BeforeAll
    public static void checkBeforeAll_HAVE_FCNTL_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Fcntl.HAVE_FCNTL_H, "not expected to have fcntl.h");
        } else {
            Assertions.assertTrue(Fcntl.HAVE_FCNTL_H, "expected to have locale.h");
        }
    }

    @BeforeAll
    public static void checkBeforeAll_FcntlDefines() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Fcntl.class, NativeDefines.class, "HAVE_FCNTL_H");
    }

    @Test
    public void testNPEOpen() throws Exception {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Fcntl.open(null, 0);
        });
    }

    @Test
    public void testNPECreat() throws Exception {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Fcntl.creat(null, 0);
        });
    }

}
