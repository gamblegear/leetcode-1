// Given a number represented as an array of digits, plus one to the number.

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		test1();
		test2();
	}
	
	public static void test1() {
		int[] test =  { 9, 9, 9 };
		int[] result = plusOne(test);
		
		// Should expect { 1, 0, 0, 0 };
		for(int i=0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}
	
	public static void test2() {
		int[] test =  { 9 };
		int[] result = plusOne(test);
		
		// Should expect { 9 };
		for(int i=0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}
	
    public static int[] plusOne(int[] digits) {
        ArrayList<Integer> result = new ArrayList<Integer>();
		int carry = 1;
		int digit = 0;
		for (int i=digits.length-1; i>= 0; i--, digit++) {
			result.add((digits[i] + carry) % 10);
			carry = (digits[i] + carry) / 10;
		}
		if (carry == 1) {
			result.add(1);
		}
		
		int[] ret = new int[result.size()];
		for (int i=0; i < ret.length; i++)
		{
			ret[i] = result.get(result.size() - i - 1).intValue();
		}
		return ret;
    }
}