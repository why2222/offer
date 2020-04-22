public class Solution49 {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 6) {
            return index;
        }
        int num2 = 0;
        int num3 = 0;
        int num5 = 0;
        int[] dp = new int[index];
        dp[0] = 1;
        for (int i = 1; i < index; i++) {
            int next2 = dp[num2] * 2;
            int next3 = dp[num3] * 3;
            int next5 = dp[num5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2) {
                num2++;
            }
            if (dp[i] == next3) {
                num3++;
            }
            if (dp[i] == next5) {
                num5++;
            }
        }

        return dp[index - 1];
    }
}
