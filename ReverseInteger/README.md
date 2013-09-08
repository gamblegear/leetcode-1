## Problem 

Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321


## Stop and Think

reverse就是原数地位脱落一位加入新数中去，新数要先进位，原数要退位。

## Solution

    public static int reverse(int x) {
		boolean neg = x < 0;
		if (neg) {
			x = -x;
		}
		long res = 0;
		while (x != 0) {
			res = res * 10 + x % 10;
			x = x / 10;
		}
		return neg? (int)-res : (int)res;				        
    }

## Note

- 要考虑到溢出的情况