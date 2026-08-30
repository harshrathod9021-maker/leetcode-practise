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
    public ListNode reverseList(ListNode head) {
    ListNode prev=null;
    ListNode curr=head;
    while(curr!=null){
        ListNode  next=curr.next;    //step1
        curr.next=prev;              //step2
         prev = curr;                //step3
        curr=next;                   //step4
    }
    return prev;
    }
}