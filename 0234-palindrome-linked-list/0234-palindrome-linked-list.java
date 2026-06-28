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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        // slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        // step1: reach the middle node
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // step2: reverse the secondHalf
        ListNode secondHalfHead = reverse(slow.next);

        // step3: compare first and second half values
        ListNode first = head;
        ListNode second = secondHalfHead;
        while(second != null) {
            if(first.val != second.val) {
                reverse(secondHalfHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(secondHalfHead);
        return true;
    }

    // method to reverse a linked list - recursive approach
    static ListNode reverse(ListNode head) {
        if(head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}