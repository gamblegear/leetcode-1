## Problem

Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

## Stop and Think

需要找到边界。利用两个binary search（时间复杂度还是`O(log n)`) 找到upperbound和lowerbound。

## Solution

    public static int[] searchRange(int[] A, int target) {
        int l = searchLowerBound(A, target, 0, A.length - 1);
        int h = searchUpperBound(A, target, 0, A.length - 1);
        int[] res = { l, h };
        return res;
    }

    public static int searchLowerBound(int[] A, int target, int start, int end) {
    	if (start > end) {
    		return -1;
    	}

    	int mid = (start + end) / 2;
    	if (A[mid] < target) {
    		if (mid < A.length - 1 && A[mid+1] == target) { 
    			return mid+1;
    		}
    		return searchLowerBound(A, target, mid+1, end);
    	}
    	else {
    		if (A[mid] == target && mid == start) {
    			return mid;
    		}
    		return searchLowerBound(A, target, start, mid-1);
    	}
    }

    public static int searchUpperBound(int[] A, int target, int start, int end) {
    	if (start > end) {
    		return -1;
    	}

    	int mid = (start + end) / 2;
    	if (A[mid] > target) {
    		if (mid > 0 && A[mid-1] == target) {
    			return mid-1;
    		}
    		return searchUpperBound(A, target, start, mid-1);
    	}
    	else {
    		if (A[mid] == target && mid == end) {
    			return mid;
    		}
    		return searchUpperBound(A, target, mid+1, end);
    	}
    }


## Note

- 注意如果binary search到了头上，不能返回-1，而是头的index。