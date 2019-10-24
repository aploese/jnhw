install_name_tool -id $PWD/libjnhw.1.dylib ./libjnhw.1.dylib
install_name_tool -change /usr/local/lib/libjnhw-common.1.dylib $PWD/libjnhw-common.1.dylib ./libjnhw.1.dylib
