#fix the path so otool -L shoud point to this dir afterwards
install_name_tool -id $PWD/libjnhw-common-test.3.dylib ./libjnhw-common-test.3.dylib
install_name_tool -change /usr/local/lib/libjnhw-common.3.dylib $PWD/libjnhw-common.3.dylib ./libjnhw-common-test.3.dylib
