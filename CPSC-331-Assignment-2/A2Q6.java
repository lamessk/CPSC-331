/**
 * Student ID: 10150607
 * Tutorial Section 2 
 * TA Maryam Soleimani
 *
 * A2Q6.java is the JUnit Test Suite that tests the program A2Q5.java which
 * evaluates Lisp expressions using the algorithm devised in Question 1 of 
 * Assignment 2 for CPSC 331. 
 * 
 * @author Lamess Kharfan
 * @version 1.0
*/


import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.EmptyStackException;

public class A2Q6 {
	
	/**
	 * nullTest() tests when the evaluate method is passed a null
	 * string for the exception and either a array or linked list
	 * implementation of the bounded stack 
	 *	Input: null string
	 * Expected Output: NullPointerException() 
	 *	Purpose: Invalid Input
	 */
	@Test(expected = NullPointerException.class)
	public void nullTest(){
		String expression = null;
		System.out.println("Testing null expression...");
		BoundedStackArray stackArray = new BoundedStackArray(expression.length());
		A2Q5 nullTester = new A2Q5();
		nullTester.evaluate(expression, stackArray);		
	}


	/**
	 * singleAddExpression() tests when the evaluate method is passed a 
	 * expression with just the + operator and an array or linked list
	 * implementation of the bounded stack. 
	 *	Input: (+)
	 * Expected Output: 0 
	 *	Purpose: Typical Case 
	 */
	@Test
	public void singleAddExpression() {
		String expression = "(+)";
		System.out.println("Testing (+)...");
		BoundedStack stackArray = new BoundedStackArray(expression.length());
		LinkedListBoundedStack linkedList = new LinkedListBoundedStack(expression.length());
		A2Q5 singleAddTest = new A2Q5();
		assertEquals(0, singleAddTest.evaluate(expression, stackArray), 0.00000001);
		assertEquals(0, singleAddTest.evaluate(expression, linkedList), 0.00000001);
	} 
	
	/**
	 * singleSubExpression() tests when the evaluate method is passed a 
	 * expression with just the - operator and an array or linked list
	 * implementation of the bounded stack. 
	 *	Input: (-)
	 * Expected Output: InvalidArgumentException 
	 *	Purpose: InvalidInput
	 */
	@Test(expected = IllegalArgumentException.class)
	public void singleSubExpression() {
		String expression = "(-)";
		System.out.println("Testing (-)...");
		BoundedStack stackArray = new BoundedStackArray(expression.length());
		LinkedListBoundedStack linkedList = new LinkedListBoundedStack(expression.length());
		A2Q5 singleSubTest = new A2Q5();
		singleSubTest.evaluate(expression, stackArray);
		singleSubTest.evaluate(expression, linkedList);
	} 
	
	
	/**
	 * singleMulExpression() tests when the evaluate method is passed a 
	 * expression with just the * operator and an array or linked list
	 * implementation of the bounded stack. 
	 *	Input: (*)
	 * Expected Output: 1.0 
	 *	Purpose: Typical Case 
	 */
	@Test
	public void singleMulExpression() {
		String expression = "(*)";
		System.out.println("Testing (*)...");
		BoundedStack stackArray = new BoundedStackArray(expression.length());
		LinkedListBoundedStack linkedList = new LinkedListBoundedStack(expression.length());
		A2Q5 singleMulTest = new A2Q5();
		assertEquals(1.0, singleMulTest.evaluate(expression, stackArray), 0.00000001);
		assertEquals(1.0, singleMulTest.evaluate(expression, linkedList), 0.00000001);
	} 
	
	
	/**
	 * singleDivExpression() tests when the evaluate method is passed a 
	 * expression with just the - operator and an array or linked list
	 * implementation of the bounded stack. 
	 *	Input: (/)
	 * Expected Output: InvalidArgumentException 
	 *	Purpose: Invalid Input
	 */
	@Test(expected = IllegalArgumentException.class)
	public void singledivExpression() {
		String expression = "(/)";
		System.out.println("Testing (/)...");
		BoundedStack stackArray = new BoundedStackArray(expression.length());
		LinkedListBoundedStack linkedList = new LinkedListBoundedStack(expression.length());
		A2Q5 singleDivTest = new A2Q5();
		singleDivTest.evaluate(expression, stackArray);
		singleDivTest.evaluate(expression, linkedList);
	} 
	
