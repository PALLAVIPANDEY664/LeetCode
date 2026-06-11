class Solution {
    private int[] getLeftMaxArray(int[] height, int n){
        int[] leftmax = new int[n];
        leftmax[0] = height[0];
        for(int i=1; i<n; i++){
            leftmax[i] = Math.max(leftmax[i-1], height[i]);
        }
        return leftmax;
    }

    private int[] getRightMaxArray(int[] height, int n){
        int[] rightmax = new int[n];
        rightmax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            rightmax[i] = Math.max(rightmax[i+1], height[i]);
        }
        return rightmax;
    }
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int n = height.length;
        int[] leftmax = getLeftMaxArray(height,n);
        int[] rightmax = getRightMaxArray(height,n);
        int totalWater = 0;
        for(int i=0; i<n; i++){
            int waterLevel = Math.min(leftmax[i], rightmax[i]);
            totalWater += waterLevel - height[i];
        }
        return totalWater;
    }
}