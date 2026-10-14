import java.util.Arrays;

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] ans = new int[m];
        
        for (int i = 0; i < m; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];
            
            // Pair to store the trimmed substring and its original index
            Pair[] trimmed = new Pair[n];
            for (int j = 0; j < n; j++) {
                String s = nums[j];
                String sub = s.substring(s.length() - trim);
                trimmed[j] = new Pair(sub, j);
            }
            
            // Sort by trimmed value, and by original index if values are equal
            Arrays.sort(trimmed, (a, b) -> {
                int cmp = a.val.compareTo(b.val);
                if (cmp != 0) {
                    return cmp;
                }
                return Integer.compare(a.index, b.index);
            });
            
            ans[i] = trimmed[k - 1].index;
        }
        
        return ans;
    }
    
    private static class Pair {
        String val;
        int index;
        
        Pair(String val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}