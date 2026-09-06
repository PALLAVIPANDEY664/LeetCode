import java.util.Arrays;

class Solution {
    // memo[i][x]: -1 = unvisited, 1 = true, 0 = false
    int[][] t;

    public boolean solve(int[] nums, int i, int x) {
        if (x == 0) {
            return true;
        }

        if (i >= nums.length) {
            return false;
        }

        if (t[i][x] != -1) {
            return t[i][x] == 1;
        }

        boolean take = false;
        if (nums[i] <= x) {
            take = solve(nums, i + 1, x - nums[i]);
        }

        boolean not_take = solve(nums, i + 1, x);

        t[i][x] = (take || not_take) ? 1 : 0;
        return take || not_take;
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int S = 0;
        for (int num : nums) {
            S += num;
        }

        if (S % 2 != 0) {
            return false;
        }

        int x = S / 2;

        // Initialize memoization table (t) of size n x (x + 1) with -1
        t = new int[n][x + 1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        return solve(nums, 0, x);
    }
}