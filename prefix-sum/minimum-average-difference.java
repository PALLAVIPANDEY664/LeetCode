public class MinimumAverageDifferenceOptimal {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long totalSum = 0;
        
        // Step 1: Calculate total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        int minIndex = -1;
        long minDiff = Long.MAX_VALUE;
        long leftSum = 0;

        // Step 2: Iterate to find the minimum average difference
        for (int i = 0; i < n; i++) {
            leftSum += nums[i];
            long rightSum = totalSum - leftSum;

            long leftCount = i + 1;
            long rightCount = n - leftCount;

            long leftAvg = leftSum / leftCount;
            // Guard against division by zero for the last element
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