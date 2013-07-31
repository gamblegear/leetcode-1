/*

How to find maximum path sum in a binary tree.

The path need not be a top-bottom, can start and end nodes need not be root 
or leaf, path can start in left/right subtree and end in right/left subtree 
wrt any node.

*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.lang.*; 

public class Solution {
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return MaxPathSum(root, new IntHolder(0));
    }

    public int MaxPathSum(TreeNode root, IntHolder g)
    {
        if (root == null)
        {
            g.val = 0;
            return Integer.MIN_VALUE;
        }

        IntHolder gLeft = new IntHolder(0);
        IntHolder gRight = new IntHolder(0);

        int f = Math.max(MaxPathSum(root.left, gLeft), MaxPathSum(root.right, gRight));
        int res = Math.max(f, root.val + gLeft.val + gRight.val);
        g.val = Math.max(0, root.val + Math.max(gLeft.val, gRight.val));

        return res;
    }

    public class IntHolder
    {
        public int val;
        public IntHolder(int val)
        {
            this.val = val;
        }
    }
}