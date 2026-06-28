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
        // stack to store data values
        Stack<Integer> s = new Stack<>();
        ListNode current = head;

        // store values to stack
        while(current != null) {
            s.push(current.val);
            current = current.next;
        }

        // compare values
        current = head;
        while(current != null) {
            if(current.val != s.pop()) return false;
            current = current.next;
        }
        return true;
    }
}