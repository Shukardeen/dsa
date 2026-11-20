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
    public void recoverTree(TreeNode root) {
        // step 1: inorder traverse the tree
        List<Integer> inorder = new ArrayList<>();
        inorder(root, inorder);

        // step 2: sort the traversal
        inorder.sort((a, b) -> Integer.compare(a, b));

        // step 3: traverse tree and replace node value that doesn't match
        checkAndReplace(root, inorder, new int[1]);
    }

    // method to find inorder traversal of tree
    private void inorder(TreeNode root, List<Integer> ans) {
        if(root == null) return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

    // method to check and replace wrong nodes
    private void checkAndReplace(TreeNode root, List<Integer> inorder, int[] index) {
        if(root == null) return;
        checkAndReplace(root.left, inorder, index);
        if(root.val != inorder.get(index[0])) root.val = inorder.get(index[0]);
        index[0]++;
        checkAndReplace(root.right, inorder, index);
    }
}