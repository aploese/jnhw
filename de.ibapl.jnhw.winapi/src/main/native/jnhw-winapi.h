#include "../../../config.h"
#include <jnhw.h>

//TODO move this definition to the Makefile???
#ifdef HAVE_WINDOWS_H

// For cross compiling set the version to Win10
#ifdef _WIN32_WINNT
#undef _WIN32_WINNT
#endif

#define _WIN32_WINNT _WIN32_WINNT_WIN10
#include <windows.h>
#endif

#ifdef __cplusplus
extern "C" {
#endif

#ifdef __cplusplus
}
#endif
