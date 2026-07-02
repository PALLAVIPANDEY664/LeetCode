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
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // Create a Min-Heap based on the node values
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        
        // Push the head of each non-empty list into the heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }
        
        // Dummy head to simplify building the final merged list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        // Extract the minimum node and push its next node into the heap
        while (!minHeap.isEmpty()) {
            ListNode smallestNode = minHeap.poll();
            tail.next = smallestNode;
            tail = tail.next;
            
            if (smallestNode.next != null) {
                minHeap.add(smallestNode.next);
            }
        }
        
        return dummy.next;
    }
}