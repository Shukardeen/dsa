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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        TreeNode curr = root;

        if(curr.val == key) return deleteHelper(root);

        while(curr != null) {
            if(curr.val > key) {
                if(curr.left != null && curr.left.val == key) {
                    curr.left = deleteHelper(curr.left);
                } else curr = curr.left;
            } else {
                if(curr.right != null && curr.right.val == key) {
                    curr.right = deleteHelper(curr.right);
                } else curr = curr.right;
            }
        }

        return root;
    }

    // delete helper method
    private TreeNode deleteHelper(TreeNode root) {
        if(root.left == null) return root.right;
        else if(root.right == null) return root.left;
        else {
            TreeNode rightChild = root.right;
            TreeNode lastRightOfLeft = findLastRight(root.left);
            lastRightOfLeft.right = rightChild;
            return root.left;
        }
    }

    // method to find the last right of left child
    private TreeNode findLastRight(TreeNode node) {
        while(node.right != null) {
            node = node.right;
        }
        return node;
    }
}