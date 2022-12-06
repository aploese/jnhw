/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.datatypes.MultiarchTupelBuilder;
import de.ibapl.jnhw.common.memory.NativeIntNumber;
import de.ibapl.jnhw.util.winapi.WinApiDataType;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;

/**
 * Wrapper around the
 * <a href="https://docs.microsoft.com/en-us/windows/win32/api/basetsd/">BaseTsd.h</a>
 * header.
 *
 * @author aploese
 */
@Include("basetsd.h")
public abstract class BaseTsd {

    public static abstract class PULONG_PTR extends NativeIntNumber<Long> {

        private static class PULONG_PTR64 extends PULONG_PTR {

            private PULONG_PTR64(MemorySegment memorySegment, long offset) {
                super(memorySegment, offset);
            }

            @Override
            public long PULONG_PTR() {
                return MEM_ACCESS.uint64_t(memorySegment, 0);
            }

            @Override
            public void PULONG_PTR(long value) {
                MEM_ACCESS.uint64_t(memorySegment, 0, value);
            }

        }

        private static class PULONG_PTR32 extends PULONG_PTR {

            private PULONG_PTR32(MemorySegment memorySegment, long offset) {
                super(memorySegment, offset);
            }

            @Override
            public long PULONG_PTR() {
                return MEM_ACCESS.uint32_t_AsLong(memorySegment, 0);
            }

            @Override
            public void PULONG_PTR(long value) {
                MEM_ACCESS.uint32_t_FromLong(memorySegment, 0, value);
            }

        }

        public final static BaseDataType DATA_TYPE = WinApiDataType.ULONG_PTR;

        public static PULONG_PTR allocateNative(MemorySession ms) {
            final MemorySegment segment = MemorySegment.allocateNative(DATA_TYPE.SIZE_OF, ms);
            switch (DATA_TYPE) {
                case uint32_t -> {
                    return new PULONG_PTR32(segment, 0);
                }
                case uint64_t -> {
                    return new PULONG_PTR64(segment, 0);
                }
                default ->
                    throw new RuntimeException("Cant handle PULONG_PTR for " + MultiarchTupelBuilder.getMultiarch());
            }
        }

        protected PULONG_PTR(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, DATA_TYPE.SIZE_OF);
        }

        public abstract long PULONG_PTR();

        public abstract void PULONG_PTR(long value);

        @Override
        public BaseDataType getBaseDataType() {
            return DATA_TYPE;
        }
    }

}
