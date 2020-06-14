/** Luis Ferrufino
  * AVL Tree Practice
  * 6/7/2020
  * AVLRun.java
  */

import java.util.Scanner;

public class AVLRun {

   public static void main(String[] args) {
   
      /*AVLTree myTree = new AVLTree(2);
      
      myTree.insert(3);
      myTree.insert(9);
      myTree.insert(1);
      System.out.println("\n" + myTree);
      myTree.insert(4);
      System.out.println("\n" + myTree);
      myTree.insert(5);
      //myTree.insert(20);
      //myTree.insert(13);
      //myTree.insert(17);
      
      System.out.println("This AVL Tree has a height of " + myTree.getHeight());
      System.out.println("\n" + myTree);*/
      int ans = 0;
      Scanner keyb = new Scanner(System.in);
      AVLTree myTree = null;
      
      while ( ans != -1 ) {
      
         if ( ans == 0 ) {
         
            System.out.print("Please enter a new number: ");
            ans = keyb.nextInt();
            
            if ( myTree == null ) myTree = new AVLTree(ans);
            else myTree.insert(ans);
         } else if ( ans == 1 ) {
         
            System.out.println("\n" + myTree);
            
         }
         System.out.print("\nEnter 0 to add a node, 1 to print tree, or -1 to quit: ");
         ans = keyb.nextInt();
      }
         
   }
}