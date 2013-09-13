## Problem

Given preorder and inorder traversal of a tree, construct the binary tree.

Note: You may assume that duplicates do not exist in the tree.

## Stop and Think

此题与[前一题](https://github.com/zeiga/leetcode/tree/master/ConstructBinaryTreeFromInorderAndPostorderTraveral)非常类似，关键的观察就是preorder的第一个数是root，剩下的就是分组recursion了。

## Solution

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

## Note

