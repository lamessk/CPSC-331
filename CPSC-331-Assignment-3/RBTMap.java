
/**
 * Student ID: 10150607
 * Tutorial 2
 * TA: Maryam Solemani
 * 
 * RBTMap implements SImpleSortedMap interface using a red-black tree. Done so by
 * using the TreeMap class from the Java API, uses existing functions of TreeMap to 
 * implement all required functions from the SimpleSortedMap Interface.
 * 
 * @author Lamess Kharfan
 * @version 1.0
 * 
 */

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class RBTMap <K extends Comparable <K>, V> implements SimpleSortedMap <K, V>{
        
    TreeMap <K,V> RBT;

    //Constructor for the class
    public RBTMap() {
        RBT = new TreeMap<K,V>();
  
    }
    /**
     * Tests whether the map is empty.
     *
     * @return true if the Red-Black Tree is empty, false otherwise
     */
    public boolean isEmpty() {
        
        if(RBT.size() == 0)
            return true;
        else
            return false; 
    }
   
    /**
     * Returns the number of key-values pairs in the map.
     * @returns int The size of the red black tree map.
     */
    public int size() {
        return(RBT.size());   
    }

    /**
     * Inserts a key-value pair into the red black tree map.
     * @param key The key to be inserted.
     * @param value Key's corresponding value.
     * @throws KeyFoundException If a matching key is
     * already present in the map
     */
    public void insert(K key, V value) throws KeyFoundException {
	if (RBT.containsKey(key))
	    throw new KeyFoundException();       
	RBT.put(key, value);
    }

    /**
     * Deletes the key-value pair with the specified key
     * from the red black tree map
     * @param key The key to remove from the map.
     * @throws KeyNotFoundException If key is not found
     * in the map.
     */
    public void delete(K key) throws KeyNotFoundException {
	if (!RBT.containsKey(key))
	    throw new KeyNotFoundException();
        RBT.remove(key);
    }

    
    /**
     * Returns the value corresponding to key.
     * @param key The key to search for in the map.
     * @returns V The value corresponding to key.
     * @throws KeyNotFoundException If key is not found
     * in the red black tree map.
     */
    public V search(K key) throws KeyNotFoundException {
	if (!RBT.containsKey(key))
	    throw new KeyNotFoundException();
        return (V) RBT.get(key);
    }

    /**
     * Modifies the value corresponding to key in the red black tree map.
     * @param key The key whose value to modify.
     * @param value The new value of key.
     * @throws KeyNotFoundException If key was not found in the map
     * and therefore no value was modified.
     */
    public void modify(K key, V value) throws KeyNotFoundException {
	if (!RBT.containsKey(key))
	    throw new KeyNotFoundException();
        RBT.put(key, value);
    }

    
    /**
     * iterator() performs an inorder traveral of the red black tree
     * @return itr , which can perform an inorder traveral.
     */
   public Iterator<K> iterator() {
        Set keySet = RBT.keySet();
        Iterator itr = keySet.iterator();
        return itr;
    }
}