	/**
	 * typicalAddtion() tests when the evaluate method is passed an addition 
	 * expression with an arbitrary number of operands and an array or linked list
	 * implementation of the bounded stack. 
	 *	Input: (+ 1 2 3)
	 * Expected Output: 6.0 
	 *	Purpose: Typical Case 
	 */
		@Test
		public void typicalAddition() {
		String expression = "(+ 1 2 3)";
		System.out.println("Testing (+ 1 2 3)...");
		BoundedStack stackArray = new BoundedStackArray(expression.length());
		LinkedListBoundedStack linkedList = new LinkedListBoundedStack(expression.length());
		A2Q5 typAddTest = new A2Q5();
		assertEquals(6.0, typAddTest.evaluate(expression, stackArray), 0.00000001);
		assertEquals(6.0, typAddTest.evaluate(expression, linkedList), 0.00000001);
	}
	
	/**
	 * typicalSubtraction() tests when the evaluate method is passed a subtraction 
	 * expression with an arbitrary number of operands and an array or linked list
	 * implementation of the bounded stack. 
	 *	Input: (- 1 2 3)
	 * Expected Output: -4.0 
	 *	Purpose: Typical Case 
	 */
		@Test
		public void typicalSubtraction() {
		String expression = "(- 1 2 3)";
		System.out.println("Testing (- 1 2 3)...");
		BoundedStack stackArray = new BoundedStackArray(expression.length());
		LinkedListBoundedStack linkedList = new LinkedListBoundedStack(expression.length());
		A2Q5 typSubTest = new A2Q5();
		assertEquals(-4.0, typSubTest.evaluate(expression, stackArray), 0.00000001);
		assertEquals(-4.0, typSubTest.evaluate(expression, linkedList), 0.00000001);
		}
		
	/**
	 * typicalMultiplication() tests when the evaluate method is passed a multiplication 
	 * expression with an arbitrary number of operands and an array or linked list
	 * implementation of the bounded stack. 
	 *	Input: (+ 2 3 4)
	 * Expected Output: 24.0 
	 *	Purpose: Typical Case 
	 */		
		
		@Test
		public void typicalMultiplication() {
		String expression = "(* 2 3 4)";
		System.out.println("Testing (* 2 3 4)...");
		BoundedStack stackArray = new BoundedStackArray(expression.length());
		LinkedListBoundedStack linkedList = new LinkedListBoundedStack(expression.length());
		A2Q5 typMulTest = new A2Q5();
		assertEquals(24.0, typMulTest.evaluate(expression, stackArray), 0.00000001);
		assertEquals(24.0, typMulTest.evaluate(expression, linkedList), 0.00000001);
	}
	
	
	/**
	 * typicalDivision() tests when the evaluate method is passed an addition 
	 * expression with an arbitrary number of operands and an array or linked list
	 * implementation of the bounded stack. 
	 *	Input: (/ 8 2 2)
	 * Expected Output: 2.0 
	 *	Purpose: Typical Case 
	 */
	@Test
		public void typicalDivision() {
		String expression = "(/ 8 2 2)";
		System.out.println("Testing (/ 8 2 2)...");
		BoundedStack stackArray = new BoundedStackArray(expression.length());
		LinkedListBoundedStack linkedList = new LinkedListBoundedStack(expression.length());
		A2Q5 typDivTest = new A2Q5();
		assertEquals(2.0, typDivTest.evaluate(expression, stackArray), 0.00000001);
		assertEquals(2.0, typDivTest.evaluate(expression, linkedList), 0.00000001);
	}
	
