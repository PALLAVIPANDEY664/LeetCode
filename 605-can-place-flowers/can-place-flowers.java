public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = flowerbed.length;
        
        // Edge case: If 0 flowers need to be placed, it's always true.
        if (n == 0) {
            return true;
        }
        
        for (int i = 0; i < l; i++) {
            // Step 1: Current plot must be empty
            if (flowerbed[i] == 0) {
                
                // Step 2: Check if Left side is empty/valid
                boolean left_khali  = (i == 0) || (flowerbed[i - 1] == 0);
                
                // Step 3: Check if Right side is empty/valid
                boolean right_khali = (i == l - 1) || (flowerbed[i + 1] == 0);
                
                // If both sides are empty, we can plant a flower here
                if (left_khali && right_khali) {
                    flowerbed[i] = 1; // Plant the flower
                    n--;              // Reduce the count of flowers left to plant
                    
                    if (n == 0) {
                        return true; // All required flowers planted successfully
                    }
                }
            }
        }
        
        return false; // Loop finished but couldn't plant all n flowers
    }
}