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
        int pVal = p.val;
        int qVal = q.val;

        TreeNode curr = root;

        while(curr != null) {
            int currVal = curr.val;
            if(currVal > pVal && currVal > qVal) {
                curr = curr.left;
            } else if(currVal < pVal && currVal < qVal) {
                curr = curr.right;
            } else {
                return curr;
            }
        }
        return null;
    }
}