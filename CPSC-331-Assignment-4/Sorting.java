import java.util.Arrays;
import java.util.Random;
/**
 * Student ID: 10150607
 * TA: Maryam Solemani
 * 
 * Sorting.java contains 5 different sorting algorithms, including the classical
 * sorting algorithm insertionSort, as well as 4 others, including heapSort, 
 * quickSort, and improved version of quickSort which is more efficient at sorting
 * smaller subarrays, as well as a randomized version of quickSort which makes 
 * use of choosing a random pivot element, which causes the worst case running time to 
 * be in O(n log n) (BONUS).
 * 
 * @author Lamess Kharfan
 * @version 1.0
 */
public class Sorting {
    static int heapSize = 1;
    
    /**
     * insertionSort(), a classical sorting algorithm that sorts 
     * progressively larger subarrays until the whole array has
     * been sorted.
     * @param A , an array to be sorted.
     */
    public static void insertionSort(int [] A)
    {
        int n = A.length;
        for(int i = 0; i <= n - 1; i++)
        {
            int j = i;
            while(j > 0 && A[j] < A[j-1])
            {
                int tmp = A[j];
                A[j] = A[j - 1];
                A[j - 1] = tmp;
                j = j - 1;
            }
        }
    }
    /**
     * insert() performs insertion into a max heap, inserts 
     * a given key into the multiset of values stored in the Max-Heap,
     * and otherwise leaves it unchanged.
     * @param A , Array which we are inserting into. 
     * @param key , the value to be inserted
     * @throws FullHeapException if heap is full and we try to insert
     */
    public static void insert(int [] A, int key)
    {
        int j;
        int parent;
        int tmp;
        
        if(heapSize < A.length)
        {
            A[heapSize] = key;
            heapSize = heapSize + 1;
        
            j = heapSize -1;
            parent = (int) Math.floor((j-1)/ 2);
            while(j > 0 && A[j] > A[parent])
            {
                tmp = A[j];
                A[j] = A[parent];
                A[parent] = tmp;
                j = parent;
                parent = (int) Math.floor((j-1)/2);
            }
        }
        else
            throw new FullHeapException();
    }
    /**
     * deleteMax() deletes the largest element from a Max-heap
     * @param A , the array from which we are removing the max element
     * @return max, the largest value stored immediately before 
     * this operation
     * @throws EmptyHeapException if we attempt to delete the max element
     * from an empty Max-Heap
     */
    public static int deleteMax(int[] A)
    {
        int max;
        int j;
        int left;
        int right;
        int largest;
        int tmp;
        
        if(heapSize > 0)
        {
            max = A[0];
            A[0] = A[heapSize - 1];
            heapSize = heapSize - 1;
            
            j = 0;
            while(j < heapSize)
            {
                left = 2*j + 1;
                right = 2*j + 2;
                largest = j;
                
                if((left < heapSize) && (A[left] > A[largest]))
                    largest = left;
              
                if((right < heapSize) && (A[right] > A[largest]))
                    largest = right;
                
                if(largest != j)
                {
                    tmp = A[j];
                    A[j] = A[largest];
                    A[largest] = tmp;
                    j = largest;
                }
                else
                    j = heapSize;
            }
            return max;
        }
        else
            throw new EmptyHeapException();
    }
    
