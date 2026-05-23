class Solution {
     // Function to get next number (sum of squares of digits)
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    // Function to check if number is happy
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        // Using Floyd's cycle detection
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);             // move 1 step
            fast = getNext(getNext(fast));    // move 2 steps
        }

        return fast == 1;
    }

}