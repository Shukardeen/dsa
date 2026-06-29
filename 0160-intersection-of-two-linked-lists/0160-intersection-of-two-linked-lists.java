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

        currentA = headA;
        currentB = headB;
        if(lengthA < lengthB) return collisionPoint(currentA, currentB, lengthB-lengthA);
        else return collisionPoint(currentB, currentA, lengthA-lengthB);
    }

    // function to find collision point
    private static ListNode collisionPoint(ListNode smallerHead, ListNode largerHead, int steps) {
        // move larger steps times
        while(steps != 0) {
            steps--;
            largerHead = largerHead.next;
        }
        // move both of them simultaneously
        while(smallerHead != largerHead) {
            smallerHead = smallerHead.next;
            largerHead = largerHead.next;
        }
        return smallerHead;
    }
}