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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode current = head;

        // arraylist to store data values
        List<Integer> values = new ArrayList<>();

        // add odds
        while(current != null && current.next != null) {
            values.add(current.val);
            current = current.next.next;
        }
        if(current != null) values.add(current.val);

        // add evens
        current = head.next;
        while(current != null && current.next != null) {
            values.add(current.val);
            current = current.next.next;
        }
        if(current != null) values.add(current.val);

        // add values to original ll
        current = head;
        for(int i=0; i<values.size(); i++) {
            current.val = values.get(i);
            current = current.next;
        }
        return head;
    }
}
