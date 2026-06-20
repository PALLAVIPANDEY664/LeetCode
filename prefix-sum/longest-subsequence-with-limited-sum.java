import java.util.Arrays;

public class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] result = new int[m];

        // Step 1: Sort the array to pick the smallest elements greedily
        Arrays.sort(nums);

        // Step 2: Compute the prefix (cumulative) sum in-place
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }

        // Step 3: Process each query using Binary Search
        for (int i = 0; i < m; i++) {
            result[i] = binarySearch(nums, queries[i]);
        }

        return result;
    }

    // Helper method to find the number of elements with sum <= target
    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                // If the current prefix sum is valid, we can take at least mid + 1 elements
                count = mid + 1; 
                left = mid + 1; // Try to look for a larger valid subsequence on the right
            } else {
                right = mid - 1; // Sum is too large, look to the left
            }
        }
        return count;
    }
}