class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length;
        int [] result = new int [n];
        for(int ball = 0; ball<n; ball++){
            int row = 0;
            int col = ball;
            boolean atka = false;
            while(row<m && col<n){
                if(grid[row][col] == 1){
                    if(col == n-1 || grid[row][col+1] == -1){
                        atka = true;
                        break;
                    }
                    col++;
                }
                else if(grid[row][col] == -1){
                    if(col == 0 || grid[row][col-1] == 1){
                        atka = true;
                        break;
                    }
                    col--;
                }
                row++;
            }
            if(atka){
                result[ball] = -1;
            }
            else{
                result[ball] = col;
            }
        }
        return result;
    }
}