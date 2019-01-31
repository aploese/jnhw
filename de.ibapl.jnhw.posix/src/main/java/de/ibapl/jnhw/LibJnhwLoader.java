/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ibapl.jnhw;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 */
public abstract class LibJnhwLoader {

    public static class OpaqueMemory {

        public final long baseAddress;
        public final int sizeInBytes;
        public final OpaqueMemory memoryOwner;

        public final static native long allocateMemory(int sizeInBytes);

        public final static native void freeMemory(long baseAddress);

        public OpaqueMemory(int sizeInBytes) {
            this.sizeInBytes = sizeInBytes;
            baseAddress = allocateMemory(sizeInBytes);
            memoryOwner = this;
        }

        public OpaqueMemory(OpaqueMemory owner, long baseAddress, int sizeInBytes) {
            this.baseAddress = baseAddress;
            this.sizeInBytes = sizeInBytes;
            memoryOwner = owner;
        }

        @Override
        protected void finalize() throws Throwable {
            try {
                if (memoryOwner == this) {
                    LOG.log(Level.INFO, String.format("Finalize: try free memory @0x%016x size: %d", baseAddress, sizeInBytes));
                    freeMemory(baseAddress);
                    LOG.log(Level.INFO, String.format("memory @0x%016x freed", baseAddress));
                } else {
                    LOG.log(Level.INFO, String.format("Finalize: memory @0x%016x size: %d belongs to %s", baseAddress, sizeInBytes, memoryOwner));
                }
            } catch (Throwable t) {
                LOG.log(Level.SEVERE, String.format("Finalize: Memory Leak freeing memory @0x%016x size: %d failed", baseAddress, sizeInBytes), t);
            } finally {
                super.finalize();
            }
        }
    }

    public static abstract class StructArray<T extends OpaqueMemory> extends OpaqueMemory {

        private final T[] pointers;

        public StructArray(int elementSizeInBytes, T[] array) {
            super(elementSizeInBytes * array.length);
            pointers = array;
            for (int i = 0; i < array.length; i++) {
                pointers[i] = createElement(baseAddress + i * elementSizeInBytes);
            }
        }

        public final T get(int index) {
            return pointers[index];
        }

        public final int length() {
            return pointers.length;
        }

        protected abstract T createElement(long elementBaseAddress);

    }

    protected final static Logger LOG = Logger.getLogger("de.ibapl.libjnhw");

    private volatile static boolean libLoaded;
    private final static Object loadLock;
    private static String libName;
    private final static MultiarchTupelBuilder MULTIARCH_TUPEL_BUILDER = new MultiarchTupelBuilder();

    static {
        libLoaded = false;
        loadLock = new Object();
        loadNativeLib();
    }

    protected LibJnhwLoader() {
    }

    public static boolean isLibLoaded() {
        return libLoaded;
    }

    //libLoaded will be set in the native code.
    private static boolean loadNativeLib() {
        synchronized (loadLock) {
            if (libLoaded) {
                LOG.log(Level.INFO, "Lib was Loaded");
                return false;
            }
            LOG.log(Level.INFO, "java.library.path: \"{0}\"", System.getProperty("java.library.path"));

            for (MultiarchInfo multiarchtupel : MULTIARCH_TUPEL_BUILDER.guessMultiarch()) {

                libName = "jnhw";

                // Try it plain - OSGi will load with the bundle classloader - or if there are
                // in the "java.library.path"
                LOG.log(Level.INFO, "Try plain with libName: {0}", libName);
                try {
                    System.loadLibrary(libName);
                    LOG.log(Level.INFO, "Lib loaded via System.loadLibrary(\"{0}\")", libName);
                    libLoaded = true;
                    return true;
                } catch (UnsatisfiedLinkError ule) {
                    LOG.log(Level.INFO, "Native lib {0} not loaded: {1}", new String[]{libName, ule.getMessage()});
                } catch (Throwable t) {
                    LOG.log(Level.INFO, "Native lib not loaded.", t);
                }

                // Figure out os and arch
                final String libResourceName = String.format("lib/%s/%s", multiarchtupel.getTupelName(), System.mapLibraryName(libName));
                // Try from classpath like the tests or extracted jars do
                libName = LibJnhwLoader.class.getClassLoader().getResource(libResourceName).getFile();
                if (new File(libName).exists()) {
                    // Unbundled aka not within a jar
                    LOG.log(Level.INFO, "Try from filesystem with libName: {0}", libName);
                    try {
                        System.load(libName);
                        LOG.log(Level.INFO, "Lib loaded via System.load(\"{0}\")", libName);
                        libLoaded = true;
                        return true;
                    } catch (UnsatisfiedLinkError ule) {
                        LOG.log(Level.INFO, "Native lib {0} not loaded: {1}", new String[]{libName, ule.getMessage()});
                    } catch (Throwable t) {
                        LOG.log(Level.INFO, "Native lib not loaded.", t);
                    }
                }

                // If nothing helps, do it the hard way: unpack to temp and load that.
                File tmpLib = null;
                try (InputStream is = LibJnhwLoader.class.getClassLoader()
                        .getResourceAsStream(libResourceName)) {
                    if (is == null) {
                        throw new RuntimeException("Cant find lib: " + libName + "in resources");
                    }
                    int splitPos = libName.lastIndexOf('.');
                    if (splitPos <= 0) {
                        // ERROR
                    }
                    tmpLib = File.createTempFile(libName.substring(0, splitPos), libName.substring(splitPos));
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
                            new String[]{libName, tmpLib.getAbsolutePath()});
                    libName = tmpLib.getAbsolutePath();
                    System.load(libName);
                    tmpLib.delete();
                    libLoaded = true;
                    LOG.log(Level.INFO, "Lib loaded via System.load(\"{0}\")", tmpLib.getAbsolutePath());
                    return true;
                } catch (Throwable t) {
                    LOG.log(Level.SEVERE, "Can't load the lib \"" + tmpLib.getAbsolutePath() + "\" List System Properties",
                            t);
                }
            }
            LOG.log(Level.SEVERE, "Giving up can't load the lib! Will list System Properties\n{0}",
                    new Object[]{MULTIARCH_TUPEL_BUILDER.listSystemProperties()});
            throw new RuntimeException("Can't load jnhw native lib, giving up! See logs for details!");
        }
    }

}
