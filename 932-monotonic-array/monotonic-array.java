class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        boolean isIncreasing = false;
        boolean isDecreasing = false;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                isIncreasing = true;
            } else if (nums[i] > nums[i + 1]) {
                isDecreasing = true;
            }
        }

        // If both increasing and decreasing trends are present, it's not monotonic [00:04:55]
        if (isIncreasing && isDecreasing) {
            return false;
        }

        return true;
    }
}