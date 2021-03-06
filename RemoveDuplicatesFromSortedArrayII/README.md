## Problem

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].

## Stop and Think

Instead of saving one previous number, we save two.

## Solution

    public static int removeDuplicates(int[] A) {
		int prev = Integer.MIN_VALUE;
		int prevprev = Integer.MIN_VALUE;
		int count = 0;
		for(int i=0; i < A.length; i++) {
			if (A[i] != prev || prev != prevprev) {
				A[count++] = A[i];
			}
			prevprev = prev;
			prev = A[i];
		}		        
		return count;
    }

## Note