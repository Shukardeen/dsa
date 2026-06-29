/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        /* value copy and skip mechanism */

        // copy the value of next node in current node
        node.val = node.next.val;
        // link the current node to its next's next
        node.next = node.next.next;
    }
}