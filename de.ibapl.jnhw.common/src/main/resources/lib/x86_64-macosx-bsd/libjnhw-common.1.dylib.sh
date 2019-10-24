#fix the path so otool -L shoud point to this dir afterwards
install_name_tool -id $PWD/libjnhw-common.1.dylib ./libjnhw-common.1.dylib
