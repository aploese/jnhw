/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2019, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.libloader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class resolves a native lib. The resoler expects a native lib with a
 * name generated by libtool. The resolver scans first the
 * <code>java.library.path} for the lib. If the lib is not found it will
 * be searched in the resources of the Consumers class. The search directoy is
 * /lib/. If its found it will be copied to the temp dir and can be loaded with
 * the class loader that actually needs the lib. This makes sure that OSGi can
 * find, load and use the native lib, because each bundle has its own
 * classloder. So a lib loded from this bundle cant be used in the Consumers
 * bundle. This is needed because <code>System.load(absoluteLibName)} uses
 * refecti9ons to find the correct classloder which is the one that System.load
 * is called.
 *
 *
 * @author aploese
 *
 */
public abstract class NativeLibResolver {

    protected final static Logger LOG = Logger.getLogger("de.ibapl.libjnhw");

    protected final static MultiarchTupelBuilder MULTIARCH_TUPEL_BUILDER;
    protected final static Set<MultiarchInfo> MULTIARCH_INFO;
    protected final static OS RUNNING_ON_OS;
    protected final static File NATIVE_TEMP_DIR;
    protected static MultiarchInfo loadedMultiarch;

    /**
     * Setup native lib. Sometimes arm-linux-gnueabi and arm-linux-gnueabihf
     * can't be distinguished afer loading a lib from the resource we know what
     * we are on.
     */
    static {
        MULTIARCH_TUPEL_BUILDER = new MultiarchTupelBuilder();
        Set<MultiarchInfo> multiarchInfo = EnumSet.noneOf(MultiarchInfo.class);
        OS os = null;
        try {
            multiarchInfo = MULTIARCH_TUPEL_BUILDER.guessMultiarch();
            Iterator<MultiarchInfo> iter = multiarchInfo.iterator();
            if (iter.hasNext()) {
                os = iter.next().getOS();
            } else {
                os = null;
            }
        } catch (Throwable t) {
            LOG.log(Level.SEVERE,
                    "Unknown exception sys properties: \n" + MULTIARCH_TUPEL_BUILDER.listSystemProperties(), t);
        }
        RUNNING_ON_OS = os;
        MULTIARCH_INFO = multiarchInfo;

        File nativeTemDir = null;
        try {
            nativeTemDir = File.createTempFile("jnhw-native-loader", "lib-dir");
            nativeTemDir.delete();
            nativeTemDir.mkdir();
            nativeTemDir.deleteOnExit();
        } catch (IOException ioe) {
            LOG.log(Level.SEVERE,
                    "Can't create tempDir sys properties: \n" + MULTIARCH_TUPEL_BUILDER.listSystemProperties(), ioe);
        }
        NATIVE_TEMP_DIR = nativeTemDir;
    }

    private static void trySetloadedMultiarch() {
        Iterator<MultiarchInfo> iterator = MULTIARCH_INFO.iterator();
        MultiarchInfo first;
        if (iterator.hasNext()) {
            first = iterator.next();
        } else {
            return;
        }
        if (!iterator.hasNext()) {
            loadedMultiarch = first;
        }
    }

    private NativeLibResolver() {
    }

    /**
     * Only call System.load(absLibName); in the subclass - so OSGi can pick the
     * right classloader...
     *
     * @param libName the name of the lib without any pre or posfix. @see OS for
     * the naming templates.
     * @param libToolInterfaceVersion the libtool version.
     * @param consumer the consumer which really load the lib.
     * @return the result of this attempt to load the native lib.
     */
    public static synchronized LoadResult loadNativeLib(final String libName, int libToolInterfaceVersion,
            Consumer<String> consumer) {
        String[] javaLibraryPath = System.getProperty("java.library.path").split(":");
        String formattedLibName = RUNNING_ON_OS.formatLibName(libName, libToolInterfaceVersion);
        for (String javaLibraryPathElement : javaLibraryPath) {
            final String absLibName = javaLibraryPathElement + "/" + formattedLibName;
            if (new File(absLibName).exists()) {
                try {
                    consumer.accept(absLibName);
                    LOG.log(Level.INFO, "Lib {0} loaded via System.load(\"{1}\")",
                            new Object[]{libName, absLibName});
                    trySetloadedMultiarch();
                    return LoadResult.successFromLibraryPath(libName, formattedLibName, absLibName);
                } catch (UnsatisfiedLinkError ule) {
                    LOG.log(Level.FINE, ule, () -> {
                        return String.format("Could not load %s via System.load(\"%s\")", libName, absLibName);
                    });
                }
            }
        }
        return loadFromResource(libName, formattedLibName, consumer);
    }

