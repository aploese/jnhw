install_name_tool -id $PWD/libjnhw-winapi.3.dylib ./libjnhw-winapi.3.dylib
install_name_tool -change /usr/local/lib/libjnhw-common.3.dylib $PWD/libjnhw-common.3.dylib ./libjnhw-winapi.3.dylib
