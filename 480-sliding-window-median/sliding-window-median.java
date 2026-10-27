import java.util.*;

class Solution {
    // Max heap for the smaller half of the numbers
    PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder());
    // Min heap for the larger half of the numbers
    PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
    
    // Tracks elements that are out of the sliding window and need to be removed from heaps lazily
    Map<Integer, Integer> delayed = new HashMap<>();
    
    int leftSize = 0;
    int rightSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n - k + 1];
        int resIdx = 0;

        // Initialize the first window
        for (int i = 0; i < k; i++) {
            insert(nums[i]);
        }
        
        result[resIdx++] = getMedian(k);

        // Slide the window across the rest of the array
        for (int i = k; i < n; i++) {
            int outNum = nums[i - k];
            int inNum = nums[i];
            
            // Mark the outgoing element for deletion
            delayed.put(outNum, delayed.getOrDefault(outNum, 0) + 1);
            
            if (outNum <= leftHeap.peek()) {
                leftSize--;
            } else {
                rightSize--;
            }
            
            // Insert the incoming element and balance heaps
            insert(inNum);
            
            // Prune heaps (remove elements that are marked for deletion from the top)
            prune(leftHeap);
            prune(rightHeap);
            
            result[resIdx++] = getMedian(k);
        }

        return result;
    }

    private void insert(int num) {
        if (leftHeap.isEmpty() || num <= leftHeap.peek()) {
            leftHeap.add(num);
            leftSize++;
        } else {
            rightHeap.add(num);
            rightSize++;
        }
        balanceHeaps();
    }

    private void balanceHeaps() {
        if (leftSize > rightSize + 1) {
            rightHeap.add(leftHeap.poll());
            leftSize--;
            rightSize++;
            prune(leftHeap);
        } else if (leftSize < rightSize) {
            leftHeap.add(rightHeap.poll());
            rightSize--;
            leftSize++;
            prune(rightHeap);
        }
    }

    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (delayed.containsKey(num)) {
                delayed.put(num, delayed.get(num) - 1);
                if (delayed.get(num) == 0) {
                    delayed.remove(num);
                }
                heap.poll();
            } else {
                break;
            }
        }
    }

    private double getMedian(int k) {
        if (k % 2 == 1) {
            return leftHeap.peek();
        } else {
            // Use 1.0 * (...) to avoid integer overflow
            return ((double) leftHeap.peek() + rightHeap.peek()) / 2.0;
        }
    }
}