// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
// For example:
// Given binary tree {3,9,20,#,#,15,7},
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]
// confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

public class Solution {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x, TreeNode l, TreeNode r) {
        val = x;
        left = l;
        right = r;
      }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, 
          new TreeNode(9, null, null), 
          new TreeNode(20, 
            new TreeNode(15, null, null),
            new TreeNode(7, null, null)));
        ArrayList<ArrayList<Integer>> res = levelOrder(root);
        for (ArrayList<Integer> lvl : res) {
          for (Integer i : lvl) {
            System.out.print(i + ",");
          }
          System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
      if (root == null) {
        return new ArrayList<ArrayList<Integer>>();
      }

      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      HashMap<TreeNode, Integer> levels = new HashMap<TreeNode, Integer>();
      Queue<TreeNode> q = new LinkedList<TreeNode>();
      q.offer(root);
      levels.put(root, 0);

      while (!q.isEmpty()) {
        TreeNode t = q.poll();
        int currLevel = levels.get(t);
        if (res.size() <= currLevel) {
          ArrayList<Integer> arr = new ArrayList<Integer>();
          arr.add(t.val);
          res.add(arr);
        }
        else {
          ArrayList<Integer> arr = res.get(currLevel);
          arr.add(t.val);
        }

        if (t.left != null) {
          q.offer(t.left);
          levels.put(t.left, currLevel+1);
        }
        if (t.right != null) {
          q.offer(t.right);
          levels.put(t.right, currLevel+1);
        }
      }
      return res;
    }
}