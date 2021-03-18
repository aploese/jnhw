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
package de.ibapl.jnhw.common.memory.layout;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 */
public abstract class StructLayout {

    @Deprecated
    public abstract int getSizeof();

    @Deprecated
    public abstract Alignment getAlignment();

    public StructLayout() {
    }

    public void check() {
        long currentOffset = 0;
        int currentBitpos = 0;
        FieldLayout previousField = null;
        for (Field f : getClass().getFields()) {
            try {
                if (FieldLayout.class.isInstance(f.getType()));
                final FieldLayout currentField = (FieldLayout) f.get(this);

                if (currentField instanceof FieldLayout.BitField) {
                    FieldLayout.BitField bf = (FieldLayout.BitField) currentField;
                    if (currentOffset != bf.offset) {
                        //start at a new (byte) address
                        currentBitpos = 0;
                    }
                    throw new RuntimeException();
                    /*                    testen Überlauf
                    shift und maske setzen
                    .
                    currentBitpos += bf.bits;
                     */
                } else {
                    currentBitpos = 0;
                }
                currentOffset = currentField.offset;
                previousField = currentField;
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(StructLayout.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(StructLayout.class.getName()).log(Level.SEVERE, null, ex);
            }
            throw new RuntimeException();
            /*            größe ok
            ?
            sizeof = size;
             */        }

    }
}
