import java.util.*;

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        if (m == 1 && n == 1) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        
        boolean[][][] visited = new boolean[m][n][k + 1];

        queue.offer(new int[]{0, 0, k});
        visited[0][0][k] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];
                int currK = current[2];

                if (r == m - 1 && c == n - 1) {
                    return steps;
                }

                for (int[] dir : directions) {
                    int nextR = r + dir[0];
                    int nextC = c + dir[1];

                    if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n) {
                        
                        if (grid[nextR][nextC] == 0 && !visited[nextR][nextC][currK]) {
                            visited[nextR][nextC][currK] = true;
                            queue.offer(new int[]{nextR, nextC, currK});
                        } 
                        else if (grid[nextR][nextC] == 1 && currK > 0 && !visited[nextR][nextC][currK - 1]) {
                            visited[nextR][nextC][currK - 1] = true;
                            queue.offer(new int[]{nextR, nextC, currK - 1});
                        }
                    }
                }
            }
            
            steps++;
        }

        
        return -1;
    }
}