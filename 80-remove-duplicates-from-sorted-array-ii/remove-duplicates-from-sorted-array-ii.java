class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j =2;
        if(n <= 2){
            return n;
        }
        for(int i = 2; i<n; i++){
            if(nums[i] != nums[j-2]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}