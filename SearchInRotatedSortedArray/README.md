## Problem

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

## Stop and Think

如果mid落在前一个part的话，比第一个数和最后一个数要大。如果是后一个part的话，比第一个数和最后一个数都要小。如果是顺序的话，那就是正好是两数之间。分情况讨论，再根据target的数值来决定。

## Solution

    public static int search(int[] A, int target) {
    	return search(A, target, 0, A.length - 1);
    }
    public static int search(int[] A, int target, int start, int end) {
    	if (start >= end) {
    		return A[start] == target? start : -1;
    	}
    	int mid = (start + end) / 2;
    	if (A[mid] == target) {
    		return mid;
    	}
 		if (A[mid] >= A[start] && A[mid] >= A[end]) {
 			// like 
 			// 2 3 4 5 6 7 8 0 1
 			if (target > A[mid]) {
 				return search(A, target, mid + 1, end);
 			}
 			else {
 				int nRes = search(A, target, start, mid - 1);
 				if (nRes != -1) {
 					return nRes;
 				}
 				else {
 					return search(A, target, mid + 1, end);
 				}
 			}
 		}   
 		else if (A[mid] <= A[start] && A[mid] <= A[end]) {
 			// like
 			// 8 9 1 2 3 4 5 6 7 
 			if (target < A[mid]) {
 				return search(A, target, start, mid - 1);
 			}
 			else {
 				int nRes = search(A, target, mid + 1, end);
 				if (nRes != -1) {
 					return nRes;
 				}
 				else {
 					return search(A, target, start, mid - 1);
 				}
 			}
 		}
 		else {	
 			// like 
 			// 1 2 3 4 5 6 7 8 9
 			if (target > A[mid]) {
 				return search(A, target, mid + 1, end);
 			}
 			else {
 				return search(A, target, start, mid - 1);
 			}
 		}
    }

## Note

- 注意等号。