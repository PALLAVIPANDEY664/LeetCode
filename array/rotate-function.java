class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int f0 = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f0 += i * nums[i];
        }

        int maxF = f0;
        int currentF = f0;

        // Calculate F(k) using the transition state relation:
        // F(k) = F(k - 1) + sum - n * nums[n - k]
        for (int i = 1; i < n; i++) {
            currentF = currentF + sum - n * nums[n - i];
            maxF = Math.max(maxF, currentF);
        }

        return maxF;
    }
}