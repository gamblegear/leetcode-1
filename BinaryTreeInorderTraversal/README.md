## Problem

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


## Stop and Think

既然说recursion是trivial，那我们就用iterative来做。

recursion意味着stack，从root进入栈顶开始，如果左边还有值，把当前节点和左儿子亚金栈内。如果左边没有值了，或者之前访问过，我们就访问访问这个当前节点，然后把右儿子给压进栈。

## Solution

    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
        	return new ArrayList<Integer>(); // empty
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        stack.push(root);
        HashSet<TreeNode> visited = new HashSet<TreeNode>();
        while (!stack.empty()) {
        	TreeNode t = stack.pop();
        	if (t.left == null || visited.contains(t.left)) {
        		visited.add(t);
        		res.add(t.val);
        		if (t.right != null) {
        			stack.push(t.right);
        		}
        	}
        	else {
        		stack.push(t);
        		stack.push(t.left);
        	}
        }
        return res;
    }

## Note

- 需要store一个hashset来保存已访问节点的list。
