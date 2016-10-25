package BST_A2;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;

	BST_Node(String data) {
		this.data = data;
		left = null;
		right = null;
	}

	// --- used for testing ----------------------------------------------
	//
	// leave these 3 methods in, as is

	public String getData() {
		return data;
	}

	public BST_Node getLeft() {
		return left;
	}

	public BST_Node getRight() {
		return right;
	}

	// --- end used for testing -------------------------------------------

	// --- fill in these methods ------------------------------------------
	//
	// at the moment, they are stubs returning false
	// or some appropriate "fake" value
	//
	// you make them work properly
	// add the meat of correct implementation logic to them

	// you MAY change the signatures if you wish...
	// make the take more or different parameters
	// have them return different types
	//
	// you may use recursive or iterative implementations

	public boolean containsNode(String s) {
		int com = this.data.compareTo(s);
		if (com == 0)
			return true;
		else if (com < 0 && right != null) {
			return this.right.containsNode(s);
		} else if (com > 0 && left != null)
			return this.left.containsNode(s);

		else
			return false;

	}

	public boolean insertNode(String s) {
		int com = this.data.compareTo(s);
		if (com == 0)
			return false;
		else if (com < 0) {
			if (right == null)
				right = new BST_Node(s);
			else
				return this.right.insertNode(s);
		} else {
			if (left == null)
				left = new BST_Node(s);
			else
				return this.left.insertNode(s);
		}
		return true;
	}

	public boolean removeNode(String s) {
		int com = this.data.compareTo(s);
		int check = checkS();
		switch (check) {
		case 11:
			if (com == 0) {
				this.data = right.data;

				this.left = right.left;
				this.right = right.right;
				return true;
			} else if (com < 0) {
				if (right.data.compareTo(s) == 0 && right.checkS() == 0) {
					right = null;
					return true;
				} else
					return right.removeNode(s);
			} else
				return false;
		case 10:
			if (com == 0) {
				this.data = left.data;

				this.right = left.right;
				this.left = left.left;
				return true;
			} else if (com > 0) {
				if (left.data.compareTo(s) == 0 && left.checkS() == 0) {
					left = null;
					return true;
				} else
					return left.removeNode(s);

			} else
				return false;
		case 2:
			if (com > 0) {
				if (left.data.compareTo(s) == 0 && left.checkS() == 0) {
					left = null;
					return true;
				} else
					return left.removeNode(s);
			} else if (com < 0) {
				if (right.data.compareTo(s) == 0 && right.checkS() == 0) {
					right = null;
					return true;
				} else
					return right.removeNode(s);
			} else {
				this.data = left.findMax().data;
				if (left.checkS() == 0)
					left = null;
				else
					left.removeNode(data);
				return true;
			}
		}

		return false;

	}

	public BST_Node findMin() {
		if (left == null)
			return this;
		else
			return left.findMin();
	}

	public BST_Node findMax() {
		if (right == null) {
			return this;
		} else
			return right.findMax();
	}

	public int getHeight() {
		int s = checkS();

		if (s == 0)
			return 0;
		else if (s == 10)
			return left.getHeight() + 1;
		else if (s == 11)
			return right.getHeight() + 1;
		else {
			if (right.getHeight() > left.getHeight())
				return right.getHeight() + 1;
			else
				return left.getHeight() + 1;

		}
	}

	private int checkS() {
		if (left != null && right != null) {
			return 2;
		} else if (left != null) {
			return 10;
		} else if (right != null)
			return 11;
		else
			return 0;
	}

	// --- end fill in these methods --------------------------------------

	// --------------------------------------------------------------------
	// you may add any other methods you want to get the job done
	// --------------------------------------------------------------------

	public String toString() {
		return "Data: " + this.data + ", Left: " + ((this.left != null) ? left.data : "null") + ",Right: "
				+ ((this.right != null) ? right.data : "null");
	}
}