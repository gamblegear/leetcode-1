## Problem

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.


## Stop and Think

这题用recursive来解最方便，通过比较head节点的大小来区分subproblem。

## Solution

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}        

		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}
		else {
			l2.next = mergeTwoLists(l2.next, l1);
			return l2;
		}
    }


## Note

- Nothing to say :)