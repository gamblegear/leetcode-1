## Problem

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

[link](http://leetcode.com/onlinejudge#question_98)

## Stop and Think

要validate一个BST，除了要左子树和右子树要是BST以外，root的值是左子树的upper bound，是右子树的lower bound，这就提示了我们可以写一个helper method。

## Solution

    public boolean isValidBST(TreeNode root) {
         return isValidBSTWithRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBSTWithRange(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        return root.val >= min &&
                root.val <= max &&
                isValidBSTWithRange(root.left, min, root.val) &&
                isValidBSTWithRange(root.right, root.val, max);
    }

## Note

- 关键是要把BST的概念理解清楚