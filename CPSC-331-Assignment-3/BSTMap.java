

/**
 * Student ID: 101050607
 * Tutorial Section 2
 * TA: Maryam Soleimani
 *
 * BSTMap implements the SimpleSortedMap interface using a binary search tree data structure.
 * Search, insert, modify, and delete are all implemented iteratively,
 * and the iterator returned by Iterator performs an in-order traversal of the binary search 
 * tree, accessing the keys in ascending order.  Also includes a function that calculates height
 * for A3Q6.
 * 
 * @author Lamess Kharfan
 * @version 1.0
 * 
 */

import java.util.Iterator;
import java.util.Stack;

public class BSTMap <K extends Comparable <K>, V> implements SimpleSortedMap <K, V>{

    private bstNode<K,V> root;
    private int bstSize;
    
        //bstNode delclares a class for creating a bstNode 
	private class bstNode <K extends Comparable <K>, V> {
            private K key;	
            private V value;
            private bstNode<K, V> left;
            private bstNode<K, V> right;
            
            public bstNode(K k, V v) {
                key = k;
 	        value = v;
            }
    	}
        
        /**
         * COnstructor for BSTmap Class
         */
        public BSTMap(){
            root = null;
            bstSize = 0;
        }
    
    /**
     * isEmpty() tests if the binary search tree is empty
     * or contains nodes.
     * @return true if bstSize is equal to 0, false otherwsie
     */
    public boolean isEmpty() {
        if (bstSize == 0)
            return true;
        else
            return false;
    }

    /**
     * size() gives the number of nodes in the tree
     * @return value of bstSize which is incremented whenever
     * a node is added, and decremented whenever a node is removed.
     */
    public int size() {
        return bstSize;
    }

    /**
     * insert() adds distinct nodes to a BST according to the BST property.
     * If the key of a node is less than the value of the root, it is inserted
     * somewhere within the left subtree, and is inserted somewhere within the 
     * right subtree otherwise. 
     * @param key , the key of the node to be inserted
     * @param value , the value of the node to be inserted
     * @throws KeyFoundException if there exists a node with the same 
     * key as the one to be inserted
     */
    public void insert(K key, V value) throws KeyFoundException {
        
        bstNode<K, V> curr = root;
        bstNode<K, V> parent = null;
        
        //If the tree is empty, insert at the root
        if(root == null){
            root = new bstNode<K, V>(key, value);
        }
        
        //Otherwise, search for the place to insert
        else{
            while(curr != null){
                parent = curr;
                
                //Search left
                if(key.compareTo(curr.key) < 0)
                {
                    curr = curr.left;  
                }
                //Search right
                else if(key.compareTo(curr.key) > 0) 
                {
                    curr = curr.right;
                }
                //Otherwise key has been found
                else{
                    throw new KeyFoundException();
					            
                }
            }
            if(key.compareTo(parent.key) < 0)
            {
                parent.left = new bstNode(key, value);
            }
            else
            {
                parent.right = new bstNode(key, value);
            }
                  
        }
        bstSize++; 
    }
    /**
     * delete() removes a node from a binary search tree, and takes
     * care of the 4 cases when deleting a node, which include if the node to be
     * deleted is not in the tree, if it is a leaf node, if it has 1 child, or if 
     * it has 2 children. A search is first implemented and deletion is carried out
     * depending on what the case is. 
     * @param key , the key of the node we wish to delete from the binary search tree
     * @throws KeyNotFoundException  when the node specified to delete is not within the tree.
     */
    public void delete(K key) throws KeyNotFoundException {
        bstNode<K, V> curr = root;
        bstNode<K, V> parent = null;
	bstNode<K, V> child = root;
      
	//Search for key to be deleted
        while(curr != null && curr.key != key){
		parent = curr;

            	if(key.compareTo(curr.key) < 0){
                	curr = curr.left;
             	}
            	else if(key.compareTo(curr.key) > 0){
                	curr = curr.right;         
             	}
	}

	 //If we have broken out of the loop, curr == null or key has been found

	    //Case 1: Check if it is the case that curr	= null
	    //If it is null, throw exception.	
	    if (curr == null)
 		    throw new KeyNotFoundException();
     
 	   //Otherwise, if the key has been found, figure out what case we have

	    //Case 2: Node to be deleted is a leaf
	    //Set parents child to null 	
	    if (curr.left == null && curr.right == null){ 
        	if (key.compareTo(parent.key) < 0)
            		parent.left = null;
       		 else
           		 parent.right = null;
             }
	    //Case 3a: Node to be deleted has a right child
            //Set pointer to right child by exchanging key and value of parent and child
	    else if (curr.left == null){
        	child = curr.right;
        	
		//Switch keys
		K switchK = curr.key;
    		curr.key = child.key;
    		child.key = switchK;        	


		//Switch values
		V switchV = curr.value;
    		curr.value = child.value;
    		child.value = switchV; 

        	curr.left = child.left;
        	curr.right = child.right;
    	    }

	    //Case 3b: Node to be deleted has a left child
	    //Set pointer to left child by exchanging key and values of parent and child		
	    else if (curr.right == null){
        	child = curr.left;
		
		//Switch keys
		K switchK = curr.key;
    		curr.key = child.key;
    		child.key = switchK;        	


		//Switch values
		V switchV = curr.value;
    		curr.value = child.value;
    		child.value = switchV; 	        	
			
        	curr.left = child.left;
        	curr.right = child.right;
    	   }
	   //Case 4: Node to be deleted has 2 children 
	   //Replace node with its successor, min in right subtree
	   else{
		//Find the minimum of the right subtree
	        child = curr.left;
	        parent = null;

        	while (child.right != null){
            		parent = child;
            		child = parent.right;
        	}
        	if (parent == null){
			//Switch keys of curr and child
			K switchK = curr.key;
    			curr.key = child.key;
    			child.key = switchK;        	

			//Switch values
			V switchV = curr.value;
    			curr.value = child.value;
    			child.value = switchV; 	

			//Set left child of current to left child of child.
            		curr.left = child.left;
        	}
		else{
            		//Switch keys of curr and child
			K switchK = curr.key;
    			curr.key = child.key;
    			child.key = switchK;        	

			//Switch values
			V switchV = curr.value;
    			curr.value = child.value;
    			child.value = switchV; 
			
			//Set parent's right child to child's left child.
            		parent.right = child.left;
        	}
    	   }
            //Decrement the size of the binary search tree
            bstSize--;
	}

    
    /**
     * search() uses a specified key to attempt to find a node with that key 
     * within the binary search tree. Uses the BST property to find the node, 
     * searching left if key is less than root, searching right if key is greater 
     * than root. Returns the value associated with the key if found. 
     * @param key
     * @return
     * @throws KeyNotFoundException 
     */
    public V search(K key) throws KeyNotFoundException {
        V v = null;
        bstNode<K, V> curr = root;
        while(curr != null && v == null)
        {
            //If key found, assign value to v
            if(key.compareTo(curr.key) == 0){
                v = curr.value;
            }
            //If key less than node's key, search left
            else if(key.compareTo(curr.key) < 0)
            {
                curr = curr.left;
            }
            //Otherwise search right
            else
            {
                curr = curr.right;
	     }
        }
        //If we have broken out of the loop check if it's because the node was
        //found the value has be assigned to V or if it wasn't found. 
        if (v == null){
            throw new KeyNotFoundException();
         }
        else{
            return v;
         }
    }

