// Reverse digits of an integer.

// Example1: x = 123, return 321
// Example2: x = -123, return -321

public class Solution {
	public static void main(String[] args) {
		int res = reverse(123);
		System.out.println(res);

		res = reverse(-123);
		System.out.println(res);
	}

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
}