# Java Native Header Wrapper (JNHW)

JNI Header Wrapper a lightweight alternative to JNA or JNR
and a helper to resolve a native lib by name and libtool version.

Unlike JNR or JNA
* all macro constants are natively resolved.
* all structures will be natively allocated and its filed natively accessed. [StructTermios in Termios.java](./de.ibapl.jnhw.posix/src/main/java/de/ibapl/jnhw/posix/Termios.java) and the jni bindings [Termios_Termios.c](de.ibapl.jnhw.posix/src/main/native/Termios_Termios.c) and [TermiosDefines.c](de.ibapl.jnhw.posix/src/main/native/TermiosDefines.c) and [TermiosFunctions.c](de.ibapl.jnhw.posix/src/main/native/TermiosFunctions.c) . Struct termios varies over the OS and even on Linux on different architectures like (i.e. mips is different from the rest).
* different sizes, alignments and offset of struct members are handled natively like stuct mcontext_t [Tests testAlignOfMcontext_t testSizeOfMcontext_t in SignalTest.java](./de.ibapl.jnhw.posix/src/test/java/de/ibapl/jnhw/posix/SignalTest.java).
  Examples for [struct and union](./it/fun-with-memory-and-function-pointers/src/main/java/de/ibapl/jnhw/it/fun_with_memory_and_function_pointers/Struct.java)
  and [function pointer](./it/fun-with-memory-and-function-pointers/src/main/java/de/ibapl/jnhw/it/fun_with_memory_and_function_pointers/FunctionPointer.java) are in teh exaples modules.
* it does not use sun.misc.Unsafe but allocate the memory by itself.
* callbacks from and calls of native functions are supported [Callback_I_V_Impl.java](de.ibapl.jnhw.common/src/main/java/de/ibapl/jnhw/common/callback/Callback_I_V_Impl.java),
  and its counterpart [CallNative_J_V.java](de.ibapl.jnhw.common/src/main/java/de/ibapl/jnhw/common/nativecall/CallNative_J_V.java),
  and their common ancestor [FunctionPtr_I_V.java](de.ibapl.jnhw.common/src/main/java/de/ibapl/jnhw/common/nativepointer/FunctionPtr_I_V.java).

A running "real life" comparison can be found here: [JNHW-Example: Compare JNHW, JNR, JNA](./it/jnhw-jna-jnr/src/main/java/de/ibapl/jnhw/it/jnhw_jna_jnr/).

Add this dependency for POSIX.

```
<dependency>
    <groupId>de.ibapl.jnhw</groupId>
    <artifactId>de.ibapl.jnhw.posix</artifactId>
    <version>[3.0.0,4.0.0)</version>
</dependency>
```
and this for the Windows API

```
<dependency>
    <groupId>de.ibapl.jnhw</groupId>
    <artifactId>de.ibapl.jnhw.winapi</artifactId>
    <version>[3.0.0,4.0.0)</version>
</dependency>
```
# Usage

# Error Handling

If an native error occured and the called function flags an error condition to the caller. One calls for ISO C errno and for the windows API GetLastError(). this is done in the jni wrapper which throws the checked exception [NativeErrorException](./de.ibapl.jnhw.common/src/main/java/de/ibapl/jnhw/NativeErrorException.java) in that case.

# State

## Branch master

