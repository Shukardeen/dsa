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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        // node to track tail node
        ListNode tail = head;
        // variable to store length of linked list
        int listLen = 1;

        // find length of LL and tail node
        while(tail.next != null) {
            listLen++;
            tail = tail.next;
        }

        // return given head if k is multiple of length
        if(k % listLen == 0) return head;

        // update tail's next to head
        tail.next = head;

        // find the new tail position
        k = k % listLen;
        int newTailPosition = listLen - k;

        // reach to the new tail
        tail = head;
        while(tail != null) {
            newTailPosition--;
            if(newTailPosition == 0) break;
            tail = tail.next;
        }
        // update head
        head = tail.next;
        // update new tail's next
        tail.next = null;
        // return head
        return head;
    }
}