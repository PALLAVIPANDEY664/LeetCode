import java.util.Arrays;

class Solution {
    public int[] findOriginalArray(int[] changed) {
        // Step 1: If the length is odd, it cannot be a doubled array
        if (changed.length % 2 != 0) {
            return new int[0];
        }
        
        // Find the maximum value to size our frequency array dynamically
        int maxVal = 0;
        for (int num : changed) {
            maxVal = Math.max(maxVal, num);
        }
        
        // Step 2: Create a frequency array to count occurrences
        int[] freq = new int[maxVal + 1];
        for (int num : changed) {
            freq[num]++;
        }
        
        // Step 3: Sort the changed array to process from smallest to largest
        Arrays.sort(changed);
        
        int[] original = new int[changed.length / 2];
        int index = 0;
        
        // Step 4: Match elements greedily
        for (int num : changed) {
            // If this number has already been used as a "double" for a smaller number
            if (freq[num] == 0) {
                continue;
            }
            
            // Check if its double exceeds the maximum value or doesn't exist
            int doubleNum = num * 2;
            if (doubleNum > maxVal || freq[doubleNum] == 0) {
                return new int[0]; // Invalid doubled array
            }
            
            // Special case for zero: it needs at least 2 occurrences to pair with itself (0 * 2 = 0)
            if (num == 0 && freq[0] < 2) {
                return new int[0];
            }
            
            // Consume both the element and its double
            original[index++] = num;
            freq[num]--;
            freq[doubleNum]--;
        }
        
        return original;
    }
}