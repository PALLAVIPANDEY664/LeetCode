class Solution {
    public int countCommas(int n) {
        //return n < 1000 ? 0 : n-999;
        return Math.max(n-999, 0);
    }
}