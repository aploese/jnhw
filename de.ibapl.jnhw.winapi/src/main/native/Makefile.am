AM_CPPFLAGS = @JNI_INCLUDE_FLAGS@ -I @JNI_HEADER_DIR@ -I @JNHW_COMMON_SRC_DIR@
AM_CFLAGS = -Wall -Wextra -Wconversion -Werror
AM_LDFLAGS = -z noexecstack -no-undefined -static-libgcc -version-info @JNHW_VERSION_INFO@

LIB_JNHW_WINAPI_NAME=@JNHW_LIB_PREFIX@jnhw-winapi@JNHW_LIBTOOL_LIB_SUFFIX@
LIB_JNHW_WINAPI_RES_NAME=@JNHW_RESOURCES_DIR@/@JNHW_LIB_PREFIX@jnhw-winapi@JNHW_LIB_SUFFIX@

lib_LTLIBRARIES = libjnhw-winapi.la

noinst_LTLIBRARIES = \
 libwinnt.la \
 libbasetsd.la \
 libminwinbase.la \
 libwindef.la \
 libwinbase.la \
 libwinreg.la \
 libwinerror.la \
 libsynchapi.la \
 libfileapi.la \
 libioapiset.la \
 libioapi.la \
 libhandleapi.la \
 liberrhandlingapi.la \
 libprocessenv.la \
 libprocessthreadsapi.la
 
libjnhw_winapi_la_LIBADD = \
 @JNHW_COMMON_SRC_DIR@/libjnhw-common.la \
 libbasetsd.la \
 libminwinbase.la \
 libwindef.la \
 libwinnt.la \
 libwinbase.la \
 libwinreg.la \
 libwinerror.la  \
 libsynchapi.la \
 libfileapi.la \
 libioapiset.la \
 libioapi.la \
 libhandleapi.la \
 liberrhandlingapi.la \
 libprocessenv.la \
 libprocessthreadsapi.la

libjnhw_winapi_la_SOURCES = \
 jnhw-winapi-jni.c

libwinnt_la_SOURCES = \
 WinntDefines.c \
 Winnt_PHANDLE.c \
 Winnt_LPWSTR.c \
 Winnt_ArrayOfHandle.c

libbasetsd_la_SOURCES = \
  BaseTsdDefines.c \
  BaseTsdFunctions.c

libminwinbase_la_SOURCES = \
 MinwinbaseDefines.c \
 Minwinbase_OVERLAPPED.c \
 Minwinbase_SECURITY_ATTRIBUTES.c

libwindef_la_SOURCES = \
 WinDefDefines.c

libwinbase_la_SOURCES = \
 WinbaseDefines.c \
 WinbaseFunctions.c \
 Winbase_COMMTIMEOUTS.c \
 Winbase_COMSTAT.c \
 Winbase_DCB.c

libwinreg_la_SOURCES = \
 WinregDefines.c \
 WinregFunctions.c

libwinerror_la_SOURCES = \
 WinerrorDefines.c
 
libsynchapi_la_SOURCES = \
 SynchapiDefines.c \
 SynchapiFunctions.c

libfileapi_la_SOURCES = \
 FileapiDefines.c \
 FileapiFunctions.c
 
libioapi_la_SOURCES = \
 IoAPIDefines.c \
 IoAPIFunctions.c

libioapiset_la_SOURCES = \
 IoapisetDefines.c \
 IoapisetFunctions.c

libhandleapi_la_SOURCES = \
 HandleapiDefines.c \
 HandleapiFunctions.c

liberrhandlingapi_la_SOURCES = \
 ErrhandlingapiDefines.c \
 ErrhandlingapiFunctions.c

libprocessenv_la_SOURCES = \
 ProcessEnvDefines.c \
 ProcessEnvFunctions.c 

libprocessthreadsapi_la_SOURCES = \
 ProcessthreadsapiDefines.c \
 ProcessthreadsapiFunctions.c 

#hook into make all
all-local: $(LIB_JNHW_WINAPI_RES_NAME)

clean-generic:
	-test -z "$(LIB_JNHW_WINAPI_RES_NAME)" || rm -f $(LIB_JNHW_WINAPI_RES_NAME)
	
install-jnhw-resources: $(LIB_JNHW_WINAPI_RES_NAME)

$(LIB_JNHW_WINAPI_RES_NAME): libjnhw-winapi.la
	$(MKDIR_P) @JNHW_RESOURCES_DIR@
	cp ./.libs/$(LIB_JNHW_WINAPI_NAME) $(LIB_JNHW_WINAPI_RES_NAME)
	$(STRIP) $(JNHW_STRIP_FLAG) $(LIB_JNHW_WINAPI_RES_NAME)
