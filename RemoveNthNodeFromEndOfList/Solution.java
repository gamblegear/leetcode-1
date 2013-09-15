// Given a linked list, remove the nth node from the end of list and
// return its head.
// For example,
//    Given linked list: 1->2->3->4->5, and n = 2.
//    After removing the second node from the end, the linked list becomes 1->2->3->5.
//
// Note:
// 	Given n will always be valid.
// 	Try to do this in one pass.

public class Solution {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
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
						new ListNode(5, null)))));
		ListNode newHead = removeNthFromEnd(head, 2);
		// ListNode head = new ListNode(1, null);
		// ListNode newHead = removeNthFromEnd(head, 1);
		while (newHead != null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}
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
}