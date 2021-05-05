/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
   Andrew Choi
*/

public class BSTIndex {

	private class Node {
		private String key;
		private MovieInfo data;
		private Node left, right;

		public Node(MovieInfo info) {
			data = info;
			key = data.shortTitle;
		}
	}

	private Node root;

	public BSTIndex() {
		root = null;
	}
	/* Important: Notice that each public method here calls another private method while passing it a reference to the tree root. This is a common way of structuring BST functions such that external client code will not have direct access to the tree root. You will be implementing the code in the private methods, not the public ones. */

	/* Calculate and return the height of the current tree. */
	public int calcHeight(){
		return calcNodeHeight(this.root);
	}

	/* Insert the given data element into the proper place in the BST structure. */
	public void insertMovie(MovieInfo data) {
		root = insertMovie(data, this.root);
	}

	/* Find and return the data element (i.e. the MovieInfo object)
	of the node where the movie's shortTitle matches the given key.
	Return null if the movie is not found. */
	public MovieInfo findMovie(String key) {
		return findMovie(this.root, key);
	}

	/* Print out all movies in the database whose shortTitle begins with
	the passed prefix string. If no movies match the given prefix, nothing
	will be printed. The order of printing does not matter, but make sure
	to print each match in a separate line. */
	public void printMoviesPrefix(String prefix) {
		printMoviesPrefix(this.root, prefix);
	}
	// ----------------- end of public methods ------------------ //


	// ------------------ private BST methods ------------------- //


	//calculates the height of the bst
	private int calcNodeHeight(Node t) {
		if (t == null) { //if there are no nodes, the height is zero; this is also the base case
			return 0;
		}			

		//height = 1 + max between left and right subtree;
		return 1 + Math.max(calcNodeHeight(t.left),calcNodeHeight(t.right)); //recursive call			
	}


	//inserts the movie's data into the bst with the correct key and value
	private Node insertMovie(MovieInfo data, Node t) {
		if (t == null) { //if the bst is empty, add the first node; also base case for recursion
			return new Node(data);
		}
		// if movie already in bst
		if (data.shortTitle.equals(t.key)) {
			return root;
		}
		
		// found place to put movie in bst
		//if the left side is empty and the data is also less than the parent node, add the node
		if (data.shortTitle.compareTo(t.key) < 0 && t.left == null) {
			Node newNode = new Node(data);
			t.left = newNode;
			return root;
		}

		//if the right side is empty and the data is also greater than the parent node, add the node
		if (data.shortTitle.compareTo(t.key) > 0 && t.right == null) {
			Node newNode = new Node(data);
			t.right = newNode;
			return root;
		}

		//use a ternary operator to recursively search through the bst	
		return insertMovie(data, data.shortTitle.compareTo(t.key) < 0 ? t.left : t.right);
	}


	//this method traverses the bst to find the movie
	private MovieInfo findMovie(Node t, String key) {
		if (t == null) { //if the bst is empty, return null; also base case for recursion
			return null;
		}

		//if the key matches the node, return the data
		if (t.key.equals(key)) {
			return t.data;
		}

		//use a ternary operator to recursively search through the bst
		return findMovie(key.compareTo(t.key) < 0 ? t.left : t.right, key);
	}         

	
	//this method prints all of the movies starting with a certain String given in String prefix
	private void printMoviesPrefix(Node t, String prefix) {
		if (t == null) { //if the bst is empty, print nothing; also the base case for recursion
			return;
		}

		/**
	  	* if t contains prefix: print and search both subtrees
	  	* if t is prefix: print and search right subtree
	  	* if t doesn't contain prefix:
	  	*		if t > prefix: search left subtree
	  	*		if t < prefix: search right subtree
	  	*/

		if(t.key.equals(minusAsterisk(prefix))) {
			System.out.println(t.key);
			printMoviesPrefix(t.right, prefix);
		} else if (t.key.startsWith(minusAsterisk(prefix))) {
			System.out.println(t.key);
			printMoviesPrefix(t.left, prefix);
			printMoviesPrefix(t.right, prefix);
		} else {
			if (t.key.compareTo(minusAsterisk(prefix)) > 0) {
				printMoviesPrefix(t.left, prefix);
			} else {
				printMoviesPrefix(t.right, prefix);
			}
		}
	}

	//helper method for printMoviesPrefix() method
	//subtracts the asterisk in the prefix
	private String minusAsterisk(String prefix) {
		return prefix.substring(0, prefix.length() - 1);
	}
}
