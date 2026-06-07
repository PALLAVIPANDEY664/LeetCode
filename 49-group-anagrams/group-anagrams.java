import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Edge case: if the input array is null or empty, return an empty list
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        
        // Map to store the sorted string as the key and the list of anagrams as the value
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Convert string to character array and sort it
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = String.valueOf(charArray);
            
            // If the key doesn't exist, initialize a new list
            if (!map.containsKey(sortedKey)) {
                map.put(sortedKey, new ArrayList<>());
            }
            
            // Add the original string to the corresponding list
            map.get(sortedKey).add(s);
        }
        
        // Return all the grouped lists
        return new ArrayList<>(map.values());
    }
}