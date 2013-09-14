// Given a linked list and a value x, partition it such that all nodes
// less than x come before nodes greater than or equal to x.
// You should preserve the original relative order of the nodes
// in each of the two partitions.

// For example,
// Given 1->4->3->2->5->2 and x = 3,
// return 1->2->2->4->3->5.

public class Solution {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x, ListNode n) {
			val = x;
			next = n;
		}
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1, 
			new ListNode(4, 
				new ListNode(3, 
					new ListNode(2, 
						new ListNode(5, 
							new ListNode(2, null))))));

		ListNode r = partition(head, 3);
		while(r != null) {
			System.out.print(r.val + " ");
			r = r.next;
		}
	}

    public static ListNode partition(ListNode head, int x) {
    	ListNode curr = head;
        ListNode s = new ListNode(0, null);
        ListNode sFront = s;
        ListNode l = new ListNode(0, null);
        ListNode lFront = l;
        while (curr != null) {
        	if (curr.val < x) {
        		sFront.next = curr;
        		sFront = curr;
        	}
        	else {
        		lFront.next = curr;
        		lFront = curr;
        	}
        	curr = curr.next;
        }
        lFront.next = null;
        sFront.next = l.next;
        return s.next;
    }
}