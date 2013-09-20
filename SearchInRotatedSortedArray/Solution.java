// Suppose a sorted array is rotated 
// at some pivot unknown to you beforehand.
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
// You are given a target value to search. If found in 
// the array return its index, otherwise return -1.
// You may assume no duplicate exists in the array.

public class Solution {
	public static void main(String[] args) {
		// int[] A = { 4, 5, 6, 7, 0, 1, 2 };
		// System.out.println(search(A, 4));
		// System.out.println(search(A, 5));
		// System.out.println(search(A, 6));
		// System.out.println(search(A, 7));
		// System.out.println(search(A, 0));
		// System.out.println(search(A, 1));
		// System.out.println(search(A, 2));	
		int[] A = { 3, 1 };
		System.out.println(search(A, 1));
	}
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
}