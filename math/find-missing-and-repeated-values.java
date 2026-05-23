import java.util.*;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        int size = n * n;

        HashMap<Integer, Integer> map = new HashMap<>();

        int actualSum = 0;
        int repeating = -1;

        // Traverse grid
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

                int num = grid[i][j];
                actualSum += num;

                map.put(num, map.getOrDefault(num,0) + 1);

                if(map.get(num) == 2){
                    repeating = num;
                }
            }
        }

        // Expected sum of 1 to n^2
        int expectedSum = (size * (size + 1)) / 2;

        // Missing number
        int missing = expectedSum - (actualSum - repeating);

        return new int[]{repeating, missing};
    }
}