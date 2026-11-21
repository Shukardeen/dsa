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

        TreeNode root = new TreeNode(preorder[0]);

        for(int i=1; i<preorder.length; i++) {
            TreeNode curr = root;
            int val = preorder[i];
            while(curr != null) {
                if(curr.val < val) {
                    if(curr.right == null) {
                        curr.right = new TreeNode(val);
                        break;
                    }
                    curr = curr.right;
                } else {
                    if(curr.left == null) {
                        curr.left = new TreeNode(val);
                        break;
                    }
                    curr = curr.left;
                }
            }
        }
        return root;
    }
}