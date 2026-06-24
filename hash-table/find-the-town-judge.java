class Solution {
    public int findJudge(int n, int[][] trust) {
        // Initialize degree arrays of size n + 1 since people are 1-indexed [00:07:52]
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];
        
        // Populate the degrees based on the relationships [00:08:19]
        for (int[] edge : trust) {
            int u = edge[0]; // Person who trusts
            int v = edge[1]; // Person who is trusted
            
            outDegree[u]++;
            inDegree[v]++;
        }
        
        // Find the person who satisfies both conditions [00:08:44]
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i;
            }
        }
        
        return -1;
    }
}