/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2021-2024, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.syscall.linux.sysfs;

import de.ibapl.jnhw.syscall.linux.annotation.Path;
import java.lang.ref.WeakReference;

/**
 *
 * @author aploese
 */
@Path("/sys/")
public class SysFs {

    private static WeakReference<Bus> bus;

    @Path("/sys/bus/")
    public static Bus bus() {
        Bus result;
        if (bus == null) {
            result = new Bus();
            bus = new WeakReference<>(result);
        } else {
            result = bus.get();
            if (result == null) {
                result = new Bus();
                bus = new WeakReference<>(result);
            }
        }
        return result;
    }

}
