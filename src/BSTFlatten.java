
import java.util.*;

public class BSTFlatten {
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		// Test Case #1
		// 	  3
		// 	 / \
		//  0   0
		BSTNode tree1 = new BSTNode(3);
		tree1.left = new BSTNode(0);
		tree1.right = new BSTNode(0);
		System.out.println("first case: " + sol.distribute(tree1));

		// Test Case #2
		//    0
		//   / \
		//  0   3
		BSTNode tree2 = new BSTNode(0);
		tree2.left = new BSTNode(0);
		tree2.right = new BSTNode(3);
		System.out.println("second case: " + sol.distribute(tree2));

		// Test Case #3
		// 	    0
		// 	   / \
		//    0   1
		//   /   / \
		//  1   1   3
		BSTNode tree3 = new BSTNode(0);
		tree3.left = new BSTNode(0);
		tree3.left.left = new BSTNode(1);
		tree3.right = new BSTNode(1);
		tree3.right.left = new BSTNode(1);
		tree3.right.right = new BSTNode(3);
		System.out.println("third case: " + sol.distribute(tree3));

		// Test Case #4
		// 		    0
		//       / \
		//      0   3
		//     /   / \
		//    0   3   0
		//   /      /  \
		//  0      2    1
		BSTNode tree4 = new BSTNode(0);
		tree4.left = new BSTNode(0);
		tree4.left.left = new BSTNode(0);
		tree4.left.left.left = new BSTNode(0);
		tree4.right = new BSTNode(3);
		tree4.right.left = new BSTNode(3);
		tree4.right.right = new BSTNode(0);
		tree4.right.right.left = new BSTNode(2);
		tree4.right.right.right = new BSTNode(1);
		System.out.println("forth case: " + sol.distribute(tree4));

		// Test Case #5
		// 		    9
		//       / \
		//      0   0
		//     /   / \
		//    0   0   0
		//   /       / \
		//  0       0   0
		BSTNode tree5 = new BSTNode(9);
		tree5.left = new BSTNode(0);
		tree5.left.left = new BSTNode(0);
		tree5.left.left.left = new BSTNode(0);
		tree5.right = new BSTNode(0);
		tree5.right.left = new BSTNode(0);
		tree5.right.right = new BSTNode(0);
		tree5.right.right.left = new BSTNode(0);
		tree5.right.right.right = new BSTNode(0);
		System.out.println("fifth case: " + sol.distribute(tree5));

		// Test Case #6
		// 		      0
		//         / \
		//        0   1
		//       / 
		//      0
		//     /
		//    0 
		//   /
		//  5
		BSTNode tree6 = new BSTNode(0);
		tree6.left = new BSTNode(0);
		tree6.left.left = new BSTNode(0);
		tree6.left.left.left = new BSTNode(0);
		tree6.left.left.left.left = new BSTNode(5);
		tree6.right = new BSTNode(1);
		System.out.println("sixth case: " + sol.distribute(tree6));
	}
}

class BSTNode {
	int val;
	BSTNode left;
	BSTNode right;

	BSTNode(int x) {
		val = x;
	}
}

class Solution {

	int result = 0;

	/**
	   * PURPOSE: this recuirsion method traverses the tree and adds all values to result.  
	   * PARAMETERS: 
	   * 	tree, root of BSTNode.
	   * RETURN VALUES:
	   * 	if the tree is null, return 0. 
	   * 	Otherwise, return current tree's value and left and right side's value -1.
	   */
	public int distributeRecursion(BSTNode tree) {
		if (tree == null)
			return 0;
		int leftNode = distributeRecursion(tree.left);
		int rightNode = distributeRecursion(tree.right);
		result += Math.abs(leftNode) + Math.abs(rightNode);
		return tree.val + leftNode + rightNode - 1;
	}

	/**
	   * PURPOSE: this method calls distributeRecursion method and return the total number of moves to flatten PPEs.
	   * PARAMETERS:
	   *     tree, root of BSTNode.
	   * RETURN VALUES:
	   *     integer result, return the total number of move to flatten PPEs.
	   */
	public int distribute(BSTNode tree) {
		distributeRecursion(tree);
		int result = this.result;
		this.result = 0;
		return result;
	}
}
