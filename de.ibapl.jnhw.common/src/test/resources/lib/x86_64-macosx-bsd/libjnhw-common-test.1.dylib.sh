#fix the path so otool -L shoud point to this dir afterwards
install_name_tool -id $PWD/libjnhw-common-test.1.dylib ./libjnhw-common-test.1.dylib
install_name_tool -change /usr/local/lib/libjnhw-common.1.dylib $PWD/libjnhw-common.1.dylib ./libjnhw-common-test.1.dylib
