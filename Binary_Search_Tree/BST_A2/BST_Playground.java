
package BST_A2;

import java.util.*;

public class BST_Playground {
	/*
	 * you will test your own BST implementation in here
	 *
	 * we will replace this with our own when grading, and will do what you
	 * should do in here... create BST objects, put data into them, take data
	 * out, look for values stored in it, checking size and height, and looking
	 * at the BST_Nodes to see if they are all linked up correctly for a BST
	 * 
	 */

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		BST t = new BST();
		t.insert("64");
		t.insert("57");
		t.remove("64");
		System.out.println("800".compareTo("57"));

		for (int i = 0; i > -1; i++) {
			String o = keyboard.nextLine();
			if (o.equals("in")) {
				System.out.println(t.insert(keyboard.nextLine()));
			} else if (o.equals("r")) {
				System.out.println(t.remove(keyboard.nextLine()));

			} else if (o.equals("min")) {
				System.out.println(t.findMin());
			} else if (o.equals("max"))
				System.out.println(t.findMax());
			else if (o.equals("e")) {
				System.out.println(t.empty());

			} else if (o.equals("con")) {
				System.out.println(t.contains(keyboard.nextLine()));
			} else if (o.equals("s")) {
				System.out.println(t.size());

			} else if (o.equals("h")) {
				System.out.println(t.height());
			} else if (o.equals("p"))
				print(t);
			else
				return;

		}

		// you should test your BST implementation in here
		// it is up to you to test it rthoroughly and make sure
		// the methods behave as requested above in the interface

		// do not simple depend on the oracle test we will give
		// use the oracle tests as a way of checking AFTER you have done
		// your own testing

		// one thing you might find useful for debugging is a print tree method
		// feel free to use the printLevelOrder method to verify your trees
		// manually
		// or write one you like better
		// you may wish to print not only the node value, and indicators of what
		// nodes are the left and right subtree roots,
		// but also which node is the parent of the current node

	}

	static void printLevelOrder(BST tree) {
		// will print your current tree in Level-Order...
		// https://en.wikipedia.org/wiki/Tree_traversal
		int h = tree.getRoot().getHeight();
		for (int i = 0; i <= h; i++) {
			printGivenLevel(tree.getRoot(), i);
		}

	}

	static void printGivenLevel(BST_Node root, int level) {
		if (root == null)
			return;
		if (level == 0)
			System.out.print(root.data + " ");
		else if (level > 0) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	 static  void print(BST t) {
		if (t.empty())
			return;
		System.out.println(t.getRoot().data);
		
		

	}
}