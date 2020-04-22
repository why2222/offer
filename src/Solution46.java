public class Solution46 {
    // 动态规划
    public int numberOfDecodings(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;

        return 0;
    }
}
