## Problem

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

## Stop and Think

不能太费内存，所以不能另外开辟ListNode来存所有的节点。所以通过“穿针引线”的方法，先create两个dummy node作为两个list的head，然后walk throu list，大小分明地partition分别加入list，最后再连成一串。

## Solution

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

## Note

- 注意要设lfront的next为空，不然有可能死循环。