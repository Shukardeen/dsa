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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode current = head;

        // stack to store data values
        Stack<Integer> values = new Stack<>();

        // store data values in stack
        while(current != null) {
            values.push(current.val);
            current = current.next;
        }

        // put the values in linked list from stack
        current = head;
        while(!values.isEmpty()) {
            current.val = values.pop();
            current = current.next;
        }
        return head;
    }
}