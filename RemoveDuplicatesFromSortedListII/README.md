## Problem

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.


## Stop and Think

使用两个指针来扫一遍linkedlist，两个都一步一步移动，如果两个值都一样的话就直接跳过，当然需要考虑边界条件。

## Solution

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

## Note

