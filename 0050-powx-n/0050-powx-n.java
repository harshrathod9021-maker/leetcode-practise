class Solution {
    public double myPow(double x, int n) {
        long N = n;

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return power(x, N);
    }

    private double power(double x, long n) {
        // Base case
        if (n == 0) {
            return 1.0;
        }

        // Recursive call
        double half = power(x, n / 2);

        // If n is even
        if (n % 2 == 0) {
            return half * half;
        }

        // If n is odd
        return half * half * x;
    }
}