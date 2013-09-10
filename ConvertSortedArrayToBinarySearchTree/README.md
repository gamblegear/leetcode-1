## Problem

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

## Stop and Think

就跟sortedListToBST的思想一样，二分加上recursion。

## Solution

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

## Note