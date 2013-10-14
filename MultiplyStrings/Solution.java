// Given two numbers represented as strings, return multiplication
// of the numbers as a string.

// Note: The numbers can be arbitrarily large 
// and are non-negative.

public class Solution {
	public static void main(String[] args) {
		//String res = multiply("200000000000000000000", 
		//	"300000000000000000000");
		String res = multiply("11", "233");
		System.out.println(res);
	}

    public static String multiply(String num1, String num2) {
 		StringBuilder result = new StringBuilder();
 		// reset to all zeroes
 		for(int i=0; i < num1.length() + num2.length(); i++) {
 			result.append('0');
 		}
 		for (int i=num1.length() - 1, ri=0; i >= 0; i--, ri++) {
 			int dig1 = num1.charAt(i) - '0';
 			int carry = 0;
 			for (int j=num2.length() - 1, rj=0; j>= 0; j--, rj++) {
 				int dig2 = num2.charAt(j) - '0';
 				int existing = result.charAt(ri + rj) - '0';
 				result.setCharAt(ri + rj, (char)((dig1 * dig2 + carry + existing) % 10 + '0'));
 				carry = (dig1 * dig2 + carry + existing) / 10;
 			}
 			if (carry != 0) {
 				result.setCharAt(ri + num2.length(), (char)(carry + '0'));
 			}
 		}
 		// trim the trailing zeroes
 		for(int i=result.length() - 1; i >= 0; i--) {
 			if(result.charAt(i) == '0') {
 				result.deleteCharAt(i);
 			}
 			else {
 				return result.reverse().toString();
 			}
 		}
 		return "0";
    }
}