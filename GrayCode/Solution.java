// The gray code is a binary numeral system where two successive values differ in only one bit.
// Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
// For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

// 00 - 0
// 01 - 1
// 11 - 3
// 10 - 2

// Note:
// For a given n, a gray code sequence is not uniquely defined.
// For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
// For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		ArrayList<Integer> res = grayCode(3);
		for (int i=0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
    public static ArrayList<Integer> grayCode(int n) {
    	Set<Integer> s = new HashSet<Integer>();
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	int currentValue = 0;
    	s.add(currentValue);
    	res.add(currentValue);

    	while (true) {
    		boolean foundNextValue = false;
    		for(int i=0; i < n; i++) {
    			int nextValue = flipKbit(currentValue, i);	
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
    private static int flipKbit(int num, int k) {
    	int mask = 1 << k;
    	return (num & mask) != 0? num - mask : num + mask;
    }
}