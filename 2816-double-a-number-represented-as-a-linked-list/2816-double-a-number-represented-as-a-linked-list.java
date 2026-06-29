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
        int carry = helper(head);
        if(carry != 0) {
            head = new ListNode(carry, head);
            return head;
        }
        return head;
    }

    // recursive helper function
    private int helper(ListNode head) {
        if(head == null) return 0;
        int carry = helper(head.next);
        int val = head.val * 2 + carry;
        if(val < 10) {
            head.val = val;
            return 0;
        } 
        head.val = val%10;
        return val/10;
    }
}