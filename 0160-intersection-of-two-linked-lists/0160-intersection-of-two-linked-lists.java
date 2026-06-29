/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currentA = headA;
        ListNode currentB = headB;

        while(currentA != currentB) {
            currentA = currentA.next;
            currentB = currentB.next;
            if(currentA == currentB) return currentA;
            if(currentA == null) currentA = headB;
            if(currentB == null) currentB = headA;
        }
        return currentA;
    }
}