/**
 *  Simplified Sorted Map interface supporting some basic
 *  operations map/dictionary.
 *
 * @author  Karel P. Bergmann, Mike Jacobson
 * @version 2.0
 */
public interface SimpleSortedMap<K extends Comparable <K>, V> extends Iterable<K> {
    /**
     * Tests whether the map is empty.
     *
     * @return true if the dictionary is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Returns the number of key-values pairs in the map.
     * @returns int The size of the map.
     */
    public int size ();

    /**
     * Inserts a key-value pair into the map.
     * @param key The key to be inserted.
     * @param value Key's corresponding value.
     * @throws KeyFoundException If a matching key is
     * already present in the map
     */
    public void insert (K key, V value) throws KeyFoundException;

    /**
     * Deletes the key-value pair with the specified key
     * from the map
     * @param key The key to remove from the map.
     * @throws KeyNotFoundException If key is not found
     * in the map.
     */
    public void delete (K key) throws KeyNotFoundException;

    /**
     * Returns the value corresponding to key.
     * @param key The key to search for in the map.
     * @returns V The value corresponding to key.
     * @throws KeyNotFoundException If key is not found
     * in the map.
     */
    public V search (K key) throws KeyNotFoundException;

    /**
     * Modifies the value corresponding to key in the map.
     * @param key The key whose value to modify.
     * @param value The new value of key.
     * @throws KeyNotFoundException If key was not found in the map
     * and therefore no value was modified.
     */
    public void modify (K key, V value) throws KeyNotFoundException;
}

