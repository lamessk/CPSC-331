/*Lamess Kharfan	Student Number: 10150607
Tutorial Section:2	TA: Maryam Soleimani
Assignment 1- JUnit Tests for maxSubSum3 method. 
Implementation of white box test. 
*/

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.lang.IllegalArgumentException;

public class MSSTester4 {
	
	//Test if array was null
	@Test
	public void nullTest(){
		int[] A = {1 ,2, 3, 4};
		try{
			if(A != null){
				System.out.println("Array not null");
				MaxSubsequenceSum nullTester = new MaxSubsequenceSum();
				assertEquals(10, nullTester.maxSubSum3(A));
			}
			else{
				System.out.println("Array is null!");
				throw new IllegalArgumentException();
				}
			}
		catch (IllegalArgumentException e){
			System.out.println("Error: Array is null");
			throw new IllegalArgumentException();
			
		}
	}
	//Test if array is the proper length
	@Test
	public void lengthTest(){
		int[] A = {1, 2, 3, 4, 5};
		int i = 100000;
		try{
			if(A.length < i){
				System.out.println("Array length less than max");
				MaxSubsequenceSum lengTest = new MaxSubsequenceSum();
				assertEquals(15, lengTest.maxSubSum3(A));
			}
			else{
				System.out.println("Array length greater than or equal to max");
				throw new IllegalArgumentException();
			}
		}
		catch(IllegalArgumentException e){
			throw new IllegalArgumentException();
		}
	
	}
	
	//Test if loop guard returns true or false
	@Test
	public void loopTest(){
		int j = 0;
		int[] A = {1};
		int i = A.length;
		try{
			if(j < i){
				System.out.println("Loop guard is true.");
				MaxSubsequenceSum lTest = new MaxSubsequenceSum();
				assertEquals(1, lTest.maxSubSum3(A));
			}
			else{
				System.out.println("Loop gaurd is false, skip over loop.");
			}
		}
		catch(IllegalArgumentException e){
			System.out.println("Illegal Argument.");
			throw new IllegalArgumentException();
		}
	}
		
	//Test for what the loop body executes 	
	@Test
	public void ifTest(){
	int thisSum = 0;
	int	maxSum = 0;
	int[] A = {1};
	
	try{
		thisSum += thisSum + A[0];
		if(thisSum > maxSum){
			System.out.println("thisSum > maxSum");
			MaxSubsequenceSum ifTester = new MaxSubsequenceSum();
			assertEquals(1, ifTester.maxSubSum3(A));
		}
		else if (thisSum < 0){
			System.out.println("thisSum < 0");
			MaxSubsequenceSum ifTester = new MaxSubsequenceSum();
			assertEquals(1, ifTester.maxSubSum3(A));
		}
		else{
			System.out.println("Both if statements false");
			throw new IllegalArgumentException();
		}
	}
	catch(IllegalArgumentException e){
		System.out.println("Illegal Argument");
	}
		
	}
	
}	
		