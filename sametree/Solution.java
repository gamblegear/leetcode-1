/**
 * Created with IntelliJ IDEA.
 * User: jiezha
 * Date: 7/17/13
 * Time: 8:58 AM
 * To change this template use File | Settings | File Templates.
 *
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */

// Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null) {
            return q == null;
        }

        if (q == null) {
            return p == null;
        }

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
