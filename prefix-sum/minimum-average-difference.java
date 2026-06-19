class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int minIndex = -1;
        long minDiff = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long leftSum = 0;
            long rightSum = 0;

            // Calculate left sum from index 0 to i
            for (int j = 0; j <= i; j++) {
                leftSum += nums[j];
            }

            // Calculate right sum from index i + 1 to n - 1
            for (int j = i + 1; j < n; j++) {
                rightSum += nums[j];
            }

            long leftCount = i + 1;
            long rightCount = n - leftCount;

            long leftAvg = leftSum / leftCount;
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