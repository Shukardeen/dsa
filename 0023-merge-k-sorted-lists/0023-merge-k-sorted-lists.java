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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];

        ListNode head = lists[0];
        for(int i=1; i<lists.length; i++) {
            head = merge(head, lists[i]);
        }
        return head;
    }

    // method to merge two lists
    private ListNode merge(ListNode head1, ListNode head2) {
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        ListNode current1 = head1;
        ListNode current2 = head2;
        ListNode dummyHead = new ListNode(-1);
        ListNode dummyCurrent = dummyHead;

        while(current1 != null && current2 != null) {
            if(current1.val < current2.val) {
                dummyCurrent.next = current1;
                current1 = current1.next;
            } else {
                dummyCurrent.next = current2;
                current2 = current2.next;
            }
            dummyCurrent = dummyCurrent.next;
        }
        dummyCurrent.next = (current1 == null) ? current2 : current1;
        return dummyHead.next;
    }
}