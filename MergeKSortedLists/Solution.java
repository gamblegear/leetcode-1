// Merge k sorted linked lists and return it as one sorted list.
// Analyze and describe its complexity.
import java.util.*;

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
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		ListNode head1 = new ListNode(1, 
			new ListNode(5, 
				new ListNode(10, null)));
		ListNode head2 = null;
		ListNode head3 = new ListNode (2, 
			new ListNode(3, 
				new ListNode(12, 
					new ListNode(13))));
		ListNode head4 = new ListNode(20, null);
		lists.add(head1); // 1-5-10
		lists.add(head2); // empty
		lists.add(head3); // 2-3-12-13
		lists.add(head4); // 20
		ListNode newHead = mergeKLists(lists);
		while (newHead != null) {
			System.out.print(newHead.val + " ");
			newHead = newHead.next;
		}
	}	
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
    	if (lists == null) {
    		return null;
    	}
    	Comparator<ListNode> comparator = new Comparator<ListNode>() {
    		public int compare(ListNode l1, ListNode l2) {
    			return l1.val - l2.val;
    		}
    	};
    	PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(1, comparator);
    	for (ListNode list : lists) {
    		ListNode curr = list;
    		while (curr != null) {
    			q.add(curr);
    			curr = curr.next;
    		}
    	}
    	ListNode dummy = new ListNode(0);
    	ListNode df = dummy;

    	while (q.size() != 0) {
    		df.next = q.remove();
    		df = df.next;
    	}

    	return dummy.next;
    }
}