import java.util.EmptyStackException;

/**
* Student ID: 10150607
 * Tutorial Section 2 
 * TA Maryam Soleimani
 *
 * LinkedListBoundedStack implements the BoundedStack interface which
 * represents the Bounded Stack ADT as described in CPSC 331.
 *
 * @author  Lamess Kharfan
 * @version 1.0
 */

public class LinkedListBoundedStack<T> implements BoundedStack<T>{


    private class StackNode<T>{
    private T value;
    private StackNode<T> next;
		
        private StackNode(T x, StackNode<T> n){
            value = x; 
            next = n;
        }
    }
	
    //Node for the top of the stack
    private StackNode<T> top;
	
    //size of the stack
    private int size;
	
    //Maximum size of the stack
    private int SIZEBOUND; //Is it enough to just have this? 

    //Stack ADT implemented using a linked list 
    public LinkedListBoundedStack(int listSize) 
    {
        size  = 0;
        SIZEBOUND = listSize; 
	top = (StackNode<T>) null;
    }
	
	
    /**
     * Tests whether the stack is empty by checking it's size.
     *
     * @return true if the stack is empty, false otherwise
     * @throws EmptyStackException if stack size of stack is 0
	 */
    public boolean isEmpty()
    {
        if(size == 0)
            return true;
	else
            return false;
    }

    /**
     * Pushes the object x onto the top of the stack.
     *
     * @param x object to be pushed onto the stack.
     * @throw FullStackException if isFull() returns true.
	 */
    public void push(T x)
    {
        if(isFull())
            System.out.println("The Stack is Full");
        else 
        {
            ++size;
            top = new StackNode<T>(x, top);
        }
    }	
	
    /**
     * Checks the size of the stack.
     *
     * @return size, the number of objects pushed to the stack so far
     */
    public int size()
    {
        return size;
    }
	
    /**
     * Tests whether the stack is full.
     *
     * @return true if the size of the stack is equal to the 
     * stack's capacity, false otherwise.
     * @throws FullStackException if the stack is full.
     */	
    public boolean isFull()
    {
        if(size == SIZEBOUND){
            return true;
            //throw new FullStackException
         }
        else
            return false;
    }
	
    /**
     * Returns the object at the top of the stack.
     *
     * @return reference to the item at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T top()
    {
	if(isEmpty())
            throw new EmptyStackException();
        
	return top.value;
    }

    /**
     * Removes and returns the object at the top of the stack.
     *
     * @return reference x to the item at the top of the stack
     * @throws EmptyStackException if the stack is empty prior to popping
     */
    public T pop()
    {
	if(isEmpty())	
        	throw new EmptyStackException();
	T x = top.value;
	top = top.next;
	--size;
	return x;
    }
    /**
     * Checks the maximum number of elements the stack can store
     *
     * @return SIZEBOUND, the maximum number of elements that the 
     * stack can store
     */
    public int capacity() 
    {
	return SIZEBOUND;
    }
	
}

