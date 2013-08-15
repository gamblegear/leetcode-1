## Problem

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].


[link](http://leetcode.com/onlinejudge#question_56)


## Stop and Think

思路就是先按照start从小到大排序。然后从第一个interval开始看，如果下一个interval的start比当前interval要大，说明需要merge；否则就说明不用merge，当前的interval就被add进去result里面。

## Solution

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

## Note

- 需要注意的是`Arraylist`的`remove`是`O(n)`，避免使用。
- `ArrayList`的`sort`需要定义一个`comparator`，然后里面要定义compare method，return value应该要是`int`。