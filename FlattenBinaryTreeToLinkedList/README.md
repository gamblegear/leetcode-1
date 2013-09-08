## Problem

Flatten Binary Tree to Linked List
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6


## Stop and Think

这题如果不是in-place的话，就可以直接dfs一下，把value读入一个list，然后重建一个linked list。所以不行。

注意到结果实际上是左子树flatten一下，右子树flatten一下，然后把左右子树串起来放在root的右子树下。


## Solution

    public static void flatten(TreeNode root) {
      if (root == null) {
        return;
      }
      
      flatten(root.left);
      flatten(root.right);

      if (root.left == null) {
        return;
      }

      // chain linked list on the right to the left
      TreeNode tn = root.left;
      while (tn.right != null) {
        tn = tn.right;
      }
      tn.right = root.right;

      // reset the left chain to be right chain
      root.right = root.left;
    }

## Note

- If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.