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
        // length variables
        int lengthA = 0;
        int lengthB = 0;

        // compute the length of lists
        ListNode currentA = headA;
        ListNode currentB = headB;
        while(currentA != null || currentB != null) {
            if(currentA != null) {
                lengthA++;
                currentA = currentA.next;
            }
            if(currentB != null) {
                lengthB++;
                currentB = currentB.next;
            }
        }

        // steps to move
        int stepsToMove = Math.abs(lengthA - lengthB);

        // move the longer list head
        currentA = headA;
        currentB = headB;
        if(lengthA > lengthB) currentA = move(currentA, stepsToMove);
        else currentB = move(currentB, stepsToMove);

        // traverse both simultaneously 
        while(currentA != null && currentB != null) {
            if(currentA == currentB) return currentA;
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return null;
    }

    // function to move
    private static ListNode move(ListNode node, int steps) {
        for(int i=0; i<steps; i++) {
            node = node.next;
        }
        return node;
    }
}