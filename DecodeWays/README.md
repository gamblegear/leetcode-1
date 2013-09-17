## Problem

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.


## Stop and Think

利用dp来解这题，如果当前是0的话，那可定是与前面一位只能组成一种可能的值，所以赋值为results[i-2]；如果与前一位组成的数值是10到26之前的话，那就有可能用一位，也有可能用两位；如果是10以下或者26以上的话，那就只能用当前这位组成结果。所以需要分情况讨论。

## Solution

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

## Note

- 用recursion很可能超时