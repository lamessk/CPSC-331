/**
 *Student ID: 10150607
 * TA: Maryam Solemani
 * 
 * EmptyHeapException is a runtime exception that is thrown when
 * someone tries to delete the max element from an already empty
 * Max-Heap.
 * @author Lamess Kharfan
 * @version 1.0
 */
public class EmptyHeapException extends RuntimeException {
    /**
     * Creates an exception with a null cause.
     * @see RuntimeException#RuntimeException()
     */
    public EmptyHeapException( ) {
	super( );
    }

    /**
     * Creates an exception with cause message.
     * @see RuntimeException#RuntimeException(String message)
     */
    public EmptyHeapException( String message ) {
	super( message );
    }
}
