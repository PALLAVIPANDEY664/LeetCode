class Solution {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push it
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // If it's a closing bracket
            else {
                if (stack.isEmpty()) return false; // no opening bracket

                char top = stack.peek();

                if ((c == ')' && top == '(') ||
                    (c == '}' && top == '{') ||
                    (c == ']' && top == '[')) {
                    stack.pop(); // valid match
                } else {
                    return false; // mismatch
                }
            }
        }
        return stack.isEmpty(); // must be empty if valid
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));      // true
        System.out.println(isValid("()[]{}"));  // true
        System.out.println(isValid("(]"));      // false
        System.out.println(isValid("([])"));    // true
        System.out.println(isValid("([)]"));    // false
    }
}
