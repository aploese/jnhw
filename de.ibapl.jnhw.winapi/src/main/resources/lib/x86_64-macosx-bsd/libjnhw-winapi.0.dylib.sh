install_name_tool -id $PWD/libjnhw-winapi.0.dylib ./libjnhw-winapi.0.dylib
install_name_tool -change /usr/local/lib/libjnhw-common.0.dylib $PWD/libjnhw-common.0.dylib ./libjnhw-winapi.0.dylib
