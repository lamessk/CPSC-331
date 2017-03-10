/*Lamess Kharfan	Student Number: 10150607
Tutorial Section:2	TA: Maryam Soleimani
Assignment 1- JUnit Tests for maxSubSum2 method. 
Implementation of black box tests. 
*/

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MSSTester2 {
	
	//Test if array is null
	@Test (expected = IllegalArgumentException.class)
	public void nullTest() {
		System.out.println("Testing for null array...");
		throw new IllegalArgumentException();
	}	
	//Test if nonInteger array was given as input
	@Test (expected = IllegalArgumentException.class)
	public void nonIntegerTest() {
		System.out.println("Testing for non-integer array...");
		throw new IllegalArgumentException();
	}
	
	//Test if array is empty
	@Test
	public void emptyTest() {
		int[] A = {};
		System.out.println("Testing for empty array...");
		MaxSubsequenceSum emptyTester = new MaxSubsequenceSum();
		assertEquals(0, emptyTester.maxSubSum2(A));
	}

	//Test for negatove integer array
	@Test
	public void negativeTest() {
		int[] A = {-8, -3, -10, -4, -5};
		System.out.println("Testing for negative array...");
		MaxSubsequenceSum negativeTester = new MaxSubsequenceSum();
		assertEquals(0, negativeTester.maxSubSum2 (A));
	}

	//Test if array only contains one element
	@Test
	public void oneElementTest() {
		int [] A = {2};
		System.out.println("Testing one element array...");
		MaxSubsequenceSum oneElement = new MaxSubsequenceSum();
		assertEquals(2, oneElement.maxSubSum2(A));
	}
	
	//Test if last two elements are maxSubSum
	@Test
	public void lastTwoTest() {
		int[] A = {-1, -2, -3, 12, 10};
		System.out.println("Testing last two elements are max in array...");
		MaxSubsequenceSum lastTwo = new MaxSubsequenceSum();
		assertEquals(22, lastTwo.maxSubSum2(A));
	}
	
	//Test if first two elements in array are maxSubSum
	@Test
	public void firstTwoTest() {
		int[] A = {30, 22, -1, -4, -6, 3};
		System.out.println("Testing if first two elements are max in array...");
		MaxSubsequenceSum firstTwo = new MaxSubsequenceSum();
		assertEquals(52, firstTwo.maxSubSum2(A));
	}

	//Test for integer array as input
	@Test 
	public void integerArrayTest() {
		int[] A = {3, 5, -6, 22, -1, 5, 10};
		System.out.println("Testing an integer array... ");
		MaxSubsequenceSum integerTest = new MaxSubsequenceSum();
		assertEquals(38, integerTest.maxSubSum2(A));
	}
}