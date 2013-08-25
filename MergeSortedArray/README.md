## Problem

Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.

[link](http://leetcode.com/onlinejudge#question_88)

## Stop and Think

为了实现inplace的merge，我们应该从后面还是merge。

## Solution


    public void merge(int A[], int m, int B[], int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                A[i] = B[i];
            }
            return;
        }
        int length = m + n;
        for (int i = length - 1; i >=0; i--) {
		  	if (n==0) {
            	return;
            }
            if (m == 0 || A[m-1] < B[n-1]) {
                A[i] = B[n-1];
                n--;
            }
            else {
                A[i] = A[m-1];
                m--;
            }
        }
    }

## Note

- 需要注意either array已经空的情况。