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
        if (lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];

        // min heap to store all heads
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));

        // store all heads to priority queue
        for(int i=0; i<lists.length; i++) {
            ListNode head = lists[i];
            if(head != null) {
                pq.offer(new Pair(head.val, head));
            }
        }

        // dummy head
        ListNode dummyHead = new ListNode(-1);
        ListNode dummyCurrent = dummyHead;

        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            dummyCurrent.next = p.node;
            dummyCurrent = dummyCurrent.next;
            if(p.node.next != null) {
                pq.offer(new Pair(p.node.next.val, p.node.next));
            }
        }

        return dummyHead.next;
    }
}

class Pair {
    int value;
    ListNode node;

    Pair(int value, ListNode node) {
        this.value = value;
        this.node = node;
    }
}