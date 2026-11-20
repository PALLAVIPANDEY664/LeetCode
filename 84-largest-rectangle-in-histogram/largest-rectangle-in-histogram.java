class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> s = new Stack<>();

        // 1. Find Right Smaller Nearest index for each bar [00:25:06]
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            // Default boundary is n if no smaller bar exists on the right [00:29:23]
            right[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }

        // Clear the stack to reuse it [00:26:12]
        s.clear();

        // 2. Find Left Smaller Nearest index for each bar [00:25:55]
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            // Default boundary is -1 if no smaller bar exists on the left [00:29:02]
            left[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        // 3. Calculate maximum rectangle area [00:26:36]
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int currArea = heights[i] * width;
            ans = Math.max(ans, currArea);
        }

        return ans;
    }
}