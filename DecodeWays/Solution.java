// A message containing letters from A-Z is being encoded to
// numbers using the following mapping:
// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given an encoded message containing digits, determine the
// total number of ways to decode it.

// For example,
// Given encoded message "12", it could be decoded as
// "AB" (1 2) or "L" (12).
// The number of ways decoding "12" is 2.

public class Solution {
	public static void main(String[] args) {
		System.out.println(numDecodings("10326")); //2
		System.out.println(numDecodings("22026")); //2
		System.out.println(numDecodings("127")); //2
	}
	public static int numDecodings(String s) {
		// dynamic programming.
		char[] arr = s.toCharArray();
		int[] results = new int[arr.length];
		results[0] = 1;
		int firstTwo = Integer.parseInt(s.substring(0, 2));
		results[1] = firstTwo != 10 && firstTwo != 20 && 
			firstTwo <= 26? 2 : 1;

		for(int i = 2; i < arr.length; i++) {
			if (arr[i] == '0') {
				results[i] = results[i-2];
			}
			else {
				int num = Integer.parseInt(s.substring(i-1, i+1));
				if (num > 10 && num <= 26) {
					results[i] = results[i-1] + results[i-2];
				}
				else {
					results[i] = results[i-1];
				}
			}
		}
		return results[arr.length-1];
	}
	// recursion solution will time out.
    //  public static int numDecodings(String s) {        
    //  	if (s.length() == 0) {
    //  		return 1;
    //  	}
    //  	if (s.charAt(0) == '0') {
    //  		return 0;
    //  	}
    //  	int count = numDecodings(s.substring(1));
    //  	if (s.length() >= 2) {
    //  		int num = Integer.parseInt(s.substring(0, 2));
	  		 // if (num >= 10 && num <= 26) {
			 // 	count += numDecodings(s.substring(2));
			 // }
    //  	}
    //  	return count;
    //  }
}