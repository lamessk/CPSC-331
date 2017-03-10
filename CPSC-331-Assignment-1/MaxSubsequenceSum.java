/*Lamess Kharfan	Student Number: 10150607
Tutorial Section:2	TA: Maryam Soleimani
Edited version of MaxSubsequenceSum.java
*/
import java.util.Random;
import static java.lang.Integer.parseInt;
import static java.lang.Math.max;
import java.lang.IllegalArgumentException;

/**
 * The MaxSubsequenceSum class contains implementations of three algorithms
 * for solving the maximum subsequence sum problem.
 * @author  Mike Jacobson
 * @version 1.0, September 2008
 */
public class MaxSubsequenceSum {
    static final int MAX_ARRAY_SIZE=100000;
    static final int MAX_ENTRY_SIZE=1000;


    /**
     * Generates an array containing n random elements between -maxEntry and
     * maxEntry.
     *
     * @return array containing n random elements between -maxEntry and maxEntry
     * @param  n desired size of A
     * @param  maxEntry elements of A will be randomly chosen between -maxEntry and maxEntry
     * @throws IllegalArgumentException if n < 0, n > MAX_ARRAY_SIZE or maxEntry > MAX_ENTRY_SIZE
     */
    public static int [] randomArray(int n, int maxEntry)
    {
        // Enforce preconditions
	if (n <= 0)
	    throw new IllegalArgumentException("Negative array size: " + n);

	if (n > MAX_ARRAY_SIZE)
	    throw new IllegalArgumentException("Array size = " + n + " bigger than MAX_ARRAY_SIZE = " + MAX_ARRAY_SIZE);

	if (maxEntry > MAX_ENTRY_SIZE)
	    throw new IllegalArgumentException("Max entry size = " + maxEntry + " bigger than " + MAX_ENTRY_SIZE);


	// create A
	int [] A = new int[n];


	// fill A with random integers
	Random R = new Random();
	for (int i=0; i<n; ++i)
	    {
		int val = R.nextInt(2*maxEntry+1) - maxEntry;
		assert -maxEntry <= val && val <= maxEntry : "val = " + val + ", maxEntry = " + maxEntry;
		A[i] = val;
	    }


	// test postconditions
	assert A.length == n : "A.length = " + A.length + ", n = " + n;
	for (int i=0; i<n; ++i)
	    assert -maxEntry <= A[i] && A[i] <= maxEntry : "A[i] = " + A[i] + ", maxEntry = " + maxEntry; 

	return A;
    }



    /**
     * Exhaustive search maximum subsequence sum algorithm.
     * Finds and returns maximum sum in A by testing all valid indices i and j.
     *
     * @return value of the maximum subsequence sum in A
     * @param A integer array
     * @throws IllegalArgumentException if A is null or A.length > MAX_ARRAY_SIZE
     */
    public static int maxSubSum1(int [] A)
    {
        // enforce preconditions
        if (A == null)
            throw new IllegalArgumentException("A is null");

        if (A.length > MAX_ARRAY_SIZE)
            throw new IllegalArgumentException("Array size = " + A.length + " bigger than MAX_ARRAY_SIZE = " + MAX_ARRAY_SIZE);


        // compute the max subsequence sum of A using brute-force
        int maxSum=0;
	int n = A.length;

	for (int j=0; j<n; ++j) {
	    for (int i=0; i<=j; ++i) {
		int S = 0;
		for (int k=i; k <= j; ++k) {
		    S += A[k];
		}

		if (S > maxSum)
		    maxSum = S;
	    }
	}

        // Postcondition: maxSum is the max subsequence sum of A
        assert maxSum >= 0: maxSum;

        return maxSum;
    }




    /**
     * Recursive maximum subsequence sum algorithm.
     * Finds maximum sum in subarray spanning A[left],...,A[right].
     *
     * @return value of the maximum subsequence sum in A[left],...,A[right]
     * @param A non-null integer array of length <= MAX_ARRAY_SIZE with entries between -MAX_ENTRY_SIZE and MAX_ENTRY_SIZE
     * @param left left index of current subarray
     * @param right  right index of current subarray
     */
    private static int maxSumRec(int [] A, int left, int right)
    {
	// test preconditions of private function
	assert A != null;
	assert left >= 0 : left;
	assert right <= A.length : A.length;


	// base cases
        if (left > right)
	    return 0;

	if (left == right)
	    if (A[left] > 0)
		return A[left];
	    else
		return 0;


	// compute maximum subsequence sum for left and right halves of the array
	int center = (left + right) / 2;
	int maxLeftSum = maxSumRec(A,left,center);
	int maxRightSum = maxSumRec(A,center+1,right);



	// compute largest sum in the left half containing A[center]
	int maxLeftBorderSum = 0, leftBorderSum = 0;
	for (int i=center; i>=left; --i)
	    {
		leftBorderSum += A[i];
		if (leftBorderSum > maxLeftBorderSum)
		    maxLeftBorderSum = leftBorderSum;
	    }
	// maxLeftBorderSum is the max subsequence sum of A[left],...,A[center]
        //   that includes A[center]



	// compute largest sum in the right half containing A[center+1]
	int maxRightBorderSum = 0, rightBorderSum = 0;
	for (int i=center+1; i<=right; ++i)
	    {
		rightBorderSum += A[i];
		if (rightBorderSum > maxRightBorderSum)
		    maxRightBorderSum = rightBorderSum;
	    }
	// maxRightBorderSum is the max subsequence sum of
        //   A[center+1],...,A[right] that includes A[center+1]



        int maxSum =  max(  max(maxLeftSum,maxRightSum), maxLeftBorderSum+maxRightBorderSum);

	// the maximimum subsequence sum for A[left],...,A[right] is
	// max(maxLeftSum, maxRightSum, maxLeftBorderSum+maxRightBorderSum)
	assert maxSum >= 0 : maxSum;

        return maxSum;
    }




