import java.util.Vector;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.util.EmptyStackException;
import java.io.IOException;
import java.io.FileNotFoundException;
import static java.lang.Integer.parseInt;

/**
 *
 * A class for counting word frequencies in a text file.
 *
 * @author  Mike Jacobson
 * @version 1.0
 */

public class CountWords {

    /**
     *  Prints a message describing proper usage with respect to required
     *  command line parameters and exits.
     */
    public static void usage() {
	System.out.println("Usage: java CountWords infile (type)");
	System.out.println("  infile - name of input file containing text");
	System.out.println("  type (optional) - SimpleSortedMap implementation to use:");
	System.out.println("    0 - LinkedListMap (default)");
	System.out.println("    1 - BSTMap");
	System.out.println("    2 - RBTMap");
	System.out.println("    3 - MyRBTMap");
	System.exit(1);
    }


    /**
     *  A command line interface to the expression evaluator
     */
    public static void main(String[] args) {
	// gather command line arguments
	if (args.length != 1 && args.length != 2)  usage();

        int type = 0;
        if (args.length == 2)
	    type = parseInt(args[1]);

        // read each word from the text file and add it to a 
        // SimpleSortedMap
	SimpleSortedMap<String,Integer> M;

// UNCOMMENT THIS CODE TO USE WITH BSTMap and RBTMap
        if (type == 1) 
	    M = new BSTMap<String,Integer>();
	else if (type == 2)
	    M = new RBTMap<String,Integer>();
	// only uncomment this clause if you've solved the bonus question!
	// else if (type == 3)
	//    M = new MyRBTMap<String,Integer>();
	else
	    M = new LinkedListMap<String,Integer>();

	// Use a try-catch block to handle any exceptions thrown by
	// reading from the input file
	try {
	    // Create a Scanner object to read from the file argv[1]
	    //  (in current folder), which will be used to read in lines
	    //  of the input file
	    File inputFile = new File(args[0]);
	    Scanner in = new Scanner(inputFile);

	    while (in.hasNextLine()) {
		String inline = in.nextLine();
		StringTokenizer line = new StringTokenizer(inline,".,?;:\\ !&(){}[]`-\"");

		while (line.hasMoreTokens()) {
		    String word = (line.nextToken()).toLowerCase();

		    try {
			Integer freq = M.search(word);
			M.modify(word,freq+1);
		    }
		    catch(KeyNotFoundException e) {
			M.insert(word,1);
		    }
		}
	    }
	}

	// Print a message to standard output if there was a problem
	// opening or processing the input file.
	catch(FileNotFoundException e) {
	    System.out.println(e);
	    System.exit(0);
	}

        // print all the keys stored in the SimpleSortedMap
        System.out.println("Keys contained in the map:");
        Vector<String> keys = new Vector<String>();
        for (String key : M) {
	    keys.add(key);
	    System.out.println(key + ", " + M.search(key));
	}

        // delete all keys that occur multiple times in the file
        for (int i=0; i<keys.size(); ++i) {
	    Integer freq = M.search(keys.get(i));
	    if (freq > 1) {
		M.delete(keys.get(i));
	    }
	}

        // output remaining keys
        System.out.println("\nKeys contained in the map with frequency 1:");
        for (String key : M)
	    System.out.println(key + ", " + M.search(key));
    }
}