    /**
     * Modifies the value corresponding to key in the map.
     * @param key The key whose value to modify.
     * @param value The new value of key.
     * @throws KeyNotFoundException If key was not found in the map
     * and therefore no value was modified.
     */
    public void modify(K key, V value) throws KeyNotFoundException {      
        bstNode<K, V> curr = root;
        
        //Search for node using key to change value
        while(curr != null)
        {
            //If found, change value
            if(key.compareTo(curr.key) == 0){
                curr.value = value;
                return;
            }
            //If key < curr.key search left
            else if(key.compareTo(curr.key) < 0)
            {
                curr = curr.left;
            }
            //Otherwise search right
            else
                curr = curr.right;
        }
        
            throw new KeyNotFoundException();
    }
    

    /**
     * iterator() performs an inorder traveral of the binary search tree
     * @return BSTMapIterator , which can perform an inorder traveral.
     */
     public Iterator<K> iterator() {
        return new BSTMapIterator<K,V>();
    }

    private class BSTMapIterator<K extends Comparable<K>,V> implements Iterator<K> {
        private bstNode<K,V> curr;
	Stack<bstNode> stack = new Stack<bstNode>();

        //Constructor
        BSTMapIterator() {
            curr = (bstNode<K,V>) root;
           
        }

        /**
         * hasNext() lets us know if there are still nodes to be traversed 
         * @return true is there are still nodes to be traversed, false otherwise
         */
        public boolean hasNext() {
            return (curr != null || !stack.empty());
        }
              
        /**
         * next() gives the next node to be traversed in the binary search tree
         * @return key of node to be traversed.
         */
        public K next(){
		while(curr != null) {
			stack.push(curr);
			curr= curr.left;
		}
		curr = stack.pop();
		bstNode<K, V> next = curr;
		curr = curr.right;
		
		return next.key;
	}
        
        //Not being used.
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
     
   /**
    * height() gives the longest path from root to leaf of a binary search tree
    * @return 1 + max , the value of the height of the tree. 
    */
   public int height()
   {
      return height(root);
   }
   private int height(bstNode<K, V> T)
   {
       int max;
      //If root is null return that the tree is empty 
      if(T == null) 
          return -1;
      
      //Otherwise, recursively call height to calculate height.
      else{
          int heightL = height(T.left);
          int heightR = height(T.right);
          
          if(heightL >= heightR)
              max = heightL;
          else
              max = heightR;
      }
      //Return maximum of 2 recursive calls and add one
        return 1 + max;
   }
    
   
    public static void main (String [] args) {
	//Tests to make sure all methods in BSTMap are working correctly
        BSTMap <Integer, String> bst = new BSTMap <Integer, String> ();
        bst.insert (8, "Hi");
        bst.insert (12, "Insert");
        bst.insert(9, "Test");

        System.out.println(bst.search (8).toString());
        System.out.println(bst.search (9).toString());
        bst.modify(9, "Changed");
        System.out.println(bst.search (9).toString());
        
        Iterator<Integer> I = bst.iterator();
        while (I.hasNext()) 
           System.out.println (I.next());

	int height = bst.height();
        System.out.println(height);
        
        bst.delete(2);
        System.out.println(bst.search (2).toString());
        
    }    
}
