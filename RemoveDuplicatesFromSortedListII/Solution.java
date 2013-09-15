// Given a sorted linked list, delete all nodes that have duplicate numbers,
// leaving only distinct numbers from the original list.

// For example,
// Given 1->2->3->3->4->4->5, return 1->2->5.
// Given 1->1->1->2->3, return 2->3.

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
					new ListNode(3, 
						new ListNode(4, 
							new ListNode(4,
								new ListNode(5)))))));
		ListNode newHead = deleteDuplicates(head);
		while (newHead != null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	} 
    public static ListNode deleteDuplicates(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	ListNode dummy = new ListNode(0);
    	ListNode df = dummy;
    	ListNode fast = head.next;
    	ListNode slow = head;
    	while (fast != null) {
    		if (fast.val != slow.val) {
    			df.next = slow;
    			df = df.next;
    			slow = slow.next;
    			fast = fast.next;
    		}
    		else {
    			if (fast.next == null) {
    				break;
    			}
    			if (fast.next.next == null) {
    				df.next = fast.next; 
    				df = df.next;
    				break;
    			}
    			slow = slow.next.next;
    			fast = fast.next.next;
    		}
    	}
    	df.next = null;
    	return dummy.next;
    }
}