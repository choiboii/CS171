import java.util.*;

public class Testing{
  public static void main (String args[]){
    ArrayDeque<Integer> arrdq = new ArrayDeque<Integer>();
    ArrayList<Integer> al = new ArrayList<Integer>();
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    LinkedList<Integer> link = new LinkedList<Integer>();

    arrdq.add(2);
    arrdq.addFirst(1);
    arrdq.addLast(3);
    arrdq.remove();

    System.out.println(arrdq);


    al.add(1);
    al.add(2);
    al.add(3);
    al.remove(1);

    System.out.println(al);


    pq.add(1);
    pq.add(2);
    pq.add(3);
    pq.remove();

    System.out.println(pq);


    link.add(1);
    link.add(2);
    link.add(3);
    System.out.println(link.peek());

    System.out.println(link);
  }
}
