public class MinimumAverageDifferenceBruteForce {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int minIndex = -1;
        long minDiff = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long leftSum = 0;
            long rightSum = 0;

            // Calculate left sum [0...i]
            for (int j = 0; j <= i; j++) {
                leftSum += nums[j];
            }

            // Calculate right sum [i+1...n-1]
            for (int j = i + 1; j < n; j++) {
                rightSum += nums[j];
            }

            // Calculate counts
            long leftCount = i + 1;
            long rightCount = n - leftCount;

            // Calculate averages
            long leftAvg = leftSum / leftCount;
            long rightAvg = (rightCount == 0) ? 0 : rightSum / rightCount;

            // Absolute difference
            long diff = Math.abs(leftAvg - rightAvg);

            // Track the minimum difference and its corresponding index
            if (diff < minDiff) {
                minDiff = diff;
                minIndex = i;
            }
        }

        return minIndex;
    }
}