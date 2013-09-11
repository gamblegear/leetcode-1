// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

// For example:
// Given binary tree {3,9,20,#,#,15,7},

//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its zigzag level order traversal as:

// [
//   [3],
//   [20,9],
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
      TreeNode(int x) { val = x; }
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

      ArrayList<ArrayList<Integer>> res = zigzagLevelOrder(root);

      for (ArrayList<Integer> level : res) {
          for (Integer i : level) {
            System.out.print(i + ",");
          }
          System.out.println();
      }
    }

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      if (root == null) {
        return res;
      }
      Queue<TreeNode> q = new LinkedList<TreeNode>();
      HashMap<TreeNode, Integer> levels = new HashMap<TreeNode, Integer>();
      q.offer(root);
      levels.put(root, 0);

      while (!q.isEmpty()) {
        TreeNode t = q.poll();
        int level = levels.get(t);

        if (res.size() == level) {
          ArrayList<Integer> arr = new ArrayList<Integer>();
          arr.add(t.val);
          res.add(arr);
        }
        else {
          ArrayList<Integer> arr = res.get(level);
          arr.add(t.val);
        }

        if (level % 2 == 0) {
          if (t.right != null) {
            q.offer(t.right);
            levels.put(t.right, level+1);
          }
          if (t.left != null) {
            q.offer(t.left);
            levels.put(t.left, level+1);
          }
        }
        else {
          if (t.left != null) {
            q.offer(t.left);
            levels.put(t.left, level+1);
          }
          if (t.right != null) {
            q.offer(t.right);
            levels.put(t.right, level+1);
          }
        }
      }
      return res;
    }
}