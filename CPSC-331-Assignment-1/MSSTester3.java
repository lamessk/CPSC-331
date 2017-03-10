/*Lamess Kharfan	Student Number: 10150607
Tutorial Section:2	TA: Maryam Soleimani
Assignment 1- JUnit Tests for maxSubSum3 method. 
Implementation of black box tests. 
*/

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MSSTester3 {
	
	//Test for null array
	@Test (expected = IllegalArgumentException.class)
	public void nullTest() {
		System.out.println("Testing for null array...");
		throw new IllegalArgumentException();
	}	
	
	//Test for nonInteger Array input 
	@Test (expected = IllegalArgumentException.class)
	public void nonIntegerTest() {
		System.out.println("Testing for non-integer array...");
		throw new IllegalArgumentException();
	}
	
	//Test if integer array is empty
	@Test
	public void emptyTest() {
		int[] A = {};
		System.out.println("Testing for empty array...");
		MaxSubsequenceSum emptyTester = new MaxSubsequenceSum();
		assertEquals(0, emptyTester.maxSubSum3(A));
	}

	//Test if all elements of input array are negative 
	@Test
	public void negativeTest() {
		int[] A = {-8, -3, -10, -4, -5};
		System.out.println("Testing for negative array...");
		MaxSubsequenceSum negativeTester = new MaxSubsequenceSum();
		assertEquals(0, negativeTester.maxSubSum3(A));
	}

	//Test if input array only has 1 element
	@Test
	public void oneElementTest() {
		int [] A = {2};
		System.out.println("Testing one element array...");
		MaxSubsequenceSum oneElement = new MaxSubsequenceSum();
		assertEquals(2, oneElement.maxSubSum3(A));
	}
	
	//Test is last two elements are the maxSubSum 
	@Test
	public void lastTwoTest() {
		int[] A = {-1, -2, -3, 12, 10};
		System.out.println("Testing last two elements are max in array...");
		MaxSubsequenceSum lastTwo = new MaxSubsequenceSum();
		assertEquals(22, lastTwo.maxSubSum3(A));
	}
	
	//Test if first two elements are the maxSubSum
	@Test
	public void firstTwoTest() {
		int[] A = {30, 22, -1, -4, -6, 3};
		System.out.println("Testing if first two elements are max in array...");
		MaxSubsequenceSum firstTwo = new MaxSubsequenceSum();
		assertEquals(52, firstTwo.maxSubSum3(A));
	}

	//Test if input is an integer array
	@Test 
	public void integerArrayTest() {
		int[] A = {3, 5, -6, 22, -1, 5, 10};
		System.out.println("Testing an integer array... ");
		MaxSubsequenceSum integerTest = new MaxSubsequenceSum();
		assertEquals(38, integerTest.maxSubSum3(A));
	}
}