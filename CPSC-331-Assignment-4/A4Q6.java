import java.util.Arrays;
import java.util.Random;
import static java.lang.Integer.parseInt;
/**Student ID: 10150607
 * TA: Maryam Solemani
 * 
 * A4Q6.java tests all of the sorting algorithms implemented in Sorting.java,
 * as well as Java's built-in sort function on SORTED arrays of various 
 * lengths, used alongside VisualVM to profile run times. 
 * 
 * TAKES IN 2 PARAMETERS. 1) the length of the arrays to randomly generate
 *                        2) the number of arrays to randomly generate
 * USAGE: java A4Q6 (length of arrays) (number of arrays)
 * 
 * @author Lamess Kharfan
 * @version 1.0
 */
public class A4Q6 {
    public static void main(String[] args)
    {
	int length;
	int numArrays;

        //Ensure correct number of parameters have been given
        //If not, display usage message and exit
	if(args.length != 2)
	{
		System.out.println("Usage: java A2Q6 (array size) (number of arrays) ");
		System.exit(1);
	}

	length = parseInt(args[0]);
	numArrays = parseInt(args[1]);
        
        
        //Test insertion sort
	for(int i = 0; i < numArrays; i++)
	{
		int[] A = new int[length];        
		for(int j = 0; j < length; j++)
        	{	
            		A[j] = j;
        	}
        	Sorting.insertionSort(A);
	}	
        //Test heap sort
	for(int i = 0; i < numArrays; i++)
	{
		int[] B = new int[length];        
		for(int j = 0; j < length; j++)
        	{	
            		B[j] = j;
        	}
        	Sorting.heapSort(B);
	}
        //Test quick sort
	for(int i = 0; i < numArrays; i++)
	{
		int[] C = new int[length];        
		for(int j = 0; j < length; j++)
        	{	
            		C[j] = j;
        	}
        	Sorting.quickSort(C);
	}

        //Test quick sort improved
	for(int i = 0; i < numArrays; i++)
	{
		int[] D = new int[length];        
		for(int j = 0; j < length; j++)
        	{	
            		D[j] = j;
        	}
        	Sorting.quickSortImproved(D);
	}

        //Test bonus quick sort
	for(int i = 0; i < numArrays; i++)
	{
		int[] E = new int[length];        
		for(int j = 0; j < length; j++)
        	{	
            		E[j] = j;
        	}
        	Sorting.quickSortBonus(E);
	}
    
        //Test java's built in sorting function
	for(int i = 0; i < numArrays; i++)
	{
		int[] F = new int[length];        
		for(int j = 0; j < length; j++)
        	{	
            		F[j] = j;
        	}
        	Sorting.javaSort(F);
	}

    }
}
