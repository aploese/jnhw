AM_CPPFLAGS = @JNI_INCLUDE_FLAGS@ -I @JNI_TEST_HEADER_DIR@ -I @JNHW_COMMON_SRC_DIR@
AM_CFLAGS = -Wall -Wextra -Wconversion -Werror
AM_LDFLAGS = -z noexecstack -no-undefined -version-info @JNHW_VERSION_INFO@

LIB_JNHW_COMMON_TEST_NAME=@JNHW_LIB_PREFIX@jnhw-common-test@JNHW_LIBTOOL_LIB_SUFFIX@
LIB_JNHW_COMMON_TEST_RES_NAME=@JNHW_TEST_RESOURCES_DIR@/@JNHW_LIB_PREFIX@jnhw-common-test@JNHW_LIB_SUFFIX@
 
lib_LTLIBRARIES = libjnhw-common-test.la

noinst_LTLIBRARIES = libtests.la

libjnhw_common_test_la_LIBADD = libtests.la @JNHW_COMMON_SRC_DIR@/libjnhw-common.la

libtests_la_SOURCES = \
 ByteRefTests.c \
 ShortRefTests.c \
 IntRefTests.c \
 LongRefTests.c \
 ObjectRefTests.c \
 Callback_I_V_Tests.c \
 Callback_J_V_Tests.c \
 Callback_IJ_V_Tests.c \
 Callback_I_I_PtrOpaqueMemory_V_Tests.c \
 Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V_Tests.c \
 Callback_PtrOpaqueMemory_V_Tests.c \
 NativeRunnableTests.c \
 PointerArray_Tests.c \
 JnhwExceptionsTest.c

#hook into make all
all-local: $(LIB_JNHW_COMMON_TEST_RES_NAME)

clean-generic:
	-test -z "$(LIB_JNHW_COMMON_TEST_RES_NAME)" || rm -f $(LIB_JNHW_COMMON_TEST_RES_NAME)

install-jnhw-resources: $(LIB_JNHW_COMMON_TEST_RES_NAME)

$(LIB_JNHW_COMMON_TEST_RES_NAME): libjnhw-common-test.la
	$(MKDIR_P) @JNHW_TEST_RESOURCES_DIR@
	cp ./.libs/$(LIB_JNHW_COMMON_TEST_NAME) $(LIB_JNHW_COMMON_TEST_RES_NAME)
	$(STRIP) $(JNHW_STRIP_FLAG) $(LIB_JNHW_COMMON_TEST_RES_NAME)
