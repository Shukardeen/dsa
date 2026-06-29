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
        // hashmap to store nodes of linked list A
        HashMap<ListNode, Integer> map = new HashMap<>();
        // store the nodes of linked list A in hash map
        ListNode current = headA;
        while(current != null) {
            map.put(current, 1);
            current = current.next;
        }

        // store the node of linked list 2 in the linked list
        current  = headB;
        while(current != null) {
            // check if map contains the current node
            if(map.containsKey(current)) {
                // if true, return the node 
                return current;
            }
            current = current.next;
        }

        return null;
    }
}