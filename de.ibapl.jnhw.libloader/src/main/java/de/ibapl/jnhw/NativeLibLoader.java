/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ibapl.jnhw;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.nio.CharBuffer;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 */
public abstract class NativeLibLoader {

    protected final static Logger LOG = Logger.getLogger("de.ibapl.libjnhw");

    private final static Map<String, String> libNames = new HashMap<>();
    private final static Map<String, Throwable> loadErrors = new HashMap<>();
    protected final static MultiarchTupelBuilder MULTIARCH_TUPEL_BUILDER;
    protected final static Set<MultiarchInfo> MULTIARCH_INFO;
    protected final static OS OS;
    protected final static File NATIVE_TEMP_DIR;

    /**
     * Setup native lib Sometimes arm-linux-gnueabihf and arm-linux-gnuabihf
     * cant be distinguished
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
            LOG.log(Level.SEVERE, "Unknown exception sys propereties: \n" + MULTIARCH_TUPEL_BUILDER.listSystemProperties(), t);
        }
        OS = os;
        MULTIARCH_INFO = multiarchInfo;

        File nativeTemDir = null;
        try {
            nativeTemDir = File.createTempFile("jnhw-native-loader", "lib-dir");
            nativeTemDir.delete();
            nativeTemDir.mkdir();
            nativeTemDir.deleteOnExit();
        } catch (IOException ioe) {
            LOG.log(Level.SEVERE, "Can't create tempDir sys propereties: \n" + MULTIARCH_TUPEL_BUILDER.listSystemProperties(), ioe);
        }
        NATIVE_TEMP_DIR = nativeTemDir;
    }

    public static Throwable getLoadError(String libName) {
        return loadErrors.get(libName);
    }

    public static boolean hasLoadError(String libName) {
        return loadErrors.containsKey(libName);
    }

    protected NativeLibLoader() {
    }

    public static boolean isLibLoaded(String libname) {
        synchronized (libNames) {
            return libNames.containsKey(libname);
        }
    }

    public static String getLibLoadedName(String libname) {
        synchronized (libNames) {
            return libNames.get(libname);
        }
    }

    public static boolean loadNativeLib(final String libName, int libToolInterfaceVersion) {
        synchronized (libNames) {
            if (libNames.containsKey(libName)) {
                LOG.log(Level.INFO, "Lib " + libName + " was Loaded as: " + libNames.get(libName));
                return true;
            }
            String[] javaLibraryPath = System.getProperty("java.library.path").split(":");
            String formattedLibName = OS.formatLibName(libName, libToolInterfaceVersion);
            for (int i = 0; i < javaLibraryPath.length; i++) {
                final String absLibName = javaLibraryPath[i] + "/" + formattedLibName;
                if (new File(absLibName).exists()) {
                    try {
                        System.load(absLibName);
                        libNames.put(libName, libName);
                        loadErrors.remove(libName);
                        LOG.log(Level.INFO, "Lib {0} loaded via System.load(\"{1}\")", new Object[]{libName, absLibName});
                        return true;
                    } catch (UnsatisfiedLinkError ule) {
                        LOG.log(Level.INFO, ule, () -> {
                            return String.format("Could not load %s via System.load(\"%s\")", libName, absLibName);
                        });
                    }
                }
            }
            return loadFromResource(libName, formattedLibName);
        }
    }

    private static boolean loadFromResource(final String libName, final String formattedLibName) {
        for (MultiarchInfo mi : MULTIARCH_INFO) {
            // Figure out os and arch
            final String libResourceName = String.format("lib/%s/%s", mi.getTupelName(), formattedLibName);
            // Try from classpath like the tests or extracted jars do
            URL classPathLibURL = NativeLibLoader.class.getClassLoader().getResource(libResourceName);
            if (classPathLibURL == null) {
                LOG.log(Level.SEVERE, "Lib {0} is not in classpath with resourcename: {1}", new Object[]{libName, libResourceName});
                loadErrors.put(libName, new RuntimeException("Lib " + libName + " is not in classpath with resourcename: " + libResourceName));
                return false;
            }
            String classPathLibName = classPathLibURL.getFile();
            
            // Unbundled aka not within a jar
            LOG.log(Level.INFO, "Try load {0} from filesystem with libName: {1}", new Object[]{libName, classPathLibName});
            try {
                System.load(classPathLibName);
                libNames.put(libName, classPathLibName);
                loadErrors.remove(libName);
                LOG.log(Level.INFO, "Lib {0} loaded via System.load(\"{1}\")", new Object[]{libName, classPathLibName});
                return true;
            } catch (UnsatisfiedLinkError ule) {
                LOG.log(Level.INFO, "Native lib {0} for {1} not loaded: {2}", new Object[]{classPathLibName, libName, ule.getMessage()});
            } catch (Throwable t) {
                LOG.log(Level.INFO, "Native lib not loaded.", t);
            }

            try {
                File tmpLib = copyToNativeLibDir(classPathLibURL, formattedLibName);
                classPathLibName = tmpLib.getAbsolutePath();

                if (getOS() == OS.MAC_OS_X) {
                    URL classPathLibHelperURL = NativeLibLoader.class.getClassLoader().getResource(libResourceName + ".sh");
                    if (classPathLibHelperURL != null) {
                        String helperName = formattedLibName + ".sh";
                        File libLocationFixScript = copyToNativeLibDir(classPathLibHelperURL, helperName);
                        Process child = new ProcessBuilder("/bin/sh", helperName).directory(NATIVE_TEMP_DIR).start();
                        child.waitFor();
                        if (child.exitValue() != 0) {
                            //Todo collect error stream
                            LOG.log(Level.SEVERE, "executing Script failed (\"{0}\")", libLocationFixScript);
                        }
                    }
                }
                System.load(classPathLibName);
                libNames.put(libName, classPathLibName);
                loadErrors.remove(libName);
                LOG.log(Level.INFO, "Lib loaded via System.load(\"{0}\")", classPathLibName);
                return true;
            } catch (Throwable t) {
                LOG.log(Level.SEVERE, "Can't load the lib \"" + classPathLibName + "\" List System Properties\n " + MULTIARCH_TUPEL_BUILDER.listSystemProperties() + "\n", t);
                loadErrors.put(libName, t);
            }
        }
        LOG.log(Level.SEVERE, "Giving up; Can't load the lib {0}!\nList System Properties\n {1} \n",
                new Object[]{libName, MULTIARCH_TUPEL_BUILDER.listSystemProperties()});
        if (!loadErrors.containsKey(libName)) {
            loadErrors.put(libName, null);
        }
        return false;
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

    public static boolean loadClassicalNativeLib(final String libName) {
        synchronized (libNames) {
            if (libNames.containsKey(libName)) {
                LOG.log(Level.INFO, "Lib {0} was Loaded as: {1}", new Object[]{libName, libNames.get(libName)});
                return true;
            }
            LOG.log(Level.INFO, "java.library.path: \"{0}\"", System.getProperty("java.library.path"));
            return loadFromResource(libName, System.mapLibraryName(libName));
        }
    }

    public static OS getOS() {
        return OS;
    }
}
