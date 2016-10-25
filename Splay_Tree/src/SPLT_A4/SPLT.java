package SPLT_A4;

import SPLT_A4.BST_Node.Direction;

public class SPLT implements SPLT_Interface {
	private BST_Node root;
	private int size;

	public SPLT() {
		this.size = 0;
	}

	public BST_Node getRoot() {
		return root;
	}

	@Override
	public void insert(String s) {
		if (root == null) {
			root = new BST_Node(s,null,BST_Node.Direction.NO);
			size++;
			root.justMade = false;
		} else {
			root=root.insertNode(s);
			if (root.justMade) {
				size++;
				root.justMade = false;
			}
		}
	}

	@Override
	public void remove(String s) {
		if (root == null)
			return;

		root=root.containsNode(s);
		if (!root.data.equals(s))
			return;

		BST_Node r = root.right;
		BST_Node l = root.left;
		
		if(l==null && r==null) {
			root=null;
			size=0;
			return;
		}
		if(l==null) {
			root=r;
			root.par=null;
			root.dir=Direction.NO;
			size--;
			return;
		}
		
		l=l.findMax();
		l.right = r;
		l.dir=Direction.NO;
		if (r!=null) 
			r.par=l;
		root = l;
		size--;

	}

	@Override
	public String findMin() {
		if (root == null)
			return null;
		root =root.findMin();
		return root.data;
	}

	@Override
	public String findMax() {
		// TODO Auto-generated method stub
		if (root == null)
			return null;
		root=root.findMax();
		return root.data;
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		if (root == null)
			return true;
		return false;
	}

	@Override
	public boolean contains(String s) {
		if (root == null)
			return false;

		root=root.containsNode(s);
		if (!root.data.equals(s))
			return false;
		return true;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return root.getHeight();
	}

}
