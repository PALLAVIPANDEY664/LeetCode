class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        
        // Step 1: Calculate the total sum of all elements in the array
        for (int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        
        // Step 2: Traverse the array to find the pivot index
        for (int i = 0; i < nums.length; i++) {
            // The right sum is total sum minus what's on the left and the current element
            int rightSum = totalSum - leftSum - nums[i];
            
            // Step 3: Check if left sum equals right sum
            if (leftSum == rightSum) {
                return i; // Return the leftmost pivot index found
            }
            
            // Update the running left sum for the next index
            leftSum += nums[i];
        }
        
        // If no pivot index exists, return -1
        return -1;
    }
}