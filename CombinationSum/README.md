## Problem 

Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 


## Stop and Think

从candidates里面挑一个数，然后调整target的值来recursion。

## Solution

	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		return combinationSumSorted(candidates, target);
	}

    public static ArrayList<ArrayList<Integer>> combinationSumSorted(int[] candidates, int target) {
		HashSet<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
		if (target < candidates[0]) {
			return new ArrayList<ArrayList<Integer>>(res); // empty
		}
		for (int c : candidates) {
			if (target - c == 0) {
				ArrayList<Integer> s = new ArrayList<Integer>();
				s.add(c);
				res.add(s);
			}
			else if (target - c > 0) {
				ArrayList<ArrayList<Integer>> prev = combinationSumSorted(candidates, target - c);
				for (ArrayList<Integer> combo : prev) {
					ArrayList<Integer> cc = new ArrayList<Integer>(combo);
					cc.add(c);
					Collections.sort(cc);
					res.add(cc);							
				}						
			}
		}
		return new ArrayList<ArrayList<Integer>>(res);
	}

## Note

- 不能assume candidates是sorted。