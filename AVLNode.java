/** Luis Ferrufino
  * AVL Tree Practice
  * 6/7/2020
  * AVLNode.java
  */

public class AVLNode {

   private int datum;
   private AVLNode leftChild, rightChild;
   
   public AVLNode(int d, AVLNode l, AVLNode r) {
   
      datum = d;
      leftChild = l;
      rightChild = r;
   }
   
   public int getHeight() {
   
      int leftSubtreeHeight, rightSubtreeHeight;
   
      if ( leftChild == null ) leftSubtreeHeight = 0;
      else leftSubtreeHeight = leftChild.getHeight();
      
      if ( rightChild == null ) rightSubtreeHeight = 0;
      else rightSubtreeHeight = rightChild.getHeight();
      
      return 1 + ( leftSubtreeHeight > rightSubtreeHeight ? leftSubtreeHeight : rightSubtreeHeight );
   }
   
   public String getTreeString(int currDepth) {
   
      //returns a string representation of the tree. done via pre-order traversal.
   
      String output = "";
      
      for ( int i = currDepth; i > 1; i-- ) {
      
         if ( i == currDepth ) output += "┣━━";
         else output += "━━━";
      }
      output += datum + "\n";
      
      if ( leftChild != null ) output += leftChild.getTreeString(currDepth + 1);
      
      if ( rightChild != null ) output += rightChild.getTreeString(currDepth + 1);
      
      return output;
   }
   
   public int getKey() {
   
      return datum;
   }   
   
   public AVLNode getLeftChild() {
   
      return leftChild;
   }
   
   public AVLNode getRightChild() {
   
      return rightChild;
   }
   
   public void setLeftChild(AVLNode l) {
   
      leftChild = l;
   }
   
   public void setRightChild(AVLNode r) {
   
      rightChild = r;
   }
   
   public boolean isImbalanced() {
   
      if ( Math.abs(getLeftChildHeight() - getRightChildHeight()) > 1 ) return true;
      else return false;
   }
   //idea: refactor code to depend more on the following two methods
   public int getLeftChildHeight() {
   
      if ( leftChild == null ) return 0;
      else return leftChild.getHeight();
   }
   
   public int getRightChildHeight() {
   
      if ( rightChild == null ) return 0;
      else return rightChild.getHeight();
   } 
   
   //idea: unify some of these methods into one command with different behaviours given different arguments
   public int getLeftLeftHeight() {
   
      if ( leftChild == null ) return 0;
      if ( leftChild.leftChild == null ) return 0;
      else return leftChild.leftChild.getHeight();
   }
   
   public int getLeftRightHeight() {
   
      if ( leftChild == null ) return 0;
      if ( leftChild.rightChild == null ) return 0;
      else return leftChild.rightChild.getHeight();
   }
   
   public int getRightRightHeight() {
   
      if ( rightChild == null ) return 0;
      if ( rightChild.rightChild == null ) return 0;
      else return rightChild.rightChild.getHeight();
   }
   
   public int getRightLeftHeight() {
      
      if ( rightChild == null ) return 0;
      if ( rightChild.leftChild == null ) return 0;
      else return rightChild.leftChild.getHeight();
   
   }
} 