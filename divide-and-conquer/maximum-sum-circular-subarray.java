class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        
        // 1. Calculate the total sum of the array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // 2. Get the maximum subarray sum using standard Kadane's Algorithm
        int maxKadane = getMaxKadane(nums);
        
        // 3. Get the minimum subarray sum using modified Kadane's Algorithm
        int minKadane = getMinKadane(nums);
        
        // 4. Calculate the circular subarray sum
        int circularSum = totalSum - minKadane;
        
        // 5. If maxKadane is negative, it means all numbers in the array are negative.
        // In that case, returning `circularSum` would incorrectly return 0 (totalSum - totalSum).
        if (maxKadane > 0) {
            return Math.max(maxKadane, circularSum);
        }
        
        return maxKadane;
    }
    
    // Standard Kadane's Algorithm to find Maximum Subarray Sum
    private int getMaxKadane(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Decide whether to add to the current subarray or start a new one
            sum = Math.max(nums[i], sum + nums[i]);
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }
    
    // Modified Kadane's Algorithm to find Minimum Subarray Sum
    private int getMinKadane(int[] nums) {
        int sum = nums[0];
        int minSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Decide whether to add to the current subarray or start a new one for minimum sum
            sum = Math.min(nums[i], sum + nums[i]);
            minSum = Math.min(minSum, sum);
        }
        
        return minSum;
    }
}