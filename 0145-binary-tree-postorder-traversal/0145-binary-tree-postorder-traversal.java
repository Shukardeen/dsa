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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        helper(root, ans);
        return ans;
    }

    // recursive helper method
    private void helper(TreeNode root, List<Integer> traversal) {
        if(root == null) return;
        helper(root.left, traversal);
        helper(root.right, traversal);
        traversal.add(root.val);
    }
}