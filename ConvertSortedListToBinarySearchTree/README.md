## Problem

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

## Stop and Think

要把一个list变成一个balanced的bst，只有采用二分的思想。取中点作为root，对前后两个list进行recursively变。

## Solution

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


## Note
