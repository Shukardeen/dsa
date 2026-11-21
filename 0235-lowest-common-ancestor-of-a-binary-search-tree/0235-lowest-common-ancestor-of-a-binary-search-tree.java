/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    // recursive helper method
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        int curr = root.val;
        if(curr > p.val && curr > q.val) {
            return helper(root.left, p, q);
        } else if(curr < p.val && curr < q.val) {
            return helper(root.right, p, q);
        }
        return root;
    }
}