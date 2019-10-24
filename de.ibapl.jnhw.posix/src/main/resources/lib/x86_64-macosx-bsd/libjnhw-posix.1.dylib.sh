install_name_tool -id $PWD/libjnhw-posix.1.dylib ./libjnhw-posix.1.dylib
install_name_tool -change /usr/local/lib/libjnhw-common.1.dylib $PWD/libjnhw-common.1.dylib ./libjnhw-posix.1.dylib
