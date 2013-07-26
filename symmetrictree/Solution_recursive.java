/**
 * Created with IntelliJ IDEA.
 * User: zeiga
 * Date: 7/25/13
 * Time: 8:49 PM
 * To change this template use File | Settings | File Templates.
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 *  For example, this binary tree is symmetric:
 *
 *       1
 *     / \
 *    2   2
 *   / \ / \
 *  3  4 4  3
 * But the following is not:
 *
 *       1
 *     / \
 *    2   2
 *    \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 **/

//Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
   }

    public boolean isMirror(TreeNode first, TreeNode second) {
        if (first == null) {
            return second == null;
        }
        if (second == null) {
            return first == null;
        }
        return (first.val == second.val) && isMirror(first.left, second.right) && isMirror(first.right, second.left);
    }
}