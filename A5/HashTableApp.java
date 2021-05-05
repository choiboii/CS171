import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
   Andrew Choi
*/

public class HashTableApp {

	// Builds and returns a hash table of frequencies from the given input file
	public static HashSeparateChaining getMap(Scanner in){
		HashSeparateChaining map = new HashSeparateChaining();
		int idx = 1; //test
		while(in.hasNext()){
			String word = in.next(); // read next word in file
			word = word.toLowerCase();
			System.out.println( (idx++) + " => " + word); //test

			// word not yet in map
			if(map.get(word) == null) {
				map.put(word, 1);
			} else { // word already in map
				map.put(word, map.get(word) + 1);
			}
		}

		return map;
	}

	public static void main(String[] args) {
		if (args.length < 1){
			System.out.println("Pass the filename to be read as an argument.");
			System.exit(-1);
		}

		File input = new File(args[0]);
		Scanner fileReader = null;

		try{
			fileReader = new Scanner(input);
		} catch (FileNotFoundException e) {
			System.out.println("File was not found.  Check the file name and try again.");
			System.exit(-2);
		}

		HashSeparateChaining map = getMap(fileReader);
		System.out.println(map); // invokes map.toString()
	}
}