	/**
	 * extraRightBracket() tests when the evaluate method is passed a 
	 * expression one or more extra right brackets and an array or linked list
	 * implementation of the bounded stack. 
	 *	Input: (+ 1 2 3))
	 * Expected Output: IllegalArgumentException 
	 *	Purpose: Invalid Input
	 */	
		@Test(expected = IllegalArgumentException.class)
		public void extraRightBracket() {
		String expression = "(+ 1 2 3))";
		System.out.println("Testing (+ 1 2 3))...");
		BoundedStack stackArray = new BoundedStackArray(expression.length());
		LinkedListBoundedStack linkedList = new LinkedListBoundedStack(expression.length());
		A2Q5 exRBTest = new A2Q5();
		exRBTest.evaluate(expression, stackArray);
		exRBTest.evaluate(expression, linkedList);
	}
	
	/**
	 * extraLeftBracket() tests when the evaluate method is passed a 
	 * expression one or more extra left brackets and an array or linked list
	 * implementation of the bounded stack. 
	 *	Input: ((+ 1 2 3)
	 * Expected Output: IllegalArgumentException 
	 *	Purpose: Invalid Input
	 */	
	@Test(expected = IllegalArgumentException.class)
		public void extraLeftBracket() {
		String expression = "((+ 1 2 3)";
		System.out.println("Testing ((+ 1 2 3)...");
		BoundedStack stackArray = new BoundedStackArray(expression.length());
		LinkedListBoundedStack linkedList = new LinkedListBoundedStack(expression.length());
		A2Q5 exLBTest = new A2Q5();
		exLBTest.evaluate(expression, stackArray);
		exLBTest.evaluate(expression, linkedList);
	}
	
	/**
	 * tooManyOpertaors() tests when the evaluate method is passed a 
	 * expression one or more extra operators and an array or linked list
	 * implementation of the bounded stack. 
	 *	Input: (+ - 6)
	 * Expected Output: IllegalArgumentException 
	 *	Purpose: Invalid Input
	 */	
	@Test(expected = IllegalArgumentException.class)
	public void tooManyOperators(){
		String expression = "(+ - 6)";
		System.out.println("Testing incorrect format with (+ - 6)....");
		BoundedStack stackArray = new BoundedStackArray(expression.length());
		LinkedListBoundedStack linkedList = new LinkedListBoundedStack(expression.length());
		A2Q5 operatorTest = new A2Q5();
		operatorTest.evaluate(expression, stackArray);
		operatorTest.evaluate(expression, linkedList);
	}

	
	/**
	 * singleAddOperand() tests when the evaluate method is passed an addition 
	 * expression with one operand and an array or linked list
	 * implementation of the bounded stack. 
	 *	Input: (+ 4)
	 * Expected Output: 4.0 
	 *	Purpose: Typical Case 
	 */
	@Test
	public void singleAddOperand() {
		String expression = "(+ 4)";
		System.out.println("Testing (+ 4)...");
		BoundedStack stackArray = new BoundedStackArray(expression.length());
		LinkedListBoundedStack linkedList = new LinkedListBoundedStack(expression.length());
		A2Q5 oneOpAdd = new A2Q5();
		assertEquals(4.0, oneOpAdd.evaluate(expression, stackArray), 0.00000001);
		assertEquals(4.0, oneOpAdd.evaluate(expression, linkedList), 0.00000001);
	} 
	
	/**
	 * singleSubOperand() tests when the evaluate method is passed a subtraction
	 * expression with one operand and an array or linked list
	 * implementation of the bounded stack. 
	 *	Input: (- 6)
	 * Expected Output: -6.0 
	 *	Purpose: Typical Case 
	 */
	@Test
	public void singleSubOperand() {
		String expression = "(- 6)";
		System.out.println("Testing (- 6)...");
		BoundedStack stackArray = new BoundedStackArray(expression.length());
		LinkedListBoundedStack linkedList = new LinkedListBoundedStack(expression.length());
		A2Q5 oneOpSub = new A2Q5();
		assertEquals(-6.0, oneOpSub.evaluate(expression, stackArray), 0.00000001);
		assertEquals(-6.0, oneOpSub.evaluate(expression, linkedList), 0.00000001);
	}


