import java.util.*;

class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, result, new ArrayList<>(), used);

        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result,
                           List<Integer> current, boolean[] used) {

        // Base Case: If permutation is complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) continue;   // Skip if already used

            // Choose
            used[i] = true;
            current.add(nums[i]);

            // Explore
            backtrack(nums, result, current, used);

            // Unchoose (Backtrack)
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}