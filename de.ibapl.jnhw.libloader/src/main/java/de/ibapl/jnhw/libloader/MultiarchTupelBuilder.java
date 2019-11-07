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

import java.util.EnumSet;
import java.util.Set;

/**
 * Build the Multiarch Tuples
 * <a href="https://wiki.debian.org/Multiarch/Tuples">wiki.debian.org/Multiarch/Tuples</a>.
 * Multiarch Tuples are needed to figure out which native lib to load arm soft
 * float or hard float for example.
 *
 * @author Arne Plöse
 */
public final class MultiarchTupelBuilder {

    // known system properties
    public final String sun_os_patch_level;
    public final String os_arch;
    public final String os_name;
    public final String os_version;
    public final String sun_arch_abi;
    public final String sun_arch_data_model;
    public final String sun_cpu_endian;
    public final String sun_cpu_isalist;

    public MultiarchTupelBuilder() {
        super();
        sun_os_patch_level = System.getProperty("sun.os.patch.level");
        os_arch = System.getProperty("os.arch");
        os_name = System.getProperty("os.name");
        os_version = System.getProperty("os.version");
        sun_arch_abi = System.getProperty("sun.arch.abi");
        sun_arch_data_model = System.getProperty("sun.arch.data.model");
        sun_cpu_endian = System.getProperty("sun.cpu.endian");
        sun_cpu_isalist = System.getProperty("sun.cpu.isalist");
    }

    /**
     * Do not use this, its just for testing to fill in the right values...
     *
     * @param sun_os_patch_level
     * @param os_arch
     * @param os_name
     * @param os_version
     * @param sun_arch_abi
     * @param sun_cpu_endian
     * @param sun_cpu_isalist
     */
    MultiarchTupelBuilder(String sun_os_patch_level, String os_arch, String os_name, String os_version,
            String sun_arch_abi, String sun_arch_data_model, String sun_cpu_endian, String sun_cpu_isalist) {
        super();
        this.sun_os_patch_level = sun_os_patch_level;
        this.os_arch = os_arch;
        this.os_name = os_name;
        this.os_version = os_version;
        this.sun_arch_abi = sun_arch_abi;
        this.sun_arch_data_model = sun_arch_data_model;
        this.sun_cpu_endian = sun_cpu_endian;
        this.sun_cpu_isalist = sun_cpu_isalist;
    }

    private Set<MultiarchInfo> guessLinux() {
        Set<MultiarchInfo> result = EnumSet.noneOf(MultiarchInfo.class);
        switch (os_arch) {
            case "amd64":
                result.add(MultiarchInfo.X86_64__LINUX__GNU);
                return result;
            case "i386":
                result.add(MultiarchInfo.I386__LINUX__GNU);
                return result;
            case "arm":
                switch (sun_arch_data_model) {
                    case "32":
                        if (sun_arch_abi == null || sun_arch_abi.isEmpty()) {
                            // info of hard or soft float is missing
                            result.add(MultiarchInfo.ARM__LINUX__GNU_EABI_HF);
                            result.add(MultiarchInfo.ARM__LINUX__GNU_EABI);
                            return result;
                        } else {
                            switch (sun_arch_abi) {
                                case "gnueabi":
                                    result.add(MultiarchInfo.ARM__LINUX__GNU_EABI);
                                    return result;
                                case "gnueabihf":
                                    result.add(MultiarchInfo.ARM__LINUX__GNU_EABI_HF);
                                    return result;
                                default:
                                    throw new UnsupportedOperationException(
                                            "Can't handle sun.arch.abi of arm linux\n" + listSystemProperties());
                            }
                        }
                    default:
                        throw new UnsupportedOperationException(
                                "Can't handle sun.arch.data.model of arm linux\n" + listSystemProperties());
                }
            case "aarch64":
                switch (sun_arch_data_model) {
                    case "64":
                        switch (sun_cpu_endian) {
                            case "little":
                                result.add(MultiarchInfo.AARCH64__LINUX__GNU);
                                return result;
                            default:
                                throw new UnsupportedOperationException(
                                        "Can't handle sun.arch.abi of aarch64 linux\n" + listSystemProperties());
                        }
                    default:
                        throw new UnsupportedOperationException(
                                "Can't handle sun.arch.data.model of aarch64 linux\n" + listSystemProperties());
                }
            case "mips":
                switch (sun_arch_data_model) {
                    case "32":
                        switch (sun_cpu_endian) {
                            case "big":
                                result.add(MultiarchInfo.MIPS__LINUX__GNU);
                                return result;
                            default:
                                throw new UnsupportedOperationException(
                                        "Can't handle sun_cpu_endian of mips 32 linux\n" + listSystemProperties());
                        }
                    case "64":
                        switch (sun_cpu_endian) {
                            case "big":
                                switch (sun_arch_abi) {
                                    case "gnuabi64":
                                        result.add(MultiarchInfo.MIPS_64__LINUX__GNU_ABI_64);
                                        return result;
                                    default:
                                        throw new UnsupportedOperationException(
                                                "Can't handle sun.arch.abi of mips64 linux\n" + listSystemProperties());
                                }
                            default:
                                throw new UnsupportedOperationException(
                                        "Can't handle sun_cpu_endian of mips 32 linux\n" + listSystemProperties());
                        }
                    default:
                        throw new UnsupportedOperationException(
                                "Can't handle sun.arch.data.model of mips linux\n" + listSystemProperties());
                }
            case "mipsel":
                switch (sun_arch_data_model) {
                    case "32":
                        switch (sun_cpu_endian) {
                            case "little":
                                result.add(MultiarchInfo.MIPS_EL__LINUX__GNU);
                                return result;
                            default:
                                throw new UnsupportedOperationException(
                                        "Can't handle sun_cpu_endian of mipsel 32 linux\n" + listSystemProperties());
                        }
                    case "64":
                        switch (sun_cpu_endian) {
                            case "little":
                                switch (sun_arch_abi) {
                                    case "gnuabi64":
                                        result.add(MultiarchInfo.MIPS_64_EL__LINUX__GNU_ABI_64);
                                        return result;
                                    default:
                                        throw new UnsupportedOperationException(
                                                "Can't handle sun.arch.abi of mips64el linux\n" + listSystemProperties());
                                }
                            default:
                                throw new UnsupportedOperationException(
                                        "Can't handle sun_cpu_endian of mipsel 32 linux\n" + listSystemProperties());
                        }
                    default:
                        throw new UnsupportedOperationException(
                                "Can't handle sun.arch.data.model of mipsel linux\n" + listSystemProperties());
                }
            default:
                throw new UnsupportedOperationException("Can't handle os.arch of linux\n" + listSystemProperties());
        }

    }

