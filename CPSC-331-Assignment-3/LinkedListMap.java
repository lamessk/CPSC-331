import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  A linked list implementation of the SimpleSortedMap interface 
 *  using generics.
 *  @author Karel P. Bergmann
 */
public class LinkedListMap <K extends Comparable <K>, V> implements SimpleSortedMap <K, V> {
    private Node <K, V> head;
    private int llsize;
    
    public LinkedListMap () {
        head = null;
        llsize = 0;
    }
    
    /**
     * Tests whether the map is empty.
     *
     * @return true if the dictionary is empty, false otherwise
     */
    public boolean isEmpty() {
	return (llsize == 0);
    }


    /**
     * Returns the number of key-values pairs in the map.
     *
     * @returns int The size of the map.
     */
    public int size () {
        return llsize;
    }


    /**
     * Inserts a key-value pair into the map.
     *
     * @param key The key to be inserted.
     * @param value Key's corresponding value.
     * @throws KeyFoundException If a matching key is already present in the map
     */
    public void insert (K key, V value) throws KeyFoundException {
        Node <K, V> current = head;
        Node <K, V> previous = null;
        while (current != null && (current.key).compareTo(key) <= 0) {
            if ((current.key).compareTo(key) == 0)
		throw new KeyFoundException ();
            previous = current;
            current = current.next;
	}

        Node <K, V> n = new Node <K, V> (key, value, current);
        if (previous == null)
	    head = n;
        else
	    previous.next = n;
        llsize++;
    }


    /**
     * Deletes the key-value pair with the specified key
     * from the map
     *
     * @param key The key to remove from the map.
     * @throws KeyNotFoundException If key is not found
     * in the map.
     */
    public void delete (K key) throws KeyNotFoundException {
        Node <K, V> current = head;
        if ((current != null) && ((current.key).compareTo(key) == 0)) {
            head = head.next;
            llsize--;
            return;
        }

        while (current.next != null && ((current.next).key).compareTo(key) <= 0) {
            if (((current.next).key).compareTo(key) == 0) {
                current.next = (current.next).next;
                llsize--;
                return;
            }    
            current = current.next;
        }
        throw new KeyNotFoundException ();
    }
    

    /**
     * Returns the value corresponding to key.
     *
     * @param key The key to search for in the map.
     * @returns V The value corresponding to key.
     * @throws KeyNotFoundException If key is not found
     * in the map.
     */
    public V search (K key) throws KeyNotFoundException {
        Node <K, V> current = head;
        while (current != null && (current.key).compareTo(key) <= 0) {
            if ((current.key).compareTo(key) == 0)
                return current.value;
            current = current.next;
        }
        throw new KeyNotFoundException ();
    }
    

    /**
     * Modifies the value corresponding to key in the map.
     *
     * @param key The key whose value to modify.
     * @param value The new value of key.
     * @throws KeyNotFoundException If key was not found in the map
     * and therefore no value was modified.
     */
    public void modify (K key, V value) throws KeyNotFoundException {
        Node <K, V> current = head;
        while (current != null && (current.key).compareTo(key) <= 0) {
            if ((current.key).compareTo(key) == 0) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        throw new KeyNotFoundException ();
    }


    public Iterator<K> iterator() {
        return new LLMapIterator<K,V>();
    }

    private class LLMapIterator<K extends Comparable<K>,V> implements Iterator<K> {
        private Node<K,V> curr;

        LLMapIterator() {
            curr = (Node<K,V>) head;
        }

        public boolean hasNext() {
            return (curr != null);
        }

        public K next() {
            if (curr == null) 
                throw new NoSuchElementException();
         
            Node<K,V> prev = curr;
            curr = curr.next;
            return prev.key;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }



    private class Node <K extends Comparable <K>, V> {
        private K key;
        private V value;
        private Node <K, V> next;
           
        public Node (K k, V v, Node <K, V> n) {
            key = k;
            value = v;
            next = n;
        }
    }    


    public static void main (String [] args) {
        LinkedListMap <Integer, String> ll = new LinkedListMap <Integer, String> ();
        ll.insert (1, "hello");
        ll.insert (2, "test");
        System.out.println(ll.search (1).toString());
        System.out.println(ll.search (2).toString());
        Iterator<Integer> I = ll.iterator();
        while (I.hasNext()) 
            System.out.println (I.next());
        ll.delete(2);
        System.out.println(ll.search (2).toString());
    }
}

