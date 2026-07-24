class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] hasPair = new boolean[2048];
        boolean[] hasNum = new boolean[2048];
        int n = nums.length;

        // Step 1: Collect unique values and compute all pair XORs
        for (int i = 0; i < n; i++) {
            hasNum[nums[i]] = true;
            for (int j = i; j < n; j++) {
                hasPair[nums[i] ^ nums[j]] = true;
            }
        }

        // Step 2: Combine pair XORs with unique nums to get triplet XORs
        boolean[] hasTriplet = new boolean[2048];
        for (int p = 0; p < 2048; p++) {
            if (!hasPair[p]) continue;
            for (int u = 0; u < 2048; u++) {
                if (hasNum[u]) {
                    hasTriplet[p ^ u] = true;
                }
            }
        }

        // Step 3: Count unique triplet XOR values
        int count = 0;
        for (boolean present : hasTriplet) {
            if (present) {
                count++;
            }
        }

        return count;
    }
}