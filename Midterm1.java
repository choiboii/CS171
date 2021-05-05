import java.util.*;


public class Midterm1{
  public static void main (String args[]){
    int[] test = {1,2,3,4,5};
    System.out.print(Arrays.toString(topN(test,2)));
  }

  public static int[] topN(int[] integers, int count){
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    int[] result = new int[count];

    for(int i = 0; i < integers.length; i++){
      pq.add(integers[i]);
    }
    for(int j = 0; j < integers.length - count; j++){
      pq.remove();
    }

    for(int k = 0; k < count; k++){
      result[k] = (Integer)pq.poll();
    }
    return result;
  }
}
