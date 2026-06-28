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
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode current = head;
        int nodeCount = 0;

        // count the number of nodes
        while(current != null) {
            nodeCount++;
            current = current.next;
        }

        // middle node position --> (n/2)+1
        int middleNode = nodeCount/2 + 1;
        // reach the middle node and return
        current = head;
        while(current != null) {
            middleNode--;
            if(middleNode == 0) {
                break;
            }
            current = current.next;
        }
        return current;
    }
}