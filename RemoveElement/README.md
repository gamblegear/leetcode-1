## Problem

Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

[link](http://leetcode.com/onlinejudge#question_27)

## Stop and Think

因为要inplace，可以考虑用两个pointer的方法来做。一个iterating pointer，一个slow pointer来保存结果。

## Solution

	public static int removeElement(int[] A, int elem) {
    	int ptr = 0;
    	for(int i = 0; i < A.length; i++) {
    		if (A[i] != elem) {
    			A[ptr++] = A[i];
    		}
    	}
    	return ptr;
    }

## Note

- NA