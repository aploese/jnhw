package de.ibapl.jnhw.isoc;

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.LibJnhwLoader;
import de.ibapl.jnhw.NotDefinedException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

@Include("#include <errno.h>")
public final class Errno extends LibJnhwLoader {

    private Errno() {

    }

    /**
     * Operation not permitted.
     */
    @Define
    public final static native int EPERM();

    /**
     * No such file or directory.
     */
    @Define
    public final static native int ENOENT();

    /**
     * No such process.
     */
    @Define
    public final static native int ESRCH();

    /**
     * Interrupted function.
     */
    @Define
    public final static native int EINTR();

    /**
     * I/O error.
     */
    @Define
    public final static native int EIO();

    /**
     * No such device or address.
     */
    @Define
    public final static native int ENXIO();

    /**
     * Argument list too long.
     */
    @Define
    public final static native int E2BIG();

    /**
     * Executable file format error.
     */
    @Define
    public final static native int ENOEXEC();

    /**
     * Bad file descriptor.
     */
    @Define
    public final static native int EBADF();

    /**
     * No child processes.
     */
    @Define
    public final static native int ECHILD();

    /**
     * Resource unavailable, try again (may be the same value as [EWOULDBLOCK]).
     */
    @Define
    public final static native int EAGAIN();

    /**
     * Not enough space.
     */
    @Define
    public final static native int ENOMEM();

    /**
     * Permission denied.
     */
    @Define
    public final static native int EACCES();

    /**
     * Bad address.
     */
    @Define
    public final static native int EFAULT();

    @Define
    public final static native int ENOTBLK();

    /**
     * Device or resource busy.
     */
    @Define
    public final static native int EBUSY();

    /**
     * File exists.
     */
    @Define
    public final static native int EEXIST();

    /**
     * Cross-device link.
     */
    @Define
    public final static native int EXDEV();

    /**
     * No such device.
     */
    @Define
    public final static native int ENODEV();

    /**
     * Not a directory or a symbolic link to a directory.
     */
    @Define
    public final static native int ENOTDIR();

    /**
     * Is a directory.
     */
    @Define
    public final static native int EISDIR();

    /**
     * Invalid argument.
     */
    @Define
    public final static native int EINVAL();

    /**
     * Too many files open in system.
     */
    @Define
    public final static native int ENFILE();

    /**
     * File descriptor value too large.
     */
    @Define
    public final static native int EMFILE();

    /**
     * Inappropriate I/O control operation.
     */
    @Define
    public final static native int ENOTTY();

    /**
     * Text file busy.
     */
    @Define
    public final static native int ETXTBSY();

    /**
     * File too large.
     */
    @Define
    public final static native int EFBIG();

    /**
     * No space left on device.
     */
    @Define
    public final static native int ENOSPC();

    /**
     * Invalid seek.
     */
    @Define
    public final static native int ESPIPE();

    /**
     * Read-only file system.
     */
    @Define
    public final static native int EROFS();

    /**
     * Too many links.
     */
    @Define
    public final static native int EMLINK();

    /**
     * Broken pipe.
     */
    @Define
    public final static native int EPIPE();

    /**
     * Mathematics argument out of domain of function.
     */
    @Define
    public final static native int EDOM();

    /**
     * Result too large.
     */
    @Define
    public final static native int ERANGE();

    /**
     * Resource deadlock would occur.
     */
    @Define
    public final static native int EDEADLK();

    /**
     * Filename too long.
     */
    @Define
    public final static native int ENAMETOOLONG();

    /**
     * No locks available.
     */
    @Define
    public final static native int ENOLCK();

    /**
     * Functionality not supported.
     */
    @Define
    public final static native int ENOSYS();

    /**
     * Directory not empty.
     */
    @Define
    public final static native int ENOTEMPTY();

    /**
     * Too many levels of symbolic links.
     */
    @Define
    public final static native int ELOOP();

    /**
     * Operation would block (may be the same value as [@see EAGAIN]).
     */
    @Define
    public final static native int EWOULDBLOCK();

    /**
     * No message of the desired type.
     */
    @Define
    public final static native int ENOMSG();

    /**
     * Identifier removed.
     */
    @Define
    public final static native int EIDRM();

    //LINUX()
    @Define
    public final static native int ECHRNG() throws NotDefinedException;

    //LINUX()
    @Define
    public final static native int EL2NSYNC() throws NotDefinedException;

    //LINUX()
    @Define
    public final static native int EL3HLT() throws NotDefinedException;

    //LINUX()
    @Define
    public final static native int EL3RST() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int ELNRNG() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int EUNATCH() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int ENOCSI() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int EL2HLT() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int EBADE() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int EBADR() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int EXFULL() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int ENOANO() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int EBADRQC() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int EBADSLT() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int EDEADLOCK() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int EBFONT() throws NotDefinedException;

    /**
     * Not a STREAM.
     */
    //POSIX(POSIX.Marker.XSI)
    @Define
    public final static native int ENOSTR() throws NotDefinedException;

    /**
     * No message is available on the STREAM head read queue.
     */
    //POSIX(POSIX.Marker.XSI)
    @Define
    public final static native int ENODATA() throws NotDefinedException;

    /**
     * Stream @see ioctl_H.ioctl() timeout.
     */
    @Define
    public final static native int ETIME() throws NotDefinedException;

    /**
     * No STREAM resources.
     */
    //POSIX(POSIX.Marker.XSI)
    @Define
    public final static native int ENOSR() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int ENONET() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int ENOPKG() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int EREMOTE();

    /**
     * Reserved.
     */
    @Define
    public final static native int ENOLINK();

    @Define
    public final static native int EADV() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int ESRMNT() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int ECOMM() throws NotDefinedException;

