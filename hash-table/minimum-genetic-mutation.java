import java.util.*;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        
        // If the target gene is not present in the bank, transformation is impossible
        if (!bankSet.contains(endGene)) {
            return -1;
        }
        
        char[] genes = new char[]{'A', 'C', 'G', 'T'};
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(startGene);
        visited.add(startGene);
        
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                
                // Found the target gene
                if (curr.equals(endGene)) {
                    return level;
                }
                
                char[] currArray = curr.toCharArray();
                
                // Try mutating every character to 'A', 'C', 'G', 'T'
                for (int j = 0; j < currArray.length; j++) {
                    char originalChar = currArray[j];
                    
                    for (char ch : genes) {
                        if (ch == originalChar) continue;
                        
                        currArray[j] = ch;
                        String mutated = new String(currArray);
                        
                        // Check if the mutation is valid and unvisited
                        if (bankSet.contains(mutated) && !visited.contains(mutated)) {
                            visited.add(mutated);
                            queue.offer(mutated);
                        }
                    }
                    // Backtrack the character to restore original string for the next index
                    currArray[j] = originalChar;
                }
            }
            level++;
        }
        
        return -1;
    }
}