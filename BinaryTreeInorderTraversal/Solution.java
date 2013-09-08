// Given a binary tree, return the inorder traversal of its nodes' values.
// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [1,3,2].

// Note: Recursive solution is trivial, could you do it iteratively?
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
		TreeNode(int x, TreeNode l, TreeNode r) {
			val = x;
			left = l;
			right = r;
		}
	}

	public static void main(String[] args) {
		//    1
		//     \
		//      2
		//     /
		//    3
		//     \
		//      4
		TreeNode root = new TreeNode(1, 
			null,
			new TreeNode(2, new TreeNode(3, null, new TreeNode(4, null, null)), null));

		ArrayList<Integer> res = inorderTraversal(root);
		for (Integer i : res) {
			System.out.println(i);
		}
	}

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
}