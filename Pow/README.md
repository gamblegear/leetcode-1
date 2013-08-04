## Problem

Implement pow(x, n).

[link](http://leetcode.com/onlinejudge#question_50)

## Stop and Think

此题可用二分和recursion来做。

## Solution

    public double pow(double x, int n) {
    	if (n < 0) {
    		return 1 / pow(x, -n);
    	}
    	if (n == 0) {
    		return 1;
    	}
    	if (n == 1) {
    		return x;
    	}
    	return n % 2 == 1? x * pow(x, n/2) * pow(x, n/2) :
    		pow(x, n/2) * pow(x, n/2);
    }

## Note

- 要注意负数的可能性。
- 因为二分，所以此时间复杂度为 `O(log n)`
