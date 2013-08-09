## Problem

Determine whether an integer is a palindrome. Do this without extra space.

[link](http://leetcode.com/onlinejudge#question_9)

## Stop and Think

最先想到的是一个个`digit`放在一个`array`里面，然后两端扫这个`array`。但是题目要求不能用`extra space`。

其实从定义出发就可以，`Palindrome`就是`reverse`一下还是同样的东西，那就用一个循环算出`reverse number`，然后比较是不是一致就行。

## Solution

    public static boolean isPalindrome(int x) {
    	if (x < 0) {
    		return false;
    	}
    	int reverseX = 0;
    	int originalX = x;
    	while(x != 0) {
    		reverseX = reverseX * 10 + x % 10;
    		x = x / 10;
    	}
    	return originalX == reverseX;
    }


## Note

- 注意负数
- `reverseX`有可能`overflow`.