    private Set<MultiarchInfo> guessFreeBSD() {
        Set<MultiarchInfo> result = EnumSet.noneOf(MultiarchInfo.class);
        switch (os_arch) {
            case "amd64":
                result.add(MultiarchInfo.X86_64__FREE_BSD__BSD);
                return result;
            default:
                throw new UnsupportedOperationException("Can't handle os.arch of FreeBSD\n" + listSystemProperties());
        }

    }

    private Set<MultiarchInfo> guessMacOS() {
        Set<MultiarchInfo> result = EnumSet.noneOf(MultiarchInfo.class);
        switch (os_arch) {
            case "x86_64":
                result.add(MultiarchInfo.X86_64__MAC_OS_X__BSD);
                return result;
            default:
                throw new UnsupportedOperationException("Can't handle os.arch of Mac OS X\n" + listSystemProperties());
        }

    }

    private Set<MultiarchInfo> guessWindows() {
        Set<MultiarchInfo> result = EnumSet.noneOf(MultiarchInfo.class);
        switch (os_arch) {
            case "amd64":
                result.add(MultiarchInfo.X86_64__WINDOWS__PE32_PLUS);
                return result;
            case "x86":
                result.add(MultiarchInfo.I386__WINDOWS__PE32);
                return result;
            default:
                throw new UnsupportedOperationException("Cant handle Windows architecture: " + os_arch);
        }

    }

    public Set<MultiarchInfo> guessMultiarch() {
        switch (getOs()) {
            case LINUX:
                return guessLinux();
            case FREE_BSD:
                return guessFreeBSD();
            case MAC_OS_X:
                return guessMacOS();
            case WINDOWS:
                return guessWindows();
            default:
                throw new UnsupportedOperationException("Cant handle " + os_name + " architecture: " + os_arch);
        }

    }

    public OS getOs() {
        switch (os_name) {
            case "Linux":
                return OS.LINUX;
            case "FreeBSD":
                return OS.FREE_BSD;
            case "Mac OS X":
                return OS.MAC_OS_X;
            default:
                if (os_name.startsWith("Windows")) {
                    return OS.WINDOWS;
                } else {
                    throw new IllegalArgumentException("Unknown OS: " + os_name);
                }
        }
    }

    public String listSystemProperties() {
        StringBuilder sb = new StringBuilder();
        for (String name : System.getProperties().stringPropertyNames()) {
            sb.append("\t").append(name).append(" = ").append(System.getProperty(name)).append("\n");
        }
        return sb.toString();
    }

}
