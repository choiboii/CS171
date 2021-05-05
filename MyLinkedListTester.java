import java.util.*;

public class MyLinkedListTester{

  public static void main(String[]args){

     MyLinkedList<String> listStrings = new MyLinkedList<String>();
     listStrings.addLast("to");
     listStrings.addLast("be");
     listStrings.addLast("or");
     System.out.println(listStrings);

     System.out.println(listStrings.get(0));
     System.out.println(listStrings.get(1));
     System.out.println(listStrings.get(2));

     listStrings.remove("be");
     System.out.println(listStrings); // Expected?

     // // Thanks to generics support, we can create another linked list of integers!
     MyLinkedList<Integer> listInts = new MyLinkedList<Integer>();
     listInts.addFirst(30);
     listInts.addFirst(20);
     listInts.addFirst(10);

     System.out.println(listInts);

     // Now we can iterate using an iterator or a for-each!
     System.out.println("\nPrinting using an iterator (because our LL implements Iterable!):");
     Iterator<Integer> itr = listInts.iterator();
     while(itr.hasNext()){
       System.out.println(itr.next());
     }

  }

}
