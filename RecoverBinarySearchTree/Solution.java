// Two elements of a binary search tree (BST) are swapped by mistake.

// Recover the tree without changing its structure.

// Note:
// A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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
		TreeNode(int x) {
			val = x;
		}
		TreeNode(int x, TreeNode l, TreeNode r) {
			val = x;
			left = l;
			right = r;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2, null,
			new TreeNode(1, null, null));
		recoverTree(root);
		System.out.println(root.val);
		System.out.println(root.right.val);
	}

	static class Tuple<X> {
   		public X first;
   		public X second;
   		public Tuple(X x, X y) {
   			first = x;
   			second = y;
   		}
   }

    public static void recoverTree(TreeNode root) {
    	recoverTreeHelper(root);

    	if(tuples.size() == 1){
    		Tuple<TreeNode> t = tuples.get(0);
    		int temp = t.first.val;
    		t.first.val = t.second.val;
    		t.second.val = temp;
    	}
    	else if (tuples.size() == 2) {
    		Tuple<TreeNode> t1 = tuples.get(0);
    		Tuple<TreeNode> t2 = tuples.get(1);
    		int temp = t1.first.val;
    		t1.first.val = t2.second.val;
    		t2.second.val = temp;
    	}
   }

   private static TreeNode prev = new TreeNode(Integer.MIN_VALUE);
   private static ArrayList<Tuple<TreeNode>> tuples = new ArrayList<Tuple<TreeNode>>();

   private static void recoverTreeHelper(TreeNode root) {
   		if (root == null) {
   			return;
   		}

   		recoverTreeHelper(root.left);
   		if (root.val < prev.val) {
   			Tuple<TreeNode> t = new Tuple<TreeNode>(prev, root);
   			tuples.add(t);
   		}
   		prev = root;

		recoverTreeHelper(root.right);
   }
}