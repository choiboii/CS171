/***************************************************************************
 * A Linked List class with a private static inner Node class.
 *****************************************************************************/
import java.util.*;

// TODO 1: Make this Linked List support <generics>
// TODO 2: Make this Linked List Iterable!

public class MyLinkedList<T> implements SimpleList<T>, Iterable {
  /*******************************************************
  * The private inner class "Node" */
  private class Node {
      private T data;
      private Node next;

      public Node(T data, Node next) {
          this.data = data;
          this.next = next;
      }
      public String toString(){ return ""+this.data; } // alt1: String.valueOf()

   } // End of private innter class "Node"
   /********************************************************/

   // MyLinkedListList instance variable "head" is declared of
   // type "Node", i.e. the inner class defined above
   private Node head;

   // Constructs an empty list
   public MyLinkedList() {
      head = null;
   }

   // Returns true if the list is empty
   public boolean isEmpty(){
     return head == null;
   }

   // Inserts a new node at the beginning of this list
   public void addFirst(T item){
     // Step1: Wrap "item" inside a Node
     Node temp = new Node(item, head);//the current "head" will be this node's next
     // Step2: Update the variable "head"
     head = temp;

     // Alternative one-line solution:
     // head = new Node(item,head);
   }

   // Inserts a new node to the end of this list
   public void addLast(T item){
     if( isEmpty() ) // corner case: empty linked list
        addFirst(item);
     else
     {
       Node current = head;
       while( current.next != null ) current = current.next;

       // Now current is pointing to the last element!
       current.next = new Node(item, null);
     }
   }

   // Returns the first element (data) in the list
   public T getFirst(){
     // If the list is empty, throw an exception
     if( isEmpty() ) throw new NoSuchElementException();
     return head.data;
   }

   // Returns the last element (data) in the list
   public T getLast(){
     // If the list is empty, throw an exception
     if(head == null) throw new NoSuchElementException();
     Node tmp = head;
     while(tmp.next != null) tmp = tmp.next;
     return tmp.data;
   }

   // Returns the data at the specified position in the list.
   // Note: Assume that pos is the index of the node, and that
   // node indexes start at zero!
   public T get(int pos){
     // Coding strategy: Start by solving the general case,
     // then add checks for corner cases (e.g. What if "pos" is out-of-bound?)
     if ( isEmpty() || pos < 0) throw new IndexOutOfBoundsException();
     // Alternatively: throw new NoSuchElementException();

     Node tmp = head;
     for (int k = 0; k < pos; k++){
        tmp = tmp.next;
        if( tmp == null) throw new IndexOutOfBoundsException();
     }
     return tmp.data;
   }


   // Removes and returns the first element (data) in the list.
   public T removeFirst(){
     T temp = getFirst(); // get the data in first element
     head = head.next; // remove first element
     return temp; // return the data in first element
   }

   // Removes the first occurrence of the specified element in this list.
   public void remove(T key){
     if(head == null) // corner case: empty linked list
        throw new RuntimeException("cannot delete key from this empty list");

     // corner case: key to be removed is in the head node
     if( head.data.equals(key) ){
        head = head.next;
        return;
     }

     // general case
     Node cur  = head;
     Node prev = null;
     while(cur != null && !cur.data.equals(key) ) {
        prev = cur;
        cur = cur.next;
     }

     // corner case: key does not exist!
     if(cur == null)
        throw new RuntimeException("cannot delete - key does not exist");

     // key does exist: delete cur node
     prev.next = cur.next;
   }

   // Returns a string representation
   public String toString(){
      String output = "";
      if(head == null) throw new NoSuchElementException();
      Node tmp = head;
      while(tmp != null) {
        output += tmp + " -> ";
        tmp = tmp.next;
      }
      output += "[NULL]";
      return output;
   }

   // because this class implements Iterable, we must implement
   // the method iterator():
   public MyLinkedListIterator iterator() {
      // return new Iterator(); // WRONG
      return new MyLinkedListIterator(); // See definition of MyLinkedListIterator class below
   }

   // Provide the implementation of class MyLinkedListIterator
   // which must implement the interface Iterator:
   private class MyLinkedListIterator implements Iterator<T> {

      // we need this instance variable to keep track of nodes
      // while traversing
      private Node nextNode;

      // Constructor
      public MyLinkedListIterator() {
        nextNode = head; // Notice: this inner class has access to "head" from outer class!
      }

      public boolean hasNext() {
        return nextNode != null;
      }

      public T next() {
         if (!hasNext()) throw new NoSuchElementException();
         T res = nextNode.data;
         nextNode = nextNode.next;
         return res;
      }
      // We must implement remove() but we don't want to support
      // removal via Iterator objects, we only support removal via
      // the remove() method defined in MyLinkedList class above ;-)
      public void remove() { throw new UnsupportedOperationException(); }
      // Recall, in the LL implementation we have these methods:
      // remove(T key)
      // removeLast
      // removeFast
   }

} // End of MyLinkedListList class
