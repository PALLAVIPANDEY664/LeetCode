import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int findRotateSteps(String ring, String key) {
        int rLen = ring.length();
        int kLen = key.length();
        
        // Group the indices of the ring by character ('a' to 'z')
        List<Integer>[] charToIndices = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            charToIndices[i] = new ArrayList<>();
        }
        for (int i = 0; i < rLen; i++) {
            charToIndices[ring.charAt(i) - 'a'].add(i);
        }
        
        // Create a memoization table initialized with -1
        int[][] memo = new int[rLen][kLen];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        // Start the DFS from ring index 0 and key index 0
        return dfs(0, 0, ring, key, charToIndices, memo);
    }
    
    private int dfs(int rIdx, int kIdx, String ring, String key, 
                    List<Integer>[] charToIndices, int[][] memo) {
        // Base case: All characters in the key have been spelled out
        if (kIdx == key.length()) {
            return 0;
        }
        
        // Return cached result if already calculated
        if (memo[rIdx][kIdx] != -1) {
            return memo[rIdx][kIdx];
        }
        
        int minSteps = Integer.MAX_VALUE;
        char targetChar = key.charAt(kIdx);
        List<Integer> nextIndices = charToIndices[targetChar - 'a'];
        
        // Try rotating to every possible position of the target character
        for (int nextIdx : nextIndices) {
            // Calculate clockwise and counterclockwise distances
            int dist = Math.abs(rIdx - nextIdx);
            int rotationSteps = Math.min(dist, ring.length() - dist);
            
            // Recurse for the next character (+1 step for pressing the center button)
            int totalSteps = rotationSteps + 1 + dfs(nextIdx, kIdx + 1, ring, key, charToIndices, memo);
            minSteps = Math.min(minSteps, totalSteps);
        }
        
        // Cache and return the result
        memo[rIdx][kIdx] = minSteps;
        return minSteps;
    }
}
