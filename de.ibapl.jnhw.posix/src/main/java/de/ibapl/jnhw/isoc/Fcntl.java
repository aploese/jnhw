package de.ibapl.jnhw.isoc;

import de.ibapl.jnhw.LibJnhwPosixLoader;
import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.NativeErrorException;

@Include("#include <fcntl.h>")
public class Fcntl extends LibJnhwPosixLoader {

    protected Fcntl() {
    }

    public final static native boolean HAVE_FCNTL_H();
   /**
     * Creates the named file with the mode flags.
     * @param file
     * @param mode
     * @return a handle to the opend file.
     * 
     * @exception NullPointerException if <code>file</code> is <code>null</code>.
     * 
     * @throws NativeErrorException 
     */
    public final static native int creat(CharSequence file, int mode) throws NativeErrorException;

    @Define
    public final static native int O_RDWR();
    /**
     * Opens the named file with the flags.
     * @param file
     * @param oflag
     * @return a handle to the opend file.
     * 
     * @exception NullPointerException if <code>file</code> is <code>null</code>.
     * 
     * @throws NativeErrorException 
     */
    public final static native int open(CharSequence file, int oflag) throws NativeErrorException;

}
