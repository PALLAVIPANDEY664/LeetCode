class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if(n == 0) return 0;
        Arrays.sort(points, (a,b)-> Integer.compare(a[0], b[0]));
        int [] previous = points[0];
        int count=1;
        for(int i=0; i<n; i++){
            int currSP = points[i][0];
            int currEP = points[i][1];
            int prevSP = previous[0];
            int prevEP = previous[1];

            if(currSP > prevEP){
                count++;
                previous = points[i];
            }

            else{
                previous[0] = Math.max(prevSP, currSP);
                previous[1] = Math.min(prevEP, currEP);

            }
        }
        return count;
    }
}