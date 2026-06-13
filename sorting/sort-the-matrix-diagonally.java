class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                int diagonalKey = i-j;
                map.putIfAbsent(diagonalKey, new PriorityQueue<>());
                map.get(diagonalKey).add(mat[i][j]);
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int diagonalKey = i-j;
                mat[i][j] = map.get(diagonalKey).poll();
            }
        }
        return mat;
    }
}