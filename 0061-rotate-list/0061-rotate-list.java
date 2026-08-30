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
        if (head == null || k == 0 || head.next == null) {
            return head;
        }

        ListNode tail = head;
        int length = 1;

        while (tail.next != null) { // move tail to end and count length
            tail = tail.next;
            length++;
        }

        k = k % length; // count real k (number of times we actually have to rotate the list)
        if (k == 0) { // rotation will ended up the same, return head
            return head;
        }

        // move curr position to new tail
        ListNode curr = head;
        for (int i = 0; i < length - k - 1; i++) {
            curr = curr.next;
        }

        // connect tail to new head and make curr the tail
        ListNode newHead = curr.next;
        curr.next = null;
        tail.next = head;
        return newHead;
    }
}