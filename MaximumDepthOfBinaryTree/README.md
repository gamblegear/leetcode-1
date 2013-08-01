## Problem

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

[link](http://leetcode.com/onlinejudge#question_104)

## Stop and Think

1. base case：null的depth是0
2. 左右子树的maxDepth取其大者再加一

## Solution

    public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}   	
		return Math.max(maxDepth(root.left), 
			maxDepth(root.right)) + 1;
    }

## Note

- `O(n)`，n是节点数。