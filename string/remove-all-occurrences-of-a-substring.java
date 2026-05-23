class Solution {
    public String removeOccurrences(String s, String part) {
        
        while (s.contains(part)) {
            int index = s.indexOf(part);   // leftmost occurrence
            
            // Remove that substring
            s = s.substring(0, index) + 
                s.substring(index + part.length());
        }
        
        return s;
    }
}
