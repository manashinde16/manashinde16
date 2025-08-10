class Solution {
    private static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long powEven = modPow(5, evenCount, MOD);
        long powOdd = modPow(4, oddCount, MOD);

        return (int) ((powEven * powOdd) % MOD);
    }

    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
