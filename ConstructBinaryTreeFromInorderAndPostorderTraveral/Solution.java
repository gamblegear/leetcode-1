// Given inorder and postorder traversal of a tree, construct the binary tree.

// Note:
// You may assume that duplicates do not exist in the tree.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
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
		// take this example:
		// http://datastructuresnotes.blogspot.com/2009/02/binary-tree-traversal-preorder-inorder.html
		int[] inorder = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] postorder = { 0, 2, 4, 6, 5, 3, 1, 8, 10, 9, 7 };
		TreeNode root = buildTree(inorder, postorder);

		System.out.println("Root: " + root.val);
		System.out.println("Left: " + root.left.val);
		System.out.println("Right: " + root.right.val);
	}

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0) {
			return null;
		}
		if (inorder.length == 1) {
			return new TreeNode(inorder[0]);
		}
		int rootVal = postorder[postorder.length - 1];
		int index = Arrays.binarySearch(inorder, rootVal);
		int leftLen = index;
		int rightLen = inorder.length - index - 1;

		int[] leftInorder = new int[leftLen];
		int[] rightInorder = new int[rightLen];
		int[] leftPostorder = new int[leftLen];
		int[] rightPostorder = new int[rightLen];
		for(int i=0; i < leftLen; i++) {
			leftInorder[i] = inorder[i];
		}
		for(int i=0; i < rightLen; i++) {
			rightInorder[i] = inorder[i + leftLen + 1];
		}
		for(int i=0; i < leftLen; i++) {
			leftPostorder[i] = postorder[i];
		}
		for(int i=0; i < rightLen; i++) {
			rightPostorder[i] = postorder[i + leftLen];
		}
		return new TreeNode(rootVal, 
			buildTree(leftInorder, leftPostorder),
			buildTree(rightInorder, rightPostorder));
    }
}