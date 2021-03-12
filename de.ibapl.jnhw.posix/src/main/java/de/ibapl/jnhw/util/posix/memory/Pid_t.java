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
package de.ibapl.jnhw.util.posix.memory;

import de.ibapl.jnhw.annotation.posix.sys.types.pid_t;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.NativeIntNumber;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.util.posix.PosixDataType;
import java.io.IOException;

/**
 *
 * @author aploese
 */
@pid_t
public class Pid_t extends NativeIntNumber implements Accessor_Pid_t {

    private final static BaseDataType dataType = PosixDataType.pid_t.baseDataType;

    public Pid_t(AbstractNativeMemory owner, long offset, Byte setMem) {
        super(owner, offset, dataType.SIZE_OF, setMem);
    }

    @Override
    public void pid_t(OpaqueMemory32 mem, long offset, @pid_t int value) {
        PosixStruct32.ACCESSOR_PID_T.pid_t(mem, offset, value);
    }

    @Override
    @pid_t
    public int pid_t(OpaqueMemory32 mem, long offset) {
        return PosixStruct32.ACCESSOR_PID_T.pid_t(mem, offset);
    }

    @Override
    public String nativeToHexString() {
        return MEM_ACCESS.getSignedLongOf_AsHex(this, 0, sizeInBytes);
    }

    @Override
    public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
        sb.append(MEM_ACCESS.getSignedLongOf_nativeToString(this, 0, sizeInBytes));
    }

    @Override
    public BaseDataType getBaseDataType() {
        return dataType;
    }

}
