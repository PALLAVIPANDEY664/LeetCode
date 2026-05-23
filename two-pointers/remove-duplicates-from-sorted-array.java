class Solution {
        public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // i is the index of the last unique element
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j]; // place the next unique element
            }
        }
        return i + 1; // length of unique elements
    }

}