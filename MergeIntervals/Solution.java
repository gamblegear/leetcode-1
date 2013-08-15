// Given a collection of intervals, merge all overlapping intervals.

// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].


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
	//Definition for an interval.
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
		test.add(new Interval(2, 3));
		test.add(new Interval(4, 5));
		test.add(new Interval(6, 7));
		test.add(new Interval(1, 10));		
		
		test = merge(test);

		System.out.println("after:");
		for (Interval i : test) {
			Interval.printInterval(i);
		}
	}

    public static  ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    	if (intervals.size() == 0 || intervals.size() == 1) {
    		return intervals;
    	}

    	// sort the interval by start 
    	Collections.sort(intervals, new Comparator<Interval>() {
    		public int compare(Interval one, Interval other) {
    			return one.start - other.start;
    		}
    	});

    	ArrayList<Interval> res = new ArrayList<Interval>();
    	int curr = 0;
    	Interval currInterval = intervals.get(curr);
    	while (curr + 1 < intervals.size()) {
    		if(currInterval.end < intervals.get(curr+1).start) {
    			res.add(currInterval);
    			curr++;
    			currInterval = intervals.get(curr);
    		}
    		else {
    			currInterval.end = 	Math.max(currInterval.end, 
    				intervals.get(curr+1).end);
    			curr++;
    		}
    	} 
    	res.add(currInterval);
    	return res;
    }
}