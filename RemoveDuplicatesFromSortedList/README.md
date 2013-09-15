## Problem

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

## Stop and Think

因为已经sorted了，所以不需要额外的内存，只要存前一个Node，“穿针引线”即可。

## Solution

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

## Note

- 记得要设df的next为空。