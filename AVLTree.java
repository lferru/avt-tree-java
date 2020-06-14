/** Luis Ferrufino
  * AVL Tree Practice
  * 6/7/2020
  * AVLTree.java
  */
 
import java.util.List;
import java.util.ArrayList; 
  
public class AVLTree {

   private AVLNode root;
   
   public AVLTree() {
   
      root = null;
   }
   
   public AVLTree(int startingData) {
   
      root = new AVLNode(startingData, null, null);
   }
   
   public int getHeight() {
   
      return root.getHeight();
   }
   
   public void insert(int num) {
   
      AVLNode tempNode = root;
      AVLNode tempParent = null;
      AVLNode newNode = new AVLNode(num, null, null); //our goal is to put this guy in his proper place.
      List<AVLNode> path = new ArrayList<AVLNode>(); //after while-loop, root will be at end of the list.
      
      if ( root == null ) { //in the case of the empty tree
      
         root = newNode;
         return;
      }
      
      while ( tempNode != null ) { //post-condition: tempParent will be the parent of the new node.
      
         tempParent = tempNode;
         path.add(0, tempParent);
         
         if ( num < tempNode.getKey() ) tempNode = tempNode.getLeftChild();
         else tempNode = tempNode.getRightChild();
      }
      
      newNode = new AVLNode(num, null, null);
      
      if ( num < tempParent.getKey() ) tempParent.setLeftChild(newNode);
      else tempParent.setRightChild(newNode);
      
      //we have inserted the newNode. now we need to do some balancing (if needed):
      
      //TODO: don't forget to write results back into parent (or root)
      System.out.println("* " + root.getHeight() + " " + root.getLeftChildHeight() + " " + root.getRightChildHeight()
       + " " + root.getLeftRightHeight() + " " + root.getRightLeftHeight());
      
      for ( int i = 0; i < path.size(); i++ ) {
      
         AVLNode pathNode = path.get(i);
         AVLNode newAnchor;
         boolean wasOnLeft = false;
         
         if ( i != path.size() - 1 ) wasOnLeft = pathNode == path.get(i + 1).getLeftChild() ? true : false;
         
         if ( pathNode.isImbalanced() ) {
            
            if ( pathNode.getLeftChildHeight() - pathNode.getRightChildHeight() > 0 ) {
            
               //wasOnLeft = true;
            
               if ( pathNode.getLeftLeftHeight() - pathNode.getLeftRightHeight() > 0 ) //the left-left case
               
                  newAnchor = rightRotate(pathNode);
               else newAnchor = leftRightRotate(pathNode); //the left-right case
            } else {
            
               //wasOnLeft = false;
               if ( pathNode.getRightRightHeight() - pathNode.getRightLeftHeight() > 0 ) // the right-right case
               
                  newAnchor = leftRotate(pathNode);
               else newAnchor = rightLeftRotate(pathNode); //the right-left case
            }
               
            if ( i == path.size() - 1 ) root = newAnchor;
           
            else 
            
               if ( wasOnLeft ) path.get(i + 1).setLeftChild(newAnchor);
               
               else path.get(i + 1).setRightChild(newAnchor);
            break; //one rotation should suffice.
         }
      }
      
   }
   
   public AVLNode leftRotate(AVLNode anchor) { //solves the right-right case
   
      AVLNode newAnchor = anchor.getRightChild();
      AVLNode middleSubtree = newAnchor.getLeftChild();
      anchor.setRightChild(middleSubtree);
      newAnchor.setLeftChild(anchor);
      return newAnchor;
   }
   
   public AVLNode rightRotate(AVLNode anchor) { //solves the left-left case
   
      AVLNode newAnchor = anchor.getLeftChild();
      AVLNode middleSubtree = newAnchor.getRightChild();
      anchor.setLeftChild(middleSubtree);
      newAnchor.setRightChild(anchor);
      return newAnchor;
   }
   
   public AVLNode leftRightRotate(AVLNode anchor) { //solves the left-right case
   
      anchor.setLeftChild(leftRotate(anchor.getLeftChild()));
      return rightRotate(anchor);
   }
   
   public AVLNode rightLeftRotate(AVLNode anchor) { //solves the right-left case
   
      anchor.setRightChild(rightRotate(anchor.getRightChild()));
      return leftRotate(anchor);
   }
   
   public String toString() {
   
      String output = root.getTreeString(1);
      int ind = output.lastIndexOf("┣");
      return getHeight() > 1 ? output.substring(0, ind) + "┗" + output.substring(ind + 1) : output;
   }
}