    /**
     * heapSort() stores values from some ordered type T, can be 
     * turned into a max heap of size 1 simply by setting heapsize to 1,
     * inserting elements produces a Max-Heap while reordering the entries of A,
     * repeated calls to delete max will return entries, listed in decreasing order.
     * This overwrites the input array with the output array.
     * @param A , the array to be sorted. 
     */
    public static void heapSort(int[] A)
    {
        heapSize = 1;
        int i = 1;
        int largest;
        
        while(i < A.length)
        {
            insert(A, A[i]);
            i = i + 1;
        }
        i = A.length - 1;
        while(i > 0)
        {
            largest = deleteMax(A);
            A[i] = largest;
            i = i -1;
        }
    }
    /**
     * DPartition() chooses a pivot element and reorders
     * the array as follows: 
     *      pivot is in the correct spot if the array was sorted
     *      elements < pivot are to the left of it in the array
     *      elements > pivot are to the right of it in the array
     * The pivot element is the last element in the part of the array being processed.
     * @param A , the array to be sorted
     * @param low , the smallest index of the array
     * @param high , the largest index of the array
     * @return i , the pivot
     */
    public static int DPartition(int[] A, int low, int high)
    {
        int tmp;
        int p = A[high];
        int i = low;
        int j = high - 1;
        while(i <=j){
            while((i <= j) && (A[i] <= p))
                i += 1;
        
            while((j >= i) && (A[j] >= p))
                j -= 1;
        
            if(i < j)
            {
                tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
         tmp = A[i];
         A[i] = A[high];
         A[high] = tmp;
        
         return i;
    }
    /**
     * quickSort(int[], int, int) makes calls to DParition and
     * recursively sorts the array A.
     * @param A , the array to be sorted
     * @param low , the lowest index of the array
     * @param high , the highest index of the array
     */
    public static void quickSort(int[] A, int low, int high)
    {
        int q;
        if(low < high)
        {
            q = DPartition(A, low, high);
            quickSort(A, low, q - 1);
            quickSort(A, q + 1, high);       
        } 
    }
    
    /**
     * quickSort(int[]) takes in an array to be sorted
     * and calls quickSort[int[], int, int] to do the
     * paritioning and recursive sorting.
     * @param A , the array to be sorted
     */
    public static void quickSort(int[] A)
    {
        quickSort(A, 0, A.length - 1);
    }
   
    /** 
     * DPartitionImproved works almost the same as DPartition, except 
     * it also takes in p, the pivot element, which is calculated in
     * pivotImproved. 
     * @param A , array to be sorted
     * @param low , lowest index of the array
     * @param high , highest index of the array
     * @param p , the pivot
     * @return i, the partition
     */
    public static int DPartitionImproved(int [] A, int low, int high, int p)
    {
        int tmp;
        int i = low;
        int j = high - 1;
        while(i <=j){
            while((i <= j) && (A[i] <= p))
                i += 1;
        
            while((j >= i) && (A[j] >= p))
                j -= 1;
        
            if(i < j)
            {
                tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
         tmp = A[i];
         A[i] = A[high];
         A[high] = tmp;
        
         return i;
    }
    
    /**
     * pivotImproved() chooses the pivot element to be the median of the first element, 
     * the last element, and the middle element of the array. These three
     * elements are reorders so the smallest of the three is at the beginning,
     * largest is at the end, and the pivot element is the second-last position
     * in the array.
     * @param A , the array to be sorted
     * @param low , the lowest index of the array A
     * @param high , the highest index of the array A
     * @return p , which is the pivot located at the second last index
     */
    public static int pivotImproved(int[] A, int low, int high)
    {   
        int tmp;
        int median = (high + low)/2;

        //Check if value of low is bigger than value of median
        //If so, reorder them
        if(low > median)
        {
           tmp = A[low];
           A[low] = A[median];
           A[median] = tmp;
        }
        //Check if value of median is bigger than value of high
        //If so, reorder them
        if(median > high)
        {
            tmp = A[median];
            A[median] = A[high];
            A[high] = tmp;
        }
      
        //Check if value of low is larger than value of high
        //If so, reorder them 
        if(low > high)
        {
            tmp = A[low];
            A[low] = A[high];
            A[high] = tmp;
        }
        
        //Move median to second last position of the array
        tmp = A[median];
        A[median] = A[high - 1];
        A[high - 1] = tmp;
        
        //Return the second last element as the pivot
        return A[high - 1];
    }
    
    /**
     * quickSortImproved(int [], int, int) gets parameters from the 
     * quickSort called in main, and performs the sorting algorithm.
     * @param A , Array to be sorted
     * @param low , lowest index of the array
     * @param high , highest index of the array
     */
    public static void quickSortImproved(int [] A, int low, int high)
    {
        int thresh = 1024;
        //Due to recursive nature, size changes for subarrays
        int size = high - low + 1;
        if(size > thresh)
        {
            int pivot = pivotImproved(A, low, high);
            int q = DPartitionImproved(A, low, high, pivot);
            //Recurively sort the subarrays
            quickSort(A, low, q - 1);
            quickSort(A, q + 1, high);   
        }
    }
    /**
     * quickSortImproved is a more efficient way to sort when we have our worst 
     * case, when the array is already sorted, and makes sorting smaller subarrays more
     * efficient. We make use of a threshhold value, and this indicates if the algorithm
     * should continue recursively or, if the size of the input is smaller, 
     * the algorithm terminates and insertion sort is called to complete the
     * sorting process.
     * @param A , the array to be sorted.
     */
    public static void quickSortImproved(int [] A)
    {
        quickSortImproved(A, 0, A.length - 1);
        //If the if-statement in quickSortImproved(int[], int, int) fails
        //It will return and we will use insertion sort to sort A.
        insertionSort(A);  
    }
    
    /**
     * bonusPart() chooses a the pivot randomly from
     * the bound of the array and calls DPartition to 
     * complete the partitioning process.
     * @param A , array to be sorted
     * @param low , lowest index in the array A
     * @param high , highest index in the array A
     * @return the value DParition returns
     */
    public static int bonusPart(int[] A, int low, int high)
    {
        Random randomGen = new Random();
        int bounds = high - low + 1;
        int i = randomGen.nextInt(bounds) + low;
        
        int tmp = A[i];
        A[i] = A[high];
        A[high] = tmp;
        
        return (DPartition(A, low, high));
    }
    
    /** 
     * The method that is called by the method used in main
     * to complete the sorting algorithm for randomize quick sort
     * @param A , the array to be sorted
     * @param low , the lowest index of the array A
     * @param high , the highest index of the array A
     */
    public static void bonusQuickSort(int[] A, int low, int high)
    {
        if(low < high)
        {
            int q = bonusPart(A, low, high);
            bonusQuickSort(A, low, q - 1);
            bonusQuickSort(A, q + 1, high);
        }
        
    }
    /** 
     * quickSort bonus is an implementation of randomized quickSort,
     * which is the same as quickSort except we choose the pivot element
     * randomly from within the bounds of the array using bonusPart.
     * Worst case running time is O(n log n)
     * @param A , the array to be sorted. 
     */
    public static void quickSortBonus(int [] A)
    {
        bonusQuickSort(A, 0, A.length - 1);
    }
	
    /**
     * javaSort uses java's built in sorting function to sort a
     * randomly generated array.
     * @param A , the array to be sorted
     *
     */
    public static void javaSort(int [] A)
    {
	Arrays.sort(A);
    }
}
