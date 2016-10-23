package BST_A2;

public class BST implements BST_Interface {
	public BST_Node root;
	int size;

	public BST() {
		size = 0;
		root = null;
	}

	@Override
	// used for testing, please leave as is
	public BST_Node getRoot() {
		return root;
	}

	@Override
	public boolean insert(String s) {
		// TODO Auto-generated method stub
		if (root == null) {
			root = new BST_Node(s);
			size++;
			return true;
		} else if (root.insertNode(s)) {
			size++;
			return true;

		} else
			return false;
	}

	@Override
	public boolean remove(String s) {
		// TODO Auto-generated method stub
		if (size == 0)
			return false;
		else if (size == 1 && root.data.compareTo(s) == 0) {
			root = null;
			size--;
			return true;
		} else if (size == 1 && root.data.compareTo(s) != 0)
			return false;
		else if (root.removeNode(s)) {
			size--;
			return true;
		} else
			return false;
	}

	@Override
	public String findMin() {
		// TODO Auto-generated method stub
		if (size == 0)
			return null;
		else
			return root.findMin().data;
	}

	@Override
	public String findMax() {
		// TODO Auto-generated method stub
		if (size == 0)
			return null;
		else
			return root.findMax().data;
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public boolean contains(String s) {
		// TODO Auto-generated method stub
		if (root == null)
			return false;
		else
			return root.containsNode(s);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int height() {
		if (size == 0)
			return -1;
		else
			// TODO Auto-generated method stub
			return root.getHeight();
	}

}