| Test Platform         | VM version | Hotspot VM (Java Foreign)  | Zero VM (Java Foreign)     | Hotspot VM (JNI)           | Zero VM (JNI)              |
| :-------------------- | :--------- | :------------------------: | :------------------------: | :------------------------: | :------------------------: |
| aarch64-freebsd-bsd   | 23         | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 |
| aarch64-linux-gnu     | 23.0.2     | success         2025-02-26 | no JFF          2025-02-26 | not included by default    | not included by default    |
| aarch64-netbsd-bsd    | 23         | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 |
| aarch64-openbsd-bsd   | 23         | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 |
| arm-freebsd-bsd       | 23         | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 |
| arm-linux-gnueabihf   | 23.0.2     | no Server VM    2025-02-26 | success         2025-02-26 | not included by default    | not included by default    |
| arm-netbsd-bsd        | 23         | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 |
| arm-openbsd-bsd       | 23         | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 |
| i386-freebsd-bsd      | 23         | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 |
| i386-linux-gnu        | 23.0.2     | no Server VM    2025-02-26 | success         2025-02-26 | not included by default    | not included by default    |
| i386-netbsd-bsd       | 23         | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 |
| i386-openbsd-bsd      | 23         | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 |
| mips64el-linux-gnu    | 23.0.2     | success         2025-02-24 | Test Garbage    2025-02-24 | not included by default    | not included by default    |
| powerpc-linux-gnu     | 23.0.2     | no Server VM    2025-02-26 | JFF is broken   2025-02-26 | not included by default    | not included by default    |
| powerpc64le-linux-gnu | 23.0.2     | success         2025-02-26 | no JFF          2025-02-26 | not included by default    | not included by default    |
| riscv64-linux-gnu     | 23.0.2     | success         2025-02-26 | no JFF          2025-02-26 | not included by default    | not included by default    |
| s390x-linux-gnu       | 23.0.2     | success         2025-02-26 | no JFF          2025-02-26 | not included by default    | not included by default    |
| x86_64-apple-darwin   | 23.0.2     | success         2025-03-11 | n.a.            2025-03-11 | success         2025-03-11 | n.a.            2025-03-11 |
| x86_64-freebsd-bsd    | 23         | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 |
| x86_64-linux-gnu      | 23.0.2     | success         2025-02-26 | no JFF          2025-02-26 | not included by default    | not included by default    |
| x86_64-netbsd-bsd     | 23         | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 |
| x86_64-openbsd-bsd    | 23         | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 | no OpenJDK23    2025-02-17 |
| x86_64-windows-pe32+  | 19.0.1     | success         2023-01-26 | n.a.            2023-01-27 | not included by default    | not included by default    |

n.a. ... the feature are not available.

# Demos
## Hello World
See [subdirectory it/hello-world/](./it/hello-world).
run `mvn exec:java -Dexec.mainClass="de.ibapl.jnhw.it.hello_world.App"` in `it/hello_world`.

### POSIX

Import Unistd in a static manner so the code may become less noisy.

```java
package de.ibapl.jnhw.it.hello_world;

import de.ibapl.jnhw.NativeErrorException;
//Import only the needed define from the wrapper of posix's unistd.h.h
import static de.ibapl.jnhw.posix.Unistd.STDOUT_FILENO;
//Import only the needed method from the wrapper of iso c's unistd.h.h
import static de.ibapl.jnhw.posix.Unistd.write;

public class Posix {

	public static void sayHello() throws NativeErrorException {
		int bytesWritten = write(STDOUT_FILENO, "Hello World! from POSIX\n".getBytes());
                System.out.println("Bytes written: " + bytesWritten);
	}

}
```

### Windows API

```java
package de.ibapl.jnhw.it.hello_world;

import de.ibapl.jnhw.NativeErrorException;
//Import only the needed define from the wrapper of processenv.h
import static de.ibapl.jnhw.winapi.Winbase.STD_OUTPUT_HANDLE;
//Import only the needed method from the wrapper of processenv.h
import static de.ibapl.jnhw.winapi.ProcessEnv.GetStdHandle;
//Import only the needed method from the wrapper of fileapi.h
import static de.ibapl.jnhw.winapi.Fileapi.WriteFile;

public class Windows {

	public static void sayHello() throws NativeErrorException {
		int bytesWritten = WriteFile(GetStdHandle(STD_OUTPUT_HANDLE), "Hello World! from WIN API\n".getBytes());
                System.out.println("Bytes written: " + bytesWritten);
	}

}
```

create a file named test.c and include the needed headers.
run
```sh
gcc  -dD -dI -E test.c  | less
```
to see the preprocessed defines
