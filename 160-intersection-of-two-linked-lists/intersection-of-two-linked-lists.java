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
        if (headA == null || headB == null) return null;

        ListNode ptrA = headA;
        ListNode ptrB = headB;

        // Loop until both pointers meet at the intersection node or at null
        while (ptrA != ptrB) {
            // Move to the next node, or switch to the other list's head if at the end
            ptrA = (ptrA != null) ? ptrA.next : headB;
            ptrB = (ptrB != null) ? ptrB.next : headA;
        }

        return ptrA;
    }
}