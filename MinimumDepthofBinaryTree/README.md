## Problem

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

[link](http://leetcode.com/onlinejudge#question_111)

## Stop and Think

从root出发的最小depth应该就是左子树的最小depth和右子树的最小depth的最小值，然后加一。

## Solution

    public int minDepth(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        if (root.left == null && root.right == null) {
        	return 1;
        }
        if (root.left == null) {
        	return minDepth(root.right) + 1;
        }
        if (root.right == null) {
        	return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }


## Note

- 需要考虑只有一个儿子的情况。
