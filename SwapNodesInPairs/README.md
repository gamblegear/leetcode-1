## Problem

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

## Stop and Think


利用recursion，只考虑前面两个swap，后面的交给recursion。


## Solution

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

## Note
