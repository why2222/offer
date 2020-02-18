public class Solution19 {
    public static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, 0, pattern, 0);
    }

    /**
     * 情况分析：
     * 如果模式匹配字符的下一个字符是‘*’：
     *  a.如果pattern当前字符和str的当前字符匹配，有以下三种可能情况：
     *      1.pattern当前字符能匹配str中的0个字符：match(str,pattern+2)
     *      2.pattern当前字符能匹配str中的1个字符：match(str+1,pattern+2)
     *      3.pattern当前字符能匹配str中的多个字符：match(str+1,pattern)
     *  b.如果pattern当前字符和str的当前字符不匹配
     *      pattern当前字符能匹配str中的0个字符：(str,pattern+2)
     * 如果模式匹配字符的下一个字符不是‘*’，进行逐字符匹配。
     * 对于‘.’的情况比较简单，‘.’和一个字符匹配match(str+1,pattern+1)
     * 另外需要注意的是：空字符串“”和“.*”是匹配的。(测试时，""如何表示，使用'\0'不能通过) ???
     * @param str
     * @param s
     * @param pattern
     * @param p
     * @return
     */
    public static boolean matchCore(char[] str, int s, char[] pattern, int p) {
        if (str.length <= s && pattern.length <= p) {
            return true;    // 都已经匹配完
        }
        if (str.length > s && pattern.length <= p) {
            return false;   // pattern完了字符串还没有匹配完
        }
        // 当pattern当先位置的下一个位置是‘*’时
        if (p + 1 < pattern.length && pattern[p + 1] == '*') {
            // 字符串已经匹配完了
            if (s > str.length) {
                return matchCore(str, s, pattern, p + 2);
            } else if (pattern[p] == '.' && str[s] == '\0') {
                    return true;
            } else {
                if (pattern[p] == str[s] || pattern[p] == '.') {
                    return matchCore(str, s, pattern, p + 2)
                            || matchCore(str, s + 1, pattern, p + 2)
                            || matchCore(str, s + 1, pattern, p);
                } else {
                    return matchCore(str, s, pattern, p + 2);
                }
            }
        } else {
            if (s >= str.length) {
                return false;
            } else {
                if (str[s] == pattern[p] || pattern[p] == '.') {
                    return matchCore(str, s + 1, pattern, p + 1);
                }
            }
        }
        return false;
    }

    public static boolean match2(char[] str, char[] pattern) {
        int s = str.length;
        int p = pattern.length;
        boolean[][] dp = new boolean[s + 1][p + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p; i++) {
            if (pattern[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= s; i++) {
            for (int j = 1; j <= p; j++) {
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        dp[i][j] |= dp[i][j - 1];
                        dp[i][j] |= dp[i - 1][j];
                        dp[i][j] |= dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[s][p];
    }

    public static boolean match3(char[] str, char[] pattern){
        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++)
            if (pattern[i - 1] == '*')
                dp[0][i] = dp[0][i - 2];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern[j - 1] == '*')
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        dp[i][j] |= dp[i][j - 1]; // a* counts as single a
                        dp[i][j] |= dp[i - 1][j]; // a* counts as multiple a
                        dp[i][j] |= dp[i][j - 2]; // a* counts as empty
                    } else
                        dp[i][j] = dp[i][j - 2]; // a* only countsas empty
        return dp[m][n];
    }
}
