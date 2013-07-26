## Problem

Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

- [link](http://leetcode.com/onlinejudge#question_100)

## Stop & Think

这题真没啥好说的，就是recursive来解。base condition就是判断null。

比较容易。

## Solution

	public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null) {
            return q == null;
        }

        if (q == null) {
            return p == null;
        }

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

## Note

