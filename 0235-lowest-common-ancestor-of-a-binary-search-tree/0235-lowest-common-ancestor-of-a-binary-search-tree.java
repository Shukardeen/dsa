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
        int val1 = p.val;
        int val2 = q.val;

        TreeNode curr = root;
        while(curr != null) {
            int currVal = curr.val;
            if(currVal > val1 && currVal > val2) {
                curr = curr.left;
            } else if(currVal < val1 && currVal < val2) {
                curr = curr.right;
            } else {
                return curr;
            }
        }
        return null;
    }
}