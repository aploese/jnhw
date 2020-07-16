AM_CPPFLAGS = @JNI_INCLUDE_FLAGS@ -I @JNI_TEST_HEADER_DIR@ -I @JNHW_POSIX_SRC_DIR@ -I @JNHW_COMMON_SRC_DIR@
AM_CFLAGS = -Wall -Wextra -Wconversion -Werror
AM_LDFLAGS = -no-undefined -version-info @JNHW_VERSION_INFO@

LIB_JNHW_POSIX_TEST_NAME=@JNHW_LIB_PREFIX@jnhw-posix-test@JNHW_LIB_SUFFIX@
LIB_JNHW_POSIX_TEST_RES_NAME=@JNHW_TEST_RESOURCES_DIR@/$(LIB_JNHW_POSIX_TEST_NAME)
 
lib_LTLIBRARIES = libjnhw-posix-test.la

noinst_LTLIBRARIES = libtests.la

libjnhw_posix_test_la_LIBADD = libtests.la @JNHW_POSIX_SRC_DIR@/libjnhw-posix.la

libtests_la_SOURCES = \
 LocaleTest.c

#hook into make all
all-local: $(LIB_JNHW_POSIX_TEST_RES_NAME)

install-jnhw-resources: $(LIB_JNHW_POSIX_TEST_RES_NAME)

$(LIB_JNHW_POSIX_TEST_RES_NAME): libjnhw-posix-test.la
	$(MKDIR_P) @JNHW_TEST_RESOURCES_DIR@
	cp ./.libs/$(LIB_JNHW_POSIX_TEST_NAME) $(LIB_JNHW_POSIX_TEST_RES_NAME)
	$(STRIP) $(JNHW_STRIP_FLAG) $(LIB_JNHW_POSIX_TEST_RES_NAME)