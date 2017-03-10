import java.util.EmptyStackException;
/**
* Student ID: 10150607
 * Tutorial Section 2 
 * TA Maryam Soleimani
 *
 * The BoundedStackArray implements the BoundedStack interface which
 * represents the Stack ADT as described in CPSC 331.
 *
 * @author  Lamess Kharfan
 * @version 1.0
 */
 
public class BoundedStackArray<T> implements BoundedStack<T> {
	
    //Variables 
    private T[] stack;
    private int top;
    public int sizeCount;
    public int SIZEBOUND;

    /**
    * Constructor for the class.
    *
    * @param arraySize, the maximum size of the bounded stack
    */
    public BoundedStackArray(int arraySize) 
    {
        top = -1;
        stack = (T[]) new Object[arraySize];
	SIZEBOUND = arraySize;
    }
	
    /**
     * Tests whether the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     * @throws EmptyStackException if top == -1
     */
    public boolean isEmpty()
    {
        if(top == -1){
            return true; 
        }
        else
        {
        	return false;
        		//throw new EmptyStackException();
	}
    }

    /**
     * Pushes the object x onto the top of the stack.
     *
     * @param x object to be pushed onto the stack.
     * @throws FullStackException if size of stack = stack capacity
     */
    public void push(T x)
    {
        if(isFull()){
            System.out.println("Stack is full");
            //throw new FullStackException();
        }
	else
	{
            ++top;
            stack[top] = x;
            
	}
    }
	
    /**
     * Checks the number of elements pushed to the stack
     *
     * @return the value of top + 1, giving the number of elements
     * in the stack
     */
    public int size()
    {
        return top + 1;
    }
		
    /**
     * Tests whether the stack is full.
     *
     * @return true if the number of elements in the stack 
     *	is equal to the stack's capacity, false otherwise.
     * @throws FullStackException if the stack is full.
     */
    public boolean isFull()
    {
        if(size() == SIZEBOUND)
	{
            System.out.println("Full Stack");
            return true;
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
        
        return stack[top];
    }

    /**
     * Removes and returns the object at the top of the stack.
     *
     * @return reference e to the item at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T pop()
    {
        if(isEmpty())
        {	
            System.out.println("The stack is empty");
            throw new EmptyStackException();
        }
        T e = stack[top];
        stack[top] = null;
        --top;
        return e;
    }
	
	/**
     * Checks the maximum number of elements the stack can store
     *
     * @return SIZEBOUND, which is the maximum number of elements the 
     * stack can hold
     */
    public int capacity() 
    {
        return SIZEBOUND;
    }
	
}