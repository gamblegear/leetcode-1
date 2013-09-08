// Flatten Binary Tree to Linked List
// Given a binary tree, flatten it to a linked list in-place.
// For example,
// Given
//          1
//         / \
//        2   5
//       / \   \
//      3   4   6
// The flattened tree should look like:
//    1
//     \
//      2
//       \
//        3
//         \
//          4
//           \
//            5
//             \
//              6
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
      TreeNode(int x, TreeNode l, TreeNode r) {
        val = x;
        left = l;
        right = r;
      }
    }
    public static void main(String[] args) {
      //          1
      //         / \
      //        2   5
      //       / \   \
      //      3   4   6
      TreeNode root = new TreeNode(1, 
        new TreeNode(2, 
          new TreeNode(3, null, null),
          new TreeNode(4, null, null)),
        new TreeNode(5, null, new TreeNode(6, null, null)));

      flatten(root);

      TreeNode ptr = root;
      while (ptr != null) {
        System.out.println(ptr.val);
        ptr = ptr.right;
      }
    }

    public static void flatten(TreeNode root) {
      if (root == null) {
        return;
      }
      
      flatten(root.left);
      flatten(root.right);

      if (root.left == null) {
        return;
      }

      // chain linked list on the right to the left
      TreeNode tn = root.left;
      while (tn.right != null) {
        tn = tn.right;
      }
      tn.right = root.right;

      // reset the left chain to be right chain
      root.right = root.left;
    }
}