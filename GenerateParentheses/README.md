## Problem

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

[link](http://leetcode.com/onlinejudge#question_22)

## Stop and Think

用dp，在计算n时候，组合所有f(1)和f(n-1)，f(2)和f(n-2)，...，一直到n/2, 前后颠倒也算，最后对于f(1)和f(n-1)比较特殊，一对（）可以加在两头。

## Solution

    public static ArrayList<String> generateParenthesis(int n) {	
		HashSet<String> res = new HashSet<String>();
		res.add("()");
		if (n == 1) {
			return new ArrayList<String>(res);
		}
		// start dynamic programming
		ArrayList<HashSet<String>> resultCache = new ArrayList<HashSet<String>>();       
		resultCache.add(null); // zero-index 
		resultCache.add(res);  // first-index
		for(int i = 2; i <= n; i++) {
			res = new HashSet<String>();
			for(int j=1; j <= i/2; j++) {
				Set<String> a = resultCache.get(j);
				Set<String> b = resultCache.get(i - j);
				for (String aa : a) {
					for (String bb : b) {
						res.add(aa + bb);
					}
				}
				for (String aa : a) {
					for (String bb : b) {
						res.add(bb + aa);
					}
				}
			}
			Set<String> c = resultCache.get(i - 1);
			for (String cc : c) {
				res.add("(" + cc + ")");
			}
			resultCache.add(res);			
		}
		return new ArrayList<String>(resultCache.get(n));
    }

## Note

- 不能在f(n-1)的结果上直接左边，右边，两边这样recursively算，容易漏掉情况如n＝4时，(())() => missing (())(())