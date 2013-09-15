## Problem

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

## Stop and Think

n-way merge可以利用的heap或者priority queue来解决，把所有的node放在pq上，然后依次pop出来。因为heap存的都是reference，所以memory开销不是很大。

## Solution

   public static ListNode mergeKLists(ArrayList<ListNode> lists) {
    	if (lists == null) {
    		return null;
    	}
    	Comparator<ListNode> comparator = new Comparator<ListNode>() {
    		public int compare(ListNode l1, ListNode l2) {
    			return l1.val - l2.val;
    		}
    	};
    	PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(1, comparator);
    	for (ListNode list : lists) {
    		ListNode curr = list;
    		while (curr != null) {
    			q.add(curr);
    			curr = curr.next;
    		}
    	}
    	ListNode dummy = new ListNode(0);
    	ListNode df = dummy;

    	while (q.size() != 0) {
    		df.next = q.remove();
    		df = df.next;
    	}

    	return dummy.next;
    }

## Note

- complexity分析：memory cost就是heap，time就是O(n).
- 从solution可以看出来，没有利用到sorted的这个优惠条件，这就告诉我们有更好的solution，我们只是对所有list的head listnode放入queue里面，每次pop出一个，每次push进这个出去node的next，这个memory cost就比较低。