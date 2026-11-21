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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 1) return new TreeNode(preorder[0]);

        int[] index = {0};
        return helper(preorder, index, Integer.MAX_VALUE);
    }

    // recursive helper method
    private TreeNode helper(int[] preorder, int[] index, int upperBound) {
        if(index[0] == preorder.length || preorder[index[0]] > upperBound) return null;

        TreeNode root = new TreeNode(preorder[index[0]]);
        index[0]++;
        root.left = helper(preorder, index, root.val);
        root.right = helper(preorder, index, upperBound);

        return root;
    }
}