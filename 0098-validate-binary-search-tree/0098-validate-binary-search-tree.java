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
    public boolean isValidBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        helper(root, inorder);

        for(int i=1; i<inorder.size(); i++) {
            if(inorder.get(i) <= inorder.get(i-1)) {
                return false;
            }
        }

        return true;
    }

    // method to find inorder traversal of bst
    private void helper(TreeNode root, List<Integer> inorder) {
        TreeNode curr = root;
        Deque<TreeNode> st = new ArrayDeque<>();

        while(curr != null || !st.isEmpty()) {
            if(curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = st.pop();
                inorder.add(node.val);
                curr = node.right;
            }
        }
    }
}