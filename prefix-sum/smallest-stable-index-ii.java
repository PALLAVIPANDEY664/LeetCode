class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        for(int i =0; i<n; i++){
            int maxel = Integer.MIN_VALUE;
            int minel = Integer.MAX_VALUE;
            for(int j = 0; j<= i; j++){
                maxel = Math.max(maxel, nums[j]);
            }
            for(int j =i; j<n ; j++){
                minel = Math.min(minel, nums[j]);
            }
            if(maxel - minel <= k){
                return i;
            }
        }
        return -1;
    }
}