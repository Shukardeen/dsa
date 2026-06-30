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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        // nodes to track current nodes of list1 and list2
        ListNode current1 = list1;
        ListNode current2 = list2;

        // dummy node 
        ListNode dummyHead = new ListNode(-1);
        ListNode dummyCurrent = dummyHead;

        // traverse lists
        while(current1 != null && current2 != null) {
            if(current1.val <= current2.val) {
                dummyCurrent.next = current1;
                current1 = current1.next;
            } else {
                dummyCurrent.next = current2;
                current2 = current2.next;
            }
            dummyCurrent = dummyCurrent.next;
        }

        // when one of the list is exhausted
        dummyCurrent.next = (current1 == null) ? current2 : current1;

        return dummyHead.next;
    }
}