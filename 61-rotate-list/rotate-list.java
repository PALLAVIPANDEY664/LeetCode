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
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find the length of the list and the tail node
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Handle cases where k >= length
        k = k % length;
        if (k == 0) {
            return head;
        }

        // Step 3: Connect tail to head to form a circular list
        tail.next = head;

        // Step 4: Find the new tail position: (length - k - 1) steps from head
        int stepsToNewTail = length - k;
        ListNode newTail = tail; // starting from tail takes us length steps to loop back around
        
        while (stepsToNewTail > 0) {
            newTail = newTail.next;
            stepsToNewTail--;
        }

        // Step 5: Break the circular connection and get new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}