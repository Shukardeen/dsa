/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        if(head.next == null && n == 1) return null;
        ListNode current = head;
        int nodeCount = 0;

        // count the number of nodes in list
        while(current != null) {
            nodeCount++;
            current = current.next;
        }

        if(nodeCount == n) return head.next;

        // reach the node before the nth node from back
        int nodePosition = nodeCount - n;
        current = head;
        while(current != null) {
            nodePosition--;
            if(nodePosition == 0) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }

        return head;
    }
}