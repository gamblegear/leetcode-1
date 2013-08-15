## Problem

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

[link](http://leetcode.com/onlinejudge#question_57)


## Stop and Think

思路是从original的`intervals`一个一个与`newInterval`进行比较，三种情况，一种是`newInterval`在当前`interval`的后面，那就直接把当前`interval`放入result中；第二种是`newInterval`在当前的`interval`的前面，那就把`newInterval`放入result中，把当前`interval`也放入，设一个flag，后面的`interval`就直接放入result就行；最后一种情况是merge，merge完更新`newInterval`。如果最后是第三种情况结尾的，需要把`newInterval`也给放入result。


## Solution

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

## Note

- 注意考虑清楚最后剩余的情况
