## Problem

Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

## Stop and Think

首先要找到离end还有N+1的节点，有了它就是可以delete了。

## Solution

    public static ListNode removeNthFromEnd(ListNode head, int n) {
    	if (head == null || head.next == null) {
    		return null;
    	}
		ListNode fast = head;
		for (int i = 0; i < n + 1; i++) {
			fast = fast.next;
		}
		ListNode slow = head;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return head;
    }

## Notes