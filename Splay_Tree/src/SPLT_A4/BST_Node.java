package SPLT_A4;


public class BST_Node {
	enum Direction {
		LEFT, RIGHT, NO
	};

	String data;
	BST_Node left;
	BST_Node right;
	BST_Node par; 
	boolean justMade; 
	Direction dir;

	BST_Node(String data) {
		this.data = data;
		this.justMade = true;
	}

	BST_Node(String data,  BST_Node par, Direction dir) { 
		this.data = data;
		this.par = par;
		this.justMade = true;
		this.dir = dir;
	}


	public String getData() {
		return data;
	}

	public BST_Node getLeft() {
		return left;
	}

	public BST_Node getRight() {
		return right;
	}

	public BST_Node containsNode(String s) {
		int com = this.data.compareTo(s);
		if (com == 0){
			splay(this);
			return this;
		}
		else if (com < 0 && right != null) {
			
			return this.right.containsNode(s);
			
		} else if (com > 0 && left != null)
			return this.left.containsNode(s);

		else{
			splay(this);
			return this;
		}
			
	} 

	public BST_Node insertNode(String s) {
		int com = this.data.compareTo(s);
		if (com == 0){
			splay(this);
			return this;
		}
			
		else if (com < 0) {
			if (right == null)
				{right = new BST_Node(s,this,Direction.RIGHT);
				BST_Node t=this.right;
				splay(t);
				return t;
				}
			else
				return this.right.insertNode(s);
		} else {
			if (left == null)
				{left = new BST_Node(s,this,Direction.LEFT);
				BST_Node t=this.left;
				splay(t);
				return t;
				}
			else
				return this.left.insertNode(s);
		}
		
	} 


	public BST_Node findMin() {
		if(left!=null) {
			BST_Node min=left.findMin();
			splay (min,this);
			return min;
		}
		return this;
	}

	public BST_Node findMax() {
		if(right!=null){
			BST_Node max=right.findMax();
			splay(max,this);
			return max;
		}
		return this;
	}

	public int getHeight() {
		int l=0;
		int r=0;
		if(left!=null)l+=left.getHeight()+1;
		if(right!=null)r+=right.getHeight()+1;
		return Integer.max(l, r);
	}
	private void splay(BST_Node X) {
		
		if (X.dir == Direction.NO)
			return;
			

		BST_Node Y = X.par;
		if (Y.dir == Direction.NO) {
			if (X.dir == Direction.RIGHT)
				rotateLeft(X);
			else
				rotateRight(X);
			return;
		}

		if (Y.dir == Direction.RIGHT) {
			if (X.dir == Direction.RIGHT) {
				rotateLeft(Y);
				rotateLeft(X);
			} else {
				rotateRight(X);
				rotateLeft(X);
			}

		} else {
			if (X.dir == Direction.RIGHT) {
				rotateLeft(X);
				rotateRight(X);
			} else {
				rotateRight(Y);
				rotateRight(X);
			}

		}
		
		splay(X);

	}

	private void splay(BST_Node X, BST_Node to) {
		Direction t=to.dir;
		to.dir=Direction.NO;
		if (X.dir == Direction.NO)
			{X.dir=t;
			return;
			}

		BST_Node Y = X.par;
		if (Y.dir == Direction.NO) {
			if (X.dir == Direction.RIGHT)
				rotateLeft(X);
			else
				rotateRight(X);
			X.dir=t;
			return;
		}

		if (Y.dir == Direction.RIGHT) {
			if (X.dir == Direction.RIGHT) {
				rotateLeft(Y);
				rotateLeft(X);
			} else {
				rotateRight(X);
				rotateLeft(X);
			}

		} else {
			if (X.dir == Direction.RIGHT) {
				rotateLeft(X);
				rotateRight(X);
			} else {
				rotateRight(Y);
				rotateRight(X);
			}

		}
		
		splay(X,to);

	}

	private void rotateRight(BST_Node X) {
		BST_Node Y = X.par;
		if (Y.par == null) {
			X.par = null;
			X.dir = Direction.NO;
		} else {
			BST_Node Z = Y.par;
			X.dir = Y.dir;
			X.par = Z;
			if (Y.dir == Direction.LEFT)
				{Z.left = X;
				}
			else
				{Z.right = X;
				}
		}
		Y.dir = Direction.RIGHT;
		Y.par = X;
		Y.left = X.right;
		if (Y.left!=null) {
			Y.left.dir=Direction.LEFT;
			Y.left.par=Y;
		}
		X.right = Y;
	}

	private void rotateLeft(BST_Node X) {
		BST_Node Y = X.par;
		if (Y.par == null) {
			X.par = null;
			X.dir = Direction.NO;
		} else {
			BST_Node Z = Y.par;
			X.dir = Y.dir;
			X.par = Z;
			if (Y.dir == Direction.LEFT)
				Z.left = X;
				
			else
				Z.right = X;
				
		}
		Y.dir = Direction.LEFT;
		Y.par = X;
		Y.right = X.left;
		if (Y.right!=null) {
			Y.right.dir=Direction.RIGHT;
			Y.right.par=Y;
		}
		X.left = Y;
	}
	
	private void setRight(BST_Node X){
		this.right=X;
		X.dir=Direction.RIGHT;
		X.par=this;
	}
	
	private void setLeft(BST_Node X){
		this.left=X;
		X.dir=Direction.LEFT;
		X.par=this;
	}
	
	public String getDirection (){
		if (dir==Direction.NO) return "NO";
		else if (dir==Direction.LEFT) return "LEFT";
		else return "RIGHT";
	}



}