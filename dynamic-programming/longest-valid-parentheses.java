import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        // Deque is preferred over Stack in Java
        Deque<Integer> stack = new ArrayDeque<>();
        
        // Push -1 onto the stack as an initial base index
        stack.push(-1);
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // Store the index of open bracket
                stack.push(i);
            } else {
                // Pop the last unmatched '(' or base index
                stack.pop();
                
                if (stack.isEmpty()) {
                    // Current ')' has no match, set it as the new base index
                    stack.push(i);
                } else {
                    // Calculate current valid substring length
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        
        return maxLen;
    }
}