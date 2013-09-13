// Given preorder and inorder traversal of a tree, construct the binary tree.

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
		TreeNode(int x, TreeNode l, TreeNode r) {
			val = x;
			left = l;
			right = r;
		}
	}
	public static void main(String[] args) {
		int[] preorder = {7, 1, 0, 3, 2, 5, 4, 6, 9, 8, 10};
		int[] inorder  = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = buildTree(preorder, inorder);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
	}
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
        	return null;
        }
        if (preorder.length == 1) {
        	return new TreeNode(preorder[0], null, null);
        }
        int rootVal = preorder[0];
        int index = Arrays.binarySearch(inorder, rootVal);
        int leftLen = index;
        int rightLen = inorder.length - 1 - index;

        int[] leftPreorder = new int[leftLen];
        int[] leftInorder = new int[leftLen];
        int[] rightPreorder = new int[rightLen];
        int[] rightInorder = new int[rightLen];
        for(int i=0; i < leftLen; i++) {
        	leftPreorder[i] = preorder[1+i];
        }
        for(int i=0; i < rightLen; i++) {
        	rightPreorder[i] = preorder[1 + i + leftLen];
        }
        for(int i=0; i < leftLen; i++) {
        	leftInorder[i] = inorder[i];
        }
        for(int i=0; i < rightLen; i++) {
        	rightInorder[i] = inorder[1 + i + leftLen];
        }
        return new TreeNode(rootVal, 
        	buildTree(leftPreorder, leftInorder),
        	buildTree(rightPreorder, rightInorder));
    }
}