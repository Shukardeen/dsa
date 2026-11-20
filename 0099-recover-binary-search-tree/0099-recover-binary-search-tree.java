/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode first, middle, last, prev;

    public void recoverTree(TreeNode root) {
        // step 1: initialize first, middle, last, and prev
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);

        helper(root);
        if(first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if(first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    // recursive helper method
    private void helper(TreeNode root) {
        if(root == null) return;
        helper(root.left);
        if(prev != null && (root.val < prev.val)) {
            if(first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        prev = root;
        helper(root.right);
    }
}