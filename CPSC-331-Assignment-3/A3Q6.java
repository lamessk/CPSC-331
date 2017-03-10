/**
  * Student ID: 10150607
  * Tutorial #2
  * TA: Maryam Solemani
  *
  *
  * A3Q6.java calulcates staton  the  height  of m different
  * binary  search  trees created by inserting n distinctrandom 
  * integers into the tree, where n and m are command-line  parameters.
  * Table is presented with the minimim height of all m random trees,
  * The maximum height of all m random trees, the average height of all 
  * m random trees, an upper bound on the expected height of a random binary
  * search tree of size n, and a worst-case upperbound on the maximum height
  * of a red-black tree of size n. 
  * 
  * Syntax to run program is:
  *	java A3Q6 m n
  * where m and m are integers, m neing the number of random binary search trees
  * and n being the number of random nodes to insert in order to calculate the 
  * statistics listed above. 
  *
  *
  * @author Lamess Kharfan
  * @version 1.0 
  *
*/

import static java.lang.Integer.parseInt;
import java.lang.Math;
import static java.lang.Math.log;
import java.util.Random;

public class A3Q6 {
    
     public static void main(String[] args) {
       
	//Initialize all variables
         int m = 0;
         int n = 0;
         int max = 0;
         int min = 0;
         int toInsert;
         int height;
         int heightT = 0;
         int avg = 0;
	 double upperBound = 0;   
	 double upperRBT = 0;
     

	//Test if we were given the correct numbe rof arguments at the command line
	//Print message on how to use if not and exit program
        if (args.length != 2) {
            System.out.println("Usage: java A3Q6 m and n");
            System.out.println("  m - the number of Binary Search trees to create");
            System.out.println("  n - the number of nodes to insert into the Binary Search Trees");
            System.exit(1);
        }
        
	//If correct number of parameters were given, assign 1st to m and second to n
        if (args.length == 2)
        {
	    m = parseInt(args[0]);
            n = parseInt(args[1]);
            max = -1;
            min = n;
        }

         
         Random randomGen = new Random();
         
	//Loop as long as there are still random binary search trees to create
         for(int i = 0; i < m; i++){
             
             BSTMap <Integer, String> bst = new BSTMap <Integer, String> ();
             
	     //Insert nodes into trees as long as there are still nodes
             //to be inserted.
             int j = 0;
             while(j < n)
             {
                 try{
                    toInsert = randomGen.nextInt(999999);
                    bst.insert(toInsert, "value");
                 }
                 catch(KeyFoundException e){
                     j = j - 1;
                 }
                 
                 j = j + 1; 
             }
                          
             height = bst.height();
             heightT += height;

             //Check for new max
             if(height > max)
                 max = height;
             
	     //Check for new min
             if(height < min)
                 min = height;	

         }
	
	//Calculate upperbound on average
	upperBound = 3*(log(n)/(log(2)));	

	//Calculate upperbound on worst case maximum for red black trees
	upperRBT = 2*(log(n + 1)/log(2));

	//Calculate the average
         avg = heightT/m;


	//Display all statistics calulcated in a table. 	
	System.out.println(" ");
	System.out.println("------------------------------------------------------------");
	System.out.println("|          	Statistics for n = "+ n +" and m ="+m+"           |");
	System.out.println("------------------------------------------------------------");
	System.out.println("|           Minimum Height           |           "+min +"        |");
	System.out.println("------------------------------------------------------------");
	System.out.println("|           Maximum Height           |           "+max +"        |");  
	System.out.println("------------------------------------------------------------");
	System.out.println("|           Average Height           |           "+avg +"        |");           
	System.out.println("------------------------------------------------------------");
	System.out.println("|    Upper-Bound on Average Height   |  "+upperBound+" |"); 
	System.out.println("------------------------------------------------------------");
	System.out.println("| Upper-Bound on Max Height for RBT  | "+upperRBT+"  |"); 
	System.out.println("------------------------------------------------------------");       
     }
}

