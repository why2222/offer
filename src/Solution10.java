package src;

public class Solution10 {
    // 使用递归，跳进陷阱，复杂度高
    public int Fibonacci(int n) {
        int result;
        if (n == 0) {
            result = 0;
        } else if (n == 1) {
            result = 1;
        } else {
            result = Fibonacci(n - 1) + Fibonacci(n - 2);
        }
        return result;
    }

    public int Fibonacci2(int n) {
        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }
        int zero = 0;
        int one = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = zero + one;
            zero = one;
            one = res;
        }

        return res;
    }
}
