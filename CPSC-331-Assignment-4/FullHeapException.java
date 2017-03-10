/**
 * FullHeapExcepion is a runtime exception that is thrown when
 * someone tries to insert into a full Max-Heap. 
 * @author Lamess Kharfan
 * @version 1.0
 */
public class FullHeapException extends RuntimeException {
    /**
     * Creates an exception with a null cause.
     * @see RuntimeException#RuntimeException()
     */
    public FullHeapException( ) {
	super( );
    }

    /**
     * Creates an exception with cause message.
     * @see RuntimeException#RuntimeException(String message)
     */
    public FullHeapException( String message ) {
	super( message );
    }
}
