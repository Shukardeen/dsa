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
        ListNode fastPointer = head;
        ListNode slowPointer = head;

        // move fast pointer n steps 
        for(int i=0; i<n; i++) {
            fastPointer = fastPointer.next;
        }
        if(fastPointer == null) return head.next;

        // move fast ans slow pointer simultaneuosly one step
        while(fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        // change the next of node at slowPointer
        slowPointer.next = slowPointer.next.next;
        return head;
    }
}