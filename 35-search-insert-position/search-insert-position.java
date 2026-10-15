class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;  // avoid overflow

            if (nums[mid] == target) {
                return mid;  // found the target
            } else if (nums[mid] < target) {
                left = mid + 1;  // search right half
            } else {
                right = mid - 1; // search left half
            }
        }
        
        // if not found, left is the position where target should be inserted
        return left;
    }
}