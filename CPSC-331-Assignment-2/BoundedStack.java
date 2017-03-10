/**
* Student ID: 10150607
 * Tutorial Section 2 
 * TA Maryam Soleimani
 * 
 * BoundedStack extends the interface cpsc331Stack provided on the
 * CPSC 331 course webpage.
 * The cpsc331Stack interface represents the Stack ADT as described
 * in CPSC 331.
 *
 * @author Lamess Kharfan
 * @version 1.0
 * @param <T> = objects that operations can be performed on
 */
public interface BoundedStack<T> extends cpsc331Stack<T>{

    /**
     * Pushes the object x onto the top of the stack.
     *
     * @param x object to be pushed onto the stack.
     * @throws FullStackException when size is equal to the capacity
     * of the stack
     */
    public void push(T x);
	
    /**
    * Checks the number of elements currently on the stack
    * 
    * @return size, the number of elements that have been pushed 
    * onto the stack
    */
    public int size();
	
    /**
     * Tests whether the stack is full.
     *
     * @return true if the number of elements in the stack 
     * is equal to the stack's capacity, false otherwise.
     * @throws FullStackException if the stack is full.
     */
    public boolean isFull();
    
	
    /**
     * Checks the maximum number of elements the stack can store
     *
     * @return the maximum number of elements that the stack can store
     */
    public int capacity();
	
}
