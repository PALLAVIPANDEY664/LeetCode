class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        int i = 0;
        
        // 1. Add all intervals that end before the new interval starts
        while(i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]); // Fixed: changed intervals[1] to intervals[i]
            i++;
        }
        
        // 2. Merge all overlapping intervals into newInterval
        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        
        // 3. Add all remaining intervals
        while(i < n) {
            result.add(intervals[i]);
            i++;
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
