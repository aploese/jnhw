# Java Native Header Wrapper (JNHW)

JNI Header Wrapper a lightweight alternative to JNA or JNR
and a helper to resolve a native lib by name and libtool version.

Unlike JNR 
* all macro constants be natively resolved.
* all structures will be natively allocated and its filed natively accessed. [see: StructTermios in Termios.java](./de.ibapl.jnhw.posix/src/main/java/de/ibapl/jnhw/posix/Termios.java) and the jni bindings [Termios_Termios.c](de.ibapl.jnhw.posix/src/main/native/Termios_Termios.c) and [TermiosDefines.c](de.ibapl.jnhw.posix/src/main/native/TermiosDefines.c) and [TermiosFunctions.c](de.ibapl.jnhw.posix/src/main/native/TermiosFunctions.c) . Struct termios varies over the OS and even on Linux on different architectures like (i.e. mips is different from the rest).  

Add this dependency for POSIX.

```
<dependency>
    <groupId>de.ibapl.jnhw</groupId>
    <artifactId>de.ibapl.jnhw.posix</artifactId>
    <version>1.0.0</version>
</dependency>
```
and this for the Windows API

```
<dependency>
    <groupId>de.ibapl.jnhw</groupId>
    <artifactId>de.ibapl.jnhw.posix</artifactId>
    <version>1.0.0</version>
</dependency>
```
# Usage

# Demos
## Hello World
See [subdirectory it/hello-world/](./it/hello-world).
run `mvn exec:java -Dexec.mainClass="de.ibapl.jnhw.it.hello_world.App"` in `it/hello_world`.

### POSIX

Import Unistd in a static manner so the code may become less noisy.

```java

import de.ibapl.jnhw.NativeErrorException;
//Import only the needed define from the wrapper of posix's unistd.h.h
import static de.ibapl.jnhw.posix.Unistd.STDOUT_FILENO;
//Import only the needed method from the wrapper of iso c's unistd.h.h
import static de.ibapl.jnhw.isoc.Unistd.write;

public class Posix {

	public static void sayHello() throws NativeErrorException {
		write(STDOUT_FILENO(), "Hello World! from POSIX".getBytes());
	}

}
```

### Windows API

Import  in a static manner `import static de.ibapl.jnhw.posix.Unistd;` so the code may become less noisy.

```java
import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.NativeErrorException;
//Import only the needed define from the wrapper of processenv.h
import static de.ibapl.jnhw.winapi.ProcessEnv.STD_OUTPUT_HANDLE;
//Import only the needed method from the wrapper of processenv.h
import static de.ibapl.jnhw.winapi.ProcessEnv.GetStdHandle;
//Import only the needed method from the wrapper of fileapi.h
import static de.ibapl.jnhw.winapi.Fileapi.WriteFile;

public class Windows {

	public static void sayHello() throws NativeErrorException {
		final IntRef iRef = new IntRef();
		final byte[] data = "Hello World! from WIN API".getBytes();
		WriteFile(GetStdHandle(STD_OUTPUT_HANDLE()), data, 0, data.length, iRef);
	}

}
```
