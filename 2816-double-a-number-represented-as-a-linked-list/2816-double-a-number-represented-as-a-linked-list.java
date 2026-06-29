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
    public ListNode doubleIt(ListNode head) {
        // maintain carry
        int carry = 0;
        // reverse the linked list
        head = reverse(head);

        // traverse reversed linked list
        ListNode current = head;
        while(current != null) {
            int val = current.val * 2 + carry;
            if(val < 10) {
                current.val = val;
                carry = 0;
            } else {
                current.val =  val % 10;
                carry = val / 10;
            }
            current = current.next;
        }

        head = reverse(head);
        if(carry != 0) {
            head = new ListNode(carry, head);
            return head;
        }
        return head;
    }

    static ListNode reverse(ListNode head) {
        if(head.next == null) return head;
        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}