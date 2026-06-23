import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        int i = 0;
        
        // Step 1: Add all intervals that come strictly BEFORE the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        
        // Step 2: Merge all overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval); // Add the final merged interval
        
        // Step 3: Add all remaining intervals that come strictly AFTER the new interval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        
        // Convert the dynamic list back to a 2D array
        return result.toArray(new int[result.size()][]);
    }
}
