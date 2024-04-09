/**
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2022-2024, Arne Plöse and individual contributors as indicated
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
//for offsetof
#include <stddef.h>
#include <stdint.h>
#include <float.h>


int alignOf_struct_EMPTY() {
    return __alignof__ (struct {
    });
}

int sizeOf_struct_EMPTY() {
    return sizeof (struct {
    });
}


int alignOf_struct_int8_t() {
    return __alignof__ (struct {
        int8_t member;
    });
}

int sizeOf_struct_int8_t() {
    return sizeof (struct {
        int8_t member;
    });
}

int alignOf_struct_int16_t() {
    return __alignof__ (struct {
        int16_t member;
    });
}

int sizeOf_struct_int16_t() {
    return sizeof (struct {
        int16_t member;
    });
}

int alignOf_struct_int32_t() {
    return __alignof__ (struct {
        int32_t member;
    });
}

int sizeOf_struct_int32_t() {
    return sizeof (struct {
        int32_t member;
    });
}

int alignOf_struct_int64_t() {
    return __alignof__ (struct {
        int64_t member;
    });
}

int sizeOf_struct_int64_t() {
    return sizeof (struct {
        int64_t member;
    });
}

int alignOf_struct_intptr_t() {
    return __alignof__ (struct {
        intptr_t member;
    });
}

int sizeOf_struct_intptr_t() {
    return sizeof (struct {
        intptr_t member;
    });
}

int alignOf_struct_pointer() {
    return __alignof__ (struct {
        void* member;
    });
}

int sizeOf_struct_pointer() {
    return sizeof (struct {
        void* member;
    });
}

int alignOf_struct_int() {
    return __alignof__ (struct {
        int member;
    });
}

int sizeOf_struct_int() {
    return sizeof (struct {
        int member;
    });
}

int alignOf_struct_long() {
    return __alignof__ (struct {
        long member;
    });
}

int sizeOf_struct_long() {
    return sizeof (struct {
        long member;
    });
}

int alignOf_struct_long_long() {
    return __alignof__ (struct {
        long long member;
    });
}

int sizeOf_struct_long_long() {
    return sizeof (struct {
        long long member;
    });
}

int alignOf_struct_float() {
    return __alignof__ (struct {
        float member;
    });
}

int sizeOf_struct_float() {
    return sizeof (struct {
        float member;
    });
}

int alignOf_struct_double() {
    return __alignof__ (struct {
        double member;
    });

}

int sizeOf_struct_double() {
    return sizeof (struct {
        double member;
    });

}

int alignOf_struct_long_double() {
    return __alignof__ (struct {
        long double member;
    });
}

int sizeOf_struct_long_double() {
    return sizeof (struct {
        long double member;
    });
}

struct s_i8 {
    int8_t _0_i8;
};

struct s_3xi8 {
    int8_t _0_i8;
    int8_t _1_i8;
    int8_t _2_i8;
};

struct s_2xsi8 {
    struct s_i8 _0_si8;
    struct s_i8 _1_si8;
};

struct s_si8_s3xi8 {
    struct s_i8 _0_si8;
    struct s_3xi8 _1_s3xi8;
};

struct s_s3xi8_si8 {
    struct s_3xi8 _0_s3xi8;
    struct s_i8 _1_si8;
};

int sizeOf_s_i8() {
    return sizeof (struct s_i8);
}

int sizeOf_s_s2xi8() {
    return sizeof (struct s_2xsi8);
}

int sizeOf_s_3xi8() {
    return sizeof (struct s_3xi8);
}

int sizeOf_s_si8_s3xi8() {
    return sizeof (struct s_si8_s3xi8);
}

int sizeOf_s_s3xi8_si8() {
    return sizeof (struct s_s3xi8_si8);
}

int offsetOf_s_s2xi8__1_si8() {
    return offsetof(struct s_2xsi8, _1_si8);
}

int offsetOf_s_si8_s3xi8__1_s3xi8() {
    return offsetof(struct s_si8_s3xi8, _1_s3xi8);
}

int offsetOf_s_s3xi8_si8__1_si8() {
    return offsetof(struct s_s3xi8_si8, _1_si8);
}