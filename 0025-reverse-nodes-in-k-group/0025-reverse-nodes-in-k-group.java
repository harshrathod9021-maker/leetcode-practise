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
import java.util.ArrayList;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        // Store all values
        ListNode temp = head;

        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        // Reverse every group of k
        for (int i = 0; i + k <= list.size(); i += k) {

            int left = i;
            int right = i + k - 1;

            while (left < right) {
                int tempValue = list.get(left);
                list.set(left, list.get(right));
                list.set(right, tempValue);

                left++;
                right--;
            }
        }

        // Put values back into linked list
        temp = head;
        int i = 0;

        while (temp != null) {
            temp.val = list.get(i);
            temp = temp.next;
            i++;
        }

        return head;
    }
}