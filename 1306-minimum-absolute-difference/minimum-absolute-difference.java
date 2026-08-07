import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        // Sort the array so adjacent elements have the smallest differences [00:03:39]
        Arrays.sort(arr);
        int n = arr.length;
        
        // Pass 1: Find the minimum absolute difference [00:07:24]
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }
        
        // Pass 2: Collect all adjacent pairs matching the minDiff [00:07:56]
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff == minDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        
        return result;
    }
}