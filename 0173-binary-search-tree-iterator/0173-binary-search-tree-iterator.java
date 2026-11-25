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
class BSTIterator {
    private Deque<TreeNode> nextStack;

    public BSTIterator(TreeNode root) {
        this.nextStack = new ArrayDeque<>();
        pushLeftNodes(root);
    }
    
    public int next() {
        TreeNode ans = nextStack.pop();
        if(ans.right != null) pushLeftNodes(ans.right);
        return ans.val;
    }
    
    public boolean hasNext() {
        return !nextStack.isEmpty();
    }

    private void pushLeftNodes(TreeNode node) {
        while(node != null) {
            nextStack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */