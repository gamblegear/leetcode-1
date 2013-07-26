## Problem

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 
For example, this binary tree is symmetric:
 
       	   1
      	  / \
     	 2   2
    	/ \ / \
   	   3  4 4  3
 
But the following is not:

        1
       / \
      2   2
      \    \
       3    3

- [link](http://leetcode.com/onlinejudge#question_101)

## Stop & Think
 
先考虑用recursive的方法。所谓symmetric，就是左右子树对称，或者说成镜像。根据[sametree](https://github.com/zeiga/leetcode/tree/master/sametree)的经验，就很容易想到用一个helper method来判断树是否为镜像，代码如下。

再考虑用iterative的方法。画几个example，发现可以从level traversal进行出发。Basically, 所谓symmtric，就是每一层的元素print out出来是左右对称的。但是，要注意的是，如果盲目的一层层扫也不行，像上面的第二个例子，所以，需要“填洞”。代码稍微复杂一些，如下。

## Solution

Recursive:

	public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode first, TreeNode second) {
        if (first == null) {
            return second == null;
        }
        if (second == null) {
            return first == null;
        }
        return (first.val == second.val) && isMirror(first.left, second.right) && isMirror(first.right, second.left);
    }

Iterative:

    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> nodesQueue = new LinkedList<TreeNode>();
        Queue<Integer> levelsQueue = new LinkedList<Integer>();
        nodesQueue.offer(root);
        levelsQueue.offer(0); //Start from zero
        int currLevel = 0;
        while (!nodesQueue.isEmpty()){
            List<Integer> levelNums = new ArrayList<Integer>();
            int l;
            do {
                TreeNode t = nodesQueue.poll();
                l = levelsQueue.poll();

                if (t == null) {
                    levelNums.add(0);
                }
                else {
                    levelNums.add(t.val);

                    nodesQueue.offer(t.left);
                    levelsQueue.offer(currLevel+1);
                    nodesQueue.offer(t.right);
                    levelsQueue.offer(currLevel+1);
                }
            } while (!nodesQueue.isEmpty() && levelsQueue.peek() == currLevel);

            if (!isListSymmetric(levelNums)) {
                return false;
            }
            currLevel++;
        }
        return true;
    }
    public static boolean isListSymmetric(List<Integer> list) {
        int s = 0, e = list.size() - 1;
        while (s <= e) {
            if (list.get(s) != list.get(e)) {
                return false;
            }
            s++;e--;
        }
        return true;
    }

## Note

- Java里面的dequeue和enqueue API是poll和offer。
- Java的LinkedList实现了Queue的interface。
- recursive的时间复杂度是 *O(n)* （n是node数目）
- iterative的时间复杂度好像因为有这个linear复杂度的helper function感觉有点复杂，但是细想其实每个node最终共被访问的是2次，所以时间复杂度也是 *O(n)* 