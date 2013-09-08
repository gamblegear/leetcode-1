## Problem

Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

[link](http://leetcode.com/onlinejudge#question_46)


## Stop and Think

用recursion，算n时候，实际上是在n-1的基础上插值。


## Solution

    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
    	return permute(num, num.length);
    }

    public static ArrayList<ArrayList<Integer>> permute(int[] num, int len) {
    	if (len <= 0) {
		 	return null;
		 }
		 ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		 if (len == 1) {
		 	ArrayList<Integer> perm = new ArrayList<Integer>();
		 	perm.add(num[0]);
		 	res.add(perm);
		 	return res;
		 }
		 ArrayList<ArrayList<Integer>> prev = permute(num, len - 1);       
		 for (ArrayList<Integer> perm : prev) {
		 	for(int i=0; i <= perm.size(); i++) {
		 		ArrayList<Integer> temp  = new ArrayList<Integer>(perm);
		 		temp.add(i, num[len - 1]);
		 		res.add(temp);
		 	}
		 }
		 return res;
    }

## Note

- 如果是有重复的数字的话，需要用hashset来dedup。