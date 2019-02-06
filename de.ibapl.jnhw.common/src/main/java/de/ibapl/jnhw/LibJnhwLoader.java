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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 */
public abstract class LibJnhwLoader {

    protected final static Logger LOG = Logger.getLogger("de.ibapl.libjnhw");

    private final static Map<String, String> libNames = new HashMap<>();
    protected final static MultiarchTupelBuilder MULTIARCH_TUPEL_BUILDER = new MultiarchTupelBuilder();
    public final static String LIB_JNHW = "jnhw";
    public final static String LIB_JNHW_COMMON = "jnhw-common";

    static {
        loadLibJnhw();
    }

    protected LibJnhwLoader() {

    }

    protected static void loadLibJnhw() {
        loadNativeLib(LIB_JNHW_COMMON);
        loadNativeLib(LIB_JNHW);
    }

    public static boolean isLibJnhwLoaded() {
        synchronized (libNames) {
            return libNames.containsKey(LIB_JNHW);
        }
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

    public static String getLibJnhwLoadedName() {
        synchronized (libNames) {
            return libNames.get(LIB_JNHW);
        }
    }

    protected static void loadNativeLib(final String libName) {
        synchronized (libNames) {
            if (libNames.containsKey(libName)) {
                LOG.log(Level.INFO, "Lib " + libName + " was Loaded as: " + libNames.get(libName));
                return;
            }
            LOG.log(Level.INFO, "java.library.path: \"{0}\"", System.getProperty("java.library.path"));

            for (MultiarchInfo multiarchtupel : MULTIARCH_TUPEL_BUILDER.guessMultiarch()) {

                // Try it plain - OSGi will load with the bundle classloader - or if there are
                // in the "java.library.path"
                LOG.log(Level.INFO, "Try plain with libName: {0}", libName);
                try {
                    System.loadLibrary(libName);
                    libNames.put(libName, libName);
                    LOG.log(Level.INFO, "Lib loaded via System.loadLibrary(\"{0}\")", libName);
                    return;
                } catch (UnsatisfiedLinkError ule) {
                    LOG.log(Level.INFO, "Native lib {0} not loaded: {1}", new String[]{libName, ule.getMessage()});
                } catch (Throwable t) {
                    LOG.log(Level.INFO, "Native lib not loaded.", t);
                }

                // Figure out os and arch
                final String libResourceName = String.format("lib/%s/%s", multiarchtupel.getTupelName(), System.mapLibraryName(libName));
                // Try from classpath like the tests or extracted jars do
                URL classPathLibURL = LibJnhwLoader.class.getClassLoader().getResource(libResourceName);
                if (classPathLibURL == null) {
                    throw new RuntimeException("Lib " + libName + " is not in claspath with resourcename: " + libResourceName);
                }
                String classPathLibName = classPathLibURL.getFile();
                if (new File(classPathLibName).exists()) {
                    // Unbundled aka not within a jar
                    LOG.log(Level.INFO, "Try load {0} from filesystem with libName: {1}", new String[]{libName, classPathLibName});
                    try {
                        System.load(classPathLibName);
                        libNames.put(libName, classPathLibName);
                        LOG.log(Level.INFO, "Lib {0} loaded via System.load(\"{1}\")", new String[]{libName, classPathLibName});
                        return;
                    } catch (UnsatisfiedLinkError ule) {
                        LOG.log(Level.INFO, "Native lib {0} for {1} not loaded: {2}", new String[]{classPathLibName, libName, ule.getMessage()});
                    } catch (Throwable t) {
                        LOG.log(Level.INFO, "Native lib not loaded.", t);
                    }
                }

                // If nothing helps, do it the hard way: unpack to temp and load that.
                File tmpLib = null;
                try (InputStream is = LibJnhwLoader.class.getClassLoader()
                        .getResourceAsStream(libResourceName)) {
                    if (is == null) {
                        throw new RuntimeException("Cant find lib: " + classPathLibName + " in resources");
                    }
                    int splitPos = classPathLibName.lastIndexOf('.');
                    if (splitPos <= 0) {
                        // ERROR
                    }
                    tmpLib = File.createTempFile(classPathLibName.substring(0, splitPos), classPathLibName.substring(splitPos));
                    tmpLib.deleteOnExit();
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
                    tmpLib.delete();
                    LOG.log(Level.INFO, "Lib loaded via System.load(\"{0}\")", classPathLibName);
                    return;
                } catch (Throwable t) {
                    LOG.log(Level.SEVERE, "Can't load the lib \"" + classPathLibName + "\" List System Properties",
                            t);
                }
            }
            LOG.log(Level.SEVERE, "Giving up can't load the lib {0}! Will list System Properties\n{1}",
                    new String[]{libName, MULTIARCH_TUPEL_BUILDER.listSystemProperties()});
            throw new RuntimeException("Can't load jnhw native lib, giving up! See logs for details!");
        }
    }

}
