import java.util.*;

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
 *    \    \
 *     3    3
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
        Queue<TreeNode> nodesQueue = new LinkedList<TreeNode>();
        Queue<Integer> levelsQueue = new LinkedList<Integer>();

        nodesQueue.offer(root);
        levelsQueue.offer(0); //Start from zero

        int currLevel = 0;
        while (!nodesQueue.isEmpty()){
            List<Integer> levelNums = new ArrayList<Integer>();
            int l;
            do {
                TreeNode t = nodesQueue.poll();
                l = levelsQueue.poll();

                if (t == null) {
                    levelNums.add(0);
                }
                else {
                    levelNums.add(t.val);

                    nodesQueue.offer(t.left);
                    levelsQueue.offer(currLevel+1);
                    nodesQueue.offer(t.right);
                    levelsQueue.offer(currLevel+1);
                }
            } while (!nodesQueue.isEmpty() && levelsQueue.peek() == currLevel);

            if (!isListSymmetric(levelNums)) {
                return false;
            }
            currLevel++;
        }
        return true;
    }

    public boolean isListSymmetric(List<Integer> list) {
        int s = 0, e = list.size() - 1;
        while (s <= e) {
            if (list.get(s) != list.get(e)) {
                return false;
            }
            s++;e--;
        }
        return true;
    }
}