## Problem

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

## Stop and Think

利用recursion，利用前面n-1的结果，依次依个append一个数字，这个数字必须是前面那个combo最后一个数字后面，已保证sorted。

## Solution

    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      if (k == 1) {
        for(int i=1; i <= n; i++) {
          ArrayList<Integer> com = new ArrayList<Integer>();
          com.add(i);
          res.add(com);
        }
        return res;
      }
      ArrayList<ArrayList<Integer>> prev = combine(n, k - 1);
      for (ArrayList<Integer> c : prev) {
        for(int i = c.get(c.size() - 1) + 1; i <= n; i++) {
          ArrayList<Integer> a = new ArrayList<Integer>(c);
          a.add(i);
          res.add(a);
        }
      }
      return res;
    }

## Note