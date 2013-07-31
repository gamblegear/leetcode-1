// Given a binary tree, find the maximum path sum.
// The path may start and end at any node in the tree.

// For example:
// Given the below binary tree,

//        1
//       / \
//      2   3
// Return 6.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public int maxPathSum(TreeNode root) {
		Map<TreeNode, Integer> globalMax = 
								new HashMap<TreeNode, Integer>();
		globalMax.put(null, Integer.MIN_VALUE);
    	maxSumPathFromRoot(root, globalMax);
    	return globalMax.get(root);
    }

    // return the max sum of a path starting from root
    public int maxSumPathFromRoot(TreeNode root, 
    							Map<TreeNode, Integer> globalMax) {
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
}