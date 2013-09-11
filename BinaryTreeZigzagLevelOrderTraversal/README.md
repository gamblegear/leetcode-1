## Problem

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]

## Stop and Think

所谓zigzag就是level order traversal的变体，先从左到右，然后从右到左，然后循环。

## Solution


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

## Note

- 代码应该可以更refactor一些。