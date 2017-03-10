/**
 * Lamess Kharfan
 * Student ID: 10150607
 * Tutorial Section 2 
 * TA Maryam Soleimani
 *
 * The cpsc331Stack interface represents the Stack ADT as described
 * in CPSC 331.
 *
 * @author  Mike Jacobson
 * @version 1.0
 */
public interface cpsc331Stack<T> {

    /**
     * Tests whether the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Pushes the object x onto the top of the stack.
     *
     * @param x object to be pushed onto the stack.
     */
    public void push(T x);

    /**
     * Returns the object at the top of the stack.
     *
     * @return reference to the item at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T top();

    /**
     * Removes and returns the object at the top of the stack.
     *
     * @return reference to the item at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T pop();
}
