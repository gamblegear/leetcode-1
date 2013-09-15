// Given a sorted linked list, delete all duplicates such that each
// element appear only once.
// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3.

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
			new ListNode(1, 
				new ListNode(2,
					new ListNode(3,
						new ListNode(3, null)))));
		ListNode after = deleteDuplicates(head);
		while (after != null) {
			System.out.print(after.val + " ");
			after = after.next;
		}
	}
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode d = new ListNode(0);
        ListNode df = d;
        int prev = Integer.MIN_VALUE;
        while(curr != null) {
        	if (prev != curr.val) {
        		df.next = curr;
        		df = df.next;
        		prev = curr.val;
        	}
        	curr = curr.next;
        }
        df.next = null;
        return d.next;
    }
}