    private static LoadResult loadFromResource(final String libName, final String formattedLibName,
            Consumer<String> consumer) {
        for (MultiarchInfo mi : MULTIARCH_INFO) {
            // Figure out os and arch
            final String libResourceName = String.format("/lib/%s/%s", mi.getTupelName(), formattedLibName);
            // Try from classpath like the tests or extracted jars do
            URL classPathLibURL = consumer.getClass().getResource(libResourceName);
            if (classPathLibURL == null) {
                LOG.log(Level.SEVERE, "Lib \"{0}\" is not in classpath with resourcename: \"{1}\"",
                        new Object[]{libName, libResourceName});
                // TODO check if we are just in the wrong arch???
                return LoadResult.fail(libName, formattedLibName, new FileNotFoundException(
                        "Lib " + libName + " is not in classpath with resourcename: " + libResourceName));
            }
            String classPathLibName = classPathLibURL.getFile();

            // Unbundled aka not within a jar
            LOG.log(Level.INFO, "Try load \"{0}\" from filesystem with libName: \"{1}\"",
                    new Object[]{libName, classPathLibURL.toString()});
            // On MacOS we cant load the lib directly, we must fix first the internal id and
            // lib path ... only copy to tmp and fix the path solves this
            if (getOS() != OS.MAC_OS_X) {
                try {
                    consumer.accept(classPathLibName);
                    LOG.log(Level.INFO, "\"{0}\" loaded via System.load(\"{1}\")",
                            new Object[]{libName, classPathLibName});
                    loadedMultiarch = mi;
                    return LoadResult.successFromClassPath(libName, formattedLibName, classPathLibURL);
                } catch (UnsatisfiedLinkError ule) {
                    LOG.log(Level.FINE, "lib {0} for {1} not loaded: {2}",
                            new Object[]{classPathLibName, libName, ule.getMessage()});
                } catch (Throwable t) {
                    LOG.log(Level.FINE, "Native lib not loaded.", t);
                }
            }
            // Copy to tmp
            try {
                File tmpLib = copyToNativeLibDir(classPathLibURL, formattedLibName);
                classPathLibName = tmpLib.getAbsolutePath();

                if (getOS() == OS.MAC_OS_X) {
                    URL classPathLibHelperURL = consumer.getClass().getResource(libResourceName + ".sh");
                    if (classPathLibHelperURL != null) {
                        String helperName = formattedLibName + ".sh";
                        File libLocationFixScript = copyToNativeLibDir(classPathLibHelperURL, helperName);
                        Process child = new ProcessBuilder("/bin/sh", helperName).directory(NATIVE_TEMP_DIR).start();
                        child.waitFor();
                        if (child.exitValue() != 0) {
                            // Todo collect error stream
                            LOG.log(Level.SEVERE, "executing Script failed (\"{0}\")", libLocationFixScript);
                        }
                    }
                }
                consumer.accept(classPathLibName);
                LOG.log(Level.INFO, "Lib loaded via System.load(\"{0}\")", classPathLibName);
                tmpLib.delete();
                loadedMultiarch = mi;
                return LoadResult.successFromTempCopy(libName, formattedLibName, classPathLibURL,
                        tmpLib.getCanonicalPath());
            } catch (Throwable t) {
                // do not delete tmpLib so it can be examined to figure out what went wrong...
                // do not stop here.. maybe it is only the wron abi like arm spftfloat and
                // hardfloat ...
                LOG.log(Level.SEVERE, "Can't load the lib \"" + classPathLibName + "\" List System Properties\n "
                        + MULTIARCH_TUPEL_BUILDER.listSystemProperties() + "\n", t);
            }
        }
        LOG.log(Level.SEVERE, "Giving up! Can't load the lib {0} \nList System Properties\n {1} \n",
                new Object[]{libName, MULTIARCH_TUPEL_BUILDER.listSystemProperties()});
        return LoadResult.fail(libName, formattedLibName, new IOException("Can't load the lib \"" + libName
                + "\" foramtted as: \"" + formattedLibName + "\" for any Architectures"));
    }

    private static File copyToNativeLibDir(URL sourceURL, final String targetName) throws IOException {
        // If nothing helps, do it the hard way: unpack to temp and load that.
        try (InputStream is = sourceURL.openStream()) {
            File result = new File(NATIVE_TEMP_DIR, targetName);
            LOG.log(Level.INFO, "Try temp copy\nfrom:\t{0}\nto:\t{1}",
                    new Object[]{sourceURL.getFile(), result.getAbsolutePath()});

            try (FileOutputStream fos = new FileOutputStream(result)) {
                byte[] buff = new byte[1024];
                int i;
                while ((i = is.read(buff)) > 0) {
                    fos.write(buff, 0, i);
                }
                fos.flush();
            }
            return result;
        }
    }

    public static synchronized LoadResult loadClassicalNativeLib(final String libName, Consumer<String> consumer) {
        LOG.log(Level.FINE, "java.library.path: \"{0}\"", System.getProperty("java.library.path"));
        return loadFromResource(libName, System.mapLibraryName(libName), consumer);
    }

    public static OS getOS() {
        return RUNNING_ON_OS;
    }

    public static Iterable<MultiarchInfo> getMultiArchInfos() {
        return MULTIARCH_INFO::iterator;
    }
    
    public static MultiarchInfo getLoadedMultiarch() {
        return loadedMultiarch;
    }
    
    public static Arch getLoadedArch() {
        return loadedMultiarch != null ? loadedMultiarch.getArch() : null;
    }
}
