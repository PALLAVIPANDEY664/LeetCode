class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int minIndex = -1;
        long minDiff = Long.MAX_VALUE;
        
        // Step 1: Calculate the total sum of the array
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        long leftSum = 0;
        
        // Step 2: Iterate through the array to find the minimum average difference
        for (int i = 0; i < n; i++) {
            leftSum += nums[i];
            long rightSum = totalSum - leftSum;
            
            long leftCount = i + 1;
            long rightCount = n - leftCount;
            
            long leftAvg = leftSum / leftCount;
            // Handle the edge case where the right part has 0 elements
            long rightAvg = (rightCount == 0) ? 0 : rightSum / rightCount;
            
            long diff = Math.abs(leftAvg - rightAvg);
            
            if (diff < minDiff) {
                minDiff = diff;
                minIndex = i;
            }
        }
        
        return minIndex;
    }
}
