/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.util.posix.upcall;

import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr__V__MA;
import de.ibapl.jnhw.common.upcall.CallbackFactory__V__MA;
import de.ibapl.jnhw.common.upcall.Callback__V__MA;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.util.posix.nativepointer.FunctionPtr__V__UnionSigval;
import java.lang.foreign.MemoryAddress;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;
import java.util.function.ToIntFunction;

/**
 *
 * @author aploese
 */
public abstract class Callback__V__UnionSigval<A extends OpaqueMemory> extends FunctionPtr__V__UnionSigval<A> {

    private static class CallChain__V__MA extends Callback__V__MA {

        private Callback__V__UnionSigval dest;

        @Override
        protected void callback(MemoryAddress address) {
            dest.callback(address, TO_INT_SIGVAL.applyAsInt(address));
        }
    }

    private final static ToIntFunction<MemoryAddress> TO_INT_SIGVAL = switch (MultiarchTupelBuilder.getEndianess()) {
        case BIG ->
            switch (MultiarchTupelBuilder.getMemoryModel()) {
                case LP64 ->
                    (value) -> (int) (value.toRawLongValue() >>> 32);
                case LP32 ->
                    (value) -> (int) value.toRawLongValue();
                default ->
                    throw new RuntimeException("Can't handle big endian and memory model " + MultiarchTupelBuilder.getMemoryModel());
            };
        case LITTLE ->
            (value) -> (int) value.toRawLongValue();
        default ->
            throw new RuntimeException("Can't handle endianness " + MultiarchTupelBuilder.getEndianess());
    };

    private final Callback__V__MA callback__V__MA;

    private static final List<WeakReference<Callback__V__UnionSigval<?>>> REFS = new LinkedList<>();

    /**
     * Iterate over weak references all instances oth this class and if the
     * reference is gone remove the weak reference.Return the first found
     * instance or null if none is found.
     *
     * @param callbackPtr
     * @return the first found instance or null if none is found.
     */
    public static Callback__V__UnionSigval<?> find(FunctionPtr__V__MA callbackPtr) {
        return find(callbackPtr.toAddressable().address());
    }

    /**
     * Iterate over weak references all instances oth this class and if the
     * reference is gone remove the weak reference. Return the first found
     * instance or null if none is found.
     *
     * @param callbackPtr
     * @return the first found instance or null if none is found.
     */
    public static Callback__V__UnionSigval<?> find(MemoryAddress callbackPtr) {
        final ListIterator<WeakReference<Callback__V__UnionSigval<?>>> iter = REFS.listIterator();
        while (iter.hasNext()) {
            final WeakReference<Callback__V__UnionSigval<?>> weak = iter.next();
            final Callback__V__UnionSigval<?> result = weak.get();
            if (result == null) {
                iter.remove();
            } else {
                if (result.memoryAddress.equals(callbackPtr)) {
                    return result;
                }
            }
        }
        return null;
    }

    protected <T extends Callback__V__UnionSigval<A>> Callback__V__UnionSigval(Function<T, MemoryAddress> producer) {
        super(producer);
        callback__V__MA = null;
        REFS.add(new WeakReference<>(this));
    }

    protected Callback__V__UnionSigval(MemoryAddress address) {
        super(address);
        callback__V__MA = null;
        REFS.add(new WeakReference<>(this));
    }

    private Callback__V__UnionSigval(CallChain__V__MA callChain__V__MA) {
        super(callChain__V__MA.toAddress());
        this.callback__V__MA = callChain__V__MA;
        callChain__V__MA.dest = this;
        REFS.add(new WeakReference<>(this));
    }

    public Callback__V__UnionSigval() {
        this(new CallChain__V__MA());
    }

    public void release() {
        callback__V__MA.release();
    }

    /**
     * this will be called from the native code. fields of the union will be
     * laid oud separately. On little endian the int value is in bytes 0 to 3.
     * On big endian the int value is in the bytes 4 to 7 and so not acessable
     * with a int signature.
     *
     */
    protected abstract void callback(MemoryAddress sival_ptr, int sival_int);

}
