/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
   Andrew Choi
*/

public class HashSeparateChaining {

	private class Node {
		Entry entry;
		Node next;

		Node(Entry entry) { this.entry = entry; }
	}

	Node[] hashTable;
	int arraySize;
	int tableSize;

	public HashSeparateChaining(){
		hashTable = new Node[10];
		arraySize = 10;
	}

	//this method resizes the hashtable in a separate chaining manner
	private void resize() {
		Node[] newHashTable; //create new temp array
		if (((double) tableSize) / arraySize <= 2) {
			newHashTable = new Node[arraySize / 2];
		} else if (((double) tableSize) / arraySize >= 6) { // make sure that the number of nodes is between 3 and 5
			newHashTable = new Node[arraySize * 2];
		} else {
			return; //if between 3 and 5, no need for resize
		}

		arraySize = newHashTable.length; //set new arraySize

		for (Node head : hashTable) { //copy the values into the new hashtable
			Node curr = head;
			while (curr != null) {
				Entry newEntry = curr.entry;
				Node newNode = new Node(newEntry);
				String key = newEntry.getKey();

				int index = hash(key);
				if (newHashTable[index] != null)
					newNode.next = newHashTable[index];

				newHashTable[index] = newNode;
				curr = curr.next;
			}

		}

		hashTable = newHashTable; //change the hashtable into the new resized hashtable
	}


	/** Computes the index in the hash table from a given key */
	private int hash(String key) {
		int hashCode = key.hashCode();
		return (hashCode & 0x7fffffff) % arraySize;
	}

	/** Returns the number of entries in the hash table. */
	public int size() { return tableSize; }

	/** Checks whether the hash table is empty */
	public boolean isEmpty() { return tableSize == 0; }

	/** Returns the node containing the given key value if it exists in the table.
	    Otherwise, it returns a null value. */
	private Node findEntry(String key) {
		int index = hash(key);

		Node currentNode = hashTable[index];
		while (currentNode != null && !currentNode.entry.getKey().equals(key))
			currentNode = currentNode.next;

		return currentNode;

	}

	/** Returns the integer value paired with the given key, if the key is in the table.
		Otherwise, it returns null. */
	public Integer get(String key) {
		Node searchResult = findEntry(key);

		if (searchResult != null)
			return searchResult.entry.getValue();
		else
			return null;

	}

	/** If the given key is not in the table, creates a new entry and adds it to the table.
		Otherwise, it updates the value associated with the given key. */
	public void put(String key, Integer value) {
		Node searchResult = findEntry(key);

		if (searchResult != null){
			searchResult.entry.setValue(value);
			return;
		}
		
		resize(); //resize call before adding new entry
		Entry newEntry = new Entry(key, value);
		Node newNode = new Node(newEntry);

		int index = hash(key);
		if (hashTable[index] != null)
			newNode.next = hashTable[index];

		hashTable[index] = newNode;

		tableSize++; //increase tableSize to adjust for change

	}

	/** Removes the entry containing the given key
	   from the table, if the key exists in the table. */
	public void delete(String key) {
		Node searchResult = findEntry(key);
		if (searchResult == null)
			return;

		resize(); //resize call before deleting entry
		int index = hash(key);
		if (hashTable[index] == searchResult)
			hashTable[index] = searchResult.next;
		else{
			Node currentNode = hashTable[index];
			while (currentNode.next != searchResult)
				currentNode = currentNode.next;
			currentNode.next = searchResult.next;
		}

		tableSize--; //decrease tableSize to adjust for change
	}

	/** Produces a string representation of the table. */
	@Override
	public String toString(){
		String output = "";
		for (int i = 0; i < arraySize; i++){
			output += "\n (" + i + "): ";
			Node currentNode = hashTable[i];
			if (currentNode == null)
				output += currentNode + "\n";
			else{
				while (currentNode != null){
					output += " -> " + currentNode.entry;
					currentNode = currentNode.next;
				}
				output += "\n";
			}
		}

		return output;

	}
}
