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

    public boolean isPalindrome(ListNode head) {

        // 1. Find the middle
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // For even number of nodes
        if (fast != null) {
            slow = slow.next;
        }

        // 2. Reverse the second half
        slow = reverseList(slow);

        // 3. Compare first half and reversed second half
        fast = head;

        while (slow != null) {

            if (fast.val != slow.val) {
                return false;
            }

            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {

            ListNode next = current.next;

            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }
}