class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[] rowSum = new long[m];
        long[] colSum = new long[n];
        long totalSum = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                totalSum += grid[i][j];
                rowSum[i] += grid[i][j];
                colSum[j] += grid[i][j];
            }
        }

        if(totalSum % 2 != 0){
            return false;
        }
        long upperSum = 0;
        for(int i = 0; i<m-1; i++){
            upperSum += rowSum[i];
            long lowerSum = totalSum - upperSum;
            if(lowerSum == upperSum){
                return true;
            }
        }

        long leftSum = 0;
        for(int j = 0; j<n-1; j++){
            leftSum += colSum[j];
            long rightSum = totalSum - leftSum;
            if(rightSum == leftSum){
                return true;
            }
        }
        return false;

    }
}