	/**
	 * singleMulOperand() tests when the evaluate method is passed a  
	 * multiplication expression with one operand and an array or linked list
	 * implementation of the bounded stack. 
	 *	Input: (* 3)
	 * Expected Output: 3.0 
	 *	Purpose: Typical Case 
	 */
	@Test
	public void singleMulOperand() {
		String expression = "(* 3)";
		System.out.println("Testing (* 3)...");
		BoundedStack stackArray = new BoundedStackArray(expression.length());
		LinkedListBoundedStack linkedList = new LinkedListBoundedStack(expression.length());
		A2Q5 oneOpMul = new A2Q5();
		assertEquals(3.0, oneOpMul.evaluate(expression, stackArray), 0.00000001);
		assertEquals(3.0, oneOpMul.evaluate(expression, linkedList), 0.00000001);
	} 
	
	/**
	 * singleDivOperand() tests when the evaluate method is passed a 
	 * division expression with one operand and an array or linked list
	 * implementation of the bounded stack. 
	 *	Input: (/ 2)
	 * Expected Output: 0.5 
	 *	Purpose: Typical Case 
	 */
	@Test
	public void singleDivOperand() {
		String expression = "(/ 2)";
		System.out.println("Testing (/ 2)...");
		BoundedStack stackArray = new BoundedStackArray(expression.length());
		LinkedListBoundedStack linkedList = new LinkedListBoundedStack(expression.length());
		A2Q5 oneOpDiv = new A2Q5();
		assertEquals(0.5, oneOpDiv.evaluate(expression, stackArray), 0.00000001);
		assertEquals(0.5, oneOpDiv.evaluate(expression, linkedList), 0.00000001);
	} 
	
	/**
	 * allOperationsExpression() tests when the evaluate method is passed a 
	 * expression with sub expressions of every operator type and an array or
	 * linked list implementation of the bounded stack. 
	 *	Input: (+ (+ 1 2) (- 4 2) (* 3 4) (/ 4 2))
	 * Expected Output: 19.0 
	 *	Purpose: Typical Case 
	 */
	@Test
	public void allOperationsExpression() {
		String expression = "(+ (+ 1 2) (- 4 2) (* 3 4) (/ 4 2))";
		System.out.println("Testing (+ (+ 1 2) (- 4 2) (* 3 4) (/ 4 2)) to test all operations working in one expression...");
		BoundedStack stackArray = new BoundedStackArray(expression.length());
		LinkedListBoundedStack linkedList = new LinkedListBoundedStack(expression.length());
		A2Q5 allOps = new A2Q5();
		assertEquals(19.0, allOps.evaluate(expression, stackArray), 0.00000001);
		assertEquals(19.0, allOps.evaluate(expression, linkedList), 0.00000001);
	} 

	 /**
	 * negativeOperands() tests when the evaluate method is passed a 
	 * expression with operands that are negative and an array or
	 * linked list implementation of the bounded stack.
	 * This demonstrates that the algorithm is able to handle arbitrary integer values. 
	 *	Input: (+ -6)
	 * Expected Output: -6.0 
	 *	Purpose: Typical Case 
	 */
		
	@Test
	public void negativeOperands() {
		String expression = "(+ -6)";
		System.out.println("Testing negative operands with (+ -6)...");
		BoundedStack stackArray = new BoundedStackArray(expression.length());
		LinkedListBoundedStack linkedList = new LinkedListBoundedStack(expression.length());
		A2Q5 negOps = new A2Q5();
		assertEquals(-6.0, negOps.evaluate(expression, stackArray), 0.00000001);
		assertEquals(-6.0, negOps.evaluate(expression, linkedList), 0.00000001);
		
	}
	
}


