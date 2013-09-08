//Given n pairs of parentheses, write a function to generate all 
//combinations of well-formed parentheses.

//For example, given n = 3, a solution set is:
//"((()))", "(()())", "(())()", "()(())", "()()()"
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		ArrayList<String> res = generateParenthesis(4);
		for (String s : res) {
			System.out.println(s);
		}
		System.out.println(res.size());
	}

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
}