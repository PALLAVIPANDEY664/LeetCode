class Solution {
    public double myPow(double x, int n) {
        long power = n;
        boolean negative = power < 0;
        if (negative) power = -power;

        double result = helper(x, power);
        return negative ? 1 / result : result;
    }

    private double helper(double x, long n) {
        if (n == 0) return 1.0;
        double half = helper(x, n / 2);
        if (n % 2 == 0) return half * half;
        return half * half * x;
    }
}