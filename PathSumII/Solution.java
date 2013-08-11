// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

// For example:
// Given the below binary tree and sum = 22,
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1
// return

// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]

import java.util.*;

public class Solution {
    // Definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
      if (root == null) {
        return new ArrayList<ArrayList<Integer>>(); //empty list
      }
      // keep a visited table, its value is key node's parent
      Map<TreeNode, TreeNode> table = new HashMap<TreeNode, TreeNode>();
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      table.put(root, null);
      
      DFS(root, sum, table, res);

      return res;
    }

    public void DFS(TreeNode root, int sum, Map<TreeNode, TreeNode> table, List<ArrayList<Integer>> res) {
      //found a leaf node, start backtrack
      if (root.left == null && root.right == null) {
          ArrayList<Integer> path = new ArrayList<Integer>();
          int total = 0;
          while (root != null) {
              total += root.val;
              path.add(0, root.val); // insert from beginning
              root = table.get(root);
          }
          if (total == sum) {
            res.add(path);
          }
          return;
      }
      if(root.left != null) {
        table.put(root.left, root);
        DFS(root.left, sum, table, res);
      }
      if (root.right != null) {
        table.put(root.right, root);
        DFS(root.right, sum, table, res);
      }
    }
 }