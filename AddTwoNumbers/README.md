## Problem

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

[link](http://leetcode.com/onlinejudge#question_2)


## Stop and Think

刚解了 [AddBinary Problem](https://github.com/zeiga/leetcode/tree/master/AddBinary)，感觉此题非常类似，也可以用recursive的方法来解。

## Solution

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

## Note

- 注意计算sum和carry的方法

