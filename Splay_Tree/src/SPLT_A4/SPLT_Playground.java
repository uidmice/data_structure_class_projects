package SPLT_A4;

public class SPLT_Playground {
	 public static void main(String[] args){
		    genTest();
		  }
		  
		  public static void genTest(){
		    SPLT tree= new SPLT();
		    tree.insert("B");
		    tree.insert("A");
		    tree.insert("D");
       	   tree.insert("C");
	    tree.insert("E");
		    tree.remove("B");
  	     tree.remove("A");
  	     tree.remove("D");
  	     tree.remove("C");
  	    tree.remove("E");
		    System.out.println("size is "+tree.size());
		    
		    printLevelOrder(tree);
		  }

		    static void printLevelOrder(SPLT tree){ 
		    //will print your current tree in Level-Order...
		    //https://en.wikipedia.org/wiki/Tree_traversal
		    	if(tree.empty()) return;
		      int h=tree.getRoot().getHeight();
		      for(int i=0;i<=h;i++){
		        System.out.print("Level "+i+":");
		        printGivenLevel(tree.getRoot(), i);
		        System.out.println();
		      }
		      
		    }
		    static void printGivenLevel(BST_Node root,int level){
		      if(root==null)return;
		      if(level==0)System.out.print(root.data+"  "+root.getDirection()+" ");
		      else if(level>0){
		        printGivenLevel(root.left,level-1);
		        printGivenLevel(root.right,level-1);
		      }
		    }

}
