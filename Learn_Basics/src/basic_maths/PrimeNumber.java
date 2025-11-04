package basic_maths;

public class PrimeNumber {
    public boolean isPrime(int n) {
        int cnt = 0;

        for(int i = 1; (double)i <= Math.sqrt((double)n); ++i) {
            if (n % i == 0) {
                ++cnt;
                if (n / i != i) {
                    ++cnt;
                }
            }
        }

        return cnt == 2;
    }
}
