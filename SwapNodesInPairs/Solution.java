// Given a linked list, swap every two adjacent nodes and
// return its head.
// For example,
// Given 1->2->3->4, you should return the list as 2->1->4->3.
// Your algorithm should use only constant space. You may not
// modify the values in the list, only nodes itself can be changed.

public class Solution {
	static class ListNode{
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
					new ListNode(4, null))));

		ListNode newHead = swapPairs(head);
		while(newHead != null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
        	return null;
        }
        if (head.next == null) {
        	return head;
        }

        ListNode ln = swapPairs(head.next.next);
        head.next.next = head;
        ListNode res = head.next;
        head.next = ln;
        return res;
    }
}