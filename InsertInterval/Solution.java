// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

// You may assume that the intervals were initially sorted according to their start times.

// Example 1:
// Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

// Example 2:
// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

// This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.*;

public class Solution {
	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }

		public static void printInterval(Interval val) {
			System.out.println("Start: " + val.start + 
				";   end: " + val.end);
		}
	}

	public static void main(String[] args) {
		ArrayList<Interval> test = new ArrayList<Interval>();
		test.add(new Interval(1, 5));
		test = insert(test, new Interval(2, 3));

		System.out.println("after:");
		for (Interval i : test) {
			Interval.printInterval(i);
		}
	} 

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
        	res.add(newInterval);
        	return res;
        }
		boolean inserted = false;
		for(int curr=0; curr<intervals.size(); curr++) {
			Interval currInterval = intervals.get(curr);
        	if (inserted || currInterval.end < newInterval.start) {
        		res.add(currInterval);
        	}
        	else if (currInterval.start > newInterval.end) {
        		res.add(newInterval);
        		res.add(currInterval);
        		inserted = true;
        	}
        	else { // merge
        		newInterval.start = Math.min(newInterval.start,
        			currInterval.start);
        		newInterval.end = Math.max(newInterval.end, 
        			currInterval.end);
        	}
		} 
        if (!inserted) {
        	res.add(newInterval);
        }
        return res;
    }
}