## Problem


Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

## Stop and Think

做个in order traverse,只存前一个node，比较current与前一个的值。如果只有一次不满足 current.val >= previous.val, swap their values. 如果有两次不满足，记录第一次的 previous 和第二次的current, swap their values。

## Solution


	static class Tuple<X> {
   		public X first;
   		public X second;
   		public Tuple(X x, X y) {
   			first = x;
   			second = y;
   		}
   }

    public static void recoverTree(TreeNode root) {
    	recoverTreeHelper(root);

    	if(tuples.size() == 1){
    		Tuple<TreeNode> t = tuples.get(0);
    		int temp = t.first.val;
    		t.first.val = t.second.val;
    		t.second.val = temp;
    	}
    	else if (tuples.size() == 2) {
    		Tuple<TreeNode> t1 = tuples.get(0);
    		Tuple<TreeNode> t2 = tuples.get(1);
    		int temp = t1.first.val;
    		t1.first.val = t2.second.val;
    		t2.second.val = temp;
    	}
   }

   private static TreeNode prev = null;
   private static ArrayList<Tuple<TreeNode>> tuples = new ArrayList<Tuple<TreeNode>>();

   private static void recoverTreeHelper(TreeNode root) {
   		if (root == null) {
   			return;
   		}

   		recoverTreeHelper(root.left);
   		if ((prev != null) && (root.val < prev.val)) {
   			Tuple<TreeNode> t = new Tuple<TreeNode>(prev, root);
   			tuples.add(t);
   		}
   		prev = root;

		recoverTreeHelper(root.right);
   }
	static class Tuple<X> {
   		public X first;
   		public X second;
   		public Tuple(X x, X y) {
   			first = x;
   			second = y;
   		}
   }

    public static void recoverTree(TreeNode root) {
    	recoverTreeHelper(root);

    	if(tuples.size() == 1){
    		Tuple<TreeNode> t = tuples.get(0);
    		int temp = t.first.val;
    		t.first.val = t.second.val;
    		t.second.val = temp;
    	}
    	else if (tuples.size() == 2) {
    		Tuple<TreeNode> t1 = tuples.get(0);
    		Tuple<TreeNode> t2 = tuples.get(1);
    		int temp = t1.first.val;
    		t1.first.val = t2.second.val;
    		t2.second.val = temp;
    	}
   }

    private static TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    private static ArrayList<Tuple<TreeNode>> tuples = new ArrayList<Tuple<TreeNode>>();

    private static void recoverTreeHelper(TreeNode root) {
   		if (root == null) {
   			return;
   		}

   		recoverTreeHelper(root.left);
   		if (root.val < prev.val) {
   			Tuple<TreeNode> t = new Tuple<TreeNode>(prev, root);
   			tuples.add(t);
   		}
   		prev = root;

		recoverTreeHelper(root.right);
   }

## Note 

- 不知为什么code通不过oj，但是local跑没有问题。