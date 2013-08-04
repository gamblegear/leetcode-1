// Given two binary strings, return their sum (also a binary string).

// For example,
// a = "11"
// b = "1"
// Return "100".

public class Solution {
    
    public static void main(String[] args) {
    	String a = "11";
    	String b = "1";

    	System.out.println("sum is: " + addBinary(a, b));
    }

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
}