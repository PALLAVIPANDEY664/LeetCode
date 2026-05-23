import java.util.*;

class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph
        for (int[] path : paths) {
            int u = path[0] - 1;
            int v = path[1] - 1;

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] answer = new int[n];

        // Assign flowers
        for (int i = 0; i < n; i++) {

            boolean[] used = new boolean[5]; // flowers 1 to 4

            for (int neighbor : graph[i]) {
                used[answer[neighbor]] = true;
            }

            for (int flower = 1; flower <= 4; flower++) {
                if (!used[flower]) {
                    answer[i] = flower;
                    break;
                }
            }
        }

        return answer;
    }
}