    /**
     * Protocol error.
     */
    @Define
    public final static native int EPROTO();

    /**
     * Reserved.
     */
    @Define
    public final static native int EMULTIHOP();

    //LINUX
    @Define
    public final static native int EDOTDOT() throws NotDefinedException;

    /**
     * Bad message.
     */
    @Define
    public final static native int EBADMSG();

    /**
     * Value too large to be stored in data type.
     */
    @Define
    public final static native int EOVERFLOW();

    //LINUX
    @Define
    public final static native int ENOTUNIQ() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int EBADFD() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int EREMCHG() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int ELIBACC() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int ELIBBAD() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int ELIBSCN() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int ELIBMAX() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int ELIBEXEC() throws NotDefinedException;

    /**
     * Illegal byte sequence.
     */
    @Define
    public final static native int EILSEQ();

    //LINUX
    @Define
    public final static native int ERESTART() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int ESTRPIPE() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int EUSERS();

    /**
     * Not a socket.
     */
    @Define
    public final static native int ENOTSOCK();

    /**
     * Destination address required.
     */
    @Define
    public final static native int EDESTADDRREQ();

    /**
     * Message too large.
     */
    @Define
    public final static native int EMSGSIZE();

    /**
     * Protocol wrong type for socket.
     */
    @Define
    public final static native int EPROTOTYPE();

    /**
     * Protocol not available.
     */
    @Define
    public final static native int ENOPROTOOPT();

    /**
     * Protocol not supported.
     */
    @Define
    public final static native int EPROTONOSUPPORT();

    //LINUX
    @Define
    public final static native int ESOCKTNOSUPPORT();

    /**
     * Operation not supported on socket (may be the same value as [@see
     * ENOTSUP]).
     */
    @Define
    public final static native int EOPNOTSUPP();

    //LINUX
    @Define
    public final static native int EPFNOSUPPORT();

    /**
     * Address family not supported.
     */
    @Define
    public final static native int EAFNOSUPPORT();

    /**
     * Address in use.
     */
    @Define
    public final static native int EADDRINUSE();

    /**
     * Address not available.
     */
    @Define
    public final static native int EADDRNOTAVAIL();

    /**
     * Network is down.
     */
    @Define
    public final static native int ENETDOWN();

    /**
     * Network unreachable.
     */
    @Define
    public final static native int ENETUNREACH();

    /**
     * Connection aborted by network.
     */
    @Define
    public final static native int ENETRESET();

    /**
     * Connection aborted.
     */
    @Define
    public final static native int ECONNABORTED();

    /**
     * Connection reset.
     */
    @Define
    public final static native int ECONNRESET();

    /**
     * No buffer space available.
     */
    @Define
    public final static native int ENOBUFS();

    /**
     * Socket is connected.
     */
    @Define
    public final static native int EISCONN();

    /**
     * The socket is not connected.
     */
    @Define
    public final static native int ENOTCONN();

    //LINUX
    @Define
    public final static native int ESHUTDOWN();

    //LINUX
    @Define
    public final static native int ETOOMANYREFS();

    /**
     * Connection timed out.
     */
    //POSIX(POSIX.Marker.XSI)
    @Define
    public final static native int ETIMEDOUT();

    /**
     * Connection refused.
     */
    @Define
    public final static native int ECONNREFUSED();

    //LINUX
    @Define
    public final static native int EHOSTDOWN();

    /**
     * Host is unreachable.
     */
    @Define
    public final static native int EHOSTUNREACH();

    /**
     * Connection already in progress.
     */
    @Define
    public final static native int EALREADY();

    /**
     * Operation in progress.
     */
    @Define
    public final static native int EINPROGRESS();

    /**
     * Reserved.
     */
    @Define
    public final static native int ESTALE();

    //LINUX
    @Define
    public final static native int EUCLEAN() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int ENOTNAM() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int ENAVAIL() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int EISNAM() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int EREMOTEIO() throws NotDefinedException;

    /**
     * Reserved.
     */
    @Define
    public final static native int EDQUOT();

    //LINUX
    @Define
    public final static native int ENOMEDIUM() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int EMEDIUMTYPE() throws NotDefinedException;

    /**
     * Operation canceled.
     */
    @Define
    public final static native int ECANCELED();

    //LINUX
    @Define
    public final static native int ENOKEY() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int EKEYEXPIRED() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int EKEYREVOKED() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int EKEYREJECTED() throws NotDefinedException;

    /**
     * Previous owner died.
     */
    @Define
    public final static native int EOWNERDEAD();

    /**
     * State not recoverable.
     */
    @Define
    public final static native int ENOTRECOVERABLE();

    //LINUX
    @Define
    public final static native int ERFKILL() throws NotDefinedException;

    //LINUX
    @Define
    public final static native int EHWPOISON() throws NotDefinedException;

    /**
     * Not supported (may be the same value as [@see EOPNOTSUPP]).
     */
    @Define
    public final static native int ENOTSUP();

    public final static native int errno();

    public final static native void errno(int value);

    public static String getErrnoSymbol(int errno) {
        for (Method m : Errno.class.getMethods()) {
            if (m.getAnnotation(Define.class) != null) {
                try {
                    Number res = (Number) m.invoke(Errno.class);
                    if (errno == res.intValue()) {
                        return m.getName();
                    }
                } catch (IllegalArgumentException | InvocationTargetException | IllegalAccessException ex) {
                    Logger.getLogger(Errno.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception e) {
                    if (e instanceof NotDefinedException) {
                        //no-op
                    } else {
                        //something unexpected happend...
                        throw e;
                    }
                }
            }
        }
        return "Unknown errno: " + errno;
    }

}
