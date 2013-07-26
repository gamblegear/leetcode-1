import java.util.LinkedList;
import java.util.Queue;

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

    // level by level
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> lvl = new LinkedList<Integer>();

        q.add(root);
        lvl.add(0);

        while (!q.isEmpty()){



        }

    }

}