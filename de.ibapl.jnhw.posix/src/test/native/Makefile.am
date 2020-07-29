AM_CPPFLAGS = @JNI_INCLUDE_FLAGS@ -I @JNI_TEST_HEADER_DIR@ -I @JNHW_POSIX_SRC_DIR@ -I @JNHW_COMMON_SRC_DIR@
AM_CFLAGS = @CFLAGS@ @PTHREAD_CFLAGS@ -Wall -Wextra -Wconversion -Werror
AM_LDFLAGS = -z noexecstack -no-undefined -version-info @JNHW_VERSION_INFO@
AM_LIBS = @PTHREAD_LIBS@ @LIBS@
AM_CC = @PTHREAD_CC@

LIB_JNHW_POSIX_TEST_NAME=@JNHW_LIB_PREFIX@jnhw-posix-test@JNHW_LIBTOOL_LIB_SUFFIX@
LIB_JNHW_POSIX_TEST_RES_NAME=@JNHW_TEST_RESOURCES_DIR@/@JNHW_LIB_PREFIX@jnhw-posix-test@JNHW_LIB_SUFFIX@
 
lib_LTLIBRARIES = libjnhw-posix-test.la

noinst_LTLIBRARIES = libtests.la

libjnhw_posix_test_la_LIBADD = \
libtests.la \
@JNHW_POSIX_SRC_DIR@/libjnhw-posix.la \
@JNHW_COMMON_SRC_DIR@/libjnhw-common.la


libtests_la_SOURCES = \
 LocaleTest.c

#hook into make all
all-local: $(LIB_JNHW_POSIX_TEST_RES_NAME)

clean-generic:
	-test -z "$(LIB_JNHW_POSIX_TEST_RES_NAME)" || rm -f $(LIB_JNHW_POSIX_TEST_RES_NAME)

install-jnhw-resources: $(LIB_JNHW_POSIX_TEST_RES_NAME)

$(LIB_JNHW_POSIX_TEST_RES_NAME): libjnhw-posix-test.la
	$(MKDIR_P) @JNHW_TEST_RESOURCES_DIR@
	cp ./.libs/$(LIB_JNHW_POSIX_TEST_NAME) $(LIB_JNHW_POSIX_TEST_RES_NAME)
	$(STRIP) $(JNHW_STRIP_FLAG) $(LIB_JNHW_POSIX_TEST_RES_NAME)
