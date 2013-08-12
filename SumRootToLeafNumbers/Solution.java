// Given a binary tree containing digits from 0-9 only, 
// each root-to-leaf path could represent a number.

// An example is the root-to-leaf path 1->2->3 which represents 
// the number 123.

// Find the total sum of all root-to-leaf numbers.

// For example,

//     1
//    / \
//   2   3
// The root-to-leaf path 1->2 represents the number 12.
// The root-to-leaf path 1->3 represents the number 13.

// Return the sum = 12 + 13 = 25.

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
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public int sumNumbers(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}    
    	Map<TreeNode, TreeNode> table = new HashMap<TreeNode, TreeNode>();
    	ArrayList<Long> subTotals = new ArrayList<Long>();
    	table.put(root, null);
    	DFS(root, table, subTotals);

    	long total = 0;
    	for(int i=0; i < subTotals.size(); i++) {
    		total += subTotals.get(i);
    	}
    	return (int) total;
    }

    public void DFS(TreeNode root, Map<TreeNode, TreeNode> table, ArrayList<Long> subTotals) {
		  //found a leaf node, start backtrack
		  if (root.left == null && root.right == null) {
		      long subtotal = 0;
		      int weight = 1;
		      while (root != null) {
		          subtotal = subtotal +  weight * root.val;
		          root = table.get(root);
		          weight *= 10;
		      }
		      subTotals.add(subtotal);
		      return;
		  }
		  if(root.left != null) {
		    table.put(root.left, root);
		    DFS(root.left, table, subTotals);
		  }
		  if (root.right != null) {
		    table.put(root.right, root);
		    DFS(root.right, table, subTotals);
		  }
	}
}