class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int minVal = Integer.MAX_VALUE;
        int [] suffixMin = new int [n];
        for(int i = n-1; i>=0; i--){
            minVal = Math.min(minVal, nums[i]);
            suffixMin[i] = minVal;
        }
        int maxVal = Integer.MIN_VALUE;
        for(int i =0; i<n; i++){
            maxVal = Math.max(maxVal , nums[i]);

            if(maxVal - suffixMin[i] <= k){
                return i;
            }
        }
        return -1;
    }
}