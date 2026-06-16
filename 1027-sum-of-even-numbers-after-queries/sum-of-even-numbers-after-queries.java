class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sumEven = 0;
        
        // Step 1: Calculate the initial sum of all even numbers
        for (int num : nums) {
            if (num % 2 == 0) {
                sumEven += num;
            }
        }
        
        int qLen = queries.length;
        int[] result = new int[qLen];
        
        // Step 2: Process each query one by one
        for (int i = 0; i < qLen; i++) {
            int val = queries[i][0];
            int idx = queries[i][1];
            
            // If the original element was even, remove it from the running sum
            if (nums[idx] % 2 == 0) {
                sumEven -= nums[idx];
            }
            
            // Apply the modification
            nums[idx] += val;
            
            // If the updated element is even, add it back to the running sum
            if (nums[idx] % 2 == 0) {
                sumEven += nums[idx];
            }
            
            // Store the result after the current query execution
            result[i] = sumEven;
        }
        
        return result;
    }
}