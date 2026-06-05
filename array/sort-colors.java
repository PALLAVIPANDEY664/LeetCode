class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        // Loop until mid crosses high
        while (mid <= high) {
            if (nums[mid] == 0) {
                // Case 1: Element is 0 -> Swap with low, move both pointers forward
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Case 2: Element is 1 -> It's already in the right zone, just move mid forward
                mid++;
            } else {
                // Case 3: Element is 2 -> Swap with high, move high backward
                // Don't advance mid yet because the swapped element from 'high' needs to be checked
                swap(nums, mid, high);
                high--;
            }
        }
    }

    // Helper method to swap two elements in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}