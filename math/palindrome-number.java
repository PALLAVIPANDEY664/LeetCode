class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers or multiples of 10 (except 0) are not palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // For even and odd length numbers
        return x == reversedHalf || x == reversedHalf / 10;
    }
}

