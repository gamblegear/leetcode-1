// Given a binary tree, determine if it is height-balanced.

// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.lang.Math;

public class Solution {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		TreeNode(int x, TreeNode l, TreeNode r) {
			val = x;
			left = l;
			right = r;
		}
	}

	public static void main(String[] args) {
		//     a
		//    / \
		//   b   c
		//  / \ 
		// d  e 
		TreeNode a = new TreeNode(1, 
			new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), 
			new TreeNode(3, null, null));

		System.out.println(isBalanced(a));

		//     a
		//    / 
		//   b   
		//  / \ 
		// d  e 
		TreeNode a1 = new TreeNode(1, 
			new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), 
			null);

		System.out.println(isBalanced(a1));
	}

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
        	return true;
        }

        return (isBalanced(root.left) && 
        	isBalanced(root.right) &&
        	Math.abs(getDepth(root.left) -  getDepth(root.right)) <= 1);
    }

	public static int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
	}
}