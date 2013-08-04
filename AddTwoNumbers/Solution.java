// You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8

public class Solution {
	 // Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x;
			next = null;
	  }
	}
	public static void main(String[] args) {
		ListNode a = new ListNode(0);
		ListNode b = new ListNode(1);
		ListNode c = addTwoNumbers(a, b);
		System.out.println(c.val);
	}
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if (l1 == null) {
    		return l2;
    	}
    	if (l2 == null) {
    		return l1;
    	}
    	int sum = l1.val + l2.val;
    	boolean carry = (sum / 10 == 1);
    	sum = sum % 10;

		ListNode n = new ListNode(sum);
		if (carry) {
			n.next = addTwoNumbers(addTwoNumbers(l1.next, l2.next), new ListNode(1));
		}
		else {
			n.next = addTwoNumbers(l1.next, l2.next);
		}
		return n;
    }
}