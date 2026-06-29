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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        int listLen = 0;
        ListNode current = head;
        while(current != null) {
            listLen++;
            current = current.next;
        }

        // reach the node before middle node
        current = head;
        for(int i=0; i<(listLen/2)-1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }
}