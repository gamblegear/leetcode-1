// Given a set of distinct integers, S, return all possible subsets.
// Note:
// Elements in a subset must be in non-descending order.
// The solution set must not contain duplicate subsets.
// For example,
// If S = [1,2,3], a solution is:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]
import java.util.*;
public class Solution {
    public static void main(String[] args) {
      int[] S = { 1, 2, 3, 4 };
      ArrayList<ArrayList<Integer>> res = subsets(S);
      for (ArrayList<Integer> set : res) {
        for (Integer i : set) {
          System.out.print(i + ",");
        }
        System.out.println();
      }
    }
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
      Arrays.sort(S);
      ArrayList<ArrayList<Integer>> res = subsets(S, S.length-1);
      res.add(new ArrayList<Integer>());
      return res;
    }
    private static ArrayList<ArrayList<Integer>> subsets(int[] S, int term) {
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      if (term == 0) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        r.add(S[term]);
        res.add(r);
        return res;
      }
      ArrayList<Integer> nth = new ArrayList<Integer>();
      nth.add(S[term]);
      res.add(nth);
      ArrayList<ArrayList<Integer>> prev = subsets(S, term - 1);
      for (ArrayList<Integer> arr : prev) {
        res.add(arr);
        ArrayList<Integer> c = new ArrayList<Integer>(arr);
        c.add(S[term]);
        res.add(c);       
      }
      return res;
    }
}