install_name_tool -id $PWD/libjnhw-posix-test.3.dylib ./libjnhw-posix-test.3.dylib
install_name_tool -change /usr/local/lib/libjnhw-common.3.dylib $PWD/libjnhw-common.3.dylib ./libjnhw-posix-test.3.dylib
install_name_tool -change /usr/local/lib/libjnhw-posix.3.dylib $PWD/libjnhw-posix.3.dylib ./libjnhw-posix-test.3.dylib
