class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[] partner = new int[n];
        for (int[] p : pairs) {
            partner[p[0]] = p[1];
            partner[p[1]] = p[0];
        }

        // rank[i][j] stores the preference rank of person j for person i
        // Smaller rank means higher preference
        int[][] rank = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                int preferredFriend = preferences[i][j];
                rank[i][preferredFriend] = j;
            }
        }

        int unhappyCount = 0;

        for (int[] p : pairs) {
            int x = p[0], y = p[1];
            
            // Check if x is unhappy with current partner y
            if (isUnhappy(x, y, partner, rank, preferences)) {
                unhappyCount++;
            }
            // Check if y is unhappy with current partner x
            if (isUnhappy(y, x, partner, rank, preferences)) {
                unhappyCount++;
            }
        }

        return unhappyCount;
    }

    private boolean isUnhappy(int x, int y, int[] partner, int[][] rank, int[][] preferences) {
        // Iterate through all friends that x prefers more than y
        for (int i = 0; i < preferences[x].length; i++) {
            int u = preferences[x][i];
            if (u == y) {
                break; // Reached current partner y, stop checking less preferred friends
            }
            
            int v = partner[u]; // u is paired with v
            
            // If u prefers x over v, then x is unhappy
            if (rank[u][x] < rank[u][v]) {
                return true;
            }
        }
        return false;
    }
}