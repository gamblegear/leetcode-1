## Problem

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

[link](http://leetcode.com/onlinejudge#question_112)

## Stop and Think

这题比较明显是用`recursive`来解。从`root`出发是否有`sum`的path可以分解成从`root`的左儿子出发是否有`sum-root.val`的path, 或者从`root`的右儿子出发是否有`sum-root.val`的path。

## Solution

    public boolean hasPathSum(TreeNode root, int sum) {
      if (root == null) {
        return false;
      }    
      // leaf node
      if (root.left == null && root.right == null) {
        return sum == root.val;
      }
      return hasPathSum(root.left, sum - root.val) ||
        hasPathSum(root.right, sum - root.val);
    }

## Note

- 注意如果是`root`是`null`并且`sum`是0，这个时候应该是返回`false`。
