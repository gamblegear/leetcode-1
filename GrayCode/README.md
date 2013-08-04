## Problem

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0

01 - 1

11 - 3

10 - 2

Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

[link](http://leetcode.com/onlinejudge#question_89)

## Stop and Think

一开始的想法是DFS，预处理出一个graph matrix，用来存是否有任何一state到另外一state。但是这个memory cost有点高。

那就换个角度：
1. 从当前的数值（开始是全零）出发。
2. 从0位一直试到最高位，看flip一下是不是新的value，如果是新的value就放入hashset，如果是hashset已经有的，继续试。
3. 如果2试得无果，就结束，否则继续循环。

## Solution

    public static ArrayList<Integer> grayCode(int n) {
    	Set<Integer> s = new HashSet<Integer>();
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	int currentValue = 0;
    	s.add(currentValue);
    	res.add(currentValue);
    	
    	while (true) {
    		boolean foundNextValue = false;
    		for(int i=0; i < n; i++) {
    			int nextValue = flipKthBit(currentValue, i);	
    			// if new value, add to set, reset currentvalue
    			if (!s.contains(nextValue)) {
    				currentValue = nextValue;
    				s.add(currentValue);
    				res.add(currentValue);
    				foundNextValue = true;
    				break;
    			}
    		}
    		if (!foundNextValue) {
    			break;
    		}
    	}
    	return res;
    }
    private static int flipKthBit(int num, int k) {
    	int mask = 1 << k;
    	return (num & mask) != 0? num - mask : num + mask;
    }

## Note

- 为了保证check是否已有状态是constant time，所以需要hashset，但是hashset是无序的，所以再用一个arraylist来存具体的数值。

