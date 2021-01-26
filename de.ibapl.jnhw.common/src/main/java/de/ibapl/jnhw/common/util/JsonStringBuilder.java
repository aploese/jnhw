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
package de.ibapl.jnhw.common.util;

import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.memory.Struct32;
import java.io.IOException;

/**
 *
 * @author aploese
 */
public class JsonStringBuilder {

    @FunctionalInterface
    public interface Appender {
        void appendTo(Appendable sb) throws IOException;
    }

    public void close() throws IOException {
        switch (state) {
            case EMPTY:
                if (compact) {
                    sb.append("{");
                } else {
                    sb.append("{\n").append(INDENT_PREFIX);
                }
            case FILLING:
                if (compact) {
                    sb.append("}");
                } else {
                    sb.append("\n").append(INDENT_PREFIX).append(("}"));
                }
                state = State.CLOSED;
                break;
            default:
                throw new RuntimeException("Unknown state: " + state);
        }
    }

    enum State {
        EMPTY,
        FILLING,
        CLOSED;
    }
    private final Appendable sb;
    private final String INDENT_PREFIX;
    private final String INDENT;
    private final boolean compact;
    private State state = State.EMPTY;

    public JsonStringBuilder(Appendable sb, String indentPrefix, String indent) {
        this.sb = sb;
        this.INDENT = indent;
        this.INDENT_PREFIX = indentPrefix + indent;
        compact = INDENT_PREFIX.length() == 0;
    }

    public JsonStringBuilder(String indentPrefix, String indent) {
        this(new StringBuilder(), indentPrefix, indent);
    }

    private void appendMemberName(String name) throws IOException {
        switch (state) {
            case EMPTY:
                if (compact) {
                    sb.append("{");
                } else {
                    sb.append("{\n").append(INDENT_PREFIX);
                }
                state = State.FILLING;
                break;
            case FILLING:
                if (compact) {
                    sb.append(", ");
                } else {
                    sb.append(",\n").append(INDENT_PREFIX);
                }
                break;
            case CLOSED:
                throw new IllegalStateException("Builder is closed!");
            default:
                throw new RuntimeException("Unknown state: " + state);
        }
        sb.append(name).append(" : ");
    }

    public String toString() {
        if (state != State.CLOSED) {
            try {
                close();
            } catch (IOException ioe) {
                throw new RuntimeException(ioe);
            }
        }
        return sb.toString();
    }

    public void appendAddressMember(String name, long value) throws IOException {
        appendMemberName(name);
        sb.append(JnhwFormater.formatAddress(value));
    }

    public void appendCharMember(String name, char value) throws IOException {
        appendMemberName(name);
        sb.append('"').append(value).append('"');
    }

    public void appendByteMember(String name, byte value) throws IOException {
        appendMemberName(name);
        sb.append(Byte.toString(value));
    }

    public void appendHexByteMember(String name, byte value) throws IOException {
        appendMemberName(name);
        sb.append(String.format("0x%02x", value));
    }

    public void appendShortMember(String name, short value) throws IOException {
        appendMemberName(name);
        sb.append(Short.toString(value));
    }

    public void appendHexShortMember(String name, short value) throws IOException {
        appendMemberName(name);
        sb.append(String.format("0x%04x", value));
    }

    public void appendIntMember(String name, int value) throws IOException {
        appendMemberName(name);
        sb.append(Integer.toString(value));
    }

    public void appendHexIntMember(String name, int value) throws IOException {
        appendMemberName(name);
        sb.append(String.format("0x%08x", value));
    }

    public void appendLongMember(String name, long value) throws IOException {
        appendMemberName(name);
        sb.append(Long.toString(value));
    }

    public void appendHexLongMember(String name, long value) throws IOException {
        appendMemberName(name);
        sb.append(String.format("0x%016x", value));
    }

    public void appendStringMember(String name, String value) throws IOException {
        appendMemberName(name);
        sb.append('\"').append(value).append('\"');
    }

    public void appendNativeAddressHolderMember(String name, NativeAddressHolder value) throws IOException {
        appendMemberName(name);
        sb.append(value.toString());
    }

    public void appendStruct32Member(String name, Struct32 value) throws IOException {
        appendMemberName(name);
        if (value == null) {
            sb.append("null");
        } else {
            value.nativeToString(sb, INDENT_PREFIX, INDENT);
        }
    }

    public void appendMember(String name, String valuePrefix, Appender valueAppender, String valuePostfix) throws IOException {
        appendMemberName(name);
        sb.append(valuePrefix);
        valueAppender.appendTo(sb);
        sb.append(valuePostfix);
    }

    public void appendFunctionPtrMember(String name, NativeFunctionPointer value) throws IOException {
        appendMemberName(name);
        if (value == null) {
            sb.append("null");
        } else {
            value.nativeToString(sb, INDENT_PREFIX, INDENT);
        }
    }

}
