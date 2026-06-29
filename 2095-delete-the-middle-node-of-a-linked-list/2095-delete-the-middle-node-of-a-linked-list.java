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
        // node to track the previous node
        ListNode prev = null;
        // slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        // reach the middle node of the linked list
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // update the next of prev node
        prev.next = slow.next;
        return head;
    }
}