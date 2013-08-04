//Given a binary tree, determine if it is a valid binary search tree (BST).

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
// confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

public class Solution {
    // Definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

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
}