    /**
     * Recursive maximum subsequence sum driver program.
     * Finds maximum subsequence sum in A recursively.
     *
     * @return value of the maximum subsequence sum in A
     * @param A integer array
     * @throws IllegalArgumentException if A is null or A.length > MAX_ARRAY_SIZE
     */
    public static int maxSubSum2(int [] A)
    {
	// enforce preconditions
	if (A == null)
	    throw new IllegalArgumentException("A is null");

	if (A.length > MAX_ARRAY_SIZE)
	    throw new IllegalArgumentException("Array size = " + A.length + " bigger than MAX_ARRAY_SIZE = " + MAX_ARRAY_SIZE);


	// compute the max subsequence sum of A using a recursive (divide-and-conquer) method
	int maxSum =  maxSumRec(A, 0, A.length-1);

	// Postcondition: maxSum is the max subsequence sum of A
	assert maxSum >= 0: maxSum;

	return maxSum;
    }




    /**
     * Optimal efficiency maximum subsequence sum algorithm.
     * Finds maximal subsequence sum in A using the fastest known algorithm.
     *
     * @return value of the maximum subsequence sum in A
     * @param A integer array
     * @throws IllegalArgumentException if A is null or A.length > MAX_ARRAY_SIZE
     */
    public static int maxSubSum3(int [] A)
    {
	// enforce preconditions
	if (A == null)
	    throw new IllegalArgumentException("A is null");

	if (A.length > MAX_ARRAY_SIZE)
	    throw new IllegalArgumentException("Array size = " + A.length + " bigger than MAX_ARRAY_SIZE = " + MAX_ARRAY_SIZE);


	int maxSum = 0, thisSum = 0;

	for (int j=0; j<A.length; ++j)
	    {
		thisSum += A[j];

		if (thisSum > maxSum)
		    maxSum = thisSum;
		else if (thisSum < 0)
		    thisSum = 0;
	    }

	// Postcondition:  maxSum is the max subsequence sum of A
	assert maxSum >= 0 : maxSum;

	return maxSum;
    }




    /**
     *  Prints a message describing proper usage with respect to required
     *  command line parameters and exits.
     */
    public static void usage()
    {  
	System.out.println("Usage: java MaxSubsequenceSum arraySize maxEntry numArrays");
	System.out.println("  arraySize - number of elements per array");
	System.out.println("  maxEntry - each entry is between -maxEntry and maxEntry");
	System.out.println("  numArrays - number of different arrays to test");
	System.exit(1);
    }


    /**
     *  Tests the three maximum subsequence sum functions on a common series
     *  of random arrays.
     *  Requires three command line parameters of type <code>int</code>:
     *  <ul>
     *   <li> arraySize (length of arrays to test)
     *   <li> maxEntry (each array entry will be between -maxEntry and maxEntry)
     *   <li> numArrays (number of random arrays to test)
     *  </ul>
    */
    public static void main(String[] args)
    {
	if (args.length != 3)  usage();

	// gather command line arguments
	int n = parseInt(args[0]);
	int maxEntry = parseInt(args[1]);
	int num_arrays = parseInt(args[2]);

	System.out.println("Testing " + num_arrays + " arrays");
	System.out.println("Array entries between " + -maxEntry + " and " + maxEntry);
	System.out.println(n + " elements in each array");


	// create num_arrays random arrays and compute the maximum
        // subsequence sum using three different methods for each

	for (int i=0; i<num_arrays; ++i)
	    {
		// create an array of random integers between
                // -max_int and max_int
		int [] A = null;
		try 
		    {
			A = randomArray(n,maxEntry);
		    }
		catch (IllegalArgumentException e)
		    {
			System.out.println(e);
			usage();
		    }

		// compute maximum subsequence sum using exhaustive
                // search algorithm
		int max1 = maxSubSum1(A);

		// compute maximum subsequence sum using recursive algorithm
		int max2 = maxSubSum2(A);
		assert max2 == max1 : "max1 = " + max1 + ", max2 = " + max2 + " (should be equal)";

		// compute maximum subsequence sum using optimal algorithm
		int max3 = maxSubSum3(A);
		assert max3 == max2 : "max2 = " + max2 + ", max3 = " + max3 + " (should be equal)";

		System.out.println("i=" + i + ", max1 = " + max1 + ", max2 = " + max2 + ", max3 = " + max3);
	    }
    }
}