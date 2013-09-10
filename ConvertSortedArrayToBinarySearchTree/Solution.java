// Given an array where elements are sorted in
// ascending order, convert it to a height balanced BST.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
*/

public class Solution {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		int[] num = { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode root = sortedArrayToBST(num);

		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
	}

    public static TreeNode sortedArrayToBST(int[] num) {
		return sortedArrayToBST(num, 0, num.length - 1);
    }

    public static TreeNode sortedArrayToBST(int[] num, int start, int end) {
    	if (start > end) {
    		return null;
    	}
    	if (start == end) {
    		return new TreeNode(num[start]);
    	}
    	int mid = (start + end) / 2;
    	TreeNode root = new TreeNode(num[mid]);
    	root.left = sortedArrayToBST(num, start, mid-1);
    	root.right = sortedArrayToBST(num, mid+1, end);
    	return root;
    }
}