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
    private int findLength(ListNode head){
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }
    public ListNode swapNodes(ListNode head, int k) {
        int L = findLength(head);
        int k1 = k;
        ListNode node1 = head;
        while(k1 > 1){
            node1 = node1.next;
            k1--;
        }

        int k2 = L-k+1;
        ListNode node2 = head;
        while(k2 > 1){
            node2 = node2.next;
            k2--;
        }
        int tempVal = node1.val;
        node1.val = node2.val;
        node2.val = tempVal;
        return head;
    }
}