/**
 * A checked exception used by SimpleSortedMap to indicate when searching or 
 * deleting a key that is not in the map.
 *
 * @author  Mike Jacobson
 * @version 1.0
 *
 */

public class KeyNotFoundException extends RuntimeException {
    /**
     * Creates an exception with a null cause.
     * @see RuntimeException#RuntimeException()
     */
    public KeyNotFoundException( ) {
	super( );
    }

    /**
     * Creates an exception with cause message.
     * @see RuntimeException#RuntimeException(String message)
     */
    public KeyNotFoundException( String message ) {
	super( message );
    }
}

