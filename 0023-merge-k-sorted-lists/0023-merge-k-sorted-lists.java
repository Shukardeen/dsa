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

        // array list to store all values
        List<Integer> values = new ArrayList<>();
        // store all values
        for(ListNode head: lists) {
            ListNode current = head;
            while(current != null) {
                values.add(current.val);
                current = current.next;
            }
        }

        // sort the values
        values.sort((a, b) -> Integer.compare(a, b));

        if(values.size() == 0) return null;
        // convert sorted array list to linked list
        ListNode head = new ListNode(values.get(0));
        ListNode current = head;
        for(int i=1; i<values.size(); i++) {
            current.next = new ListNode(values.get(i));
            current = current.next;
        }
        return head;
    }
}