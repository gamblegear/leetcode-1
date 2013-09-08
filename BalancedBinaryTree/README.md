## Problem

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


## Stop and Think

从定义出发，左右子树必须是balanced，然后左右子树的depth相差不能1以上。


## Solution

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
        	return true;
        }
        return (isBalanced(root.left) && 
        	isBalanced(root.right) &&
        	Math.abs(getDepth(root.left) -  getDepth(root.right)) <= 1);
    }
	public static int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
	}

## Note

- 如果要优化的话，可以cache 每个node的depth，以防止重复计算。