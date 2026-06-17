class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;
        for(int rowOff = -n+1; rowOff<n; rowOff++){
            for(int colOff = -n+1; colOff<n; colOff++){
                int currentOverlap = countOverlap(img1, img2, rowOff, colOff,n);

                maxOverlap = Math.max(maxOverlap, currentOverlap);
            }
        }
        return maxOverlap;
    }
    private int countOverlap(int[][]img1, int[][]img2, int rowOff, int colOff, int n ){
        int count= 0;
        for(int i = 0; i<n; i++){
            for(int j= 0; j<n; j++){
                int img2_row = i+rowOff;
                int img2_col = j+colOff;

                if(img2_row>=0 && img2_row<n && img2_col>=0 && img2_col<n){
                    if(img1[i][j] == 1 && img2[img2_row][img2_col] == 1){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}