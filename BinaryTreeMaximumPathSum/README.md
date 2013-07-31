## Problem

Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.

[link](http://leetcode.com/onlinejudge#question_124)

## Stop and Think

对于给定的root来说，最大路径无非两种情况：一种是在左右子树里面，另一种就是经过root（到左儿子的最大路径+到右儿子的最大路径+root）。当你逐层往上算的时候，你肯定需要判断到底是取前者还是后者，这就需要我们要保存这些计算的出来的value。

为此我用了一个`Hashmap`来保存当前`TreeNode`下的最大值`globalMax`。然后可以用一个recursive的method来计算到当前TreeNode下的最大路径。

代码如下。

## Solution

    public int maxPathSum(TreeNode root) {
    
        Map<TreeNode, Integer> globalMax = new HashMap<TreeNode, Integer>();
	
        globalMax.put(null, Integer.MIN_VALUE);
    	
        maxSumPathFromRoot(root, globalMax);
    	
        return globalMax.get(root);
    }

    // return the max sum of a path starting from root
    public int maxSumPathFromRoot(TreeNode root, Map<TreeNode, Integer> globalMax) {
    	
    	if (root == null) {
    		return 0;
    	}

    	int l = maxSumPathFromRoot(root.left, globalMax);
    	int r = maxSumPathFromRoot(root.right, globalMax);

        int c = Math.max(globalMax.get(root.left), globalMax.get(root.right));
        int m = root.val + Math.max(0, l) + Math.max(0, r);
    	globalMax.put(root, Math.max(c, m));

    	return Math.max(0, Math.max(l, r)) + root.val;
    }

## Note

- 需要注意的是，`hashmap`对于null value要提前设置好。
- 需要注意的是，不是所有的node都是positive的，有可能有negative的value，这是本题的一个难点。比如在计算`maxSumPathFromRoot`的时候，要和0比较，因为你可以不选择左右子树而只选择root一个。同样对于`globalMax`的计算也是一样的。


