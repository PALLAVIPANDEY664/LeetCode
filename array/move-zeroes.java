class Solution {
    public void moveZeroes(int[] nums) {
        int lastnz = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[lastnz];
                nums[lastnz] = temp;
                lastnz++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}