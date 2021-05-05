/*  This class represents a Playlist of podcast episodes, where each
/*  episode is implemented as an object of type Episode. A user navigating
/*  a Playlist should be able to move between songs using Next or Previous.
/*
/*  To enable flexible navigation, the Playlist is implemented as
/*  a Circular Doubly Linked List where each episode has a link to both
/*  the next and the prev episodes in the list.
/*
/*  Additionally, the last Episode is linked to the head of the list (via next),
/*  and the head of the list is linked to that last Episode (via prev). That said,
/*  there is NO special "last" reference keeping track of the last Episode.
/*  But there is a "head" reference that should always refer to the first Episode.
*/
public class Playlist
{
   private Episode head;
   private int size;

   public Playlist(){
      head = null;
      size = 0;
   }

   public boolean isEmpty()
   { return head == null; }

   // Ensure that "size" is updated properly in other methods, to
   // always reflect the correct number of episodes in the current playlist
   public int getSize()
   { return this.size; }

   // Displays the Episodes starting from the head and moving forward
   // Example code and its expected output:
   /*   Playlist pl = new Playlist();
   /*   pl.addLast("PlanetMoney",26.0);
   /*   pl.addLast("TodayExplained",10);
   /*   pl.addLast("RadioLab",25.5);
   /*   pl.displayPlaylistForward();
   /* [BEGIN] (PlanetMoney|26.0MIN) -> (TodayExplained|10.0MIN) -> (RadioLab|25.5MIN) [END]
   */
   public void displayPlaylistForward()
   {
     String output = "[BEGIN] ";
     Episode current = head;
     if( current != null ){
       while( current.next != head ){
         output += current + " -> ";
         current = current.next;
       }
       output += current + " [END]\n";
     }
     else{
       output += " [END]\n";
     }
     System.out.println(output);
   }

   // Displays the Episodes starting from the end and moving backwards
   // Example code and its expected output:
   /*   Playlist pl = new Playlist();
   /*   pl.addLast("PlanetMoney",26.0);
   /*   pl.addLast("HowIBuiltThis",10);
   /*   pl.addLast("RadioLab",25.5);
   /*   pl.displayPlaylistForward();
   /* [END] (RadioLab|25.5MIN) -> (HowIBuiltThis|10.0MIN) -> (PlanetMoney|26.0MIN) [BEGIN]
   /* (note; the code used is similar to the displayPlaylistForward() method)
   */
   public void displayPlaylistBackward()
   {
     String output = "[END] "; //beginning of output statement
     Episode current = head;
     if( current != null ){ //check for if the list is empty
       while( current.prev != head ){
         output += current + " -> "; //add episode title and length + arrow
         current = current.prev;
       }
       output += current + " [BEGIN]\n"; // ending statement
     }
     else{
       output += " [BEGIN]\n"; //if list is empty, finish with ending statement
     }
     System.out.println(output); //print list
   }

   // Add a new Episode at the beginning of the Playlist
   public void addFirst( String title, double length )
   {
     size++; //increase size to indicate the growth of the list
     if(isEmpty()){
       head = new Episode(title, length, null, null);
       head.next = head;
       head.prev = head;
       return;  //if the list is empty, there is only one object in the list and
     }          //it points to itself.
     else{
       Episode temp = new Episode(title, length, head, head.prev); //create new episode
       head.prev = temp; //reference to last element of the list
       if(temp.prev != null){
          temp.prev.next = temp; //connection from the new object to the last element
       }
       head = temp; //set the new object to be the new head of the list
     }
   }

   // Add a new Episode at the end of the Playlist
   public void addLast( String title, double length )
   {
     addFirst(title, length); //create the object and place in the front
     head = head.next; //shift the head so that the object created becomes the last object on the list
   }

   // Add a new Episode at the given index, assuming that index
   // zero corresponds to the first node
   public void add( String title, double length, int index )
   {
     size++; //increment
     if(index == 0){ //if it is the first node, just use the addFirst() method
       addFirst(title, length);
       return;
     }
     else{
       int i = 0;
       Episode current = head;
       while(i < index){ //traverse the list to the correct place on the list
         if (head.next != null){
           current = head.next;
         }
         i++;
       }
       Episode temp = new Episode(title, length, current, current.prev); //create the object
       current.prev = temp; //connect the object to the node in front
       if(temp.prev != null){
         temp.prev.next = temp; //connect the object to the previous node
       }
     }
   }

   // Delete the first Episode in the Playlist
   public Episode deleteFirst()
   {
     Episode current = head; //peek the first episode
     if(isEmpty()){ //if the list is empty, throw error
       throw new RuntimeException("[Error] Cannot delete episode from an empty Playlist!");
     }
     else if(head.next == head.prev){ //if there is only one object in the list
       size--;                        //return the only object in the list
       head = null;
       return current;
     }
     else{
       size--;
       head.prev.next = head.next;    //connect the last node's next with the second element in the list
       head.next.prev = head.prev;    //connect the second element's prev with the last element in the list
       head = head.next;              //reset the head to be the second element, as the first element is deleted.
     }
     return current; //return the episode deleted
   }

   // Delete the last Episode in the Playlist
   // (There is no special "last" variable in this Playlist;
   // think of alternative ways to find that last Episode)
   public Episode deleteLast()
   {
     head = head.prev; //set the head to be the last element
     Episode deleted = deleteFirst(); //then delete the element
     return deleted;
   }
   // Remove (delete) the Episode that has the given "title"
   // You can assume there will be no duplicate titles in any Playlist
   public Episode deleteEpisode(String title)
   {
     Episode tempHead = head; //set two episode; one to keep track of the original head,
     Episode current = head;  //and one to keep track of where the list is being traversed
     if(isEmpty()){ //if empty, throw error
       throw new RuntimeException("[Error] Cannot delete episode from an empty Playlist!");
     }
     while(current.next != tempHead && !(current.getTitle().equals(title))){ //traverse the list while searching the list
       current = current.next;
     }
     if(!(current.getTitle().equals(title))){ //if the title does not exist in the list, then throw error
       throw new RuntimeException("[Error] Could not find title in the Playlist!");
     }
     head = current; //set new head
     Episode deleted = deleteFirst(); //use deleteFirst() method based on new head
     if(tempHead != current){ //check if the head is gone; if it is, reset
       head = tempHead;
     }
     return deleted; //return the deleted episode from line 184
   }

   // Remove (delete) every m-th Episode in the user's circular Playlist,
   // until only one Episode survives. Return the survived Episode.
   public Episode deleteEveryMthEpisode(int m)
   {
     Episode current = head.prev; //start from the last element to ensure continuity in the while loop ahead (line 198);
     while(size > 1){ //go until there is only one element left in the list
       int i = 0; //reset counter for the while loop in the next line (line 198)
       while(i < m){ //traverse the list based on int m
         current = current.next;
         i++;
       }
       current.prev.next = current.next; //deletion algorithm;
       current.next.prev = current.prev;
       current = current.next.prev;
       size--;
     }
     head = current; //reset head after the entire deletion process
     return current; //return the survived episode
   }

} // End of Playlist class
