/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ibapl.jnhw;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
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

    /**
     * Setup native lib Sometimes arm-linux-gnueabihf and arm-linux-gnuabihf
     * cant be distinguished
     */
    static {
        MULTIARCH_TUPEL_BUILDER = new MultiarchTupelBuilder();
        MULTIARCH_INFO = MULTIARCH_TUPEL_BUILDER.guessMultiarch();
        Iterator<MultiarchInfo> iter = MULTIARCH_INFO.iterator();
        if (iter.hasNext()) {
            OS = iter.next().getOS();
        } else {
            OS = null;
        }
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
                        LOG.log(Level.INFO, "Lib {0} loaded via System.load(\"{1}\")", new String[]{libName, absLibName});
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
                LOG.log(Level.SEVERE, "Lib {0} is not in classpath with resourcename: {1}", new String[]{libName, libResourceName});
                loadErrors.put(libName, new RuntimeException("Lib " + libName + " is not in classpath with resourcename: " + libResourceName));
                return false;
            }
            String classPathLibName = classPathLibURL.getFile();
            // Unbundled aka not within a jar
            LOG.log(Level.INFO, "Try load {0} from filesystem with libName: {1}", new String[]{libName, classPathLibName});
            try {
                System.load(classPathLibName);
                libNames.put(libName, classPathLibName);
                loadErrors.remove(libName);
                LOG.log(Level.INFO, "Lib {0} loaded via System.load(\"{1}\")", new String[]{libName, classPathLibName});
                return true;
            } catch (UnsatisfiedLinkError ule) {
                LOG.log(Level.INFO, "Native lib {0} for {1} not loaded: {2}", new String[]{classPathLibName, libName, ule.getMessage()});
            } catch (Throwable t) {
                LOG.log(Level.INFO, "Native lib not loaded.", t);
            }

            // If nothing helps, do it the hard way: unpack to temp and load that.
            File tmpLib = null;
            try (InputStream is = classPathLibURL.openStream()) {
                int splitPos = classPathLibName.lastIndexOf('.');
                if (splitPos <= 0) {
                    // ERROR
                }
                File tmpLibDir = File.createTempFile(classPathLibName.substring(0, splitPos), classPathLibName.substring(splitPos));
                tmpLibDir.delete();
                tmpLibDir.mkdir();
                tmpLib = new File(tmpLibDir, formattedLibName);
                /*
                    if (getOS() == OS.WINDOWS) {
                    //On win we must load the lib with the correct name ...
                    //TODO check if exists ...
                    //TODO do this for all ???
                    tmpLib = new File(System.getProperty("java.io.tmpdir"), formattedLibName);
                } else {
                    tmpLib = File.createTempFile(classPathLibName.substring(0, splitPos), classPathLibName.substring(splitPos));
                }
                 */
                tmpLibDir.deleteOnExit();
                try (FileOutputStream fos = new FileOutputStream(tmpLib)) {
                    byte[] buff = new byte[1024];
                    int i;
                    while ((i = is.read(buff)) > 0) {
                        fos.write(buff, 0, i);
                    }
                    fos.flush();
                }
                LOG.log(Level.INFO, "Try temp copy\nfrom:\t{0}\nto:\t{1}",
                        new String[]{classPathLibName, tmpLib.getAbsolutePath()});
                classPathLibName = tmpLib.getAbsolutePath();
                System.load(classPathLibName);
                libNames.put(libName, classPathLibName);
                loadErrors.remove(libName);
                tmpLibDir.delete();
                LOG.log(Level.INFO, "Lib loaded via System.load(\"{0}\")", classPathLibName);
                return true;
            } catch (Throwable t) {
                LOG.log(Level.SEVERE, "Can't load the lib \"" + classPathLibName + "\" List System Properties", t);
                loadErrors.put(libName, t);
            }
        }
        LOG.log(Level.SEVERE, "Giving up can't load the lib {0}! Will list System Properties\n{1}",
                new String[]{libName, MULTIARCH_TUPEL_BUILDER.listSystemProperties()});
        loadErrors.put(libName, null);
        return false;
    }

    public static boolean loadClassicalNativeLib(final String libName) {
        synchronized (libNames) {
            if (libNames.containsKey(libName)) {
                LOG.log(Level.INFO, "Lib " + libName + " was Loaded as: " + libNames.get(libName));
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
