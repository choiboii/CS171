/* THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
Andrew Choi */

import java.util.Stack;

public class KnightTour {

    /* a Knight Tour's solution for an n*n chess board
    * @param n size of the board
    * @return KnightBoard object with a valid Knight Tour
    */
    public static KnightBoard tour(int n){
      //use a stack to keep track of all possible knight moves on the board.
      Stack<KnightBoard> candidates = new Stack<KnightBoard>();
      KnightBoard kb = new KnightBoard(n); // create initial board of size n*n
      candidates.push(kb); // push the initial board onto the stack

      KnightBoard output = kb;  //set a default board to use in case stack
                                //becomes completely empty

      while (!candidates.empty()){ //account for EmptyStackError
        KnightBoard temp = candidates.pop(); //remove the top board
        if (temp.getMoveCount() == n*n){  //if the knight has traveled to each
          return temp;                    //space possible, return the board.
        }
        if (temp.getMoveCount() > output.getMoveCount()) { //update the default
            output = temp;                                 //board
        }

        int[] dx = {-2,-1,1,2,2,1,-1,-2}; //arrays that correlate to all 8
        int[] dy = {-1,-2,-2,-1,1,2,2,1}; //possible movements of the knight

        for (int i = 0; i < 8; i++) { //iterative loop to test each move
          int newX = temp.getCurrentX() + dx[i]; //new coordinates
          int newY = temp.getCurrentY() + dy[i];
          KnightBoard newPos = temp.copyBoard(); //create copy of board

          if (newPos.move(newX, newY)) { //if the move is valid, push the
            candidates.push(newPos);   //board on to the stack
          }
        }
      }

      return output;  //in case stack becomes empty, return the updated default
                      //board.
    }



    public static void main(String[] args) {
      int n = 6; // default board size if user didn't specify
      // pass in parameter n from command line
      if (args.length == 1) {
        n = Integer.parseInt(args[0].trim());
        if (n < 3) {
          System.out.println("Incorrect parameter (n must be >= 3)");
          System.exit(-1);
        }
      }
      long startTime = System.nanoTime();
      KnightBoard winner = KnightTour.tour(n);
      long endTime = System.nanoTime();
      double delta = (endTime - startTime) / 1e6;
      // Display the solution you discovered:
      System.out.println("\nPossible Knight Tour with max #squares visited in this ("+n+"x" +n+") board:");
      winner.printChessBoard();
      System.out.println("\n(Time to find this solution = " + delta + " milliseconds)");
    }
}
