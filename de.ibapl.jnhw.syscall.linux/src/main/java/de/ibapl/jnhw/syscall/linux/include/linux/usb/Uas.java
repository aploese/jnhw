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
 /* SPDX-License-Identifier: GPL-2.0 */
package de.ibapl.jnhw.syscall.linux.include.linux.usb;

import de.ibapl.jnhw.common.annotation.Packed;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import de.ibapl.jnhw.syscall.linux.include.uapi.linux.usb.AbstractDescriptor;
import de.ibapl.jnhw.syscall.linux.uapi.asm_generic.Types.__be16;
import de.ibapl.jnhw.syscall.linux.uapi.asm_generic.Types.__u8;
import de.ibapl.jnhw.syscall.linux.uapi.asm_generic.Types.__le16;
import java.io.IOException;

/**
 *
 * @author aploese
 */
public class Uas {

    /* Common header for all IUs */
    @Packed
    public abstract static class Iu {

        @__u8
        byte iu_id;
        @__u8
        byte rsvd1;
        @__be16
        short tag;
    };

    public final static byte IU_ID_COMMAND = 0x01;
    public final static byte IU_ID_STATUS = 0x03;
    public final static byte IU_ID_RESPONSE = 0x04;
    public final static byte IU_ID_TASK_MGMT = 0x05;
    public final static byte IU_ID_READ_READY = 0x06;
    public final static byte IU_ID_WRITE_READY = 0x07;

    public final static byte TMF_ABORT_TASK = 0x01;
    public final static byte TMF_ABORT_TASK_SET = 0x02;
    public final static byte TMF_CLEAR_TASK_SET = 0x04;
    public final static byte TMF_LOGICAL_UNIT_RESET = 0x08;
    public final static byte TMF_I_T_NEXUS_RESET = 0x10;
    public final static byte TMF_CLEAR_ACA = 0x40;
    public final static byte TMF_QUERY_TASK = (byte) 0x80;
    public final static byte TMF_QUERY_TASK_SET = (byte) 0x81;
    public final static byte TMF_QUERY_ASYNC_EVENT = (byte) 0x82;

    public final static byte RC_TMF_COMPLETE = 0x00;
    public final static byte RC_INVALID_INFO_UNIT = 0x02;
    public final static byte RC_TMF_NOT_SUPPORTED = 0x04;
    public final static byte RC_TMF_FAILED = 0x05;
    public final static byte RC_TMF_SUCCEEDED = 0x08;
    public final static byte RC_INCORRECT_LUN = 0x09;
    public final static byte RC_OVERLAPPED_TAG = 0x0a;

    @Packed
    public abstract class Command_iu {

        @__u8
        byte iu_id;
        @__u8
        byte rsvd1;
        @__be16
        short tag;
        @__u8
        byte prio_attr;
        @__u8
        byte rsvd5;
        @__u8
        byte len;
        @__u8
        byte rsvd7;
        //TODO      Scsi_lun lun ;
        @__u8
        byte[] cdb;//[16];	/* XXX: Overflow-checking tools may misunderstand */
    }

    @Packed
    public abstract static class Task_mgmt_iu {

        @__u8
        byte iu_id;
        @__u8
        byte rsvd1;
        @__be16
        short tag;
        @__u8
        byte function;
        @__u8
        byte rsvd2;
        @__be16
        short task_tag;
//TODO        Scsi_lun lun ;
    }

    /*
 * Also used for the Read Ready and Write Ready IUs since they have the
 * same first four bytes
     */
    @Packed
    public abstract static class Sense_iu {

        @__u8
        byte iu_id;
        @__u8
        byte rsvd1;
        @__be16
        short tag;
        @__be16
        short status_qual;
        @__u8
        byte status;
        @__u8
        byte[] rsvd7; //[7];
        @__be16
        short len;
        @__u8
        byte[] sense; //[SCSI_SENSE_BUFFERSIZE];
    }

    @Packed
    public abstract static class Response_iu {

        @__u8
        byte iu_id;
        @__u8
        byte rsvd1;
        @__be16
        short tag;
        @__u8
        byte[] add_response_info; //[3];
        @__u8
        byte response_code;
    }

    @Packed
    public static class Usb_pipe_usage_descriptor extends AbstractDescriptor {

        public final static class Layout extends AbstractDescriptor.Layout {

            public final static byte bPipeID = _sizeof;
            public final static byte Reserved = bPipeID + __U8;

            public final static byte sizeof = Reserved + __U8; //TODO ERROR? a descriptor has USB_DT_PIPE_USAGE with blength == 5 ???
        }

        public Usb_pipe_usage_descriptor(AbstractNativeMemory parent, long offset, SetMem setMem) {
            super(parent, offset, Layout.sizeof, setMem);
        }

        public Usb_pipe_usage_descriptor(AbstractNativeMemory parent, long offset, int sizeInBytes, SetMem setMem) {
            super(parent, offset, sizeInBytes, setMem);
            if (sizeInBytes < Layout.sizeof) {
                throw new IllegalArgumentException("sizeInBytes too small");
            }
        }

        @__u8
        public byte bPipeID() {
            return ACCESSOR___U8.__u8(this, Layout.bPipeID);
        }

        @__u8
        public byte Reserved() {
            return ACCESSOR___U8.__u8(this, Layout.Reserved);
        }

        @Override
        protected void nativeToString(JsonStringBuilder jsb, String indentPrefix, String indent) throws IOException {
            jsb.appendByteMember("bPipeID", bPipeID());
            jsb.appendByteMember("Reserved", Reserved());
        }

    }

    public final static byte CMD_PIPE_ID = 1;
    public final static byte STATUS_PIPE_ID = 2;
    public final static byte DATA_IN_PIPE_ID = 3;
    public final static byte DATA_OUT_PIPE_ID = 4;
    public final static byte UAS_SIMPLE_TAG = 0;
    public final static byte UAS_HEAD_TAG = 1;
    public final static byte UAS_ORDERED_TAG = 2;
    public final static byte UAS_ACA = 4;

}
