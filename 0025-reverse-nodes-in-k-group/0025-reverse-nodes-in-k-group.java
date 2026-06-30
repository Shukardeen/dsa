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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head.next == null) return head;
        // variable node to track current node
        ListNode current = head;
        // variable to store previous and next nodes
        ListNode prevNode = null, nextNode = null;

        // traverse the linked list
        while(current != null) {
            // get the kth node
            ListNode kthNode = getKthNode(current, k);
            if(kthNode == null) {
                if(prevNode != null) {
                    prevNode.next = current;
                    break;
                }
            }
            // preserve the next node
            nextNode = kthNode.next;
            // remove next link of node to get individual LL
            kthNode.next = null;
            // reverse the linked list
            kthNode = reverse(current);
            if(current == head) {
                head = kthNode;
            } else {
                prevNode.next = kthNode;
            }
            prevNode = current;
            current = nextNode;
        }
        return head;
    }

    // method to get kth node
    private ListNode getKthNode(ListNode node, int k) {
        while(node != null) {
            k--;
            if(k == 0) break;
            node = node.next;
        }
        return node;
    }

    // recursive method to reverse the LL
    private ListNode reverse(ListNode head) {
        if(head.next == null) return head;
        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}