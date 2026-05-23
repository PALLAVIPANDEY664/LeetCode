class Solution {
    public String convertToTitle(int columnNumber) {
        
        StringBuilder result = new StringBuilder();
        
        while(columnNumber > 0) {
            
            columnNumber--;  
            
            int remainder = columnNumber % 26;
            
            char ch = (char)(remainder + 'A');
            
            result.append(ch);
            
            columnNumber = columnNumber / 26;
        }
        
        return result.reverse().toString();
    }
}