install_name_tool -id $PWD/libjnhw.0.dylib ./libjnhw.0.dylib
install_name_tool -change /usr/local/lib/libjnhw-common.0.dylib $PWD/libjnhw-common.0.dylib ./libjnhw.0.dylib