install_name_tool -id $PWD/libjnhw-winapi.1.dylib ./libjnhw-winapi.1.dylib
install_name_tool -change /usr/local/lib/libjnhw-common.1.dylib $PWD/libjnhw-common.1.dylib ./libjnhw-winapi.1.dylib
