AM_CPPFLAGS = 
AM_CFLAGS = -Wall -Wextra -Wconversion -Werror
AM_LDFLAGS = -z noexecstack -no-undefined -version-info @JNHW_VERSION_INFO@

LIB_JNHW_COMMON_TEST_NAME=@JNHW_LIB_PREFIX@jnhw-common-test@JNHW_LIBTOOL_LIB_SUFFIX@
LIB_JNHW_COMMON_TEST_RES_NAME=@JNHW_TEST_RESOURCES_DIR@/@JNHW_LIB_PREFIX@jnhw-common-test@JNHW_LIB_SUFFIX@

lib_LTLIBRARIES = libjnhw-common-test.la

noinst_LTLIBRARIES = libtests.la

libjnhw_common_test_la_LIBADD = libtests.la

libtests_la_SOURCES = \
 Callback__V__MA_Test.c \
 Callback__V___I_Test.c \
 Callback__V___I_MA_MA_Test.c \
 Callback__V___I__I_MA_Test.c \
 Callback__V___L_Test.c \
 Callback__V__Union_I_MA_Test.c \
 SizeAndAlignmentOfBaseDataTypes.c \
 StructLayoutFactoryImplTest.c \
 Struct__s_i8_i16.c \
 Struct__s_i8_i32.c \
 Struct__s_i8_i64.c \
 TestStructures.c

#hook into make all
all-local: $(LIB_JNHW_COMMON_TEST_RES_NAME)

clean-generic:
	-test -z "$(LIB_JNHW_COMMON_TEST_RES_NAME)" || rm -f $(LIB_JNHW_COMMON_TEST_RES_NAME)

install-jnhw-resources: $(LIB_JNHW_COMMON_TEST_RES_NAME)

$(LIB_JNHW_COMMON_TEST_RES_NAME): libjnhw-common-test.la
	$(MKDIR_P) @JNHW_TEST_RESOURCES_DIR@
	cp ./.libs/$(LIB_JNHW_COMMON_TEST_NAME) $(LIB_JNHW_COMMON_TEST_RES_NAME)
	$(STRIP) $(JNHW_STRIP_FLAG) $(LIB_JNHW_COMMON_TEST_RES_NAME)
