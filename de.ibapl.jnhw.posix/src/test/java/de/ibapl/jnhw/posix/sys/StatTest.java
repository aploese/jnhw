/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ibapl.jnhw.posix.sys;

import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.posix.LibJnhwPosixTestLoader;
import de.ibapl.jnhw.util.posix.DefinesTest;
import static de.ibapl.jnhw.util.posix.DefinesTest.MULTIARCHTUPEL_BUILDER;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class StatTest {

    public static class NativeDefines {

        public final static native boolean HAVE_SYS_STAT_H();

        public final static native int S_IRGRP();

        public final static native int S_IROTH();

        public final static native int S_IRUSR();

        public final static native int S_IRWXG();

        public final static native int S_IRWXO();

        public final static native int S_IRWXU();

        public final static native int S_ISGID();

        public final static native int S_ISUID();

        public final static native int S_ISVTX();

        public final static native int S_IWGRP();

        public final static native int S_IWOTH();

        public final static native int S_IWUSR();

        public final static native int S_IXGRP();

        public final static native int S_IXOTH();

        public final static native int S_IXUSR();

        static {
            LibJnhwPosixTestLoader.touch();
        }

    }
    private final static MultiarchTupelBuilder MULTIARCHTUPEL_BUILDER = new MultiarchTupelBuilder();

    @Test
    public static void test_HAVE_SYS_STAT_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Stat.HAVE_SYS_STAT_H, "not expected to have sys/stat.h");
        } else {
            Assertions.assertTrue(Stat.HAVE_SYS_STAT_H, "expected to have sys/stat.h");
        }
    }

    @Test
    public void test_StatDefines() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Stat.class, NativeDefines.class, "HAVE_SYS_STAT_H");
    }

}
