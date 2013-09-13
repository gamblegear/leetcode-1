## Problem

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.


## Stop and Think

一个很重要的发现是postorder的最后一个数就是root，然后就可以拿着这个数把inorder分成两半。按照左右子树的数目把postorder也分成两半。

## Solution

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

## Note

- Array.binarySearch
