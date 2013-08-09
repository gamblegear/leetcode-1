// Determine whether an integer is a palindrome. 
// Do this without extra space.

public class Solution {
	public static void main(String[] args) {
		System.out.println(isPalindrome(-2147447412));
	}

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
}