class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Step 1: Place each number in its correct position if possible
        for (int i = 0; i < n; i++) {
            // Keep swapping until the current element is in its correct place
            // nums[i] should be at index nums[i] - 1
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        
        // Step 2: Find the first mismatch where index + 1 != nums[index]
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        // Step 3: If all positions match, the missing number is n + 1
        return n + 1;
    }
}