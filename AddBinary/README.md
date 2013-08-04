## Problem

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

[link](http://leetcode.com/onlinejudge#question_67)

## Stop and Think

此题不能用`bit to string`或者`string to bit`的`api`，不然意思不大。

这题可以`iteratively`如同小学加法似的相加，但是这里我觉得也可以用`recursive`的方法，没准更简化代码一些。

注意到如果是“101”和“1100”进行相加，subproblem可以看作是“10”和“110”相加，这个结果是前部分。再看末位一个digit的相加，如果有carry，那就在前面结果上继续加“1”，否则就是直接`concatnate`起来。

## Solution

    public static String addBinary(String a, String b) {
    	if (a.length() == 0) {
    		return b;	
    	}
    	if (b.length() == 0) {
    		return a;
    	}
    	boolean carry = false;
    	String sum = "0";
    	String fusionOfLastTwoDigits = a.substring(a.length() - 1) + b.substring(b.length() - 1);
    	if (fusionOfLastTwoDigits.equals("01") || fusionOfLastTwoDigits.equals("10")) {
    		sum = "1";
    	}
    	else if (fusionOfLastTwoDigits.equals("11")) {
    		carry = true;
    	}
    	String other = addBinary(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1));
    	return carry? addBinary(other, "1") + sum : other + sum;
    }


## Note

- 这个算法`implement`起来比较容易，可读性比较好，但是有个缺点是`string`开销比较大。`substring`和加号都能`create`一个新的`string`。
- java`string`比较要用`equals()`