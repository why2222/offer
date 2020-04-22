import java.util.ArrayList;
import java.util.Arrays;

public class Solution38 {
    private static ArrayList<String> result = new ArrayList<>();
    public static ArrayList<String> Permutation(String str) {
        if (str.length() <= 0) {
            return result;  // 这里返回NULL，牛客检测会报错！！！
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuilder());
        return result;
    }

    public static void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
        if (s.length() == chars.length) {
            result.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i]) {
                continue;
            }
            // 保证不重复
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) {
                continue;
            }
            hasUsed[i] = true;
            s.append(chars[i]);
            backtracking(chars, hasUsed, s);
            s.deleteCharAt(s.length() - 1);
            hasUsed[i] = false;
        }
    }

}
