// Given a singly linked list where elements are sorted 
// in ascending order, convert it to a height balanced BST.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		TreeNode(int x, TreeNode l, TreeNode r) {
			val = x;
			left = l;
			right = r;
		}
	}

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; next = null; }
		ListNode(int x, ListNode n) {
			val = x;
			next = n;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1, 
			new ListNode(2, 
				new ListNode(3, 
					new ListNode(4, 
						new ListNode(5, 
							new ListNode(6, 
								new ListNode(7, null)))))));

		TreeNode root = sortedListToBST(head);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
	}

    public static TreeNode sortedListToBST(ListNode head) {
    	if (head == null) {
    		return null;
    	}
    	if (head.next == null) {
    		return new TreeNode(head.val);
    	}
    	// find the middle element in the list.
    	int len = 0;
    	ListNode curr = head;
    	while (curr != null) {
    		curr = curr.next;
    		len++;
    	}
    	curr = head;
    	for(int i=0; i < len/2 - 1; i++) {
    		curr = curr.next;
    	}

    	TreeNode root = new TreeNode(curr.next.val);
    	root.right = sortedListToBST(curr.next.next);
    	curr.next = null;
    	root.left = sortedListToBST(head);
    	return root;
    }
}