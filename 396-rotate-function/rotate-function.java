class Solution {
    public int maxRotateFunction(int[] nums) {
        long n = nums.length;
        long sum = 0;
        long f0 = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            f0 += (long) i * nums[i];
        }

        long maxF = f0;
        long currentF = f0;

        for (int i = 1; i < nums.length; i++) {
            currentF = currentF + sum - n * nums[nums.length - i];
            maxF = Math.max(maxF, currentF);
        }

        return (int) maxF;
    }
}