## Problem

Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].


## Stop and Think

扫一遍，如果是一个新的数就写到应该的index上。

## Solution

    public static int removeDuplicates(int[] A) {
        int count = 0;
        int prev = Integer.MIN_VALUE;
        for (int a : A) {
        	if (a != prev) {
        		A[count] = a;
        		count++;
        		prev = a;
        	}
        }
        return count;
    }

## Note

- 根据题意，注意需要改变A。